package com.cucumber.steps;

import com.pageobjects.ShoppingCartPage;
import io.cucumber.java.en.When;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

public class ShoppingCartPersistenceSteps extends ShoppingCartPage {

    @Given("the user opens the web application in Chrome browser")
    public void openWebApplication() {
        launchApplication();
    }

    @When("the user logs in with valid credentials {string} and {string}")
    public void userLogsIn(String username, String password) {
        login(username, password);
    }

    @Then("the user is redirected to the home page")
    public void verifyHomePageRedirection() {
        checkHomePage();
    }

    @When("the user navigates to the {string} category")
    public void navigateToCategory(String category) {
        selectCategory(category);
    }

    @Then("{string} products are displayed")
    public void verifyProductsDisplayed(String category) {
        checkProductsDisplayed(category);
    }

    @When("the user selects {string} product and adds it to the cart")
    public void addProductToCart(String product) {
        selectProductAndAddToCart(product);
    }

    @Then("the product is added to the cart with a confirmation message")
    public void verifyProductAddedToCart() {
        checkProductAddedConfirmation();
    }

    @When("the user views the shopping cart")
    public void viewShoppingCart() {
        openShoppingCart();
    }

    @Then("both {string} and {string} are displayed in the cart with correct quantities {int} each")
    public void verifyProductsInCart(String product1, String product2, int quantity) {
        checkProductsInCart(product1, product2, quantity);
    }

    @When("the user closes the browser completely")
    public void closeBrowser() {
        closeBrowserSession();
    }

    @When("reopens the browser and navigates to the web application")
    public void reopenBrowserAndNavigate() {
        reopenApplication();
    }

    @Then("the application home page is displayed")
    public void verifyApplicationHomePage() {
        checkHomePage();
    }

    @Then("the user is successfully logged in")
    public void verifyUserLoggedIn() {
        checkUserLoggedIn();
    }

    @Then("both {string} and {string} are displayed in the cart with correct quantities {int} each")
    public void verifyProductsInCartAfterReopen(String product1, String product2, int quantity) {
        checkProductsInCart(product1, product2, quantity);
    }

    @Then("product names, prices, quantities, and subtotals are correctly displayed")
    public void verifyCartDetails() {
        checkCartDetails();
    }

    @When("the user logs out from the application")
    public void userLogsOut() {
        logout();
    }

    @Then("the user is successfully logged out and redirected to the home page")
    public void verifyUserLoggedOut() {
        checkUserLoggedOut();
    }
}