package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SearchPage;

public class SearchSteps extends SearchPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the retail application")
    public void theUserIsLoggedIntoTheRetailApplication() {
        loginToApplication();
    }

    @When("the user navigates to the search bar in the product catalog section")
    public void theUserNavigatesToTheSearchBarInTheProductCatalogSection() {
        navigateToSearchBar();
    }

    @When("enters a search query that has no matching products")
    public void entersASearchQueryThatHasNoMatchingProducts() {
        enterSearchQuery("noMatchQuery");
    }

    @Then("the system displays a message indicating no products were found matching the search criteria")
    public void theSystemDisplaysAMessageIndicatingNoProductsWereFoundMatchingTheSearchCriteria() {
        verifyNoProductsFoundMessage();
    }

    @Then("UI elements remain intact after search")
    public void uiElementsRemainIntactAfterSearch() {
        verifyUIElementsIntact();
    }

    @Then("alternative suggestions are provided if applicable")
    public void alternativeSuggestionsAreProvidedIfApplicable() {
        verifyAlternativeSuggestions();
    }

    @When("enters a search query with special characters")
    public void entersASearchQueryWithSpecialCharacters() {
        enterSearchQuery("special@#%!");
    }

    @Then("the system handles special characters gracefully and displays an appropriate message")
    public void theSystemHandlesSpecialCharactersGracefullyAndDisplaysAnAppropriateMessage() {
        verifySpecialCharactersHandling();
    }

    @When("enters an excessively long search query")
    public void entersAnExcessivelyLongSearchQuery() {
        enterSearchQuery("longQueryExceedingNormalLength");
    }

    @Then("the system processes the query and handles it without errors")
    public void theSystemProcessesTheQueryAndHandlesItWithoutErrors() {
        verifyLongQueryHandling();
    }

    @When("the user performs rapid successive search operations")
    public void theUserPerformsRapidSuccessiveSearchOperations() {
        performRapidSearchOperations();
    }

    @Then("the system maintains performance and responsiveness")
    public void theSystemMaintainsPerformanceAndResponsiveness() {
        verifySystemPerformance();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is successfully logged out and redirected to the login page")
    public void theUserIsSuccessfullyLoggedOutAndRedirectedToTheLoginPage() {
        verifyLogoutRedirection();
    }

    @Given("the user is logged into the retail application using {string}")
    public void theUserIsLoggedIntoTheRetailApplicationUsing(String userAccount) {
        loginWithDifferentUserAccount(userAccount);
    }

    @Then("the search functionality works consistently across different user accounts")
    public void theSearchFunctionalityWorksConsistentlyAcrossDifferentUserAccounts() {
        verifySearchConsistencyAcrossUsers();
    }

    @When("the user navigates to the search bar in the product catalog section using {string}")
    public void theUserNavigatesToTheSearchBarInTheProductCatalogSectionUsing(String browser) {
        navigateToSearchBarOnBrowser(browser);
    }

    @Then("the search works consistently on all supported browsers")
    public void theSearchWorksConsistentlyOnAllSupportedBrowsers() {
        verifySearchConsistencyAcrossBrowsers();
    }

    @When("the user navigates to the search bar in the product catalog section using {string}")
    public void theUserNavigatesToTheSearchBarInTheProductCatalogSectionUsingDevice(String device) {
        navigateToSearchBarOnDevice(device);
    }

    @Then("search operations can be performed on mobile devices without any issues")
    public void searchOperationsCanBePerformedOnMobileDevicesWithoutAnyIssues() {
        verifySearchOnMobileDevices();
    }

    @When("enters a search query with invalid data format")
    public void entersASearchQueryWithInvalidDataFormat() {
        enterSearchQuery("invalidDataFormat");
    }

    @Then("the system handles invalid data gracefully and displays an error message")
    public void theSystemHandlesInvalidDataGracefullyAndDisplaysAnErrorMessage() {
        verifyInvalidDataHandling();
    }

    @When("the user performs a search operation")
    public void theUserPerformsASearchOperation() {
        performSearchOperation();
    }

    @Then("system logs do not show any critical errors related to search operations")
    public void systemLogsDoNotShowAnyCriticalErrorsRelatedToSearchOperations() {
        verifySystemLogsForErrors();
    }
}