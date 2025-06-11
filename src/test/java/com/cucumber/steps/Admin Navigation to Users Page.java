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

    @When("the admin user navigates to the Admin profile menu")
    public void theAdminUserNavigatesToTheAdminProfileMenu() {
        navigateToUserProfileSection();
    }

    @Then("the Admin profile menu options are visible")
    public void theAdminProfileMenuOptionsAreVisible() {
        verifyProfileMenuOptionsVisible();
    }

    @When("the admin user clicks on the 'Users' menu option")
    public void theAdminUserClicksOnTheUsersMenuOption() {
        clickProjectsMenuOption();
    }

    @Then("the user is redirected to the 'Users' page")
    public void theUserIsRedirectedToTheUsersPage() {
        verifyRedirectionToProjectsPage();
    }

    @Then("the 'Create new User' option is visible on the 'Users' page")
    public void theCreateNewUserOptionIsVisibleOnTheUsersPage() {
        verifyCreateNewProjectOptionVisible();
    }
}