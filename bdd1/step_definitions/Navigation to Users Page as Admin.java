package com.cucumber.steps;

import com.pageobjects.AdminPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps extends AdminPage {

    @Given("the Admin user is on the login page")
    public void theAdminUserIsOnTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the Admin user enters valid credentials")
    public void theAdminUserEntersValidCredentials() {
        String username = testHarness.getData("AdminData", "Username");
        String password = testHarness.getData("AdminData", "Password");
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the Admin user should be logged in successfully")
    public void theAdminUserShouldBeLoggedInSuccessfully() {
        verifyHomePageRedirection(testHarness.getData("AdminData", "ExpectedHomePageURL"));
    }

    @Given("the Admin user is logged into CoCO")
    public void theAdminUserIsLoggedIntoCoCO() {
        verifyHomePageRedirection(testHarness.getData("AdminData", "ExpectedHomePageURL"));
    }

    @When("the Admin user navigates to the profile section")
    public void theAdminUserNavigatesToTheProfileSection() {
        navigateToProfileSection();
    }

    @Then("the Admin user should see the Admin profile menu options")
    public void theAdminUserShouldSeeTheAdminProfileMenuOptions() {
        verifyProfileMenuOptions();
    }

    @Given("the Admin user can see the Admin profile menu options")
    public void theAdminUserCanSeeTheAdminProfileMenuOptions() {
        verifyProfileMenuOptions();
    }

    @When("the Admin user clicks on the projects menu option")
    public void theAdminUserClicksOnTheProjectsMenuOption() {
        clickProjectsMenuOption();
    }

    @Then("the Admin user should be redirected to the Users page")
    public void theAdminUserShouldBeRedirectedToTheUsersPage() {
        verifyUsersPageRedirection(testHarness.getData("AdminData", "ExpectedUsersPageURL"));
    }

    @Given("the Admin user is on the Users page")
    public void theAdminUserIsOnTheUsersPage() {
        verifyUsersPageRedirection(testHarness.getData("AdminData", "ExpectedUsersPageURL"));
    }

    @When("the Users page is loaded")
    public void theUsersPageIsLoaded() {
        verifyUsersPageLoaded();
    }

    @Then("the Admin user should see the \"create new User\" option on the Users page")
    public void theAdminUserShouldSeeTheCreateNewUserOptionOnTheUsersPage() {
        verifyCreateNewUserOption();
    }
}