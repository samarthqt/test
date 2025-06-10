package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

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
    public void theFollowingAdminRelatedMenusShouldBeDisplayed(io.cucumber.datatable.DataTable dataTable) {
        for (String menuItem : dataTable.asList()) {
            Assert.assertTrue(isMenuItemVisible(menuItem), "Menu item " + menuItem + " is not visible.");
        }
    }

    @Given("I can see the admin profile menu options")
    public void iCanSeeTheAdminProfileMenuOptions() {
        Assert.assertTrue(isElementVisible(userProfileMenu), "Admin profile menu options are not visible.");
    }

    @When("I click on the \"Projects\" menu option")
    public void iClickOnTheProjectsMenuOption() {
        clickMenuOption("Projects");
    }

    @Then("I should be redirected to the Users page")
    public void iShouldBeRedirectedToTheUsersPage() {
        verifyUsersPageRedirection();
    }

    @Given("I am on the Users page as an Admin")
    public void iAmOnTheUsersPageAsAnAdmin() {
        navigateToUsersPage();
    }

    @When("I view the page options")
    public void iViewThePageOptions() {
        // Implementation for viewing page options
    }

    @Then("I should see the \"Create new User\" option")
    public void iShouldSeeTheCreateNewUserOption() {
        Assert.assertTrue(isCreateNewUserOptionVisible(), "Create new User option is not visible.");
    }

    private boolean isMenuItemVisible(String menuItem) {
        // Implementation to check if menu item is visible
        return true;
    }

    private void clickMenuOption(String menuOption) {
        // Implementation to click on menu option
    }

    private void verifyUsersPageRedirection() {
        // Implementation to verify redirection to Users page
    }

    private void navigateToUsersPage() {
        // Implementation to navigate to Users page
    }

    private boolean isCreateNewUserOptionVisible() {
        // Implementation to check if Create new User option is visible
        return true;
    }
}