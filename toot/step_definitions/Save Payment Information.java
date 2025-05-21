import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class PaymentInfoSteps {
    WebDriver driver;
    WebDriverWait wait;
    PaymentInfoPage paymentInfoPage;

    public PaymentInfoSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.paymentInfoPage = new PaymentInfoPage(driver);
    }

    public void givenUserIsLoggedIntoTheirAccount() {
        // Assume user is already logged in
    }

    public void givenUserIsOnPaymentInfoPage() {
        driver.get("http://example.com/payment-info");
    }

    public void givenUserEntersValidPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        paymentInfoPage.enterCardNumber(cardNumber);
        paymentInfoPage.enterExpiryDate(expiryDate);
        paymentInfoPage.enterCVV(cvv);
    }

    public void whenUserSavesPaymentInformation() {
        paymentInfoPage.clickSaveButton();
    }

    public void thenPaymentInformationShouldBeSavedSecurely() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation_message")));
        Assert.assertEquals("Payment information saved successfully.", confirmationMessage.getText());
    }

    public void givenUserEntersInvalidPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        paymentInfoPage.enterCardNumber(cardNumber);
        paymentInfoPage.enterExpiryDate(expiryDate);
        paymentInfoPage.enterCVV(cvv);
    }

    public void thenErrorMessageShouldBeDisplayed(String errorMessage) {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message")));
        Assert.assertEquals(errorMessage, errorMessageElement.getText());
    }

    public void givenUserEntersIncompletePaymentDetails(String cardNumber, String expiryDate, String cvv) {
        paymentInfoPage.enterCardNumber(cardNumber);
        paymentInfoPage.enterExpiryDate(expiryDate);
        paymentInfoPage.enterCVV(cvv);
    }

    public void givenUserHasPreviouslySavedPaymentInformation() {
        // Assume payment information is already saved
    }

    public void whenUserUpdatesPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        paymentInfoPage.enterCardNumber(cardNumber);
        paymentInfoPage.enterExpiryDate(expiryDate);
        paymentInfoPage.enterCVV(cvv);
    }

    public void whenUserOptsToDeleteSavedPaymentInformation() {
        paymentInfoPage.clickDeleteButton();
    }

    public void thenPaymentInformationShouldBeRemoved() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation_message")));
        Assert.assertEquals("Payment information deleted successfully.", confirmationMessage.getText());
    }
}