package freelancer.tests;

import freelancer.pages.DemoqaPage;
import freelancer.utilities.ConfigReader;
import freelancer.utilities.Driver;
import freelancer.utilities.ExtentReport;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class C01_DemoqaTest {


    @Test
    public void demoqaTest() {

        ExtentReport.createExtentTest("demoqaTest");

        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));

        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.alertButton.click();

        Alert alert = Driver.getDriver().switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert metni: " + alertText);
        alert.accept();

        ExtentReport.flushReport();







    }


}
