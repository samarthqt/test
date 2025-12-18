package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStatePersistenceAcrossSessionsSteps extends CartStatePersistenceAcrossSessionsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has an account and is on the application")
    public void theUserHasAnAccountAndIsOnTheApplication() {
        navigateToApplication();
    }

    @When("the user logs into the application and adds {string} to the cart")
    public void theUserLogsIntoTheApplicationAndAddsToTheCart(String item) {
        loginUser();
        addItemToCart(item);
    }

    @Then("the {string} is added to the user's cart")
    public void theIsAddedToTheUsersCart(String item) {
        verifyItemInCart(item);
    }

    @When("the user logs out of the application")
    public void theUserLogsOutOfTheApplication() {
        logoutUser();
    }

    @Then("the user successfully logs out")
    public void theUserSuccessfullyLogsOut() {
        verifyLogoutSuccess();
    }

    @When("the user logs back into the application")
    public void theUserLogsBackIntoTheApplication() {
        loginUser();
    }

    @Then("the user successfully logs in")
    public void theUserSuccessfullyLogsIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed")
    public void theCartPageIsDisplayed() {
        verifyCartPageDisplay();
    }

    @When("the user verifies the presence of {string} and {string} in the cart")
    public void theUserVerifiesThePresenceOfExistingItem1AndExistingItem2InTheCart(String existingItem1, String existingItem2) {
        verifyItemsInCart(existingItem1, existingItem2);
    }

    @Then("{string} and {string} are present in the cart")
    public void existingItem1AndExistingItem2ArePresentInTheCart(String existingItem1, String existingItem2) {
        verifyItemsInCart(existingItem1, existingItem2);
    }

    @When("the user modifies the quantity of {string}")
    public void theUserModifiesTheQuantityOfExistingItem1(String existingItem1) {
        modifyItemQuantity(existingItem1);
    }

    @Then("the quantity of {string} is updated in the cart")
    public void theQuantityOfExistingItem1IsUpdatedInTheCart(String existingItem1) {
        verifyItemQuantity(existingItem1);
    }

    @When("the user logs out of the application")
    public void theUserLogsOutOfTheApplicationAgain() {
        logoutUser();
    }

    @Then("the user successfully logs out")
    public void theUserSuccessfullyLogsOutAgain() {
        verifyLogoutSuccess();
    }

    @When("the user logs back into the application")
    public void theUserLogsBackIntoTheApplicationAgain() {
        loginUser();
    }

    @Then("the user successfully logs in")
    public void theUserSuccessfullyLogsInAgain() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the cart")
    public void theUserNavigatesToTheCart() {
        navigateToCartPage();
    }

    @Then("the cart is displayed with previous items")
    public void theCartIsDisplayedWithPreviousItems() {
        verifyCartPageDisplay();
    }

    @When("the user checks the quantity of {string} in the cart")
    public void theUserChecksTheQuantityOfExistingItem1InTheCart(String existingItem1) {
        verifyItemQuantity(existingItem1);
    }

    @Then("the quantity of {string} is as last modified")
    public void theQuantityOfExistingItem1IsAsLastModified(String existingItem1) {
        verifyItemQuantity(existingItem1);
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("the checkout page is displayed with correct cart details")
    public void theCheckoutPageIsDisplayedWithCorrectCartDetails() {
        verifyCheckoutDetails();
    }

    @When("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        confirmOrder();
    }

    @Then("the order confirmation page is displayed")
    public void theOrderConfirmationPageIsDisplayed() {
        verifyOrderConfirmation();
    }
}
