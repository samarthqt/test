package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CartPage;

public class CartManagementSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the shopping platform")
    public void theUserIsLoggedIntoTheShoppingPlatform() {
        loginToPlatform();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed showing no items")
    public void theCartPageIsDisplayedShowingNoItems() {
        verifyCartPageDisplayed();
        verifyCartIsEmpty();
    }

    @Given("the cart is empty")
    public void theCartIsEmpty() {
        verifyCartIsEmpty();
    }

    @When("the user clicks on the 'Proceed to Checkout' button")
    public void theUserClicksOnTheProceedToCheckoutButton() {
        attemptProceedToCheckout();
    }

    @Then("the system does not allow proceeding to checkout")
    public void theSystemDoesNotAllowProceedingToCheckout() {
        verifyCheckoutNotAllowed();
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Given("an error message is displayed due to an empty cart")
    public void anErrorMessageIsDisplayedDueToAnEmptyCart() {
        verifyErrorMessageDisplayed();
    }

    @When("the user reads the error message")
    public void theUserReadsTheErrorMessage() {
        readErrorMessage();
    }

    @Then("the error message clearly states that the cart is empty and checkout cannot proceed")
    public void theErrorMessageClearlyStatesThatTheCartIsEmptyAndCheckoutCannotProceed() {
        verifyErrorMessageContent();
    }

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        navigateToCartPage();
    }

    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        addProductToCart();
    }

    @Then("the product is added successfully")
    public void theProductIsAddedSuccessfully() {
        verifyProductAdded();
    }

    @Then("checkout can proceed with a non-empty cart")
    public void checkoutCanProceedWithANonEmptyCart() {
        verifyCheckoutAllowed();
    }

    @Given("the user has added items to the cart")
    public void theUserHasAddedItemsToTheCart() {
        addItemsToCart();
    }

    @When("the user removes all items from the cart")
    public void theUserRemovesAllItemsFromTheCart() {
        removeAllItemsFromCart();
    }

    @When("attempts to checkout")
    public void attemptsToCheckout() {
        attemptProceedToCheckout();
    }

    @Then("the same error message is displayed indicating the cart is empty")
    public void theSameErrorMessageIsDisplayedIndicatingTheCartIsEmpty() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user attempts to checkout with an empty cart")
    public void theUserAttemptsToCheckoutWithAnEmptyCart() {
        attemptProceedToCheckout();
    }

    @When("system logs or alerts are checked")
    public void systemLogsOrAlertsAreChecked() {
        checkSystemLogs();
    }

    @Then("they indicate a checkout attempt with an empty cart")
    public void theyIndicateACheckoutAttemptWithAnEmptyCart() {
        verifyLogsForEmptyCartCheckout();
    }

    @When("the checkout attempt is made")
    public void theCheckoutAttemptIsMade() {
        attemptProceedToCheckout();
    }

    @Then("the system remains stable and responsive")
    public void theSystemRemainsStableAndResponsive() {
        verifySystemStability();
    }

    @When("the user interface is reviewed")
    public void theUserInterfaceIsReviewed() {
        reviewUserInterface();
    }

    @Then("the error message is displayed correctly without any layout issues")
    public void theErrorMessageIsDisplayedCorrectlyWithoutAnyLayoutIssues() {
        verifyErrorMessageLayout();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the cart remains empty")
    public void theCartRemainsEmpty() {
        verifyCartIsEmpty();
    }

    @Then("no checkout is possible")
    public void noCheckoutIsPossible() {
        verifyCheckoutNotAllowed();
    }

    @When("the order history is checked")
    public void theOrderHistoryIsChecked() {
        checkOrderHistory();
    }

    @Then("no order is found due to the empty cart")
    public void noOrderIsFoundDueToTheEmptyCart() {
        verifyNoOrderInHistory();
    }

    @Given("the user is on the cart page with an empty cart")
    public void theUserIsOnTheCartPageWithAnEmptyCart() {
        navigateToCartPage();
        verifyCartIsEmpty();
    }

    @When("the user attempts to navigate away from the cart page")
    public void theUserAttemptsToNavigateAwayFromTheCartPage() {
        attemptNavigateAwayFromCart();
    }

    @Then("a warning message is displayed asking to confirm navigation without proceeding to checkout")
    public void aWarningMessageIsDisplayedAskingToConfirmNavigationWithoutProceedingToCheckout() {
        verifyNavigationWarningMessage();
    }

    @When("the user reviews the system guidance")
    public void theUserReviewsTheSystemGuidance() {
        reviewSystemGuidance();
    }

    @Then("the system suggests adding items to the cart before proceeding to checkout")
    public void theSystemSuggestsAddingItemsToTheCartBeforeProceedingToCheckout() {
        verifySystemGuidanceForAddingItems();
    }

    @When("the URL is manipulated")
    public void theURLIsManipulated() {
        manipulateURL();
    }

    @Then("access is denied")
    public void accessIsDenied() {
        verifyAccessDenied();
    }

    @Then("the user is redirected back to the cart page")
    public void theUserIsRedirectedBackToTheCartPage() {
        verifyRedirectToCartPage();
    }

    @When("the user interacts with the system")
    public void theUserInteractsWithTheSystem() {
        interactWithSystem();
    }

    @Then("the system maintains a user-friendly experience with clear guidance and error messages")
    public void theSystemMaintainsAUserFriendlyExperienceWithClearGuidanceAndErrorMessages() {
        verifyUserFriendlyExperience();
    }

    @Given("the user is on the product details page")
    public void theUserIsOnTheProductDetailsPage() {
        navigateToProductDetailsPage();
    }

    @When("the user adds items from the product details page")
    public void theUserAddsItemsFromTheProductDetailsPage() {
        addItemsFromProductDetailsPage();
    }

    @Then("items are added successfully")
    public void itemsAreAddedSuccessfully() {
        verifyItemsAddedSuccessfully();
    }

    @Then("checkout proceeds smoothly")
    public void checkoutProceedsSmoothly() {
        verifySmoothCheckout();
    }
}