package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import com.pageobjects.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersPageSteps extends AdminProfilePage {

    private UsersPage usersPage = new UsersPage();

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @Given("I can view the admin profile menu options")
    public void iCanViewTheAdminProfileMenuOptions() {
        navigateToUserProfile();
    }

    @When("I click on the Users menu option")
    public void iClickOnTheUsersMenuOption() {
        usersPage.clickUsersMenuOption();
    }

    @Then("I should be redirected to the Users page")
    public void iShouldBeRedirectedToTheUsersPage() {
        usersPage.verifyUsersPageRedirection();
    }

    @Then("I should see the \"create new User\" option on the Users page")
    public void iShouldSeeTheCreateNewUserOptionOnTheUsersPage() {
        usersPage.verifyCreateNewUserOptionVisible();
    }
}