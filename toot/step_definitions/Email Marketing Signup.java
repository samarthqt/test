import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class EmailMarketingStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    EmailMarketingPage emailMarketingPage;

    public EmailMarketingStepDefinitions() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        emailMarketingPage = new EmailMarketingPage(driver);
    }

    public void givenUserIsOnSignupPage() {
        driver.get("http://example.com/email-signup");
    }

    public void whenUserEntersValidEmail() {
        emailMarketingPage.enterEmail("valid.email@example.com");
    }

    public void whenUserEntersInvalidEmail() {
        emailMarketingPage.enterEmail("invalid-email");
    }

    public void whenUserEntersAlreadyRegisteredEmail() {
        emailMarketingPage.enterEmail("registered.email@example.com");
    }

    public void whenUserSubmitsSignupForm() {
        emailMarketingPage.submitForm();
    }

    public void thenUserShouldSeeConfirmationMessage() {
        Assert.assertTrue("Confirmation message not displayed", emailMarketingPage.isConfirmationMessageDisplayed());
    }

    public void thenUserShouldSeeErrorMessageForInvalidEmail() {
        Assert.assertTrue("Error message for invalid email not displayed", emailMarketingPage.isInvalidEmailErrorMessageDisplayed());
    }

    public void thenUserShouldSeeAlreadyRegisteredMessage() {
        Assert.assertTrue("Already registered message not displayed", emailMarketingPage.isAlreadyRegisteredMessageDisplayed());
    }

    public void thenUserShouldSeeEmailRequiredErrorMessage() {
        Assert.assertTrue("Email required error message not displayed", emailMarketingPage.isEmailRequiredErrorMessageDisplayed());
    }

    public void whenUserClicksPrivacyPolicyLink() {
        emailMarketingPage.clickPrivacyPolicyLink();
    }

    public void thenUserShouldBeRedirectedToPrivacyPolicyPage() {
        Assert.assertTrue("Not redirected to privacy policy page", emailMarketingPage.isPrivacyPolicyPageDisplayed());
    }

    public void thenUserShouldBeAbleToReturnToSignupPage() {
        emailMarketingPage.returnToSignupPage();
        Assert.assertTrue("Not returned to signup page", emailMarketingPage.isSignupPageDisplayed());
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}