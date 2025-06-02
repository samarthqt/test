package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackingPage;

public class TrackingIntegrationSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the tracking system is integrated with multiple carriers")
    public void theTrackingSystemIsIntegratedWithMultipleCarriers() {
        verifyIntegrationWithCarriers();
    }

    @When("I select Carrier A from the carrier list")
    public void iSelectCarrierAFromTheCarrierList() {
        selectCarrier("FedEx");
    }

    @Then("Carrier A is selected")
    public void carrierAIsSelected() {
        verifyCarrierSelected("FedEx");
    }

    @Given("Carrier A API keys are configured")
    public void carrierAApiKeysAreConfigured() {
        configureApiKeys("FedEx");
    }

    @When("I enter a valid tracking number for Carrier A")
    public void iEnterAValidTrackingNumberForCarrierA() {
        enterTrackingNumber("FedEx", testHarness.getData("TrackingData", "ValidTrackingNumber"));
    }

    @Then("Tracking information is retrieved successfully")
    public void trackingInformationIsRetrievedSuccessfully() {
        verifyTrackingInformationRetrieved();
    }

    @When("I select Carrier B from the carrier list")
    public void iSelectCarrierBFromTheCarrierList() {
        selectCarrier("UPS");
    }

    @Then("Carrier B is selected")
    public void carrierBIsSelected() {
        verifyCarrierSelected("UPS");
    }

    @Given("Carrier B API keys are configured")
    public void carrierBApiKeysAreConfigured() {
        configureApiKeys("UPS");
    }

    @When("I enter a valid tracking number for Carrier B")
    public void iEnterAValidTrackingNumberForCarrierB() {
        enterTrackingNumber("UPS", testHarness.getData("TrackingData", "ValidTrackingNumber"));
    }

    @When("I select Carrier C from the carrier list")
    public void iSelectCarrierCFromTheCarrierList() {
        selectCarrier("DHL");
    }

    @Then("Carrier C is selected")
    public void carrierCIsSelected() {
        verifyCarrierSelected("DHL");
    }

    @Given("Carrier C API keys are configured")
    public void carrierCApiKeysAreConfigured() {
        configureApiKeys("DHL");
    }

    @When("I enter a valid tracking number for Carrier C")
    public void iEnterAValidTrackingNumberForCarrierC() {
        enterTrackingNumber("DHL", testHarness.getData("TrackingData", "ValidTrackingNumber"));
    }

    @When("I enter an invalid tracking number for Carrier A")
    public void iEnterAnInvalidTrackingNumberForCarrierA() {
        enterTrackingNumber("FedEx", testHarness.getData("TrackingData", "InvalidTrackingNumber"));
    }

    @Then("System displays an error message for invalid tracking numbers")
    public void systemDisplaysAnErrorMessageForInvalidTrackingNumbers() {
        verifyErrorMessageForInvalidTracking();
    }

    @When("Carrier A experiences a service outage")
    public void carrierAExperiencesAServiceOutage() {
        simulateServiceOutage("FedEx");
    }

    @Then("System displays a service outage message for Carrier A")
    public void systemDisplaysAServiceOutageMessageForCarrierA() {
        verifyServiceOutageMessage("FedEx");
    }

    @When("Carrier B experiences a service outage")
    public void carrierBExperiencesAServiceOutage() {
        simulateServiceOutage("UPS");
    }

    @Then("System displays a service outage message for Carrier B")
    public void systemDisplaysAServiceOutageMessageForCarrierB() {
        verifyServiceOutageMessage("UPS");
    }

    @When("Carrier C experiences a service outage")
    public void carrierCExperiencesAServiceOutage() {
        simulateServiceOutage("DHL");
    }

    @Then("System displays a service outage message for Carrier C")
    public void systemDisplaysAServiceOutageMessageForCarrierC() {
        verifyServiceOutageMessage("DHL");
    }

    @When("the system handles multiple carrier requests")
    public void theSystemHandlesMultipleCarrierRequests() {
        simulateHighLoad();
    }

    @Then("System remains stable and responsive")
    public void systemRemainsStableAndResponsive() {
        verifySystemPerformance();
    }

    @When("tracking information is retrieved")
    public void trackingInformationIsRetrieved() {
        retrieveTrackingInformation();
    }

    @Then("Carrier-specific tracking details are displayed")
    public void carrierSpecificTrackingDetailsAreDisplayed() {
        verifyCarrierSpecificDetails();
    }

    @When("a new carrier is integrated into the system")
    public void aNewCarrierIsIntegratedIntoTheSystem() {
        integrateNewCarrier();
    }

    @Then("System can integrate with new carriers successfully")
    public void systemCanIntegrateWithNewCarriersSuccessfully() {
        verifyNewCarrierIntegration();
    }
}