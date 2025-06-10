package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileOptionsSteps extends AdminProfilePage {

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @Given("I am logged into COCO as a User")
    public void iAmLoggedIntoCOCOAsAUser() {
        loginAsUser();
    }

    @When("I navigate to the user profile")
    public void iNavigateToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("I should see the \"Release\" label displayed with an appropriate value")
    public void iShouldSeeTheReleaseLabelDisplayedWithAnAppropriateValue() {
        verifyLabelDisplayedWithValue("Release");
    }

    @Then("I should see the \"Last Deployed Date\" label displayed with an appropriate value")
    public void iShouldSeeTheLastDeployedDateLabelDisplayedWithAnAppropriateValue() {
        verifyLabelDisplayedWithValue("Last Deployed Date");
    }
}