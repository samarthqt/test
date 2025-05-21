import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SocialMediaLoginSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    SocialMediaPage socialMediaPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        loginPage = new LoginPage(driver, wait);
        loginPage.navigateToLoginPage();
    }

    @When("the user selects {string} login option")
    public void the_user_selects_login_option(String platform) {
        loginPage.selectSocialMediaLoginOption(platform);
    }

    @And("the user is redirected to {string} login page")
    public void the_user_is_redirected_to_login_page(String platform) {
        socialMediaPage = new SocialMediaPage(driver, wait, platform);
        Assert.assertTrue(socialMediaPage.isOnSocialMediaLoginPage());
    }

    @And("the user enters valid {string} credentials")
    public void the_user_enters_valid_credentials(String platform) {
        socialMediaPage.enterValidCredentials(platform);
    }

    @And("the user enters invalid {string} credentials")
    public void the_user_enters_invalid_credentials(String platform) {
        socialMediaPage.enterInvalidCredentials(platform);
    }

    @And("the user authorizes the application")
    public void the_user_authorizes_the_application() {
        socialMediaPage.authorizeApplication();
    }

    @And("the user denies the application authorization")
    public void the_user_denies_the_application_authorization() {
        socialMediaPage.denyApplicationAuthorization();
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        Assert.assertTrue(loginPage.isOnHomePage());
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isUserLoggedIn());
    }

    @Then("the user should see an error message indicating invalid credentials")
    public void the_user_should_see_an_error_message_indicating_invalid_credentials() {
        Assert.assertTrue(socialMediaPage.isErrorMessageDisplayed());
    }

    @Then("the user should not be logged in")
    public void the_user_should_not_be_logged_in() {
        Assert.assertFalse(loginPage.isUserLoggedIn());
    }

    @Then("the user should be redirected back to the login page")
    public void the_user_should_be_redirected_back_to_the_login_page() {
        Assert.assertTrue(loginPage.isOnLoginPage());
    }

    @When("the user looks for social media login options")
    public void the_user_looks_for_social_media_login_options() {
        loginPage.checkSocialMediaOptions();
    }

    @Then("the user should see options for Facebook, Google, Twitter, and LinkedIn")
    public void the_user_should_see_options_for_facebook_google_twitter_and_linkedin() {
        Assert.assertTrue(loginPage.areSocialMediaOptionsAvailable());
    }
}