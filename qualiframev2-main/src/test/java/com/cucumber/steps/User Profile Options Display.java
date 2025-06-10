package com.cucumber.steps;

import com.pageobjects.UserProfilePage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfileSteps extends UserProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        // Assume login is handled in a previous step
    }

    @When("the user navigates to the user profile section")
    public void theUserNavigatesToTheUserProfileSection() {
        navigateToUserProfile();
    }

    @Then("the user profile section is displayed")
    public void theUserProfileSectionIsDisplayed() {
        verifyUserProfileSectionDisplayed();
    }

    @Then("the 'User name' menu item is displayed")
    public void theUserNameMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("User name");
    }

    @Then("the 'Mail ID' menu item is displayed")
    public void theMailIDMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Mail ID");
    }

    @Then("the 'Home' menu item is displayed")
    public void theHomeMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Home");
    }

    @Then("the 'Dashboards' menu item is displayed")
    public void theDashboardsMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Dashboards");
    }

    @Then("the 'Version' menu item is displayed")
    public void theVersionMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Version");
    }

    @Then("the 'Logout' menu item is displayed")
    public void theLogoutMenuItemIsDisplayed() {
        verifyMenuItemDisplayed("Logout");
    }
}