import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RedundancyPage from "../pages/redundancyPage";

Given("redundancy type is Failover High", () => {
 RedundancyPage.setRedundancyType('Failover High');
});

Given("access to redundancy monitoring tools is available", () => {
 RedundancyPage.checkMonitoringToolsAccess();
});

Given("the primary server is Server A", () => {
 RedundancyPage.setPrimaryServer('Server A');
});

Given("the backup server is Server B", () => {
 RedundancyPage.setBackupServer('Server B');
});

Given("the failover policy is enabled", () => {
 RedundancyPage.enableFailoverPolicy();
});

When("normal operations are simulated on the primary server", () => {
 RedundancyPage.simulateNormalOperations();
});

When("redundancy mechanisms are monitored during normal operations", () => {
 RedundancyPage.monitorRedundancyMechanisms();
});

When("failure is simulated on the primary server", () => {
 RedundancyPage.simulatePrimaryServerFailure();
});

When("system stability is verified post failover", () => {
 RedundancyPage.verifySystemStability();
});

When("system logs are checked for failover events", () => {
 RedundancyPage.checkSystemLogs();
});

When("system response is tested to simultaneous server failures", () => {
 RedundancyPage.testSimultaneousFailures();
});

When("failure is simulated in redundancy mechanisms", () => {
 RedundancyPage.simulateRedundancyFailure();
});

When("notification alerts are verified for redundancy issues", () => {
 RedundancyPage.verifyNotificationAlerts();
});

When("manual intervention processes are tested for redundancy management", () => {
 RedundancyPage.testManualIntervention();
});

When("system performance metrics are checked post redundancy resolution", () => {
 RedundancyPage.checkPerformanceMetrics();
});

When("network latency is simulated and system response is observed", () => {
 RedundancyPage.simulateNetworkLatency();
});

When("rollback mechanisms are verified for failed failover events", () => {
 RedundancyPage.verifyRollbackMechanisms();
});

When("system response is tested to unexpected redundancy spikes", () => {
 RedundancyPage.testRedundancySpikes();
});

When("logging out from the redundancy monitoring tools", () => {
 RedundancyPage.logout();
});

Then("the primary server operates normally, maintaining high availability", () => {
 RedundancyPage.verifyPrimaryServerOperation();
});

Then("redundancy mechanisms are active, ensuring high availability", () => {
 RedundancyPage.verifyRedundancyMechanismsActive();
});

Then("failover mechanisms activate, switching operations to the backup server", () => {
 RedundancyPage.verifyFailoverActivation();
});

Then("the system stabilizes with the backup server, maintaining high availability", () => {
 RedundancyPage.verifySystemStabilization();
});

Then("system logs display accurate timestamps and details of failover events", () => {
 RedundancyPage.verifySystemLogs();
});

Then("the system handles simultaneous failures effectively, maintaining high availability", () => {
 RedundancyPage.verifySimultaneousFailureHandling();
});

Then("the failure is logged, and fallback mechanisms are activated", () => {
 RedundancyPage.verifyFailureLogging();
});

Then("notification alerts are sent to administrators, detailing redundancy issues", () => {
 RedundancyPage.verifyNotificationSent();
});

Then("manual intervention processes are executed successfully, resolving redundancy issues", () => {
 RedundancyPage.verifyManualInterventionSuccess();
});

Then("system performance metrics return to normal, indicating successful resolution", () => {
 RedundancyPage.verifyPerformanceMetricsNormal();
});

Then("system response is logged, showing impact of network latency on redundancy", () => {
 RedundancyPage.verifyNetworkLatencyImpact();
});

Then("rollback mechanisms are activated, restoring the system to pre-failure state", () => {
 RedundancyPage.verifyRollbackActivation();
});

Then("the system handles unexpected spikes effectively, maintaining high availability", () => {
 RedundancyPage.verifySpikeHandling();
});

Then("the user is logged out successfully", () => {
 RedundancyPage.verifyLogoutSuccess();
});