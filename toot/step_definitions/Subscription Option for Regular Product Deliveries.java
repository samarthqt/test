import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.*;

public class SubscriptionSteps {
    WebDriver driver;
    WebDriverWait wait;
    SubscriptionPage subscriptionPage;

    @Given("the user is on the product subscription page")
    public void user_on_subscription_page() {
        driver.get("http://example.com/subscription");
        subscriptionPage = new SubscriptionPage(driver);
    }

    @When("the user selects a product for subscription")
    public void user_selects_product() {
        subscriptionPage.selectProduct();
    }

    @When("the user chooses the subscription frequency")
    public void user_chooses_frequency() {
        subscriptionPage.chooseFrequency();
    }

    @When("the user provides payment details")
    public void user_provides_payment_details() {
        subscriptionPage.enterPaymentDetails();
    }

    @Then("the system should confirm the subscription")
    public void system_confirms_subscription() {
        Assert.assertTrue(subscriptionPage.isSubscriptionConfirmed());
    }

    @Then("the user should receive a confirmation email")
    public void user_receives_confirmation_email() {
        Assert.assertTrue(subscriptionPage.isConfirmationEmailReceived());
    }

    @Given("the user has an active product subscription")
    public void user_has_active_subscription() {
        Assert.assertTrue(subscriptionPage.hasActiveSubscription());
    }

    @When("the user navigates to the subscription management page")
    public void user_navigates_to_management_page() {
        subscriptionPage.goToManagementPage();
    }

    @When("the user selects to modify the subscription")
    public void user_selects_modify_subscription() {
        subscriptionPage.modifySubscription();
    }

    @When("the user changes the subscription frequency or product quantity")
    public void user_changes_subscription_details() {
        subscriptionPage.changeSubscriptionDetails();
    }

    @Then("the system should update the subscription details")
    public void system_updates_subscription_details() {
        Assert.assertTrue(subscriptionPage.isSubscriptionUpdated());
    }

    @Then("the user should receive an update confirmation email")
    public void user_receives_update_confirmation_email() {
        Assert.assertTrue(subscriptionPage.isUpdateConfirmationEmailReceived());
    }

    @When("the user selects to cancel the subscription")
    public void user_selects_cancel_subscription() {
        subscriptionPage.cancelSubscription();
    }

    @Then("the system should confirm the cancellation")
    public void system_confirms_cancellation() {
        Assert.assertTrue(subscriptionPage.isCancellationConfirmed());
    }

    @Then("the user should receive a cancellation confirmation email")
    public void user_receives_cancellation_confirmation_email() {
        Assert.assertTrue(subscriptionPage.isCancellationEmailReceived());
    }

    @Then("the user should see the subscription details including product, frequency, and next delivery date")
    public void user_sees_subscription_details() {
        Assert.assertTrue(subscriptionPage.areSubscriptionDetailsVisible());
    }

    @When("the payment details are invalid")
    public void payment_details_are_invalid() {
        subscriptionPage.enterInvalidPaymentDetails();
    }

    @Then("the system should display an error message")
    public void system_displays_error_message() {
        Assert.assertTrue(subscriptionPage.isErrorMessageDisplayed());
    }

    @Then("the subscription should not be processed")
    public void subscription_not_processed() {
        Assert.assertFalse(subscriptionPage.isSubscriptionProcessed());
    }
}