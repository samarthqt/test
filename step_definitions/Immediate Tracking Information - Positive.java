package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackingPage;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has a valid customer account with Customer ID \"CUST33445\"")
    public void aUserHasAValidCustomerAccountWithCustomerID() {
        String customerId = "CUST33445";
        verifyCustomerAccount(customerId);
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccountUsingValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsSuccessfullyLoggedInToTheirAccount() {
        verifyLoginSuccess();
    }

    @Given("the shipment with Shipment ID \"SHIP66778\" is in transit")
    public void theShipmentWithShipmentIDIsInTransit() {
        String shipmentId = "SHIP66778";
        verifyShipmentInTransit(shipmentId);
    }

    @When("the user navigates to the \"Track Shipment\" section")
    public void theUserNavigatesToTheTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the \"Track Shipment\" section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP66778\" in the search bar")
    public void theUserEntersTheShipmentIDInTheSearchBar() {
        String shipmentId = "SHIP66778";
        enterShipmentIdInSearchBar(shipmentId);
    }

    @Then("the shipment details are displayed for \"SHIP66778\"")
    public void theShipmentDetailsAreDisplayedFor() {
        String shipmentId = "SHIP66778";
        verifyShipmentDetailsDisplayed(shipmentId);
    }

    @Then("the current status of the shipment is displayed as \"Out for Delivery\"")
    public void theCurrentStatusOfTheShipmentIsDisplayedAs() {
        String expectedStatus = "Out for Delivery";
        verifyShipmentStatus(expectedStatus);
    }

    @When("the user refreshes the page to check for immediate updates")
    public void theUserRefreshesThePageToCheckForImmediateUpdates() {
        refreshPage();
    }

    @Then("the tracking information updates immediately to reflect any changes")
    public void theTrackingInformationUpdatesImmediatelyToReflectAnyChanges() {
        verifyTrackingInformationUpdates();
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