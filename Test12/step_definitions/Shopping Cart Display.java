package com.cucumber.steps;

import com.page_objects.CartDisplayPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartDisplaySteps extends CartDisplayPage {

    @Given("a user has added products to the shopping cart")
    public void aUserHasAddedProductsToTheShoppingCart() {
        addProductsToCart();
    }

    @When("the shopping cart is viewed")
    public void theShoppingCartIsViewed() {
        viewCart();
    }

    @Then("the cart should display product name, price, quantity, and subtotal")
    public void theCartShouldDisplayProductDetails() {
        verifyProductDetailsInCart();
    }

    @Given("a user has updated product quantities in the shopping cart")
    public void aUserHasUpdatedProductQuantitiesInTheShoppingCart() {
        updateProductQuantities();
    }

    @Then("the product details should be updated in real-time")
    public void theProductDetailsShouldBeUpdatedInRealTime() {
        verifyRealTimeUpdates();
    }

    @Given("a user has multiple items in the shopping cart")
    public void aUserHasMultipleItemsInTheShoppingCart() {
        addMultipleItemsToCart();
    }

    @Then("the total price of all items should be displayed")
    public void theTotalPriceOfAllItemsShouldBeDisplayed() {
        verifyTotalPrice();
    }

    @Then("the system should ensure data integrity and accuracy in product details")
    public void theSystemShouldEnsureDataIntegrityAndAccuracyInProductDetails() {
        verifyDataIntegrityAndAccuracy();
    }

    @Given("a user views the shopping cart on different devices")
    public void aUserViewsTheShoppingCartOnDifferentDevices() {
        viewCartOnDifferentDevices();
    }

    @Then("the cart display should adjust to various screen sizes")
    public void theCartDisplayShouldAdjustToVariousScreenSizes() {
        verifyResponsiveCartDisplay();
    }

    @Given("a user has products in the shopping cart")
    public void aUserHasProductsInTheShoppingCart() {
        addProductsToCart();
    }

    @When("the user clicks on a product in the cart")
    public void theUserClicksOnAProductInTheCart() {
        clickOnProductInCart();
    }

    @Then("detailed product information should be accessible")
    public void detailedProductInformationShouldBeAccessible() {
        verifyDetailedProductInformation();
    }

    @Given("a product is out-of-stock")
    public void aProductIsOutOfStock() {
        markProductOutOfStock();
    }

    @Then("the system should prevent display of the out-of-stock product")
    public void theSystemShouldPreventDisplayOfTheOutOfStockProduct() {
        verifyOutOfStockProductNotDisplayed();
    }

    @Given("a user views the shopping cart on different browsers")
    public void aUserViewsTheShoppingCartOnDifferentBrowsers() {
        viewCartOnDifferentBrowsers();
    }

    @Then("the cart display should be consistent across browsers")
    public void theCartDisplayShouldBeConsistentAcrossBrowsers() {
        verifyConsistentCartDisplayAcrossBrowsers();
    }

    @Given("a user is viewing the shopping cart")
    public void aUserIsViewingTheShoppingCart() {
        viewCart();
    }

    @When("navigating the cart")
    public void navigatingTheCart() {
        navigateCart();
    }

    @Then("the system should provide a clear user interface for easy navigation")
    public void theSystemShouldProvideAClearUserInterfaceForEasyNavigation() {
        verifyClearUserInterface();
    }

    @When("the user decides to checkout")
    public void theUserDecidesToCheckout() {
        proceedToCheckout();
    }

    @Then("the user should be able to proceed to checkout directly from the cart display")
    public void theUserShouldBeAbleToProceedToCheckoutDirectlyFromTheCartDisplay() {
        verifyCheckoutFromCartDisplay();
    }
}