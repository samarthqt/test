package com.cucumber.steps;

import com.page_objects.ProjectsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectsPageSteps extends ProjectsPage {

    @Given("the Admin user logs into the COCO application with username {string} and password {string}")
    public void theAdminUserLogsIntoTheCOCOApplication(String username, String password) {
        launchApplication();
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the Admin user is logged in successfully")
    public void theAdminUserIsLoggedInSuccessfully() {
        verifySuccessfulLogin();
    }

    @Then("the Admin profile menu options are visible")
    public void theAdminProfileMenuOptionsAreVisible() {
        verifyProfileMenuOptionsVisible();
    }

    @When("the Admin user clicks on the 'Projects' menu option")
    public void theAdminUserClicksOnTheProjectsMenuOption() {
        clickProjectsMenuOption();
    }

    @Then("the user is redirected to the Projects page")
    public void theUserIsRedirectedToTheProjectsPage() {
        verifyProjectsPageRedirection();
    }

    @Then("the 'Create New Project' option is displayed on the Projects page")
    public void theCreateNewProjectOptionIsDisplayedOnTheProjectsPage() {
        verifyCreateNewProjectOptionDisplayed();
    }
}