package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CartPage;

public class CartManagementSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is on the product page")
    public void aUserIsOnTheProductPage() {
        navigateToProductPage();
    }

    @When("the user adds a product to the shopping cart")
    public void theUserAddsAProductToTheShoppingCart() {
        addProductToCart();
    }

    @Then("the product should be added to the shopping cart")
    public void theProductShouldBeAddedToTheShoppingCart() {
        verifyProductInCart();
    }

    @Then("the user should receive a notification of successful addition")
    public void theUserShouldReceiveANotificationOfSuccessfulAddition() {
        verifyAdditionNotification();
    }

    @Then("the system should log the add operation for auditing")
    public void theSystemShouldLogTheAddOperationForAuditing() {
        verifyAddOperationLogged();
    }

    @Given("a product is present in the shopping cart")
    public void aProductIsPresentInTheShoppingCart() {
        ensureProductInCart();
    }

    @When("the user removes the product from the shopping cart")
    public void theUserRemovesTheProductFromTheShoppingCart() {
        removeProductFromCart();
    }

    @Then("the product should be removed from the shopping cart")
    public void theProductShouldBeRemovedFromTheShoppingCart() {
        verifyProductNotInCart();
    }

    @Then("the user should receive a notification of successful removal")
    public void theUserShouldReceiveANotificationOfSuccessfulRemoval() {
        verifyRemovalNotification();
    }

    @Then("the system should log the remove operation for auditing")
    public void theSystemShouldLogTheRemoveOperationForAuditing() {
        verifyRemoveOperationLogged();
    }

    @When("the user modifies the quantity of the product")
    public void theUserModifiesTheQuantityOfTheProduct() {
        modifyProductQuantity();
    }

    @Then("the quantity should be updated immediately in the shopping cart")
    public void theQuantityShouldBeUpdatedImmediatelyInTheShoppingCart() {
        verifyQuantityUpdated();
    }

    @Then("the system should update the subtotal based on the new quantity")
    public void theSystemShouldUpdateTheSubtotalBasedOnTheNewQuantity() {
        verifySubtotalUpdated();
    }

    @Then("the user should receive a notification of successful modification")
    public void theUserShouldReceiveANotificationOfSuccessfulModification() {
        verifyModificationNotification();
    }

    @Then("the system should log the modify operation for auditing")
    public void theSystemShouldLogTheModifyOperationForAuditing() {
        verifyModifyOperationLogged();
    }

    @When("the user attempts to set a negative quantity for the product")
    public void theUserAttemptsToSetANegativeQuantityForTheProduct() {
        attemptNegativeQuantity();
    }

    @Then("the system should prevent the negative quantity")
    public void theSystemShouldPreventTheNegativeQuantity() {
        verifyNegativeQuantityPrevention();
    }

    @Then("the user should receive an error message that is user-friendly")
    public void theUserShouldReceiveAnErrorMessageThatIsUserFriendly() {
        verifyUserFriendlyErrorMessage();
    }

    @Given("a user is on a desktop or mobile platform")
    public void aUserIsOnADesktopOrMobilePlatform() {
        verifyPlatform();
    }

    @When("the user performs cart operations")
    public void theUserPerformsCartOperations() {
        performCartOperations();
    }

    @Then("the operations should be accessible and function correctly on both platforms")
    public void theOperationsShouldBeAccessibleAndFunctionCorrectlyOnBothPlatforms() {
        verifyOperationsOnPlatforms();
    }

    @Given("a user is performing cart operations")
    public void aUserIsPerformingCartOperations() {
        initiateCartOperations();
    }

    @When("an error occurs")
    public void anErrorOccurs() {
        simulateError();
    }

    @Then("the system should handle the error gracefully")
    public void theSystemShouldHandleTheErrorGracefully() {
        verifyErrorHandling();
    }

    @Then("provide a user-friendly message to the user")
    public void provideAUserFriendlyMessageToTheUser() {
        verifyUserFriendlyErrorMessage();
    }
}