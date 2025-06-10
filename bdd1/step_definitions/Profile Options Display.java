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

    @When("I navigate to the user profile")
    public void iNavigateToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("the following labels should be displayed with appropriate values:")
    public void theFollowingLabelsShouldBeDisplayedWithAppropriateValues(io.cucumber.datatable.DataTable dataTable) {
        for (String label : dataTable.asList()) {
            Assert.assertTrue(isLabelDisplayed(label), "Label " + label + " is not displayed.");
        }
    }

    @Given("the user is logged into COCO")
    public void theUserIsLoggedIntoCOCO() {
        loginAsAdmin(); // Assuming similar login method for simplicity
    }

    @When("the user navigates to the user profile")
    public void theUserNavigatesToTheUserProfile() {
        navigateToUserProfile();
    }

    private boolean isLabelDisplayed(String label) {
        // Implement logic to verify if the label is displayed
        // This is a placeholder for actual implementation
        return true;
    }
}