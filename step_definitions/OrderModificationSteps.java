package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.OrderModificationPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class OrderModificationSteps extends OrderModificationPage {

    @Given("user logs into the SAP S/4HANA system using valid credentials")
    public void userLogsIntoTheSystem() {
        loginToSystem("validUsername", "validPassword");
    }

    @Given("user navigates to the Sales Order processing screen")
    public void userNavigatesToSalesOrderProcessingScreen() {
        navigateToSalesOrderScreen();
    }

    @When("user searches for the order using {string}")
    public void userSearchesForTheOrderUsing(String uniqueOrderID) {
        searchOrder(uniqueOrderID);
    }

    @Then("system displays an error message {string}")
    public void systemDisplaysAnErrorMessage(String errorMessage) {
        verifyErrorMessage(errorMessage);
    }

    @When("user attempts to modify the order details with {string}")
    public void userAttemptsToModifyTheOrderDetailsWith(String updatedOrderDetails) {
        modifyOrderDetails(updatedOrderDetails);
    }

    @Then("system prevents changes and displays an error message {string}")
    public void systemPreventsChangesAndDisplaysAnErrorMessage(String modificationErrorMessage) {
        verifyModificationErrorMessage(modificationErrorMessage);
    }

    @When("user checks the system logs for errors related to {string}")
    public void userChecksTheSystemLogsForErrorsRelatedTo(String uniqueOrderID) {
        checkSystemLogs(uniqueOrderID);
    }

    @Then("logs indicate the error {string}")
    public void logsIndicateTheError(String logError) {
        verifyLogError(logError);
    }

    @When("user attempts to save the changes")
    public void userAttemptsToSaveTheChanges() {
        attemptToSaveChanges();
    }

    @Then("system prevents saving and displays an error message {string}")
    public void systemPreventsSavingAndDisplaysAnErrorMessage(String saveErrorMessage) {
        verifySaveErrorMessage(saveErrorMessage);
    }

    @Then("user logs out of the system")
    public void userLogsOutOfTheSystem() {
        logoutFromSystem();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }
}