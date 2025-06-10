package com.cucumber.steps;

import com.pageobjects.ProjectsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectsNavigationSteps extends ProjectsPage {

    @Given("I am logged into CoCO as an Admin user")
    public void iAmLoggedIntoCoCOAsAnAdminUser() {
        loginAsAdmin();
    }

    @Then("I should see the Admin profile menu options")
    public void iShouldSeeTheAdminProfileMenuOptions() {
        verifyAdminProfileMenuOptions();
    }

    @When("I click on the projects menu option")
    public void iClickOnTheProjectsMenuOption() {
        clickProjectsMenuOption();
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