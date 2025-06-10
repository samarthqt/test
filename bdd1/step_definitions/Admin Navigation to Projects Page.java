package com.cucumber.steps;

import com.pageobjects.AdminPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminNavigationSteps extends AdminPage {

    @Given("I am on the CoCO login page")
    public void iAmOnTheCoCOLoginPage() {
        launchLoginPage();
    }

    @When("I enter valid Admin credentials")
    public void iEnterValidAdminCredentials() {
        enterAdminCredentials();
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

    @When("I navigate to the profile menu")
    public void iNavigateToTheProfileMenu() {
        navigateToProfileMenu();
    }

    @Then("I should see the Admin profile menu options")
    public void iShouldSeeTheAdminProfileMenuOptions() {
        verifyAdminProfileMenuOptions();
    }

    @Given("I can see the Admin profile menu options")
    public void iCanSeeTheAdminProfileMenuOptions() {
        verifyAdminProfileMenuOptions();
    }

    @When("I click on the \"Projects\" menu option")
    public void iClickOnTheProjectsMenuOption() {
        clickProjectsMenuOption();
    }

    @Then("I should be redirected to the Projects page")
    public void iShouldBeRedirectedToTheProjectsPage() {
        verifyProjectsPageRedirection();
    }

    @Given("I am on the Projects page")
    public void iAmOnTheProjectsPage() {
        verifyProjectsPage();
    }

    @When("I look at the available options")
    public void iLookAtTheAvailableOptions() {
        viewAvailableOptions();
    }

    @Then("I should see the \"create new project\" option")
    public void iShouldSeeTheCreateNewProjectOption() {
        verifyCreateNewProjectOption();
    }
}