import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.*;

public class RegistrationSteps {
    WebDriver driver;
    RegistrationPage registrationPage;
    WebDriverWait wait;

    public RegistrationSteps(WebDriver driver) {
        this.driver = driver;
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        wait = new WebDriverWait(driver, 10);
    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        driver.get("http://example.com/register");
    }

    @When("I enter valid details such as username, email, and password")
    public void i_enter_valid_details() {
        registrationPage.enterUsername("newuser");
        registrationPage.enterEmail("newuser@example.com");
        registrationPage.enterPassword("StrongPassword123");
        registrationPage.enterConfirmPassword("StrongPassword123");
    }

    @When("I submit the registration form")
    public void i_submit_the_registration_form() {
        registrationPage.clickRegisterButton();
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOf(registrationPage.getConfirmationMessage()));
        Assert.assertTrue("Confirmation message not displayed", confirmationMessage.isDisplayed());
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        Assert.assertEquals("http://example.com/login", driver.getCurrentUrl());
    }

    @When("I enter \"test@example.com\" as my email")
    public void i_enter_existing_email() {
        registrationPage.enterEmail("test@example.com");
    }

    @Then("I should see an error message indicating the email is already registered")
    public void i_should_see_email_already_registered_error() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(registrationPage.getEmailErrorMessage()));
        Assert.assertTrue("Email already registered error not displayed", errorMessage.isDisplayed());
    }

    @When("I enter a password that does not meet the security requirements")
    public void i_enter_weak_password() {
        registrationPage.enterPassword("weak");
        registrationPage.enterConfirmPassword("weak");
    }

    @Then("I should see an error message indicating the password is too weak")
    public void i_should_see_weak_password_error() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(registrationPage.getPasswordErrorMessage()));
        Assert.assertTrue("Weak password error not displayed", errorMessage.isDisplayed());
    }

    @When("I leave one or more required fields empty")
    public void i_leave_required_fields_empty() {
        registrationPage.enterUsername("");
        registrationPage.enterEmail("");
        registrationPage.enterPassword("");
        registrationPage.enterConfirmPassword("");
    }

    @Then("I should see an error message indicating the fields are required")
    public void i_should_see_required_fields_error() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(registrationPage.getRequiredFieldsErrorMessage()));
        Assert.assertTrue("Required fields error not displayed", errorMessage.isDisplayed());
    }

    @When("I enter an invalid email format")
    public void i_enter_invalid_email_format() {
        registrationPage.enterEmail("invalid-email");
    }

    @Then("I should see an error message indicating the email format is invalid")
    public void i_should_see_invalid_email_format_error() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(registrationPage.getEmailFormatErrorMessage()));
        Assert.assertTrue("Invalid email format error not displayed", errorMessage.isDisplayed());
    }

    @When("I enter a password and a different password in the confirmation field")
    public void i_enter_mismatched_passwords() {
        registrationPage.enterPassword("Password123");
        registrationPage.enterConfirmPassword("Password456");
    }

    @Then("I should see an error message indicating the passwords do not match")
    public void i_should_see_passwords_do_not_match_error() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(registrationPage.getPasswordMismatchErrorMessage()));
        Assert.assertTrue("Passwords do not match error not displayed", errorMessage.isDisplayed());
    }
}