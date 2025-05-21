import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class StepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Given("a shipment order exists in the system with Order ID {int}")
    public void a_shipment_order_exists_in_the_system_with_order_id(Integer orderId) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://example.com/login");
    }

    @Given("the customer with email {string} has not subscribed to shipment alerts")
    public void the_customer_with_email_has_not_subscribed_to_shipment_alerts(String email) {
        // Logic to verify subscription status
    }

    @When("I log in to the Dynamics 365 system with valid credentials")
    public void i_log_in_to_the_dynamics_365_system_with_valid_credentials() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("validUsername");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("validPassword");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    @Then("the dashboard is displayed")
    public void the_dashboard_is_displayed() {
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        Assert.assertTrue("Dashboard not displayed", dashboard.isDisplayed());
    }

    @And("I navigate to the 'Orders' module")
    public void i_navigate_to_the_orders_module() {
        WebElement ordersModule = wait.until(ExpectedConditions.elementToBeClickable(By.id("orders_module")));
        ordersModule.click();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void the_orders_module_is_displayed_with_a_list_of_orders() {
        WebElement ordersList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orders_list")));
        Assert.assertTrue("Orders list not displayed", ordersList.isDisplayed());
    }

    @When("I select the order with ID {int}")
    public void i_select_the_order_with_id(Integer orderId) {
        WebElement order = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-order-id='" + orderId + "']")));
        order.click();
    }

    @Then("the order details for order ID {int} are displayed")
    public void the_order_details_for_order_id_are_displayed(Integer orderId) {
        WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_details")));
        Assert.assertTrue("Order details not displayed", orderDetails.isDisplayed());
    }

    @And("the shipment status is 'Dispatched'")
    public void the_shipment_status_is_dispatched() {
        WebElement shipmentStatus = driver.findElement(By.id("shipment_status"));
        Assert.assertEquals("Dispatched", shipmentStatus.getText());
    }

    @When("I update the shipment status to 'Dispatched'")
    public void i_update_the_shipment_status_to_dispatched() {
        WebElement updateStatusButton = driver.findElement(By.id("update_status"));
        updateStatusButton.click();
    }

    @Then("the shipment status is updated to 'Dispatched'")
    public void the_shipment_status_is_updated_to_dispatched() {
        WebElement shipmentStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipment_status")));
        Assert.assertEquals("Dispatched", shipmentStatus.getText());
    }

    @And("I check the alert system for outgoing alerts")
    public void i_check_the_alert_system_for_outgoing_alerts() {
        // Logic to check alert system
    }

    @Then("no alert is sent to {string}")
    public void no_alert_is_sent_to(String email) {
        // Logic to verify no alert sent
    }

    @And("I verify the customer's email inbox")
    public void i_verify_the_customer_s_email_inbox() {
        // Logic to verify email inbox
    }

    @Then("no alert is received by {string}")
    public void no_alert_is_received_by(String email) {
        // Logic to verify no alert received
    }
}