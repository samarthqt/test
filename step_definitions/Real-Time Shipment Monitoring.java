package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentMonitoringSteps extends ShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST12345\"")
    public void theUserHasAValidCustomerAccount() {
        String customerId = testHarness.getData("CustomerData", "CustomerID");
        verifyCustomerAccount(customerId);
    }

    @Given("the shipment is in transit")
    public void theShipmentIsInTransit() {
        verifyShipmentStatus("In Transit");
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccount() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToAccount(username, password);
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP67890\" in the search bar")
    public void theUserEntersShipmentIDInSearchBar() {
        String shipmentId = testHarness.getData("ShipmentData", "ShipmentID");
        enterShipmentID(shipmentId);
    }

    @Then("shipment details are displayed for \"SHIP67890\"")
    public void shipmentDetailsAreDisplayed() {
        verifyShipmentDetailsDisplayed("SHIP67890");
    }

    @Then("the current location of the shipment is displayed as \"Warehouse A\"")
    public void currentLocationIsDisplayed() {
        verifyCurrentLocation("Warehouse A");
    }

    @Then("the estimated delivery time is displayed as \"2 hours\"")
    public void estimatedDeliveryTimeIsDisplayed() {
        verifyEstimatedDeliveryTime("2 hours");
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        refreshPage();
    }

    @Then("any changes in location or delivery time are updated in real-time")
    public void changesAreUpdatedInRealTime() {
        verifyRealTimeUpdates();
    }

    @When("the user logs out of the customer account")
    public void theUserLogsOutOfTheCustomerAccount() {
        logoutFromAccount();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}