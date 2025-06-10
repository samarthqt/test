package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminProfileSteps extends AdminProfilePage {

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @Given("I can view admin profile menu options")
    public void iCanViewAdminProfileMenuOptions() {
        navigateToUserProfile();
    }

    @When("I click on the {string} menu option")
    public void iClickOnTheMenuOption(String menuOption) {
        clickElement(By.linkText(menuOption));
    }

    @Then("I should be redirected to the Projects page")
    public void iShouldBeRedirectedToTheProjectsPage() {
        String expectedURL = "expectedProjectsPageURL"; // Replace with actual expected URL
        verifyHomePageRedirection(expectedURL);
    }

    @Then("I should see the {string} option on the Projects page")
    public void iShouldSeeTheOptionOnTheProjectsPage(String option) {
        Assert.assertTrue(isElementVisible(By.linkText(option)), "Create new project option is not visible.");
    }
}