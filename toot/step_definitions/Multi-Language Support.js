import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LanguagePage from "../pages/languagePage";

Given("the user is on the homepage", () => {
 LanguagePage.visitHomepage();
});

When("the user selects {string} from the language dropdown", (language) => {
 LanguagePage.selectLanguage(language);
});

Then("the site should display content in {string}", (language) => {
 LanguagePage.verifyLanguageContent(language);
});

Then("the site should display content in English by default", () => {
 LanguagePage.verifyDefaultLanguage();
});

Given("the user selects Spanish from the language dropdown", () => {
 LanguagePage.selectLanguage("Spanish");
});

And("the user navigates to another page", () => {
 LanguagePage.navigateToAnotherPage();
});

Then("the site should continue to display content in Spanish", () => {
 LanguagePage.verifyLanguageContent("Spanish");
});

Given("the user selects French from the language dropdown", () => {
 LanguagePage.selectLanguage("French");
});

When("the user navigates to the Contact Us page", () => {
 LanguagePage.navigateToContactUsPage();
});

Then("the Contact Us page should display content in French", () => {
 LanguagePage.verifyContactUsPageLanguage("French");
});

Then("the language dropdown should be visible", () => {
 LanguagePage.verifyLanguageDropdownVisible();
});

Given("the user selects German from the language dropdown", () => {
 LanguagePage.selectLanguage("German");
});

When("the user refreshes the page", () => {
 cy.reload();
});

Then("the site should continue to display content in German", () => {
 LanguagePage.verifyLanguageContent("German");
});