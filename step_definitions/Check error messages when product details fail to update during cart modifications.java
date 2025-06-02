package com.cucumber.steps;

import com.page_objects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartModificationSteps extends CartPage {

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("Product ID 98765 is added to the cart with an initial quantity of 3")
    public void productIsAddedToCart() {
        addProductToCart("98765", "3");
    }

    @When("User navigates to the shopping cart page")
    public void userNavigatesToShoppingCartPage() {
        openCart();
    }

    @Then("Shopping cart page displays correctly with initial quantity 3")
    public void shoppingCartPageDisplaysCorrectly() {
        verifyProductQuantity("98765", "3");
    }

    @When("User attempts to update the product quantity to 5")
    public void userAttemptsToUpdateProductQuantity() {
        updateProductQuantity("98765", "5");
    }

    @When("Simulate a failure in updating the product details")
    public void simulateFailureInUpdatingProductDetails() {
        simulateUpdateFailure();
    }

    @Then("System displays an error message indicating the update failure")
    public void systemDisplaysErrorMessage() {
        verifyErrorMessage("Update failed");
    }

    @Then("Error message clearly states the issue with updating product details")
    public void errorMessageClearlyStatesIssue() {
        verifyDetailedErrorMessage();
    }

    @Then("Cart maintains the original quantity and details")
    public void cartMaintainsOriginalQuantity() {
        verifyProductQuantity("98765", "3");
    }

    @When("User attempts to update other product details such as price or name")
    public void userAttemptsToUpdateOtherProductDetails() {
        updateProductDetails("98765");
    }

    @Then("Logs should reflect the error handling process for update failures")
    public void logsReflectErrorHandling() {
        verifyLogsForErrorHandling();
    }

    @Then("Users should understand the error message and how to resolve the issue")
    public void usersUnderstandErrorMessage() {
        verifyUserUnderstandingOfErrorMessage();
    }

    @Then("Product details remain consistent and accurately reflect available information")
    public void productDetailsRemainConsistent() {
        verifyProductDetailsConsistency("98765");
    }

    @Then("System scales effectively and maintains performance")
    public void systemScalesEffectively() {
        verifySystemScalability();
    }

    @Then("Cart functions should remain unaffected by update failures")
    public void cartFunctionsRemainUnaffected() {
        verifyCartFunctionality();
    }

    @Then("System should not display any warnings if functioning correctly")
    public void systemDisplaysNoWarnings() {
        verifyNoSystemWarnings();
    }
}