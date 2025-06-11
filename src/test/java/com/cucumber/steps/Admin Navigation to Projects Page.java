package com.cucumber.steps;

import com.pageobjects.AdminPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminNavigationSteps extends AdminPage {

    @Given("the admin user is logged in successfully")
    public void theAdminUserIsLoggedInSuccessfully() {
        verifyAdminLoggedIn();
    }

    @When("the admin user navigates to the user profile section")
    public void theAdminUserNavigatesToTheUserProfileSection() {
        navigateToUserProfileSection();
    }

    @Then("the admin profile menu options are visible")
    public void theAdminProfileMenuOptionsAreVisible() {
        verifyProfileMenuOptionsVisible();
    }

    @When("the admin user clicks on the 'Projects' menu option")
    public void theAdminUserClicksOnTheProjectsMenuOption() {
        clickProjectsMenuOption();
    }

    @Then("the user is redirected to the 'projects' page")
    public void theUserIsRedirectedToTheProjectsPage() {
        verifyRedirectionToProjectsPage();
    }

    @Then("the 'create new project' option is visible on the 'projects' page")
    public void theCreateNewProjectOptionIsVisibleOnTheProjectsPage() {
        verifyCreateNewProjectOptionVisible();
    }
}