package freelancer.tests;

import freelancer.pages.HerokuPage;
import freelancer.utilities.Driver;
import freelancer.utilities.ExtentReport;
import freelancer.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C04_HerokuDDTTest {


    @DataProvider
    public static Object[][] loginVerileri() {
        return new Object[][]{

                {"tomsmith", "SuperSecretPassword!", "Success"},
                {"yanlısUser", "yanlısSifre", "Invalid"},
                {"gecersiz", "12345", "Invalid"},
                {"Zeze", "13579", "Invalid"}
        };
    }

    @Test(dataProvider = "loginVerileri")
    public void herokuLoginTest(String user, String pass, String message) {

        ExtentReport.createExtentTest("Heroku DDT Test");
        Driver.getDriver().get("https://the-internet.herokuapp.com/login");
        ExtentReport.info("Herokuapp sitesine gidildi");

        HerokuPage herokuPage = new HerokuPage();
        herokuPage.username.sendKeys(user);
        herokuPage.password.sendKeys(pass);
        ReusableMethods.clickWithJS(herokuPage.loginButton);
        ReusableMethods.waitForVisibility(herokuPage.alertMessage, 10);

        if (message.equals("Success")) {
            Assert.assertTrue(herokuPage.alertMessage.getText().contains("You logged into"));
            ExtentReport.pass("Başarılı giriş");
        } else {

            Assert.assertTrue(herokuPage.alertMessage.getText().contains("invalid"));
            ExtentReport.info("Hatalı giriş");
        }
        ExtentReport.flushReport();


    }


}
