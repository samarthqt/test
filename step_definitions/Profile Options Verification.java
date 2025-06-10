package com.cucumber.steps;

import com.page_objects.ProfilePage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileOptionsSteps extends ProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged into the COCO application as an Admin with username {string} and password {string}")
    public void iAmLoggedIntoTheCOCOApplicationAsAnAdmin(String username, String password) {
        loginToApplication(username, password);
    }

    @Given("I am logged into the COCO application as a User with username {string} and password {string}")
    public void iAmLoggedIntoTheCOCOApplicationAsAUser(String username, String password) {
        loginToApplication(username, password);
    }

    @When("I navigate to the profile page")
    public void iNavigateToTheProfilePage() {
        navigateToProfilePage();
    }

    @Then("I should see the 'Release' label with the appropriate value")
    public void iShouldSeeTheReleaseLabelWithTheAppropriateValue() {
        verifyReleaseLabel();
    }

    @Then("I should see the 'Last Deployed Date' label with the appropriate value")
    public void iShouldSeeTheLastDeployedDateLabelWithTheAppropriateValue() {
        verifyLastDeployedDateLabel();
    }
}