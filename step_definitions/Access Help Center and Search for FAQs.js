import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HelpCenterPage from "../pages/helpCenterPage";

Given("the user is logged in with valid credentials", () => {
 cy.login();
});

When("the user navigates to the homepage", () => {
 cy.visit('/homepage');
});

Then("the main navigation bar is visible and accessible", () => {
 cy.get('nav').should('be.visible');
});

Given("the user is on the homepage", () => {
 cy.visit('/homepage');
});

When("the user clicks on the 'Help Center' link in the main navigation", () => {
 HelpCenterPage.clickHelpCenterLink();
});

Then("the user is redirected to the Help Center page", () => {
 cy.url().should('include', '/help-center');
});

Given("the user is on the Help Center page", () => {
 cy.visit('/help-center');
});

Then("the Help Center page displays FAQs and guides options", () => {
 HelpCenterPage.verifyFAQsAndGuidesOptions();
});

When("the user enters 'returns' in the FAQ search bar and clicks search", () => {
 HelpCenterPage.searchFAQ('returns');
});

Then("relevant FAQ results for 'returns' are displayed", () => {
 HelpCenterPage.verifyFAQResults('returns');
});

When("the user enters 'setup' in the guide search bar and clicks search", () => {
 HelpCenterPage.searchGuide('setup');
});

Then("relevant guide results for 'setup' are displayed", () => {
 HelpCenterPage.verifyGuideResults('setup');
});

Given("relevant FAQ results are displayed", () => {
 HelpCenterPage.verifyFAQResults('returns');
});

When("the user selects a FAQ from the search results", () => {
 HelpCenterPage.selectFAQ();
});

Then("the selected FAQ content is displayed correctly", () => {
 HelpCenterPage.verifySelectedFAQContent();
});

Given("relevant guide results are displayed", () => {
 HelpCenterPage.verifyGuideResults('setup');
});

When("the user selects a guide from the search results", () => {
 HelpCenterPage.selectGuide();
});

Then("the selected guide content is displayed correctly", () => {
 HelpCenterPage.verifySelectedGuideContent();
});

When("the user checks the page on different devices", () => {
 HelpCenterPage.checkResponsiveness();
});

Then("the Help Center page is responsive and displays correctly on all devices", () => {
 HelpCenterPage.verifyResponsiveness();
});

When("the user tests the search functionality with multiple keywords", () => {
 HelpCenterPage.testMultipleKeywords();
});

Then("search results are accurate and relevant to the keywords entered", () => {
 HelpCenterPage.verifyMultipleKeywordsResults();
});

When("the user accesses FAQ and guide content", () => {
 HelpCenterPage.accessFAQAndGuideContent();
});

Then("content loads within acceptable time limits", () => {
 HelpCenterPage.verifyContentLoadingTime();
});

When("the user checks for accessibility features", () => {
 HelpCenterPage.checkAccessibilityFeatures();
});

Then("accessibility features are present and functional", () => {
 HelpCenterPage.verifyAccessibilityFeatures();
});

Given("the user is logged out", () => {
 cy.logout();
});

When("the user attempts to access the Help Center", () => {
 HelpCenterPage.attemptAccessWhileLoggedOut();
});

Then("the user is prompted to log in to access the Help Center", () => {
 HelpCenterPage.verifyLoginPrompt();
});

When("the user enters special characters in the search bar", () => {
 HelpCenterPage.searchWithSpecialCharacters();
});

Then("the system handles special characters gracefully and returns relevant results", () => {
 HelpCenterPage.verifySpecialCharactersHandling();
});

When("the user accesses the Help Center during peak hours", () => {
 HelpCenterPage.accessDuringPeakHours();
});

Then("the Help Center remains accessible and performs well during peak hours", () => {
 HelpCenterPage.verifyPeakHoursPerformance();
});

When("the user searches using synonyms", () => {
 HelpCenterPage.searchWithSynonyms();
});

Then("search results include relevant synonyms", () => {
 HelpCenterPage.verifySynonymsResults();
});