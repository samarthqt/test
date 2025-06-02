package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class PerformanceTestPage extends WebReusableComponents {

    protected By userSimulationTool = By.id("userSimulationTool");
    protected By userCountInput = By.id("userCountInput");
    protected By applicationTestDevice = By.id("applicationTestDevice");
    protected By operationStatus = By.id("operationStatus");
    protected By responseTime = By.id("responseTime");
    protected By performanceMetrics = By.id("performanceMetrics");
    protected By errorMessages = By.id("errorMessages");
    protected By applicationResponsiveness = By.id("applicationResponsiveness");
    protected By logResultsButton = By.id("logResultsButton");
    protected By resetConditionsButton = By.id("resetConditionsButton");
    protected By repeatTestButton = By.id("repeatTestButton");
    protected By analyzeImpactButton = By.id("analyzeImpactButton");
    protected By documentDiscrepanciesButton = By.id("documentDiscrepanciesButton");
    protected By provideRecommendationsButton = By.id("provideRecommendationsButton");
    protected By ensureOptimalPerformanceButton = By.id("ensureOptimalPerformanceButton");

    public PerformanceTestPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchApplication() {
        driver.get(getAppUrl());
        maximizeWindow();
        Assert.assertTrue(driver.getTitle().contains("Application"), "Application did not launch successfully.");
    }

    public void openUserSimulationTool() {
        waitUntilElementVisible(userSimulationTool, 3);
        clickElement(userSimulationTool);
        Assert.assertTrue(elementVisible(userCountInput), "User Simulation Tool did not open.");
    }

    public void setConcurrentUserCount(int userCount) {
        waitUntilElementVisible(userCountInput, 3);
        enterText(userCountInput, String.valueOf(userCount));
        verifyConcurrentUserCount(userCount);
    }

    public void verifyConcurrentUserCount(int userCount) {
        String actualUserCount = getTextFromElement(userCountInput);
        Assert.assertEquals(actualUserCount, String.valueOf(userCount), "User count is not set correctly.");
    }

    public void openApplicationOnTestDevice() {
        waitUntilElementVisible(applicationTestDevice, 3);
        clickElement(applicationTestDevice);
        Assert.assertTrue(elementVisible(operationStatus), "Application did not open on test device.");
    }

    public void performOperations() {
        // Logic to perform operations like login, navigation, and data retrieval
        Assert.assertTrue(elementVisible(operationStatus), "Operations were not performed successfully.");
    }

    public void verifyOperationsAttempted() {
        String status = getTextFromElement(operationStatus);
        Assert.assertTrue(status.contains("Success"), "Operations were not attempted successfully.");
    }

    public void measureResponseTime() {
        waitUntilElementVisible(responseTime, 3);
        String time = getTextFromElement(responseTime);
        Assert.assertNotNull(time, "Response time measurement failed.");
    }

    public void checkPerformanceMetrics() {
        waitUntilElementVisible(performanceMetrics, 3);
        List<WebElement> metrics = getWebElementList(performanceMetrics);
        Assert.assertFalse(metrics.isEmpty(), "Performance metrics are not available.");
    }

    public void observeErrorsOrIssues() {
        waitUntilElementVisible(errorMessages, 3);
        List<WebElement> errors = getWebElementList(errorMessages);
        Assert.assertTrue(errors.isEmpty(), "Errors or issues were observed.");
    }

    public void checkApplicationResponsiveness() {
        waitUntilElementVisible(applicationResponsiveness, 3);
        String responsiveness = getTextFromElement(applicationResponsiveness);
        Assert.assertTrue(responsiveness.contains("Responsive"), "Application is not responsive.");
    }

    public void logResults() {
        waitUntilElementVisible(logResultsButton, 3);
        clickElement(logResultsButton);
        Assert.assertTrue(elementVisible(performanceMetrics), "Results were not logged successfully.");
    }

    public void resetSimulationConditions() {
        waitUntilElementVisible(resetConditionsButton, 3);
        clickElement(resetConditionsButton);
        Assert.assertTrue(elementVisible(userCountInput), "Simulation conditions were not reset.");
    }

    public void repeatTestWithDifferentUserCounts() {
        waitUntilElementVisible(repeatTestButton, 3);
        clickElement(repeatTestButton);
        Assert.assertTrue(elementVisible(userCountInput), "Test was not repeated with different user counts.");
    }

    public void analyzeImpact() {
        waitUntilElementVisible(analyzeImpactButton, 3);
        clickElement(analyzeImpactButton);
        Assert.assertTrue(elementVisible(performanceMetrics), "Impact analysis failed.");
    }

    public void documentDiscrepancies() {
        waitUntilElementVisible(documentDiscrepanciesButton, 3);
        clickElement(documentDiscrepanciesButton);
        Assert.assertTrue(elementVisible(errorMessages), "Discrepancies were not documented.");
    }

    public void provideRecommendations() {
        waitUntilElementVisible(provideRecommendationsButton, 3);
        clickElement(provideRecommendationsButton);
        Assert.assertTrue(elementVisible(performanceMetrics), "Recommendations were not provided.");
    }

    public void ensureOptimalPerformance() {
        waitUntilElementVisible(ensureOptimalPerformanceButton, 3);
        clickElement(ensureOptimalPerformanceButton);
        Assert.assertTrue(elementVisible(performanceMetrics), "Optimal performance was not ensured.");
    }
}