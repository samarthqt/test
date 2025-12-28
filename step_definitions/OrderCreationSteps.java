package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.OrderCreationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class OrderCreationSteps extends OrderCreationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user triggers the inbound interface from Lisbon to S/4HANA with a payload of size {string} and unique order ID {string}")
    public void theUserTriggersTheInboundInterface(String payloadSize, String orderId) {
        triggerInboundInterface(payloadSize, orderId);
    }

    @Given("the payload includes all required fields including Sales Area {string}")
    public void thePayloadIncludesAllRequiredFields(String salesArea) {
        validatePayloadFields(salesArea);
    }

    @When("the interface processes the payload")
    public void theInterfaceProcessesThePayload() {
        processPayload();
    }

    @Then("the system creates a new standard order \(ZOR\) in S/4HANA")
    public void theSystemCreatesANewStandardOrder() {
        verifyOrderCreation();
    }

    @Then("the new order is assigned the correct Sales Area {string}")
    public void theNewOrderIsAssignedTheCorrectSalesArea(String salesArea) {
        verifySalesAreaAssignment(salesArea);
    }

    @Then("the order details match the information provided in the payload")
    public void theOrderDetailsMatchTheInformationProvidedInThePayload() {
        verifyOrderDetails();
    }

    @Then("the system generates a unique order number for the new ZOR order")
    public void theSystemGeneratesAUniqueOrderNumber() {
        verifyUniqueOrderNumber();
    }

    @Then("the order creation event is logged in the system for traceability")
    public void theOrderCreationEventIsLoggedInTheSystem() {
        verifyOrderCreationEventLog();
    }

    @Then("the interface logs show successful processing without critical warnings")
    public void theInterfaceLogsShowSuccessfulProcessing() {
        verifyInterfaceLogs();
    }

    @Then("the created order adheres to the standard order format \(ZOR\)")
    public void theCreatedOrderAdheresToTheStandardOrderFormat() {
        verifyOrderFormat();
    }

    @Then("an acknowledgment is sent to Lisbon confirming the successful order creation")
    public void anAcknowledgmentIsSentToLisbon() {
        verifyAcknowledgmentSent();
    }

    @Then("the system processes the payload efficiently without performance degradation")
    public void theSystemProcessesThePayloadEfficiently() {
        verifyPerformanceEfficiency();
    }
}