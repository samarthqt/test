package com.cucumber.steps;
import io.cucumber.java.en.When;
import com.framework.cucumber.TestHarness;

import com.pageobjects.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

public class InventorySteps extends InventoryPage {

    @Given("user has access to the e-commerce website")
    public void userHasAccessToTheECommerceWebsite() {
        openHomePage();
    }

    @When("user navigates to the product listing page")
    public void userNavigatesToTheProductListingPage() {
        navigateToProductListingPage();
    }

    @Then("product listing page is displayed with multiple products")
    public void productListingPageIsDisplayedWithMultipleProducts() {
        verifyProductListingPage();
    }

    @When("user selects Product 1 with limited inventory of 5 units")
    public void userSelectsProduct1WithLimitedInventoryOf5Units() {
        selectProduct1();
    }

    @Then("Product 1 detail page is displayed with product information, price, quantity selector, and 'Add to Cart' button")
    public void product1DetailPageIsDisplayed() {
        verifyProductDetailPage();
    }

    @When("user locates the quantity selector field for Product 1")
    public void userLocatesTheQuantitySelectorFieldForProduct1() {
        locateQuantitySelector();
    }

    @When("user enters '5' in the quantity field")
    public void userEnters5InTheQuantityField() {
        enterQuantity("5");
    }

    @Then("quantity field displays '5'")
    public void quantityFieldDisplays5() {
        verifyQuantityField("5");
    }

    @When("user adds the product to the cart")
    public void userAddsTheProductToTheCart() {
        addToCart();
    }

    @Then("product is successfully added to cart with quantity 5")
    public void productIsSuccessfullyAddedToCartWithQuantity5() {
        verifyProductAddedToCart("5");
    }

    @Then("a confirmation message appears")
    public void aConfirmationMessageAppears() {
        verifyConfirmationMessage();
    }

    @Given("user is on the Product 1 detail page")
    public void userIsOnTheProduct1DetailPage() {
        verifyProductDetailPage();
    }

    @When("user enters '1' in the quantity field")
    public void userEnters1InTheQuantityField() {
        enterQuantity("1");
    }

    @Then("system displays an error message: 'Sorry, only 5 units available. You already have 5 units in your cart'")
    public void systemDisplaysAnErrorMessage() {
        verifyErrorMessage("Sorry, only 5 units available. You already have 5 units in your cart");
    }

    @Given("user clicks on the cart icon")
    public void userClicksOnTheCartIcon() {
        clickCartIcon();
    }

    @Then("shopping cart page opens displaying Product 1 with quantity 5")
    public void shoppingCartPageOpensDisplayingProduct1WithQuantity5() {
        verifyCartContents("Product 1", "5");
    }

    @Given("user locates the quantity field for Product 1 in the cart")
    public void userLocatesTheQuantityFieldForProduct1InTheCart() {
        locateCartQuantityField();
    }

    @When("user enters '{quantity}' in the quantity field and updates")
    public void userEntersQuantityInTheQuantityFieldAndUpdates(String quantity) {
        updateCartQuantity(quantity);
    }

    @Then("system prevents updating the quantity and displays an error message: 'Sorry, only 5 units available'")
    public void systemPreventsUpdatingTheQuantityAndDisplaysAnErrorMessage() {
        verifyErrorMessage("Sorry, only 5 units available");
    }

    @Then("quantity field reverts to the previous valid value (5)")
    public void quantityFieldRevertsToThePreviousValidValue() {
        verifyCartQuantity("5");
    }

    @When("user decreases the quantity to '3' and updates")
    public void userDecreasesTheQuantityTo3AndUpdates() {
        updateCartQuantity("3");
    }

    @Then("quantity is successfully updated to 3")
    public void quantityIsSuccessfullyUpdatedTo3() {
        verifyCartQuantity("3");
    }

    @Then("a confirmation message appears indicating 'Cart updated successfully'")
    public void aConfirmationMessageAppearsIndicatingCartUpdatedSuccessfully() {
        verifyConfirmationMessage("Cart updated successfully");
    }

    @Given("user navigates back to Product 1 detail page")
    public void userNavigatesBackToProduct1DetailPage() {
        navigateToProductDetailPage();
    }

    @When("user enters '3' in the quantity field")
    public void userEnters3InTheQuantityField() {
        enterQuantity("3");
    }

    @Then("system displays an error message: 'Sorry, only 2 more units available. You already have 3 units in your cart'")
    public void systemDisplaysAnErrorMessageForAdditionalUnits() {
        verifyErrorMessage("Sorry, only 2 more units available. You already have 3 units in your cart");
    }
}