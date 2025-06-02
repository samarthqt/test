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

    @When("the user navigates to the homepage")
    public void theUserNavigatesToTheHomepage() {
        navigateToHomePage();
    }

    @When("the user enters {string} in the search bar and presses enter")
    public void theUserEntersInTheSearchBarAndPressesEnter(String keyword) {
        enterSearchKeyword(keyword);
        pressEnterInSearchBar();
    }

    @Then("the system displays an error message indicating {string}")
    public void theSystemDisplaysAnErrorMessageIndicating(String errorMessage) {
        verifyErrorMessage(errorMessage);
    }

    @Given("the user has entered an invalid keyword")
    public void theUserHasEnteredAnInvalidKeyword() {
        enterInvalidKeyword();
    }

    @Then("no products are displayed; only error message is shown")
    public void noProductsAreDisplayedOnlyErrorMessageIsShown() {
        verifyNoProductsDisplayed();
    }

    @Then("the search bar remains operational and can accept new input")
    public void theSearchBarRemainsOperationalAndCanAcceptNewInput() {
        verifySearchBarOperational();
    }

    @Then("the system does not execute any unintended SQL commands")
    public void theSystemDoesNotExecuteAnyUnintendedSQLCommands() {
        verifyNoSQLExecution();
    }

    @Then("error messages provide clear guidance on correcting the input")
    public void errorMessagesProvideClearGuidanceOnCorrectingTheInput() {
        verifyErrorMessageGuidance();
    }

    @Then("other functionalities remain unaffected and operational")
    public void otherFunctionalitiesRemainUnaffectedAndOperational() {
        verifyOtherFunctionalitiesUnaffected();
    }

    @Then("invalid search attempts are logged for auditing purposes")
    public void invalidSearchAttemptsAreLoggedForAuditingPurposes() {
        verifySearchAttemptsLogged();
    }

    @Then("the system suggests alternative keywords or categories")
    public void theSystemSuggestsAlternativeKeywordsOrCategories() {
        verifyKeywordSuggestions();
    }

    @When("the user enters a valid keyword")
    public void theUserEntersAValidKeyword() {
        enterValidKeyword();
    }

    @Then("the user can perform a successful search")
    public void theUserCanPerformASuccessfulSearch() {
        verifySuccessfulSearch();
    }

    @Then("the user account remains unlocked and accessible")
    public void theUserAccountRemainsUnlockedAndAccessible() {
        verifyAccountUnlocked();
    }
}