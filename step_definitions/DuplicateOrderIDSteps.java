package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.DuplicateOrderIDPage;
import com.framework.cucumber.TestHarness;

public class DuplicateOrderIDSteps extends DuplicateOrderIDPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing Unique Order ID {string}")
    public void theUserTriggersInboundInterface(String uniqueOrderID) {
        triggerInboundInterface(uniqueOrderID);
    }

    @Given("the payload includes all mandatory fields including Sales Area {string}")
    public void thePayloadIncludesMandatoryFields(String salesArea) {
        validateMandatoryFields(salesArea);
    }

    @When("the system processes the payload")
    public void theSystemProcessesPayload() {
        processPayload();
    }

    @Then("the system identifies the duplicate Unique Order ID")
    public void theSystemIdentifiesDuplicateID() {
        verifyDuplicateOrderID();
    }

    @Then("the system rejects the order creation and logs an error for the duplicate ID")
    public void theSystemRejectsOrderCreation() {
        logErrorForDuplicateID();
    }

    @Then("the error message in the system logs indicates that the Unique Order ID already exists")
    public void theErrorMessageIndicatesDuplicateID() {
        verifyErrorMessageInLogs();
    }

    @Then("no new order is created in the system")
    public void noNewOrderIsCreated() {
        verifyNoNewOrderCreated();
    }

    @Then("the system sends an error acknowledgment back to Lisbon indicating the failure to create the order")
    public void theSystemSendsErrorAcknowledgment() {
        sendErrorAcknowledgment();
    }

    @Then("the interface logs provide details of the rejected order creation attempt")
    public void theInterfaceLogsProvideDetails() {
        verifyInterfaceLogsDetails();
    }

    @Then("the system does not create any duplicate entries in the database")
    public void theSystemDoesNotCreateDuplicateEntries() {
        verifyNoDuplicateEntriesInDatabase();
    }

    @Then("the system maintains consistent performance during the error handling process")
    public void theSystemMaintainsPerformance() {
        verifyPerformanceConsistency();
    }

    @Then("the error handling process adheres to the configured business rules for duplicate IDs")
    public void theErrorHandlingAdheresToBusinessRules() {
        verifyBusinessRulesAdherence();
    }

    @Then("the system logs the rejection event with a timestamp for audit purposes")
    public void theSystemLogsRejectionEvent() {
        logRejectionEventWithTimestamp();
    }
}