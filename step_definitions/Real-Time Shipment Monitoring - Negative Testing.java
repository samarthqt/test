package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentMonitoringSteps extends ShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user logs into the customer account using valid credentials")
    public void theUserLogsIntoTheCustomerAccountUsingValidCredentials() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

    @Given("the user has Customer ID \"CUST98765\"")
    public void theUserHasCustomerID() {
        verifyCustomerID("CUST98765");
    }

    @When("the user navigates to the \"Track Shipment\" section")
    public void theUserNavigatesToTheTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the \"Track Shipment\" section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the invalid shipment ID \"SHIP00000\" in the search bar")
    public void theUserEntersTheInvalidShipmentIDInTheSearchBar() {
        enterShipmentID("SHIP00000");
    }

    @Then("the system displays an error message indicating the shipment ID is invalid")
    public void theSystemDisplaysAnErrorMessageIndicatingTheShipmentIDIsInvalid() {
        verifyErrorMessageDisplayed("Invalid shipment ID.");
    }

    @When("the user attempts to refresh the page")
    public void theUserAttemptsToRefreshThePage() {
        refreshPage();
    }

    @Then("the error message persists and no shipment details are displayed")
    public void theErrorMessagePersistsAndNoShipmentDetailsAreDisplayed() {
        verifyErrorMessagePersists();
        verifyNoShipmentDetailsDisplayed();
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