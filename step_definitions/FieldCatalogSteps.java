package com.cucumber.steps;

import com.pageobjects.FieldCatalogPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class FieldCatalogSteps {

    private FieldCatalogPage fieldCatalogPage = new FieldCatalogPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        fieldCatalogPage.navigateToLoginPage();
        fieldCatalogPage.enterCredentials("username", "password");
    }

    @When("the user logs into the SAP S/4 HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        fieldCatalogPage.clickLoginButton();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        fieldCatalogPage.verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP S/4 HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        fieldCatalogPage.verifyLoginSuccess();
    }

    @When("the user navigates to the configuration screen for billing output determination")
    public void theUserNavigatesToConfigurationScreen() {
        fieldCatalogPage.navigateToConfigurationScreen();
    }

    @Then("the configuration screen for billing output determination is displayed")
    public void theConfigurationScreenIsDisplayed() {
        fieldCatalogPage.verifyConfigurationScreenDisplayed();
    }

    @Given("the user is on the configuration screen for billing output determination")
    public void theUserIsOnConfigurationScreen() {
        fieldCatalogPage.verifyConfigurationScreenDisplayed();
    }

    @When("the user accesses the field catalog \\(ZPDT\\) settings")
    public void theUserAccessesFieldCatalogSettings() {
        fieldCatalogPage.accessFieldCatalogSettings();
    }

    @Then("the field catalog settings are accessible")
    public void theFieldCatalogSettingsAreAccessible() {
        fieldCatalogPage.verifyFieldCatalogSettingsAccessible();
    }

    @Given("the user has accessed the field catalog \\(ZPDT\\) settings")
    public void theUserHasAccessedFieldCatalogSettings() {
        fieldCatalogPage.verifyFieldCatalogSettingsAccessible();
    }

    @When("the user searches for {string} in the field catalog list")
    public void theUserSearchesForAttribute(String attribute) {
        fieldCatalogPage.searchForAttribute(attribute);
    }

    @Then("{string} is visible in the field catalog list")
    public void attributeIsVisibleInFieldCatalogList(String attribute) {
        fieldCatalogPage.verifyAttributeVisibility(attribute);
    }

    @Given("the user has found {string} in the field catalog list")
    public void theUserHasFoundAttributeInFieldCatalogList(String attribute) {
        fieldCatalogPage.verifyAttributeVisibility(attribute);
    }

    @When("the user selects {string} and verifies its properties")
    public void theUserSelectsAttributeAndVerifiesProperties(String attribute) {
        fieldCatalogPage.selectAttribute(attribute);
        fieldCatalogPage.verifyAttributeProperties(attribute);
    }

    @Then("{string} is selectable and its properties such as {string} are correct")
    public void attributeIsSelectableAndPropertiesAreCorrect(String attribute, String property) {
        fieldCatalogPage.verifyAttributeProperties(attribute, property);
    }

    @Given("the user has made modifications to the field catalog settings")
    public void theUserHasMadeModificationsToFieldCatalogSettings() {
        fieldCatalogPage.modifyFieldCatalogSettings();
    }

    @When("the user saves the configuration changes")
    public void theUserSavesConfigurationChanges() {
        fieldCatalogPage.saveConfigurationChanges();
    }

    @Then("the changes are saved successfully without errors")
    public void theChangesAreSavedSuccessfully() {
        fieldCatalogPage.verifyChangesSavedSuccessfully();
    }

    @When("the user creates a new billing document")
    public void theUserCreatesNewBillingDocument() {
        fieldCatalogPage.createBillingDocument();
    }

    @Then("the billing document creation screen is displayed")
    public void theBillingDocumentCreationScreenIsDisplayed() {
        fieldCatalogPage.verifyBillingDocumentCreationScreenDisplayed();
    }

    @Given("the user is on the billing document creation screen")
    public void theUserIsOnBillingDocumentCreationScreen() {
        fieldCatalogPage.verifyBillingDocumentCreationScreenDisplayed();
    }

    @When("the user enters the required details including {string}")
    public void theUserEntersRequiredDetailsIncludingAttribute(String attribute) {
        fieldCatalogPage.enterBillingDocumentDetails(attribute);
    }

    @Then("the details are entered successfully and {string} is selectable")
    public void theDetailsAreEnteredSuccessfullyAndAttributeIsSelectable(String attribute) {
        fieldCatalogPage.verifyAttributeSelectable(attribute);
    }

    @Given("the user has entered the required details for the billing document")
    public void theUserHasEnteredRequiredDetailsForBillingDocument() {
        fieldCatalogPage.verifyBillingDocumentDetailsEntered();
    }

    @When("the user configures an output determination rule using {string}")
    public void theUserConfiguresOutputDeterminationRuleUsingAttribute(String attribute) {
        fieldCatalogPage.configureOutputDeterminationRule(attribute);
    }

    @Then("the output determination rule is configured successfully")
    public void theOutputDeterminationRuleIsConfiguredSuccessfully() {
        fieldCatalogPage.verifyOutputDeterminationRuleConfigured();
    }

    @Given("the user has configured the output determination rule")
    public void theUserHasConfiguredOutputDeterminationRule() {
        fieldCatalogPage.verifyOutputDeterminationRuleConfigured();
    }

    @When("the user triggers the output determination process for the billing document")
    public void theUserTriggersOutputDeterminationProcess() {
        fieldCatalogPage.triggerOutputDeterminationProcess();
    }

    @Then("the output determination process is triggered without errors")
    public void theOutputDeterminationProcessIsTriggeredWithoutErrors() {
        fieldCatalogPage.verifyOutputDeterminationProcessTriggered();
    }

    @Given("the user has triggered the output determination process")
    public void theUserHasTriggeredOutputDeterminationProcess() {
        fieldCatalogPage.verifyOutputDeterminationProcessTriggered();
    }

    @When("the user validates that {string} is used in the output determination logic")
    public void theUserValidatesAttributeUsedInOutputDeterminationLogic(String attribute) {
        fieldCatalogPage.validateAttributeInOutputDeterminationLogic(attribute);
    }

    @Then("{string} is correctly applied in the output determination logic")
    public void attributeIsCorrectlyAppliedInOutputDeterminationLogic(String attribute) {
        fieldCatalogPage.verifyAttributeAppliedInOutputDeterminationLogic(attribute);
    }

    @Given("the user has validated the output determination logic")
    public void theUserHasValidatedOutputDeterminationLogic() {
        fieldCatalogPage.verifyOutputDeterminationLogicValidated();
    }

    @When("the user generates a report to confirm the visibility and usage of Attribute 7")
    public void theUserGeneratesReportToConfirmVisibilityAndUsage() {
        fieldCatalogPage.generateReportForAttributeUsage();
    }

    @Then("the report confirms that Attribute 7 is visible and used as expected")
    public void theReportConfirmsAttributeVisibilityAndUsage() {
        fieldCatalogPage.verifyReportConfirmsAttributeUsage();
    }

    @Given("user logs into the SAP S/4 HANA system with appropriate credentials")
    public void userLogsIntoTheSAPSystemWithAppropriateCredentials() {
        fieldCatalogPage.loginToSAPSystem("username", "password");
    }

    @When("user navigates to the configuration screen for billing output determination")
    public void userNavigatesToConfigurationScreenForBillingOutputDetermination() {
        fieldCatalogPage.navigateToBillingOutputDetermination();
    }

    @When("user accesses the field catalog settings")
    public void userAccessesTheFieldCatalogSettings() {
        fieldCatalogPage.accessFieldCatalogSettings();
    }

    @When("user searches for Attribute 7 in the field catalog list")
    public void userSearchesForAttribute7InTheFieldCatalogList() {
        fieldCatalogPage.searchForAttributeInFieldCatalog("Attribute 7");
    }

    @When("user enters {string} for Attribute 7")
    public void userEntersValueForAttribute7(String attributeValue) {
        fieldCatalogPage.enterAttributeValue(attributeValue);
    }

    @When("user saves the changes to the field catalog")
    public void userSavesTheChangesToTheFieldCatalog() {
        fieldCatalogPage.saveFieldCatalogChanges();
    }

    @When("user creates a new billing document using the boundary values for Attribute 7")
    public void userCreatesANewBillingDocumentUsingBoundaryValuesForAttribute7() {
        fieldCatalogPage.createBillingDocumentWithBoundaryValues();
    }

    @When("user triggers the output determination process for the billing document")
    public void userTriggersTheOutputDeterminationProcessForTheBillingDocument() {
        fieldCatalogPage.triggerOutputDeterminationProcess();
    }

    @Then("the output determination logic should handle the boundary values {string} correctly")
    public void theOutputDeterminationLogicShouldHandleBoundaryValuesCorrectly(String attributeValue) {
        fieldCatalogPage.verifyOutputDeterminationLogic(attributeValue);
    }

    @Then("user generates a report confirming the processing of boundary values {string}")
    public void userGeneratesAReportConfirmingProcessingOfBoundaryValues(String attributeValue) {
        fieldCatalogPage.generateBoundaryValuesReport(attributeValue);
    }

    @Given("user logs out of the SAP S/4 HANA system")
    public void userLogsOutOfTheSAPSystem() {
        fieldCatalogPage.logoutFromSAPSystem();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        fieldCatalogPage.verifySuccessfulLogout();
    }
}
