package com.cucumber.steps;

import com.page_objects.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersPageNavigationSteps extends UsersPage {

    @Given("the Admin user logs in to the COCO application")
    public void theAdminUserLogsInToTheCOCOApplication() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the Admin user enters username {string} and password {string}")
    public void theAdminUserEntersUsernameAndPassword(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the Admin user is logged in successfully")
    public void theAdminUserIsLoggedInSuccessfully() {
        verifyLoginSuccess();
    }

    @Then("the Admin profile menu options are visible")
    public void theAdminProfileMenuOptionsAreVisible() {
        verifyProfileMenuOptionsVisible();
    }

    @When("the Admin user clicks on the 'Users' menu option")
    public void theAdminUserClicksOnTheUsersMenuOption() {
        clickUsersMenuOption();
    }

    @Then("the user is redirected to the Users page")
    public void theUserIsRedirectedToTheUsersPage() {
        verifyUsersPageRedirection();
    }

    @Then("the 'Create New User' option is displayed on the Users page")
    public void theCreateNewUserOptionIsDisplayedOnTheUsersPage() {
        verifyCreateNewUserOptionDisplayed();
    }
}