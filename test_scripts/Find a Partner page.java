import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstantShipmentTrackingAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            // Log in to the Dynamics 365 system with valid credentials
            driver.get("https://example.com/login");
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            usernameField.sendKeys("validUsername");
            passwordField.sendKeys("validPassword");
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
            WebElement orderResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order12345")));
            orderResult.click();

            // Update the shipment status to 'Dispatched'
            WebElement shipmentStatusDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipmentStatus")));
            shipmentStatusDropdown.click();
            WebElement dispatchedOption = driver.findElement(By.xpath("//option[text()='Dispatched']"));
            dispatchedOption.click();
            WebElement updateButton = driver.findElement(By.id("updateButton"));
            updateButton.click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("statusMessage"), "Status updated"));

            // Check the alert system for outgoing alerts
            WebElement alertSystemTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertSystemTab")));
            alertSystemTab.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outgoingAlerts")));

            // Verify the alert received by the customer
            WebElement customerAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerAlert")));
            if (customerAlert.isDisplayed()) {
                System.out.println("Alert received by the customer.");
            }

        } finally {
            driver.quit();
        }
    }
}