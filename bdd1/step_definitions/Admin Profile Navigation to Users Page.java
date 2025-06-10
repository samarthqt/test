package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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

    @Then("the following admin related menus should be displayed:")
    public void theFollowingAdminRelatedMenusShouldBeDisplayed(List<String> menuItems) {
        for (String menuItem : menuItems) {
            Assert.assertTrue(isMenuItemVisible(menuItem), "Menu item " + menuItem + " is not visible.");
        }
    }

    @When("I click on the \"Users\" menu option")
    public void iClickOnTheUsersMenuOption() {
        clickUsersMenuOption();
    }

    @Then("I should be redirected to the Users page")
    public void iShouldBeRedirectedToTheUsersPage() {
        verifyPageRedirection("expectedUsersPageURL");
    }

    @Then("I should see the option to \"create new User\" on the Users page")
    public void iShouldSeeTheOptionToCreateNewUserOnTheUsersPage() {
        Assert.assertTrue(isCreateNewUserOptionVisible(), "Create new User option is not visible.");
    }

    private boolean isMenuItemVisible(String menuItem) {
        // Implement logic to verify if the menu item is visible
        return true;
    }

    private void clickUsersMenuOption() {
        // Implement logic to click on the Users menu option
    }

    private boolean isCreateNewUserOptionVisible() {
        // Implement logic to verify if the Create new User option is visible
        return true;
    }
}