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

    @FindBy(css = "#register-password-input")
    public WebElement password;

    @FindBy(xpath = "(//div[@class='p-checkbox-wrapper checkbox-small  '])[3]")
    public WebElement checkBox;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement captcha;

    @FindBy(xpath = "//div[contains(text(),'Kadın')]")
    public WebElement genderWomenButton;

    @FindBy(xpath = "//div[contains(text(),'Erkek')]")
    public WebElement genderManButton;

    @FindBy(xpath = "//input[@data-testid='suggestion']")
    public WebElement searchBox;
}
