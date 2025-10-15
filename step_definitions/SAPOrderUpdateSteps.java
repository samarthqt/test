package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.SAPOrderUpdatePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SAPOrderUpdateSteps extends SAPOrderUpdatePage {

    @Given("the user has valid SAP credentials")
    public void theUserHasValidSAPCredentials() {
        enterSAPCredentials("validUsername", "validPassword");
    }

    @When("the user logs in to the SAP S/4HANA system")
    public void theUserLogsInToTheSAPSystem() {
        loginToSAP();
    }

    @Then("the user is successfully logged in and navigates to the SAP home screen")
    public void theUserIsSuccessfullyLoggedIn() {
        verifySAPHomeScreen();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoSAP() {
        verifySAPLogin();
    }

    @When("the user navigates to the job scheduling module")
    public void theUserNavigatesToJobSchedulingModule() {
        navigateToJobSchedulingModule();
    }

    @When("the user configures a background job to poll the EC2 path for the file")
    public void theUserConfiguresBackgroundJob() {
        configureBackgroundJob("EC2Path", "parameters");
    }

    @Then("the background job is configured successfully with the correct path and parameters")
    public void theBackgroundJobIsConfiguredSuccessfully() {
        verifyBackgroundJobConfiguration();
    }

    @Given("a pipe-delimited file with updated sales order data is prepared")
    public void aPipeDelimitedFileIsPrepared() {
        preparePipeDelimitedFile("salesOrderData");
    }

    @When("the user places the prepared file in the specified EC2 path")
    public void theUserPlacesFileInEC2Path() {
        placeFileInEC2Path("preparedFile");
    }

    @Then("the file is successfully placed in the EC2 path")
    public void theFileIsSuccessfullyPlaced() {
        verifyFilePlacement("EC2Path");
    }

    @Given("the background job is configured with the correct path and parameters")
    public void theBackgroundJobIsConfigured() {
        verifyBackgroundJobConfiguration();
    }

    @When("the user executes the background job")
    public void theUserExecutesBackgroundJob() {
        executeBackgroundJob();
    }

    @Then("the system retrieves the file and begins processing the data")
    public void theSystemRetrievesFileAndProcessesData() {
        verifyFileProcessing();
    }

    @Given("the system retrieves the file from the EC2 path")
    public void theSystemRetrievesFileFromEC2Path() {
        retrieveFileFromEC2Path("EC2Path");
    }

    @When("the system matches the Unique Order ID in the file with existing sales orders")
    public void theSystemMatchesUniqueOrderID() {
        matchUniqueOrderID("fileData");
    }

    @When("the system updates the sales order data with the new values from the file")
    public void theSystemUpdatesSalesOrderData() {
        updateSalesOrderData("fileData");
    }

    @Then("the sales orders are updated with the correct quantity, price, and other details")
    public void theSalesOrdersAreUpdatedCorrectly() {
        verifySalesOrderUpdates("quantity", "price", "details");
    }

    @Then("the system logs indicate successful processing with no errors or warnings")
    public void theSystemLogsIndicateSuccess() {
        verifySystemLogs("success");
    }

    @Then("the updated sales orders are visible in the sales module")
    public void theUpdatedSalesOrdersAreVisible() {
        verifySalesModuleUpdates();
    }

    @Then("the changes are reflected in the database tables {string}")
    public void theChangesAreReflectedInDatabaseTables(String databaseTable) {
        verifyDatabaseUpdates(databaseTable);
    }

    @Then("the report confirms the accuracy of the updated sales order data")
    public void theReportConfirmsAccuracy() {
        verifyReportAccuracy();
    }

    @Given("the system has processed the file")
    public void theSystemHasProcessedFile() {
        verifyFileProcessing();
    }

    @When("the user verifies the updated sales orders")
    public void theUserVerifiesUpdatedSalesOrders() {
        verifyUpdatedSalesOrders();
    }

    @Then("no duplicate or erroneous updates are found in the system")
    public void noDuplicateOrErroneousUpdatesAreFound() {
        verifyNoDuplicateUpdates();
    }

    @Given("the sales orders are successfully updated")
    public void theSalesOrdersAreSuccessfullyUpdated() {
        verifySalesOrderUpdates("quantity", "price", "details");
    }

    @When("the user checks the notification system")
    public void theUserChecksNotificationSystem() {
        checkNotificationSystem();
    }

    @Then("notifications are sent successfully to relevant stakeholders confirming the update process")
    public void notificationsAreSentSuccessfully() {
        verifyNotificationsSent();
    }
}