package com.cucumber.steps;

import com.pageobjects.ZGC1OutputPage;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZGC1OutputSteps {

    private ZGC1OutputPage zgc1OutputPage = new ZGC1OutputPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        zgc1OutputPage.enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        zgc1OutputPage.loginToSAP();
    }

    @Then("the user is successfully logged in and navigates to the SAP main menu")
    public void theUserIsLoggedIn() {
        zgc1OutputPage.verifySAPMainMenu();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoSAP() {
        zgc1OutputPage.verifySAPLogin();
    }

    @When("the user navigates to the Invoice Correction Request creation screen")
    public void theUserNavigatesToInvoiceCorrectionScreen() {
        zgc1OutputPage.navigateToInvoiceCorrectionScreen();
    }

    @Then("the Invoice Correction Request creation screen is displayed")
    public void theInvoiceCorrectionScreenIsDisplayed() {
        zgc1OutputPage.verifyInvoiceCorrectionScreen();
    }

    @Given("the user is on the Invoice Correction Request creation screen")
    public void theUserIsOnInvoiceCorrectionScreen() {
        zgc1OutputPage.verifyInvoiceCorrectionScreen();
    }

    @When("the user selects the Invoice Correction Request type as ZRK")
    public void theUserSelectsInvoiceTypeZRK() {
        zgc1OutputPage.selectInvoiceType("ZRK");
    }

    @Then("the Invoice Correction Request type ZRK is selected")
    public void theInvoiceTypeZRKIsSelected() {
        zgc1OutputPage.verifyInvoiceType("ZRK");
    }

    @Given("the user has selected the Invoice Correction Request type as ZRK")
    public void theUserHasSelectedInvoiceTypeZRK() {
        zgc1OutputPage.verifyInvoiceType("ZRK");
    }

    @When("the user enters customer details \"{string}\" and billing details for a credit adjustment of \"{string}\"")
    public void theUserEntersCustomerAndBillingDetails(String customerDetails, String creditAdjustment) {
        zgc1OutputPage.enterCustomerAndBillingDetails(customerDetails, creditAdjustment);
    }

    @Then("the customer and billing details are entered successfully")
    public void theCustomerAndBillingDetailsAreEntered() {
        zgc1OutputPage.verifyCustomerAndBillingDetails();
    }

    @Given("the user has entered customer and billing details")
    public void theUserHasEnteredCustomerAndBillingDetails() {
        zgc1OutputPage.verifyCustomerAndBillingDetails();
    }

    @When("the user saves the Invoice Correction Request")
    public void theUserSavesInvoiceCorrectionRequest() {
        zgc1OutputPage.saveInvoiceCorrectionRequest();
    }

    @Then("the Invoice Correction Request is saved successfully, and a unique document number is generated")
    public void theInvoiceCorrectionRequestIsSaved() {
        zgc1OutputPage.verifyInvoiceRequestSaved();
    }

    @Given("the Invoice Correction Request is saved successfully")
    public void theInvoiceRequestIsSavedSuccessfully() {
        zgc1OutputPage.verifyInvoiceRequestSaved();
    }

    @When("the user triggers the output generation process for the saved Invoice Correction Request")
    public void theUserTriggersOutputGeneration() {
        zgc1OutputPage.triggerOutputGeneration();
    }

    @Then("the system initiates the output generation process")
    public void theSystemInitiatesOutputGeneration() {
        zgc1OutputPage.verifyOutputGenerationInitiated();
    }

    @Given("the output generation process is initiated")
    public void theOutputGenerationProcessIsInitiated() {
        zgc1OutputPage.verifyOutputGenerationInitiated();
    }

    @When("the user verifies the template used for generating the ZGC1 form")
    public void theUserVerifiesTemplateUsed() {
        zgc1OutputPage.verifyTemplateUsed("ZPDT");
    }

    @Then("the ZGC1 form is generated using the ZPDT template")
    public void theZGC1FormIsGenerated() {
        zgc1OutputPage.verifyZGC1FormGenerated();
    }

    @Given("the ZGC1 form is generated")
    public void theZGC1FormIsGeneratedSuccessfully() {
        zgc1OutputPage.verifyZGC1FormGenerated();
    }

    @When("the user ensures the Print Program SD_INVOICE_PRINT01 is invoked during the generation process")
    public void theUserEnsuresPrintProgramInvoked() {
        zgc1OutputPage.verifyPrintProgramInvoked("SD_INVOICE_PRINT01");
    }

    @Then("the Print Program SD_INVOICE_PRINT01 is invoked successfully")
    public void thePrintProgramIsInvoked() {
        zgc1OutputPage.verifyPrintProgramInvoked("SD_INVOICE_PRINT01");
    }

    @Given("the Print Program SD_INVOICE_PRINT01 is invoked successfully")
    public void thePrintProgramIsInvokedSuccessfully() {
        zgc1OutputPage.verifyPrintProgramInvoked("SD_INVOICE_PRINT01");
    }

    @When("the user attempts to print the ZGC1 output")
    public void theUserAttemptsToPrintZGC1Output() {
        zgc1OutputPage.printZGC1Output();
    }

    @Then("the ZGC1 output is printed successfully")
    public void theZGC1OutputIsPrinted() {
        zgc1OutputPage.verifyZGC1OutputPrinted();
    }

    @Given("the ZGC1 output is printed successfully")
    public void theZGC1OutputIsPrintedSuccessfully() {
        zgc1OutputPage.verifyZGC1OutputPrinted();
    }

    @When("the user verifies the printed output for accuracy and completeness")
    public void theUserVerifiesPrintedOutput() {
        zgc1OutputPage.verifyPrintedOutputAccuracy();
    }

    @Then("the printed ZGC1 output matches the expected format and contains all necessary details")
    public void thePrintedZGC1OutputMatchesExpected() {
        zgc1OutputPage.verifyPrintedOutputFormat();
    }

    @Given("the printed ZGC1 output matches the expected format")
    public void thePrintedZGC1OutputMatchesExpectedFormat() {
        zgc1OutputPage.verifyPrintedOutputFormat();
    }

    @When("the user validates the output for customer delivery")
    public void theUserValidatesOutputForDelivery() {
        zgc1OutputPage.validateOutputForDelivery();
    }

    @Then("the output is confirmed to be ready for customer delivery")
    public void theOutputIsReadyForDelivery() {
        zgc1OutputPage.verifyOutputReadyForDelivery();
    }

    @Given("the user has completed all tasks")
    public void theUserHasCompletedAllTasks() {
        zgc1OutputPage.verifyAllTasksCompleted();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfSAP() {
        zgc1OutputPage.logoutOfSAP();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        zgc1OutputPage.verifyLogoutSuccessful();
    }
}
