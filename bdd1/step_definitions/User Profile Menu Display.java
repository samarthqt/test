package com.cucumber.steps;

import com.pageobjects.UserProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfileSteps extends UserProfilePage {

    @Given("I am logged into the COCO application")
    public void iAmLoggedIntoTheCOCOApplication() {
        loginToApplication();
    }

    @When("I navigate to my user profile")
    public void iNavigateToMyUserProfile() {
        navigateToUserProfile();
    }

    @Then("I should see the following admin related menu items:")
    public void iShouldSeeTheFollowingAdminRelatedMenuItems(io.cucumber.datatable.DataTable dataTable) {
        verifyAdminMenuItems(dataTable.asList());
    }

    @Then("all the listed menu items should be displayed prominently on the home page for a user profile")
    public void allTheListedMenuItemsShouldBeDisplayedProminentlyOnTheHomePageForAUserProfile() {
        verifyMenuItemsDisplayedProminently();
    }
}