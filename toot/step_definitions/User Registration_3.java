import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class RegistrationSteps {
    WebDriver driver;
    WebDriverWait wait;
    RegistrationPage registrationPage;

    @Given("I am on the user registration page")
    public void i_am_on_the_user_registration_page() {
        driver.get("http://example.com/register");
        registrationPage = new RegistrationPage(driver);
    }

    @When("I enter valid details such as {string} for name, {string} for email, {string} for password")
    public void i_enter_valid_details(String name, String email, String password) {
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
    }

    @When("I enter {string} for name, {string} for email, {string} for password")
    public void i_enter_details(String name, String email, String password) {
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
    }

    @When("I leave the name field empty")
    public void i_leave_the_name_field_empty() {
        registrationPage.enterName("");
    }

    @When("I leave the email field empty")
    public void i_leave_the_email_field_empty() {
        registrationPage.enterEmail("");
    }

    @When("I leave the password field empty")
    public void i_leave_the_password_field_empty() {
        registrationPage.enterPassword("");
    }

    @And("I submit the registration form")
    public void i_submit_the_registration_form() {
        registrationPage.submitForm();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String message) {
        Assert.assertEquals(message, registrationPage.getConfirmationMessage());
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String message) {
        Assert.assertEquals(message, registrationPage.getErrorMessage());
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}