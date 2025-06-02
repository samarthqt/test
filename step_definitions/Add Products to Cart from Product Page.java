package com.cucumber.steps;

import com.page_objects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps extends CartPage {

    @Given("the user is logged into the system with username {string} and password {string}")
    public void theUserIsLoggedIntoTheSystem(String username, String password) {
        login(username, password);
    }

    @When("the user navigates to the product page for {string} with Product ID {string}")
    public void theUserNavigatesToTheProductPage(String productName, String productId) {
        navigateToProductPage(productName, productId);
    }

    @Then("the product page is displayed with product details")
    public void theProductPageIsDisplayedWithProductDetails() {
        verifyProductPageDetails();
    }

    @Given("the product page for {string} is accessible")
    public void theProductPageIsAccessible(String productName) {
        verifyProductPageAccessibility(productName);
    }

    @When("the user selects the quantity of the product to add to the cart")
    public void theUserSelectsTheQuantityOfTheProduct() {
        selectProductQuantity();
    }

    @Then("the quantity selection is available and can be adjusted")
    public void theQuantitySelectionIsAvailable() {
        verifyQuantitySelection();
    }

    @Given("the user has selected the quantity for {string}")
    public void theUserHasSelectedTheQuantity(String productName) {
        verifyQuantitySelected(productName);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        clickAddToCartButton(buttonName);
    }

    @Then("the product is added to the shopping cart")
    public void theProductIsAddedToTheShoppingCart() {
        verifyProductAddedToCart();
    }

    @Given("the product is added to the shopping cart")
    public void theProductIsAddedToTheShoppingCartGiven() {
        verifyProductAddedToCart();
    }

    @When("the user views the cart icon")
    public void theUserViewsTheCartIcon() {
        viewCartIcon();
    }

    @Then("the cart icon reflects the updated quantity of products")
    public void theCartIconReflectsUpdatedQuantity() {
        verifyCartIconQuantity();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToShoppingCartPage();
    }

    @Then("the shopping cart page displays the added product with details")
    public void theShoppingCartPageDisplaysProductDetails() {
        verifyShoppingCartPageDetails();
    }

    @Given("the product is in the shopping cart")
    public void theProductIsInTheShoppingCart() {
        verifyProductInShoppingCart();
    }

    @When("the user checks the subtotal and total amounts in the cart")
    public void theUserChecksSubtotalAndTotalAmounts() {
        checkSubtotalAndTotalAmounts();
    }

    @Then("the amounts are calculated correctly based on product price and quantity")
    public void theAmountsAreCalculatedCorrectly() {
        verifyAmountsCalculation();
    }

    @When("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        removeProductFromCart();
    }

    @Then("the product is removed and the cart updates accordingly")
    public void theProductIsRemovedAndCartUpdates() {
        verifyProductRemovedAndCartUpdated();
    }

    @Given("the product was removed from the shopping cart")
    public void theProductWasRemovedFromShoppingCart() {
        verifyProductRemovedFromShoppingCart();
    }

    @When("the user adds the product to the cart again")
    public void theUserAddsTheProductToCartAgain() {
        addProductToCartAgain();
    }

    @Then("the product is successfully added back to the cart")
    public void theProductIsSuccessfullyAddedBackToCart() {
        verifyProductAddedBackToCart();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("the user is redirected to the checkout page with cart details")
    public void theUserIsRedirectedToCheckoutPage() {
        verifyCheckoutPageWithCartDetails();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyUserOnCheckoutPage();
    }

    @When("the user logs out from the account")
    public void theUserLogsOutFromAccount() {
        logoutFromAccount();
    }

    @Then("the user is logged out and redirected to the login page")
    public void theUserIsLoggedOutAndRedirectedToLoginPage() {
        verifyUserLoggedOutAndRedirected();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        verifyUserLoggedOut();
    }

    @When("the user logs back into the account")
    public void theUserLogsBackIntoAccount() {
        loginBackIntoAccount();
    }

    @Then("the cart retains the previously added product")
    public void theCartRetainsPreviouslyAddedProduct() {
        verifyCartRetainsProduct();
    }

    @Given("the user is on the product page")
    public void theUserIsOnTheProductPage() {
        verifyUserOnProductPage();
    }

    @When("the user attempts to add a product with zero quantity")
    public void theUserAttemptsToAddProductWithZeroQuantity() {
        attemptToAddProductWithZeroQuantity();
    }

    @Then("the system displays an error message indicating invalid quantity")
    public void theSystemDisplaysErrorMessage() {
        verifyErrorMessageForInvalidQuantity();
    }

    @When("the user adds the product with maximum available quantity")
    public void theUserAddsProductWithMaxQuantity() {
        addProductWithMaxQuantity();
    }

    @Then("the product is added successfully up to the maximum quantity limit")
    public void theProductIsAddedSuccessfully() {
        verifyProductAddedSuccessfully();
    }

    @Given("multiple products are added to the cart")
    public void multipleProductsAreAddedToCart() {
        verifyMultipleProductsAddedToCart();
    }

    @When("the cart is under high load")
    public void theCartIsUnderHighLoad() {
        simulateHighLoadOnCart();
    }

    @Then("the cart functions correctly and maintains performance")
    public void theCartFunctionsCorrectly() {
        verifyCartPerformanceUnderLoad();
    }

    @When("the user views the product details in the cart")
    public void theUserViewsProductDetailsInCart() {
        viewProductDetailsInCart();
    }

    @Then("the product name, price, and quantity match the selected product")
    public void theProductDetailsMatchSelectedProduct() {
        verifyProductDetailsMatch();
    }
}