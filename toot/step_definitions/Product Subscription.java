import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SubscriptionSteps {
    WebDriver driver;
    WebDriverWait wait;
    SubscriptionPage subscriptionPage;

    @Given("the user is logged into the application")
    public void userIsLoggedIn() {
        // Assume user is already logged in
    }

    @Given("the user is on the product subscription page")
    public void userOnSubscriptionPage() {
        subscriptionPage.navigateToSubscriptionPage();
    }

    @Given("the user selects a product to subscribe")
    public void userSelectsProduct() {
        subscriptionPage.selectProduct();
    }

    @When("the user chooses a subscription plan")
    public void userChoosesPlan() {
        subscriptionPage.chooseSubscriptionPlan();
    }

    @When("the user enters payment details")
    public void userEntersPaymentDetails() {
        subscriptionPage.enterPaymentDetails();
    }

    @When("the user confirms the subscription")
    public void userConfirmsSubscription() {
        subscriptionPage.confirmSubscription();
    }

    @Then("the system should display a subscription confirmation message")
    public void systemDisplaysConfirmationMessage() {
        Assert.assertTrue(subscriptionPage.isConfirmationMessageDisplayed());
    }

    @Then("the user should receive a confirmation email")
    public void userReceivesConfirmationEmail() {
        // Assume email is sent
    }

    @Given("the user has an active product subscription")
    public void userHasActiveSubscription() {
        subscriptionPage.verifyActiveSubscription();
    }

    @When("the user navigates to the subscription management page")
    public void userNavigatesToManagementPage() {
        subscriptionPage.navigateToManagementPage();
    }

    @When("the user selects the subscription to modify")
    public void userSelectsSubscriptionToModify() {
        subscriptionPage.selectSubscriptionToModify();
    }

    @When("the user changes the subscription plan")
    public void userChangesSubscriptionPlan() {
        subscriptionPage.changeSubscriptionPlan();
    }

    @When("the user confirms the changes")
    public void userConfirmsChanges() {
        subscriptionPage.confirmChanges();
    }

    @Then("the system should display a subscription modification confirmation message")
    public void systemDisplaysModificationConfirmationMessage() {
        Assert.assertTrue(subscriptionPage.isModificationConfirmationMessageDisplayed());
    }

    @Then("the user should receive an email with the updated subscription details")
    public void userReceivesUpdatedSubscriptionEmail() {
        // Assume email is sent
    }

    @When("the user selects the subscription to cancel")
    public void userSelectsSubscriptionToCancel() {
        subscriptionPage.selectSubscriptionToCancel();
    }

    @When("the user confirms the cancellation")
    public void userConfirmsCancellation() {
        subscriptionPage.confirmCancellation();
    }

    @Then("the system should display a subscription cancellation confirmation message")
    public void systemDisplaysCancellationConfirmationMessage() {
        Assert.assertTrue(subscriptionPage.isCancellationConfirmationMessageDisplayed());
    }

    @Then("the user should receive a cancellation confirmation email")
    public void userReceivesCancellationEmail() {
        // Assume email is sent
    }

    @Then("the system should display the subscription details including product, plan, and next delivery date")
    public void systemDisplaysSubscriptionDetails() {
        Assert.assertTrue(subscriptionPage.areSubscriptionDetailsDisplayed());
    }

    @When("the user attempts to confirm the subscription without entering payment details")
    public void userAttemptsWithoutPaymentDetails() {
        subscriptionPage.attemptSubscriptionWithoutPaymentDetails();
    }

    @Then("the system should display an error message indicating that payment details are required")
    public void systemDisplaysErrorMessage() {
        Assert.assertTrue(subscriptionPage.isErrorMessageDisplayed());
    }
}