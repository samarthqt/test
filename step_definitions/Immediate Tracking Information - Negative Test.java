package com.cucumber.steps;

import com.page_objects.TrackingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackingSteps extends TrackingPage {

    @Given("the user has a valid customer account with Customer ID \"CUST55667\"")
    public void theUserHasAValidCustomerAccount() {
        verifyCustomerAccount("CUST55667");
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccount() {
        loginToAccount();
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

    @When("the user enters the Invalid Shipment ID \"SHIP99999\" in the search bar")
    public void theUserEntersInvalidShipmentID() {
        enterShipmentID("SHIP99999");
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
    public void theUserLogsOutOfTheCustomerAccount() {
        logoutOfAccount();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}