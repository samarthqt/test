import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class PaymentGatewayStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    public PaymentGatewayStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void userSelectsPaymentMethod(String method) {
        WebElement paymentMethod = wait.until(ExpectedConditions.elementToBeClickable(By.id(method)));
        paymentMethod.click();
    }

    public void userEntersPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = driver.findElement(By.id("card_number"));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id("expiry_date"));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id("cvv"));
        cvvField.sendKeys(cvv);
    }

    public void userConfirmsPayment() {
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm_payment")));
        confirmButton.click();
    }

    public void paymentShouldBeProcessedSuccessfully() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_confirmation")));
        Assert.assertTrue("Payment not processed", confirmationMessage.isDisplayed());
    }

    public void orderStatusShouldBeUpdated(String status) {
        WebElement orderStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_status")));
        Assert.assertEquals("Order status not updated", status, orderStatus.getText());
    }

    public void userReceivesErrorMessage(String message) {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message")));
        Assert.assertEquals("Error message not displayed", message, errorMessage.getText());
    }

    public void userIsRedirectedToPage(String pageId) {
        WebElement pageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageId)));
        Assert.assertTrue("User not redirected", pageElement.isDisplayed());
    }
}