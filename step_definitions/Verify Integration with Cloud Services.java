package com.cucumber.steps;

import com.page_objects.CloudServicePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CloudServiceSteps extends CloudServicePage {

    @Given("the user has valid credentials for the cloud service portal")
    public void theUserHasValidCredentialsForTheCloudServicePortal() {
        navigateToLoginPage();
        enterCredentials();
    }

    @When("the user logs in to the cloud service portal")
    public void theUserLogsInToTheCloudServicePortal() {
        clickLoginButton();
    }

    @Then("the user is successfully logged into the cloud service portal")
    public void theUserIsSuccessfullyLoggedIntoTheCloudServicePortal() {
        verifySuccessfulLogin();
    }

    @Given("the user is logged into the cloud service portal")
    public void theUserIsLoggedIntoTheCloudServicePortal() {
        verifySuccessfulLogin();
    }

    @When("the user navigates to the resource management section")
    public void theUserNavigatesToTheResourceManagementSection() {
        navigateToResourceManagement();
    }

    @Then("the resource management section is displayed with options for creating and managing resources")
    public void theResourceManagementSectionIsDisplayedWithOptionsForCreatingAndManagingResources() {
        verifyResourceManagementSection();
    }

    @Given("the user is in the resource management section")
    public void theUserIsInTheResourceManagementSection() {
        verifyResourceManagementSection();
    }

    @When("the user selects \"Create New Resource\" and chooses \"Virtual Machine\" as the resource type")
    public void theUserSelectsCreateNewResourceAndChoosesVirtualMachineAsTheResourceType() {
        selectCreateNewResource();
        chooseResourceType("Virtual Machine");
    }

    @Then("options for configuring a new virtual machine are displayed")
    public void optionsForConfiguringANewVirtualMachineAreDisplayed() {
        verifyVirtualMachineOptions();
    }

    @Given("the options for configuring a new virtual machine are displayed")
    public void theOptionsForConfiguringANewVirtualMachineAreDisplayed() {
        verifyVirtualMachineOptions();
    }

    @When("the user enters region as \"US-East-1\" and instance count as \"5\"")
    public void theUserEntersRegionAsUSEast1AndInstanceCountAs5() {
        enterRegion("US-East-1");
        enterInstanceCount("5");
    }

    @Then("the region and instance count are correctly set for the new virtual machine")
    public void theRegionAndInstanceCountAreCorrectlySetForTheNewVirtualMachine() {
        verifyRegionAndInstanceCount("US-East-1", "5");
    }

    @Given("the region and instance count are set for the new virtual machine")
    public void theRegionAndInstanceCountAreSetForTheNewVirtualMachine() {
        verifyRegionAndInstanceCount("US-East-1", "5");
    }

    @When("the user configures additional settings such as security groups and network settings")
    public void theUserConfiguresAdditionalSettingsSuchAsSecurityGroupsAndNetworkSettings() {
        configureAdditionalSettings();
    }

    @Then("additional settings are configured successfully")
    public void additionalSettingsAreConfiguredSuccessfully() {
        verifyAdditionalSettings();
    }

    @Given("the virtual machine configuration is complete")
    public void theVirtualMachineConfigurationIsComplete() {
        verifyConfigurationComplete();
    }

    @When("the user submits the configuration")
    public void theUserSubmitsTheConfiguration() {
        submitConfiguration();
    }

    @Then("the resources are created successfully and listed under resource management")
    public void theResourcesAreCreatedSuccessfullyAndListedUnderResourceManagement() {
        verifyResourcesCreated();
    }

    @Given("the resources are created")
    public void theResourcesAreCreated() {
        verifyResourcesCreated();
    }

    @When("the user verifies resource allocation and utilization metrics")
    public void theUserVerifiesResourceAllocationAndUtilizationMetrics() {
        verifyResourceMetrics();
    }

    @Then("resource allocation and utilization metrics are displayed accurately")
    public void resourceAllocationAndUtilizationMetricsAreDisplayedAccurately() {
        verifyMetricsAccuracy();
    }

    @When("the user checks for any integration errors or warnings")
    public void theUserChecksForAnyIntegrationErrorsOrWarnings() {
        checkIntegrationErrors();
    }

    @Then("no integration errors or warnings are present")
    public void noIntegrationErrorsOrWarningsArePresent() {
        verifyNoIntegrationErrors();
    }

    @When("the user accesses the API dashboard")
    public void theUserAccessesTheAPIDashboard() {
        accessAPIDashboard();
    }

    @Then("the API dashboard displays real-time data of API calls and responses")
    public void theAPIDashboardDisplaysRealTimeDataOfAPICallsAndResponses() {
        verifyAPIDashboardData();
    }

    @When("the user verifies data synchronization between the local system and cloud resources")
    public void theUserVerifiesDataSynchronizationBetweenTheLocalSystemAndCloudResources() {
        verifyDataSynchronization();
    }

    @Then("data synchronization occurs seamlessly without any discrepancies")
    public void dataSynchronizationOccursSeamlesslyWithoutAnyDiscrepancies() {
        verifySynchronizationSeamlessness();
    }

    @Given("predefined scaling rules are set")
    public void predefinedScalingRulesAreSet() {
        verifyScalingRulesSet();
    }

    @When("the conditions for scaling up are met")
    public void theConditionsForScalingUpAreMet() {
        verifyScalingUpConditions();
    }

    @Then("resources scale up automatically as per the predefined rules")
    public void resourcesScaleUpAutomaticallyAsPerThePredefinedRules() {
        verifyAutomaticScalingUp();
    }

    @When("the conditions for scaling down are met")
    public void theConditionsForScalingDownAreMet() {
        verifyScalingDownConditions();
    }

    @Then("resources scale down automatically as per the predefined rules")
    public void resourcesScaleDownAutomaticallyAsPerThePredefinedRules() {
        verifyAutomaticScalingDown();
    }

    @Given("the user attempts to create a resource")
    public void theUserAttemptsToCreateAResource() {
        attemptResourceCreation();
    }

    @When("a failure in resource creation is simulated")
    public void aFailureInResourceCreationIsSimulated() {
        simulateResourceCreationFailure();
    }

    @Then("error handling mechanisms are triggered, and appropriate error messages are displayed")
    public void errorHandlingMechanismsAreTriggeredAndAppropriateErrorMessagesAreDisplayed() {
        verifyErrorHandling();
    }

    @When("the user deletes a resource")
    public void theUserDeletesAResource() {
        deleteResource();
    }

    @Then("the resources are deleted successfully from the cloud service portal")
    public void theResourcesAreDeletedSuccessfullyFromTheCloudServicePortal() {
        verifyResourceDeletion();
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        logout();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogout();
    }
}