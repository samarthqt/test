package com.cucumber.steps;

import com.page_objects.CartPersistencePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPersistenceSteps extends CartPersistencePage {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginUser();
    }

    @When("the user adds products to the shopping cart")
    public void theUserAddsProductsToTheShoppingCart() {
        addProductsToCart();
    }

    @Then("the products are successfully added to the cart")
    public void theProductsAreSuccessfullyAddedToTheCart() {
        verifyProductsInCart();
    }

    @Given("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        logoutUser();
    }

    @When("the user logs back into the session")
    public void theUserLogsBackIntoTheSession() {
        loginUser();
    }

    @Then("the shopping cart displays previously added products")
    public void theShoppingCartDisplaysPreviouslyAddedProducts() {
        verifyProductsInCart();
    }

    @Given("the user navigates to the shopping cart")
    public void theUserNavigatesToTheShoppingCart() {
        navigateToCart();
    }

    @Then("the product details and quantities match the previous session")
    public void theProductDetailsAndQuantitiesMatchThePreviousSession() {
        verifyProductDetailsAndQuantities();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        logoutUser();
    }

    @When("the user logs in from a different device")
    public void theUserLogsInFromADifferentDevice() {
        loginUserOnDifferentDevice();
    }

    @Then("the cart contents remain consistent across devices")
    public void theCartContentsRemainConsistentAcrossDevices() {
        verifyCartConsistencyAcrossDevices();
    }

    @Given("the user adds more products to the cart")
    public void theUserAddsMoreProductsToTheCart() {
        addMoreProductsToCart();
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        logoutUser();
    }

    @Then("the new products are added successfully")
    public void theNewProductsAreAddedSuccessfully() {
        verifyNewProductsInCart();
    }

    @Given("the user logs back in")
    public void theUserLogsBackIn() {
        loginUser();
    }

    @Then("the cart should reflect new additions accurately")
    public void theCartShouldReflectNewAdditionsAccurately() {
        verifyCartReflectsNewAdditions();
    }

    @Given("the user clears browser cache")
    public void theUserClearsBrowserCache() {
        clearBrowserCache();
    }

    @When("the user logs in again")
    public void theUserLogsInAgain() {
        loginUser();
    }

    @Then("the cart contents should remain intact despite cache clearing")
    public void theCartContentsShouldRemainIntactDespiteCacheClearing() {
        verifyCartIntactAfterCacheClearing();
    }

    @Given("the user switches network")
    public void theUserSwitchesNetwork() {
        switchNetwork();
    }

    @When("the user logs in")
    public void theUserLogsIn() {
        loginUser();
    }

    @Then("the cart persistence should be unaffected by network changes")
    public void theCartPersistenceShouldBeUnaffectedByNetworkChanges() {
        verifyCartPersistenceUnaffectedByNetworkChanges();
    }

    @Given("the user repeats the test on a mobile browser")
    public void theUserRepeatsTheTestOnAMobileBrowser() {
        repeatTestOnMobileBrowser();
    }

    @Then("the cart contents should persist on mobile browsers too")
    public void theCartContentsShouldPersistOnMobileBrowsersToo() {
        verifyCartPersistenceOnMobileBrowser();
    }

    @Given("the user navigates to the shopping cart")
    public void theUserNavigatesToTheShoppingCart() {
        navigateToCart();
    }

    @Then("the cart total should be accurate and consistent")
    public void theCartTotalShouldBeAccurateAndConsistent() {
        verifyCartTotalAccuracy();
    }

    @Given("the user attempts to remove a product")
    public void theUserAttemptsToRemoveAProduct() {
        attemptToRemoveProduct();
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        logoutUser();
    }

    @Then("the product removal should be successful and reflect in the next session")
    public void theProductRemovalShouldBeSuccessfulAndReflectInTheNextSession() {
        verifyProductRemovalPersistence();
    }

    @Given("the user logs in using a guest account")
    public void theUserLogsInUsingAGuestAccount() {
        loginUserAsGuest();
    }

    @Then("the guest cart should not persist across sessions")
    public void theGuestCartShouldNotPersistAcrossSessions() {
        verifyGuestCartNonPersistence();
    }

    @Given("the user performs session transitions")
    public void theUserPerformsSessionTransitions() {
        performSessionTransitions();
    }

    @Then("no console errors should appear during the test execution")
    public void noConsoleErrorsShouldAppearDuringTheTestExecution() {
        verifyNoConsoleErrorsDuringSessionTransitions();
    }
}