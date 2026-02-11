package freelancer.pages;

import freelancer.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationExercisePage {


    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.=' Signup / Login']")
    public WebElement login;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailAdres;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signup;

    @FindBy(css = "#id_gender2")
    public WebElement gender;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(css = "#days")
    public WebElement day;

    @FindBy(css = "#months")
    public WebElement month;

    @FindBy(css = "#years")
    public WebElement year;


}
