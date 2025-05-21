import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ShipmentTrackingSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("a shipment order exists in the system with Order ID {string}")
    public void shipmentOrderExists(String orderId) {
        // Assume order exists in the system
    }

    @Given("the customer has subscribed to shipment alerts")
    public void customerSubscribedToAlerts() {
        // Assume customer is subscribed
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void userLogsIn() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("validUser");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("validPassword");
        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();
    }

    @Then("the dashboard is displayed")
    public void dashboardDisplayed() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue("Dashboard not displayed", dashboardElement.isDisplayed());
    }

    @When("the user navigates to the 'Orders' module")
    public void navigateToOrdersModule() {
        WebElement ordersModule = driver.findElement(By.id("orders_module"));
        ordersModule.click();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void ordersModuleDisplayed() {
        WebElement ordersList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orders_list")));
        Assert.assertTrue("Orders list not displayed", ordersList.isDisplayed());
    }

    @When("the user selects the order with ID {string}")
    public void selectOrder(String orderId) {
        WebElement orderElement = driver.findElement(By.id("order_" + orderId));
        orderElement.click();
    }

    @Then("the order details for order ID {string} are displayed")
    public void orderDetailsDisplayed(String orderId) {
        WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_details_" + orderId)));
        Assert.assertTrue("Order details not displayed", orderDetails.isDisplayed());
    }

    @And("the shipment status is {string}")
    public void shipmentStatusIs(String status) {
        WebElement statusElement = driver.findElement(By.id("shipment_status"));
        Assert.assertEquals("Shipment status incorrect", status, statusElement.getText());
    }

    @When("the user updates the shipment status to {string}")
    public void updateShipmentStatus(String status) {
        WebElement statusDropdown = driver.findElement(By.id("status_dropdown"));
        statusDropdown.click();
        WebElement statusOption = driver.findElement(By.id("status_option_" + status));
        statusOption.click();
    }

    @Then("the shipment status is updated to {string}")
    public void shipmentStatusUpdated(String status) {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_status")));
        Assert.assertEquals("Shipment status not updated", status, statusElement.getText());
    }

    @When("the alert system is checked for outgoing alerts")
    public void checkAlertSystem() {
        // Assume alert system is checked
    }

    @Then("an alert is sent to {string} notifying them of the {string} status")
    public void alertSent(String email, String status) {
        WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert_sent")));
        Assert.assertTrue("Alert not sent", alertElement.isDisplayed());
    }

    @When("the alert received by the customer is verified")
    public void verifyCustomerAlert() {
        // Assume alert is verified
    }

    @Then("the customer receives an alert with the message: {string}")
    public void customerReceivesAlert(String message) {
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert_message")));
        Assert.assertEquals("Alert message incorrect", message, alertMessage.getText());
    }
}