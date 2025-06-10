package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminProjectsPageSteps extends AdminProfilePage {

    @Given("the admin user is logged in successfully")
    public void theAdminUserIsLoggedInSuccessfully() {
        verifyAdminLogin();
    }

    @Given("the admin profile menu options are visible")
    public void theAdminProfileMenuOptionsAreVisible() {
        verifyUserProfileSectionDisplayed();
    }

    @When("the admin user clicks on the 'Projects' menu option")
    public void theAdminUserClicksOnTheProjectsMenuOption() {
        verifyMenuItemDisplayed("Projects");
        navigateToProjectsPage();
    }

    @Then("the user is redirected to the Projects page")
    public void theUserIsRedirectedToTheProjectsPage() {
        verifyProjectsPageRedirection();
    }

    @Then("the Projects page is displayed")
    public void theProjectsPageIsDisplayed() {
        verifyProjectsPageDisplayed();
    }

    @Then("the 'Create New Project' option is available on the Projects page")
    public void theCreateNewProjectOptionIsAvailableOnTheProjectsPage() {
        verifyCreateNewProjectOptionAvailable();
    }
}