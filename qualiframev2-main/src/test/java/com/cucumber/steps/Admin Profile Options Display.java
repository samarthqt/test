package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminProfileSteps extends AdminProfilePage {

    @Given("the admin user is logged in successfully")
    public void theAdminUserIsLoggedInSuccessfully() {
        verifyAdminLogin();
    }

    @When("the user navigates to the user profile section")
    public void theUserNavigatesToTheUserProfileSection() {
        navigateToUserProfile();
    }

    @Then("the user profile section is displayed")
    public void theUserProfileSectionIsDisplayed() {
        verifyUserProfileSectionDisplayed();
    }

    @Then("'User name' menu item is displayed")
    public void userNameMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("User name");
    }

    @Then("'Mail ID' menu item is displayed")
    public void mailIDMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Mail ID");
    }

    @Then("'Home' menu item is displayed")
    public void homeMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Home");
    }

    @Then("'Projects' menu item is displayed")
    public void projectsMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Projects");
    }

    @Then("'Users' menu item is displayed")
    public void usersMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Users");
    }

    @Then("'Dashboards' menu item is displayed")
    public void dashboardsMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Dashboards");
    }

    @Then("'Prompts' menu item is displayed")
    public void promptsMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Prompts");
    }

    @Then("'Version' menu item is displayed")
    public void versionMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Version");
    }

    @Then("'Logout' menu item is displayed")
    public void logoutMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Logout");
    }
}