import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        driver.get("http://example.com/login");
    }

    @When("the user enters a valid email {string} and password {string}")
    public void the_user_enters_a_valid_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("the user enters an invalid email {string} and a valid password {string}")
    public void the_user_enters_an_invalid_email_and_a_valid_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("the user enters a valid email {string} and an invalid password {string}")
    public void the_user_enters_a_valid_email_and_an_invalid_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("the user leaves the email and password fields empty")
    public void the_user_leaves_the_email_and_password_fields_empty() {
        loginPage.enterEmail("");
        loginPage.enterPassword("");
    }

    @When("the user leaves the email field empty and enters a valid password {string}")
    public void the_user_leaves_the_email_field_empty_and_enters_a_valid_password(String password) {
        loginPage.enterEmail("");
        loginPage.enterPassword(password);
    }

    @When("the user enters a valid email {string} and leaves the password field empty")
    public void the_user_enters_a_valid_email_and_leaves_the_password_field_empty(String email) {
        loginPage.enterEmail(email);
        loginPage.enterPassword("");
    }

    @When("the user enters a password {string}")
    public void the_user_enters_a_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks the password visibility toggle")
    public void the_user_clicks_the_password_visibility_toggle() {
        loginPage.togglePasswordVisibility();
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @When("the user selects the {string} checkbox")
    public void the_user_selects_the_checkbox(String checkbox) {
        loginPage.selectRememberMe();
    }

    @When("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkText) {
        loginPage.clickForgotPassword();
    }

    @Then("the user should be redirected to the account dashboard")
    public void the_user_should_be_redirected_to_the_account_dashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @Then("an error message should be displayed indicating invalid email or password")
    public void an_error_message_should_be_displayed_indicating_invalid_email_or_password() {
        Assert.assertTrue(loginPage.isInvalidLoginMessageDisplayed());
    }

    @Then("an error message should be displayed indicating that email and password are required")
    public void an_error_message_should_be_displayed_indicating_that_email_and_password_are_required() {
        Assert.assertTrue(loginPage.isEmailAndPasswordRequiredMessageDisplayed());
    }

    @Then("an error message should be displayed indicating that email is required")
    public void an_error_message_should_be_displayed_indicating_that_email_is_required() {
        Assert.assertTrue(loginPage.isEmailRequiredMessageDisplayed());
    }

    @Then("an error message should be displayed indicating that password is required")
    public void an_error_message_should_be_displayed_indicating_that_password_is_required() {
        Assert.assertTrue(loginPage.isPasswordRequiredMessageDisplayed());
    }

    @Then("the password should be visible in plain text")
    public void the_password_should_be_visible_in_plain_text() {
        Assert.assertTrue(loginPage.isPasswordVisible());
    }

    @Then("the password should be hidden")
    public void the_password_should_be_hidden() {
        Assert.assertFalse(loginPage.isPasswordVisible());
    }

    @Then("the user's email should be remembered on the login page upon logout")
    public void the_user_s_email_should_be_remembered_on_the_login_page_upon_logout() {
        loginPage.logout();
        Assert.assertTrue(loginPage.isEmailRemembered());
    }

    @Then("the user should be redirected to the password reset page")
    public void the_user_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(loginPage.isPasswordResetPageDisplayed());
    }
}