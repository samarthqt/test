package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.SAPValidationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SAPValidationSteps extends SAPValidationPage {

    @Given("the user logs into the SAP system with valid credentials")
    public void theUserLogsIntoTheSAPSystemWithValidCredentials() {
        loginToSAP("validUsername", "validPassword");
    }

    @Given("the user navigates to the Direct Sales processing program")
    public void theUserNavigatesToTheDirectSalesProcessingProgram() {
        navigateToDirectSalesProgram();
    }

    @When("the user creates a sales order with {string}, {string}, {string}, {string}, and {string} using the S1 billing document type")
    public void theUserCreatesASalesOrder(String orderId, String customerId, String productId, String quantity, String price) {
        createSalesOrder(orderId, customerId, productId, quantity, price, "S1");
    }

    @Then("the sales order is created successfully")
    public void theSalesOrderIsCreatedSuccessfully() {
        verifySalesOrderCreation();
    }

    @Then("the user processes the created sales order")
    public void theUserProcessesTheCreatedSalesOrder() {
        processSalesOrder();
    }

    @Then("the user navigates to the billing document generated for the sales order")
    public void theUserNavigatesToTheBillingDocumentGeneratedForTheSalesOrder() {
        navigateToBillingDocument();
    }

    @Then("the billing document is displayed successfully")
    public void theBillingDocumentIsDisplayedSuccessfully() {
        verifyBillingDocumentDisplay();
    }

    @Then("the amount in the billing document is displayed as positive")
    public void theAmountInTheBillingDocumentIsDisplayedAsPositive() {
        verifyBillingDocumentAmountPositive();
    }

    @Then("the quantity in the billing document is displayed as negative")
    public void theQuantityInTheBillingDocumentIsDisplayedAsNegative() {
        verifyBillingDocumentQuantityNegative();
    }

    @Then("the sign conventions are consistent with the ZOTC_CROSSREFTAB table mappings")
    public void theSignConventionsAreConsistentWithTheZOTC_CROSSREFTABTableMappings() {
        verifySignConventions();
    }

    @When("the user generates a report of the billing document details")
    public void theUserGeneratesAReportOfTheBillingDocumentDetails() {
        generateBillingDocumentReport();
    }

    @Then("the report is generated successfully showing the correct sign conventions")
    public void theReportIsGeneratedSuccessfullyShowingTheCorrectSignConventions() {
        verifyReportGeneration();
    }

    @Then("the user exports the report for further validation")
    public void theUserExportsTheReportForFurtherValidation() {
        exportReport();
    }

    @Then("the report is exported successfully in the desired format")
    public void theReportIsExportedSuccessfullyInTheDesiredFormat() {
        verifyReportExport();
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        verifyUserLoggedIn();
    }

    @When("the user logs out of the SAP system")
    public void theUserLogsOutOfTheSAPSystem() {
        logoutFromSAP();
    }

    @Then("the user is logged out of the SAP system successfully")
    public void theUserIsLoggedOutOfTheSAPSystemSuccessfully() {
        verifyUserLoggedOut();
    }

    @Given("the user has completed the validation of the billing document")
    public void theUserHasCompletedTheValidationOfTheBillingDocument() {
        verifyValidationCompleted();
    }

    @When("the user documents the test results and observations")
    public void theUserDocumentsTheTestResultsAndObservations() {
        documentTestResults();
    }

    @Then("the test results and observations are documented accurately")
    public void theTestResultsAndObservationsAreDocumentedAccurately() {
        verifyTestResultsDocumentation();
    }
}