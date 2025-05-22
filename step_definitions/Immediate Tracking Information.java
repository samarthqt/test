package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST11223\"")
    public void theUserHasAValidCustomerAccount() {
        String customerId = "CUST11223";
        verifyCustomerAccount(customerId);
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

    @Given("the shipment is in transit")
    public void theShipmentIsInTransit() {
        verifyShipmentInTransit();
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP44556\" in the search bar")
    public void theUserEntersTheShipmentID() {
        String shipmentId = "SHIP44556";
        enterShipmentID(shipmentId);
    }

    @Then("shipment details are displayed for \"SHIP44556\"")
    public void shipmentDetailsAreDisplayed() {
        verifyShipmentDetailsDisplayed("SHIP44556");
    }

    @Then("the current status of the shipment is displayed as \"In Transit\"")
    public void theCurrentStatusOfTheShipmentIsDisplayed() {
        verifyShipmentStatus("In Transit");
    }

    @Then("the current status is accurately displayed as \"In Transit\"")
    public void theCurrentStatusIsAccuratelyDisplayed() {
        verifyAccurateShipmentStatus("In Transit");
    }

    @When("the user refreshes the tracking information")
    public void theUserRefreshesTheTrackingInformation() {
        refreshTrackingInformation();
    }

    @Then("the tracking information updates immediately to reflect real-time changes")
    public void theTrackingInformationUpdatesImmediately() {
        verifyRealTimeTrackingUpdates();
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