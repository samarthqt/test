package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OutOfStockPage;

public class OutOfStockSteps extends OutOfStockPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the product page of an out-of-stock item with Product ID {int}")
    public void theUserNavigatesToTheProductPageOfAnOutOfStockItemWithProductID(int productId) {
        navigateToOutOfStockProductPage(productId);
    }

    @Then("the product page is displayed with an out-of-stock status")
    public void theProductPageIsDisplayedWithAnOutOfStockStatus() {
        verifyOutOfStockStatus();
    }

    @Given("the user is on the product page of an out-of-stock item")
    public void theUserIsOnTheProductPageOfAnOutOfStockItem() {
        verifyOnOutOfStockProductPage();
    }

    @Then("the 'Add to Cart' button is disabled")
    public void theAddToCartButtonIsDisabled() {
        verifyAddToCartButtonDisabled();
    }

    @Given("the 'Add to Cart' button is disabled")
    public void theAddToCartButtonIsDisabledGiven() {
        verifyAddToCartButtonDisabled();
    }

    @When("the user attempts to click the 'Add to Cart' button")
    public void theUserAttemptsToClickTheAddToCartButton() {
        attemptToClickAddToCartButton();
    }

    @Then("the system prevents adding the product to the cart and displays an error message")
    public void theSystemPreventsAddingTheProductToTheCartAndDisplaysAnErrorMessage() {
        verifyErrorMessageDisplayed();
    }

    @Then("an out-of-stock notification is visible on the product page")
    public void anOutOfStockNotificationIsVisibleOnTheProductPage() {
        verifyOutOfStockNotificationVisible();
    }

    @When("the user tries to add the product to the cart using a direct URL manipulation")
    public void theUserTriesToAddTheProductToTheCartUsingADirectURLManipulation() {
        attemptAddToCartViaURLManipulation();
    }

    @Then("the system prevents addition and displays an error message")
    public void theSystemPreventsAdditionAndDisplaysAnErrorMessage() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user attempted to add an out-of-stock product to the cart")
    public void theUserAttemptedToAddAnOutOfStockProductToTheCart() {
        attemptToAddOutOfStockProduct();
    }

    @Then("the cart remains unchanged with no out-of-stock products added")
    public void theCartRemainsUnchangedWithNoOutOfStockProductsAdded() {
        verifyCartUnchanged();
    }

    @Then("alternative product suggestions are displayed")
    public void alternativeProductSuggestionsAreDisplayed() {
        verifyAlternativeSuggestionsDisplayed();
    }

    @When("the user attempts to add the out-of-stock product to a wishlist")
    public void theUserAttemptsToAddTheOutOfStockProductToAWishlist() {
        addToWishlist();
    }

    @Then("the system allows adding to the wishlist but not to the cart")
    public void theSystemAllowsAddingToTheWishlistButNotToTheCart() {
        verifyWishlistAddition();
    }

    @Given("the stock status of the product changes")
    public void theStockStatusOfTheProductChanges() {
        changeStockStatus();
    }

    @Then("the product page reflects real-time stock status updates")
    public void theProductPageReflectsRealTimeStockStatusUpdates() {
        verifyRealTimeStockUpdates();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        logout();
    }

    @When("the user attempts to add the out-of-stock product to the cart")
    public void theUserAttemptsToAddTheOutOfStockProductToTheCart() {
        attemptToAddOutOfStockProduct();
    }

    @Then("the system prevents addition and prompts for login")
    public void theSystemPreventsAdditionAndPromptsForLogin() {
        verifyLoginPrompt();
    }

    @When("the user attempts to add an out-of-stock product to the cart")
    public void theUserAttemptsToAddAnOutOfStockProductToTheCart() {
        attemptToAddOutOfStockProduct();
    }

    @Then("the system logs the attempt for auditing purposes")
    public void theSystemLogsTheAttemptForAuditingPurposes() {
        verifyAuditLog();
    }

    @When("the user attempts to add the out-of-stock product using a mobile device")
    public void theUserAttemptsToAddTheOutOfStockProductUsingAMobileDevice() {
        attemptAddUsingMobileDevice();
    }

    @Then("the system prevents addition and displays a consistent error message")
    public void theSystemPreventsAdditionAndDisplaysAConsistentErrorMessage() {
        verifyConsistentErrorMessage();
    }

    @When("the user searches for the out-of-stock product in the product catalog")
    public void theUserSearchesForTheOutOfStockProductInTheProductCatalog() {
        searchOutOfStockProduct();
    }

    @Then("the product is searchable but marked as out of stock")
    public void theProductIsSearchableButMarkedAsOutOfStock() {
        verifyProductMarkedOutOfStock();
    }

    @When("the user attempts to add the product via an API call")
    public void theUserAttemptsToAddTheProductViaAnAPICall() {
        attemptAddViaAPICall();
    }

    @Then("the API responds with an error indicating out-of-stock status")
    public void theAPIRespondsWithAnErrorIndicatingOutOfStockStatus() {
        verifyAPIErrorResponse();
    }

    @Given("the product is out of stock")
    public void theProductIsOutOfStock() {
        verifyProductOutOfStock();
    }

    @Then("a notification option is available for the user to be notified when the product is back in stock")
    public void aNotificationOptionIsAvailableForTheUserToBeNotifiedWhenTheProductIsBackInStock() {
        verifyNotificationOptionAvailable();
    }
}