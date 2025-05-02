package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistFunctionalitySteps extends WishlistPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        String loginURL = testHarness.getData("UserData", "LoginPageURL");
        navigateToPage(loginURL);
        performLogin();
    }

    @Given("the user is viewing a product page")
    public void theUserIsViewingAProductPage() {
        String productPageURL = testHarness.getData("ProductData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("the user clicks on the \"Add to Wishlist\" button")
    public void theUserClicksOnTheAddToWishlistButton() {
        addProductToWishlist();
    }

    @Then("the product should be added to the user's wishlist")
    public void theProductShouldBeAddedToTheUsersWishlist() {
        navigateToWishlist();
        verifyWishlistContainsItems();
    }

    @Then("a confirmation message should be displayed")
    public void aConfirmationMessageShouldBeDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @When("the user navigates to the wishlist page")
    public void theUserNavigatesToTheWishlistPage() {
        navigateToWishlist();
    }

    @Then("the user should see a list of products saved in their wishlist")
    public void theUserShouldSeeAListOfProductsSavedInTheirWishlist() {
        verifyWishlistContainsItems();
    }

    @Given("the user is viewing their wishlist")
    public void theUserIsViewingTheirWishlist() {
        navigateToWishlist();
    }

    @When("the user clicks on the \"Remove\" button next to a product")
    public void theUserClicksOnTheRemoveButtonNextToAProduct() {
        String productName = testHarness.getData("WishlistData", "ProductName");
        removeProductFromWishlist(productName);
    }

    @Then("the product should be removed from the wishlist")
    public void theProductShouldBeRemovedFromTheWishlist() {
        String productName = testHarness.getData("WishlistData", "ProductName");
        verifyProductRemoved(productName);
    }

    @When("the user clicks on the \"Add to Cart\" button next to a product")
    public void theUserClicksOnTheAddToCartButtonNextToAProduct() {
        addProductFromWishlistToCart();
    }

    @Then("the product should be added to the user's cart")
    public void theProductShouldBeAddedToTheUsersCart() {
        verifyProductInCart();
    }

    @Given("the user has no products in their wishlist")
    public void theUserHasNoProductsInTheirWishlist() {
        clearWishlist();
    }

    @Then("the user should see a message indicating that the wishlist is empty")
    public void theUserShouldSeeAMessageIndicatingThatTheWishlistIsEmpty() {
        verifyWishlistIsEmpty();
    }

    @Given("the user is not logged into their account")
    public void theUserIsNotLoggedIntoTheirAccount() {
        navigateToHomePage();
    }

    @Then("the user should be prompted to log in or create an account")
    public void theUserShouldBePromptedToLogInOrCreateAnAccount() {
        verifyLoginPromptDisplayed();
    }
}