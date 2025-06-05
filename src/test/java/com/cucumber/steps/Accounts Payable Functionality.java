import java.util.*;
import com.page_objects.AccountsPayablePage;

public class AccountsPayableSteps extends AccountsPayablePage {

    public void givenIAmAFinanceUser() {
        loginAsFinanceUser();
    }

    public void whenILoginToTheSystem() {
        performLogin();
    }

    public void thenIShouldBeSuccessfullyLoggedInAndDirectedToTheSystemDashboard() {
        verifyDashboardAccess();
    }

    public void givenIAmOnTheSystemDashboard() {
        verifyDashboardAccess();
    }

    public void whenINavigateToTheAccountsPayableModule() {
        navigateToAccountsPayable();
    }

    public void thenIShouldBeAbleToNavigateToTheModuleWithoutAnyErrorsOrIssues() {
        verifyAccountsPayableAccess();
    }

    public void givenIAmOnTheAccountsPayableModule() {
        verifyAccountsPayableAccess();
    }

    public void thenIShouldBeAbleToSeeAndAccessAllNecessaryOptionsAndFeaturesRelatedToAccountsPayable() {
        verifyAccountsPayableFeatures();
    }

    public void whenICreateANewInvoiceWithAllTheRequiredInformation() {
        createNewInvoice();
    }

    public void thenTheInvoiceShouldBeSuccessfullySavedInTheSystem() {
        verifyInvoiceSaved();
    }

    public void whenICreateANewInvoice() {
        createNewInvoice();
    }

    public void thenTheSystemShouldDisplayTheNewlyCreatedInvoiceInTheInvoiceList() {
        verifyInvoiceInList();
    }

    public void whenIEditAnExistingInvoiceAndUpdateTheNecessaryInformation() {
        editInvoice();
    }

    public void thenTheChangesShouldBeSuccessfullySavedInTheSystem() {
        verifyInvoiceUpdated();
    }

    public void whenIEditAnExistingInvoice() {
        editInvoice();
    }

    public void thenTheSystemShouldDisplayTheUpdatedInformationForTheEditedInvoice() {
        verifyUpdatedInvoiceInList();
    }

    public void whenIDeleteAnExistingInvoice() {
        deleteInvoice();
    }

    public void thenTheInvoiceShouldBeSuccessfullyDeletedFromTheSystem() {
        verifyInvoiceDeleted();
    }

    public void thenTheSystemShouldNotDisplayTheDeletedInvoiceInTheInvoiceList() {
        verifyInvoiceNotInList();
    }

    public void whenIGenerateAPaymentForAnInvoice() {
        generatePayment();
    }

    public void thenThePaymentProcessShouldBeCompletedSuccessfully() {
        verifyPaymentCompleted();
    }

    public void thenTheSystemShouldRecordAndUpdateThePaymentInformationForTheInvoice() {
        verifyPaymentRecorded();
    }

    public void whenIViewAndDownloadReportsRelatedToAccountsPayable() {
        viewAndDownloadReports();
    }

    public void thenIShouldBeAbleToViewAndDownloadTheReportsWithoutAnyIssues() {
        verifyReportsDownloaded();
    }

    public void givenIHaveDownloadedReportsRelatedToAccountsPayable() {
        verifyReportsDownloaded();
    }

    public void whenIReviewTheDownloadedReports() {
        reviewReports();
    }

    public void thenTheReportsShouldContainAccurateAndCompleteInformationRelatedToAccountsPayable() {
        verifyReportAccuracy();
    }

    public void givenIAmLoggedInToTheSystem() {
        verifyDashboardAccess();
    }

    public void whenILogout() {
        performLogout();
    }

    public void thenIShouldBeSuccessfullyLoggedOutFromTheSystemAndDirectedToTheLoginPage() {
        verifyLogout();
    }

    public void givenIAmNotAuthorizedToAccessTheAccountsPayableFunctionality() {
        verifyUnauthorizedAccess();
    }

    public void whenIAttemptToAccessTheFunctionality() {
        attemptUnauthorizedAccess();
    }

    public void thenTheSystemShouldRestrictAccessAndDisplayAnAppropriateErrorMessageOrNotification() {
        verifyAccessRestriction();
    }
}