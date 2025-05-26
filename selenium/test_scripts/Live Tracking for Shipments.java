package com.tests;

import com.pageobjects.LiveTrackingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.*;

public class LiveTrackingTest {
    private LiveTrackingPage liveTrackingPage;

    @BeforeMethod
    public void setUp() {
        liveTrackingPage = new LiveTrackingPage();
        liveTrackingPage.login("09876");
    }

    @Test
    public void testLiveTracking() {
        liveTrackingPage.navigateToLiveTrackingPage();
        assertTrue(liveTrackingPage.isLiveTrackingPageDisplayed(), "Live tracking page is not displayed.");

        liveTrackingPage.enterShipmentID("54321");
        assertTrue(liveTrackingPage.isTrackingDetailsDisplayed("54321"), "Tracking details are not displayed.");

        assertTrue(liveTrackingPage.isCurrentLocationDisplayed(), "Current location is not displayed.");

        liveTrackingPage.simulateLocationChange();
        assertTrue(liveTrackingPage.isLocationUpdatedInRealTime(), "Location is not updated in real-time.");

        assertTrue(liveTrackingPage.isEstimatedDeliveryTimeDisplayed(), "Estimated delivery time is not displayed.");

        liveTrackingPage.refreshPage();
        assertTrue(liveTrackingPage.isTrackingInformationConsistent(), "Tracking information is not consistent after refresh.");

        liveTrackingPage.logout();
        liveTrackingPage.login("09876");
        assertTrue(liveTrackingPage.isTrackingInformationAvailable(), "Tracking information is not available after re-login.");

        assertTrue(liveTrackingPage.areNotificationsEnabled(), "Notifications are not enabled for live tracking updates.");

        liveTrackingPage.simulateNetworkIssue();
        assertTrue(liveTrackingPage.isNetworkIssueHandledGracefully(), "Network issue is not handled gracefully.");

        assertTrue(liveTrackingPage.isTrackingHistoryLogCorrect(), "Tracking history log is incorrect.");

        assertFalse(liveTrackingPage.areErrorMessagesDisplayed(), "Error messages are displayed during location updates.");

        liveTrackingPage.updateLocationFromDifferentDevice();
        assertTrue(liveTrackingPage.isLocationSynchronizedAcrossDevices(), "Location is not synchronized across devices.");

        assertTrue(liveTrackingPage.isMobileTrackingConsistent(), "Mobile tracking is not consistent with desktop view.");

        liveTrackingPage.rebootSystem();
        assertTrue(liveTrackingPage.isTrackingInformationAvailableAfterReboot(), "Tracking information is not available after system reboot.");

        assertTrue(liveTrackingPage.isLiveTrackingAccurate(), "Live tracking information is not accurate.");
    }

    @AfterMethod
    public void tearDown() {
        liveTrackingPage.logout();
    }
}```java
// LiveTrackingPage.java (Page Object Model file)
package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LiveTrackingPage {
    private WebDriver driver;

    private By shipmentIdField = By.id("shipmentId");
    private By currentLocation = By.id("currentLocation");
    private By estimatedDeliveryTime = By.id("estimatedDeliveryTime");
    private By notificationSettings = By.id("notificationSettings");
    private By trackingHistoryLog = By.id("trackingHistoryLog");
    private By errorMessages = By.id("errorMessages");

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToTrackingPage(String url) {
        driver.get(url);
    }

    public void enterShipmentId(String shipmentId) {
        driver.findElement(shipmentIdField).sendKeys(shipmentId);
    }

    public String getCurrentLocation() {
        return driver.findElement(currentLocation).getText();
    }

    public void simulateLocationChange(String newLocation) {
        WebElement locationField = driver.findElement(currentLocation);
        locationField.clear();
        locationField.sendKeys(newLocation);
    }

    public String getEstimatedDeliveryTime() {
        return driver.findElement(estimatedDeliveryTime).getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logOut() {
        driver.findElement(By.id("logout")).click();
    }

    public void logIn(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }

    public String getNotificationSettings() {
        return driver.findElement(notificationSettings).getText();
    }

    public void simulateNetworkIssue() {
        // Simulate network issue logic here
    }

    public String getTrackingHistoryLog() {
        return driver.findElement(trackingHistoryLog).getText();
    }

    public String getErrorMessages() {
        return driver.findElement(errorMessages).getText();
    }

    public void updateLocationFromDifferentDevice(String newLocation) {
        WebElement locationField = driver.findElement(currentLocation);
        locationField.clear();
        locationField.sendKeys(newLocation);
    }

    public void verifyLiveTrackingOnMobile() {
        // Mobile device specific logic here
    }

    public void verifyLiveTrackingAfterReboot() {
        // System reboot logic here
    }

    public boolean verifyTrackingAccuracy(String expectedLocation) {
        return getCurrentLocation().equals(expectedLocation);
    }
}

// LiveTrackingTest.java (Test script)
package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.example.pages.LiveTrackingPage;

public class LiveTrackingTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        LiveTrackingPage trackingPage = new LiveTrackingPage(driver);

        trackingPage.navigateToTrackingPage("http://example.com/live-tracking");
        trackingPage.enterShipmentId("54321");
        String currentLocation = trackingPage.getCurrentLocation();
        trackingPage.simulateLocationChange("New Location");
        String estimatedDeliveryTime = trackingPage.getEstimatedDeliveryTime();
        trackingPage.refreshPage();
        trackingPage.logOut();
        trackingPage.logIn("user", "password");
        String notificationSettings = trackingPage.getNotificationSettings();
        trackingPage.simulateNetworkIssue();
        String trackingHistoryLog = trackingPage.getTrackingHistoryLog();
        String errorMessages = trackingPage.getErrorMessages();
        trackingPage.updateLocationFromDifferentDevice("Another Location");
        trackingPage.verifyLiveTrackingOnMobile();
        trackingPage.verifyLiveTrackingAfterReboot();
        boolean isTrackingAccurate = trackingPage.verifyTrackingAccuracy("Expected Location");

        driver.quit();
    }
}
```