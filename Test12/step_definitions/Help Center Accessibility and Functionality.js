import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HelpCenterPage from "../pages/helpCenterPage";

Given("the user is on the web platform", () => {
 HelpCenterPage.visitWebPlatform();
});

Given("the user is on the mobile platform", () => {
 HelpCenterPage.visitMobilePlatform();
});

Given("the user is in the help center", () => {
 HelpCenterPage.visitHelpCenter();
});

Given("the user is in the FAQs section of the help center", () => {
 HelpCenterPage.visitFAQsSection();
});

Given("the user is in the troubleshooting guides section of the help center", () => {
 HelpCenterPage.visitTroubleshootingGuidesSection();
});

Given("the user is viewing a help center article", () => {
 HelpCenterPage.viewArticle();
});

Given("the user is authenticated", () => {
 HelpCenterPage.authenticateUser();
});

Given("the user is not authenticated", () => {
 HelpCenterPage.deauthenticateUser();
});

Given("the user is interacting with the help center", () => {
 HelpCenterPage.interactWithHelpCenter();
});

When("the user navigates to the help center", () => {
 HelpCenterPage.navigateToHelpCenter();
});

When("the user selects a category", () => {
 HelpCenterPage.selectCategory();
});

When("the user searches for a keyword", () => {
 HelpCenterPage.searchFAQs("keyword");
});

When("the user opens a troubleshooting guide", () => {
 HelpCenterPage.openTroubleshootingGuide();
});

When("the user views an article", () => {
 HelpCenterPage.viewArticle();
});

When("the user provides feedback on the article", () => {
 HelpCenterPage.provideFeedback();
});

When("the user accesses the help center", () => {
 HelpCenterPage.accessHelpCenter();
});

When("the user performs any action", () => {
 HelpCenterPage.performAction();
});

Then("the help center should be displayed", () => {
 HelpCenterPage.verifyHelpCenterDisplayed();
});

Then("content related to the selected category should be displayed", () => {
 HelpCenterPage.verifyCategoryContentDisplayed();
});

Then("FAQs related to the keyword should be displayed", () => {
 HelpCenterPage.verifyFAQsDisplayed("keyword");
});

Then("step-by-step instructions should be displayed", () => {
 HelpCenterPage.verifyTroubleshootingInstructionsDisplayed();
});

Then("the content should be up-to-date and accurate", () => {
 HelpCenterPage.verifyContentUpToDateAndAccurate();
});

Then("the feedback should be submitted successfully", () => {
 HelpCenterPage.verifyFeedbackSubmitted();
});

Then("the content should be accessible", () => {
 HelpCenterPage.verifyContentAccessible();
});

Then("the interaction should be logged for content improvement", () => {
 HelpCenterPage.verifyInteractionLogged();
});