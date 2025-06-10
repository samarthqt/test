package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.AdminProfilePage;
import java.util.*;

public class UserProfileSteps extends AdminProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into COCO")
    public void theUserIsLoggedIntoCOCO() {
        loginAsAdmin();
    }

    @When("the user navigates to the user profile")
    public void theUserNavigatesToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("the following admin related menus should be displayed:")
    public void theFollowingAdminRelatedMenusShouldBeDisplayed(List<String> menuItems) {
        verifyAdminMenusDisplayed(menuItems);
    }

    @When("the user navigates to the home page")
    public void theUserNavigatesToTheHomePage() {
        navigateToHomePage();
    }

    @Then("the following menu items should be displayed:")
    public void theFollowingMenuItemsShouldBeDisplayed(List<String> menuItems) {
        verifyAdminMenusDisplayed(menuItems);
    }

    private void navigateToHomePage() {
        // Logic to navigate to the home page
    }
}