package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.SAPActionsPage;

public class SAPActionsSteps extends SAPActionsPage {

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        loginToSAP();
    }

    @Then("the user is successfully logged in and navigates to the SAP main menu")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyNavigationToMainMenu();
    }

    @Given("the user is on the SAP main menu")
    public void theUserIsOnTheSAPMainMenu() {
        verifyMainMenuDisplayed();
    }

    @When("the user navigates to the Invoice Correction Request creation screen")
    public void theUserNavigatesToInvoiceCorrectionRequestScreen() {
        navigateToInvoiceCorrectionRequestScreen();
    }

    @Then("the Invoice Correction Request creation screen is displayed")
    public void theInvoiceCorrectionRequestScreenIsDisplayed() {
        verifyInvoiceCorrectionRequestScreenDisplayed();
    }

    @Given("the user is on the Invoice Correction Request creation screen")
    public void theUserIsOnInvoiceCorrectionRequestScreen() {
        verifyInvoiceCorrectionRequestScreenDisplayed();
    }

    @When("the user selects the Invoice Correction Request type as {string}")
    public void theUserSelectsInvoiceCorrectionRequestType(String requestType) {
        selectInvoiceCorrectionRequestType(requestType);
    }

    @When("the user enters customer details as {string} and billing details for a debit adjustment of {string}")
    public void theUserEntersCustomerAndBillingDetails(String customerDetails, String billingAmount) {
        enterCustomerAndBillingDetails(customerDetails, billingAmount);
    }

    @Then("the Invoice Correction Request type {string} is selected")
    public void theInvoiceCorrectionRequestTypeIsSelected(String requestType) {
        verifyRequestTypeSelected(requestType);
    }

    @Then("customer and billing details are entered successfully")
    public void customerAndBillingDetailsAreEnteredSuccessfully() {
        verifyCustomerAndBillingDetailsEntered();
    }

    @Given("the user has entered the required details for the Invoice Correction Request")
    public void theUserHasEnteredRequiredDetails() {
        verifyRequiredDetailsEntered();
    }

    @When("the user saves the Invoice Correction Request")
    public void theUserSavesInvoiceCorrectionRequest() {
        saveInvoiceCorrectionRequest();
    }

    @Then("the Invoice Correction Request is saved successfully")
    public void theInvoiceCorrectionRequestIsSavedSuccessfully() {
        verifyRequestSavedSuccessfully();
    }

    @Then("a unique document number is generated")
    public void aUniqueDocumentNumberIsGenerated() {
        verifyDocumentNumberGenerated();
    }

    @Given("the Invoice Correction Request is saved successfully")
    public void theInvoiceCorrectionRequestIsSaved() {
        verifyRequestSavedSuccessfully();
    }

    @When("the user triggers the output generation process for the saved Invoice Correction Request")
    public void theUserTriggersOutputGenerationProcess() {
        triggerOutputGenerationProcess();
    }

    @Then("the system initiates the output generation process")
    public void theSystemInitiatesOutputGenerationProcess() {
        verifyOutputGenerationProcessInitiated();
    }

    @Given("the output generation process is initiated")
    public void theOutputGenerationProcessIsInitiated() {
        verifyOutputGenerationProcessInitiated();
    }

    @When("the user verifies the template used for generating the ZGL1 form")
    public void theUserVerifiesTemplateUsedForZGL1Form() {
        verifyTemplateUsedForZGL1Form();
    }

    @Then("the ZGL1 form is generated using the ZPDT template")
    public void theZGL1FormIsGeneratedUsingZPDTTemplate() {
        verifyZGL1FormGeneratedUsingZPDTTemplate();
    }

    @When("the user ensures the Print Program SD_INVOICE_PRINT01 is invoked")
    public void theUserEnsuresPrintProgramInvoked() {
        ensurePrintProgramInvoked();
    }

    @Then("the Print Program SD_INVOICE_PRINT01 is invoked successfully")
    public void thePrintProgramIsInvokedSuccessfully() {
        verifyPrintProgramInvokedSuccessfully();
    }

    @Given("the ZGL1 form is generated successfully")
    public void theZGL1FormIsGeneratedSuccessfully() {
        verifyZGL1FormGeneratedSuccessfully();
    }

    @When("the user attempts to print the ZGL1 output")
    public void theUserAttemptsToPrintZGL1Output() {
        printZGL1Output();
    }

    @Then("the ZGL1 output is printed successfully")
    public void theZGL1OutputIsPrintedSuccessfully() {
        verifyZGL1OutputPrintedSuccessfully();
    }

    @Given("the ZGL1 output is printed successfully")
    public void theZGL1OutputIsPrintedSuccessfully() {
        verifyZGL1OutputPrintedSuccessfully();
    }

    @When("the user verifies the printed ZGL1 output for accuracy and completeness")
    public void theUserVerifiesPrintedZGL1Output() {
        verifyPrintedZGL1Output();
    }

    @Then("the printed ZGL1 output matches the expected format")
    public void thePrintedZGL1OutputMatchesExpectedFormat() {
        verifyPrintedOutputFormat();
    }

    @Then("the printed ZGL1 output contains all necessary details")
    public void thePrintedZGL1OutputContainsNecessaryDetails() {
        verifyPrintedOutputDetails();
    }

    @Given("the printed ZGL1 output is verified successfully")
    public void thePrintedZGL1OutputIsVerifiedSuccessfully() {
        verifyPrintedOutputDetails();
    }

    @When("the user validates the readiness of the output for customer delivery")
    public void theUserValidatesOutputReadiness() {
        validateOutputReadinessForDelivery();
    }

    @Then("the output is confirmed to be ready for customer delivery")
    public void theOutputIsConfirmedReadyForDelivery() {
        confirmOutputReadyForDelivery();
    }

    @Given("the user has completed all actions in the SAP S/4HANA system")
    public void theUserHasCompletedAllActions() {
        verifyAllActionsCompleted();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfSAPSystem() {
        logoutFromSAP();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccessful();
    }
}