package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductCatalogPage;

public class ProductCatalogSteps extends ProductCatalogPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the retail application")
    public void theUserIsLoggedIntoTheRetailApplication() {
        loginToApplication();
    }

    @When("the user navigates to the product catalog section")
    public void theUserNavigatesToTheProductCatalogSection() {
        navigateToProductCatalog();
    }

    @When("the user locates the filter option for product categories")
    public void theUserLocatesTheFilterOptionForProductCategories() {
        locateCategoryFilter();
    }

    @When("the user selects an invalid category to filter products")
    public void theUserSelectsAnInvalidCategoryToFilterProducts() {
        selectInvalidCategory();
    }

    @Then("the system displays an error message indicating the category is invalid")
    public void theSystemDisplaysAnErrorMessageIndicatingTheCategoryIsInvalid() {
        verifyInvalidCategoryErrorMessage();
    }

    @Then("UI elements remain intact after the filter attempt")
    public void uiElementsRemainIntactAfterTheFilterAttempt() {
        verifyUIElementsIntact();
    }

    @When("the user attempts filtering products with an empty category")
    public void theUserAttemptsFilteringProductsWithAnEmptyCategory() {
        filterWithEmptyCategory();
    }

    @Then("the system handles the empty category gracefully and displays an appropriate message")
    public void theSystemHandlesTheEmptyCategoryGracefullyAndDisplaysAnAppropriateMessage() {
        verifyEmptyCategoryMessage();
    }

    @When("the user filters products using special characters in the category")
    public void theUserFiltersProductsUsingSpecialCharactersInTheCategory() {
        filterWithSpecialCharacters();
    }

    @Then("the system handles special characters gracefully and displays an appropriate message")
    public void theSystemHandlesSpecialCharactersGracefullyAndDisplaysAnAppropriateMessage() {
        verifySpecialCharactersMessage();
    }

    @When("the user performs rapid successive filter attempts")
    public void theUserPerformsRapidSuccessiveFilterAttempts() {
        performRapidFilterAttempts();
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
        verifyLogoutSuccess();
    }

    @When("the user performs a filter operation")
    public void theUserPerformsAFilterOperation() {
        performFilterOperation();
    }

    @Then("the filter functionality works consistently across different user accounts")
    public void theFilterFunctionalityWorksConsistentlyAcrossDifferentUserAccounts() {
        verifyFilterConsistencyAcrossAccounts();
    }

    @Then("the filter works consistently on all supported browsers")
    public void theFilterWorksConsistentlyOnAllSupportedBrowsers() {
        verifyFilterConsistencyAcrossBrowsers();
    }

    @Then("the filter operations can be performed on mobile devices without any issues")
    public void theFilterOperationsCanBePerformedOnMobileDevicesWithoutAnyIssues() {
        verifyFilterOnMobileDevices();
    }

    @When("the user attempts to filter with an invalid data format")
    public void theUserAttemptsToFilterWithAnInvalidDataFormat() {
        filterWithInvalidDataFormat();
    }

    @Then("the system handles invalid data gracefully and displays an error message")
    public void theSystemHandlesInvalidDataGracefullyAndDisplaysAnErrorMessage() {
        verifyInvalidDataFormatMessage();
    }

    @Then("the system logs do not show any critical errors related to filter operations")
    public void theSystemLogsDoNotShowAnyCriticalErrorsRelatedToFilterOperations() {
        verifySystemLogsForErrors();
    }
}