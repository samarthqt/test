package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CartPage;

public class CartDisplaySteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the retail application is opened on {string}")
    public void theRetailApplicationIsOpenedOn(String device) {
        openApplicationOnDevice(device);
    }

    @Given("user account with items added to the cart is logged in")
    public void userAccountWithItemsAddedToTheCartIsLoggedIn() {
        loginWithItemsInCart();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page loads with items correctly displayed")
    public void theCartPageLoadsWithItemsCorrectlyDisplayed() {
        verifyItemsDisplayedCorrectly();
    }

    @Then("the text in the cart is clear and readable without needing to zoom")
    public void theTextInTheCartIsClearAndReadableWithoutNeedingToZoom() {
        verifyTextReadability();
    }

    @Then("the cart layout adjusts correctly to the screen size without overlapping elements")
    public void theCartLayoutAdjustsCorrectlyToTheScreenSizeWithoutOverlappingElements() {
        verifyLayoutAdjustment();
    }

    @Then("similar positive results as observed on iPhone 12 are seen")
    public void similarPositiveResultsAsObservedOnIPhone12AreSeen() {
        verifySimilarResultsAsIPhone12();
    }

    @Given("the retail application is opened on {string} in landscape mode")
    public void theRetailApplicationIsOpenedOnInLandscapeMode(String device) {
        openApplicationOnDeviceInLandscape(device);
    }

    @Then("the cart display adjusts correctly without losing readability")
    public void theCartDisplayAdjustsCorrectlyWithoutLosingReadability() {
        verifyLandscapeDisplayAdjustment();
    }

    @When("the user adds an item to the cart")
    public void theUserAddsAnItemToTheCart() {
        addItemToCart();
    }

    @Then("the item is successfully added and displayed in the cart")
    public void theItemIsSuccessfullyAddedAndDisplayedInTheCart() {
        verifyItemAddedToCart();
    }

    @When("the user removes an item from the cart")
    public void theUserRemovesAnItemFromTheCart() {
        removeItemFromCart();
    }

    @Then("the item is successfully removed and no longer displayed in the cart")
    public void theItemIsSuccessfullyRemovedAndNoLongerDisplayedInTheCart() {
        verifyItemRemovedFromCart();
    }
}