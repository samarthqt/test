package com.cucumber.steps;

import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ZRKCorrectionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZRKCorrectionSteps {

    private ZRKCorrectionPage zrkCorrectionPage = new ZRKCorrectionPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        zrkCorrectionPage.loginToSAPSystem("validUsername", "validPassword");
    }

    @When("the user logs in to the SAP system")
    public void theUserLogsInToTheSAPSystem() {
        zrkCorrectionPage.clickLoginButton();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        zrkCorrectionPage.verifySuccessfulLogin("Welcome to SAP");
    }

    @Given("the user has appropriate permissions to create correction requests")
    public void theUserHasAppropriatePermissionsToCreateCorrectionRequests() {
        zrkCorrectionPage.verifyUserPermissions("BillingCorrectionAccess");
    }

    @When("the user navigates to the billing correction form")
    public void theUserNavigatesToTheBillingCorrectionForm() {
        zrkCorrectionPage.navigateToBillingCorrectionForm();
    }

    @Then("the billing correction form is displayed")
    public void theBillingCorrectionFormIsDisplayed() {
        zrkCorrectionPage.verifyBillingCorrectionFormDisplayed();
    }

    @When("the user selects {string} as the correction request type")
    public void theUserSelectsAsTheCorrectionRequestType(String correctionType) {
        zrkCorrectionPage.selectCorrectionRequestType(correctionType);
    }

    @Then("{string} correction request type is selected")
    public void correctionRequestTypeIsSelected(String correctionType) {
        zrkCorrectionPage.verifyCorrectionRequestTypeSelected(correctionType);
    }

    @When("the user enters the following mandatory fields:")
    public void theUserEntersTheFollowingMandatoryFields(io.cucumber.datatable.DataTable dataTable) {
        String customerID = dataTable.cell(1, 0);
        String billingDocumentNumber = dataTable.cell(1, 1);
        zrkCorrectionPage.enterMandatoryFields(customerID, billingDocumentNumber);
    }

    @When("the user submits the form")
    public void theUserSubmitsTheForm() {
        zrkCorrectionPage.submitCorrectionForm();
    }

    @Then("the system responds with {string}")
    public void theSystemRespondsWith(String systemResponse) {
        zrkCorrectionPage.verifySystemResponse(systemResponse);
    }

    @Then("the correction request {string}")
    public void theCorrectionRequest(String requestStatus) {
        zrkCorrectionPage.verifyCorrectionRequestStatus(requestStatus);
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        zrkCorrectionPage.verifySuccessfulLogin("Welcome to SAP");
    }

    @When("the user logs out of the SAP system")
    public void theUserLogsOutOfTheSAPSystem() {
        zrkCorrectionPage.logoutFromSAPSystem();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        zrkCorrectionPage.verifySuccessfulLogout("You have been logged out");
    }

    @Given("the user uploads a batch of {string} ZRK correction requests into the system")
    public void theUserUploadsABatchOfZRKCorrectionRequestsIntoTheSystem(String numberOfRequests) {
        zrkCorrectionPage.uploadBatchZRKCorrectionRequests(numberOfRequests);
    }

    @Then("all correction requests are successfully uploaded without any errors")
    public void allCorrectionRequestsAreSuccessfullyUploadedWithoutAnyErrors() {
        zrkCorrectionPage.verifyBatchUploadSuccess();
    }

    @Given("the user submits all ZRK correction requests for processing")
    public void theUserSubmitsAllZRKCorrectionRequestsForProcessing() {
        zrkCorrectionPage.submitZRKCorrectionRequests();
    }

    @Then("the system processes all requests and generates ZG2C documents for each correction")
    public void theSystemProcessesAllRequestsAndGeneratesZG2CDocumentsForEachCorrection() {
        zrkCorrectionPage.verifyZG2CDocumentGeneration();
    }

    @Given("the user reviews the ZG2C documents generated")
    public void theUserReviewsTheZG2CDocumentsGenerated() {
        zrkCorrectionPage.reviewZG2CDocuments();
    }

    @Then("each ZG2C document is traceable to its originating ZRK correction request")
    public void eachZG2CDocumentIsTraceableToItsOriginatingZRKCorrectionRequest() {
        zrkCorrectionPage.verifyZG2CTraceability();
    }

    @When("the user checks the financial postings for the generated credit document")
    public void theUserChecksFinancialPostings() {
        zrkCorrectionPage.verifyFinancialPostings();
    }

    @Then("the financial postings are accurate and align with the correction request")
    public void theFinancialPostingsAreAccurate() {
        zrkCorrectionPage.verifyFinancialPostings();
    }

    @When("the user checks the audit trail for the correction request and associated documents")
    public void theUserChecksAuditTrail() {
        zrkCorrectionPage.verifyAuditTrail();
    }

    @Then("the audit trail shows a clear linkage between the correction request, credit document, and output")
    public void theAuditTrailShowsClearLinkage() {
        zrkCorrectionPage.verifyAuditTrail();
    }

    @When("the user validates compliance with business rules and financial integrity")
    public void theUserValidatesCompliance() {
        zrkCorrectionPage.validateCompliance();
    }

    @Then("all processes comply with business rules and maintain financial integrity")
    public void allProcessesComplyWithBusinessRules() {
        zrkCorrectionPage.validateCompliance();
    }

    @When("the user logs out of the system")
    public void theUserLogsOutOfTheSystem() {
        zrkCorrectionPage.logoutSAPSystem();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        zrkCorrectionPage.verifyLogout();
    }
}
