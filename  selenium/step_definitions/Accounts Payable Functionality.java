package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPayableSteps extends AccountsPayablePage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am a Finance user")
    public void iAmAFinanceUser() {
        loginAsFinanceUser();
    }

    @When("I login to the system")
    public void iLoginToTheSystem() {
        performLogin();
    }

    @Then("I should be successfully logged in and directed to the system dashboard")
    public void iShouldBeSuccessfullyLoggedInAndDirectedToTheSystemDashboard() {
        verifyDashboardAccess();
    }

    @Given("I am on the system dashboard")
    public void iAmOnTheSystemDashboard() {
        verifyDashboardAccess();
    }

    @When("I navigate to the Accounts Payable module")
    public void iNavigateToTheAccountsPayableModule() {
        navigateToAccountsPayableModule();
    }

    @Then("I should be able to navigate to the module without any errors or issues")
    public void iShouldBeAbleToNavigateToTheModuleWithoutAnyErrorsOrIssues() {
        verifyModuleNavigation();
    }

    @Given("I am on the Accounts Payable module")
    public void iAmOnTheAccountsPayableModule() {
        verifyModuleNavigation();
    }

    @Then("I should be able to see and access all necessary options and features related to Accounts Payable, such as creating invoices, managing payments, and generating reports")
    public void iShouldBeAbleToSeeAndAccessAllNecessaryOptionsAndFeaturesRelatedToAccountsPayable() {
        verifyOptionsAndFeatures();
    }

    @When("I create a new invoice with all the required information")
    public void iCreateANewInvoiceWithAllTheRequiredInformation() {
        createNewInvoice();
    }

    @Then("the invoice should be successfully saved in the system")
    public void theInvoiceShouldBeSuccessfullySavedInTheSystem() {
        verifyInvoiceSaved();
    }

    @When("I create a new invoice")
    public void iCreateANewInvoice() {
        createNewInvoice();
    }

    @Then("the system should display the newly created invoice in the invoice list with all the relevant details, such as invoice number, vendor information, and amount")
    public void theSystemShouldDisplayTheNewlyCreatedInvoiceInTheInvoiceList() {
        verifyInvoiceDisplayed();
    }

    @When("I edit an existing invoice and update the necessary information")
    public void iEditAnExistingInvoiceAndUpdateTheNecessaryInformation() {
        editInvoice();
    }

    @Then("the changes should be successfully saved in the system")
    public void theChangesShouldBeSuccessfullySavedInTheSystem() {
        verifyChangesSaved();
    }

    @When("I edit an existing invoice")
    public void iEditAnExistingInvoice() {
        editInvoice();
    }

    @Then("the system should display the updated information for the edited invoice, such as the modified invoice amount or due date")
    public void theSystemShouldDisplayTheUpdatedInformationForTheEditedInvoice() {
        verifyUpdatedInvoice();
    }

    @When("I delete an existing invoice")
    public void iDeleteAnExistingInvoice() {
        deleteInvoice();
    }

    @Then("the invoice should be successfully deleted from the system")
    public void theInvoiceShouldBeSuccessfullyDeletedFromTheSystem() {
        verifyInvoiceDeleted();
    }

    @Then("the system should not display the deleted invoice in the invoice list, and it should be permanently removed from the system")
    public void theSystemShouldNotDisplayTheDeletedInvoiceInTheInvoiceList() {
        verifyInvoiceNotDisplayed();
    }

    @When("I generate a payment for an invoice")
    public void iGenerateAPaymentForAnInvoice() {
        generatePayment();
    }

    @Then("the payment process should be completed successfully")
    public void thePaymentProcessShouldBeCompletedSuccessfully() {
        verifyPaymentCompleted();
    }

    @Then("the system should record and update the payment information for the invoice, such as payment date and amount")
    public void theSystemShouldRecordAndUpdateThePaymentInformationForTheInvoice() {
        verifyPaymentRecorded();
    }

    @When("I view and download reports related to Accounts Payable")
    public void iViewAndDownloadReportsRelatedToAccountsPayable() {
        viewAndDownloadReports();
    }

    @Then("I should be able to view and download the reports without any issues")
    public void iShouldBeAbleToViewAndDownloadTheReportsWithoutAnyIssues() {
        verifyReportsDownloaded();
    }

    @Given("I have downloaded reports related to Accounts Payable")
    public void iHaveDownloadedReportsRelatedToAccountsPayable() {
        verifyReportsDownloaded();
    }

    @When("I review the downloaded reports")
    public void iReviewTheDownloadedReports() {
        reviewReports();
    }

    @Then("the reports should contain accurate and complete information related to Accounts Payable, such as correct invoice details or payment records")
    public void theReportsShouldContainAccurateAndCompleteInformation() {
        verifyReportAccuracy();
    }

    @Given("I am logged in to the system")
    public void iAmLoggedInToTheSystem() {
        verifyDashboardAccess();
    }

    @When("I logout")
    public void iLogout() {
        performLogout();
    }

    @Then("I should be successfully logged out from the system and directed to the login page")
    public void iShouldBeSuccessfullyLoggedOutFromTheSystem() {
        verifyLogout();
    }

    @Given("I am not authorized to access the Accounts Payable functionality")
    public void iAmNotAuthorizedToAccessTheAccountsPayableFunctionality() {
        verifyAuthorization();
    }

    @When("I attempt to access the functionality")
    public void iAttemptToAccessTheFunctionality() {
        attemptAccess();
    }

    @Then("the system should restrict access and display an appropriate error message or notification")
    public void theSystemShouldRestrictAccessAndDisplayAnErrorMessage() {
        verifyAccessRestriction();
    }
}