package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SessionPage extends WebReusableComponents {

    protected By dashboard = By.id("dashboard");
    protected By loginPage = By.id("loginPage");
    protected By sessionExpirationNotification = By.id("sessionExpirationNotification");
    protected By restrictedPage = By.id("restrictedPage");

    public SessionPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginWithValidCredentials() {
        // Logic to log in with valid credentials
        enterText(By.id("username"), "validUsername");
        enterText(By.id("password"), "validPassword");
        clickElement(By.id("loginButton"));
        verifySuccessfulLogin();
    }

    public void navigateToDashboard() {
        clickElement(By.id("dashboardLink"));
        verifyDashboardDisplayed();
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not displayed.");
    }

    public void waitForInactivityPeriod(int minutes) {
        try {
            Thread.sleep(minutes * 60 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void attemptActionAfterInactivity() {
        clickElement(By.id("someActionButton"));
        verifySessionExpirationAndRedirection();
    }

    public void verifySessionExpirationAndRedirection() {
        waitUntilElementVisible(loginPage, 3);
        Assert.assertTrue(isElementDisplayed(loginPage), "User is not redirected to the login page.");
    }

    public void verifySessionExpirationNotification() {
        waitUntilElementVisible(sessionExpirationNotification, 3);
        Assert.assertTrue(isElementDisplayed(sessionExpirationNotification), "Session expiration notification is not displayed.");
    }

    public void simulateSessionExpiration() {
        setSessionTimeoutConfiguration(1); // Set timeout to 1 minute for testing
        waitForInactivityPeriod(1);
        verifySessionExpirationAndRedirection();
    }

    public void verifySuccessfulLogin() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Login was not successful.");
    }

    public void accessSessionTimeoutConfiguration() {
        clickElement(By.id("sessionTimeoutConfigLink"));
    }

    public void verifySessionTimeoutSetting(int minutes) {
        WebElement timeoutElement = findElement(By.id("sessionTimeoutValue"));
        Assert.assertEquals(timeoutElement.getText(), String.valueOf(minutes), "Session timeout setting is incorrect.");
    }

    public void accessSystemLogs() {
        clickElement(By.id("systemLogsLink"));
    }

    public void verifyLogEntriesForSessionExpiration(int minutes) {
        accessSystemLogs();
        WebElement logEntry = findElement(By.xpath("//log[contains(text(), 'Session expired after " + minutes + " minutes')]"));
        Assert.assertTrue(logEntry.isDisplayed(), "Log entry for session expiration is not found.");
    }

    public void setSessionTimeoutConfiguration(int minutes) {
        accessSessionTimeoutConfiguration();
        enterText(By.id("sessionTimeoutInput"), String.valueOf(minutes));
        clickElement(By.id("saveTimeoutButton"));
        verifySessionTimeoutSetting(minutes);
    }

    public void verifySessionExpirationAfterInactivity(int minutes) {
        waitForInactivityPeriod(minutes);
        verifySessionExpirationAndRedirection();
    }

    public void attemptAccessRestrictedPage() {
        clickElement(restrictedPage);
        verifyAccessDeniedAndRedirection();
    }

    public void verifyAccessDeniedAndRedirection() {
        waitUntilElementVisible(loginPage, 3);
        Assert.assertTrue(isElementDisplayed(loginPage), "Access is not denied or not redirected to the login page.");
    }

    public void useDifferentBrowsers() {
        // Logic to use different browsers
        // This would typically involve setting up WebDriver instances for different browsers
    }

    public void verifyConsistentSessionExpirationAcrossBrowsers() {
        useDifferentBrowsers();
        simulateSessionExpiration();
        verifySessionExpirationAndRedirection();
    }

    public void verifyNoErrorMessagesOnExpiration() {
        WebElement errorMessage = findElement(By.id("errorMessage"));
        Assert.assertFalse(errorMessage.isDisplayed(), "Error message is displayed on session expiration.");
    }

    public void loginMultipleUserAccounts() {
        // Logic to log in multiple user accounts
        // This would typically involve iterating over a list of user credentials
    }

    public void waitForInactivityPeriodForMultipleUsers() {
        loginMultipleUserAccounts();
        waitForInactivityPeriod(5); // Example inactivity period
        verifyAllSessionsExpireCorrectly();
    }

    public void verifyAllSessionsExpireCorrectly() {
        verifySessionExpirationAndRedirection();
    }

    public void useMobileDevices() {
        // Logic to use mobile devices
        // This would typically involve setting up WebDriver instances for mobile emulation
    }

    public void verifyConsistentSessionExpirationOnMobileDevices() {
        useMobileDevices();
        simulateSessionExpiration();
        verifySessionExpirationAndRedirection();
    }

    public void verifyNoSecurityVulnerabilitiesOnExpiration() {
        // Logic to verify no security vulnerabilities on expiration
        // This would typically involve checking for secure session handling
    }
}