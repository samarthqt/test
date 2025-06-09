package com.cucumber.steps;

import com.pageobjects.ProjectOptionsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectOptionsSteps extends ProjectOptionsPage {

    @Given("the user is logged into COCO")
    public void theUserIsLoggedIntoCOCO() {
        loginToCOCO();
    }

    @When("the user navigates to the home screen")
    public void theUserNavigatesToTheHomeScreen() {
        navigateToHomeScreen();
    }

    @Then("the home screen is displayed with various options")
    public void theHomeScreenIsDisplayedWithVariousOptions() {
        verifyHomeScreenOptions();
    }

    @Then("the user has at least one project assigned")
    public void theUserHasAtLeastOneProjectAssigned() {
        verifyProjectAssignment();
    }

    @When("the user locates the 'projects' dropdown on the home screen")
    public void theUserLocatesTheProjectsDropdownOnTheHomeScreen() {
        locateProjectsDropdown();
    }

    @Then("the projects dropdown is visible")
    public void theProjectsDropdownIsVisible() {
        verifyProjectsDropdownVisibility();
    }

    @When("the user clicks on the 'projects' dropdown")
    public void theUserClicksOnTheProjectsDropdown() {
        clickProjectsDropdown();
    }

    @Then("the dropdown expands displaying the list of projects assigned to the user")
    public void theDropdownExpandsDisplayingTheListOfProjectsAssignedToTheUser() {
        verifyDropdownExpansion();
    }

    @When("the user selects 'Project Alpha' from the dropdown")
    public void theUserSelectsProjectAlphaFromTheDropdown() {
        selectProjectAlpha();
    }

    @Then("the user is navigated to the project details page for 'Project Alpha'")
    public void theUserIsNavigatedToTheProjectDetailsPageForProjectAlpha() {
        verifyProjectAlphaNavigation();
    }

    @When("the user locates the requirements tile on the project details page")
    public void theUserLocatesTheRequirementsTileOnTheProjectDetailsPage() {
        locateRequirementsTile();
    }

    @Then("the requirements tile is visible")
    public void theRequirementsTileIsVisible() {
        verifyRequirementsTileVisibility();
    }

    @When("the user clicks on the requirements tile")
    public void theUserClicksOnTheRequirementsTile() {
        clickRequirementsTile();
    }

    @Then("options 'Generate', 'Validate', and 'Fix' are displayed")
    public void optionsGenerateValidateAndFixAreDisplayed() {
        verifyOptionsDisplayed();
    }

    @Then("each option is clearly labeled")
    public void eachOptionIsClearlyLabeled() {
        verifyOptionLabels();
    }

    @When("the user selects the 'Generate' option")
    public void theUserSelectsTheGenerateOption() {
        selectGenerateOption();
    }

    @Then("the 'Generate' functionality is triggered successfully")
    public void theGenerateFunctionalityIsTriggeredSuccessfully() {
        verifyGenerateFunctionality();
    }

    @When("the user returns to the requirements tile")
    public void theUserReturnsToTheRequirementsTile() {
        returnToRequirementsTile();
    }

    @Then("the requirements tile is displayed again with options")
    public void theRequirementsTileIsDisplayedAgainWithOptions() {
        verifyRequirementsTileWithOptions();
    }

    @When("the user selects the 'Validate' option")
    public void theUserSelectsTheValidateOption() {
        selectValidateOption();
    }

    @Then("the 'Validate' functionality is triggered successfully")
    public void theValidateFunctionalityIsTriggeredSuccessfully() {
        verifyValidateFunctionality();
    }

    @When("the user returns to the requirements tile")
    public void theUserReturnsToTheRequirementsTileAgain() {
        returnToRequirementsTile();
    }

    @Then("the requirements tile is displayed again with options")
    public void theRequirementsTileIsDisplayedAgainWithOptionsAgain() {
        verifyRequirementsTileWithOptions();
    }

    @When("the user selects the 'Fix' option")
    public void theUserSelectsTheFixOption() {
        selectFixOption();
    }

    @Then("the 'Fix' functionality is triggered successfully")
    public void theFixFunctionalityIsTriggeredSuccessfully() {
        verifyFixFunctionality();
    }

    @Then("no errors occur during the selection of any option")
    public void noErrorsOccurDuringTheSelectionOfAnyOption() {
        verifyNoErrors();
    }

    @When("the user logs out of the COCO application")
    public void theUserLogsOutOfTheCOCOApplication() {
        logoutFromCOCO();
    }

    @Then("the user is logged out successfully and redirected to the login page")
    public void theUserIsLoggedOutSuccessfullyAndRedirectedToTheLoginPage() {
        verifyLogoutSuccess();
    }
}