package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.*;

public class UserProfileMenuSteps extends AdminProfilePage {

    @Given("the user is logged into COCO")
    public void theUserIsLoggedIntoCOCO() {
        loginAsAdmin();
    }

    @When("the user navigates to the user profile")
    public void theUserNavigatesToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("the following admin-related menus should be displayed:")
    public void theFollowingAdminRelatedMenusShouldBeDisplayed(List<String> expectedMenus) {
        verifyAdminMenusDisplayed(expectedMenus);
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        navigateToHomePage();
    }

    @When("the user views the menu items")
    public void theUserViewsTheMenuItems() {
        viewMenuItems();
    }

    @Then("the following menu items should be displayed:")
    public void theFollowingMenuItemsShouldBeDisplayed(List<String> expectedMenus) {
        verifyMenuItemsDisplayed(expectedMenus);
    }

    private void navigateToHomePage() {
        // Implement navigation logic to home page
    }

    private void viewMenuItems() {
        // Implement logic to view menu items
    }

    private void verifyMenuItemsDisplayed(List<String> expectedMenus) {
        // Implement verification logic for menu items
    }
}