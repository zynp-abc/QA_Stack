package freelancer.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExtentReport {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentSparkReporter;
    protected static ExtentTest extentTest;

    public static void createExtentTest(String testName) {
        Locale.setDefault(Locale.US);
        extentReports = new ExtentReports();

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = System.getProperty("user.dir") + "/test-output/Rapor_" + date + ".html";
        extentSparkReporter = new ExtentSparkReporter(path);
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.config().setDocumentTitle("Automation Test Results");


        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Zeynep");
        extentTest = extentReports.createTest(testName, "Test Steps");
    }

    public static void addScreenshot(String name) {
        String resimYolu = ReusableMethods.getScreenshotForReport(name);

        try {
            extentTest.addScreenCaptureFromPath(resimYolu);
        } catch (Exception e) {
            System.out.println("Ekran görüntüsü rapora eklenemedi!");
        }
    }


    public static ExtentTest getTest() {
        return extentTest;
    }

    public static void info(String message) {
        extentTest.info(message);
    }

    public static void pass(String message) {
        extentTest.pass(message);
    }


    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentReport.flushReport();
    }
}






