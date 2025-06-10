package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.AdminProfilePage;
import java.util.*;

public class UserProfileSteps extends AdminProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged into COCO")
    public void iAmLoggedIntoCOCO() {
        loginAsAdmin();
    }

    @When("I navigate to the user profile")
    public void iNavigateToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("the following menu items should be displayed:")
    public void theFollowingMenuItemsShouldBeDisplayed(List<String> menuItems) {
        verifyAdminMenusDisplayed(menuItems);
    }
}