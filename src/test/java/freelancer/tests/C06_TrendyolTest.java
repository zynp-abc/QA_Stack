package freelancer.tests;

import freelancer.pages.TrendyolPage;
import freelancer.utilities.ConfigReader;
import freelancer.utilities.Driver;
import freelancer.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class C06_TrendyolTest {

   /* @Test
    public void trendyolTest() {

        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));

        TrendyolPage trendyolPage = new TrendyolPage();
        ReusableMethods.clickWithJS(trendyolPage.loginButton);

        trendyolPage.emailBox.click();
        trendyolPage.emailBox.sendKeys(ConfigReader.getProperty("trendyolEmail"));
        trendyolPage.continuing.click();
        trendyolPage.password.sendKeys(ConfigReader.getProperty("trendyolPassword"));
        trendyolPage.checkBox.click();

        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.clickWithJS(trendyolPage.captcha);
        Driver.getDriver().switchTo().defaultContent();
 }*/ // Kayıt işlemini yapamadım çünkü CAPTCHA yi aşamadım.


    @Test
    public void trendyolTest() {

        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));

        TrendyolPage trendyolPage = new TrendyolPage();
        trendyolPage.genderWomenButton.click();
        trendyolPage.searchBox.sendKeys("Macbook", Keys.ENTER);


    }
}
