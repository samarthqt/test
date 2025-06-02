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

    @Given("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page displays 50 items with IDs ranging from 201 to 250")
    public void theCartPageDisplaysItems() {
        verifyCartItemsRange(201, 250);
    }

    @Then("the cart contains the maximum allowed number of items")
    public void theCartContainsMaximumItems() {
        verifyMaximumCartItems();
    }

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart correctly lists 50 items")
    public void theCartCorrectlyListsItems() {
        verifyCartItemCount(50);
    }

    @Then("the item IDs range from 201 to 250")
    public void theItemIDsRange() {
        verifyCartItemsRange(201, 250);
    }

    @Given("the user is on the cart page with 50 items")
    public void theUserIsOnTheCartPageWithItems() {
        navigateToCartPage();
        verifyCartItemCount(50);
    }

    @When("the user clicks on the 'Proceed to Checkout' button")
    public void theUserClicksProceedToCheckout() {
        proceedToCheckout();
    }

    @Then("the user is redirected to the checkout page")
    public void theUserIsRedirectedToCheckoutPage() {
        verifyCheckoutPage();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @When("the user enters valid shipping information")
    public void theUserEntersValidShippingInformation() {
        enterShippingDetails("John Doe", "123 Main St", "Cityville", "12345", "1234567890");
    }

    @Then("the shipping information is accepted without errors")
    public void theShippingInformationIsAccepted() {
        verifyShippingDetailsAccepted();
    }

    @When("the user enters valid billing information")
    public void theUserEntersValidBillingInformation() {
        enterBillingDetails("John Doe", "123 Main St", "Cityville", "12345", "1234567890");
    }

    @Then("the billing information is accepted without errors")
    public void theBillingInformationIsAccepted() {
        verifyBillingDetailsAccepted();
    }

    @Given("the user has entered valid shipping and billing information")
    public void theUserHasEnteredValidInformation() {
        enterShippingDetails("John Doe", "123 Main St", "Cityville", "12345", "1234567890");
        enterBillingDetails("John Doe", "123 Main St", "Cityville", "12345", "1234567890");
    }

    @When("the user reviews the order summary")
    public void theUserReviewsOrderSummary() {
        reviewOrderSummary();
    }

    @Then("the order summary displays all 50 items and correct total cost")
    public void theOrderSummaryDisplaysItemsAndCost() {
        verifyOrderSummaryDetails(50);
    }

    @Given("the user has reviewed the order summary")
    public void theUserHasReviewedOrderSummary() {
        reviewOrderSummary();
    }

    @When("the user clicks on 'Confirm Order'")
    public void theUserClicksConfirmOrder() {
        confirmOrder();
    }

    @Then("the order is successfully confirmed")
    public void theOrderIsSuccessfullyConfirmed() {
        verifyOrderConfirmation();
    }

    @Given("the order is confirmed")
    public void theOrderIsConfirmed() {
        verifyOrderConfirmation();
    }

    @Then("the confirmation message reads: 'Your order has been placed successfully.'")
    public void theConfirmationMessageReads() {
        verifyConfirmationMessage("Your order has been placed successfully.");
    }

    @Then("the user receives an order confirmation email with correct details")
    public void theUserReceivesOrderConfirmationEmail() {
        verifyOrderConfirmationEmail();
    }

    @Then("the order is listed in the user's order history with correct details")
    public void theOrderIsListedInOrderHistory() {
        verifyOrderInHistory();
    }

    @Then("the payment method is correctly recorded")
    public void thePaymentMethodIsCorrectlyRecorded() {
        verifyPaymentMethod();
    }

    @Then("the cart is empty after successful checkout")
    public void theCartIsEmptyAfterCheckout() {
        verifyCartIsEmpty();
    }

    @Given("the cart is empty post-checkout")
    public void theCartIsEmptyPostCheckout() {
        verifyCartIsEmpty();
    }

    @When("the user attempts to add more items to the cart")
    public void theUserAttemptsToAddMoreItems() {
        addItemsToCart();
    }

    @Then("items can be added to the cart again")
    public void itemsCanBeAddedToCartAgain() {
        verifyItemsCanBeAdded();
    }

    @Then("the shipping tracking information is available and accurate")
    public void theShippingTrackingInformationIsAvailable() {
        verifyShippingTrackingInformation();
    }

    @Given("the user is checking out")
    public void theUserIsCheckingOut() {
        proceedToCheckout();
    }

    @Then("the system performs efficiently without lag")
    public void theSystemPerformsEfficiently() {
        verifySystemPerformance();
    }
}