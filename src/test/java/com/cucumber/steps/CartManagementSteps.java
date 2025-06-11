package com.cucumber.steps;

import com.pageobjects.CartPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        String username = testHarness.getData("UserData", "Username");
        String password = testHarness.getData("UserData", "Password");
        login(username, password);
    }

    @Given("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        openCart();
    }

    @Then("the cart page is displayed with the list of products")
    public void theCartPageIsDisplayedWithTheListOfProducts() {
        verifyCartPageDisplayed();
    }

    @Then("at least one product is in the cart")
    public void atLeastOneProductIsInTheCart() {
        verifyProductInCart("12345");
    }

    @When("the user identifies the product with ID 12345 in the cart")
    public void theUserIdentifiesTheProductWithID12345InTheCart() {
        verifyProductInCart("12345");
    }

    @Then("product 12345 is located in the cart")
    public void product12345IsLocatedInTheCart() {
        verifyProductInCart("12345");
    }

    @When("the user clicks on the 'Remove' button next to product 12345")
    public void theUserClicksOnTheRemoveButtonNextToProduct12345() {
        removeProductFromCart("12345");
    }

    @Then("product 12345 is removed from the cart")
    public void product12345IsRemovedFromTheCart() {
        verifyProductRemoved("12345");
    }

    @Then("product 12345 no longer appears in the cart")
    public void product12345NoLongerAppearsInTheCart() {
        verifyProductRemoved("12345");
    }

    @Then("the cart total is updated to reflect the removal of product 12345")
    public void theCartTotalIsUpdatedToReflectTheRemovalOfProduct12345() {
        verifyCartTotalUpdated();
    }

    @Then("the cart icon reflects the updated number of items")
    public void theCartIconReflectsTheUpdatedNumberOfItems() {
        verifyCartIconUpdated();
    }

    @When("the user attempts to checkout with the remaining items in the cart")
    public void theUserAttemptsToCheckoutWithTheRemainingItemsInTheCart() {
        proceedToCheckout();
    }

    @Then("the checkout process proceeds without errors")
    public void theCheckoutProcessProceedsWithoutErrors() {
        verifyCheckoutProcess();
    }

    @Then("product 12345 is not included in the checkout summary")
    public void product12345IsNotIncludedInTheCheckoutSummary() {
        verifyProductNotInCheckoutSummary("12345");
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logout();
        login(testHarness.getData("UserData", "Username"), testHarness.getData("UserData", "Password"));
    }

    @Then("the cart remains consistent and product 12345 is still removed")
    public void theCartRemainsConsistentAndProduct12345IsStillRemoved() {
        verifyProductRemoved("12345");
    }

    @Then("the removal transaction for product 12345 is logged in the server logs")
    public void theRemovalTransactionForProduct12345IsLoggedInTheServerLogs() {
        verifyRemovalLogged("12345");
    }

    @Then("no errors are encountered during the removal process")
    public void noErrorsAreEncounteredDuringTheRemovalProcess() {
        verifyNoErrorsDuringRemoval();
    }

    @When("the user attempts to re-add product 12345 to the cart")
    public void theUserAttemptsToReAddProduct12345ToTheCart() {
        addProductToCart("12345");
    }

    @Then("product 12345 is successfully re-added to the cart")
    public void product12345IsSuccessfullyReAddedToTheCart() {
        verifyProductInCart("12345");
    }

    @When("the user removes product 12345 again")
    public void theUserRemovesProduct12345Again() {
        removeProductFromCart("12345");
    }

    @Then("product 12345 is removed from the cart once more")
    public void product12345IsRemovedFromTheCartOnceMore() {
        verifyProductRemoved("12345");
    }

    @Then("the cart updates correctly each time product 12345 is re-added and removed")
    public void theCartUpdatesCorrectlyEachTimeProduct12345IsReAddedAndRemoved() {
        verifyCartUpdatesCorrectly();
    }

    @Then("the cart remains functional for other operations")
    public void theCartRemainsFunctionalForOtherOperations() {
        verifyCartFunctionality();
    }
}