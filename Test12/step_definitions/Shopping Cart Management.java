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
        String productPageURL = testHarness.getData("CartData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        addProductToCart();
    }

    @Then("the product should be added to the cart successfully")
    public void theProductShouldBeAddedToTheCartSuccessfully() {
        openCart();
        String expectedProductName = testHarness.getData("CartData", "ProductName");
        verifyProductInCart(expectedProductName);
    }

    @Given("a user has products in the cart")
    public void aUserHasProductsInTheCart() {
        String productName = testHarness.getData("CartData", "ProductName");
        addProductToCart();
        openCart();
        verifyProductInCart(productName);
    }

    @When("the user removes a product from the cart")
    public void theUserRemovesAProductFromTheCart() {
        removeProductFromCart();
    }

    @Then("the product should be removed from the cart without errors")
    public void theProductShouldBeRemovedFromTheCartWithoutErrors() {
        verifyCartIsEmpty();
    }

    @When("the user updates the quantity of a product")
    public void theUserUpdatesTheQuantityOfAProduct() {
        String newQuantity = testHarness.getData("CartData", "NewQuantity");
        updateProductQuantity(newQuantity);
    }

    @Then("the product quantity should be updated in the cart")
    public void theProductQuantityShouldBeUpdatedInTheCart() {
        String expectedQuantity = testHarness.getData("CartData", "NewQuantity");
        verifyProductQuantity(expectedQuantity);
    }

    @When("the user views the cart")
    public void theUserViewsTheCart() {
        openCart();
    }

    @Then("the cart should display product details including name, price, quantity, and subtotal")
    public void theCartShouldDisplayProductDetailsIncludingNamePriceQuantityAndSubtotal() {
        verifyCartDetails();
    }

    @When("the user adds, removes, or updates a product")
    public void theUserAddsRemovesOrUpdatesAProduct() {
        addProductToCart();
        updateProductQuantity("2");
        removeProductFromCart();
    }

    @Then("the changes should be reflected immediately in the cart")
    public void theChangesShouldBeReflectedImmediatelyInTheCart() {
        verifyCartUpdates();
    }

    @Given("a user attempts an invalid cart operation")
    public void aUserAttemptsAnInvalidCartOperation() {
        performInvalidCartOperation();
    }

    @When("the operation is performed")
    public void theOperationIsPerformed() {
        // Operation is already performed in the Given step
    }

    @Then("an error message should be displayed to the user")
    public void anErrorMessageShouldBeDisplayedToTheUser() {
        verifyErrorMessage();
    }

    @Given("a logged-in user has products in the cart")
    public void aLoggedInUserHasProductsInTheCart() {
        loginUser();
        aUserHasProductsInTheCart();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutUser();
        loginUser();
    }

    @Then("the cart should be saved across sessions")
    public void theCartShouldBeSavedAcrossSessions() {
        verifyCartPersistence();
    }

    @Given("a user accesses the shopping cart")
    public void aUserAccessesTheShoppingCart() {
        openCart();
    }

    @When("the user interacts with the cart interface")
    public void theUserInteractsWithTheCartInterface() {
        interactWithCartInterface();
    }

    @Then("the interface should be user-friendly and intuitive")
    public void theInterfaceShouldBeUserFriendlyAndIntuitive() {
        verifyUserFriendlyInterface();
    }

    @Given("a user performs operations on the cart")
    public void aUserPerformsOperationsOnTheCart() {
        theUserAddsRemovesOrUpdatesAProduct();
    }

    @When("the operations are completed")
    public void theOperationsAreCompleted() {
        // Operations are already completed in the Given step
    }

    @Then("the cart operations should be logged for analytics")
    public void theCartOperationsShouldBeLoggedForAnalytics() {
        verifyCartOperationsLogged();
    }

    @When("the user performs cart operations")
    public void theUserPerformsCartOperations() {
        theUserAddsRemovesOrUpdatesAProduct();
    }

    @Then("the cart should comply with data privacy and security standards")
    public void theCartShouldComplyWithDataPrivacyAndSecurityStandards() {
        verifyDataPrivacyAndSecurityCompliance();
    }
}