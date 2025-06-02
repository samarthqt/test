package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentPage;

public class ShipmentSteps extends ShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST54321\"")
    public void theUserHasAValidCustomerAccountWithCustomerID() {
        String customerId = testHarness.getData("CustomerData", "CustomerID");
        verifyCustomerAccount(customerId);
    }

    @Given("the shipment \"SHIP09876\" is in transit")
    public void theShipmentIsInTransit() {
        String shipmentId = testHarness.getData("ShipmentData", "ShipmentID");
        verifyShipmentInTransit(shipmentId);
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccountUsingValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToAccount(username, password);
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsSuccessfullyLoggedInToTheirAccount() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTheTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP09876\" in the search bar")
    public void theUserEntersTheShipmentIDInTheSearchBar() {
        String shipmentId = testHarness.getData("ShipmentData", "ShipmentID");
        enterShipmentID(shipmentId);
    }

    @Then("shipment details are displayed for \"SHIP09876\"")
    public void shipmentDetailsAreDisplayedForShipmentID() {
        verifyShipmentDetailsDisplayed();
    }

    @Then("the current location of the shipment is displayed as \"Distribution Center B\"")
    public void theCurrentLocationOfTheShipmentIsDisplayed() {
        String expectedLocation = testHarness.getData("ShipmentData", "CurrentLocation");
        verifyCurrentLocation(expectedLocation);
    }

    @Then("the estimated delivery time is displayed as \"3 hours\"")
    public void theEstimatedDeliveryTimeIsDisplayed() {
        String expectedDeliveryTime = testHarness.getData("ShipmentData", "EstimatedDeliveryTime");
        verifyEstimatedDeliveryTime(expectedDeliveryTime);
    }

    @When("the user waits for 5 minutes and refreshes the page")
    public void theUserWaitsForMinutesAndRefreshesThePage() {
        waitForMinutesAndRefreshPage(5);
    }

    @Then("any changes in location or delivery time are updated in real-time")
    public void anyChangesInLocationOrDeliveryTimeAreUpdatedInRealTime() {
        verifyRealTimeUpdates();
    }

    @When("the user logs out of the customer account")
    public void theUserLogsOutOfTheCustomerAccount() {
        logoutOfAccount();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}