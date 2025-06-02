package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account")
    public void theUserHasAValidCustomerAccount() {
        verifyCustomerAccount();
    }

    @Given("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccountUsingValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTheTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @Then("the shipment with ID \"SHIP67890\" is in transit")
    public void theShipmentWithIDIsInTransit() {
        verifyShipmentInTransit("SHIP67890");
    }

    @When("the user enters the Shipment ID \"SHIP67890\" in the search bar")
    public void theUserEntersTheShipmentIDInTheSearchBar() {
        enterShipmentID("SHIP67890");
    }

    @Then("the shipment details are displayed for \"SHIP67890\"")
    public void theShipmentDetailsAreDisplayedFor() {
        verifyShipmentDetailsDisplayed("SHIP67890");
    }

    @Then("the current location of the shipment is displayed as \"Warehouse A\"")
    public void theCurrentLocationOfTheShipmentIsDisplayedAs() {
        verifyCurrentLocationDisplayed("Warehouse A");
    }

    @Then("the estimated delivery time is displayed as \"2 hours\"")
    public void theEstimatedDeliveryTimeIsDisplayedAs() {
        verifyEstimatedDeliveryTimeDisplayed("2 hours");
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        refreshPage();
    }

    @Then("any changes in location or delivery time are updated in real-time")
    public void anyChangesInLocationOrDeliveryTimeAreUpdatedInRealTime() {
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