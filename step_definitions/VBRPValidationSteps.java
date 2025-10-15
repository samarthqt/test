package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.VBRPValidationPage;
import com.framework.cucumber.TestHarness;

public class VBRPValidationSteps extends VBRPValidationPage {

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        enterCredentials("username", "password");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        loginToSAP();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIntoTheSystem() {
        verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the billing correction request creation screen")
    public void theUserNavigatesToBillingCorrectionRequestScreen() {
        navigateToBillingCorrectionRequestScreen();
    }

    @Then("the billing correction request creation screen is displayed")
    public void theBillingCorrectionRequestScreenIsDisplayed() {
        verifyBillingCorrectionRequestScreenDisplayed();
    }

    @Given("the user is on the billing correction request creation screen")
    public void theUserIsOnBillingCorrectionRequestScreen() {
        verifyBillingCorrectionRequestScreenDisplayed();
    }

    @When("the user enters the original billing document number {string}")
    public void theUserEntersOriginalBillingDocumentNumber(String originalBillingDocumentNumber) {
        enterOriginalBillingDocumentNumber(originalBillingDocumentNumber);
    }

    @When("the user selects the billing correction request type {string}")
    public void theUserSelectsBillingCorrectionRequestType(String billingCorrectionRequestType) {
        selectBillingCorrectionRequestType(billingCorrectionRequestType);
    }

    @When("the user saves the billing correction request")
    public void theUserSavesBillingCorrectionRequest() {
        saveBillingCorrectionRequest();
    }

    @Then("the billing correction request is successfully created")
    public void theBillingCorrectionRequestIsSuccessfullyCreated() {
        verifyBillingCorrectionRequestCreated();
    }

    @Given("the billing correction request is successfully created")
    public void theBillingCorrectionRequestIsSuccessfullyCreatedGiven() {
        verifyBillingCorrectionRequestCreated();
    }

    @When("the user generates a ZL2C billing document linked to the billing correction request")
    public void theUserGeneratesZL2CBillingDocument() {
        generateZL2CBillingDocument();
    }

    @Then("the ZL2C billing document is successfully generated")
    public void theZL2CBillingDocumentIsSuccessfullyGenerated() {
        verifyZL2CBillingDocumentGenerated();
    }

    @Given("the ZL2C billing document is successfully generated")
    public void theZL2CBillingDocumentIsSuccessfullyGeneratedGiven() {
        verifyZL2CBillingDocumentGenerated();
    }

    @When("the user accesses the VBRP table")
    public void theUserAccessesVBRPTable() {
        accessVBRPTable();
    }

    @Then("the VBRP table entries for the ZL2C billing document are displayed")
    public void theVBRPTableEntriesAreDisplayed() {
        verifyVBRPTableEntriesDisplayed();
    }

    @Given("the VBRP table entries for the ZL2C billing document are displayed")
    public void theVBRPTableEntriesAreDisplayedGiven() {
        verifyVBRPTableEntriesDisplayed();
    }

    @When("the user verifies that item category {string} has a {string} sign convention in the VBRP table")
    public void theUserVerifiesSignConventions(String itemCategory, String signConvention) {
        verifySignConventionsInVBRPTable(itemCategory, signConvention);
    }

    @Then("the VBRP table reflects {string} values for {string} items")
    public void theVBRPTableReflectsValues(String signConvention, String itemCategory) {
        verifySignConventionsInVBRPTable(itemCategory, signConvention);
    }

    @When("the user validates the linkage between the ZL2C billing document and the original billing document")
    public void theUserValidatesLinkageBetweenDocuments() {
        validateLinkageBetweenDocuments();
    }

    @Then("the VBRP table accurately links the ZL2C billing document to the original billing document")
    public void theVBRPTableAccuratelyLinksDocuments() {
        verifyLinkageBetweenDocuments();
    }

    @When("the user generates a report to review the VBRP table entries")
    public void theUserGeneratesReportForVBRPTable() {
        generateVBRPTableReport();
    }

    @Then("the report confirms accurate data consistency in the VBRP table")
    public void theReportConfirmsDataConsistency() {
        verifyDataConsistencyInReport();
    }

    @When("the user validates the financial data in the ZL2C billing document")
    public void theUserValidatesFinancialData() {
        validateFinancialDataInZL2CBillingDocument();
    }

    @Then("the financial data is consistent and accurately reflects the VBRP table entries")
    public void theFinancialDataIsConsistent() {
        verifyFinancialDataConsistency();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfSAPSystem() {
        logoutFromSAP();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}