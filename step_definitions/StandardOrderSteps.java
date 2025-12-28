package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.StandardOrderPage;

public class StandardOrderSteps extends StandardOrderPage {

    @Given("the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing the Unique Order ID {string}")
    public void theUserTriggersTheInboundInterface(String uniqueOrderID) {
        triggerInboundInterface(uniqueOrderID);
    }

    @Given("the payload includes all mandatory fields including Sales Area {string}")
    public void thePayloadIncludesMandatoryFields(String salesArea) {
        verifyMandatoryFields(salesArea);
    }

    @When("the interface processes the payload in S/4HANA")
    public void theInterfaceProcessesThePayload() {
        processPayload();
    }

    @Then("a new standard order \(ZOR\) is created in the S/4HANA system")
    public void aNewStandardOrderIsCreated() {
        verifyOrderCreation();
    }

    @Then("the created order is assigned the correct Sales Area {string}")
    public void theCreatedOrderIsAssignedCorrectSalesArea(String salesArea) {
        verifySalesAreaAssignment(salesArea);
    }

    @Then("the order details match the information provided in the payload")
    public void theOrderDetailsMatchPayload() {
        verifyOrderDetails();
    }

    @Then("the system generates a unique order number for the new ZOR order")
    public void theSystemGeneratesUniqueOrderNumber() {
        verifyUniqueOrderNumber();
    }

    @Then("the order creation is logged in the system for traceability")
    public void theOrderCreationIsLogged() {
        verifyOrderLogging();
    }

    @Then("the interface logs indicate successful processing without critical warnings")
    public void theInterfaceLogsIndicateSuccess() {
        verifyInterfaceLogs();
    }

    @Then("the integration between Lisbon and S/4HANA is seamless and error-free")
    public void theIntegrationIsSeamless() {
        verifyIntegration();
    }

    @Then("the created order adheres to the standard order format \(ZOR\)")
    public void theCreatedOrderAdheresToStandardFormat() {
        verifyOrderFormat();
    }

    @Then("the system sends an acknowledgment back to Lisbon confirming the successful creation of the order")
    public void theSystemSendsAcknowledgment() {
        verifyAcknowledgment();
    }
}