package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.VOFMConfigurationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class VOFMConfigurationSteps extends VOFMConfigurationPage {

    @Given("the user has access to the SAP system")
    public void theUserHasAccessToTheSAPSystem() {
        loginToSAPSystem();
    }

    @When("the user navigates to the VOFM configuration screen")
    public void theUserNavigatesToTheVOFMConfigurationScreen() {
        navigateToVOFMConfigurationScreen();
    }

    @Then("the VOFM configuration screen is displayed")
    public void theVOFMConfigurationScreenIsDisplayed() {
        verifyVOFMConfigurationScreenDisplayed();
    }

    @Given("the user is on the VOFM configuration screen")
    public void theUserIsOnTheVOFMConfigurationScreen() {
        verifyVOFMConfigurationScreenDisplayed();
    }

    @When("the user selects the option to assign a copy-control routine to Sales Order to Billing Document mappings")
    public void theUserSelectsTheOptionToAssignACopyControlRoutineToSalesOrderToBillingDocumentMappings() {
        selectCopyControlRoutineOption();
    }

    @Then("the system displays the mapping configuration screen")
    public void theSystemDisplaysTheMappingConfigurationScreen() {
        verifyMappingConfigurationScreenDisplayed();
    }

    @Given("the user is on the mapping configuration screen")
    public void theUserIsOnTheMappingConfigurationScreen() {
        verifyMappingConfigurationScreenDisplayed();
    }

    @When("the user chooses the mapping for Sales Order item category {string} to Billing Document item category {string}")
    public void theUserChoosesTheMappingForSalesOrderItemCategoryToBillingDocumentItemCategory(String salesOrderCategory, String billingDocumentCategory) {
        chooseMapping(salesOrderCategory, billingDocumentCategory);
    }

    @Then("the selected mapping is displayed for editing")
    public void theSelectedMappingIsDisplayedForEditing() {
        verifyMappingDisplayedForEditing();
    }

    @Given("the user is editing the mapping for Sales Order item category ZOR to Billing Document item category ZF2C")
    public void theUserIsEditingTheMappingForSalesOrderItemCategoryZORToBillingDocumentItemCategoryZF2C() {
        verifyMappingDisplayedForEditing();
    }

    @When("the user assigns RV60C901 as the copy-control routine for the selected mapping")
    public void theUserAssignsRV60C901AsTheCopyControlRoutineForTheSelectedMapping() {
        assignCopyControlRoutine("RV60C901");
    }

    @Then("RV60C901 is assigned to the mapping without errors")
    public void rv60c901IsAssignedToTheMappingWithoutErrors() {
        verifyCopyControlRoutineAssigned("RV60C901");
    }

    @Given("the user has assigned RV60C901 to the mapping")
    public void theUserHasAssignedRV60C901ToTheMapping() {
        verifyCopyControlRoutineAssigned("RV60C901");
    }

    @When("the user saves the configuration changes")
    public void theUserSavesTheConfigurationChanges() {
        saveConfigurationChanges();
    }

    @Then("the changes are successfully saved in the system")
    public void theChangesAreSuccessfullySavedInTheSystem() {
        verifyConfigurationChangesSaved();
    }

    @Given("the configuration changes are saved")
    public void theConfigurationChangesAreSaved() {
        verifyConfigurationChangesSaved();
    }

    @When("the user transports the configuration to the test environment")
    public void theUserTransportsTheConfigurationToTheTestEnvironment() {
        transportConfigurationToTestEnvironment();
    }

    @Then("the transport request for the updated mapping is successfully created and moved to the test environment")
    public void theTransportRequestForTheUpdatedMappingIsSuccessfullyCreatedAndMovedToTheTestEnvironment() {
        verifyTransportRequestSuccessful();
    }

    @Given("the configuration is transported to the test environment")
    public void theConfigurationIsTransportedToTheTestEnvironment() {
        verifyTransportRequestSuccessful();
    }

    @When("the user validates the presence of the updated mapping")
    public void theUserValidatesThePresenceOfTheUpdatedMapping() {
        validateUpdatedMappingInTestEnvironment();
    }

    @Then("the mapping with RV60C901 is available and functional in the test environment")
    public void theMappingWithRV60C901IsAvailableAndFunctionalInTheTestEnvironment() {
        verifyMappingFunctionalInTestEnvironment("RV60C901");
    }

    @Given("the updated mapping is available in the test environment")
    public void theUpdatedMappingIsAvailableInTheTestEnvironment() {
        verifyMappingFunctionalInTestEnvironment("RV60C901");
    }

    @When("the user executes a test Sales Order to Billing Document copy process using the updated mapping")
    public void theUserExecutesATestSalesOrderToBillingDocumentCopyProcessUsingTheUpdatedMapping() {
        executeTestCopyProcess();
    }

    @Then("the copy process executes without errors")
    public void theCopyProcessExecutesWithoutErrors() {
        verifyCopyProcessSuccessful();
    }

    @Given("the updated mapping is functional in the test environment")
    public void theUpdatedMappingIsFunctionalInTheTestEnvironment() {
        verifyMappingFunctionalInTestEnvironment("RV60C901");
    }

    @When("the user verifies the functional specification")
    public void theUserVerifiesTheFunctionalSpecification() {
        verifyFunctionalSpecification();
    }

    @Then("all functional requirements for the mapping are satisfied")
    public void allFunctionalRequirementsForTheMappingAreSatisfied() {
        verifyFunctionalRequirementsSatisfied();
    }

    @Given("the updated mapping is functional and meets all requirements")
    public void theUpdatedMappingIsFunctionalAndMeetsAllRequirements() {
        verifyFunctionalRequirementsSatisfied();
    }

    @When("the user performs a peer review of the configuration")
    public void theUserPerformsAPeerReviewOfTheConfiguration() {
        performPeerReview();
    }

    @Then("the peer review confirms that the mapping is correctly configured")
    public void thePeerReviewConfirmsThatTheMappingIsCorrectlyConfigured() {
        verifyPeerReviewSuccessful();
    }

    @Given("the configuration is reviewed and approved")
    public void theConfigurationIsReviewedAndApproved() {
        verifyPeerReviewSuccessful();
    }

    @When("the user documents the assignment process")
    public void theUserDocumentsTheAssignmentProcess() {
        documentAssignmentProcess();
    }

    @Then("the documentation is complete and accurate")
    public void theDocumentationIsCompleteAndAccurate() {
        verifyDocumentationCompleteAndAccurate();
    }

    @Given("the assignment process is documented")
    public void theAssignmentProcessIsDocumented() {
        verifyDocumentationCompleteAndAccurate();
    }

    @When("the user signs off on the configuration and updates the status in the project tracker")
    public void theUserSignsOffOnTheConfigurationAndUpdatesTheStatusInTheProjectTracker() {
        signOffConfigurationAndUpdateStatus();
    }

    @Then("the configuration is approved and the status is updated")
    public void theConfigurationIsApprovedAndTheStatusIsUpdated() {
        verifyConfigurationApprovedAndStatusUpdated();
    }
}