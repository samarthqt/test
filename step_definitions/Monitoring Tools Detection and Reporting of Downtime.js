import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import MonitoringPage from "../pages/monitoringPage";

Given("monitoring tools are configured and operational", () => {
 MonitoringPage.ensureToolsConfigured();
});

Given("downtime detection criteria are defined", () => {
 MonitoringPage.defineDetectionCriteria();
});

When("a network failure downtime event is simulated", () => {
 MonitoringPage.simulateNetworkFailure();
});

When("reviewing monitoring tool logs", () => {
 MonitoringPage.reviewLogs();
});

When("a server crash downtime event is simulated", () => {
 MonitoringPage.simulateServerCrash();
});

When("a power outage downtime event occurs", () => {
 MonitoringPage.simulatePowerOutage();
});

When("an application error downtime event occurs", () => {
 MonitoringPage.simulateApplicationError();
});

When("a database disconnection downtime event is simulated", () => {
 MonitoringPage.simulateDatabaseDisconnection();
});

When("downtime reports are generated", () => {
 MonitoringPage.generateDowntimeReports();
});

When("downtime occurs", () => {
 MonitoringPage.simulateDowntime();
});

When("recovery from a downtime event is simulated", () => {
 MonitoringPage.simulateRecovery();
});

Then("monitoring tools should detect the event and report it promptly", () => {
 MonitoringPage.verifyDetectionAndReporting();
});

Then("logs should accurately reflect downtime detection and reporting for a server crash", () => {
 MonitoringPage.verifyLogAccuracyForServerCrash();
});

Then("administrators should receive timely alerts regarding downtime", () => {
 MonitoringPage.verifyAdminAlerts();
});

Then("response time should be within acceptable limits", () => {
 MonitoringPage.verifyResponseTime();
});

Then("reports should be accurate and reflect actual events", () => {
 MonitoringPage.verifyReportAccuracy();
});

Then("performance metrics should indicate stable operation despite downtime", () => {
 MonitoringPage.verifyPerformanceMetrics();
});

Then("logs should be complete and accurately reflect downtime events", () => {
 MonitoringPage.verifyLogCompleteness();
});

Then("alerts should be sent to system administrators promptly", () => {
 MonitoringPage.verifyAlertNotifications();
});

Then("monitoring tools should reliably detect and report downtime events", () => {
 MonitoringPage.verifyReliability();
});

Then("data integrity should be preserved with no loss", () => {
 MonitoringPage.verifyDataIntegrity();
});

Then("monitoring tools should accurately report system recovery", () => {
 MonitoringPage.verifySystemRecovery();
});