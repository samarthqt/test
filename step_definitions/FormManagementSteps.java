package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.FormManagementPage;
import com.framework.cucumber.TestHarness;

public class FormManagementSteps extends FormManagementPage {

    @Given("the user logs in to the SAP S/4HANA Cloud system")
    public void theUserLogsInToTheSAPSystem() {
        loginToSAPSystem();
    }

    @When("the user navigates to the Form Management application")
    public void theUserNavigatesToFormManagementApplication() {
        navigateToFormManagement();
    }

    @Then("the Form Management application is displayed successfully")
    public void theFormManagementApplicationIsDisplayedSuccessfully() {
        verifyFormManagementPageDisplayed();
    }

    @Given("the necessary configuration for the ZPB1 form template creation is completed")
    public void theNecessaryConfigurationForZPB1FormTemplateCreationIsCompleted() {
        verifyConfigurationForZPB1Template();
    }

    @When("the user selects the option to create a new form template")
    public void theUserSelectsOptionToCreateNewFormTemplate() {
        selectCreateNewFormTemplateOption();
    }

    @When("the user chooses the {string} template as the base for the new form template")
    public void theUserChoosesBaseTemplate(String baseTemplate) {
        chooseBaseTemplate(baseTemplate);
    }

    @When("the user enters {string} for the new form template")
    public void theUserEntersNewTemplateName(String newTemplateName) {
        enterNewTemplateName(newTemplateName);
    }

    @When("the user associates the new template with document type {string} and billing document type {string}")
    public void theUserAssociatesNewTemplateWithDocumentTypeAndBillingDocumentType(String documentType, String billingDocumentType) {
        associateTemplateWithDocumentTypes(documentType, billingDocumentType);
    }

    @When("the user populates the fields required for periodic billing, ensuring alignment with the ZPDT template structure")
    public void theUserPopulatesFieldsForPeriodicBilling() {
        populateFieldsForPeriodicBilling();
    }

    @When("the user reviews the configuration of the new template to ensure all details are accurate")
    public void theUserReviewsConfigurationOfNewTemplate() {
        reviewNewTemplateConfiguration();
    }

    @When("the user saves the new template")
    public void theUserSavesTheNewTemplate() {
        saveNewTemplate();
    }

    @When("the user activates the new template")
    public void theUserActivatesTheNewTemplate() {
        activateNewTemplate();
    }

    @Then("the new template is created, saved, and activated successfully")
    public void theNewTemplateIsCreatedSavedAndActivatedSuccessfully() {
        verifyTemplateCreatedAndActivated();
    }

    @Given("the ZPB1 form template is activated successfully")
    public void theZPB1FormTemplateIsActivatedSuccessfully() {
        verifyZPB1TemplateActivated();
    }

    @When("the user generates a periodic billing document of type ZPB")
    public void theUserGeneratesPeriodicBillingDocumentOfTypeZPB() {
        generatePeriodicBillingDocument();
    }

    @Then("the periodic billing document of type ZPB is generated successfully")
    public void thePeriodicBillingDocumentIsGeneratedSuccessfully() {
        verifyPeriodicBillingDocumentGenerated();
    }

    @Given("a periodic billing document of type ZPB is generated")
    public void aPeriodicBillingDocumentOfTypeZPBIsGenerated() {
        verifyPeriodicBillingDocumentGenerated();
    }

    @When("the user verifies that the ZPB1 form is assigned to the generated billing document")
    public void theUserVerifiesZPB1FormAssignedToBillingDocument() {
        verifyZPB1FormAssignedToBillingDocument();
    }

    @Then("the ZPB1 form is correctly assigned to the billing document")
    public void theZPB1FormIsCorrectlyAssignedToBillingDocument() {
        verifyZPB1FormAssignment();
    }

    @Given("the ZPB1 form is assigned to the billing document")
    public void theZPB1FormIsAssignedToBillingDocument() {
        verifyZPB1FormAssignment();
    }

    @When("the user prints the ZPB1 form")
    public void theUserPrintsTheZPB1Form() {
        printZPB1Form();
    }

    @Then("the ZPB1 form is printed successfully")
    public void theZPB1FormIsPrintedSuccessfully() {
        verifyZPB1FormPrinted();
    }

    @Then("the output is correctly formatted with all necessary fields included")
    public void theOutputIsCorrectlyFormatted() {
        verifyOutputFormatting();
    }
}