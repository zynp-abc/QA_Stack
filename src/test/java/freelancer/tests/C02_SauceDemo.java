package freelancer.tests;


import com.github.javafaker.Faker;
import freelancer.pages.SaucePage;
import freelancer.utilities.ConfigReader;
import freelancer.utilities.Driver;
import freelancer.utilities.ExtentReport;
import freelancer.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_SauceDemo {

    @Test
    public void sauceDemo() {
        ExtentReport.createExtentTest("Sauce Testi");
        Driver.getDriver().get(ConfigReader.getProperty("sauceUrl"));
        ExtentReport.info("Sauce sayfasına gidildi");

        SaucePage saucePage = new SaucePage();

        saucePage.userName.sendKeys(ConfigReader.getProperty("sauceUserName"));
        saucePage.password.sendKeys(ConfigReader.getProperty("saucePassword"));
        saucePage.loginButton.click();
        saucePage.canta.click();
        saucePage.sepet.click();

        Assert.assertTrue(saucePage.checkout.isDisplayed());
        ExtentReport.info("Çanta sepete başarıyla eklendi");
        saucePage.checkout.click();

        Faker faker = new Faker();

        saucePage.firstName.sendKeys(faker.name().firstName());
        saucePage.lastName.sendKeys(faker.name().lastName());
        saucePage.zipKod.sendKeys(faker.address().zipCode());
        saucePage.continueText.click();
        saucePage.finish.click();

        String siparis = Driver.getDriver().findElement(By.xpath("//*[.='Thank you for your order!']")).getText();
        Assert.assertEquals(siparis, "Thank you for your order!");
        ExtentReport.pass("Sipariş başarıyla tamamlandı");
        ExtentReport.addScreenshot("Sauce sipariş son görünüm");
        ReusableMethods.clickWithJS(saucePage.anaSayfayaDön);
        ReusableMethods.waitForVisibility(saucePage.urunlerBaslığı, 10);
        Assert.assertTrue(saucePage.urunlerBaslığı.isDisplayed());
        ExtentReport.addScreenshot("Ana sayfa");
        ExtentReport.pass("Ana sayfaya dönüldü");
        ExtentReport.flushReport();


    }
}
