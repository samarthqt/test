package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

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
        // Implementation to ensure items are in the cart
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @Then("the shopping cart page is displayed with items listed")
    public void theShoppingCartPageIsDisplayedWithItemsListed() {
        // Implementation to verify cart page display
    }

    @Then("the applicable discounts and taxes are defined in the system")
    public void theApplicableDiscountsAndTaxesAreDefinedInTheSystem() {
        // Implementation to verify discounts and taxes
    }

    @When("the user verifies the displayed price total")
    public void theUserVerifiesTheDisplayedPriceTotal() {
        // Implementation to verify price total
    }

    @Then("the price total should be calculated correctly, including discounts and taxes")
    public void thePriceTotalShouldBeCalculatedCorrectlyIncludingDiscountsAndTaxes() {
        // Implementation to assert correct price total
    }

    @Then("the user sees an input field for entering a promo code")
    public void theUserSeesAnInputFieldForEnteringAPromoCode() {
        // Implementation to verify promo code input field
    }

    @When("the user enters a valid promo code in the input field")
    public void theUserEntersAValidPromoCodeInTheInputField() {
        // Implementation to enter promo code
    }

    @Then("the system verifies the promo code's validity and applicability")
    public void theSystemVerifiesThePromoCodeSValidityAndApplicability() {
        // Implementation to verify promo code
    }

    @Then("if valid, the discount is immediately displayed in the order summary")
    public void ifValidTheDiscountIsImmediatelyDisplayedInTheOrderSummary() {
        // Implementation to verify discount display
    }

    @Then("the final total before payment reflects the applied discount")
    public void theFinalTotalBeforePaymentReflectsTheAppliedDiscount() {
        // Implementation to verify final total
    }
}