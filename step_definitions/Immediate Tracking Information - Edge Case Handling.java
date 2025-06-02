package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackShipmentPage;

public class TrackShipmentSteps extends TrackShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid customer account with Customer ID {string}")
    public void theUserHasAValidCustomerAccountWithCustomerID(String customerID) {
        testHarness.setData("CustomerData", "CustomerID", customerID);
    }

    @When("the user logs in to the customer account using valid credentials")
    public void theUserLogsInToTheCustomerAccountUsingValidCredentials() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToAccount(userName, password);
    }

    @Then("the user is successfully logged in to their account")
    public void theUserIsSuccessfullyLoggedInToTheirAccount() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the {string} section")
    public void theUserNavigatesToTheSection(String sectionName) {
        navigateToSection(sectionName);
    }

    @Then("the {string} section is displayed")
    public void theSectionIsDisplayed(String sectionName) {
        verifySectionDisplayed(sectionName);
    }

    @When("the user enters the Long Shipment ID {string} in the search bar")
    public void theUserEntersTheLongShipmentIDInTheSearchBar(String shipmentID) {
        enterShipmentID(shipmentID);
    }

    @Then("the system processes the input without crashing or displaying errors")
    public void theSystemProcessesTheInputWithoutCrashingOrDisplayingErrors() {
        verifyInputProcessing();
    }

    @When("the user checks for system feedback or error message for the long ID")
    public void theUserChecksForSystemFeedbackOrErrorMessageForTheLongID() {
        checkForFeedbackOrErrorMessage();
    }

    @Then("the system either displays an error message or handles the input gracefully")
    public void theSystemEitherDisplaysAnErrorMessageOrHandlesTheInputGracefully() {
        verifyErrorMessageOrGracefulHandling();
    }

    @When("the user logs out of the customer account")
    public void theUserLogsOutOfTheCustomerAccount() {
        logoutFromAccount();
    }

    @Then("the user is successfully logged out")
    public void theUserIsSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }
}