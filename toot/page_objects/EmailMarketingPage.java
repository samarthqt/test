
package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import .time.Duration;

public class EmailMarketingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailFieldLocator = By.id(email);
    private final By submitButtonLocator = By.id(submit_button);
    private final By confirmationMessageLocator = By.id(confirmation_message);
    private final By invalidEmailErrorLocator = By.id(invalid_email_error);
    private final By alreadyRegisteredMessageLocator = By.id(already_registered_message);
    private final By emailRequiredErrorLocator = By.id(email_required_error);
    private final By privacyPolicyLinkLocator = By.id(privacy_policy_link);

    public EmailMarketingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(final String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void submitForm() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.click();
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator));
        return confirmationMessage.isDisplayed();
    }

    public boolean isInvalidEmailErrorMessageDisplayed() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmailErrorLocator));
        return errorMessage.isDisplayed();
    }

    public boolean isAlreadyRegisteredMessageDisplayed() {
        WebElement alreadyRegisteredMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyRegisteredMessageLocator));
        return alreadyRegisteredMessage.isDisplayed();
    }

    public boolean isEmailRequiredErrorMessageDisplayed() {
        WebElement emailRequiredMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(emailRequiredErrorLocator));
        return emailRequiredMessage.isDisplayed();
    }

    public void clickPrivacyPolicyLink() {
        WebElement privacyPolicyLink = wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLinkLocator));
        privacyPolicyLink.click();
    }

    public boolean isPrivacyPolicyPageDisplayed() {
        return driver.getCurrentUrl().contains(privacy-policy);
    }

    public void returnToSignupPage() {
        driver.navigate().back();
    }

    public boolean isSignupPageDisplayed() {
        return driver.getCurrentUrl().contains(email-signup);
    }
}
