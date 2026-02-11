package freelancer.tests;

import com.github.javafaker.Faker;
import freelancer.pages.AutomationExercisePage;
import freelancer.utilities.ConfigReader;
import freelancer.utilities.Driver;
import freelancer.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class C03_AutomationExercise {

    @Test
    public void automationExercise() {

        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));

        AutomationExercisePage automationExercisePage = new AutomationExercisePage();
        automationExercisePage.login.click();

        Faker faker = new Faker();

        automationExercisePage.name.sendKeys(faker.name().firstName());
        automationExercisePage.emailAdres.sendKeys(faker.internet().emailAddress());
        automationExercisePage.signup.click();
        automationExercisePage.gender.click();
        automationExercisePage.password.sendKeys(faker.internet().password());

        ReusableMethods.selectByValue(automationExercisePage.day, "2");
        ReusableMethods.selectByValue(automationExercisePage.month, "9");
        ReusableMethods.selectByValue(automationExercisePage.year, "2000");
    }
}
