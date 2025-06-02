package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackingPage;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID {string}")
    public void theUserHasAValidCustomerAccountWithCustomerID(String customerId) {
        verifyCustomerAccount(customerId);
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

    @And("a shipment with Shipment ID {string} is in transit")
    public void aShipmentWithShipmentIDIsInTransit(String shipmentId) {
        verifyShipmentInTransit(shipmentId);
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTheTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID {string} in the search bar")
    public void theUserEntersTheShipmentIDInTheSearchBar(String shipmentId) {
        enterShipmentIdInSearchBar(shipmentId);
    }

    @Then("the shipment details are displayed for {string}")
    public void theShipmentDetailsAreDisplayedFor(String shipmentId) {
        verifyShipmentDetailsDisplayed(shipmentId);
    }

    @And("the current status of the shipment is displayed as 'In Transit'")
    public void theCurrentStatusOfTheShipmentIsDisplayedAsInTransit() {
        verifyShipmentStatusInTransit();
    }

    @When("the user refreshes the tracking information")
    public void theUserRefreshesTheTrackingInformation() {
        refreshTrackingInformation();
    }

    @Then("the tracking information updates immediately to reflect real-time changes")
    public void theTrackingInformationUpdatesImmediatelyToReflectRealTimeChanges() {
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