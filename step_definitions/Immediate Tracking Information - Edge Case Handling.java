package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID \"CUST77889\"")
    public void theUserHasAValidCustomerAccount() {
        String customerId = testHarness.getData("CustomerData", "CustomerID");
        verifyCustomerAccount(customerId);
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccount() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToAccount(userName, password);
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

    @When("the user enters the Long Shipment ID \"SHIP12345678901234567890\" in the search bar")
    public void theUserEntersLongShipmentID() {
        String shipmentId = testHarness.getData("ShipmentData", "LongShipmentID");
        enterShipmentID(shipmentId);
    }

    @Then("the system processes the input without crashing or displaying errors")
    public void theSystemProcessesInputWithoutErrors() {
        verifyInputProcessing();
    }

    @When("the user checks if the system provides any feedback or error message for the long ID")
    public void theUserChecksForFeedbackOrErrorMessage() {
        checkForFeedbackOrErrorMessage();
    }

    @Then("the system either displays an error message or handles the input gracefully")
    public void theSystemHandlesInputGracefully() {
        verifyGracefulHandlingOrErrorMessage();
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