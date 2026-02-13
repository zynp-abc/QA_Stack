package freelancer.tests;

import com.github.javafaker.Faker;
import freelancer.pages.AutomationExercisePage;
import freelancer.utilities.ConfigReader;
import freelancer.utilities.Driver;
import freelancer.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_AutomationExercise {

    @Test
    public void userCanRegisterAndDeleteAccount() {

        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));

        AutomationExercisePage automationExercisePage = new AutomationExercisePage();
        automationExercisePage.signupLogin.click();

        Faker faker = new Faker();

        automationExercisePage.name.sendKeys(faker.name().firstName());
        automationExercisePage.emailAdres.sendKeys(faker.internet().emailAddress());
        automationExercisePage.signup.click();
        automationExercisePage.gender.click();
        automationExercisePage.signupPassword.sendKeys("Password123");

        ReusableMethods.selectByValue(automationExercisePage.day, "2");
        ReusableMethods.selectByValue(automationExercisePage.month, "9");
        ReusableMethods.selectByValue(automationExercisePage.year, "2000");

        automationExercisePage.firstName.sendKeys(faker.name().firstName());
        automationExercisePage.lastName.sendKeys(faker.name().lastName());
        automationExercisePage.company.sendKeys(faker.company().name());
        automationExercisePage.adres1.sendKeys(faker.address().fullAddress());
        automationExercisePage.adres2.sendKeys(faker.address().streetName());
        automationExercisePage.country.sendKeys(faker.address().country());
        automationExercisePage.state.sendKeys(faker.address().state());
        automationExercisePage.city.sendKeys(faker.address().city());
        automationExercisePage.zipcode.sendKeys(faker.address().zipCode());
        automationExercisePage.mobileNumber.sendKeys(faker.phoneNumber().phoneNumber());
        automationExercisePage.createAccount.click();

        Assert.assertTrue(automationExercisePage.createdAccount.isDisplayed());
        automationExercisePage.Continue.click();
        automationExercisePage.deletedAccount.click();

        Assert.assertTrue(automationExercisePage.deletedText.isDisplayed());
        automationExercisePage.continueButton.click();
        Assert.assertTrue(automationExercisePage.signupLogin.isDisplayed());

        automationExercisePage.signupLogin.click();
        automationExercisePage.emaiLogin.sendKeys("azize.ece@gmail.com");
        automationExercisePage.passwordLogin.sendKeys("Azize123");
        automationExercisePage.loginButton.click();
        Driver.getDriver().navigate().refresh();
        automationExercisePage.products.click();
        automationExercisePage.viewProductsButton.get(10).click();
        automationExercisePage.addToCart.click();

        Assert.assertTrue(automationExercisePage.added.isDisplayed());
        automationExercisePage.continueShopping.click();
        automationExercisePage.products.click();
        automationExercisePage.logout.click();


    }
}
