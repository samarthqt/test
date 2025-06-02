package com.cucumber.steps;

import com.page_objects.AdminDashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminDashboardSteps extends AdminDashboardPage {

    @Given("I am logged in as a regular user with email {string} and password {string}")
    public void iAmLoggedInAsARegularUserWithEmailAndPassword(String email, String password) {
        loginAsRegularUser(email, password);
    }

    @When("I attempt to access the admin dashboard using the URL {string}")
    public void iAttemptToAccessTheAdminDashboardUsingTheURL(String url) {
        attemptAccessAdminDashboard(url);
    }

    @Then("I should see an error message indicating insufficient permissions")
    public void iShouldSeeAnErrorMessageIndicatingInsufficientPermissions() {
        verifyInsufficientPermissionsError();
    }

    @Then("I should be redirected to the user dashboard")
    public void iShouldBeRedirectedToTheUserDashboard() {
        verifyRedirectionToUserDashboard();
    }

    @Given("I am logged in as a regular user")
    public void iAmLoggedInAsARegularUser() {
        loginAsRegularUser();
    }

    @When("I attempt to access admin dashboard features via direct URLs")
    public void iAttemptToAccessAdminDashboardFeaturesViaDirectURLs() {
        attemptAccessAdminFeaturesDirectly();
    }

    @Then("I should see appropriate error messages for each feature")
    public void iShouldSeeAppropriateErrorMessagesForEachFeature() {
        verifyErrorMessagesForFeatures();
    }

    @When("I attempt unauthorized access to the admin dashboard")
    public void iAttemptUnauthorizedAccessToTheAdminDashboard() {
        attemptUnauthorizedAccess();
    }

    @Then("the audit logs should reflect denied access attempts with user details")
    public void theAuditLogsShouldReflectDeniedAccessAttemptsWithUserDetails() {
        verifyAuditLogsForDeniedAccess();
    }

    @When("I log out from the user account")
    public void iLogOutFromTheUserAccount() {
        logoutUserAccount();
    }

    @Then("I should be successfully logged out")
    public void iShouldBeSuccessfullyLoggedOut() {
        verifySuccessfulLogout();
    }

    @Given("I am not logged in")
    public void iAmNotLoggedIn() {
        ensureUserIsNotLoggedIn();
    }

    @Then("I should see a login prompt")
    public void iShouldSeeALoginPrompt() {
        verifyLoginPrompt();
    }

    @When("I attempt to log in to the admin dashboard with incorrect credentials")
    public void iAttemptToLogInToTheAdminDashboardWithIncorrectCredentials() {
        attemptLoginWithIncorrectCredentials();
    }

    @Then("I should see an error message indicating incorrect credentials")
    public void iShouldSeeAnErrorMessageIndicatingIncorrectCredentials() {
        verifyIncorrectCredentialsError();
    }

    @When("I repeatedly attempt unauthorized access to the admin dashboard")
    public void iRepeatedlyAttemptUnauthorizedAccessToTheAdminDashboard() {
        attemptRepeatedUnauthorizedAccess();
    }

    @Then("the system should block further attempts after a threshold is reached")
    public void theSystemShouldBlockFurtherAttemptsAfterAThresholdIsReached() {
        verifySystemBlockAfterThreshold();
    }

    @Then("the system performance should remain stable and unaffected")
    public void theSystemPerformanceShouldRemainStableAndUnaffected() {
        verifySystemPerformanceStability();
    }

    @Then("the error messages should provide clear guidance for correction")
    public void theErrorMessagesShouldProvideClearGuidanceForCorrection() {
        verifyClearErrorMessages();
    }

    @Then("notifications should be sent to relevant stakeholders if applicable")
    public void notificationsShouldBeSentToRelevantStakeholdersIfApplicable() {
        verifyNotificationsToStakeholders();
    }

    @Then("security measures should prevent unauthorized access effectively")
    public void securityMeasuresShouldPreventUnauthorizedAccessEffectively() {
        verifyEffectiveSecurityMeasures();
    }

    @Then("a security audit should confirm the effectiveness of existing measures")
    public void aSecurityAuditShouldConfirmTheEffectivenessOfExistingMeasures() {
        verifySecurityAuditEffectiveness();
    }

    @When("I log in with valid admin credentials")
    public void iLogInWithValidAdminCredentials() {
        loginWithValidAdminCredentials();
    }

    @Then("I should be successfully logged in and redirected to the admin dashboard")
    public void iShouldBeSuccessfullyLoggedInAndRedirectedToTheAdminDashboard() {
        verifySuccessfulAdminLogin();
    }
}