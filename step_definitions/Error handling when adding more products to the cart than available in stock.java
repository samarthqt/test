package com.cucumber.steps;

import com.page_objects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartErrorHandlingSteps extends CartPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the product page for Product ID {int}")
    public void theUserNavigatesToTheProductPageForProductID(int productId) {
        navigateToProductPage(productId);
    }

    @Then("the product page displays correctly with stock information")
    public void theProductPageDisplaysCorrectlyWithStockInformation() {
        verifyProductPageDisplaysCorrectly();
    }

    @Then("the product stock information is accurately updated in the system")
    public void theProductStockInformationIsAccuratelyUpdatedInTheSystem() {
        verifyStockInformationUpdated();
    }

    @Given("the available stock for Product ID {int} is {int}")
    public void theAvailableStockForProductIDIs(int productId, int stock) {
        setAvailableStock(productId, stock);
    }

    @When("the user enters a quantity of {int} into the quantity field")
    public void theUserEntersAQuantityOfIntoTheQuantityField(int quantity) {
        enterQuantity(quantity);
    }

    @When("clicks the 'Add to Cart' button")
    public void clicksTheAddToCartButton() {
        clickAddToCartButton();
    }

    @Then("the system displays an error message indicating insufficient stock")
    public void theSystemDisplaysAnErrorMessageIndicatingInsufficientStock() {
        verifyErrorMessageForInsufficientStock();
    }

    @Then("the cart does not contain the requested quantity")
    public void theCartDoesNotContainTheRequestedQuantity() {
        verifyCartDoesNotContainRequestedQuantity();
    }

    @Given("the user attempted to add more products than available in stock")
    public void theUserAttemptedToAddMoreProductsThanAvailableInStock() {
        attemptToAddMoreThanAvailableStock();
    }

    @Then("the error message clearly states the issue and available stock")
    public void theErrorMessageClearlyStatesTheIssueAndAvailableStock() {
        verifyErrorMessageClarityAndAccuracy();
    }

    @Given("the user adjusts the quantity to the available stock limit")
    public void theUserAdjustsTheQuantityToTheAvailableStockLimit() {
        adjustQuantityToAvailableStockLimit();
    }

    @Then("the system successfully adds the product to the cart")
    public void theSystemSuccessfullyAddsTheProductToTheCart() {
        verifyProductSuccessfullyAddedToCart();
    }

    @Then("the cart displays the correct quantity reflecting available stock")
    public void theCartDisplaysTheCorrectQuantityReflectingAvailableStock() {
        verifyCartDisplaysCorrectQuantity();
    }

    @When("the user enters a quantity of {int} into the quantity field")
    public void theUserEntersAQuantityOfZeroIntoTheQuantityField(int quantity) {
        enterQuantity(quantity);
    }

    @Then("the system should not add the product and may display a relevant message")
    public void theSystemShouldNotAddTheProductAndMayDisplayARelevantMessage() {
        verifyNoProductAddedForZeroQuantity();
    }

    @When("the user enters a negative quantity into the quantity field")
    public void theUserEntersANegativeQuantityIntoTheQuantityField() {
        enterNegativeQuantity();
    }

    @Then("the system should reject the input and display an error message")
    public void theSystemShouldRejectTheInputAndDisplayAnErrorMessage() {
        verifyErrorMessageForNegativeQuantity();
    }

    @When("the user enters a non-numeric quantity into the quantity field")
    public void theUserEntersANonNumericQuantityIntoTheQuantityField() {
        enterNonNumericQuantity();
    }

    @Then("the system should reject the input and display an error message")
    public void theSystemShouldRejectTheInputAndDisplayAnErrorMessage() {
        verifyErrorMessageForNonNumericQuantity();
    }

    @When("the user attempts actions that breach stock limits")
    public void theUserAttemptsActionsThatBreachStockLimits() {
        attemptActionsBreachingStockLimits();
    }

    @Then("the system logs should reflect the error handling process")
    public void theSystemLogsShouldReflectTheErrorHandlingProcess() {
        verifySystemLogsForErrorHandling();
    }

    @When("the user repeatedly attempts to add more products than available in stock")
    public void theUserRepeatedlyAttemptsToAddMoreProductsThanAvailableInStock() {
        repeatedlyAttemptToAddMoreThanAvailableStock();
    }

    @Then("the system remains responsive and handles errors gracefully")
    public void theSystemRemainsResponsiveAndHandlesErrorsGracefully() {
        verifySystemResponsiveness();
    }

    @Given("the user encounters error messages due to stock limit breaches")
    public void theUserEncountersErrorMessagesDueToStockLimitBreaches() {
        encounterErrorMessagesDueToStockLimitBreaches();
    }

    @Then("users should understand the error message and how to resolve the issue")
    public void usersShouldUnderstandTheErrorMessageAndHowToResolveTheIssue() {
        verifyUserUnderstandingOfErrorMessages();
    }

    @Given("the user attempts various actions related to stock limits")
    public void theUserAttemptsVariousActionsRelatedToStockLimits() {
        attemptVariousActionsRelatedToStockLimits();
    }

    @Then("stock levels remain consistent and accurately reflect available inventory")
    public void stockLevelsRemainConsistentAndAccuratelyReflectAvailableInventory() {
        verifyStockLevelsConsistency();
    }
}