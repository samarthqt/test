package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginUser();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed with selected products")
    public void theCartPageIsDisplayedWithSelectedProducts() {
        verifyCartPageDisplayed();
    }

    @Then("products are available in the cart")
    public void productsAreAvailableInTheCart() {
        verifyProductsInCart();
    }

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        verifyUserOnCartPage();
    }

    @Then("products in the cart match the selected items")
    public void productsInTheCartMatchTheSelectedItems() {
        verifyCartItemsMatch();
    }

    @When("the user clicks on 'Proceed to Checkout' button")
    public void theUserClicksOnProceedToCheckoutButton() {
        proceedToCheckout();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyUserOnCheckoutPage();
    }

    @When("the user selects 'Credit Card' as the payment method")
    public void theUserSelectsCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @Then("the Credit Card payment section is displayed")
    public void theCreditCardPaymentSectionIsDisplayed() {
        verifyCreditCardSectionDisplayed();
    }

    @Given("the user is on the Credit Card payment section")
    public void theUserIsOnTheCreditCardPaymentSection() {
        verifyUserOnCreditCardSection();
    }

    @When("the user enters valid credit card details")
    public void theUserEntersValidCreditCardDetails() {
        enterCreditCardDetails();
    }

    @Then("the credit card details are accepted")
    public void theCreditCardDetailsAreAccepted() {
        verifyCreditCardDetailsAccepted();
    }

    @Given("the user has entered valid credit card details")
    public void theUserHasEnteredValidCreditCardDetails() {
        verifyValidCreditCardDetailsEntered();
    }

    @When("the user clicks on 'Pay Now' button")
    public void theUserClicksOnPayNowButton() {
        clickPayNow();
    }

    @Then("the payment is processed")
    public void thePaymentIsProcessed() {
        verifyPaymentProcessed();
    }

    @Then("the confirmation page is displayed")
    public void theConfirmationPageIsDisplayed() {
        verifyConfirmationPageDisplayed();
    }

    @Given("the user is on the confirmation page")
    public void theUserIsOnTheConfirmationPage() {
        verifyUserOnConfirmationPage();
    }

    @Then("the order confirmation message is displayed with order details")
    public void theOrderConfirmationMessageIsDisplayedWithOrderDetails() {
        verifyOrderConfirmationMessage();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedInAgain() {
        loginUser();
    }

    @When("the user checks the order summary in the user account")
    public void theUserChecksTheOrderSummaryInTheUserAccount() {
        checkOrderSummary();
    }

    @Then("the order summary matches the transaction details")
    public void theOrderSummaryMatchesTheTransactionDetails() {
        verifyOrderSummaryMatches();
    }

    @Given("the payment has been processed")
    public void thePaymentHasBeenProcessed() {
        verifyPaymentProcessed();
    }

    @When("the user verifies the payment transaction in the payment gateway")
    public void theUserVerifiesThePaymentTransactionInThePaymentGateway() {
        verifyPaymentTransaction();
    }

    @Then("the transaction is recorded and successful")
    public void theTransactionIsRecordedAndSuccessful() {
        verifyTransactionRecorded();
    }

    @Given("the order has been confirmed")
    public void theOrderHasBeenConfirmed() {
        verifyOrderConfirmed();
    }

    @When("the user checks email for order confirmation")
    public void theUserChecksEmailForOrderConfirmation() {
        checkEmailForOrderConfirmation();
    }

    @Then("the order confirmation email is received with correct details")
    public void theOrderConfirmationEmailIsReceivedWithCorrectDetails() {
        verifyOrderConfirmationEmail();
    }

    @When("the user verifies the order status in the user dashboard")
    public void theUserVerifiesTheOrderStatusInTheUserDashboard() {
        verifyOrderStatusInDashboard();
    }

    @Then("the order status is displayed as 'Processing' or 'Completed'")
    public void theOrderStatusIsDisplayedAsProcessingOrCompleted() {
        verifyOrderStatus();
    }

    @When("the user checks the delivery address details in the order summary")
    public void theUserChecksTheDeliveryAddressDetailsInTheOrderSummary() {
        checkDeliveryAddressDetails();
    }

    @Then("the correct delivery address is displayed")
    public void theCorrectDeliveryAddressIsDisplayed() {
        verifyDeliveryAddress();
    }

    @When("the user verifies if the loyalty points or discounts were applied correctly")
    public void theUserVerifiesIfTheLoyaltyPointsOrDiscountsWereAppliedCorrectly() {
        verifyLoyaltyPointsOrDiscounts();
    }

    @Then("loyalty points/discounts are correctly applied to the order")
    public void loyaltyPointsDiscountsAreCorrectlyAppliedToTheOrder() {
        verifyLoyaltyPointsDiscountsApplied();
    }

    @When("the user checks for 'Print Receipt' option")
    public void theUserChecksForPrintReceiptOption() {
        checkPrintReceiptOption();
    }

    @Then("'Print Receipt' option is available and functional")
    public void printReceiptOptionIsAvailableAndFunctional() {
        verifyPrintReceiptOption();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("order details persist after logging back in")
    public void orderDetailsPersistAfterLoggingBackIn() {
        verifyOrderDetailsPersistence();
    }
}