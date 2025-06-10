package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has items in their cart")
    public void aUserHasItemsInTheirCart() {
        String productName = testHarness.getData("CartData", "ProductName");
        String quantity = testHarness.getData("CartData", "Quantity");
        addProductToCart(productName, quantity);
    }

    @When("the user initiates the checkout process")
    public void theUserInitiatesTheCheckoutProcess() {
        proceedToCheckout();
    }

    @Then("the checkout should be completed in 5 steps or fewer")
    public void theCheckoutShouldBeCompletedIn5StepsOrFewer() {
        verifyCheckoutSteps(5);
    }

    @Given("a user has completed the checkout process")
    public void aUserHasCompletedTheCheckoutProcess() {
        completeCheckoutProcess();
    }

    @Then("the user should receive confirmation of successful checkout")
    public void theUserShouldReceiveConfirmationOfSuccessfulCheckout() {
        verifyOrderConfirmation("Your order has been successfully placed.");
    }

    @Given("a user is at the payment step of checkout")
    public void aUserIsAtThePaymentStepOfCheckout() {
        navigateToPaymentStep();
    }

    @Then("payment options should be clearly presented")
    public void paymentOptionsShouldBeClearlyPresented() {
        verifyPaymentOptionsVisibility();
    }

    @Given("a user has previously entered shipping information")
    public void aUserHasPreviouslyEnteredShippingInformation() {
        saveShippingInformation();
    }

    @When("the user reaches the shipping step of checkout")
    public void theUserReachesTheShippingStepOfCheckout() {
        navigateToShippingStep();
    }

    @Then("shipping information must be auto-filled")
    public void shippingInformationMustBeAutoFilled() {
        verifyAutoFilledShippingInformation();
    }

    @When("the user chooses to save their payment method")
    public void theUserChoosesToSaveTheirPaymentMethod() {
        savePaymentMethod();
    }

    @Then("the payment method should be saved for future use")
    public void thePaymentMethodShouldBeSavedForFutureUse() {
        verifyPaymentMethodSaved();
    }

    @Given("a user encounters an error during checkout")
    public void aUserEncountersAnErrorDuringCheckout() {
        simulateCheckoutError();
    }

    @Then("error handling should guide the user to resolve the issue")
    public void errorHandlingShouldGuideTheUserToResolveTheIssue() {
        verifyErrorHandlingGuidance();
    }

    @Given("a user has items in their cart and abandons the checkout process")
    public void aUserHasItemsInTheirCartAndAbandonsTheCheckoutProcess() {
        abandonCheckoutProcess();
    }

    @Then("an abandoned cart notification must be sent to the user")
    public void anAbandonedCartNotificationMustBeSentToTheUser() {
        verifyAbandonedCartNotification();
    }

    @Given("a user navigates to the checkout page")
    public void aUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("the checkout page must load within 3 seconds")
    public void theCheckoutPageMustLoadWithin3Seconds() {
        verifyCheckoutPageLoadTime(3);
    }

    @Given("a user is entering sensitive information during checkout")
    public void aUserIsEnteringSensitiveInformationDuringCheckout() {
        enterSensitiveInformation();
    }

    @Then("security measures must be in place to protect user data")
    public void securityMeasuresMustBeInPlaceToProtectUserData() {
        verifySecurityMeasures();
    }

    @Given("the checkout process has been implemented")
    public void theCheckoutProcessHasBeenImplemented() {
        implementCheckoutProcess();
    }

    @When("user testing is conducted")
    public void userTestingIsConducted() {
        conductUserTesting();
    }

    @Then("the testing should validate the efficiency of the checkout process")
    public void theTestingShouldValidateTheEfficiencyOfTheCheckoutProcess() {
        validateCheckoutProcessEfficiency();
    }
}