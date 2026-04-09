package freelancer.tests;

import freelancer.pages.TrendyolPage;
import freelancer.utilities.ConfigReader;
import freelancer.utilities.Driver;
import freelancer.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class C06_TrendyolTest {

    @Test
    public void trendyolTest() {

        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));

        TrendyolPage trendyolPage = new TrendyolPage();
        ReusableMethods.clickWithJS(trendyolPage.loginButton);

        trendyolPage.emailBox.click();
        trendyolPage.emailBox.sendKeys(ConfigReader.getProperty("trendyolEmail"));
        trendyolPage.continuing.click();


    }
}
