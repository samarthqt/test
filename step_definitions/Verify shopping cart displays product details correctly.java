package com.cucumber.steps;

import com.page_objects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps extends CartPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user adds Product ID {int} to the cart with a quantity of {int}")
    public void theUserAddsProductToTheCart(int productId, int quantity) {
        addProductToCart(productId, quantity);
    }

    @Then("the product is added to the cart successfully")
    public void theProductIsAddedToTheCartSuccessfully() {
        verifyProductAddedSuccessfully();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToShoppingCartPage();
    }

    @Then("the shopping cart page displays correctly")
    public void theShoppingCartPageDisplaysCorrectly() {
        verifyShoppingCartPageDisplaysCorrectly();
    }

    @Given("the product is in the cart")
    public void theProductIsInTheCart() {
        verifyProductInCart();
    }

    @Then("the product name matches {string}")
    public void theProductNameMatches(String expectedName) {
        verifyProductName(expectedName);
    }

    @Then("the price matches ${double}")
    public void thePriceMatches(double expectedPrice) {
        verifyProductPrice(expectedPrice);
    }

    @Then("the quantity matches {int}")
    public void theQuantityMatches(int expectedQuantity) {
        verifyProductQuantity(expectedQuantity);
    }

    @Then("the subtotal matches ${double}")
    public void theSubtotalMatches(double expectedSubtotal) {
        verifyProductSubtotal(expectedSubtotal);
    }

    @Then("all details match the expected values without discrepancies")
    public void allDetailsMatchWithoutDiscrepancies() {
        verifyAllProductDetailsMatch();
    }

    @When("the user changes the product quantity in the cart")
    public void theUserChangesTheProductQuantityInTheCart() {
        changeProductQuantityInCart();
    }

    @Then("the cart reflects the updated quantity and recalculates the subtotal")
    public void theCartReflectsUpdatedQuantityAndSubtotal() {
        verifyCartUpdatesCorrectly();
    }

    @When("the user views the cart details")
    public void theUserViewsTheCartDetails() {
        viewCartDetails();
    }

    @Then("the system remains responsive and displays details efficiently")
    public void theSystemRemainsResponsive() {
        verifySystemPerformance();
    }

    @Given("multiple products are added to the cart")
    public void multipleProductsAreAddedToTheCart() {
        addMultipleProductsToCart();
    }

    @Then("the cart displays all products with correct details")
    public void theCartDisplaysAllProductsCorrectly() {
        verifyMultipleProductsDisplayCorrectly();
    }

    @Given("multiple products are in the cart")
    public void multipleProductsAreInTheCart() {
        verifyMultipleProductsInCart();
    }

    @Then("the total cart value matches the sum of all product subtotals")
    public void theTotalCartValueMatches() {
        verifyTotalCartValue();
    }

    @When("the user views the cart")
    public void theUserViewsTheCart() {
        viewCart();
    }

    @Then("the system should not display any warnings if functioning correctly")
    public void theSystemShouldNotDisplayWarnings() {
        verifyNoSystemWarnings();
    }

    @Then("users should find the display clear and informative")
    public void usersShouldFindDisplayClear() {
        assessUserSatisfaction();
    }

    @Then("the system logs should reflect the cart display process and any errors encountered")
    public void theSystemLogsShouldReflectCartDisplay() {
        verifySystemLogsForCartDisplay();
    }

    @Given("the system is under high load with multiple cart displays")
    public void theSystemIsUnderHighLoad() {
        simulateHighLoad();
    }

    @Then("the system scales effectively and maintains performance")
    public void theSystemScalesEffectively() {
        verifySystemScalability();
    }
}