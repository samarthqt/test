package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.AdminProfilePage;

public class ProfileOptionsSteps extends AdminProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @When("I navigate to the user profile")
    public void iNavigateToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("the \"Release\" label should be displayed with an appropriate value")
    public void theReleaseLabelShouldBeDisplayedWithAnAppropriateValue() {
        verifyReleaseLabelDisplayed();
    }

    @Then("the \"Last Deployed Date\" label should be displayed with an appropriate value")
    public void theLastDeployedDateLabelShouldBeDisplayedWithAnAppropriateValue() {
        verifyLastDeployedDateLabelDisplayed();
    }

    @Given("the user is logged into COCO")
    public void theUserIsLoggedIntoCOCO() {
        loginAsUser();
    }

    @When("the user navigates to the user profile")
    public void theUserNavigatesToTheUserProfile() {
        navigateToUserProfile();
    }
}