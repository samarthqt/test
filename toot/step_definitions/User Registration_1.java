import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class RegistrationSteps {
    WebDriver driver;
    WebDriverWait wait;
    RegistrationPage registrationPage;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        registrationPage = new RegistrationPage(driver);
        driver.get("http://example.com/register");
    }

    @When("the user enters valid details in all required fields")
    public void the_user_enters_valid_details_in_all_required_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        registrationPage.enterFirstName(data.get("First Name"));
        registrationPage.enterLastName(data.get("Last Name"));
        registrationPage.enterEmail(data.get("Email"));
        registrationPage.enterPassword(data.get("Password"));
        registrationPage.enterConfirmPassword(data.get("Confirm Password"));
    }

    @When("the user leaves the {string} field empty")
    public void the_user_leaves_the_field_empty(String field) {
        registrationPage.leaveFieldEmpty(field);
    }

    @When("the user enters an invalid email format {string}")
    public void the_user_enters_an_invalid_email_format(String email) {
        registrationPage.enterEmail(email);
    }

    @When("the user enters {string} in the {string} field")
    public void the_user_enters_in_the_field(String value, String field) {
        registrationPage.enterField(value, field);
    }

    @When("the user enters an email {string} that is already registered")
    public void the_user_enters_an_email_that_is_already_registered(String email) {
        registrationPage.enterEmail(email);
    }

    @And("the user submits the registration form")
    public void the_user_submits_the_registration_form() {
        registrationPage.submitForm();
    }

    @Then("the user account should be created successfully")
    public void the_user_account_should_be_created_successfully() {
        Assert.assertTrue(registrationPage.isRegistrationSuccessful());
    }

    @Then("the user should see a confirmation message {string}")
    public void the_user_should_see_a_confirmation_message(String message) {
        Assert.assertEquals(message, registrationPage.getConfirmationMessage());
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String message) {
        Assert.assertEquals(message, registrationPage.getErrorMessage());
    }
}