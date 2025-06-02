package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        addItemsToCart();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToShoppingCartPage();
    }

    @Then("the shopping cart page is displayed with items listed")
    public void theShoppingCartPageIsDisplayedWithItemsListed() {
        verifyItemsListedInCart();
    }

    @When("the user clicks on the 'Proceed to Checkout' button")
    public void theUserClicksOnTheProceedToCheckoutButton() {
        proceedToCheckout();
    }

    @Then("the checkout page is displayed with payment options")
    public void theCheckoutPageIsDisplayedWithPaymentOptions() {
        verifyCheckoutPageDisplayed();
    }

    @Then("additional payment methods \(Apple Pay, Google Pay\) are displayed as options")
    public void additionalPaymentMethodsAreDisplayedAsOptions() {
        verifyAdditionalPaymentMethods();
    }

    @Given("the user is on the checkout page with payment options")
    public void theUserIsOnTheCheckoutPageWithPaymentOptions() {
        verifyCheckoutPageWithPaymentOptions();
    }

    @When("the user selects 'Apple Pay' as the payment method")
    public void theUserSelectsApplePayAsThePaymentMethod() {
        selectPaymentMethod("Apple Pay");
    }

    @Then("'Apple Pay' option is selected")
    public void applePayOptionIsSelected() {
        verifyPaymentMethodSelected("Apple Pay");
    }

    @When("the user completes the payment using Apple Pay")
    public void theUserCompletesThePaymentUsingApplePay() {
        completePaymentUsingApplePay();
    }

    @Then("the payment is processed successfully using Apple Pay")
    public void thePaymentIsProcessedSuccessfullyUsingApplePay() {
        verifyPaymentProcessedSuccessfully("Apple Pay");
    }

    @Then("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @When("the user selects 'Google Pay' as the payment method")
    public void theUserSelectsGooglePayAsThePaymentMethod() {
        selectPaymentMethod("Google Pay");
    }

    @Then("'Google Pay' option is selected")
    public void googlePayOptionIsSelected() {
        verifyPaymentMethodSelected("Google Pay");
    }

    @When("the user completes the payment using Google Pay")
    public void theUserCompletesThePaymentUsingGooglePay() {
        completePaymentUsingGooglePay();
    }

    @Then("the payment is processed successfully using Google Pay")
    public void thePaymentIsProcessedSuccessfullyUsingGooglePay() {
        verifyPaymentProcessedSuccessfully("Google Pay");
    }

    @Given("the user has completed a payment")
    public void theUserHasCompletedAPayment() {
        verifyPaymentCompletion();
    }

    @When("the user verifies the order summary and payment details")
    public void theUserVerifiesTheOrderSummaryAndPaymentDetails() {
        verifyOrderSummaryAndPaymentDetails();
    }

    @Then("the order summary and payment details are accurate and correspond to the selected payment method")
    public void theOrderSummaryAndPaymentDetailsAreAccurateAndCorrespondToTheSelectedPaymentMethod() {
        verifyOrderSummaryAccuracy();
    }

    @Given("the user has completed their activities")
    public void theUserHasCompletedTheirActivities() {
        verifyUserActivitiesCompletion();
    }

    @When("the user logs out from the user account")
    public void theUserLogsOutFromTheUserAccount() {
        logoutFromUserAccount();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }
}