package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentMonitoringSteps extends ShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account")
    public void theUserHasAValidCustomerAccount() {
        // Assume user account is valid
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccountUsingValidCredentials() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsSuccessfullyLoggedInToTheirAccount() {
        verifyLoginSuccess();
    }

    @Given("the user is logged in to their account")
    public void theUserIsLoggedInToTheirAccount() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Track Shipment' section")
    public void theUserNavigatesToTheTrackShipmentSection() {
        navigateToTrackShipmentSection();
    }

    @Then("the 'Track Shipment' section is displayed")
    public void theTrackShipmentSectionIsDisplayed() {
        verifyTrackShipmentSectionDisplayed();
    }

    @Given("the user is in the 'Track Shipment' section")
    public void theUserIsInTheTrackShipmentSection() {
        verifyTrackShipmentSectionDisplayed();
    }

    @When("the user enters the long shipment ID \"SHIP12345678901234567890\" in the search bar")
    public void theUserEntersTheLongShipmentIDInTheSearchBar() {
        enterShipmentID("SHIP12345678901234567890");
    }

    @Then("the system processes the input without crashing or displaying errors")
    public void theSystemProcessesTheInputWithoutCrashingOrDisplayingErrors() {
        verifyShipmentIDProcessing();
    }

    @Given("the user has entered a long shipment ID")
    public void theUserHasEnteredALongShipmentID() {
        enterShipmentID("SHIP12345678901234567890");
    }

    @When("the system processes the input")
    public void theSystemProcessesTheInput() {
        verifyShipmentIDProcessing();
    }

    @Then("the system either displays an error message or handles the input gracefully")
    public void theSystemEitherDisplaysAnErrorMessageOrHandlesTheInputGracefully() {
        verifyShipmentIDFeedback();
    }

    @Given("the user is logged in to their account")
    public void theUserIsLoggedInToTheirAccountAgain() {
        verifyLoginSuccess();
    }

    @When("the user logs out of the customer account")
    public void theUserLogsOutOfTheCustomerAccount() {
        clickLogoutButton();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}