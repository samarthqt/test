import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class AlertStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    public AlertStepDefinitions() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void givenShipmentOrderExists() {
        driver.get("http://example.com/login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("validUser");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("validPassword");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue("Login failed - Dashboard not found", dashboardElement.isDisplayed());
    }

    public void whenNavigateToOrdersModule() {
        WebElement ordersModule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orders_module")));
        ordersModule.click();
        WebElement ordersList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orders_list")));
        Assert.assertTrue("Orders module not displayed", ordersList.isDisplayed());
    }

    public void whenSelectOrderWithID54321() {
        WebElement order = driver.findElement(By.id("order_54321"));
        order.click();
        WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_details_54321")));
        Assert.assertTrue("Order details not displayed", orderDetails.isDisplayed());
    }

    public void whenUpdateShipmentStatusToDelivered() {
        WebElement shipmentStatus = driver.findElement(By.id("shipment_status"));
        shipmentStatus.clear();
        shipmentStatus.sendKeys("Delivered");
        WebElement updateButton = driver.findElement(By.id("update_status_button"));
        updateButton.click();
        WebElement updatedStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updated_status")));
        Assert.assertEquals("Delivered", updatedStatus.getText());
    }

    public void whenCheckAlertSystemForOutgoingAlerts() {
        WebElement alertSystem = driver.findElement(By.id("alert_system"));
        alertSystem.click();
        WebElement noAlertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("no_alert_message")));
        Assert.assertTrue("Alert was sent despite invalid email", noAlertMessage.isDisplayed());
    }

    public void whenVerifyErrorLogsForAlertSendingFailures() {
        WebElement errorLogs = driver.findElement(By.id("error_logs"));
        errorLogs.click();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message_invalid_email")));
        Assert.assertTrue("Error not logged for invalid email", errorMessage.isDisplayed());
    }
}