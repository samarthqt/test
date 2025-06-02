package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackingPage;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST33445\"")
    public void theUserHasAValidCustomerAccount() {
        String customerId = "CUST33445";
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

    @Given("the shipment is in transit with Shipment ID \"SHIP66778\"")
    public void theShipmentIsInTransit() {
        String shipmentId = "SHIP66778";
        verifyShipmentInTransit(shipmentId);
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP66778\" in the search bar")
    public void theUserEntersShipmentIDInSearchBar() {
        String shipmentId = "SHIP66778";
        enterShipmentIDInSearchBar(shipmentId);
    }

    @Then("shipment details are displayed for \"SHIP66778\"")
    public void shipmentDetailsAreDisplayed() {
        verifyShipmentDetailsDisplayed("SHIP66778");
    }

    @Then("the current status of the shipment is displayed as \"Out for Delivery\"")
    public void theCurrentStatusOfShipmentIsDisplayed() {
        verifyShipmentStatus("Out for Delivery");
    }

    @Then("the current status is accurately displayed as \"Out for Delivery\"")
    public void theCurrentStatusIsAccuratelyDisplayed() {
        verifyAccurateShipmentStatus("Out for Delivery");
    }

    @When("the user refreshes the page to check for immediate updates")
    public void theUserRefreshesThePage() {
        refreshPageForUpdates();
    }

    @Then("tracking information updates immediately to reflect any changes")
    public void trackingInformationUpdatesImmediately() {
        verifyImmediateTrackingUpdates();
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