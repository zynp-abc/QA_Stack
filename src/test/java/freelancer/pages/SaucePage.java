package freelancer.pages;

import freelancer.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucePage {


    public SaucePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#user-name")
    public WebElement userName;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(css = "#login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//div[.='Sauce Labs Backpack']")
    public WebElement canta;

    @FindBy(className = "shopping_cart_link")
    public WebElement sepet;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement remove;

    @FindBy(css = "#checkout")
    public WebElement checkout;

    @FindBy(css = "#first-name")
    public WebElement firstName;

    @FindBy(css = "#last-name")
    public WebElement lastName;

    @FindBy(css = "#postal-code")
    public WebElement zipKod;

    @FindBy(css = "#continue")
    public WebElement continueText;

    @FindBy(css = "#finish")
    public WebElement finish;

    @FindBy(xpath ="//button[.='Back Home']")
    public WebElement anaSayfayaDön;

    @FindBy(xpath = "//span[.='Products']")
    public WebElement urunlerBaslığı;
















}
