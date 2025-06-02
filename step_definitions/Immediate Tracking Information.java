package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackingPage;

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

    @Given("the shipment with Shipment ID \"SHIP44556\" is in transit")
    public void theShipmentIsInTransit() {
        String shipmentId = "SHIP44556";
        verifyShipmentInTransit(shipmentId);
    }

    @When("the user navigates to the \"Track Shipment\" section")
    public void theUserNavigatesToTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the \"Track Shipment\" section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the Shipment ID \"SHIP44556\" in the search bar")
    public void theUserEntersShipmentIDInSearchBar() {
        String shipmentId = "SHIP44556";
        enterShipmentIDInSearchBar(shipmentId);
    }

    @Then("the shipment details are displayed for \"SHIP44556\"")
    public void theShipmentDetailsAreDisplayed() {
        verifyShipmentDetailsDisplayed("SHIP44556");
    }

    @And("the current status of the shipment is displayed as \"In Transit\"")
    public void theCurrentStatusIsDisplayedAsInTransit() {
        verifyCurrentStatus("In Transit");
    }

    @Then("the current status is accurately displayed as \"In Transit\"")
    public void theCurrentStatusIsAccuratelyDisplayed() {
        verifyAccurateStatus("In Transit");
    }

    @When("the user refreshes the tracking information")
    public void theUserRefreshesTrackingInformation() {
        refreshTrackingInformation();
    }

    @Then("the tracking information updates immediately to reflect real-time changes")
    public void theTrackingInformationUpdatesImmediately() {
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