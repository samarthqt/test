package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentMonitoringSteps extends ShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST54321\"")
    public void theUserHasAValidCustomerAccount() {
        String customerId = "CUST54321";
        verifyCustomerAccount(customerId);
    }

    @Given("the shipment is in transit with Shipment ID \"SHIP09876\"")
    public void theShipmentIsInTransit() {
        String shipmentId = "SHIP09876";
        verifyShipmentInTransit(shipmentId);
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccount() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToAccount(userName, password);
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Then("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP09876\" in the search bar")
    public void theUserEntersShipmentIDInSearchBar() {
        String shipmentId = "SHIP09876";
        enterShipmentIDInSearchBar(shipmentId);
    }

    @Then("the shipment details are displayed for Shipment ID \"SHIP09876\"")
    public void theShipmentDetailsAreDisplayed() {
        verifyShipmentDetailsDisplayed("SHIP09876");
    }

    @Then("the current location of the shipment is displayed as \"Distribution Center B\"")
    public void theCurrentLocationIsDisplayed() {
        verifyCurrentLocationDisplayed("Distribution Center B");
    }

    @Then("the estimated delivery time is displayed as \"3 hours\"")
    public void theEstimatedDeliveryTimeIsDisplayed() {
        verifyEstimatedDeliveryTimeDisplayed("3 hours");
    }

    @When("the user waits for 5 minutes and refreshes the page")
    public void theUserWaitsAndRefreshesPage() {
        waitForMinutes(5);
        refreshPage();
    }

    @Then("any changes in location or delivery time are updated in real-time")
    public void changesAreUpdatedInRealTime() {
        verifyRealTimeUpdates();
    }

    @When("the user logs out of the customer account")
    public void theUserLogsOutOfCustomerAccount() {
        logoutOfAccount();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}