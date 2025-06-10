package com.cucumber.steps;

import com.page_objects.HelpCenterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelpCenterSteps extends HelpCenterPage {

    @Given("the user is on the web platform")
    public void theUserIsOnTheWebPlatform() {
        navigateToWebPlatform();
    }

    @Given("the user is on the mobile platform")
    public void theUserIsOnTheMobilePlatform() {
        navigateToMobilePlatform();
    }

    @Given("the user is in the help center")
    public void theUserIsInTheHelpCenter() {
        navigateToHelpCenter();
    }

    @Given("the user is in the FAQs section of the help center")
    public void theUserIsInTheFAQsSectionOfTheHelpCenter() {
        navigateToFAQsSection();
    }

    @Given("the user is in the troubleshooting guides section of the help center")
    public void theUserIsInTheTroubleshootingGuidesSectionOfTheHelpCenter() {
        navigateToTroubleshootingGuidesSection();
    }

    @Given("the user is authenticated")
    public void theUserIsAuthenticated() {
        authenticateUser();
    }

    @Given("the user is not authenticated")
    public void theUserIsNotAuthenticated() {
        ensureUserIsNotAuthenticated();
    }

    @Given("the user is viewing a help center article")
    public void theUserIsViewingAHelpCenterArticle() {
        viewHelpCenterArticle();
    }

    @Given("the user is interacting with the help center")
    public void theUserIsInteractingWithTheHelpCenter() {
        interactWithHelpCenter();
    }

    @When("the user navigates to the help center")
    public void theUserNavigatesToTheHelpCenter() {
        navigateToHelpCenter();
    }

    @When("the user selects a category")
    public void theUserSelectsACategory() {
        selectCategory();
    }

    @When("the user searches for a keyword")
    public void theUserSearchesForAKeyword() {
        searchFAQsByKeyword();
    }

    @When("the user opens a troubleshooting guide")
    public void theUserOpensATroubleshootingGuide() {
        openTroubleshootingGuide();
    }

    @When("the user views an article")
    public void theUserViewsAnArticle() {
        viewArticle();
    }

    @When("the user provides feedback on the article")
    public void theUserProvidesFeedbackOnTheArticle() {
        provideFeedbackOnArticle();
    }

    @When("the user accesses the help center")
    public void theUserAccessesTheHelpCenter() {
        accessHelpCenter();
    }

    @When("the user performs any action")
    public void theUserPerformsAnyAction() {
        performAction();
    }

    @Then("the help center should be displayed")
    public void theHelpCenterShouldBeDisplayed() {
        verifyHelpCenterDisplayed();
    }

    @Then("content related to the selected category should be displayed")
    public void contentRelatedToTheSelectedCategoryShouldBeDisplayed() {
        verifyCategoryContentDisplayed();
    }

    @Then("FAQs related to the keyword should be displayed")
    public void faqsRelatedToTheKeywordShouldBeDisplayed() {
        verifyFAQsDisplayed();
    }

    @Then("step-by-step instructions should be displayed")
    public void stepByStepInstructionsShouldBeDisplayed() {
        verifyInstructionsDisplayed();
    }

    @Then("the content should be up-to-date and accurate")
    public void theContentShouldBeUpToDateAndAccurate() {
        verifyContentUpToDateAndAccurate();
    }

    @Then("the feedback should be submitted successfully")
    public void theFeedbackShouldBeSubmittedSuccessfully() {
        verifyFeedbackSubmitted();
    }

    @Then("the content should be accessible")
    public void theContentShouldBeAccessible() {
        verifyContentAccessible();
    }

    @Then("the interaction should be logged for content improvement")
    public void theInteractionShouldBeLoggedForContentImprovement() {
        verifyInteractionLogged();
    }
}