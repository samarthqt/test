package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalizedContentSteps extends PersonalizedContentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is logged into the retail platform")
    public void aUserIsLoggedIntoTheRetailPlatform() {
        loginUser();
    }

    @Given("the user has a browsing history of electronic products")
    public void theUserHasABrowsingHistoryOfElectronicProducts() {
        setBrowsingHistory("electronics");
    }

    @When("the user visits the homepage")
    public void theUserVisitsTheHomepage() {
        navigateToHomepage();
    }

    @Then("the user should see personalized banners related to electronic products")
    public void theUserShouldSeePersonalizedBannersRelatedToElectronicProducts() {
        verifyPersonalizedBanners("electronics");
    }

    @Given("the user has previously purchased clothing items")
    public void theUserHasPreviouslyPurchasedClothingItems() {
        setPurchaseHistory("clothing");
    }

    @When("the user visits the promotions page")
    public void theUserVisitsThePromotionsPage() {
        navigateToPromotionsPage();
    }

    @Then("the user should see personalized promotions related to clothing items")
    public void theUserShouldSeePersonalizedPromotionsRelatedToClothingItems() {
        verifyPersonalizedPromotions("clothing");
    }

    @Given("the user is logged into the retail platform for the first time")
    public void theUserIsLoggedIntoTheRetailPlatformForTheFirstTime() {
        loginUserFirstTime();
    }

    @When("the user visits any page on the platform")
    public void theUserVisitsAnyPageOnThePlatform() {
        navigateToAnyPage();
    }

    @Then("the user should see general promotional banners and content")
    public void theUserShouldSeeGeneralPromotionalBannersAndContent() {
        verifyGeneralPromotionalContent();
    }

    @Given("the user recently added kitchen appliances to their cart")
    public void theUserRecentlyAddedKitchenAppliancesToTheirCart() {
        addToCart("kitchen appliances");
    }

    @Then("the user should see updated personalized banners related to kitchen appliances")
    public void theUserShouldSeeUpdatedPersonalizedBannersRelatedToKitchenAppliances() {
        verifyUpdatedPersonalizedBanners("kitchen appliances");
    }

    @Given("the user has no browsing or purchase history")
    public void theUserHasNoBrowsingOrPurchaseHistory() {
        clearUserHistory();
    }

    @Then("the user should see default promotional content")
    public void theUserShouldSeeDefaultPromotionalContent() {
        verifyDefaultPromotionalContent();
    }

    @Given("the user interacts with personalized content such as clicking on a banner")
    public void theUserInteractsWithPersonalizedContentSuchAsClickingOnABanner() {
        interactWithPersonalizedContent();
    }

    @When("the user navigates through the platform")
    public void theUserNavigatesThroughThePlatform() {
        navigateThroughPlatform();
    }

    @Then("the user should experience enhanced engagement with relevant content and promotions")
    public void theUserShouldExperienceEnhancedEngagementWithRelevantContentAndPromotions() {
        verifyEnhancedUserEngagement();
    }
}