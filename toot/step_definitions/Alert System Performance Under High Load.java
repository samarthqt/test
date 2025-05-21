import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class AlertSystemSteps {
    WebDriver driver;
    WebDriverWait wait;
    DashboardPage dashboardPage;
    OrdersPage ordersPage;

    public AlertSystemSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.dashboardPage = new DashboardPage(driver);
        this.ordersPage = new OrdersPage(driver);
    }

    public void i_am_logged_into_the_Dynamics_365_system_with_valid_credentials() {
        dashboardPage.login("validUsername", "validPassword");
    }

    public void the_dashboard_is_displayed() {
        Assert.assertTrue("Dashboard is not displayed", dashboardPage.isDashboardDisplayed());
    }

    public void multiple_shipment_orders_exist_with_IDs_ranging_from_10001_to_10050() {
        Assert.assertTrue("Orders do not exist", ordersPage.ordersExist(10001, 10050));
    }

    public void customers_have_subscribed_to_shipment_alerts() {
        Assert.assertTrue("Customers are not subscribed to alerts", ordersPage.customersSubscribedToAlerts());
    }

    public void i_navigate_to_the_Orders_module() {
        dashboardPage.navigateToOrdersModule();
    }

    public void the_Orders_module_is_displayed_with_a_list_of_orders() {
        Assert.assertTrue("Orders module is not displayed", ordersPage.isOrdersModuleDisplayed());
    }

    public void the_customer_email_is_customer_example_com() {
        Assert.assertEquals("Customer email is incorrect", "customer@example.com", ordersPage.getCustomerEmail());
    }

    public void i_select_orders_with_IDs_ranging_from_10001_to_10050() {
        ordersPage.selectOrders(10001, 10050);
    }

    public void order_details_for_each_selected_order_are_displayed() {
        Assert.assertTrue("Order details are not displayed", ordersPage.areOrderDetailsDisplayed(10001, 10050));
    }

    public void the_shipment_status_is_Dispatched() {
        Assert.assertTrue("Shipment status is not 'Dispatched'", ordersPage.isShipmentStatusDispatched(10001, 10050));
    }

    public void i_update_the_shipment_status_of_all_selected_orders_to_Dispatched() {
        ordersPage.updateShipmentStatusToDispatched(10001, 10050);
    }

    public void the_shipment_status_for_all_selected_orders_is_updated_to_Dispatched() {
        Assert.assertTrue("Shipment status not updated to 'Dispatched'", ordersPage.isShipmentStatusUpdatedToDispatched(10001, 10050));
    }

    public void i_monitor_the_alert_system_for_outgoing_alerts() {
        ordersPage.monitorAlertSystem();
    }

    public void alerts_are_sent_to_customer_example_com_for_all_orders_without_delay() {
        Assert.assertTrue("Alerts not sent without delay", ordersPage.areAlertsSentWithoutDelay("customer@example.com", 10001, 10050));
    }

    public void the_system_maintains_optimal_performance_under_high_load_conditions() {
        Assert.assertTrue("System performance is not optimal", ordersPage.isSystemPerformanceOptimal());
    }
}