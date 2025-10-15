package com.cucumber.steps;

import com.pageobjects.InboundFilePage;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class InboundFileSteps extends InboundFilePage {

    @Given("user has valid credentials")
    public void userHasValidCredentials() {
        validateUserCredentials();
    }

    @When("user logs into the SAP system")
    public void userLogsIntoTheSAPSystem() {
        loginToSAPSystem();
    }

    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        verifySuccessfulLogin();
    }

    @Given("user is logged into the SAP system")
    public void userIsLoggedIntoTheSAPSystem() {
        ensureUserIsLoggedIn();
    }

    @When("user navigates to the inbound file upload interface")
    public void userNavigatesToTheInboundFileUploadInterface() {
        navigateToInboundFileUploadInterface();
    }

    @Then("inbound file upload interface is displayed")
    public void inboundFileUploadInterfaceIsDisplayed() {
        verifyInboundFileUploadInterfaceDisplayed();
    }

    @When("user uploads the inbound file with missing {string}")
    public void userUploadsTheInboundFileWithMissingMandatoryField(String mandatoryField) {
        uploadInboundFileWithMissingField(mandatoryField);
    }

    @When("user triggers the inbound interface processing manually")
    public void userTriggersTheInboundInterfaceProcessingManually() {
        triggerInboundInterfaceProcessing();
    }

    @Then("processing logs display error messages specifying the missing {string}")
    public void processingLogsDisplayErrorMessagesSpecifyingTheMissingMandatoryField(String mandatoryField) {
        verifyProcessingLogsForMissingField(mandatoryField);
    }

    @Then("no sales orders are created for the files with missing mandatory fields")
    public void noSalesOrdersAreCreatedForTheFilesWithMissingMandatoryFields() {
        verifyNoSalesOrdersCreated();
    }

    @Then("error logs provide detailed descriptions of the missing fields")
    public void errorLogsProvideDetailedDescriptionsOfTheMissingFields() {
        verifyErrorLogsForMissingFields();
    }

    @Then("user interface displays notifications about the missing fields")
    public void userInterfaceDisplaysNotificationsAboutTheMissingFields() {
        verifyUINotificationsForMissingFields();
    }

    @Then("system integrity is maintained with no incomplete or incorrect sales orders")
    public void systemIntegrityIsMaintainedWithNoIncompleteOrIncorrectSalesOrders() {
        verifySystemIntegrity();
    }
}