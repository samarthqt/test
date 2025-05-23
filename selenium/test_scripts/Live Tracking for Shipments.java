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
// LiveTrackingPage.java (Page Object Model)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrackingPage {
    WebDriver driver;

    @FindBy(id = "shipmentIdField")
    WebElement shipmentIdField;

    @FindBy(id = "currentLocation")
    WebElement currentLocation;

    @FindBy(id = "estimatedDeliveryTime")
    WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshButton")
    WebElement refreshButton;

    @FindBy(id = "logoutButton")
    WebElement logoutButton;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "notificationSettings")
    WebElement notificationSettings;

    @FindBy(id = "updateLocationButton")
    WebElement updateLocationButton;

    @FindBy(id = "trackingHistoryLog")
    WebElement trackingHistoryLog;

    @FindBy(id = "errorMessages")
    WebElement errorMessages;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentId(String shipmentId) {
        shipmentIdField.sendKeys(shipmentId);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime.getText();
    }

    public void refreshPage() {
        refreshButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public void login() {
        loginButton.click();
    }

    public void checkNotificationSettings() {
        notificationSettings.click();
    }

    public void simulateNetworkIssue() {
        driver.setNetworkConditions(new NetworkConditions(false, false, 0, 0));
    }

    public void updateLocation() {
        updateLocationButton.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessages() {
        return errorMessages.getText();
    }
}

// LiveTrackingTest.java (Test Script)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LiveTrackingTest {
    WebDriver driver;
    LiveTrackingPage liveTrackingPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://example.com/live-tracking");
        liveTrackingPage = new LiveTrackingPage(driver);
    }

    @Test
    public void testLiveTracking() {
        liveTrackingPage.enterShipmentId("54321");
        String initialLocation = liveTrackingPage.getCurrentLocation();
        liveTrackingPage.updateLocation();
        Assert.assertNotEquals(liveTrackingPage.getCurrentLocation(), initialLocation);
        Assert.assertNotNull(liveTrackingPage.getEstimatedDeliveryTime());
        liveTrackingPage.refreshPage();
        liveTrackingPage.logout();
        liveTrackingPage.login();
        liveTrackingPage.checkNotificationSettings();
        liveTrackingPage.simulateNetworkIssue();
        liveTrackingPage.updateLocation();
        Assert.assertNotNull(liveTrackingPage.getTrackingHistoryLog());
        Assert.assertNull(liveTrackingPage.getErrorMessages());
        liveTrackingPage.updateLocation();
        Assert.assertTrue(liveTrackingPage.getCurrentLocation().contains("Mobile"));
        liveTrackingPage.refreshPage();
        Assert.assertTrue(liveTrackingPage.getCurrentLocation().contains("Reboot"));
        Assert.assertTrue(liveTrackingPage.getCurrentLocation().contains("Accurate"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
```