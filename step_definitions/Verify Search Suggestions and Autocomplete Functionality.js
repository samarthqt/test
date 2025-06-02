import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HomePage from "../pages/homePage";

Given("the user is logged into the application", () => {
  // Implement login functionality here
});

When("the user navigates to the homepage of the application", () => {
  HomePage.visit();
});

Then("the homepage is displayed with a visible search bar", () => {
  HomePage.verifySearchBarVisible();
});

Given("the user is on the homepage", () => {
  HomePage.visit();
});

When("the user clicks on the search bar", () => {
  HomePage.clickSearchBar();
});

When("the user types {string} into the search bar", (keyword) => {
  HomePage.typeInSearchBar(keyword);
});

Then("search suggestions related to {string} are displayed below the search bar", (keyword) => {
  HomePage.verifySearchSuggestions(keyword);
});

Given("search suggestions for {string} are displayed", (keyword) => {
  HomePage.verifySearchSuggestions(keyword);
});

When("the user selects one of the autocomplete suggestions", () => {
  HomePage.selectAutocompleteSuggestion();
});

Then("the selected suggestion is populated in the search bar", () => {
  HomePage.verifySuggestionPopulated();
});

Then("search results are displayed", () => {
  HomePage.verifySearchResults();
});

Then("suggestions are relevant and match the initial input", () => {
  HomePage.verifySuggestionsRelevance();
});

Then("autocomplete suggestions appear swiftly without delay", () => {
  HomePage.verifyPerformance();
});

Then("suggestions appear even with partial input", () => {
  HomePage.verifyPartialKeywordSuggestions();
});

Then("suggestions dynamically update and refine as more characters are input", () => {
  HomePage.verifyDynamicUpdateOfSuggestions();
});

Then("the selected suggestion populates the search bar", () => {
  HomePage.verifySuggestionPopulated();
});

Then("it leads to correct search results", () => {
  HomePage.verifyCorrectSearchResults();
});

Then("suggestions display correctly across mobile, tablet, and desktop", () => {
  HomePage.verifySuggestionsOnDifferentDevices();
});

Then("autocomplete handles special characters correctly and provides suggestions", () => {
  HomePage.verifySpecialCharacterHandling();
});

Then("autocomplete does not suggest irrelevant or unrelated items", () => {
  HomePage.verifyRelevanceOfSuggestions();
});

Then("autocomplete function operates within user privacy settings", () => {
  HomePage.verifyPrivacySettings();
});