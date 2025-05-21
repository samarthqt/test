import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class OrderConfirmationSteps {

    WebDriver driver;
    WebDriverWait wait;

    public OrderConfirmationSteps() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void givenUserHasCompletedPurchase() {
        driver.get("http://example.com/checkout");
        WebElement completePurchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("complete_purchase")));
        completePurchaseButton.click();
    }

    public void whenPurchaseTransactionIsSuccessful() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("purchase_success")));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public void thenOrderConfirmationEmailShouldBeSent() {
        WebElement emailSentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_sent")));
        Assert.assertTrue(emailSentMessage.isDisplayed());
    }

    public void andEmailShouldContainOrderDetails() {
        WebElement emailContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_content")));
        Assert.assertTrue(emailContent.getText().contains("Order ID"));
        Assert.assertTrue(emailContent.getText().contains("Items Purchased"));
        Assert.assertTrue(emailContent.getText().contains("Total Amount"));
        Assert.assertTrue(emailContent.getText().contains("Delivery Address"));
    }

    public void andEmailShouldBeSentFromCorrectSender() {
        WebElement senderEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sender_email")));
        Assert.assertEquals("orders@example.com", senderEmail.getText());
    }

    public void givenUserAttemptsToCompletePurchase() {
        driver.get("http://example.com/checkout");
        WebElement attemptPurchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("attempt_purchase")));
        attemptPurchaseButton.click();
    }

    public void whenPurchaseTransactionFails() {
        WebElement failureMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("purchase_failure")));
        Assert.assertTrue(failureMessage.isDisplayed());
    }

    public void thenNoOrderConfirmationEmailShouldBeSent() {
        WebElement emailNotSentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_not_sent")));
        Assert.assertTrue(emailNotSentMessage.isDisplayed());
    }

    public void andInitialAttemptToSendEmailFails() {
        WebElement initialFailureMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("initial_email_failure")));
        Assert.assertTrue(initialFailureMessage.isDisplayed());
    }

    public void whenSystemRetriesSendingEmail() {
        WebElement retryButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("retry_email")));
        retryButton.click();
    }

    public void thenOrderConfirmationEmailShouldBeSuccessfullySent() {
        WebElement retrySuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retry_email_success")));
        Assert.assertTrue(retrySuccessMessage.isDisplayed());
    }

    public void whenOrderConfirmationEmailIsSent() {
        WebElement emailSentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_sent")));
        Assert.assertTrue(emailSentMessage.isDisplayed());
    }

    public void thenSystemShouldLogEmailSendingStatus() {
        WebElement logStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log_status")));
        Assert.assertTrue(logStatus.isDisplayed());
    }

    public void andLogShouldIncludeEmailStatus() {
        WebElement logContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log_content")));
        Assert.assertTrue(logContent.getText().contains("Email Sent Successfully"));
        Assert.assertTrue(logContent.getText().contains("Errors"));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}