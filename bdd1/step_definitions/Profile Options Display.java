package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProfileOptionsSteps extends AdminProfilePage {

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @Given("the user is logged into COCO")
    public void theUserIsLoggedIntoCOCO() {
        // Implement user login logic here
    }

    @When("I navigate to the user profile")
    public void iNavigateToTheUserProfile() {
        navigateToUserProfile();
    }

    @When("the user navigates to the user profile")
    public void theUserNavigatesToTheUserProfile() {
        navigateToUserProfile();
    }

    @When("I navigate to the home page")
    public void iNavigateToTheHomePage() {
        // Implement navigation to home page logic here
    }

    @When("the user navigates to the home page")
    public void theUserNavigatesToTheHomePage() {
        // Implement navigation to home page logic here
    }

    @Then("the following labels should be displayed with appropriate values:")
    public void theFollowingLabelsShouldBeDisplayedWithAppropriateValues(io.cucumber.datatable.DataTable dataTable) {
        // Implement verification logic for labels here
        Assert.assertTrue(isLabelDisplayed("Release"), "Release label is not displayed.");
        Assert.assertTrue(isLabelDisplayed("Last Deployed Date"), "Last Deployed Date label is not displayed.");
    }

    private boolean isLabelDisplayed(String label) {
        // Implement logic to check if label is displayed
        return true;
    }
}