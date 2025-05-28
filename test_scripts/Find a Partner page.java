import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstantShipmentTrackingAlertTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            // Log in to the Dynamics 365 system with valid credentials
            driver.get("https://example.com/login");
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            usernameField.sendKeys("validUsername");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("validPassword");
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();
            wait.until(ExpectedConditions.titleContains("Dashboard"));

            // Navigate to the 'Orders' module
            WebElement ordersModule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ordersModule")));
            ordersModule.click();
            wait.until(ExpectedConditions.titleContains("Orders"));

            // Select the order with ID 12345
            WebElement orderSearchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderSearchField")));
            orderSearchField.sendKeys("12345");
            WebElement searchButton = driver.findElement(By.id("searchButton"));
            searchButton.click();
            WebElement orderLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Order 12345")));
            orderLink.click();
            wait.until(ExpectedConditions.titleContains("Order Details"));

            // Update the shipment status to 'Dispatched'
            WebElement shipmentStatusDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipmentStatusDropdown")));
            shipmentStatusDropdown.click();
            WebElement dispatchedOption = driver.findElement(By.id("dispatchedOption"));
            dispatchedOption.click();
            WebElement updateStatusButton = driver.findElement(By.id("updateStatusButton"));
            updateStatusButton.click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("statusConfirmation"), "Dispatched"));

            // Check the alert system for outgoing alerts
            WebElement alertsModule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertsModule")));
            alertsModule.click();
            wait.until(ExpectedConditions.titleContains("Alerts"));
            WebElement outgoingAlerts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outgoingAlerts")));

            // Verify the alert received by the customer
            WebElement customerAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerAlert")));
            if (customerAlert.isDisplayed()) {
                System.out.println("Customer alert received successfully.");
            }

        } finally {
            driver.quit();
        }
    }
}