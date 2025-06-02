import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import GDPRPage from "../pages/gdprPage";

Given("the user has valid account credentials", () => {
 GDPRPage.ensureValidCredentials();
});

When("the user logs into their account", () => {
 GDPRPage.login();
});

Then("the user is successfully logged in", () => {
 GDPRPage.verifyLoginSuccess();
});

Given("the user is logged in", () => {
 GDPRPage.verifyUserLoggedIn();
});

When("the user navigates to the support interaction section", () => {
 GDPRPage.navigateToSupportSection();
});

Then("the user is directed to the support interaction page", () => {
 GDPRPage.verifySupportPage();
});

Given("the user is on the support interaction page", () => {
 GDPRPage.verifySupportPage();
});

When("the user initiates a support interaction with sample customer data", () => {
 GDPRPage.initiateSupportInteraction();
});

Then("the support interaction is successfully initiated", () => {
 GDPRPage.verifyInteractionInitiated();
});

Given("a support interaction is in progress", () => {
 GDPRPage.verifyInteractionInProgress();
});

When("customer data is being handled", () => {
 GDPRPage.handleCustomerData();
});

Then("the data is handled in compliance with GDPR guidelines", () => {
 GDPRPage.verifyGDPRCompliance();
});

Given("a support interaction is initiated", () => {
 GDPRPage.verifyInteractionInitiated();
});

When("the system logs the interaction", () => {
 GDPRPage.logInteraction();
});

Then("support interactions are logged with data protection measures in place", () => {
 GDPRPage.verifyDataProtectionInLogs();
});

Given("a support interaction is initiated", () => {
 GDPRPage.verifyInteractionInitiated();
});

When("the system sends notifications to users", () => {
 GDPRPage.sendNotifications();
});

Then("users receive notifications regarding data handling and protection in compliance with GDPR", () => {
 GDPRPage.verifyNotificationCompliance();
});

Given("a user wants to manage their data", () => {
 GDPRPage.verifyUserDataManagement();
});

When("the user requests data deletion or access", () => {
 GDPRPage.requestDataDeletionOrAccess();
});

Then("the system allows the request as per GDPR guidelines", () => {
 GDPRPage.verifyDataRequestCompliance();
});

Given("sensitive customer data is being handled", () => {
 GDPRPage.verifySensitiveDataHandling();
});

When("the system processes the data", () => {
 GDPRPage.processData();
});

Then("sensitive data is handled securely and in compliance with GDPR", () => {
 GDPRPage.verifySensitiveDataSecurity();
});

Given("support interaction logs exist", () => {
 GDPRPage.verifyLogsExist();
});

When("a user with different roles attempts to access the logs", () => {
 GDPRPage.attemptAccessLogsWithRoles();
});

Then("access to interaction logs is restricted based on user roles", () => {
 GDPRPage.verifyLogsAccessRestriction();
});

Given("support interactions are ongoing", () => {
 GDPRPage.verifyInteractionsOngoing();
});

When("the system logs data handling activities", () => {
 GDPRPage.logDataHandlingActivities();
});

Then("no errors are logged; data handling is recorded as expected", () => {
 GDPRPage.verifyNoErrorsInLogs();
});

Given("sensitive data has been handled", () => {
 GDPRPage.verifySensitiveDataHandled();
});

When("the system recovers from the interaction", () => {
 GDPRPage.recoverSystem();
});

Then("system recovery time is within acceptable limits", () => {
 GDPRPage.verifyRecoveryTime();
});

Given("data handling is in progress", () => {
 GDPRPage.verifyDataHandlingInProgress();
});

When("the system monitors resource usage", () => {
 GDPRPage.monitorResourceUsage();
});

Then("resource usage remains within acceptable limits", () => {
 GDPRPage.verifyResourceUsageLimits();
});

Given("support interactions are ongoing", () => {
 GDPRPage.verifyInteractionsOngoing();
});

When("the system processes interactions", () => {
 GDPRPage.processInteractions();
});

Then("system performance is consistent during support interactions", () => {
 GDPRPage.verifyPerformanceConsistency();
});

Given("different user roles exist", () => {
 GDPRPage.verifyUserRolesExist();
});

When("users attempt to initiate support interactions", () => {
 GDPRPage.attemptInitiateInteractions();
});

Then("system response is consistent across different user roles", () => {
 GDPRPage.verifyResponseConsistency();
});

Given("customer data is being processed", () => {
 GDPRPage.verifyDataProcessing();
});

When("the system handles data processing", () => {
 GDPRPage.handleDataProcessing();
});

Then("the system processes customer data in compliance with GDPR guidelines", () => {
 GDPRPage.verifyProcessingCompliance();
});