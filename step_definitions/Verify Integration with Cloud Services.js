import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CloudServicePage from "../pages/cloudServicePage";

Given("the user has valid credentials for the cloud service portal", () => {
 // Assume credentials are set in environment variables
 cy.visit(Cypress.env('CLOUD_SERVICE_URL'));
 CloudServicePage.enterCredentials(Cypress.env('USERNAME'), Cypress.env('PASSWORD'));
});

When("the user logs in to the cloud service portal", () => {
 CloudServicePage.submitLogin();
});

Then("the user is successfully logged into the cloud service portal", () => {
 CloudServicePage.verifyLoginSuccess();
});

Given("the user is logged into the cloud service portal", () => {
 CloudServicePage.verifyLoginSuccess();
});

When("the user navigates to the resource management section", () => {
 CloudServicePage.navigateToResourceManagement();
});

Then("the resource management section is displayed with options for creating and managing resources", () => {
 CloudServicePage.verifyResourceManagementSection();
});

Given("the user is in the resource management section", () => {
 CloudServicePage.verifyResourceManagementSection();
});

When("the user selects \"Create New Resource\" and chooses \"Virtual Machine\" as the resource type", () => {
 CloudServicePage.selectCreateNewResource('Virtual Machine');
});

Then("options for configuring a new virtual machine are displayed", () => {
 CloudServicePage.verifyVmConfigurationOptions();
});

Given("the options for configuring a new virtual machine are displayed", () => {
 CloudServicePage.verifyVmConfigurationOptions();
});

When("the user enters region as \"US-East-1\" and instance count as \"5\"", () => {
 CloudServicePage.configureVmRegionAndInstance('US-East-1', '5');
});

Then("the region and instance count are correctly set for the new virtual machine", () => {
 CloudServicePage.verifyVmRegionAndInstance('US-East-1', '5');
});

Given("the region and instance count are set for the new virtual machine", () => {
 CloudServicePage.verifyVmRegionAndInstance('US-East-1', '5');
});

When("the user configures additional settings such as security groups and network settings", () => {
 CloudServicePage.configureAdditionalVmSettings();
});

Then("additional settings are configured successfully", () => {
 CloudServicePage.verifyAdditionalVmSettings();
});

Given("the virtual machine configuration is complete", () => {
 CloudServicePage.verifyVmConfigurationComplete();
});

When("the user submits the configuration", () => {
 CloudServicePage.submitVmConfiguration();
});

Then("the resources are created successfully and listed under resource management", () => {
 CloudServicePage.verifyResourceCreation();
});

Given("the resources are created", () => {
 CloudServicePage.verifyResourceCreation();
});

When("the user verifies resource allocation and utilization metrics", () => {
 CloudServicePage.verifyResourceMetrics();
});

Then("resource allocation and utilization metrics are displayed accurately", () => {
 CloudServicePage.verifyMetricsAccuracy();
});

When("the user checks for any integration errors or warnings", () => {
 CloudServicePage.checkIntegrationErrors();
});

Then("no integration errors or warnings are present", () => {
 CloudServicePage.verifyNoIntegrationErrors();
});

When("the user accesses the API dashboard", () => {
 CloudServicePage.accessApiDashboard();
});

Then("the API dashboard displays real-time data of API calls and responses", () => {
 CloudServicePage.verifyApiDashboard();
});

When("the user verifies data synchronization between the local system and cloud resources", () => {
 CloudServicePage.verifyDataSynchronization();
});

Then("data synchronization occurs seamlessly without any discrepancies", () => {
 CloudServicePage.verifySynchronizationAccuracy();
});

Given("predefined scaling rules are set", () => {
 CloudServicePage.verifyScalingRulesSet();
});

When("the conditions for scaling up are met", () => {
 CloudServicePage.triggerScalingUp();
});

Then("resources scale up automatically as per the predefined rules", () => {
 CloudServicePage.verifyScalingUp();
});

When("the conditions for scaling down are met", () => {
 CloudServicePage.triggerScalingDown();
});

Then("resources scale down automatically as per the predefined rules", () => {
 CloudServicePage.verifyScalingDown();
});

Given("the user attempts to create a resource", () => {
 CloudServicePage.attemptResourceCreation();
});

When("a failure in resource creation is simulated", () => {
 CloudServicePage.simulateResourceCreationFailure();
});

Then("error handling mechanisms are triggered, and appropriate error messages are displayed", () => {
 CloudServicePage.verifyErrorHandling();
});

When("the user deletes a resource", () => {
 CloudServicePage.deleteResource();
});

Then("the resources are deleted successfully from the cloud service portal", () => {
 CloudServicePage.verifyResourceDeletion();
});

When("the user logs out", () => {
 CloudServicePage.logout();
});

Then("the user is logged out successfully", () => {
 CloudServicePage.verifyLogout();
});