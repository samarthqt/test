package com.cucumber.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;
import com.pageobjects.OrderHistoryPage;
import com.pageobjects.CheckoutPage;

public class ViewOrderStatusSteps {

    private OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the order history page")
    public void theUserIsOnTheOrderHistoryPage() {
        orderHistoryPage.navigateToOrderHistory();
    }

    @When("the user views the list of past orders")
    public void theUserViewsTheListOfPastOrders() {
        orderHistoryPage.verifyOrderHistoryDisplayed();
    }

    @Then("the order history should display previous orders")
    public void theOrderHistoryShouldDisplayPreviousOrders() {
        orderHistoryPage.verifyOrderHistoryDisplayed();
    }

    @When("the user selects an order with order ID {string}")
    public void theUserSelectsAnOrderWithOrderID(String orderID) {
        orderHistoryPage.selectOrder(orderID);
    }

    @Then("the user should see the details of the selected order")
    public void theUserShouldSeeTheDetailsOfTheSelectedOrder() {
        orderHistoryPage.verifyOrderDetailsDisplayed();
    }

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        String productName = testHarness.getData("CartData", "ProductName");
        String quantity = testHarness.getData("CartData", "Quantity");
        // Assuming a method addProductToCart exists in the context
        // addProductToCart(productName, quantity);
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        checkoutPage.proceedToCheckout();
    }

    @When("the user enters valid shipping details")
    public void theUserEntersValidShippingDetails() {
        String fullName = testHarness.getData("CheckoutData", "FullName");
        String address = testHarness.getData("CheckoutData", "Address");
        String city = testHarness.getData("CheckoutData", "City");
        String postalCode = testHarness.getData("CheckoutData", "PostalCode");
        String phone = testHarness.getData("CheckoutData", "Phone");
        checkoutPage.enterShippingDetails(fullName, address, city, postalCode, phone);
    }

    @When("the user selects a payment method")
    public void theUserSelectsAPaymentMethod() {
        String paymentMethod = testHarness.getData("CheckoutData", "PaymentMethod");
        checkoutPage.selectPaymentMethod(paymentMethod);
    }

    @When("the user places the order")
    public void theUserPlacesTheOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the user should see an order confirmation message")
    public void theUserShouldSeeAnOrderConfirmationMessage() {
        String expectedMessage = testHarness.getData("CheckoutData", "ExpectedConfirmationMessage");
        checkoutPage.verifyOrderConfirmation(expectedMessage);
    }
}
