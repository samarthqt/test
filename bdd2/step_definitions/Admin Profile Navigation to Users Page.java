package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.AdminProfilePage;

public class AdminProfileSteps extends AdminProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @When("I click on the Projects menu option")
    public void iClickOnTheProjectsMenuOption() {
        clickProjectsMenu();
    }

    @Then("I should be redirected to the Users page")
    public void iShouldBeRedirectedToTheUsersPage() {
        verifyProjectsPageRedirection();
    }

    @Given("I am on the Users page as an Admin")
    public void iAmOnTheUsersPageAsAnAdmin() {
        navigateToUserProfile();
    }

    @Then("I should see the \"Create new User\" option displayed")
    public void iShouldSeeTheCreateNewUserOptionDisplayed() {
        verifyCreateNewProjectOption();
    }
}