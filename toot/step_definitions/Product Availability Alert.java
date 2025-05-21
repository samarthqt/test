import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProductAvailabilitySteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductPage productPage;
    NotificationService notificationService;

    @Given("a product is currently out of stock")
    public void a_product_is_currently_out_of_stock() {
        productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isProductOutOfStock());
    }

    @Given("a user has subscribed to be notified when the product is back in stock")
    public void a_user_has_subscribed_to_be_notified() {
        productPage.subscribeForNotification();
    }

    @Given("a user has not subscribed to be notified when the product is back in stock")
    public void a_user_has_not_subscribed_to_be_notified() {
        Assert.assertFalse(productPage.isUserSubscribed());
    }

    @Given("multiple users have subscribed to be notified when the product is back in stock")
    public void multiple_users_have_subscribed() {
        productPage.subscribeMultipleUsers();
    }

    @Given("the user has set their preferred communication channel as email")
    public void user_set_preferred_communication_channel() {
        productPage.setPreferredCommunicationChannel("email");
    }

    @When("the product becomes available in the inventory")
    public void the_product_becomes_available() {
        productPage.setProductInStock();
    }

    @When("the user unsubscribes from the product availability alert")
    public void the_user_unsubscribes() {
        productPage.unsubscribeFromNotification();
    }

    @Then("the user should receive a notification about the product availability")
    public void user_should_receive_notification() {
        Assert.assertTrue(notificationService.isNotificationReceived());
    }

    @Then("the user should not receive any notification")
    public void user_should_not_receive_notification() {
        Assert.assertFalse(notificationService.isNotificationReceived());
    }

    @Then("all subscribed users should receive a notification about the product availability")
    public void all_subscribed_users_should_receive_notification() {
        Assert.assertTrue(notificationService.areAllNotificationsReceived());
    }

    @Then("the notification should include details of the product such as name and quantity available")
    public void notification_should_include_product_details() {
        Assert.assertTrue(notificationService.isProductDetailsIncluded());
    }

    @Then("the user should receive an email notification about the product availability")
    public void user_should_receive_email_notification() {
        Assert.assertTrue(notificationService.isEmailNotificationReceived());
    }
}