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

    @When("I click on the projects menu option")
    public void iClickOnTheProjectsMenuOption() {
        clickProjectsMenu();
    }

    @Then("I should be redirected to the projects page")
    public void iShouldBeRedirectedToTheProjectsPage() {
        verifyProjectsPageRedirection();
    }

    @Then("I should see the \"create new project\" option on the projects page")
    public void iShouldSeeTheCreateNewProjectOptionOnTheProjectsPage() {
        verifyCreateNewProjectOption();
    }
}