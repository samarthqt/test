package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginUser();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed with maximum allowable items")
    public void theCartPageIsDisplayedWithMaximumAllowableItems() {
        verifyMaxItemsInCart();
    }

    @Given("the cart is filled with maximum allowable items")
    public void theCartIsFilledWithMaximumAllowableItems() {
        fillCartWithMaxItems();
    }

    @When("the user checks the number of items in the cart")
    public void theUserChecksTheNumberOfItemsInTheCart() {
        checkNumberOfItemsInCart();
    }

    @Then("the cart displays the maximum allowable number of items")
    public void theCartDisplaysTheMaximumAllowableNumberOfItems() {
        verifyMaxItemsDisplayed();
    }

    @Given("the user is on the cart page with maximum allowable items")
    public void theUserIsOnTheCartPageWithMaximumAllowableItems() {
        navigateToCartPageWithMaxItems();
    }

    @When("the user clicks on 'Proceed to Checkout' button")
    public void theUserClicksOnProceedToCheckoutButton() {
        clickProceedToCheckout();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user enters valid shipping information")
    public void theUserEntersValidShippingInformation() {
        enterValidShippingInformation();
    }

    @Then("the shipping information is accepted")
    public void theShippingInformationIsAccepted() {
        verifyShippingInformationAccepted();
    }

    @When("the user selects a payment method and enters valid payment details")
    public void theUserSelectsAPaymentMethodAndEntersValidPaymentDetails() {
        selectPaymentMethodAndEnterDetails();
    }

    @Then("the payment details are accepted")
    public void thePaymentDetailsAreAccepted() {
        verifyPaymentDetailsAccepted();
    }

    @Given("the user has entered valid payment details")
    public void theUserHasEnteredValidPaymentDetails() {
        enterValidPaymentDetails();
    }

    @When("the user clicks on 'Pay Now' button")
    public void theUserClicksOnPayNowButton() {
        clickPayNow();
    }

    @Then("the payment is processed without performance issues")
    public void thePaymentIsProcessedWithoutPerformanceIssues() {
        verifyPaymentProcessed();
    }

    @Given("the payment is processed")
    public void thePaymentIsProcessed() {
        processPayment();
    }

    @When("the user checks for the order confirmation message")
    public void theUserChecksForTheOrderConfirmationMessage() {
        checkOrderConfirmationMessage();
    }

    @Then("the order confirmation message is displayed with order details")
    public void theOrderConfirmationMessageIsDisplayedWithOrderDetails() {
        verifyOrderConfirmationMessage();
    }

    @Given("the order is confirmed")
    public void theOrderIsConfirmed() {
        confirmOrder();
    }

    @When("the user checks the order summary in the user account")
    public void theUserChecksTheOrderSummaryInTheUserAccount() {
        checkOrderSummaryInAccount();
    }

    @Then("the order summary matches the transaction details")
    public void theOrderSummaryMatchesTheTransactionDetails() {
        verifyOrderSummaryMatches();
    }

    @Given("the checkout process is completed")
    public void theCheckoutProcessIsCompleted() {
        completeCheckoutProcess();
    }

    @When("the user verifies system performance metrics")
    public void theUserVerifiesSystemPerformanceMetrics() {
        verifySystemPerformanceMetrics();
    }

    @Then("the system performance metrics are within acceptable limits")
    public void theSystemPerformanceMetricsAreWithinAcceptableLimits() {
        verifyPerformanceMetricsLimits();
    }

    @When("the user checks their email for order confirmation")
    public void theUserChecksTheirEmailForOrderConfirmation() {
        checkEmailForOrderConfirmation();
    }

    @Then("the order confirmation email is received with correct details")
    public void theOrderConfirmationEmailIsReceivedWithCorrectDetails() {
        verifyOrderConfirmationEmail();
    }

    @When("the user checks the order status in the user dashboard")
    public void theUserChecksTheOrderStatusInTheUserDashboard() {
        checkOrderStatusInDashboard();
    }

    @Then("the order status is displayed as 'Processing' or 'Completed'")
    public void theOrderStatusIsDisplayedAsProcessingOrCompleted() {
        verifyOrderStatus();
    }

    @When("the user checks the delivery address details in the order summary")
    public void theUserChecksTheDeliveryAddressDetailsInTheOrderSummary() {
        checkDeliveryAddressInSummary();
    }

    @Then("the correct delivery address is displayed")
    public void theCorrectDeliveryAddressIsDisplayed() {
        verifyDeliveryAddress();
    }

    @When("the user verifies if loyalty points or discounts were applied")
    public void theUserVerifiesIfLoyaltyPointsOrDiscountsWereApplied() {
        verifyLoyaltyPointsOrDiscounts();
    }

    @Then("the loyalty points/discounts are correctly applied to the order")
    public void theLoyaltyPointsDiscountsAreCorrectlyAppliedToTheOrder() {
        verifyPointsOrDiscountsApplied();
    }

    @When("the user looks for the 'Print Receipt' option")
    public void theUserLooksForThePrintReceiptOption() {
        checkPrintReceiptOption();
    }

    @Then("the 'Print Receipt' option is available and functional")
    public void thePrintReceiptOptionIsAvailableAndFunctional() {
        verifyPrintReceiptOption();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the order details persist after logging back in")
    public void theOrderDetailsPersistAfterLoggingBackIn() {
        verifyOrderDetailsPersistence();
    }
}