package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class TrafficSimulationPage extends WebReusableComponents {

    protected By trafficTool = By.id("trafficTool");
    protected By userCountInput = By.id("userCount");
    protected By serverLoadInput = By.id("serverLoad");
    protected By applicationLink = By.id("applicationLink");
    protected By homepage = By.id("homepage");
    protected By loadTimeDisplay = By.id("loadTimeDisplay");
    protected By errorMessages = By.cssSelector(".error-message");
    protected By loadingIndicators = By.cssSelector(".loading-indicator");
    protected By responsivenessCheck = By.id("responsivenessCheck");
    protected By logResultsButton = By.id("logResults");
    protected By resetButton = By.id("resetButton");

    public TrafficSimulationPage() {
        PageFactory.initElements(driver, this);
    }

    public void openTrafficSimulationTool() {
        waitUntilElementVisible(trafficTool, 3);
        clickElement(trafficTool);
    }

    public void setUserCount(int userCount) {
        waitUntilElementVisible(userCountInput, 3);
        enterText(userCountInput, String.valueOf(userCount));
    }

    public void setServerLoad(int loadPercentage) {
        waitUntilElementVisible(serverLoadInput, 3);
        enterText(serverLoadInput, String.valueOf(loadPercentage));
    }

    public void openApplication() {
        waitUntilElementVisible(applicationLink, 3);
        clickElement(applicationLink);
    }

    public void loadHomepage() {
        waitUntilElementVisible(homepage, 3);
        clickElement(homepage);
    }

    public void measureHomepageLoadTime() {
        waitUntilElementVisible(loadTimeDisplay, 3);
        String loadTime = getTextFromElement(loadTimeDisplay);
        System.out.println("Load Time: " + loadTime);
    }

    public void verifyLoadTimeWithin(int seconds) {
        String loadTime = getTextFromElement(loadTimeDisplay);
        Assert.assertTrue(Integer.parseInt(loadTime) <= seconds, "Load time exceeds " + seconds + " seconds.");
    }

    public void observeErrorsOrIndicators() {
        boolean errorsPresent = isElementPresent(errorMessages);
        boolean indicatorsPresent = isElementPresent(loadingIndicators);
        Assert.assertFalse(errorsPresent, "Error messages are displayed.");
        Assert.assertFalse(indicatorsPresent, "Loading indicators are displayed.");
    }

    public void checkResponsiveness() {
        boolean isResponsive = isElementPresent(responsivenessCheck);
        Assert.assertTrue(isResponsive, "Application is not responsive during loading.");
    }

    public void logSimulationResults() {
        waitUntilElementVisible(logResultsButton, 3);
        clickElement(logResultsButton);
    }

    public void resetTrafficConditions() {
        waitUntilElementVisible(resetButton, 3);
        clickElement(resetButton);
    }

    public void analyzeTrafficImpact() {
        // Example logic to analyze traffic impact
        List<WebElement> errors = getWebElementList(errorMessages);
        List<WebElement> indicators = getWebElementList(loadingIndicators);
        Assert.assertTrue(errors.isEmpty() && indicators.isEmpty(), "Traffic impact analysis shows issues.");
    }

    public void documentIssues() {
        // Example logic to document issues
        List<WebElement> errors = getWebElementList(errorMessages);
        for (WebElement error : errors) {
            System.out.println("Documented Issue: " + error.getText());
        }
    }

    public void provideLoadSpeedRecommendations() {
        // Example logic to provide recommendations
        String loadTime = getTextFromElement(loadTimeDisplay);
        if (Integer.parseInt(loadTime) > 5) {
            System.out.println("Recommendation: Optimize images and scripts to improve load speed.");
        }
    }

    public void ensureOptimalPerformance() {
        // Example logic to ensure optimal performance
        checkResponsiveness();
        verifyLoadTimeWithin(5);
    }
}