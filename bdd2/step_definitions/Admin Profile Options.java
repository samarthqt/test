package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.*;

public class AdminProfileSteps extends AdminProfilePage {

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @When("I navigate to the user profile")
    public void iNavigateToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("I should see the following admin related menus displayed:")
    public void iShouldSeeTheFollowingAdminRelatedMenusDisplayed(List<String> menuItems) {
        verifyAdminMenusDisplayed(menuItems);
    }

    @When("I navigate to the home page")
    public void iNavigateToTheHomePage() {
        navigateToHomePage();
    }

    @Then("I should see all the listed menu items displayed for an Admin profile")
    public void iShouldSeeAllTheListedMenuItemsDisplayedForAnAdminProfile() {
        verifyAllAdminMenusDisplayed();
    }
}