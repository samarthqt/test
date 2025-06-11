package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.ProfilePage;

public class ProfileOptionsSteps extends ProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the admin user is logged in successfully")
    public void theAdminUserIsLoggedInSuccessfully() {
        verifyAdminLoggedIn();
    }

    @When("the admin user navigates to the profile section")
    public void theAdminUserNavigatesToTheProfileSection() {
        navigateToProfileSection();
    }

    @Then("the profile section is displayed")
    public void theProfileSectionIsDisplayed() {
        verifyProfileSectionDisplayed();
    }

    @Then("the 'Release' label is displayed with appropriate value")
    public void theReleaseLabelIsDisplayedWithAppropriateValue() {
        verifyReleaseLabelDisplayed();
    }

    @Then("the 'Last Deployed Date' label is displayed with appropriate value")
    public void theLastDeployedDateLabelIsDisplayedWithAppropriateValue() {
        verifyLastDeployedDateLabelDisplayed();
    }

    @When("the admin user logs out")
    public void theAdminUserLogsOut() {
        logoutAdminUser();
    }

    @Then("the admin user is logged out")
    public void theAdminUserIsLoggedOut() {
        verifyAdminUserLoggedOut();
    }

    @Given("the user logs in successfully")
    public void theUserLogsInSuccessfully() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the profile section")
    public void theUserNavigatesToTheProfileSection() {
        navigateToProfileSection();
    }

    @Then("the profile section is displayed")
    public void theProfileSectionIsDisplayed() {
        verifyProfileSectionDisplayed();
    }

    @Then("the 'Release' label is displayed with appropriate value")
    public void theReleaseLabelIsDisplayedWithAppropriateValue() {
        verifyReleaseLabelDisplayed();
    }

    @Then("the 'Last Deployed Date' label is displayed with appropriate value")
    public void theLastDeployedDateLabelIsDisplayedWithAppropriateValue() {
        verifyLastDeployedDateLabelDisplayed();
    }
}