package freelancer.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {


    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {

    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browser = ConfigReader.getProperty("browser").toLowerCase();

            switch (ConfigReader.getProperty("browser")) {
                case "chrome":

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications");
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                default:
                    driverPool.set(new ChromeDriver());
            }

            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        return driverPool.get();
    }

    public static void quitDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }


}
