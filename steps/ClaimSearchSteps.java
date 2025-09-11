package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;

import com.pageobjects.ClaimSearchPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClaimSearchSteps extends ClaimSearchPage {

    @Given("the user navigates to the claim search page")
    public void theUserNavigatesToTheClaimSearchPage() {
        navigateToClaimSearchPage();
    }

    @Then("the user should see an input field labeled \"Patient DOB\"")
    public void theUserShouldSeeAnInputFieldLabeledPatientDOB() {
        verifyPatientDOBFieldPresence();
    }

    @When("the user enters \"{string}\" in the \"Patient DOB\" field")
    public void theUserEntersInThePatientDOBField(String patientDOB) {
        enterPatientDOB(patientDOB);
    }

    @Then("the system should validate the format as \"{string}\"")
    public void theSystemShouldValidateTheFormatAs(String validationResult) {
        validatePatientDOBFormat(validationResult);
    }

    @When("the user leaves the \"Patient DOB\" field blank")
    public void theUserLeavesThePatientDOBFieldBlank() {
        leavePatientDOBFieldBlank();
    }

    @Then("the system should not display any error message")
    public void theSystemShouldNotDisplayAnyErrorMessage() {
        verifyNoErrorMessageForBlankDOB();
    }

    @Then("the system should validate the date as \"{string}\"")
    public void theSystemShouldValidateTheDateAs(String validationResult) {
        validatePatientDOBNotInFuture(validationResult);
    }

    @Then("the system should display the error message \"{string}\"")
    public void theSystemShouldDisplayTheErrorMessage(String errorMessage) {
        verifyErrorMessageForInvalidDOB(errorMessage);
    }
}

