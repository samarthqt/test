package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.HomePage;
import com.page_objects.ProductListingPage;
import com.page_objects.NavigationPage;
import com.page_objects.SearchPage;
import com.page_objects.FeedbackPage;
import com.page_objects.AccessibilityPage;
import com.page_objects.ResponsivePage;
import com.page_objects.ErrorPage;
import com.page_objects.UserTestingPage;
import com.page_objects.DesignReviewPage;

public class UserInterfaceSteps extends HomePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user views the product categories")
    public void theUserViewsTheProductCategories() {
        viewProductCategories();
    }

    @Then("the categories should be clearly labeled")
    public void theCategoriesShouldBeClearlyLabeled() {
        verifyCategoriesLabeled();
    }

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        navigateToProductListingPage();
    }

    @When("the user applies a filter")
    public void theUserAppliesAFilter() {
        applyFilter();
    }

    @Then("the filter should be easy to apply")
    public void theFilterShouldBeEasyToApply() {
        verifyFilterEase();
    }

    @Then("the results should update responsively")
    public void theResultsShouldUpdateResponsively() {
        verifyResponsiveResults();
    }

    @Given("the user is on any page of the application")
    public void theUserIsOnAnyPageOfTheApplication() {
        navigateToAnyPage();
    }

    @When("the user navigates to another page")
    public void theUserNavigatesToAnotherPage() {
        navigateToAnotherPage();
    }

    @Then("the navigation should be consistent across all pages")
    public void theNavigationShouldBeConsistentAcrossAllPages() {
        verifyConsistentNavigation();
    }

    @When("the user enters a search query")
    public void theUserEntersASearchQuery() {
        enterSearchQuery();
    }

    @Then("the search results should be relevant")
    public void theSearchResultsShouldBeRelevant() {
        verifyRelevantSearchResults();
    }

    @Then("the results should be returned quickly")
    public void theResultsShouldBeReturnedQuickly() {
        verifyQuickSearchResults();
    }

    @Given("the application has received user feedback")
    public void theApplicationHasReceivedUserFeedback() {
        receiveUserFeedback();
    }

    @When("the feedback is reviewed")
    public void theFeedbackIsReviewed() {
        reviewFeedback();
    }

    @Then("the feedback should be incorporated into the UI design")
    public void theFeedbackShouldBeIncorporatedIntoTheUIDesign() {
        incorporateFeedbackIntoUIDesign();
    }

    @Given("the user is using assistive technologies")
    public void theUserIsUsingAssistiveTechnologies() {
        useAssistiveTechnologies();
    }

    @When("the user interacts with the application")
    public void theUserInteractsWithTheApplication() {
        interactWithApplication();
    }

    @Then("the application should meet accessibility standards")
    public void theApplicationShouldMeetAccessibilityStandards() {
        verifyAccessibilityStandards();
    }

    @Given("the user is using a device with different screen sizes")
    public void theUserIsUsingADeviceWithDifferentScreenSizes() {
        useDeviceWithDifferentScreenSizes();
    }

    @When("the user views the application")
    public void theUserViewsTheApplication() {
        viewApplication();
    }

    @Then("the UI should be responsive to different screen sizes")
    public void theUIShouldBeResponsiveToDifferentScreenSizes() {
        verifyUIResponsiveness();
    }

    @Given("the user performs an invalid action")
    public void theUserPerformsAnInvalidAction() {
        performInvalidAction();
    }

    @When("the error message is displayed")
    public void theErrorMessageIsDisplayed() {
        displayErrorMessage();
    }

    @Then("the error message should be clear")
    public void theErrorMessageShouldBeClear() {
        verifyClearErrorMessage();
    }

    @Then("the error message should be actionable")
    public void theErrorMessageShouldBeActionable() {
        verifyActionableErrorMessage();
    }

    @Given("user testing is conducted")
    public void userTestingIsConducted() {
        conductUserTesting();
    }

    @When("the user tests the application navigation")
    public void theUserTestsTheApplicationNavigation() {
        testApplicationNavigation();
    }

    @Then("the navigation should be validated for ease of use")
    public void theNavigationShouldBeValidatedForEaseOfUse() {
        validateNavigationEase();
    }

    @Given("the application design is reviewed")
    public void theApplicationDesignIsReviewed() {
        reviewApplicationDesign();
    }

    @When("the design is compared with branding guidelines")
    public void theDesignIsComparedWithBrandingGuidelines() {
        compareDesignWithBrandingGuidelines();
    }

    @Then("the design should align with branding guidelines")
    public void theDesignShouldAlignWithBrandingGuidelines() {
        verifyDesignAlignment();
    }
}