package com.cucumber.steps;

import com.pageobjects.ProjectPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectSteps extends ProjectPage {

    @Given("the user has an active account and knows the login credentials")
    public void theUserHasAnActiveAccountAndKnowsTheLoginCredentials() {
        // Assume user credentials are known
    }

    @When("the user opens the COCO application login page")
    public void theUserOpensTheCOCOApplicationLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the login page should display fields for username and password")
    public void theLoginPageShouldDisplayFieldsForUsernameAndPassword() {
        verifyLoginPageFields();
    }

    @When("the user enters the username {string} in the username field")
    public void theUserEntersTheUsernameInTheUsernameField(String username) {
        enterUserName(username);
    }

    @Then("the username should be entered successfully")
    public void theUsernameShouldBeEnteredSuccessfully() {
        verifyUserNameEntered();
    }

    @When("the user enters the password {string} in the password field")
    public void theUserEntersThePasswordInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the password should be entered successfully")
    public void thePasswordShouldBeEnteredSuccessfully() {
        verifyPasswordEntered();
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonName) {
        clickLoginButton();
    }

    @Then("the user should be successfully logged into the COCO application")
    public void theUserShouldBeSuccessfullyLoggedIntoTheCOCOApplication() {
        verifySuccessfulLogin();
    }

    @When("the user navigates to the home screen")
    public void theUserNavigatesToTheHomeScreen() {
        navigateToHomeScreen();
    }

    @Then("the home screen should display various options")
    public void theHomeScreenShouldDisplayVariousOptions() {
        verifyHomeScreenOptions();
    }

    @When("the user locates the {string} dropdown on the home screen")
    public void theUserLocatesTheDropdownOnTheHomeScreen(String dropdownName) {
        locateProjectsDropdown();
    }

    @Then("the projects dropdown should be visible on the home screen")
    public void theProjectsDropdownShouldBeVisibleOnTheHomeScreen() {
        verifyProjectsDropdownVisible();
    }

    @When("the user clicks on the {string} dropdown")
    public void theUserClicksOnTheDropdown(String dropdownName) {
        clickProjectsDropdown();
    }

    @Then("the dropdown should expand displaying the list of projects assigned to the user")
    public void theDropdownShouldExpandDisplayingTheListOfProjectsAssignedToTheUser() {
        verifyProjectsListDisplayed();
    }

    @Then("each project name in the dropdown should be clickable")
    public void eachProjectNameInTheDropdownShouldBeClickable() {
        verifyProjectNamesClickable();
    }

    @When("the user clicks on one of the project names")
    public void theUserClicksOnOneOfTheProjectNames() {
        clickOnProjectName();
    }

    @Then("the user should be navigated to the project details page")
    public void theUserShouldBeNavigatedToTheProjectDetailsPage() {
        verifyNavigationToProjectDetailsPage();
    }

    @Then("a loading indicator should be displayed while fetching project data")
    public void aLoadingIndicatorShouldBeDisplayedWhileFetchingProjectData() {
        verifyLoadingIndicatorDisplayed();
    }

    @Then("the project list in the dropdown should be complete without any omission")
    public void theProjectListInTheDropdownShouldBeCompleteWithoutAnyOmission() {
        verifyCompleteProjectList();
    }

    @When("the user logs out of the COCO application")
    public void theUserLogsOutOfTheCOCOApplication() {
        logout();
    }

    @Then("the user should be logged out successfully and redirected to the login page")
    public void theUserShouldBeLoggedOutSuccessfullyAndRedirectedToTheLoginPage() {
        verifyLogoutSuccess();
    }

    @When("the user closes the COCO application")
    public void theUserClosesTheCOCOApplication() {
        closeApplication();
    }

    @Then("the application should close without any issues")
    public void theApplicationShouldCloseWithoutAnyIssues() {
        verifyApplicationClosed();
    }
}