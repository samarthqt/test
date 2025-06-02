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

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToShoppingCart();
    }

    @Then("the shopping cart page displays items added to the cart")
    public void theShoppingCartPageDisplaysItemsAddedToTheCart() {
        verifyItemsInCart();
    }

    @Given("items are added to the shopping cart")
    public void itemsAreAddedToTheShoppingCart() {
        addItemsToCart();
    }

    @Then("all items in the cart should be listed with correct name, price, quantity, and subtotal")
    public void allItemsInTheCartShouldBeListedWithCorrectDetails() {
        verifyCartDetails();
    }

    @When("the user clicks on the 'Proceed to Checkout' button")
    public void theUserClicksOnTheProceedToCheckoutButton() {
        proceedToCheckout();
    }

    @Then("the user is redirected to the checkout page")
    public void theUserIsRedirectedToTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @When("the user enters valid shipping information")
    public void theUserEntersValidShippingInformation() {
        enterShippingInformation();
    }

    @Then("the shipping information is accepted and saved")
    public void theShippingInformationIsAcceptedAndSaved() {
        verifyShippingInformationSaved();
    }

    @When("the user enters valid billing information")
    public void theUserEntersValidBillingInformation() {
        enterBillingInformation();
    }

    @Then("the billing information is accepted and saved")
    public void theBillingInformationIsAcceptedAndSaved() {
        verifyBillingInformationSaved();
    }

    @When("the user selects a payment method")
    public void theUserSelectsAPaymentMethod() {
        selectPaymentMethod();
    }

    @Then("the payment method is selected and accepted")
    public void thePaymentMethodIsSelectedAndAccepted() {
        verifyPaymentMethodAccepted();
    }

    @When("the user reviews the order summary")
    public void theUserReviewsTheOrderSummary() {
        reviewOrderSummary();
    }

    @Then("the order summary displays correct items, quantities, prices, and totals")
    public void theOrderSummaryDisplaysCorrectDetails() {
        verifyOrderSummaryDetails();
    }

    @When("the user clicks on the 'Place Order' button")
    public void theUserClicksOnThePlaceOrderButton() {
        placeOrder();
    }

    @Then("the order is successfully placed and a confirmation message is displayed")
    public void theOrderIsSuccessfullyPlaced() {
        verifyOrderConfirmation();
    }

    @Then("a confirmation email is received with order details")
    public void aConfirmationEmailIsReceived() {
        verifyConfirmationEmail();
    }

    @Then("the order appears in the order history with correct details")
    public void theOrderAppearsInOrderHistory() {
        verifyOrderInHistory();
    }

    @Then("the order status is visible and can be tracked from the dashboard")
    public void theOrderStatusIsVisible() {
        verifyOrderStatus();
    }

    @Then("the shopping cart is empty and ready for new items")
    public void theShoppingCartIsEmpty() {
        verifyCartIsEmpty();
    }

    @When("the user navigates back to the homepage")
    public void theUserNavigatesBackToTheHomepage() {
        navigateToHomepage();
    }

    @Then("the user can return using the home button or logo")
    public void theUserCanReturnToHomepage() {
        verifyReturnToHomepage();
    }

    @Then("the checkout process is secure and uses encryption protocols")
    public void theCheckoutProcessIsSecure() {
        verifyCheckoutSecurity();
    }

    @When("the user adds new items to the cart")
    public void theUserAddsNewItemsToTheCart() {
        addNewItemsToCart();
    }

    @Then("the user can add new items without issues")
    public void theUserCanAddNewItems() {
        verifyNewItemsAdded();
    }
}