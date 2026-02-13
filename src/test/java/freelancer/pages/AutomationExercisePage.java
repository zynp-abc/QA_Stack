package freelancer.pages;

import freelancer.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationExercisePage {


    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.=' Signup / Login']")
    public WebElement signupLogin;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailAdres;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signup;

    @FindBy(css = "#id_gender2")
    public WebElement gender;

    @FindBy(css = "#password")
    public WebElement signupPassword;

    @FindBy(css = "#days")
    public WebElement day;

    @FindBy(css = "#months")
    public WebElement month;

    @FindBy(css = "#years")
    public WebElement year;

    @FindBy(css = "#first_name")
    public WebElement firstName;

    @FindBy(css = "#last_name")
    public WebElement lastName;

    @FindBy(css = "#company")
    public WebElement company;

    @FindBy(css = "#address1")
    public WebElement adres1;

    @FindBy(css = "#address2")
    public WebElement adres2;

    @FindBy(css = "#country")
    public WebElement country;

    @FindBy(css = "#state")
    public WebElement state;

    @FindBy(css = "#city")
    public WebElement city;

    @FindBy(css = "#zipcode")
    public WebElement zipcode;

    @FindBy(css = "#mobile_number")
    public WebElement mobileNumber;

    @FindBy(xpath = "//*[@data-qa='create-account']")
    public WebElement createAccount;

    @FindBy(xpath = "//h2[.='Account Created!']")
    public WebElement createdAccount;

    @FindBy(xpath = "//a[.='Continue']")
    public WebElement Continue;

    @FindBy(xpath = "//a[.=' Delete Account']")
    public WebElement deletedAccount;

    @FindBy(xpath = "//h2[.='Account Deleted!']")
    public WebElement deletedText;

    @FindBy(xpath = "//a[.='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emaiLogin;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordLogin;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[.=' Logout']")
    public WebElement logout;

    @FindBy(xpath = "//*[text()=' Products']")
    public WebElement products;

    @FindBy(xpath = "//*[text()='View Product']")
    public List<WebElement> viewProductsButton;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement addToCart;

    @FindBy(xpath = "//h4[text()='Added!']")
    public WebElement added;

    @FindBy(xpath = "//button[@data-dismiss='modal']")
    public WebElement continueShopping;






}
