import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class OrderTrackingSteps {
    WebDriver driver;
    WebDriverWait wait;

    public OrderTrackingSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void userNavigatesToOrderTrackingSection() {
        driver.findElement(By.id("order_tracking_section")).click();
    }

    public void userSelectsOrderToTrack() {
        WebElement orderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_list")));
        orderElement.click();
    }

    public void systemDisplaysCurrentStatusOfOrder() {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_status")));
        Assert.assertTrue("Order status not displayed", statusElement.isDisplayed());
    }

    public void systemDisplaysExpectedDeliveryDate() {
        WebElement deliveryDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delivery_date")));
        Assert.assertTrue("Expected delivery date not displayed", deliveryDateElement.isDisplayed());
    }

    public void systemDisplaysCurrentLocationOfOrder() {
        WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_location")));
        Assert.assertTrue("Current location not displayed", locationElement.isDisplayed());
    }

    public void userViewingTrackingInformationOfOrder() {
        WebElement trackingInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tracking_info")));
        Assert.assertTrue("Tracking information not displayed", trackingInfoElement.isDisplayed());
    }

    public void orderStatusChanges() {
        // Simulate order status change
        WebElement statusChangeElement = driver.findElement(By.id("status_change"));
        statusChangeElement.click();
    }

    public void systemUpdatesOrderStatusInRealTime() {
        WebElement updatedStatusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updated_order_status")));
        Assert.assertTrue("Order status not updated in real-time", updatedStatusElement.isDisplayed());
    }

    public void userNotifiedOfStatusChange() {
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status_change_notification")));
        Assert.assertTrue("User not notified of status change", notificationElement.isDisplayed());
    }

    public void trackingInformationUnavailable() {
        WebElement unavailableElement = driver.findElement(By.id("tracking_unavailable"));
        unavailableElement.click();
    }

    public void systemDisplaysErrorMessage() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message")));
        Assert.assertTrue("Error message not displayed", errorMessageElement.isDisplayed());
    }

    public void systemProvidesOptionToRetry() {
        WebElement retryOptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retry_option")));
        Assert.assertTrue("Retry option not provided", retryOptionElement.isDisplayed());
    }

    public void userNotLoggedIntoApplication() {
        // Simulate user not logged in
        WebElement loginStatusElement = driver.findElement(By.id("login_status"));
        Assert.assertFalse("User is logged in", loginStatusElement.isDisplayed());
    }

    public void userAttemptsToAccessOrderTrackingSection() {
        driver.findElement(By.id("order_tracking_section")).click();
    }

    public void systemPromptsUserToLogIn() {
        WebElement loginPromptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_prompt")));
        Assert.assertTrue("Login prompt not displayed", loginPromptElement.isDisplayed());
    }
}