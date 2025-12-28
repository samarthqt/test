package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

import com.pageobjects.ZPB1OutputProcessingPage;

public class ZPB1OutputProcessingSteps extends ZPB1OutputProcessingPage {

    @Given("the user has authorized credentials")
    public void theUserHasAuthorizedCredentials() {
        verifyAuthorizedCredentials();
    }

    @When("the user logs into the SAP S/4 HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        loginToSAPSystem();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIntoTheSystem() {
        verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP S/4 HANA system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the periodic billing document processing transaction")
    public void theUserNavigatesToThePeriodicBillingTransaction() {
        navigateToPeriodicBillingTransaction();
    }

    @Then("the periodic billing document processing screen is displayed")
    public void thePeriodicBillingScreenIsDisplayed() {
        verifyPeriodicBillingScreenDisplayed();
    }

    @Given("the user is on the periodic billing document processing screen")
    public void theUserIsOnThePeriodicBillingScreen() {
        verifyOnPeriodicBillingScreen();
    }

    @When("the user searches for the ZFR document with document ID {string}")
    public void theUserSearchesForTheZFRDocument(String documentID) {
        searchForZFRDocument(documentID);
    }

    @Then("the ZFR document with ID {string} is displayed in the search results")
    public void theZFRDocumentIsDisplayed(String documentID) {
        verifyZFRDocumentDisplayed(documentID);
    }

    @Given("the ZFR document is displayed in the search results")
    public void theZFRDocumentIsDisplayedInSearchResults() {
        verifyZFRDocumentInSearchResults();
    }

    @When("the user selects the ZFR document for processing")
    public void theUserSelectsTheZFRDocument() {
        selectZFRDocument();
    }

    @Then("the ZFR document is selected successfully")
    public void theZFRDocumentIsSelectedSuccessfully() {
        verifyZFRDocumentSelected();
    }

    @Given("the ZFR document is selected for processing")
    public void theZFRDocumentIsSelectedForProcessing() {
        verifyZFRDocumentSelectedForProcessing();
    }

    @When("the user triggers the output processing for the ZFR document")
    public void theUserTriggersOutputProcessing() {
        triggerOutputProcessing();
    }

    @Then("the system initiates the output processing for the ZFR document")
    public void theSystemInitiatesOutputProcessing() {
        verifyOutputProcessingInitiated();
    }

    @Given("the system has initiated the output processing for the ZFR document")
    public void theSystemHasInitiatedOutputProcessing() {
        verifyOutputProcessingInitiation();
    }

    @When("the user verifies the output type determination")
    public void theUserVerifiesOutputTypeDetermination() {
        verifyOutputTypeDetermination();
    }

    @Then("the system successfully determines ZPB1 as the output type")
    public void theSystemDeterminesZPB1OutputType() {
        verifyZPB1OutputType();
    }

    @Given("the system has generated the ZPB1 output")
    public void theSystemHasGeneratedZPB1Output() {
        verifyZPB1OutputGenerated();
    }

    @When("the user reviews the output for multi-section formatting accuracy")
    public void theUserReviewsOutputFormatting() {
        reviewOutputFormatting();
    }

    @Then("the generated ZPB1 output accurately reflects the multi-section formatting")
    public void theGeneratedOutputReflectsFormatting() {
        verifyOutputFormattingAccuracy();
    }

    @When("the user validates the formatting of all sections \(Header, Body, Footer\)")
    public void theUserValidatesAllSections() {
        validateAllSectionsFormatting();
    }

    @Then("all sections in the ZPB1 output are formatted correctly without errors")
    public void allSectionsAreFormattedCorrectly() {
        verifyAllSectionsFormattedCorrectly();
    }

    @When("the user verifies the output for truncations or errors")
    public void theUserVerifiesOutputForErrors() {
        verifyOutputForErrors();
    }

    @Then("the ZPB1 output is complete without any truncations or errors")
    public void theOutputIsComplete() {
        verifyOutputCompleteness();
    }

    @When("the user checks the availability of the ZPB1 output for further actions")
    public void theUserChecksOutputAvailability() {
        checkOutputAvailability();
    }

    @Then("the ZPB1 output is successfully available for further actions")
    public void theOutputIsAvailable() {
        verifyOutputAvailability();
    }

    @Given("the ZPB1 output processing is complete")
    public void theOutputProcessingIsComplete() {
        verifyOutputProcessingCompletion();
    }

    @When("the user reviews the output logs")
    public void theUserReviewsOutputLogs() {
        reviewOutputLogs();
    }

    @Then("the output logs do not contain any errors or warnings related to the processing")
    public void theLogsDoNotContainErrors() {
        verifyLogsForErrors();
    }

    @When("the user ensures the output is saved in the designated directory or location")
    public void theUserEnsuresOutputSaved() {
        ensureOutputSaved();
    }

    @Then("the ZPB1 output is successfully saved in the designated directory or location")
    public void theOutputIsSaved() {
        verifyOutputSaved();
    }
}