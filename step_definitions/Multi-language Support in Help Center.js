import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HelpCenterPage from "../pages/helpCenterPage";

Given("the user is logged in", () => {
 // Logic to ensure the user is logged in
});

When("the user navigates to the Help Center page", () => {
 HelpCenterPage.visit();
});

Then("the Help Center page is displayed", () => {
 HelpCenterPage.verifyPageDisplayed();
});

Given("the user is on the Help Center page", () => {
 HelpCenterPage.visit();
});

When("the user selects {string} from the language options", (language) => {
 HelpCenterPage.selectLanguage(language);
});

Then("the Help Center content is displayed in {string}", (language) => {
 HelpCenterPage.verifyContentLanguage(language);
});

Given("the network condition is {string}", (networkType) => {
 cy.setNetworkCondition(networkType);
});

When("the user loads Help Center content", () => {
 HelpCenterPage.loadContent();
});

Then("the Help Center content loads within acceptable time limits", () => {
 HelpCenterPage.verifyLoadTime();
});

Given("the user has selected a language", () => {
 HelpCenterPage.selectDefaultLanguage();
});

When("the user logs out and logs back in", () => {
 HelpCenterPage.logout();
 HelpCenterPage.login();
});

Then("the selected language persists across user sessions", () => {
 HelpCenterPage.verifyLanguagePersistence();
});

When("the user tests accessibility features in different languages", () => {
 HelpCenterPage.testAccessibilityFeatures();
});

Then("the accessibility features are functional in all languages", () => {
 HelpCenterPage.verifyAccessibilityFeatures();
});

When("the user reviews the language translations", () => {
 HelpCenterPage.reviewTranslations();
});

Then("the translations are accurate and error-free", () => {
 HelpCenterPage.verifyTranslationsAccuracy();
});

When("the user tests responsiveness in different languages", () => {
 HelpCenterPage.testResponsiveness();
});

Then("the Help Center is responsive in all languages", () => {
 HelpCenterPage.verifyResponsiveness();
});

When("the user checks content synchronization across languages", () => {
 HelpCenterPage.checkContentSynchronization();
});

Then("the content is synchronized and consistent across languages", () => {
 HelpCenterPage.verifyContentSynchronization();
});

When("the user selects an unsupported language", () => {
 HelpCenterPage.selectUnsupportedLanguage();
});

Then("the system displays an error message for unsupported language", () => {
 HelpCenterPage.verifyUnsupportedLanguageError();
});

When("the user's session expires", () => {
 HelpCenterPage.sessionExpires();
});

Then("the system prompts the user to re-login and select language again", () => {
 HelpCenterPage.verifySessionExpiryHandling();
});