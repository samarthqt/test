package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminUserNavigationSteps extends AdminProfilePage {

    @Given("the admin user is logged in successfully")
    public void theAdminUserIsLoggedInSuccessfully() {
        verifyAdminLogin();
    }

    @When("the user navigates to the user profile section")
    public void theUserNavigatesToTheUserProfileSection() {
        navigateToUserProfile();
    }

    @Then("the admin profile menu options are displayed")
    public void theAdminProfileMenuOptionsAreDisplayed() {
        verifyUserProfileSectionDisplayed();
    }

    @When("the admin clicks on the 'Projects' menu option")
    public void theAdminClicksOnTheProjectsMenuOption() {
        navigateToProjectsPage();
    }

    @Then("the admin user is redirected to the Users page")
    public void theAdminUserIsRedirectedToTheUsersPage() {
        verifyProjectsPageRedirection();
    }

    @Then("the Users page is displayed")
    public void theUsersPageIsDisplayed() {
        verifyProjectsPageDisplayed();
    }

    @Then("the 'Create new User' option is available on the Users page")
    public void theCreateNewUserOptionIsAvailableOnTheUsersPage() {
        verifyCreateNewProjectOptionAvailable();
    }
}