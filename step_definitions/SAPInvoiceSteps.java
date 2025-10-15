package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.SAPInvoicePage;
import com.framework.cucumber.TestHarness;

public class SAPInvoiceSteps extends SAPInvoicePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        // Assume credentials are pre-configured in the test harness
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        String username = testHarness.getData("SAPLoginData", "Username");
        String password = testHarness.getData("SAPLoginData", "Password");
        loginToSAP(username, password);
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        // Assume user is already logged in
    }

    @When("the user navigates to the transaction code for creating an indirect sales cancellation invoice")
    public void theUserNavigatesToTransactionCode() {
        navigateToTransactionCode("VF01");
    }

    @Then("the invoice creation screen is displayed")
    public void theInvoiceCreationScreenIsDisplayed() {
        verifyInvoiceCreationScreen();
    }

    @Given("the user is on the invoice creation screen")
    public void theUserIsOnTheInvoiceCreationScreen() {
        // Assume user is already on the invoice creation screen
    }

    @When("the user enters the billing document type as {string}")
    public void theUserEntersBillingDocumentType(String billingDocumentType) {
        enterBillingDocumentType(billingDocumentType);
    }

    @When("the user sets the VBTYP value to {string}")
    public void theUserSetsVBTYPValue(String vbtypValue) {
        setVBTYPValue(vbtypValue);
    }

    @When("the user provides the Sales Order ID as {string}")
    public void theUserProvidesSalesOrderID(String salesOrderID) {
        enterSalesOrderID(salesOrderID);
    }

    @When("the user saves the invoice")
    public void theUserSavesTheInvoice() {
        saveInvoice();
    }

    @Then("the invoice is saved successfully")
    public void theInvoiceIsSavedSuccessfully() {
        verifyInvoiceSaved();
    }

    @Given("the invoice is created successfully")
    public void theInvoiceIsCreatedSuccessfully() {
        // Assume invoice creation is successful
    }

    @When("the user navigates to the created invoice and opens the details")
    public void theUserNavigatesToCreatedInvoice() {
        openCreatedInvoiceDetails();
    }

    @Then("the invoice details are displayed")
    public void theInvoiceDetailsAreDisplayed() {
        verifyInvoiceDetailsDisplayed();
    }

    @Given("the user has opened the details of the created invoice")
    public void theUserHasOpenedInvoiceDetails() {
        // Assume invoice details are already opened
    }

    @When("the user verifies the Sale Type field in the invoice")
    public void theUserVerifiesSaleTypeField() {
        verifySaleTypeField("ADJ_BOTH");
    }

    @Then("the Sale Type field is set to \"ADJ_BOTH\"")
    public void theSaleTypeFieldIsSet() {
        // Verification is already done in the previous step
    }

    @When("the user checks the relevant tables \(e.g., VBRK, VBRP\) for data consistency")
    public void theUserChecksRelevantTables() {
        verifyDataConsistencyInTables();
    }

    @Then("data consistency is maintained across all relevant tables")
    public void dataConsistencyIsMaintained() {
        // Verification is already done in the previous step
    }

    @When("the user verifies the system logs for any errors or warnings")
    public void theUserVerifiesSystemLogs() {
        verifySystemLogs();
    }

    @Then("no errors or warnings are logged")
    public void noErrorsOrWarningsAreLogged() {
        // Verification is already done in the previous step
    }

    @When("the user validates the linkage of the invoice in the document flow")
    public void theUserValidatesInvoiceLinkage() {
        validateInvoiceLinkageInDocumentFlow();
    }

    @Then("the invoice is correctly linked in the document flow")
    public void theInvoiceIsCorrectlyLinked() {
        // Verification is already done in the previous step
    }

    @When("the user confirms the output rendering for the created invoice")
    public void theUserConfirmsOutputRendering() {
        confirmOutputRendering();
    }

    @Then("the output is rendered correctly as per the configuration")
    public void theOutputIsRenderedCorrectly() {
        // Verification is already done in the previous step
    }
}