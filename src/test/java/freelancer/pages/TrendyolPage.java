package freelancer.pages;

import freelancer.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrendyolPage {

    public TrendyolPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class='user-text navigation-text']")
    public WebElement loginButton;

    @FindBy(css = "#login-email")
    public WebElement emailBox;

    @FindBy(xpath = "//button[@data-testid='email-check-button']")
    public WebElement continuing;


}
