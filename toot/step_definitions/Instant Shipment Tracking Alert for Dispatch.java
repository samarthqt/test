import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ShipmentTrackingStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Given("a shipment order exists in the system with Order ID {int}")
    public void shipmentOrderExists(int orderId) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
        loginToDynamics365();
    }

    @Given("the customer has subscribed to shipment alerts")
    public void customerSubscribedToAlerts() {
        // Assume subscription is verified
    }

    @Given("I am logged into the Dynamics 365 system with valid credentials")
    public void loginToDynamics365() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("validUser");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("validPassword");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue("Login failed", dashboardElement.isDisplayed());
    }

    @When("I navigate to the 'Orders' module")
    public void navigateToOrdersModule() {
        WebElement ordersModule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orders_module")));
        ordersModule.click();
    }

    @When("I select the order with ID {int}")
    public void selectOrder(int orderId) {
        WebElement orderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_" + orderId)));
        orderElement.click();
    }

    @When("I update the shipment status to 'Dispatched'")
    public void updateShipmentStatus() {
        WebElement statusDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status_dropdown")));
        statusDropdown.click();
        WebElement dispatchedOption = driver.findElement(By.id("status_dispatched"));
        dispatchedOption.click();
        WebElement updateButton = driver.findElement(By.id("update_button"));
        updateButton.click();
    }

    @Then("the shipment status is updated to 'Dispatched'")
    public void verifyShipmentStatusUpdated() {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
        Assert.assertEquals("Dispatched", statusElement.getText());
    }

    @Then("an alert is sent to {string} notifying them of the dispatch status")
    public void verifyAlertSent(String email) {
        // Assume alert is sent
    }

    @Then("the customer receives an alert with the message: {string}")
    public void verifyCustomerAlert(String message) {
        // Assume alert message is received
    }
}