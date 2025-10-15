package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.OutputManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class OutputManagementSteps extends OutputManagementPage {

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        verifyUserCredentials();
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        loginToSAPSystem();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIntoTheSystem() {
        verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the output management module")
    public void theUserNavigatesToOutputManagementModule() {
        navigateToOutputManagementModule();
    }

    @Then("the output management module is displayed")
    public void theOutputManagementModuleIsDisplayed() {
        verifyOutputManagementModuleDisplayed();
    }

    @Given("the user is in the output management module")
    public void theUserIsInOutputManagementModule() {
        verifyUserInOutputManagementModule();
    }

    @When("the user searches for the form using its ID {string}")
    public void theUserSearchesForFormUsingID(String formID) {
        searchFormByID(formID);
    }

    @Then("the form {string} is retrieved successfully")
    public void theFormIsRetrievedSuccessfully(String formID) {
        verifyFormRetrieved(formID);
    }

    @When("the user opens the form {string} and reviews its content")
    public void theUserOpensFormAndReviewsContent(String formID) {
        openFormAndReviewContent(formID);
    }

    @Then("the form content is displayed accurately")
    public void theFormContentIsDisplayedAccurately() {
        verifyFormContentDisplayedAccurately();
    }

    @When("the user selects the print option and chooses the printer {string}")
    public void theUserSelectsPrintOptionAndChoosesPrinter(String printer) {
        selectPrintOptionAndPrinter(printer);
    }

    @Then("the print options are displayed, and the printer {string} is selected")
    public void thePrintOptionsAreDisplayedAndPrinterIsSelected(String printer) {
        verifyPrintOptionsAndPrinterSelected(printer);
    }

    @When("the user prints the form {string}")
    public void theUserPrintsTheForm(String formID) {
        printForm(formID);
    }

    @Then("the form {string} is successfully printed")
    public void theFormIsSuccessfullyPrinted(String formID) {
        verifyFormPrintedSuccessfully(formID);
    }

    @When("the user selects the export option and chooses the format {string}")
    public void theUserSelectsExportOptionAndChoosesFormat(String exportFormat) {
        selectExportOptionAndFormat(exportFormat);
    }

    @Then("the export options are displayed, and the format {string} is selected")
    public void theExportOptionsAreDisplayedAndFormatIsSelected(String exportFormat) {
        verifyExportOptionsAndFormatSelected(exportFormat);
    }

    @When("the user exports the form {string}")
    public void theUserExportsTheForm(String formID) {
        exportForm(formID);
    }

    @Then("the form {string} is successfully exported as a {string}")
    public void theFormIsSuccessfullyExportedAsFormat(String formID, String exportFormat) {
        verifyFormExportedSuccessfully(formID, exportFormat);
    }
}