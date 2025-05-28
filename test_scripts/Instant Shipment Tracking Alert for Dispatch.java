import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiveTrackingTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            // Test Step 1
            driver.get("https://example.com/live-tracking");
            wait.until(ExpectedConditions.titleContains("Live Tracking"));

            // Test Step 2
            WebElement trackingField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingField")));
            trackingField.sendKeys("54321");
            WebElement trackButton = driver.findElement(By.id("trackButton"));
            trackButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingDetails")));

            // Test Step 3
            WebElement currentLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentLocation")));

            // Test Step 4
            WebElement simulateLocationChangeButton = driver.findElement(By.id("simulateLocationChange"));
            simulateLocationChangeButton.click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("locationUpdate"), "Updated"));

            // Test Step 5
            WebElement estimatedDeliveryTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimatedDeliveryTime")));

            // Test Step 6
            driver.navigate().refresh();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingDetails")));

            // Test Step 7
            WebElement logoutButton = driver.findElement(By.id("logout"));
            logoutButton.click();
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
            loginButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingDetails")));

            // Test Step 8
            WebElement notificationSettings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notificationSettings")));
            notificationSettings.click();
            wait.until(ExpectedConditions.elementToBeSelected(By.id("enableNotifications")));

            // Test Step 9
            WebElement simulateNetworkIssueButton = driver.findElement(By.id("simulateNetworkIssue"));
            simulateNetworkIssueButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("networkIssueHandled")));

            // Test Step 10
            WebElement trackingHistoryLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingHistoryLog")));

            // Test Step 11
            WebElement errorMessages = driver.findElement(By.id("errorMessages"));
            if (!errorMessages.isDisplayed()) {
                System.out.println("No error messages displayed.");
            }

            // Test Step 12
            WebElement updateFromDifferentDeviceButton = driver.findElement(By.id("updateFromDifferentDevice"));
            updateFromDifferentDeviceButton.click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("synchronizedUpdates"), "Synchronized"));

            // Test Step 13
            WebElement mobileTrackingView = driver.findElement(By.id("mobileTrackingView"));
            if (mobileTrackingView.isDisplayed()) {
                System.out.println("Mobile tracking view is consistent.");
            }

            // Test Step 14
            WebElement systemRebootButton = driver.findElement(By.id("systemReboot"));
            systemRebootButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingDetails")));

            // Test Step 15
            WebElement accuracyCheck = driver.findElement(By.id("accuracyCheck"));
            if (accuracyCheck.isDisplayed()) {
                System.out.println("Live tracking information is accurate.");
            }

        } finally {
            driver.quit();
        }
    }
}