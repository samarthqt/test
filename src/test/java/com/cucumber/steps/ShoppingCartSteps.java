package com.cucumber.steps;

import com.pageobjects.CartPage;
import com.pageobjects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.framework.cucumber.TestHarness;

public class ShoppingCartSteps {

    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the product details page")
    public void theUserIsOnTheProductDetailsPage() {
        String productName = testHarness.getData("ProductData", "ProductName");
        cartPage.navigateToProductPage(productName);
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        cartPage.addProductToCart();
    }

    @Then("the cart should contain the added product")
    public void theCartShouldContainTheAddedProduct() {
        String expectedProductName = testHarness.getData("ProductData", "ProductName");
        cartPage.openCart();
        cartPage.verifyProductInCart(expectedProductName);
    }

    @Given("the user has a product in the cart")
    public void theUserHasAProductInTheCart() {
        String productName = testHarness.getData("ProductData", "ProductName");
        cartPage.addProductToCart();
        cartPage.openCart();
        cartPage.verifyProductInCart(productName);
    }

    @When("the user updates the quantity to {string}")
    public void theUserUpdatesTheQuantityTo(String quantity) {
        cartPage.updateProductQuantity(quantity);
    }

    @Then("the cart should reflect the updated quantity")
    public void theCartShouldReflectTheUpdatedQuantity() {
        String expectedQuantity = testHarness.getData("CartData", "Quantity");
        cartPage.verifyProductQuantity(expectedQuantity);
    }

    @When("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        cartPage.removeProductFromCart();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        cartPage.verifyCartIsEmpty();
    }

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        String productName = testHarness.getData("CartData", "ProductName");
        String quantity = testHarness.getData("CartData", "Quantity");
        cartPage.addProductToCart(productName, quantity);
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
