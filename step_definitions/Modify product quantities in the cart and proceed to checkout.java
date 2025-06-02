package com.cucumber.steps;

import com.page_objects.CartPage;
import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps extends CartPage {

    @Given("the user is logged into the shopping platform")
    public void theUserIsLoggedIntoTheShoppingPlatform() {
        loginToPlatform();
    }

    @Given("products are added to the cart")
    public void productsAreAddedToTheCart() {
        addProductsToCart();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        openCart();
    }

    @Then("the cart page is displayed with all added products")
    public void theCartPageIsDisplayedWithAllAddedProducts() {
        verifyCartPageDisplayed();
    }

    @Given("{string} is in the cart with quantity {string}")
    public void productIsInTheCartWithQuantity(String productName, String quantity) {
        verifyProductInCartWithQuantity(productName, quantity);
    }

    @When("the user modifies the quantity of {string} to {string}")
    public void theUserModifiesTheQuantityOfProductTo(String productName, String newQuantity) {
        modifyProductQuantity(productName, newQuantity);
    }

    @Then("the quantity for {string} is updated to {string}")
    public void theQuantityForProductIsUpdatedTo(String productName, String expectedQuantity) {
        verifyProductQuantity(productName, expectedQuantity);
    }

    @Then("the subtotal reflects the change")
    public void theSubtotalReflectsTheChange() {
        verifySubtotalUpdated();
    }

    @When("the user reviews the cart")
    public void theUserReviewsTheCart() {
        reviewCart();
    }

    @Then("the total amount reflects the updated quantities and subtotals")
    public void theTotalAmountReflectsTheUpdatedQuantitiesAndSubtotals() {
        verifyTotalAmount();
    }

    @When("the user clicks on the 'Proceed to Checkout' button")
    public void theUserClicksOnTheProceedToCheckoutButton() {
        proceedToCheckout();
    }

    @Then("the user is directed to the checkout page successfully")
    public void theUserIsDirectedToTheCheckoutPageSuccessfully() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @Then("all cart items and their quantities are displayed correctly")
    public void allCartItemsAndTheirQuantitiesAreDisplayedCorrectly() {
        verifyCartItemsOnCheckoutPage();
    }

    @When("the user enters valid shipping information on the checkout page")
    public void theUserEntersValidShippingInformationOnTheCheckoutPage() {
        enterValidShippingInformation();
    }

    @Then("the shipping information is accepted and saved successfully")
    public void theShippingInformationIsAcceptedAndSavedSuccessfully() {
        verifyShippingInformationSaved();
    }

    @When("the user selects a payment method and enters valid payment details")
    public void theUserSelectsAPaymentMethodAndEntersValidPaymentDetails() {
        selectPaymentMethodAndEnterDetails();
    }

    @Then("the payment details are accepted and ready for processing")
    public void thePaymentDetailsAreAcceptedAndReadyForProcessing() {
        verifyPaymentDetailsAccepted();
    }

    @When("the user clicks on the 'Confirm Purchase' button")
    public void theUserClicksOnTheConfirmPurchaseButton() {
        confirmPurchase();
    }

    @Then("the purchase is confirmed and an order confirmation message is displayed")
    public void thePurchaseIsConfirmedAndAnOrderConfirmationMessageIsDisplayed() {
        verifyOrderConfirmationMessage();
    }

    @When("the purchase is confirmed")
    public void thePurchaseIsConfirmed() {
        verifyPurchaseConfirmed();
    }

    @Then("the order confirmation email is received with all order details")
    public void theOrderConfirmationEmailIsReceivedWithAllOrderDetails() {
        verifyOrderConfirmationEmail();
    }

    @When("the user checks the order history")
    public void theUserChecksTheOrderHistory() {
        checkOrderHistory();
    }

    @Then("the order appears in the order history with correct details")
    public void theOrderAppearsInTheOrderHistoryWithCorrectDetails() {
        verifyOrderInHistory();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the order is still present in the order history")
    public void theOrderIsStillPresentInTheOrderHistory() {
        verifyOrderStillInHistory();
    }

    @When("the user attempts to modify the order after checkout")
    public void theUserAttemptsToModifyTheOrderAfterCheckout() {
        attemptToModifyOrder();
    }

    @Then("the system does not allow modifications and prompts a message")
    public void theSystemDoesNotAllowModificationsAndPromptsAMessage() {
        verifyModificationNotAllowed();
    }

    @When("the user proceeds through the checkout process")
    public void theUserProceedsThroughTheCheckoutProcess() {
        proceedThroughCheckout();
    }

    @Then("the system responds quickly and efficiently")
    public void theSystemRespondsQuicklyAndEfficiently() {
        verifySystemResponseTime();
    }
}