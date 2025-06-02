package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in with valid credentials")
    public void theUserIsLoggedInWithValidCredentials() {
        loginWithValidCredentials();
    }

    @Given("the user has a valid payment method saved")
    public void theUserHasAValidPaymentMethodSaved() {
        verifySavedPaymentMethod();
    }

    @When("the user adds a product to the shopping cart")
    public void theUserAddsAProductToTheShoppingCart() {
        addProductToCart();
    }

    @When("proceeds to the checkout page")
    public void proceedsToTheCheckoutPage() {
        proceedToCheckout();
    }

    @When("enters valid shipping address details")
    public void entersValidShippingAddressDetails() {
        enterShippingDetails();
    }

    @When("selects a valid payment method")
    public void selectsAValidPaymentMethod() {
        selectPaymentMethod();
    }

    @When("confirms the order")
    public void confirmsTheOrder() {
        confirmOrder();
    }

    @Then("the user should receive an order confirmation message")
    public void theUserShouldReceiveAnOrderConfirmationMessage() {
        verifyOrderConfirmationMessage();
    }

    @Then("the checkout should be completed with minimal steps")
    public void theCheckoutShouldBeCompletedWithMinimalSteps() {
        verifyMinimalSteps();
    }

    @Given("the server is under high load")
    public void theServerIsUnderHighLoad() {
        simulateHighServerLoad();
    }

    @When("the user completes the checkout process")
    public void theUserCompletesTheCheckoutProcess() {
        completeCheckoutProcess();
    }

    @Then("the checkout should remain responsive and functional")
    public void theCheckoutShouldRemainResponsiveAndFunctional() {
        verifyCheckoutResponsiveness();
    }

    @When("the user accesses the checkout page")
    public void theUserAccessesTheCheckoutPage() {
        accessCheckoutPage();
    }

    @Then("all fields should be pre-filled with user's saved data for quick checkout")
    public void allFieldsShouldBePreFilledWithUsersSavedDataForQuickCheckout() {
        verifyPrefilledFields();
    }

    @Given("the user is logged in with valid credentials on a mobile device")
    public void theUserIsLoggedInWithValidCredentialsOnAMobileDevice() {
        loginOnMobileDevice();
    }

    @Then("the checkout process should be seamless on mobile devices")
    public void theCheckoutProcessShouldBeSeamlessOnMobileDevices() {
        verifyMobileCheckoutSeamlessness();
    }

    @When("the user enters invalid payment details during checkout")
    public void theUserEntersInvalidPaymentDetailsDuringCheckout() {
        enterInvalidPaymentDetails();
    }

    @Then("the system should provide appropriate error messages for invalid payment details")
    public void theSystemShouldProvideAppropriateErrorMessagesForInvalidPaymentDetails() {
        verifyErrorMessagesForInvalidPayment();
    }

    @When("the user selects different payment methods during checkout")
    public void theUserSelectsDifferentPaymentMethodsDuringCheckout() {
        selectDifferentPaymentMethods();
    }

    @Then("the checkout should be successful with various payment methods")
    public void theCheckoutShouldBeSuccessfulWithVariousPaymentMethods() {
        verifySuccessfulCheckoutWithDifferentMethods();
    }

    @When("the user proceeds to confirm the order")
    public void theUserProceedsToConfirmTheOrder() {
        proceedToOrderConfirmation();
    }

    @Then("the order summary should be displayed clearly before confirmation")
    public void theOrderSummaryShouldBeDisplayedClearlyBeforeConfirmation() {
        verifyOrderSummaryDisplay();
    }

    @Given("multiple items are added to the shopping cart")
    public void multipleItemsAreAddedToTheShoppingCart() {
        addMultipleItemsToCart();
    }

    @Then("the checkout process should handle multiple items efficiently")
    public void theCheckoutProcessShouldHandleMultipleItemsEfficiently() {
        verifyMultipleItemsCheckout();
    }
}