package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RecommendationsPage;

public class RecommendationsSteps extends RecommendationsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with browsing history of Electronics and Books")
    public void userAccountWithBrowsingHistory() {
        setupUserBrowsingHistory("Electronics", "Books");
    }

    @Given("a purchase history of Smartphone and Fiction Novel")
    public void userPurchaseHistory() {
        setupUserPurchaseHistory("Smartphone", "Fiction Novel");
    }

    @When("the user logs into the application")
    public void userLogsIntoApplication() {
        loginUser();
    }

    @When("navigates to the homepage")
    public void navigateToHomepage() {
        goToHomepage();
    }

    @Then("the homepage should display personalized recommendations including electronics and books related items")
    public void verifyHomepageRecommendations() {
        checkHomepageRecommendations("Electronics", "Books");
    }

    @Given("the user is on the homepage")
    public void userOnHomepage() {
        goToHomepage();
    }

    @When("the user navigates to the product page of a recently browsed category")
    public void navigateToProductPage() {
        goToProductPage("Recently Browsed");
    }

    @Then("the product page should display related recommendations based on browsing history")
    public void verifyProductPageRecommendations() {
        checkProductPageRecommendations("Browsing History");
    }

    @When("the user checks the recommendations section")
    public void checkRecommendationsSection() {
        openRecommendationsSection();
    }

    @Then("recommendations should include accessories for the smartphone and similar genre novels")
    public void verifyRecommendationsForPurchases() {
        checkRecommendationsForPurchases("Smartphone", "Fiction Novel");
    }

    @When("the user adds a camera to the browsing history")
    public void addCameraToBrowsingHistory() {
        addToBrowsingHistory("Camera");
    }

    @When("refreshes the homepage recommendations")
    public void refreshHomepageRecommendations() {
        refreshRecommendations();
    }

    @Then("recommendations should update to include camera-related products")
    public void verifyUpdatedRecommendations() {
        checkUpdatedRecommendations("Camera");
    }

    @Given("the user has purchased a camera lens")
    public void userPurchasedCameraLens() {
        addPurchaseHistory("Camera Lens");
    }

    @Then("recommendations should include accessories for the camera lens")
    public void verifyCameraLensRecommendations() {
        checkRecommendationsForPurchases("Camera Lens");
    }

    @Given("the user logs out and logs back into the application")
    public void userReLogin() {
        logoutAndLogin();
    }

    @Then("the user should see consistent recommendations with updated browsing and purchase history")
    public void verifyConsistentRecommendations() {
        checkConsistentRecommendations();
    }

    @Given("the user is logged in")
    public void userLoggedIn() {
        loginUser();
    }

    @When("the user checks recommendations on the deals page")
    public void checkDealsPageRecommendations() {
        goToDealsPage();
        openRecommendationsSection();
    }

    @Then("recommendations should align with user history across different sections")
    public void verifyDealsPageRecommendations() {
        checkRecommendationsAcrossSections();
    }

    @Given("the user clears their browsing history")
    public void clearBrowsingHistory() {
        clearUserBrowsingHistory();
    }

    @Then("recommendations should adjust to focus more on purchase history")
    public void verifyRecommendationsAfterClearingHistory() {
        checkRecommendationsAfterClearingHistory();
    }

    @Given("the user deletes a past purchase from the history")
    public void deletePastPurchase() {
        deletePurchaseHistory();
    }

    @Then("recommendations should adjust, removing items related to the deleted purchase")
    public void verifyRecommendationsAfterDeletingPurchase() {
        checkRecommendationsAfterDeletingPurchase();
    }

    @Given("different user profiles with unique browsing and purchase histories")
    public void setupDifferentUserProfiles() {
        setupMultipleUserProfiles();
    }

    @When("the user logs into each profile")
    public void loginToEachProfile() {
        loginToProfiles();
    }

    @Then("recommendations should be personalized and accurate for each user profile")
    public void verifyPersonalizedRecommendations() {
        checkPersonalizedRecommendations();
    }
}