package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST12345\"")
    public void theUserHasAValidCustomerAccount() {
        String customerId = testHarness.getData("CustomerData", "CustomerID");
        verifyCustomerAccount(customerId);
    }

    @Given("the shipment with Shipment ID \"SHIP67890\" is in transit")
    public void theShipmentIsInTransit() {
        String shipmentId = testHarness.getData("ShipmentData", "ShipmentID");
        verifyShipmentInTransit(shipmentId);
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsIn() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToAccount(username, password);
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTrackShipment() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP67890\" in the search bar")
    public void theUserEntersShipmentID() {
        String shipmentId = testHarness.getData("ShipmentData", "ShipmentID");
        enterShipmentID(shipmentId);
    }

    @Then("the shipment details are displayed for \"SHIP67890\"")
    public void theShipmentDetailsAreDisplayed() {
        String shipmentId = testHarness.getData("ShipmentData", "ShipmentID");
        verifyShipmentDetailsDisplayed(shipmentId);
    }

    @Then("the current location of the shipment is displayed as \"Warehouse A\"")
    public void theCurrentLocationIsDisplayed() {
        String expectedLocation = testHarness.getData("ShipmentData", "CurrentLocation");
        verifyCurrentLocation(expectedLocation);
    }

    @Then("the estimated delivery time is displayed as \"2 hours\"")
    public void theEstimatedDeliveryTimeIsDisplayed() {
        String expectedDeliveryTime = testHarness.getData("ShipmentData", "EstimatedDeliveryTime");
        verifyEstimatedDeliveryTime(expectedDeliveryTime);
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        refreshPage();
    }

    @Then("any changes in location or delivery time are updated in real-time")
    public void theChangesAreUpdatedInRealTime() {
        verifyRealTimeUpdates();
    }

    @When("the user logs out of the customer account")
    public void theUserLogsOut() {
        logoutFromAccount();
    }

    @Then("the user is successfully logged out")
    public void theUserIsLoggedOut() {
        verifyLogoutSuccess();
    }
}