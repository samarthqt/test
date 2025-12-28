package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.MappingRulesPage;
import com.framework.cucumber.TestHarness;

public class MappingRulesSteps {

    private MappingRulesPage mappingRulesPage = new MappingRulesPage();
    private TestHarness testHarness = new TestHarness();

    @Given("user logs in to SAP S/4HANA Cloud with valid credentials")
    public void userLogsInToSAPCloud() {
        mappingRulesPage.loginToSAPCloud("validUsername", "validPassword");
    }

    @Given("user navigates to the Sales Order to Billing Document copy process")
    public void userNavigatesToSalesOrderCopyProcess() {
        mappingRulesPage.navigateToSalesOrderCopyProcess();
    }

    @When("user selects the Sales Order with KATR1 = {string}")
    public void userSelectsSalesOrder(String katr1) {
        mappingRulesPage.selectSalesOrder(katr1);
    }

    @When("user initiates the copy process to create the Billing Document")
    public void userInitiatesCopyProcess() {
        mappingRulesPage.initiateCopyProcess();
    }

    @Then("the generated Billing Document type FKART should be {string}")
    public void verifyGeneratedBillingDocumentType(String fkart) {
        mappingRulesPage.verifyBillingDocumentType(fkart);
    }

    @Then("the mapping rules for KATR1 = {string} in the system configuration should correctly define FKART = {string}")
    public void verifyMappingRules(String katr1, String fkart) {
        mappingRulesPage.verifyMappingRulesInSystem(katr1, fkart);
    }

    @Then("no errors should be displayed during the copy process")
    public void verifyNoErrorsInCopyProcess() {
        mappingRulesPage.verifyNoErrors();
    }

    @Then("user saves the Billing Document and verifies its status as {string}")
    public void userSavesBillingDocument(String status) {
        mappingRulesPage.saveBillingDocument();
        mappingRulesPage.verifyBillingDocumentStatus(status);
    }

    @Then("user generates a report of the Billing Document for auditing purposes")
    public void userGeneratesBillingDocumentReport() {
        mappingRulesPage.generateBillingDocumentReport();
    }

    @Then("the report should be generated successfully with correct FKART details")
    public void verifyReportGeneration() {
        mappingRulesPage.verifyReportDetails();
    }

    @Then("user logs out of the system")
    public void userLogsOut() {
        mappingRulesPage.logoutFromSAPCloud();
    }

    @Then("the audit trail for the Billing Document creation should confirm accurate mapping and process completion")
    public void verifyAuditTrail() {
        mappingRulesPage.reviewAuditTrail();
    }

    @Then("the Billing Document type in downstream systems should correctly reflect FKART = {string}")
    public void verifyBillingDocumentInDownstreamSystems(String fkart) {
        mappingRulesPage.verifyDownstreamBillingDocumentType(fkart);
    }

    @Then("user should be successfully logged in")
    public void verifySuccessfulLogin() {
        mappingRulesPage.verifyLoginSuccess();
    }

    @Then("the Sales Order copy process screen should be displayed")
    public void verifySalesOrderCopyProcessScreen() {
        mappingRulesPage.verifyCopyProcessScreen();
    }

    @Given("user reviews the audit trail for the Billing Document creation")
    public void userReviewsAuditTrail() {
        mappingRulesPage.reviewAuditTrail();
    }

    @Given("user verifies the Billing Document type in downstream systems")
    public void userVerifiesBillingDocumentInDownstreamSystems() {
        mappingRulesPage.verifyDownstreamBillingDocumentType("ZF2");
    }

    @Given("user has appropriate credentials")
    public void userHasAppropriateCredentials() {
        mappingRulesPage.navigateToLoginPage();
        mappingRulesPage.enterCredentials("username", "password");
    }

    @When("user logs into the SAP S/4HANA Cloud system")
    public void userLogsIntoTheSAPCloudSystem() {
        mappingRulesPage.clickLoginButton();
    }

    @Then("user is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        mappingRulesPage.verifyLoginSuccess();
    }

    @Given("user has navigated to the Sales Order creation screen")
    public void userNavigatesToSalesOrderCreationScreen() {
        mappingRulesPage.navigateToSalesOrderCreationScreen();
    }

