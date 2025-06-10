package com.cucumber.steps;

import com.pageobjects.ProfilePage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileOptionsSteps extends ProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged in as an Admin")
    public void iAmLoggedInAsAnAdmin() {
        loginAsAdmin();
    }

    @Given("I am logged in as a User")
    public void iAmLoggedInAsAUser() {
        loginAsUser();
    }

    @When("I navigate to the profile page")
    public void iNavigateToTheProfilePage() {
        navigateToProfilePage();
    }

    @Then("I should see the {string} label displayed")
    public void iShouldSeeTheLabelDisplayed(String labelName) {
        verifyLabelDisplayed(labelName);
    }

    @Then("the {string} label should have an appropriate value")
    public void theLabelShouldHaveAnAppropriateValue(String labelName) {
        verifyLabelValue(labelName);
    }
}