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

    @Given("I can view the Admin profile menu options")
    public void iCanViewTheAdminProfileMenuOptions() {
        navigateToUserProfile();
    }

    @When("I click on the {string} menu option")
    public void iClickOnTheMenuOption(String menuOption) {
        if (menuOption.equals("Projects")) {
            clickElement(By.id("projectsMenu"));
        }
    }

    @Then("I should be redirected to the Projects page")
    public void iShouldBeRedirectedToTheProjectsPage() {
        String expectedURL = testHarness.getData("AdminData", "ExpectedProjectsPageURL");
        verifyPageRedirection(expectedURL);
    }

    @Then("I should see the {string} option on the Projects page")
    public void iShouldSeeTheOptionOnTheProjectsPage(String option) {
        if (option.equals("create new project")) {
            Assert.assertTrue(isElementVisible(By.id("createNewProjectButton")), "Create new project option is not visible.");
        }
    }
}