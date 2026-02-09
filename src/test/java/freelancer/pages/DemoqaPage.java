package freelancer.pages;

import freelancer.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPage {

    public DemoqaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "#alertButton")
    public WebElement alertButton;


}
