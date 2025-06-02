import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AlertPage from "../pages/alertPage";

Given("sensitive data is identified", () => {
 AlertPage.identifySensitiveData();
});

When("I simulate an attempt to access sensitive data without encryption", () => {
 AlertPage.simulateAccessAttempt();
});

Then("the access attempt is logged", () => {
 AlertPage.verifyAccessLogged();
});

Then("an alert is triggered", () => {
 AlertPage.verifyAlertTriggered();
});

Given("the alert system is configured", () => {
 AlertPage.configureAlertSystem();
});

When("an unauthorized access attempt occurs", () => {
 AlertPage.unauthorizedAccessAttempt();
});

Then("the alert system captures the unauthorized access attempt", () => {
 AlertPage.verifyAlertCapture();
});

Given("an alert is triggered", () => {
 AlertPage.triggerAlert();
});

When("I check the alert details", () => {
 AlertPage.checkAlertDetails();
});

Then("the alert contains user information and timestamp", () => {
 AlertPage.verifyAlertDetails();
});

Given("an unauthorized access attempt is detected", () => {
 AlertPage.detectUnauthorizedAccess();
});

When("the system processes the access request", () => {
 AlertPage.processAccessRequest();
});

Then("the unauthorized access attempt is blocked", () => {
 AlertPage.verifyAccessBlocked();
});

Given("an access attempt and alert trigger", () => {
 AlertPage.accessAttemptAndAlert();
});

When("I review the system logs", () => {
 AlertPage.reviewSystemLogs();
});

Then("the system logs confirm the access attempt and alert trigger", () => {
 AlertPage.verifyLogsConfirmation();
});

Given("an alert is triggered", () => {
 AlertPage.triggerAlert();
});

When("the alert is communicated", () => {
 AlertPage.communicateAlert();
});

Then("the alert is communicated to the appropriate security personnel", () => {
 AlertPage.verifyAlertCommunication();
});

Given("multiple unauthorized access attempts occur simultaneously", () => {
 AlertPage.multipleAccessAttempts();
});

When("the system processes the access attempts", () => {
 AlertPage.processMultipleAttempts();
});

Then("the system handles multiple unauthorized access attempts effectively", () => {
 AlertPage.verifyMultipleAttemptsHandling();
});

Given("an alert system is configured", () => {
 AlertPage.configureAlertSystem();
});

When("an unauthorized access attempt occurs", () => {
 AlertPage.unauthorizedAccessAttempt();
});

Then("alerts are generated and communicated without delay", () => {
 AlertPage.verifyAlertsWithoutDelay();
});

Given("the alert system is operational", () => {
 AlertPage.operationalAlertSystem();
});

When("a false positive occurs", () => {
 AlertPage.falsePositive();
});

Then("the alert system is resilient to false positives", () => {
 AlertPage.verifyResilienceToFalsePositives();
});

Given("an access attempt resolution", () => {
 AlertPage.accessAttemptResolution();
});

When("the resolution is processed", () => {
 AlertPage.processResolution();
});

Then("the alert system logs the resolution of the access attempt", () => {
 AlertPage.verifyResolutionLogging();
});

Given("unauthorized access attempts occur", () => {
 AlertPage.unauthorizedAccessAttemptsOccur();
});

When("the system processes the attempts", () => {
 AlertPage.processUnauthorizedAttempts();
});

Then("unauthorized access attempts do not impact system performance", () => {
 AlertPage.verifySystemPerformance();
});

Given("a security breach is detected", () => {
 AlertPage.detectSecurityBreach();
});

When("the system processes the breach", () => {
 AlertPage.processSecurityBreach();
});

Then("system notifications are triggered for security breaches", () => {
 AlertPage.verifySecurityNotifications();
});

Given("the alert system is operational", () => {
 AlertPage.operationalAlertSystem();
});

When("an alert is triggered", () => {
 AlertPage.triggerAlert();
});

Then("the alert system is accurate and reliable", () => {
 AlertPage.verifySystemAccuracy();
});

Given("user access logs are available", () => {
 AlertPage.accessLogsAvailable();
});

When("I review the logs", () => {
 AlertPage.reviewAccessLogs();
});

Then("unauthorized access attempts are monitored and logged", () => {
 AlertPage.verifyAccessMonitoring();
});

Given("access attempt results are available", () => {
 AlertPage.accessAttemptResults();
});

When("I document the results", () => {
 AlertPage.documentResults();
});

Then("access attempt results are documented with recommendations for alert system improvement", () => {
 AlertPage.verifyDocumentationAndRecommendations();
});