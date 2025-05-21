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

    @Given("a shipment order exists in the system")
    public void shipmentOrderExists() {
        // Assume order exists in the system
    }

    @Given("the customer has subscribed to shipment alerts")
    public void customerSubscribedToAlerts() {
        // Assume customer is subscribed
    }

    @Given("the order ID is {int}")
    public void orderIdIs(int orderId) {
        // Store order ID
    }

    @Given("the customer email is {string}")
    public void customerEmailIs(String email) {
        // Store customer email
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void userLogsIn() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://dynamics365.example.com/login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("validUsername");
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
        WebElement ordersModule = wait.until(ExpectedConditions.elementToBeClickable(By.id("orders_module")));
        ordersModule.click();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void ordersModuleDisplayed() {
        WebElement ordersList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orders_list")));
        Assert.assertTrue("Orders list not displayed", ordersList.isDisplayed());
    }

    @When("the user selects the order with ID {int}")
    public void selectOrder(int orderId) {
        WebElement orderElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.order-item[data-id='" + orderId + "']")));
        orderElement.click();
    }

    @Then("the order details for order ID {int} are displayed")
    public void orderDetailsDisplayed(int orderId) {
        WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_details")));
        Assert.assertTrue("Order details not displayed", orderDetails.isDisplayed());
    }

    @And("the shipment status is 'Delivered'")
    public void shipmentStatusIsDelivered() {
        WebElement shipmentStatus = driver.findElement(By.id("shipment_status"));
        Assert.assertEquals("Shipment status not 'Delivered'", "Delivered", shipmentStatus.getText());
    }

    @When("the user updates the shipment status to 'Delivered'")
    public void updateShipmentStatus() {
        WebElement updateStatusButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("update_status_button")));
        updateStatusButton.click();
    }

    @Then("the shipment status is updated to 'Delivered'")
    public void shipmentStatusUpdated() {
        WebElement shipmentStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_status")));
        Assert.assertEquals("Shipment status not updated to 'Delivered'", "Delivered", shipmentStatus.getText());
    }

    @When("the user checks the alert system for outgoing alerts")
    public void checkAlertSystem() {
        WebElement alertSystem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert_system")));
        alertSystem.click();
    }

    @Then("an alert is sent to {string} notifying them of the delivery confirmation")
    public void alertSent(String email) {
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-message[data-email='" + email + "']")));
        Assert.assertTrue("Alert not sent", alertMessage.isDisplayed());
    }

    @And("the customer receives an alert with the message: 'Your shipment has been delivered.'")
    public void customerReceivesAlert() {
        WebElement alertMessage = driver.findElement(By.id("alert_message"));
        Assert.assertEquals("Alert message incorrect", "Your shipment has been delivered.", alertMessage.getText());
    }
}