package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import com.pageobjects.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.CartPage;

public class ProceedToCheckoutSteps extends CartPage {

    private CheckoutPage checkoutPage = new CheckoutPage();

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        // Assuming items are already added to the cart
        openCart();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @Then("the shopping cart page is displayed with items listed")
    public void theShoppingCartPageIsDisplayedWithItemsListed() {
        verifyProductInCart("Sample Product"); // Replace with actual product name
    }

    @When("the user selects the 'Proceed to Checkout' option")
    public void theUserSelectsTheProceedToCheckoutOption() {
        proceedToCheckout();
    }

    @Then("the user is redirected to the checkout page")
    public void theUserIsRedirectedToTheCheckoutPage() {
        checkoutPage.verifyCheckoutPageDisplayed();
    }
}