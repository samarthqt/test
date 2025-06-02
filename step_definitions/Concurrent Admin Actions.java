package com.cucumber.steps;

import com.page_objects.AdminActionsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminActionsSteps extends AdminActionsPage {

    @Given("the network supports concurrent connections")
    public void theNetworkSupportsConcurrentConnections() {
        verifyNetworkSupportsConcurrentConnections();
    }

    @When("Admin1 logs in with email {string} and password {string}")
    public void admin1LogsInWithEmailAndPassword(String email, String password) {
        loginAdmin(email, password);
    }

    @Then("Admin1 is successfully logged in and redirected to the dashboard")
    public void admin1IsSuccessfullyLoggedInAndRedirectedToTheDashboard() {
        verifyAdminRedirectedToDashboard();
    }

    @When("Admin2 logs in with email {string} and password {string}")
    public void admin2LogsInWithEmailAndPassword(String email, String password) {
        loginAdmin(email, password);
    }

    @Then("Admin2 is successfully logged in and redirected to the dashboard")
    public void admin2IsSuccessfullyLoggedInAndRedirectedToTheDashboard() {
        verifyAdminRedirectedToDashboard();
    }

    @When("Admin1 navigates to the catalog management section with Product ID {string}")
    public void admin1NavigatesToTheCatalogManagementSectionWithProductID(String productId) {
        navigateToCatalogManagementSection(productId);
    }

    @Then("Admin1 accesses the catalog management section")
    public void admin1AccessesTheCatalogManagementSection() {
        verifyAccessToCatalogManagementSection();
    }

    @When("Admin2 navigates to the catalog management section with URL {string}")
    public void admin2NavigatesToTheCatalogManagementSectionWithURL(String url) {
        navigateToCatalogManagementSection(url);
    }

    @Then("Admin2 accesses the catalog management section")
    public void admin2AccessesTheCatalogManagementSection() {
        verifyAccessToCatalogManagementSection();
    }

    @When("Admin1 attempts to delete a product")
    public void admin1AttemptsToDeleteAProduct() {
        attemptToDeleteProduct();
    }

    @Then("Admin1 sees a confirmation dialog for deletion")
    public void admin1SeesAConfirmationDialogForDeletion() {
        verifyConfirmationDialogForDeletion();
    }

    @When("Admin2 simultaneously attempts to edit the same product")
    public void admin2SimultaneouslyAttemptsToEditTheSameProduct() {
        attemptToEditProduct();
    }

    @Then("Admin2 receives a notification of ongoing deletion and cannot edit")
    public void admin2ReceivesANotificationOfOngoingDeletionAndCannotEdit() {
        verifyNotificationOfOngoingDeletion();
    }

    @When("Admin1 confirms the deletion")
    public void admin1ConfirmsTheDeletion() {
        confirmDeletion();
    }

    @Then("the product is successfully deleted")
    public void theProductIsSuccessfullyDeleted() {
        verifyProductDeletion();
    }

    @When("Admin2 verifies the product")
    public void admin2VerifiesTheProduct() {
        verifyProductAvailability();
    }

    @Then("the product is not found in the catalog")
    public void theProductIsNotFoundInTheCatalog() {
        verifyProductNotFoundInCatalog();
    }

    @When("checking for error messages or alerts during concurrent actions")
    public void checkingForErrorMessagesOrAlertsDuringConcurrentActions() {
        checkForErrorMessagesOrAlerts();
    }

    @Then("no error messages or alerts are displayed")
    public void noErrorMessagesOrAlertsAreDisplayed() {
        verifyNoErrorMessagesOrAlerts();
    }

    @When("verifying audit logs for concurrent actions")
    public void verifyingAuditLogsForConcurrentActions() {
        verifyAuditLogs();
    }

    @Then("audit logs show both admin actions with timestamps")
    public void auditLogsShowBothAdminActionsWithTimestamps() {
        verifyAuditLogsWithTimestamps();
    }

    @When("reviewing system performance during concurrent actions")
    public void reviewingSystemPerformanceDuringConcurrentActions() {
        reviewSystemPerformance();
    }

    @Then("system performance remains stable and unaffected")
    public void systemPerformanceRemainsStableAndUnaffected() {
        verifySystemPerformanceStability();
    }

    @When("ensuring data consistency during concurrent actions")
    public void ensuringDataConsistencyDuringConcurrentActions() {
        ensureDataConsistency();
    }

    @Then("data remains consistent and accurate")
    public void dataRemainsConsistentAndAccurate() {
        verifyDataConsistency();
    }

    @When("checking for automatic notifications regarding concurrent actions")
    public void checkingForAutomaticNotificationsRegardingConcurrentActions() {
        checkForAutomaticNotifications();
    }

    @Then("notifications are sent to relevant stakeholders if applicable")
    public void notificationsAreSentToRelevantStakeholdersIfApplicable() {
        verifyNotificationsSent();
    }

    @When("verifying system scalability under concurrent admin actions")
    public void verifyingSystemScalabilityUnderConcurrentAdminActions() {
        verifySystemScalability();
    }

    @Then("the system handles concurrent actions smoothly without degradation")
    public void theSystemHandlesConcurrentActionsSmoothlyWithoutDegradation() {
        verifySystemHandlesConcurrentActions();
    }

    @When("attempting concurrent actions on different products")
    public void attemptingConcurrentActionsOnDifferentProducts() {
        attemptConcurrentActionsOnDifferentProducts();
    }

    @Then("both actions succeed without interference")
    public void bothActionsSucceedWithoutInterference() {
        verifyActionsSucceedWithoutInterference();
    }
}