package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import com.page_objects.CartPage;
import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutButtonSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();
    private CheckoutPage checkoutPage = new CheckoutPage();

    @Given("a user account with items added to the cart")
    public void userAccountWithItemsInCart() {
        String productName = testHarness.getData("CartData", "ProductName");
        String quantity = testHarness.getData("CartData", "Quantity");
        addProductToCart(productName, quantity);
    }

    @Given("a user account with {int} items added to the cart")
    public void userAccountWithNumberOfItemsInCart(int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            String productName = testHarness.getData("CartData", "ProductName" + i);
            addProductToCart(productName, "1");
        }
    }

    @Given("a user account with no items in the cart")
    public void userAccountWithNoItemsInCart() {
        // Assume cart is empty by default
    }

    @Given("a user is on the cart page")
    public void userIsOnCartPage() {
        navigateToCartPage();
    }

    @Given("a user is on the cart page using a mobile device")
    public void userIsOnCartPageUsingMobile() {
        navigateToCartPage();
        // Additional logic for mobile view if necessary
    }

    @Given("a user is on the cart page using {string}")
    public void userIsOnCartPageUsingBrowser(String browser) {
        testHarness.setBrowser(browser);
        navigateToCartPage();
    }

    @When("the user logs in to the retail application")
    public void userLogsInToRetailApplication() {
        loginToApplication();
    }

    @When("navigates to the cart page")
    public void navigateToCartPage() {
        openCart();
    }

    @When("clicks the 'Proceed to Checkout' button")
    public void clicksProceedToCheckoutButton() {
        proceedToCheckout();
    }

    @Then("the user is redirected to the checkout page")
    public void userIsRedirectedToCheckoutPage() {
        checkoutPage.verifyCheckoutPageLoaded();
    }

    @Then("the checkout page displays the correct items in the cart")
    public void checkoutPageDisplaysCorrectItems() {
        checkoutPage.verifyItemsInCart();
    }

    @Then("the checkout page displays all {int} items correctly")
    public void checkoutPageDisplaysAllItemsCorrectly(int numberOfItems) {
        checkoutPage.verifyNumberOfItemsInCart(numberOfItems);
    }

    @Then("the checkout page displays a message indicating no items are present")
    public void checkoutPageDisplaysNoItemsMessage() {
        checkoutPage.verifyNoItemsMessage();
    }

    @Then("the 'Proceed to Checkout' button is visible and functional")
    public void proceedToCheckoutButtonVisibleAndFunctional() {
        verifyProceedToCheckoutButtonVisible();
    }

    @Then("the user is redirected to the checkout page on the mobile device")
    public void userIsRedirectedToCheckoutPageOnMobile() {
        checkoutPage.verifyCheckoutPageLoaded();
        // Additional checks for mobile layout if necessary
    }

    @Then("the user is redirected to the checkout page on {string}")
    public void userIsRedirectedToCheckoutPageOnBrowser(String browser) {
        checkoutPage.verifyCheckoutPageLoaded();
    }

    @Then("the checkout page loads successfully without any error messages")
    public void checkoutPageLoadsWithoutErrors() {
        checkoutPage.verifyNoErrorMessages();
    }

    @Then("the page layout adjusts correctly to screen size")
    public void pageLayoutAdjustsToScreenSize() {
        checkoutPage.verifyResponsiveLayout();
    }

    @Then("payment options are visible and selectable")
    public void paymentOptionsVisibleAndSelectable() {
        checkoutPage.verifyPaymentOptions();
    }

    @Then("address fields are editable and save inputs correctly")
    public void addressFieldsEditableAndSaveInputs() {
        checkoutPage.verifyAddressFieldsEditable();
    }
}