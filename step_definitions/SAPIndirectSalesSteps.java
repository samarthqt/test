package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.SAPIndirectSalesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SAPIndirectSalesSteps extends SAPIndirectSalesPage {

    @Given("user has valid credentials")
    public void userHasValidCredentials() {
        enterCredentials("validUsername", "validPassword");
    }

    @When("user logs into the SAP system")
    public void userLogsIntoTheSAPSystem() {
        loginToSAP();
    }

    @Then("user is logged into the SAP system successfully")
    public void userIsLoggedIntoTheSAPSystemSuccessfully() {
        verifyLoginSuccess();
    }

    @Given("user is logged into the SAP system")
    public void userIsLoggedIntoTheSAPSystem() {
        ensureUserLoggedIn();
    }

    @When("user navigates to the Indirect Sales processing program \(ZOTC_INDSALES_MDLNE\)")
    public void userNavigatesToTheIndirectSalesProcessingProgram() {
        navigateToIndirectSalesProgram();
    }

    @Then("the Indirect Sales processing program interface is displayed")
    public void theIndirectSalesProcessingProgramInterfaceIsDisplayed() {
        verifyIndirectSalesProgramInterface();
    }

    @Given("user is on the Indirect Sales processing program interface")
    public void userIsOnTheIndirectSalesProcessingProgramInterface() {
        ensureOnIndirectSalesProgramInterface();
    }

    @When("user processes an indirect sales transaction with billing document type {string} using the provided test data: Transaction ID {string}, Customer ID {string}, Product ID {string}, Quantity {string}, Price {string}")
    public void userProcessesAnIndirectSalesTransaction(String billingDocumentType, String transactionID, String customerID, String productID, String quantity, String price) {
        processIndirectSalesTransaction(billingDocumentType, transactionID, customerID, productID, quantity, price);
    }

    @Then("the indirect sales transaction is processed successfully with billing document type {string}")
    public void theIndirectSalesTransactionIsProcessedSuccessfully(String billingDocumentType) {
        verifyTransactionProcessed(billingDocumentType);
    }

    @Given("user has processed an indirect sales transaction")
    public void userHasProcessedAnIndirectSalesTransaction() {
        ensureTransactionProcessed();
    }

    @When("user navigates to the data generated for the indirect sales transaction")
    public void userNavigatesToTheDataGeneratedForTheIndirectSalesTransaction() {
        navigateToGeneratedData();
    }

    @Then("the generated data for the indirect sales transaction is displayed")
    public void theGeneratedDataForTheIndirectSalesTransactionIsDisplayed() {
        verifyGeneratedDataDisplayed();
    }

    @Given("user has navigated to the generated data for the indirect sales transaction")
    public void userHasNavigatedToTheGeneratedDataForTheIndirectSalesTransaction() {
        ensureGeneratedDataDisplayed();
    }

    @When("user verifies the ExternalInvoiceQuantityAmount in the generated data")
    public void userVerifiesTheExternalInvoiceQuantityAmountInTheGeneratedData() {
        verifyExternalInvoiceQuantityAmount();
    }

    @Then("the ExternalInvoiceQuantityAmount is displayed as negative")
    public void theExternalInvoiceQuantityAmountIsDisplayedAsNegative() {
        verifyNegativeExternalInvoiceQuantityAmount();
    }

    @Given("user has verified the ExternalInvoiceQuantityAmount")
    public void userHasVerifiedTheExternalInvoiceQuantityAmount() {
        ensureExternalInvoiceQuantityAmountVerified();
    }

    @When("user validates the consistency of the sign conventions with the ZOTC_CROSSREFTAB table mappings")
    public void userValidatesTheConsistencyOfTheSignConventionsWithTheZOTC_CROSSREFTABTableMappings() {
        validateSignConventionsWithTableMappings();
    }

    @Then("the sign conventions are consistent with the ZOTC_CROSSREFTAB table mappings")
    public void theSignConventionsAreConsistentWithTheZOTC_CROSSREFTABTableMappings() {
        verifySignConventionsConsistency();
    }

    @Given("user has validated the consistency of the sign conventions")
    public void userHasValidatedTheConsistencyOfTheSignConventions() {
        ensureSignConventionsValidated();
    }

    @When("user generates a report of the indirect sales transaction details")
    public void userGeneratesAReportOfTheIndirectSalesTransactionDetails() {
        generateTransactionReport();
    }

    @Then("the report is generated successfully showing the correct sign conventions")
    public void theReportIsGeneratedSuccessfullyShowingTheCorrectSignConventions() {
        verifyReportGenerated();
    }

    @Given("user has generated the report of the indirect sales transaction details")
    public void userHasGeneratedTheReportOfTheIndirectSalesTransactionDetails() {
        ensureReportGenerated();
    }

    @When("user exports the report in {string}")
    public void userExportsTheReportIn(String format) {
        exportReport(format);
    }

    @Then("the report is exported successfully in the desired format")
    public void theReportIsExportedSuccessfullyInTheDesiredFormat() {
        verifyReportExported();
    }

    @Given("user has completed all validations and actions")
    public void userHasCompletedAllValidationsAndActions() {
        ensureAllActionsCompleted();
    }

    @When("user logs out of the SAP system")
    public void userLogsOutOfTheSAPSystem() {
        logoutFromSAP();
    }

    @Then("user is logged out of the SAP system successfully")
    public void userIsLoggedOutOfTheSAPSystemSuccessfully() {
        verifyLogoutSuccess();
    }

    @Given("user has logged out of the SAP system")
    public void userHasLoggedOutOfTheSAPSystem() {
        ensureUserLoggedOut();
    }

    @When("user documents the test results and observations")
    public void userDocumentsTheTestResultsAndObservations() {
        documentTestResults();
    }

    @Then("the test results and observations are documented accurately")
    public void theTestResultsAndObservationsAreDocumentedAccurately() {
        verifyTestResultsDocumented();
    }
}