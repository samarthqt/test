package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.BillingTypePage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class BillingTypeSteps extends BillingTypePage {

    @Given("the user is logged into the SAP S/4HANA Cloud system with appropriate credentials")
    public void theUserIsLoggedIntoTheSAPSystem() {
        loginToSAPSystem("username", "password");
    }

    @Given("Attribute 1 is set to {string}")
    public void attribute1IsSetTo(String attribute1) {
        setAttribute1(attribute1);
    }

    @Given("Attribute 2 is correctly configured as {string}")
    public void attribute2IsConfiguredAs(String attribute2) {
        configureAttribute2(attribute2);
    }

    @When("the user navigates to the billing due program")
    public void theUserNavigatesToBillingDueProgram() {
        navigateToBillingDueProgram();
    }

    @Then("the billing due program screen is displayed and is active")
    public void billingDueProgramScreenIsDisplayed() {
        verifyBillingDueProgramScreen();
    }

    @When("the user enters Attribute 1 as {string} in the relevant field")
    public void theUserEntersAttribute1(String attribute1) {
        enterAttribute1(attribute1);
    }

    @Then("Attribute 1 is accepted as {string}")
    public void attribute1IsAccepted(String attribute1) {
        verifyAttribute1Acceptance(attribute1);
    }

    @When("the user enters the minimum valid value {string} for Subtype in the respective field")
    public void theUserEntersMinimumValidSubtype(String subtype) {
        enterSubtype(subtype);
    }

    @Then("the minimum valid subtype value {string} is accepted")
    public void minimumValidSubtypeIsAccepted(String subtype) {
        verifySubtypeAcceptance(subtype);
    }

    @When("the user populates Attribute 2 with {string}")
    public void theUserPopulatesAttribute2(String attribute2) {
        populateAttribute2(attribute2);
    }

    @Then("Attribute 2 is populated successfully")
    public void attribute2IsPopulatedSuccessfully() {
        verifyAttribute2Population();
    }

    @When("the user executes the billing due program")
    public void theUserExecutesBillingDueProgram() {
        executeBillingDueProgram();
    }

    @Then("the billing due program executes without errors")
    public void billingDueProgramExecutesWithoutErrors() {
        verifyBillingDueProgramExecution();
    }

    @When("the user verifies the generated billing document in the system")
    public void theUserVerifiesGeneratedBillingDocument() {
        verifyGeneratedBillingDocument();
    }

    @Then("a billing document of the correct type is generated")
    public void billingDocumentOfCorrectTypeIsGenerated() {
        verifyBillingDocumentType();
    }

    @When("the user checks the document details for proper mapping of Attribute 1 {string} and minimum valid subtype value {string}")
    public void theUserChecksDocumentDetails(String attribute1, String subtype) {
        checkDocumentDetails(attribute1, subtype);
    }

    @Then("the document details match the expected mapping")
    public void documentDetailsMatchExpectedMapping() {
        verifyDocumentDetailsMapping();
    }

    @When("the user verifies the document flow for correct linkage")
    public void theUserVerifiesDocumentFlow() {
        verifyDocumentFlowLinkage();
    }

    @Then("the document flow shows proper linkage and no errors")
    public void documentFlowShowsProperLinkage() {
        verifyDocumentFlowErrors();
    }

    @When("the user validates the financial postings associated with the billing document")
    public void theUserValidatesFinancialPostings() {
        validateFinancialPostings();
    }

    @Then("the financial postings are accurate and reflect the correct billing type")
    public void financialPostingsAreAccurate() {
        verifyFinancialPostingsAccuracy();
    }

    @When("the user checks the system logs for any warnings or errors during the process")
    public void theUserChecksSystemLogs() {
        checkSystemLogs();
    }

    @Then("no warnings or errors are logged")
    public void noWarningsOrErrorsAreLogged() {
        verifyNoWarningsOrErrors();
    }

    @When("the user ensures the billing document is ready for further processing or transmission")
    public void theUserEnsuresBillingDocumentIsReady() {
        ensureBillingDocumentReady();
    }

    @Then("the billing document is marked as ready for further processing")
    public void billingDocumentIsMarkedReady() {
        verifyBillingDocumentReadyStatus();
    }
}