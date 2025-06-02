import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SearchPage from "../pages/searchPage";

Given("the user is logged into the application", () => {
 cy.login(); // Assuming a custom command for login
});

When("the user navigates to the search bar in the application", () => {
 SearchPage.visit();
});

Then("the search bar is accessible and ready for input", () => {
 SearchPage.getSearchBar().should('be.visible').and('be.enabled');
});

When("the user leaves the search bar empty and initiates the search", () => {
 SearchPage.clickSearchButton();
});

Then("the system does not crash or display any error", () => {
 cy.on('window:alert', (str) => {
 expect(str).to.not.exist;
 });
});

Then("an appropriate message is shown indicating no search term was entered and suggests entering a keyword", () => {
 SearchPage.getNoSearchTermMessage().should('contain', 'Please enter a search term');
});

When("the user initiates an empty search query", () => {
 SearchPage.clickSearchButton();
});

Then("the system performance remains stable and responsive", () => {
 cy.window().should('have.property', 'performance');
});

When("the user initiates an empty search query on different devices and screen sizes", () => {
 SearchPage.clickSearchButton();
 // Assuming different viewport sizes are handled in config or setup
});

Then("the system response is consistent across various devices and screen sizes", () => {
 // Assertions for consistency can be added here
});

Then("no search results are displayed", () => {
 SearchPage.getSearchResults().should('not.exist');
});

Then("the search bar remains focused, ready for input", () => {
 SearchPage.getSearchBar().should('be.focused');
});

When("the user performs multiple empty searches consecutively", () => {
 SearchPage.clickSearchButton();
 SearchPage.clickSearchButton();
});

Then("the system continues to handle multiple empty searches without issue", () => {
 // Assertions for stability
});

Then("empty search queries are logged for future analysis", () => {
 // Assuming we have a method to check logs
 SearchPage.checkLogsForEmptySearch();
});

When("the user initiates an empty search query followed by a valid search", () => {
 SearchPage.clickSearchButton();
 SearchPage.enterSearchTerm('valid term');
 SearchPage.clickSearchButton();
});

Then("the system recovers and performs a valid search without issue", () => {
 SearchPage.getSearchResults().should('exist');
});

When("the user initiates an empty search query with filters applied", () => {
 SearchPage.applyFilters();
 SearchPage.clickSearchButton();
});

Then("an appropriate message is displayed and filters remain unaffected", () => {
 SearchPage.getNoSearchTermMessage().should('contain', 'Please enter a search term');
 SearchPage.checkFiltersUnchanged();
});

Then("other functionalities remain unaffected by the empty search query", () => {
 // Assertions for other functionalities
});

When("the user initiates an empty search query after performing a valid search", () => {
 SearchPage.enterSearchTerm('valid term');
 SearchPage.clickSearchButton();
 SearchPage.clearSearchTerm();
 SearchPage.clickSearchButton();
});

Then("the system handles the transition from valid to empty search smoothly", () => {
 // Assertions for smooth transition
});

When("the user initiates an empty search query in different application modules", () => {
 SearchPage.clickSearchButton();
 // Assuming module navigation is handled
});

Then("the system response is consistent across different modules", () => {
 // Assertions for consistency
});

Then("the user interface provides clear feedback for an empty search query", () => {
 SearchPage.getNoSearchTermMessage().should('contain', 'Please enter a search term');
});