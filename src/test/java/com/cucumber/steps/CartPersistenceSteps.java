package com.cucumber.steps;

import com.pageobjects.CartPersistencePage;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class CartPersistenceSteps extends CartPersistencePage {

    @Given("user is logged into the application")
    public void userIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("user has items in the shopping cart")
    public void userHasItemsInTheShoppingCart() {
        addItemsToCart();
    }

    @When("user logs out from the application")
    public void userLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("user logs back into the application")
    public void userLogsBackIntoTheApplication() {
        loginToApplication();
    }

    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        verifyLoginSuccess();
    }

    @When("user navigates to the shopping cart page")
    public void userNavigatesToTheShoppingCartPage() {
        navigateToCartPage();
    }

    @Then("shopping cart displays the items added before logging out")
    public void shoppingCartDisplaysTheItemsAddedBeforeLoggingOut() {
        verifyCartItemsPersistence();
    }
}