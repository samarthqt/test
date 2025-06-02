package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("User has items in the shopping cart")
    public void userHasItemsInTheShoppingCart() {
        addItemsToCart();
    }

    @When("User navigates to the shopping cart page")
    public void userNavigatesToTheShoppingCartPage() {
        navigateToShoppingCart();
    }

    @Then("Shopping cart page is displayed with items listed")
    public void shoppingCartPageIsDisplayedWithItemsListed() {
        verifyItemsInCart();
    }

    @Then("Payment methods available are Credit Card, PayPal, Gift Card")
    public void paymentMethodsAvailableAreCreditCardPayPalGiftCard() {
        verifyPaymentMethods();
    }

    @Given("User clicks on the 'Proceed to Checkout' button")
    public void userClicksOnTheProceedToCheckoutButton() {
        proceedToCheckout();
    }

    @Then("Checkout page is displayed with payment options")
    public void checkoutPageIsDisplayedWithPaymentOptions() {
        verifyCheckoutPage();
    }

    @When("User selects {string} as the payment method")
    public void userSelectsAsThePaymentMethod(String paymentMethod) {
        selectPaymentMethod(paymentMethod);
    }

    @When("User enters valid {string} details")
    public void userEntersValidDetails(String paymentMethod) {
        enterPaymentDetails(paymentMethod);
    }

    @When("User clicks on 'Pay Now' button")
    public void userClicksOnPayNowButton() {
        clickPayNow();
    }

    @Then("Payment is processed successfully using {string}")
    public void paymentIsProcessedSuccessfullyUsing(String paymentMethod) {
        verifyPaymentSuccess(paymentMethod);
    }

    @Then("Confirmation message is displayed")
    public void confirmationMessageIsDisplayed() {
        verifyConfirmationMessage();
    }

    @Given("Payment is processed successfully")
    public void paymentIsProcessedSuccessfully() {
        verifyPaymentProcessed();
    }

    @When("User verifies the order summary and payment details")
    public void userVerifiesTheOrderSummaryAndPaymentDetails() {
        verifyOrderSummaryAndPaymentDetails();
    }

    @Then("Order summary and payment details are accurate and correspond to the selected payment method")
    public void orderSummaryAndPaymentDetailsAreAccurateAndCorrespondToTheSelectedPaymentMethod() {
        verifyOrderSummaryAccuracy();
    }

    @Given("User has completed the checkout process")
    public void userHasCompletedTheCheckoutProcess() {
        verifyCheckoutCompletion();
    }

    @When("User logs out from the user account")
    public void userLogsOutFromTheUserAccount() {
        logoutUserAccount();
    }

    @Then("User is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }
}