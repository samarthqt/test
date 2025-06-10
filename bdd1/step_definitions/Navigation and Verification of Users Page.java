package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.UsersPage;

public class UsersPageSteps extends UsersPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am on the CoCO login page")
    public void iAmOnTheCoCOLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("I enter valid Admin credentials")
    public void iEnterValidAdminCredentials() {
        String adminUserName = testHarness.getData("LoginData", "AdminUserName");
        String adminPassword = testHarness.getData("LoginData", "AdminPassword");
        enterUserName(adminUserName);
        enterPassword(adminPassword);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        verifySuccessfulLogin();
    }

    @Given("I am logged in as an Admin user")
    public void iAmLoggedInAsAnAdminUser() {
        verifyAdminLogin();
    }

    @When("I navigate to the Admin profile menu")
    public void iNavigateToTheAdminProfileMenu() {
        openAdminProfileMenu();
    }

    @Then("I should see all available menu options")
    public void iShouldSeeAllAvailableMenuOptions() {
        verifyAdminMenuOptions();
    }

    @When("I click on the projects menu option")
    public void iClickOnTheProjectsMenuOption() {
        clickProjectsMenuOption();
    }

    @Then("I should be redirected to the Users page")
    public void iShouldBeRedirectedToTheUsersPage() {
        verifyUsersPageRedirection();
    }

    @Given("I am on the Users page")
    public void iAmOnTheUsersPage() {
        verifyOnUsersPage();
    }

    @Then("I should see the \"create new User\" option available")
    public void iShouldSeeTheCreateNewUserOptionAvailable() {
        verifyCreateNewUserOption();
    }
}