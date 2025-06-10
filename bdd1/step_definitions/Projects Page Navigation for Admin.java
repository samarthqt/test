package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import com.pageobjects.ProjectsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectsPageSteps extends AdminProfilePage {

    private ProjectsPage projectsPage = new ProjectsPage();

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @Given("I can view Admin profile menu options")
    public void iCanViewAdminProfileMenuOptions() {
        navigateToUserProfile();
    }

    @When("I click on the projects menu option")
    public void iClickOnTheProjectsMenuOption() {
        projectsPage.clickProjectsMenuOption();
    }

    @Then("I should be redirected to the projects page")
    public void iShouldBeRedirectedToTheProjectsPage() {
        projectsPage.verifyProjectsPageRedirection();
    }

    @Then("I should see the \"create new project\" option on the projects page")
    public void iShouldSeeTheCreateNewProjectOptionOnTheProjectsPage() {
        projectsPage.verifyCreateNewProjectOptionVisible();
    }
}