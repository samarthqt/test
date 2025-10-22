package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.framework.cucumber.TestHarness;
import com.pageobjects.OrderPage;
import com.pageobjects.OrderPlacementPage;

public class OrderPlacementSteps {

    private OrderPage orderPage = new OrderPage();
    private OrderPlacementPage orderPlacementPage = new OrderPlacementPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in with User ID {string}")
    public void theUserIsLoggedInWithUserID(String userId) {
        orderPage.loginUser(userId);
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        orderPage.loginUser();
    }

    @When("the user navigates to the product page for Product ID {string}")
    public void theUserNavigatesToTheProductPageForProductID(String productId) {
        orderPage.navigateToProductPage(productId);
    }

    @When("the user navigates to the product page for Product ID {int}")
    public void theUserNavigatesToTheProductPageForProductID(int productId) {
        orderPlacementPage.navigateToProductPage(productId);
    }

    @Then("the product details page is displayed with stock status as {string}")
    public void theProductDetailsPageIsDisplayedWithStockStatusAs(String stockStatus) {
        orderPage.verifyProductStockStatus(stockStatus);
    }

    @Then("the product details page is displayed with stock status as 'Available'")
    public void theProductDetailsPageIsDisplayedWithStockStatusAsAvailable() {
        orderPlacementPage.verifyProductStockStatus("Available");
    }

    @Then("the product details page is displayed with stock status as \"Out of Stock\"")
    public void theProductDetailsPageIsDisplayedWithStockStatusAsOutOfStock() {
        orderPlacementPage.verifyProductStockStatus("Out of Stock");
    }

    @When("the user adds {int} units of the product to the shopping cart")
    public void theUserAddsUnitsOfTheProductToTheShoppingCart(int quantity) {
        orderPlacementPage.addProductToCart(quantity);
    }

    @When("the user adds {int} unit of the product to the shopping cart")
    public void theUserAddsUnitOfTheProductToTheShoppingCart(int quantity) {
        orderPage.addProductToCart(quantity);
    }

    @When("the user adds 1 unit of the product to the shopping cart")
    public void theUserAdds1UnitOfTheProductToTheShoppingCart() {
        orderPage.addProductToCart(1);
    }

    @Then("the product is added to the cart, and the cart is updated with the correct quantity and price")
    public void theProductIsAddedToTheCartAndTheCartIsUpdatedWithTheCorrectQuantityAndPrice() {
        orderPage.verifyCartDetails();
    }

    @Then("the product is added to the cart with the correct quantity and price")
    public void theProductIsAddedToTheCartWithTheCorrectQuantityAndPrice() {
        orderPlacementPage.verifyCartDetails();
    }

    @Then("the product is added to the cart, and the cart is updated with the correct quantity and price")
    public void theProductIsAddedToTheCartAndTheCartIsUpdatedWithTheCorrectQuantityAndPrice() {
        orderPlacementPage.verifyCartDetails();
    }

    @When("the user proceeds to checkout from the shopping cart")
    public void theUserProceedsToCheckoutFromTheShoppingCart() {
        orderPlacementPage.proceedToCheckout();
    }

    @Then("the checkout page is displayed with the correct order details")
    public void theCheckoutPageIsDisplayedWithTheCorrectOrderDetails() {
        orderPlacementPage.verifyCheckoutDetails();
    }

    @Then("the checkout page does not include the out-of-stock item")
    public void theCheckoutPageDoesNotIncludeTheOutOfStockItem() {
        orderPlacementPage.verifyCheckoutExcludesOutOfStockItem();
    }

    @When("the user selects {string} as the payment method")
    public void theUserSelectsAsThePaymentMethod(String paymentMethod) {
        orderPlacementPage.selectPaymentMethod(paymentMethod);
    }

    @When("the user selects Credit Card as the payment method and enters valid payment details")
    public void theUserSelectsCreditCardAsThePaymentMethodAndEntersValidPaymentDetails() {
        orderPlacementPage.selectPaymentMethodAndEnterDetails("Credit Card");
    }

    @When("the user selects {string} as the payment method and enters valid payment details")
    public void theUserSelectsAsThePaymentMethodAndEntersValidPaymentDetails(String paymentMethod) {
        orderPlacementPage.selectPaymentMethod(paymentMethod);
        orderPlacementPage.enterPaymentDetails();
    }

    @When("the user selects an invalid payment method and enters payment details")
    public void theUserSelectsAnInvalidPaymentMethodAndEntersPaymentDetails() {
        orderPage.selectInvalidPaymentMethod();
    }

    @Then("the payment details are accepted, and the user is prompted to confirm the order")
    public void thePaymentDetailsAreAcceptedAndTheUserIsPromptedToConfirmTheOrder() {
        orderPlacementPage.verifyPaymentAcceptance();
    }

    @Then("the payment method is accepted, and the user is prompted to confirm the order")
    public void thePaymentMethodIsAcceptedAndTheUserIsPromptedToConfirmTheOrder() {
        orderPlacementPage.verifyPaymentMethodAccepted();
    }

    @Then("the system rejects the payment details and displays an error message indicating invalid payment method")
    public void theSystemRejectsThePaymentDetailsAndDisplaysAnErrorMessageIndicatingInvalidPaymentMethod() {
        orderPage.verifyInvalidPaymentError();
    }

    @When("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        orderPlacementPage.confirmOrder();
    }

    @When("the user attempts to confirm the order")
    public void theUserAttemptsToConfirmTheOrder() {
        orderPage.attemptToConfirmOrder();
    }

    @Then("the order is placed successfully, and a confirmation page is displayed with the order details")
    public void theOrderIsPlacedSuccessfullyAndAConfirmationPageIsDisplayedWithTheOrderDetails() {
        orderPlacementPage.verifyOrderConfirmation();
    }

    @Then("the order is placed successfully and a confirmation page is displayed with the order details")
    public void theOrderIsPlacedSuccessfullyAndAConfirmationPageIsDisplayedWithTheOrderDetails() {
        orderPlacementPage.verifyOrderConfirmationPage();
    }

    @Then("the order cannot be confirmed due to invalid payment method")
    public void theOrderCannotBeConfirmedDueToInvalidPaymentMethod() {
        orderPage.verifyOrderNotConfirmed();
    }

    @Then("the order can be placed only for available items")
    public void theOrderCanBePlacedOnlyForAvailableItems() {
        orderPlacementPage.verifyOrderForAvailableItemsOnly();
    }

    @Then("no order confirmation is generated for the out-of-stock item")
    public void noOrderConfirmationIsGeneratedForTheOutOfStockItem() {
        orderPlacementPage.verifyNoOrderConfirmationForOutOfStockItem();
    }

    @When("the user verifies the inventory for Product ID {string}")
    public void theUserVerifiesTheInventoryForProductID(String productId) {
        orderPlacementPage.verifyInventory(productId);
    }

    @When("the user verifies the inventory for Product ID {int}")
    public void theUserVerifiesTheInventoryForProductID(int productId) {
        orderPlacementPage.verifyInventory(productId);
    }

    @Then("the inventory for Product ID {string} is reduced by {int} units")
    public void theInventoryForProductIDIsReducedByUnits(String productID, int quantity) {
        orderPlacementPage.verifyInventoryReduction(productID, quantity);
    }

    @Then("the inventory is reduced by {int} units")
    public void theInventoryIsReducedByUnits(int quantity) {
        orderPlacementPage.verifyInventoryReduction(quantity);
    }

    @Then("the inventory is reduced by 1 unit")
    public void theInventoryIsReducedBy1Unit() {
        orderPlacementPage.verifyInventoryReduction(1);
    }
}
