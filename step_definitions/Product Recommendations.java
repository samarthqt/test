package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductRecommendationsSteps extends RecommendationsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is logged into the shopping platform")
    public void aUserIsLoggedIntoTheShoppingPlatform() {
        String userCredentials = testHarness.getData("UserData", "Credentials");
        loginToPlatform(userCredentials);
    }

    @Given("the user has a browsing history")
    public void theUserHasABrowsingHistory() {
        verifyBrowsingHistoryExists();
    }

    @When("the user navigates to the homepage")
    public void theUserNavigatesToTheHomepage() {
        navigateToHomepage();
    }

    @Then("personalized product recommendations should be displayed")
    public void personalizedProductRecommendationsShouldBeDisplayed() {
        verifyPersonalizedRecommendationsDisplayed();
    }

    @Then("recommendations should be based on the user's browsing behavior")
    public void recommendationsShouldBeBasedOnTheUsersBrowsingBehavior() {
        verifyRecommendationsBasedOnBrowsingBehavior();
    }

    @Given("the user views multiple products")
    public void theUserViewsMultipleProducts() {
        simulateUserViewingProducts();
    }

    @Then("the product recommendations should be updated")
    public void theProductRecommendationsShouldBeUpdated() {
        verifyRecommendationsUpdated();
    }

    @Then("recommendations should reflect the latest user interactions")
    public void recommendationsShouldReflectTheLatestUserInteractions() {
        verifyRecommendationsReflectLatestInteractions();
    }

    @Given("a new user logs into the shopping platform")
    public void aNewUserLogsIntoTheShoppingPlatform() {
        String newUserCredentials = testHarness.getData("UserData", "NewUserCredentials");
        loginToPlatform(newUserCredentials);
    }

    @Given("the user has no browsing history")
    public void theUserHasNoBrowsingHistory() {
        verifyNoBrowsingHistoryExists();
    }

    @Then("default product recommendations should be displayed")
    public void defaultProductRecommendationsShouldBeDisplayed() {
        verifyDefaultRecommendationsDisplayed();
    }

    @Then("recommendations should be based on popular products")
    public void recommendationsShouldBeBasedOnPopularProducts() {
        verifyRecommendationsBasedOnPopularProducts();
    }

    @Given("the user has a purchase history")
    public void theUserHasAPurchaseHistory() {
        verifyPurchaseHistoryExists();
    }

    @Then("recommendations should be based on the user's purchase history")
    public void recommendationsShouldBeBasedOnTheUsersPurchaseHistory() {
        verifyRecommendationsBasedOnPurchaseHistory();
    }

    @Given("there is a system error in fetching recommendations")
    public void thereIsASystemErrorInFetchingRecommendations() {
        simulateSystemErrorInFetchingRecommendations();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the user should be informed that recommendations are currently unavailable")
    public void theUserShouldBeInformedThatRecommendationsAreCurrentlyUnavailable() {
        verifyUserInformedRecommendationsUnavailable();
    }
}