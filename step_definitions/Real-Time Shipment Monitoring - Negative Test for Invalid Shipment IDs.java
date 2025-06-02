package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST98765\"")
    public void theUserHasAValidCustomerAccount() {
        String customerId = testHarness.getData("CustomerData", "CustomerID");
        verifyCustomerAccount(customerId);
    }

    @When("the user logs in using valid credentials")
    public void theUserLogsInUsingValidCredentials() {
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

    @When("the user enters the Invalid Shipment ID \"SHIP00000\" in the search bar")
    public void theUserEntersInvalidShipmentID() {
        String invalidShipmentId = testHarness.getData("ShipmentData", "InvalidShipmentID");
        enterShipmentID(invalidShipmentId);
    }

    @Then("the system displays an error message indicating the shipment ID is invalid")
    public void theSystemDisplaysErrorMessage() {
        verifyInvalidShipmentIDErrorMessage();
    }

    @When("the user attempts to refresh the page")
    public void theUserAttemptsToRefreshThePage() {
        refreshPage();
    }

    @Then("the error message persists and no shipment details are displayed")
    public void theErrorMessagePersists() {
        verifyErrorMessagePersists();
    }

    @When("the user logs out of the customer account")
    public void theUserLogsOut() {
        logout();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}