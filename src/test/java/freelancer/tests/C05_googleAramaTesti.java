package freelancer.tests;

import freelancer.utilities.Driver;
import freelancer.utilities.ExtentReport;
import freelancer.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C05_googleAramaTesti {


    @DataProvider
    public static Object[][] aramaVerileri() {
        return new Object[][]{

                {"Selenium"},
                {"Java"},
                {"TestNG"}
        };
    }

    @Test(dataProvider = "aramaVerileri")
    public void googleSearchTest(String kelime) {
        ExtentReport.createExtentTest("Google Arama: " + kelime);

        Driver.getDriver().get("https://www.google.com");

        WebElement searchBox = Driver.getDriver().findElement(By.id("APjFqb"));
        searchBox.sendKeys(kelime + Keys.ENTER);

        ExtentReport.info(kelime + " araması yapıldı");
        ReusableMethods.waitFor(2);

        String actualTitle = Driver.getDriver().getTitle();

        if (actualTitle.contains(kelime)) {
            Assert.assertTrue(true);
            ExtentReport.pass("Başlık doğrulama başarılı. sayfa başlığı:  '" + kelime + "' kelimesini içeriyor");
        } else {
            ExtentReport.info("Başlık doğrulama başarısız. Aranan kelime: '" + kelime + "' ama sayfa başlığı farklı: " + actualTitle);
            Assert.fail("başlık aranan kelimeyi içermiyor. Mevcut başlık: " + actualTitle);
        }
        ExtentReport.flushReport();

    }


    @Test
    public void testName() {

        Driver.getDriver().get("https://duckduckgo.com");
    }
}
