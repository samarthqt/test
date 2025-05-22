package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST55667\"")
    public void theUserHasAValidCustomerAccount() {
        String customerId = testHarness.getData("CustomerData", "CustomerID");
        verifyCustomerAccount(customerId);
    }

    @When("the user logs in using valid credentials")
    public void theUserLogsInUsingValidCredentials() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(userName, password);
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the \"Track Shipment\" section")
    public void theUserNavigatesToTrackShipmentSection() {
        navigateToTrackShipment();
    }

    @Then("the \"Track Shipment\" section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the invalid Shipment ID \"SHIP99999\" in the search bar")
    public void theUserEntersInvalidShipmentID() {
        String shipmentId = testHarness.getData("ShipmentData", "InvalidShipmentID");
        enterShipmentID(shipmentId);
    }

    @Then("the system displays an error message indicating the shipment ID is invalid")
    public void theSystemDisplaysAnErrorMessage() {
        verifyInvalidShipmentIDErrorMessage();
    }

    @When("the user attempts to refresh the page")
    public void theUserAttemptsToRefreshThePage() {
        refreshPage();
    }

    @Then("the error message persists, and no shipment details are displayed")
    public void theErrorMessagePersists() {
        verifyErrorMessagePersists();
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