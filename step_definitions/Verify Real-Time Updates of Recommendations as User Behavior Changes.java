package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RecommendationPage;

public class RecommendationSteps extends RecommendationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user starts browsing home decor items")
    public void theUserStartsBrowsingHomeDecorItems() {
        browseCategory("Home Decor");
    }

    @Then("the recommendations section on the homepage should focus on home decor items")
    public void theRecommendationsSectionOnTheHomepageShouldFocusOnHomeDecorItems() {
        verifyRecommendations("Home Decor");
    }

    @When("the user shifts browsing behavior to electronics items")
    public void theUserShiftsBrowsingBehaviorToElectronicsItems() {
        browseCategory("Electronics");
    }

    @Then("the recommendations should update to include electronics items")
    public void theRecommendationsShouldUpdateToIncludeElectronicsItems() {
        verifyRecommendations("Electronics");
    }

    @Given("the user is browsing electronics items")
    public void theUserIsBrowsingElectronicsItems() {
        browseCategory("Electronics");
    }

    @When("the user adds an electronic item to the cart")
    public void theUserAddsAnElectronicItemToTheCart() {
        addItemToCart("Electronics");
    }

    @Then("the item should be successfully added to the cart")
    public void theItemShouldBeSuccessfullyAddedToTheCart() {
        verifyItemInCart("Electronics");
    }

    @Then("the recommendations should further refine to include accessories related to the cart item")
    public void theRecommendationsShouldFurtherRefineToIncludeAccessoriesRelatedToTheCartItem() {
        verifyRecommendations("Electronics Accessories");
    }

    @Given("the user changes browsing category to fashion")
    public void theUserChangesBrowsingCategoryToFashion() {
        browseCategory("Fashion");
    }

    @When("the user starts browsing fashion items")
    public void theUserStartsBrowsingFashionItems() {
        browseCategory("Fashion");
    }

    @Then("the recommendations should quickly adapt to focus on fashion items")
    public void theRecommendationsShouldQuicklyAdaptToFocusOnFashionItems() {
        verifyRecommendations("Fashion");
    }

    @Given("the user purchases a fashion item")
    public void theUserPurchasesAFashionItem() {
        purchaseItem("Fashion");
    }

    @Then("the recommendations should include complementary fashion items post-purchase")
    public void theRecommendationsShouldIncludeComplementaryFashionItemsPostPurchase() {
        verifyRecommendations("Complementary Fashion");
    }

    @Given("the user logs out and logs back into the application")
    public void theUserLogsOutAndLogsBackIntoTheApplication() {
        logoutAndLogin();
    }

    @Then("the user should be successfully logged in with updated recommendations")
    public void theUserShouldBeSuccessfullyLoggedInWithUpdatedRecommendations() {
        verifyLoginAndRecommendations();
    }

    @Then("the recommendations should remain consistent with updated browsing and purchase behavior")
    public void theRecommendationsShouldRemainConsistentWithUpdatedBrowsingAndPurchaseBehavior() {
        verifyConsistentRecommendations();
    }

    @Given("the user performs rapid category changes")
    public void theUserPerformsRapidCategoryChanges() {
        performRapidCategoryChanges();
    }

    @Then("the system should efficiently update recommendations with each category change")
    public void theSystemShouldEfficientlyUpdateRecommendationsWithEachCategoryChange() {
        verifyEfficientRecommendationUpdates();
    }

    @Given("the user tests recommendation updates on different devices simultaneously")
    public void theUserTestsRecommendationUpdatesOnDifferentDevicesSimultaneously() {
        testRecommendationsOnMultipleDevices();
    }

    @Then("the recommendations should sync in real-time across all devices")
    public void theRecommendationsShouldSyncInRealTimeAcrossAllDevices() {
        verifyRealTimeSyncAcrossDevices();
    }

    @Given("the user clears browsing history")
    public void theUserClearsBrowsingHistory() {
        clearBrowsingHistory();
    }

    @Then("the recommendations should adjust to focus more on recent behavior")
    public void theRecommendationsShouldAdjustToFocusMoreOnRecentBehavior() {
        verifyRecommendationsAfterHistoryClear();
    }

    @Given("the user repeats the real-time update verification process for different user profiles")
    public void theUserRepeatsTheRealTimeUpdateVerificationProcessForDifferentUserProfiles() {
        repeatVerificationForDifferentProfiles();
    }

    @Then("the recommendations should be personalized and real-time for each user profile")
    public void theRecommendationsShouldBePersonalizedAndRealTimeForEachUserProfile() {
        verifyPersonalizedRecommendations();
    }
}