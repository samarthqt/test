package com.cucumber.steps;

import com.page_objects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps extends CartPage {

    @Given("a user account with items added to the cart")
    public void aUserAccountWithItemsAddedToTheCart() {
        loginUser();
        addItemsToCart();
    }

    @When("the user logs in to the retail application")
    public void theUserLogsInToTheRetailApplication() {
        loginUser();
    }

    @Then("the user successfully logs in")
    public void theUserSuccessfullyLogsIn() {
        verifyLoginSuccess();
    }

    @Given("the user has logged in")
    public void theUserHasLoggedIn() {
        loginUser();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed with items")
    public void theCartPageIsDisplayedWithItems() {
        verifyCartPageDisplayed();
    }

    @Given("the cart contains 3 out-of-stock items")
    public void theCartContainsOutOfStockItems() {
        addOutOfStockItemsToCart(3);
    }

    @When("the user views the cart")
    public void theUserViewsTheCart() {
        viewCart();
    }

    @Then("out-of-stock items are clearly marked")
    public void outOfStockItemsAreClearlyMarked() {
        verifyOutOfStockItemsMarked();
    }

    @Given("the cart contains mixed in-stock and out-of-stock items")
    public void theCartContainsMixedInStockAndOutOfStockItems() {
        addMixedStockItemsToCart();
    }

    @When("the user clicks the 'Proceed to Checkout' button")
    public void theUserClicksProceedToCheckoutButton() {
        clickProceedToCheckout();
    }

    @Then("the system checks item availability")
    public void theSystemChecksItemAvailability() {
        verifyItemAvailability();
    }

    @Given("the cart contains out-of-stock items")
    public void theCartContainsOutOfStockItemsAgain() {
        addOutOfStockItemsToCart(2);
    }

    @When("the user attempts to proceed to checkout")
    public void theUserAttemptsToProceedToCheckout() {
        attemptProceedToCheckout();
    }

    @Then("the user receives a notification indicating out-of-stock items")
    public void theUserReceivesNotificationForOutOfStockItems() {
        verifyOutOfStockNotification();
    }

    @Given("the cart contains out-of-stock items")
    public void theCartContainsOutOfStockItemsOnceMore() {
        addOutOfStockItemsToCart(1);
    }

    @When("the user attempts to remove out-of-stock items from the cart")
    public void theUserAttemptsToRemoveOutOfStockItems() {
        removeOutOfStockItems();
    }

    @Then("the items are successfully removed")
    public void theItemsAreSuccessfullyRemoved() {
        verifyItemsRemoved();
    }

    @Given("the cart no longer contains out-of-stock items")
    public void theCartNoLongerContainsOutOfStockItems() {
        ensureNoOutOfStockItemsInCart();
    }

    @When("the user tries proceeding to checkout again")
    public void theUserTriesProceedingToCheckoutAgain() {
        retryProceedToCheckout();
    }

    @Then("the user is redirected to the checkout page without out-of-stock items")
    public void theUserIsRedirectedToCheckoutPage() {
        verifyCheckoutPageWithoutOutOfStockItems();
    }

    @Given("various combinations of in-stock and out-of-stock items in the cart")
    public void variousCombinationsInCart() {
        addVariousCombinationsToCart();
    }

    @When("the user repeats the checkout attempt")
    public void theUserRepeatsCheckoutAttempt() {
        repeatCheckoutAttempt();
    }

    @Then("the notification for out-of-stock items remains consistent")
    public void notificationConsistency() {
        verifyNotificationConsistency();
    }

    @Given("the user has removed out-of-stock items")
    public void userHasRemovedOutOfStockItems() {
        removeOutOfStockItems();
    }

    @When("the user views the checkout page")
    public void userViewsCheckoutPage() {
        viewCheckoutPage();
    }

    @Then("out-of-stock items are not listed on the checkout page")
    public void outOfStockItemsNotListed() {
        verifyOutOfStockItemsNotListed();
    }

    @Given("the user attempts to checkout")
    public void userAttemptsCheckout() {
        attemptCheckout();
    }

    @When("the system processes the checkout")
    public void systemProcessesCheckout() {
        processCheckout();
    }

    @Then("no errors other than out-of-stock notification are displayed")
    public void noErrorsDisplayed() {
        verifyNoErrorsExceptOutOfStock();
    }

    @Given("the user is using a mobile device")
    public void userUsingMobileDevice() {
        setMobileDeviceContext();
    }

    @When("the notification is displayed")
    public void notificationDisplayed() {
        displayNotification();
    }

    @Then("the notification is visible and readable on mobile devices")
    public void notificationVisibleOnMobile() {
        verifyNotificationVisibilityOnMobile();
    }

    @Given("various browsers are used")
    public void variousBrowsersUsed() {
        setBrowserContext();
    }

    @When("the notification is displayed")
    public void notificationDisplayedOnBrowsers() {
        displayNotification();
    }

    @Then("the notification is visible and readable on all tested browsers")
    public void notificationVisibleOnBrowsers() {
        verifyNotificationVisibilityOnBrowsers();
    }

    @Given("the user has removed out-of-stock items")
    public void userRemovedOutOfStockItems() {
        removeOutOfStockItems();
    }

    @When("the user adds in-stock items")
    public void userAddsInStockItems() {
        addInStockItems();
    }

    @Then("in-stock items can be added and proceed to checkout")
    public void inStockItemsAddedAndCheckout() {
        verifyInStockItemsAddedAndCheckout();
    }

    @Given("the cart contains only in-stock items")
    public void cartContainsOnlyInStockItems() {
        ensureOnlyInStockItemsInCart();
    }

    @When("the user initiates the checkout process")
    public void userInitiatesCheckoutProcess() {
        initiateCheckoutProcess();
    }

    @Then("the checkout process initiates successfully")
    public void checkoutProcessInitiatesSuccessfully() {
        verifyCheckoutInitiationSuccess();
    }

    @Given("the stock status changes")
    public void stockStatusChanges() {
        changeStockStatus();
    }

    @When("the user views the cart")
    public void userViewsCart() {
        viewCart();
    }

    @Then("the cart reflects current stock status accurately")
    public void cartReflectsCurrentStockStatus() {
        verifyCartStockStatus();
    }
}