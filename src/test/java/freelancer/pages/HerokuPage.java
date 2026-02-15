package freelancer.pages;

import freelancer.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuPage {

    public HerokuPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#username")
    public WebElement username;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement alertMessage;
}
