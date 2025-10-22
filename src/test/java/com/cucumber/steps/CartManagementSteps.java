package com.cucumber.steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.When;

import com.framework.cucumber.TestHarness;

public class CartManagementSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the product details page")
    public void theUserIsOnTheProductDetailsPage() {
        String productName = testHarness.getData("ProductData", "ProductName");
        navigateToProductPage(productName);
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        addProductToCart();
    }

    @Then("the cart should contain the added product")
    public void theCartShouldContainTheAddedProduct() {
        String expectedProductName = testHarness.getData("ProductData", "ProductName");
        openCart();
        verifyProductInCart(expectedProductName);
    }

    @Given("the user has a product in the cart")
    public void theUserHasAProductInTheCart() {
        String productName = testHarness.getData("ProductData", "ProductName");
        addProductToCart();
        openCart();
        verifyProductInCart(productName);
    }

    @When("the user updates the quantity to {string}")
    public void theUserUpdatesTheQuantityTo(String quantity) {
        updateProductQuantity(quantity);
    }

    @Then("the cart should reflect the updated quantity")
    public void theCartShouldReflectTheUpdatedQuantity() {
        String expectedQuantity = testHarness.getData("CartData", "Quantity");
        verifyProductQuantity(expectedQuantity);
    }

    @When("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        removeProductFromCart();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        verifyCartIsEmpty();
    }

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        // Assume items are already in the cart for this scenario
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @Then("the shopping cart page is displayed with items listed")
    public void theShoppingCartPageIsDisplayedWithItemsListed() {
        verifyCartIsNotEmpty();
    }

    @When("the user selects the 'Proceed to Checkout' option")
    public void theUserSelectsTheProceedToCheckoutOption() {
        proceedToCheckout();
    }

    @Then("the user is redirected to the checkout page")
    public void theUserIsRedirectedToTheCheckoutPage() {
        verifyCheckoutPageIsDisplayed();
    }

    @When("the user enters the valid coupon code in the coupon field")
    public void theUserEntersTheValidCouponCodeInTheCouponField() {
        enterCouponCode("SAVE20");
    }

    @When("submits the coupon code")
    public void submitsTheCouponCode() {
        submitCouponCode();
    }

    @Then("the coupon code is accepted")
    public void theCouponCodeIsAccepted() {
        verifyCouponAccepted();
    }

    @Then("the discount is displayed in the order summary, showing the amount or percentage deducted")
    public void theDiscountIsDisplayedInTheOrderSummary() {
        verifyDiscountDisplayed();
    }

    @Then("the checkout page displays the discounted total")
    public void theCheckoutPageDisplaysTheDiscountedTotal() {
        verifyDiscountedTotalDisplayed();
    }

    @When("the user enters the expired coupon code in the coupon field")
    public void theUserEntersTheExpiredCouponCodeInTheCouponField() {
        enterCouponCode("EXPIRED50");
    }

    @Then("an error message is displayed indicating the coupon is expired")
    public void anErrorMessageIsDisplayedIndicatingTheCouponIsExpired() {
        verifyCouponExpiredMessage();
    }

    @When("the user enters the invalid coupon code in the coupon field")
    public void theUserEntersTheInvalidCouponCodeInTheCouponField() {
        enterCouponCode("INVALID123");
    }

    @Then("an error message is displayed indicating the coupon is invalid")
    public void anErrorMessageIsDisplayedIndicatingTheCouponIsInvalid() {
        verifyCouponInvalidMessage();
    }
}