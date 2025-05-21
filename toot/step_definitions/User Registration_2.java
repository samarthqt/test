import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class RegistrationSteps {
    WebDriver driver;
    WebDriverWait wait;
    RegistrationPage registrationPage;

    public RegistrationSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.registrationPage = new RegistrationPage(driver);
    }

    public void givenUserIsOnRegistrationPage() {
        driver.get("http://example.com/register");
    }

    public void whenUserEntersValidUsername(String username) {
        registrationPage.enterUsername(username);
    }

    public void whenUserEntersValidEmail(String email) {
        registrationPage.enterEmail(email);
    }

    public void whenUserEntersValidPassword(String password) {
        registrationPage.enterPassword(password);
    }

    public void whenUserConfirmsPassword(String password) {
        registrationPage.enterConfirmPassword(password);
    }

    public void whenUserSubmitsRegistrationForm() {
        registrationPage.clickRegisterButton();
    }

    public void thenUserShouldSeeConfirmationMessage() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_message")));
        Assert.assertTrue("Confirmation message not displayed", successMessage.isDisplayed());
    }

    public void thenUserShouldSeeErrorMessage(String errorMessageId) {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(errorMessageId)));
        Assert.assertTrue("Error message not displayed", errorMessage.isDisplayed());
    }
}