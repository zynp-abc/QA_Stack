package freelancer.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {


    public static String getScreenshot(String name) {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String dosyaYolu = System.getProperty("user.dir") + "/test-output/Rapor_" + name + "_" + date + ".png";

        try {
            Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dosyaYolu;
    }

    public static String getScreenshotForReport(String name) {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String fileName = name + "_" + date + ".png";
        String tamYol = System.getProperty("user.dir") + "/test-output/" + fileName;

        try {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            Files.write(Paths.get(tamYol), ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }


    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    // Tamam/OK butonuna basar
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    // İptal/Cancel butonuna basar
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    // Alert üzerindeki metni döndürür
    public static String alertGetText() {
        return Driver.getDriver().switchTo().alert().getText();
    }

    // Alert içindeki kutucuğa metin gönderir
    public static void alertSendKeys(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }

    public static void alertAccept(int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        try {
            // Alert görünene kadar bekle
            wait.until(ExpectedConditions.alertIsPresent());
            // Switch yap ve onayla
            Driver.getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Hata: Alert 10 saniye içinde çıkmadı veya müdahale edilemedi.");
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickWithWait(WebElement element, int timeout) {
        waitForClickability(element, timeout).click();
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


}
