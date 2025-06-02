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
        // Assume user account is valid
    }

    @When("the user logs in using valid credentials")
    public void theUserLogsInUsingValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("the user is successfully logged into their account")
    public void theUserIsSuccessfullyLoggedIntoTheirAccount() {
        verifyLoginSuccess();
    }

    @Given("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTheTrackShipmentSection() {
        navigateToTrackShipment();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the long shipment ID \"SHIP12345678901234567890\" in the search bar")
    public void theUserEntersTheLongShipmentIDInTheSearchBar() {
        enterShipmentID("SHIP12345678901234567890");
    }

    @Then("the system processes the input without crashing or displaying errors")
    public void theSystemProcessesTheInputWithoutCrashingOrDisplayingErrors() {
        verifySystemHandlesLongID();
    }

    @When("the system provides feedback or an error message for the long ID")
    public void theSystemProvidesFeedbackOrAnErrorMessageForTheLongID() {
        checkForFeedbackOrErrorMessage();
    }

    @Then("the system either displays an error message or handles the input gracefully")
    public void theSystemEitherDisplaysAnErrorMessageOrHandlesTheInputGracefully() {
        verifyErrorMessageOrGracefulHandling();
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