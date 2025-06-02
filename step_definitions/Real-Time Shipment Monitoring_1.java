package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentPage;

public class ShipmentSteps extends ShipmentPage {

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
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTrackShipmentSection() {
        navigateToTrackShipment();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP09876\" in the search bar")
    public void theUserEntersTheShipmentIDInTheSearchBar() {
        String shipmentId = "SHIP09876";
        enterShipmentId(shipmentId);
    }

    @Then("the shipment details are displayed for \"SHIP09876\"")
    public void theShipmentDetailsAreDisplayed() {
        verifyShipmentDetailsDisplayed("SHIP09876");
    }

    @Then("the current location of the shipment is displayed as \"Distribution Center B\"")
    public void theCurrentLocationOfTheShipmentIsDisplayed() {
        verifyCurrentLocation("Distribution Center B");
    }

    @Then("the current location is accurately displayed as \"Distribution Center B\"")
    public void theCurrentLocationIsAccuratelyDisplayed() {
        verifyCurrentLocation("Distribution Center B");
    }

    @Then("the estimated delivery time is displayed as \"3 hours\"")
    public void theEstimatedDeliveryTimeIsDisplayed() {
        verifyEstimatedDeliveryTime("3 hours");
    }

    @Then("the estimated delivery time is shown as \"3 hours\"")
    public void theEstimatedDeliveryTimeIsShown() {
        verifyEstimatedDeliveryTime("3 hours");
    }

    @When("the user waits for 5 minutes and refreshes the page")
    public void theUserWaitsAndRefreshesThePage() {
        waitForMinutes(5);
        refreshPage();
    }

    @Then("any changes in location or delivery time are updated in real-time")
    public void anyChangesAreUpdatedInRealTime() {
        verifyRealTimeUpdates();
    }

    @When("the user logs out of the customer account")
    public void theUserLogsOutOfTheCustomerAccount() {
        logout();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}