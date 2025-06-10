package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CartPage;

public class CartManagementSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is on the product page")
    public void aUserIsOnTheProductPage() {
        String productName = testHarness.getData("ProductData", "ProductName");
        navigateToProductPage(productName);
    }

    @When("the user adds a product to the shopping cart")
    public void theUserAddsAProductToTheShoppingCart() {
        addProductToCart();
    }

    @Then("the product should appear in the shopping cart")
    public void theProductShouldAppearInTheShoppingCart() {
        String expectedProductName = testHarness.getData("ProductData", "ProductName");
        openCart();
        verifyProductInCart(expectedProductName);
    }

    @Then("the cart should display the product's name, price, quantity, and subtotal")
    public void theCartShouldDisplayTheProductDetails() {
        verifyProductDetailsInCart();
    }

    @Given("a user has a product in the shopping cart")
    public void aUserHasAProductInTheShoppingCart() {
        String productName = testHarness.getData("ProductData", "ProductName");
        addProductToCart();
        openCart();
        verifyProductInCart(productName);
    }

    @When("the user updates the quantity of the product in the cart")
    public void theUserUpdatesTheQuantityOfTheProductInTheCart() {
        String quantity = testHarness.getData("CartData", "Quantity");
        updateProductQuantity(quantity);
    }

    @Then("the cart should reflect the updated quantity")
    public void theCartShouldReflectTheUpdatedQuantity() {
        String expectedQuantity = testHarness.getData("CartData", "Quantity");
        verifyProductQuantity(expectedQuantity);
    }

    @Then("the subtotal should be recalculated accordingly")
    public void theSubtotalShouldBeRecalculatedAccordingly() {
        verifySubtotalCalculation();
    }

    @When("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        removeProductFromCart();
    }

    @Then("the product should no longer appear in the shopping cart")
    public void theProductShouldNoLongerAppearInTheShoppingCart() {
        verifyProductNotInCart();
    }

    @Given("a user has multiple products in the shopping cart")
    public void aUserHasMultipleProductsInTheShoppingCart() {
        addMultipleProductsToCart();
    }

    @When("the user updates the quantity or removes a product")
    public void theUserUpdatesTheQuantityOrRemovesAProduct() {
        updateOrRemoveProduct();
    }

    @Then("the cart totals should update in real-time")
    public void theCartTotalsShouldUpdateInRealTime() {
        verifyRealTimeCartTotals();
    }

    @Given("a user encounters an error while managing the shopping cart")
    public void aUserEncountersAnErrorWhileManagingTheShoppingCart() {
        simulateCartError();
    }

    @When("the error occurs")
    public void theErrorOccurs() {
        triggerCartError();
    }

    @Then("the system should handle the error gracefully")
    public void theSystemShouldHandleTheErrorGracefully() {
        verifyErrorHandling();
    }

    @Then("provide an appropriate error message to the user")
    public void provideAnAppropriateErrorMessageToTheUser() {
        verifyErrorMessage();
    }

    @Given("a user updates the shopping cart successfully")
    public void aUserUpdatesTheShoppingCartSuccessfully() {
        updateCartSuccessfully();
    }

    @When("the update is processed")
    public void theUpdateIsProcessed() {
        processCartUpdate();
    }

    @Then("the user should receive a notification confirming the successful update")
    public void theUserShouldReceiveANotificationConfirmingTheSuccessfulUpdate() {
        verifySuccessNotification();
    }

    @Given("a user has items in the shopping cart")
    public void aUserHasItemsInTheShoppingCart() {
        addItemsToCart();
    }

    @When("the user navigates away from the cart page")
    public void theUserNavigatesAwayFromTheCartPage() {
        navigateAwayFromCartPage();
    }

    @Then("the cart data should be stored securely")
    public void theCartDataShouldBeStoredSecurely() {
        verifyCartDataSecurity();
    }

    @Given("a user has items in the shopping cart on a desktop device")
    public void aUserHasItemsInTheShoppingCartOnADesktopDevice() {
        addItemsToCartOnDesktop();
    }

    @When("the user accesses the shopping cart on a mobile device")
    public void theUserAccessesTheShoppingCartOnAMobileDevice() {
        accessCartOnMobile();
    }

    @Then("the cart should be accessible with the same items")
    public void theCartShouldBeAccessibleWithTheSameItems() {
        verifyCartAccessibilityAcrossDevices();
    }

    @Given("a user performs actions on the shopping cart")
    public void aUserPerformsActionsOnTheShoppingCart() {
        performCartActions();
    }

    @When("the actions are completed")
    public void theActionsAreCompleted() {
        completeCartActions();
    }

    @Then("the system should log all interactions for user tracking purposes")
    public void theSystemShouldLogAllInteractionsForUserTrackingPurposes() {
        verifyCartInteractionLogging();
    }
}