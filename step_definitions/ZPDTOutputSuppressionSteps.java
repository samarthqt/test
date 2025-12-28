package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ZPDTOutputSuppressionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZPDTOutputSuppressionSteps extends ZPDTOutputSuppressionPage {

    @Given("the user is logged into the SAP system with appropriate permissions")
    public void theUserIsLoggedIntoTheSAPSystemWithAppropriatePermissions() {
        loginToSAPSystem("username", "password");
    }

    @Given("the user has access to the Payer Business Partner master data for {string}")
    public void theUserHasAccessToThePayerBusinessPartnerMasterDataFor(String payerBusinessPartnerID) {
        navigateToPayerBusinessPartnerMasterData(payerBusinessPartnerID);
    }

    @When("the user navigates to the Payer Business Partner master data screen")
    public void theUserNavigatesToThePayerBusinessPartnerMasterDataScreen() {
        openMasterDataScreen();
    }

    @When("the user locates Attribute 7 in the master data fields")
    public void theUserLocatesAttribute7InTheMasterDataFields() {
        locateAttribute7Field();
    }

    @When("the user sets Attribute 7 to {string} and saves the changes")
    public void theUserSetsAttribute7ToAndSavesTheChanges(String attribute7Value) {
        setAttribute7Value(attribute7Value);
        saveChanges();
    }

    @When("the user creates a new billing document for the Payer Business Partner")
    public void theUserCreatesANewBillingDocumentForThePayerBusinessPartner() {
        createBillingDocument();
    }

    @When("the user triggers the output determination process for the billing document")
    public void theUserTriggersTheOutputDeterminationProcessForTheBillingDocument() {
        triggerOutputDetermination();
    }

    @Then("the output log for the billing document indicates that the ZPDT output is {string}")
    public void theOutputLogForTheBillingDocumentIndicatesThatTheZPDTOutputIs(String outputSuppressionStatus) {
        verifyOutputLog(outputSuppressionStatus);
    }

    @Then("the document flow for the billing document does not show any invoice sent to the customer")
    public void theDocumentFlowForTheBillingDocumentDoesNotShowAnyInvoiceSentToTheCustomer() {
        verifyDocumentFlowNoInvoice();
    }

    @Then("the system logs confirm that the process executed without errors")
    public void theSystemLogsConfirmThatTheProcessExecutedWithoutErrors() {
        verifySystemLogsNoErrors();
    }
}