    @When("user creates a Sales Order with KATR1 = {string} and KATR2 = {string}")
    public void userCreatesSalesOrder(String katr1, String katr2) {
        mappingRulesPage.createSalesOrder(katr1, katr2);
    }

    @Then("the Sales Order is created successfully with the correct mapping rules")
    public void salesOrderCreatedSuccessfully() {
        mappingRulesPage.verifySalesOrderCreation();
    }

    @Given("user is on the SAP S/4HANA Cloud homepage")
    public void userIsOnHomepage() {
        mappingRulesPage.navigateToHomepage();
    }

    @When("user navigates to the Sales Order to Billing Document copy process")
    public void userNavigatesToCopyProcess() {
        mappingRulesPage.navigateToCopyProcessScreen();
    }

    @Then("Sales Order copy process screen is displayed")
    public void copyProcessScreenDisplayed() {
        mappingRulesPage.verifyCopyProcessScreen();
    }

    @Given("user is on the Sales Order copy process screen")
    public void userIsOnCopyProcessScreen() {
        mappingRulesPage.navigateToCopyProcessScreen();
    }

    @When("user selects the Sales Order with KATR1 = {string} and KATR2 = {string}")
    public void userSelectsSalesOrder(String katr1, String katr2) {
        mappingRulesPage.selectSalesOrder(katr1, katr2);
    }

    @Then("no errors are displayed during the copy process")
    public void verifyNoErrorsDuringCopyProcess() {
        mappingRulesPage.verifyNoErrors();
    }

    @Given("user has access to system configuration")
    public void userHasAccessToSystemConfiguration() {
        mappingRulesPage.navigateToSystemConfiguration();
    }

    @When("user validates the mapping rules for KATR1 = 'ZS' and KATR2 = '10'")
    public void userValidatesMappingRules() {
        mappingRulesPage.validateMappingRules("ZS", "10");
    }

    @Then("mapping rules correctly define FKART = 'ZFCB'")
    public void verifyMappingRules() {
        mappingRulesPage.verifyMappingRules("ZFCB");
    }

    @Given("user has successfully created a Billing Document")
    public void userHasCreatedBillingDocument() {
        mappingRulesPage.verifyBillingDocumentCreation();
    }

    @When("user saves the Billing Document")
    public void userSavesBillingDocument() {
        mappingRulesPage.saveBillingDocument();
    }

    @Then("the Billing Document is saved successfully with status 'Completed'")
    public void verifyBillingDocumentSaved() {
        mappingRulesPage.verifyBillingDocumentStatus("Completed");
    }

    @Given("user has a completed Billing Document")
    public void userHasCompletedBillingDocument() {
        mappingRulesPage.verifyBillingDocumentStatus("Completed");
    }

    @When("user generates a report for the Billing Document")
    public void userGeneratesReport() {
        mappingRulesPage.generateBillingDocumentReport();
    }

    @Then("the report is generated successfully with correct FKART details")
    public void verifyReportGenerated() {
        mappingRulesPage.verifyReportDetails("ZFCB");
    }

    @Given("user has completed all tasks")
    public void userHasCompletedAllTasks() {
        mappingRulesPage.verifyAllTasksCompleted();
    }

    @When("user logs out of the SAP S/4HANA Cloud system")
    public void userLogsOut() {
        mappingRulesPage.logout();
    }

    @Then("user is logged out successfully")
    public void verifyLogout() {
        mappingRulesPage.verifyLogoutSuccess();
    }

    @Given("user has access to the audit trail")
    public void userHasAccessToAuditTrail() {
        mappingRulesPage.navigateToAuditTrail();
    }

    @Then("audit trail confirms accurate mapping and process completion")
    public void verifyAuditTrail() {
        mappingRulesPage.verifyAuditTrailDetails();
    }

    @Given("user has completed the Billing Document creation process")
    public void userHasCompletedBillingDocumentProcess() {
        mappingRulesPage.verifyBillingDocumentCreation();
    }

    @When("user verifies the Billing Document type in downstream systems")
    public void userVerifiesBillingDocumentType() {
        mappingRulesPage.verifyDownstreamBillingDocumentType();
    }

    @Then("downstream systems correctly reflect FKART = {string}")
    public void verifyDownstreamSystems(String fkart) {
        mappingRulesPage.verifyDownstreamSystems(fkart);
    }
}
