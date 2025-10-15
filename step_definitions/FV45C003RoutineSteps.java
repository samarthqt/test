package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.FV45C003RoutinePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class FV45C003RoutineSteps extends FV45C003RoutinePage {

    @Given("the FV45C003 routine is configured and active")
    public void theFV45C003RoutineIsConfiguredAndActive() {
        verifyRoutineConfiguration();
    }

    @When("the user creates a Billing document of type {string} with {string}")
    public void theUserCreatesABillingDocumentOfTypeWith(String billingDocumentType, String partnerData) {
        createBillingDocument(billingDocumentType, partnerData);
    }

    @Then("the Billing document is created successfully with the specified data")
    public void theBillingDocumentIsCreatedSuccessfullyWithTheSpecifiedData() {
        verifyBillingDocumentCreation();
    }

    @When("the user generates a Sales document of type {string}")
    public void theUserGeneratesASalesDocumentOfType(String salesDocumentType) {
        generateSalesDocument(salesDocumentType);
    }

    @Then("the Sales document is generated successfully without errors")
    public void theSalesDocumentIsGeneratedSuccessfullyWithoutErrors() {
        verifySalesDocumentGeneration();
    }

    @Given("a Sales document is generated using the FV45C003 routine")
    public void aSalesDocumentIsGeneratedUsingTheFV45C003Routine() {
        verifySalesDocumentGenerated();
    }

    @When("the user verifies the partner data in the Sales document")
    public void theUserVerifiesThePartnerDataInTheSalesDocument() {
        verifyPartnerDataInSalesDocument();
    }

    @Then("the partner data, including {string}, is copied accurately")
    public void thePartnerDataIncludingIsCopiedAccurately(String partnerData) {
        verifyPartnerDataAccuracy(partnerData);
    }

    @Given("a Billing document and a Sales document are created")
    public void aBillingDocumentAndASalesDocumentAreCreated() {
        verifyDocumentsCreated();
    }

    @When("the user checks the document flow")
    public void theUserChecksTheDocumentFlow() {
        checkDocumentFlow();
    }

    @Then("the document flow shows correct linkage without any issues")
    public void theDocumentFlowShowsCorrectLinkageWithoutAnyIssues() {
        verifyDocumentFlowLinkage();
    }

    @When("the user performs the process of creating Billing and Sales documents")
    public void theUserPerformsTheProcessOfCreatingBillingAndSalesDocuments() {
        performDocumentCreationProcess();
    }

    @Then("the system performance is within acceptable limits, and response time is not affected")
    public void theSystemPerformanceIsWithinAcceptableLimitsAndResponseTimeIsNotAffected() {
        validateSystemPerformance();
    }

    @When("the user documents the test results")
    public void theUserDocumentsTheTestResults() {
        documentTestResults();
    }

    @Then("the test results are documented, and recommendations are provided to enhance the routine's robustness")
    public void theTestResultsAreDocumentedAndRecommendationsAreProvidedToEnhanceTheRoutineRobustness() {
        provideRecommendationsForImprovement();
    }
}