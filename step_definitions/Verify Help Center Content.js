import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HelpCenterPage from "../pages/helpCenterPage";

Given("the user is logged into the application", () => {
 cy.login();
});

Given("the user is not logged into the application", () => {
 cy.logout();
});

Given("the user is in the help center section", () => {
 HelpCenterPage.visitHelpCenter();
});

Given("the user has searched for a FAQ topic", () => {
 HelpCenterPage.searchFAQ("topic");
});

Given("the user is in the guides section", () => {
 HelpCenterPage.visitGuidesSection();
});

Given("the user is viewing a guide topic", () => {
 HelpCenterPage.selectGuideTopic("guide");
});

Given("the user is using different browsers", () => {
 cy.visitWithMultipleBrowsers("/help-center");
});

Given("the user is using a mobile device", () => {
 cy.viewport("iphone-x");
 cy.visit("/help-center");
});

Given("the user is accessing the help center during peak times", () => {
 cy.visitDuringPeakTimes("/help-center");
});

Given("the user is interacting with the help center", () => {
 HelpCenterPage.interactWithContent();
});

When("the user navigates to the help center section of the application", () => {
 HelpCenterPage.visitHelpCenter();
});

When("the user searches for a specific FAQ topic using the search bar", () => {
 HelpCenterPage.searchFAQ("specific topic");
});

When("the user selects a FAQ topic from the list", () => {
 HelpCenterPage.selectFAQTopic("topic");
});

When("the user navigates to the guides section", () => {
 HelpCenterPage.visitGuidesSection();
});

When("the user selects a guide topic", () => {
 HelpCenterPage.selectGuideTopic("guide");
});

When("the user checks for downloadable resources", () => {
 HelpCenterPage.checkDownloadableResources();
});

When("the user checks for broken links within FAQs and guides", () => {
 HelpCenterPage.checkBrokenLinks();
});

When("the user attempts to access help center content", () => {
 cy.visit("/help-center");
});

When("the user accesses the help center", () => {
 cy.visit("/help-center");
});

When("the user checks the content", () => {
 HelpCenterPage.checkContentUpdates();
});

When("the user uses the search bar", () => {
 HelpCenterPage.searchFAQ("query");
});

When("the help center loads", () => {
 cy.visit("/help-center");
});

When("the user performs actions within the help center", () => {
 HelpCenterPage.performActions();
});

When("the user navigates through the help center", () => {
 HelpCenterPage.navigateHelpCenter();
});

Then("the help center section is displayed with search functionality", () => {
 HelpCenterPage.verifyHelpCenterDisplayed();
});

Then("relevant FAQ topics are listed based on the search query", () => {
 HelpCenterPage.verifyFAQResults("specific topic");
});

Then("FAQ content is displayed with detailed information", () => {
 HelpCenterPage.verifyFAQContentDisplayed();
});

Then("the guides section is displayed with various guide topics", () => {
 HelpCenterPage.verifyGuidesSectionDisplayed();
});

Then("guide content is displayed with step-by-step instructions", () => {
 HelpCenterPage.verifyGuideContentDisplayed();
});

Then("downloadable resources are available and accessible", () => {
 HelpCenterPage.verifyDownloadableResourcesAvailable();
});

Then("no broken links are found", () => {
 HelpCenterPage.verifyNoBrokenLinks();
});

Then("help center content is accessible without login", () => {
 HelpCenterPage.verifyContentAccessibleWithoutLogin();
});

Then("the help center functions correctly across different browsers", () => {
 HelpCenterPage.verifyCrossBrowserCompatibility();
});

Then("help center content is accessible and properly formatted on mobile devices", () => {
 HelpCenterPage.verifyMobileContentFormatting();
});

Then("the content reflects recent updates and changes", () => {
 HelpCenterPage.verifyContentUpdates();
});

Then("the search bar returns accurate results based on input", () => {
 HelpCenterPage.verifySearchResults("query");
});

Then("the help center loads within expected time frame", () => {
 HelpCenterPage.verifyResponseTime();
});

Then("user interactions are logged in CRM systems", () => {
 HelpCenterPage.verifyCRMIntegration();
});

Then("the help center remains accessible and responsive during peak times", () => {
 HelpCenterPage.verifyPeakTimeAccessibility();
});