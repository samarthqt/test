package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.CartPage;

public class CheckoutWithEmptyCartSteps extends CartPage {

    @Given("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @Then("the shopping cart page is displayed indicating the cart is empty")
    public void theShoppingCartPageIsDisplayedIndicatingTheCartIsEmpty() {
        verifyCartIsEmpty();
    }

    @When("the user attempts to proceed to checkout")
    public void theUserAttemptsToProceedToCheckout() {
        attemptProceedToCheckout();
    }

    @Then("the system prevents the action and displays a message indicating the cart is empty")
    public void theSystemPreventsTheActionAndDisplaysAMessageIndicatingTheCartIsEmpty() {
        verifyCheckoutPreventionMessage();
    }
}