import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class StockWarningStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the product inventory module is active")
    public void productInventoryModuleActive() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/inventory");
        WebElement moduleStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_module_status")));
        Assert.assertTrue(moduleStatus.isDisplayed());
    }

    @And("a product has a defined low inventory threshold")
    public void productHasLowInventoryThreshold() {
        WebElement thresholdElement = driver.findElement(By.id("low_inventory_threshold"));
        Assert.assertTrue(thresholdElement.isDisplayed());
    }

    @When("the inventory level of the product falls below the threshold")
    public void inventoryFallsBelowThreshold() {
        WebElement inventoryLevel = driver.findElement(By.id("inventory_level"));
        int level = Integer.parseInt(inventoryLevel.getText());
        WebElement thresholdElement = driver.findElement(By.id("low_inventory_threshold"));
        int threshold = Integer.parseInt(thresholdElement.getText());
        Assert.assertTrue(level < threshold);
    }

    @Then("a stock warning notification should be sent to the users")
    public void stockWarningNotificationSent() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stock_warning_notification")));
        Assert.assertTrue(notification.isDisplayed());
    }

    @And("the notification should include the product name and current inventory level")
    public void notificationIncludesDetails() {
        WebElement notificationDetails = driver.findElement(By.id("notification_details"));
        Assert.assertTrue(notificationDetails.getText().contains("Product Name") && notificationDetails.getText().contains("Inventory Level"));
    }

    @When("the inventory level of the product is above the threshold")
    public void inventoryAboveThreshold() {
        WebElement inventoryLevel = driver.findElement(By.id("inventory_level"));
        int level = Integer.parseInt(inventoryLevel.getText());
        WebElement thresholdElement = driver.findElement(By.id("low_inventory_threshold"));
        int threshold = Integer.parseInt(thresholdElement.getText());
        Assert.assertTrue(level > threshold);
    }

    @Then("no stock warning notification should be sent to the users")
    public void noStockWarningNotificationSent() {
        WebElement notification = driver.findElement(By.id("stock_warning_notification"));
        Assert.assertFalse(notification.isDisplayed());
    }

    @When("a user configures the notification settings for low inventory")
    public void userConfiguresNotificationSettings() {
        WebElement settingsButton = driver.findElement(By.id("notification_settings_button"));
        settingsButton.click();
        WebElement saveButton = driver.findElement(By.id("save_settings_button"));
        saveButton.click();
    }

    @Then("the settings should be saved")
    public void settingsShouldBeSaved() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("settings_saved_confirmation")));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    @And("the system should respect the configured settings when sending notifications")
    public void systemRespectsConfiguredSettings() {
        WebElement notification = driver.findElement(By.id("stock_warning_notification"));
        Assert.assertTrue(notification.getText().contains("Configured Settings"));
    }

    @And("multiple products have inventory levels below their defined thresholds")
    public void multipleProductsBelowThreshold() {
        WebElement productList = driver.findElement(By.id("product_list"));
        Assert.assertTrue(productList.getText().contains("Low Inventory"));
    }

    @When("the system checks the inventory levels")
    public void systemChecksInventoryLevels() {
        WebElement checkButton = driver.findElement(By.id("check_inventory_button"));
        checkButton.click();
    }

    @Then("stock warning notifications should be sent for each product with low inventory")
    public void notificationsSentForEachProduct() {
        WebElement notifications = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("multiple_stock_warning_notifications")));
        Assert.assertTrue(notifications.isDisplayed());
    }

    @And("each notification should include the respective product name and current inventory level")
    public void eachNotificationIncludesDetails() {
        WebElement notificationDetails = driver.findElement(By.id("notification_details"));
        Assert.assertTrue(notificationDetails.getText().contains("Product Name") && notificationDetails.getText().contains("Inventory Level"));
    }

    @Given("a stock warning notification is sent")
    public void stockWarningNotificationIsSent() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stock_warning_notification")));
        Assert.assertTrue(notification.isDisplayed());
    }

    @When("the user checks their notifications")
    public void userChecksNotifications() {
        WebElement notificationTab = driver.findElement(By.id("notification_tab"));
        notificationTab.click();
    }

    @Then("the user should see the stock warning notification")
    public void userSeesStockWarningNotification() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stock_warning_notification")));
        Assert.assertTrue(notification.isDisplayed());
    }

    @And("the notification should contain details about the low inventory product")
    public void notificationContainsProductDetails() {
        WebElement notificationDetails = driver.findElement(By.id("notification_details"));
        Assert.assertTrue(notificationDetails.getText().contains("Product Name") && notificationDetails.getText().contains("Inventory Level"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}