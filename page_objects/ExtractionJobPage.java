package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ExtractionJobPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By jobStatus = By.id("jobStatus");
    protected By errorMessage = By.id("errorMessage");
    protected By activateJobButton = By.id("activateJobButton");

    public void verifyUserCredentials() {
        Assert.assertTrue(isElementVisible(txtUsername), "Username field is not visible.");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible.");
    }

    public void loginToSAPCloud() {
        enterText(txtUsername, "testUser");
        enterText(txtPassword, "testPassword");
        clickElement(btnLogin);
    }

    public void verifySuccessfulLogin() {
        Assert.assertTrue(isElementVisible(By.id("dashboard")), "Dashboard is not visible, login failed.");
    }

    public void verifyModuleAccess() {
        Assert.assertTrue(isElementVisible(By.id("modules")), "Relevant modules are not accessible.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(By.id("dashboard")), "User is not logged in.");
    }

    public void navigateToExtractionJobSchedule() {
        clickElement(By.id("jobSchedule"));
    }

    public void verifyExtractionJobInactive() {
        String status = getTextFromElement(jobStatus);
        Assert.assertEquals(status, "Inactive", "Extraction job is not inactive.");
    }

    public void verifyDataSimulationSupport() {
        Assert.assertTrue(isElementVisible(By.id("dataSimulation")), "Data simulation is not supported.");
    }

    public void generateSimulatedSalesData() {
        clickElement(By.id("simulateData"));
    }

    public void verifySimulatedDataGeneration() {
        Assert.assertTrue(isElementVisible(By.id("simulationSuccess")), "Simulated data generation failed.");
    }

    public void monitorSystemLogs() {
        clickElement(By.id("systemLogs"));
    }

    public void verifyNoExtractionJobTriggeredInLogs() {
        String logs = getTextFromElement(By.id("logs"));
        Assert.assertFalse(logs.contains("Extraction job triggered"), "Extraction job was triggered.");
    }

    public void attemptToTriggerExtractionJob() {
        clickElement(By.id("triggerJob"));
    }

    public void verifyTriggerRestriction() {
        Assert.assertTrue(isElementVisible(errorMessage), "Error message is not displayed.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void attemptToTriggerInactiveJob() {
        clickElement(By.id("triggerInactiveJob"));
    }

    public void verifyErrorMessageDisplayed() {
        Assert.assertTrue(isElementVisible(errorMessage), "Error message is not displayed.");
    }

    public void verifyInactiveJobErrorMessage() {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains("inactive"), "Error message does not indicate inactive job.");
    }

    public void verifyActivationOptionFromErrorMessage() {
        Assert.assertTrue(isElementVisible(activateJobButton), "Activation option is not available.");
    }

    public void activateExtractionJobFromErrorMessage() {
        clickElement(activateJobButton);
    }

    public void reTriggerExtractionProcess() {
        clickElement(By.id("reTriggerProcess"));
    }

    public void verifyExtractionJobActivation() {
        String status = getTextFromElement(jobStatus);
        Assert.assertEquals(status, "Active", "Extraction job activation failed.");
    }

    public void verifyProcessReTrigger() {
        Assert.assertTrue(isElementVisible(By.id("processSuccess")), "Process re-trigger failed.");
    }

    public void interactWithSystem() {
        clickElement(By.id("systemInteraction"));
    }

    public void verifyErrorHandlingMechanism() {
        Assert.assertTrue(isElementVisible(By.id("errorHandled")), "System did not handle the error gracefully.");
    }

    public void checkDataTransmissionToModelN() {
        clickElement(By.id("checkModelNTransmission"));
    }

    public void verifyNoDataTransmissionToModelN() {
        String transmissionStatus = getTextFromElement(By.id("transmissionStatus"));
        Assert.assertEquals(transmissionStatus, "No Data", "Data was transmitted to Model N.");
    }

    public void loginToModelN() {
        enterText(txtUsername, "modelNUser");
        enterText(txtPassword, "modelNPassword");
        clickElement(btnLogin);
    }

    public void verifyNoDataProcessingInModelN() {
        Assert.assertFalse(isElementVisible(By.id("dataProcessing")), "Data processing activity is displayed in Model N.");
    }

    public void completeTestForInactiveJob() {
        Assert.assertTrue(isElementVisible(By.id("testCompleted")), "Test completion is not confirmed.");
    }

    public void documentTestResults() {
        clickElement(By.id("documentResults"));
    }

    public void verifyTestResultsHighlightBehavior() {
        String results = getTextFromElement(By.id("testResults"));
        Assert.assertTrue(results.contains("inactive"), "Test results do not highlight system behavior for inactive job.");
    }
}