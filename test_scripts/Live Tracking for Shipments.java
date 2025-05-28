import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTimeShipmentStatusUpdates {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://example.com/shipment-tracking");

            WebElement shipmentIdField = driver.findElement(By.id("shipment-id"));
            shipmentIdField.sendKeys("12345");

            WebElement checkStatusButton = driver.findElement(By.id("check-status"));
            checkStatusButton.click();

            WebElement simulateUpdateButton = driver.findElement(By.id("simulate-update"));
            simulateUpdateButton.click();

            WebElement simulateDeliveredButton = driver.findElement(By.id("simulate-delivered"));
            simulateDeliveredButton.click();

            WebElement timestampElement = driver.findElement(By.id("timestamp"));
            String timestamp = timestampElement.getText();
            System.out.println("Latest update timestamp: " + timestamp);

            driver.navigate().refresh();

            WebElement logoutButton = driver.findElement(By.id("logout"));
            logoutButton.click();

            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();

            WebElement notificationSettings = driver.findElement(By.id("notification-settings"));
            notificationSettings.click();

            WebElement simulateNetworkIssueButton = driver.findElement(By.id("simulate-network-issue"));
            simulateNetworkIssueButton.click();

            WebElement shipmentHistoryLog = driver.findElement(By.id("shipment-history-log"));
            String historyLog = shipmentHistoryLog.getText();
            System.out.println("Shipment history log: " + historyLog);

            WebElement errorMessages = driver.findElement(By.id("error-messages"));
            String errors = errorMessages.getText();
            System.out.println("Error messages: " + errors);

            WebElement updateStatusDifferentDeviceButton = driver.findElement(By.id("update-different-device"));
            updateStatusDifferentDeviceButton.click();

            WebElement smsVerificationButton = driver.findElement(By.id("verify-sms"));
            smsVerificationButton.click();

            WebElement systemRebootButton = driver.findElement(By.id("system-reboot"));
            systemRebootButton.click();

            WebElement checkStatusAfterRebootButton = driver.findElement(By.id("check-status-after-reboot"));
            checkStatusAfterRebootButton.click();
            
        } finally {
            driver.quit();
        }
    }
}