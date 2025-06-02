package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has access to the account")
    public void theUserHasAccessToTheAccount() {
        loginToAccount();
    }

    @When("the user logs into the account")
    public void theUserLogsIntoTheAccount() {
        loginToAccount();
    }

    @Then("the user is logged into the account")
    public void theUserIsLoggedIntoTheAccount() {
        verifyUserLoggedIn();
    }

    @Then("the cart contains the maximum allowed items")
    public void theCartContainsTheMaximumAllowedItems() {
        verifyCartContainsMaxItems();
    }

    @When("the user adds the maximum number of items allowed to the shopping cart")
    public void theUserAddsTheMaximumNumberOfItemsAllowedToTheShoppingCart() {
        addMaxItemsToCart();
    }

    @Then("the maximum number of items are added to the cart")
    public void theMaximumNumberOfItemsAreAddedToTheCart() {
        verifyMaxItemsAddedToCart();
    }

    @When("the user navigates to the shopping cart")
    public void theUserNavigatesToTheShoppingCart() {
        navigateToShoppingCart();
    }

    @Then("the shopping cart is displayed with maximum items")
    public void theShoppingCartIsDisplayedWithMaximumItems() {
        verifyShoppingCartDisplayedWithMaxItems();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user enters valid shipping address details")
    public void theUserEntersValidShippingAddressDetails() {
        enterValidShippingAddressDetails();
    }

    @Then("the shipping address details are entered correctly")
    public void theShippingAddressDetailsAreEnteredCorrectly() {
        verifyShippingAddressDetailsEntered();
    }

    @When("the user enters valid billing information")
    public void theUserEntersValidBillingInformation() {
        enterValidBillingInformation();
    }

    @Then("the billing information is entered correctly")
    public void theBillingInformationIsEnteredCorrectly() {
        verifyBillingInformationEntered();
    }

    @When("the user selects payment method and enters payment details")
    public void theUserSelectsPaymentMethodAndEntersPaymentDetails() {
        selectPaymentMethodAndEnterDetails();
    }

    @Then("the payment method and details are entered correctly")
    public void thePaymentMethodAndDetailsAreEnteredCorrectly() {
        verifyPaymentMethodAndDetailsEntered();
    }

    @When("the user reviews order summary and verifies total price")
    public void theUserReviewsOrderSummaryAndVerifiesTotalPrice() {
        reviewOrderSummaryAndVerifyTotalPrice();
    }

    @Then("the order summary and total price are displayed correctly")
    public void theOrderSummaryAndTotalPriceAreDisplayedCorrectly() {
        verifyOrderSummaryAndTotalPriceDisplayed();
    }

    @When("the user agrees to terms and conditions")
    public void theUserAgreesToTermsAndConditions() {
        agreeToTermsAndConditions();
    }

    @Then("the terms and conditions are agreed to")
    public void theTermsAndConditionsAreAgreedTo() {
        verifyTermsAndConditionsAgreed();
    }

    @When("the user clicks 'Place Order' button")
    public void theUserClicksPlaceOrderButton() {
        clickPlaceOrderButton();
    }

    @Then("the order is placed successfully")
    public void theOrderIsPlacedSuccessfully() {
        verifyOrderPlacedSuccessfully();
    }

    @When("the user verifies order confirmation")
    public void theUserVerifiesOrderConfirmation() {
        verifyOrderConfirmation();
    }

    @Then("the order confirmation is displayed with order details")
    public void theOrderConfirmationIsDisplayedWithOrderDetails() {
        verifyOrderConfirmationDisplayedWithDetails();
    }

    @When("the user checks email for order confirmation receipt")
    public void theUserChecksEmailForOrderConfirmationReceipt() {
        checkEmailForOrderConfirmationReceipt();
    }

    @Then("the order confirmation receipt is received via email")
    public void theOrderConfirmationReceiptIsReceivedViaEmail() {
        verifyOrderConfirmationReceiptReceived();
    }

    @When("the user verifies order details in the user account order history")
    public void theUserVerifiesOrderDetailsInTheUserAccountOrderHistory() {
        verifyOrderDetailsInOrderHistory();
    }

    @Then("the order details are correctly displayed in order history")
    public void theOrderDetailsAreCorrectlyDisplayedInOrderHistory() {
        verifyOrderDetailsDisplayedInOrderHistory();
    }

    @When("the user checks if the cart is empty after checkout")
    public void theUserChecksIfTheCartIsEmptyAfterCheckout() {
        checkIfCartIsEmptyAfterCheckout();
    }

    @Then("the shopping cart is empty after successful checkout")
    public void theShoppingCartIsEmptyAfterSuccessfulCheckout() {
        verifyCartIsEmptyAfterCheckout();
    }

    @When("the user attempts to add more items to the cart after checkout")
    public void theUserAttemptsToAddMoreItemsToTheCartAfterCheckout() {
        attemptToAddMoreItemsToCartAfterCheckout();
    }

    @Then("items can be added to the cart after checkout")
    public void itemsCanBeAddedToTheCartAfterCheckout() {
        verifyItemsCanBeAddedToCartAfterCheckout();
    }
}