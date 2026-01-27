package com.cucumber.steps;
import com.pageobjects.CheckoutPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        String productName = testHarness.getData("CartData", "ProductName");
        String quantity = testHarness.getData("CartData", "Quantity");
        addProductToCart(productName, quantity);
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @When("the user enters valid shipping details")
    public void theUserEntersValidShippingDetails() {
        String fullName = testHarness.getData("CheckoutData", "FullName");
        String address = testHarness.getData("CheckoutData", "Address");
        String city = testHarness.getData("CheckoutData", "City");
        String postalCode = testHarness.getData("CheckoutData", "PostalCode");
        String phone = testHarness.getData("CheckoutData", "Phone");
        enterShippingDetails(fullName, address, city, postalCode, phone);
    }

    @When("the user selects a payment method")
    public void theUserSelectsAPaymentMethod() {
        String paymentMethod = testHarness.getData("CheckoutData", "PaymentMethod");
        selectPaymentMethod(paymentMethod);
    }

    @When("the user places the order")
    public void theUserPlacesTheOrder() {
        placeOrder();
    }

    @Then("the user should see an order confirmation message")
    public void theUserShouldSeeAnOrderConfirmationMessage() {
        String expectedMessage = testHarness.getData("CheckoutData", "ExpectedConfirmationMessage");
        verifyOrderConfirmation(expectedMessage);
    }
}