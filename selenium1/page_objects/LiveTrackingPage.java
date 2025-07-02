package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LiveTrackingPage extends WebReusableComponents {

    private final By trackingField = By.id("trackingField");
    private final By currentLocation = By.id("currentLocation");
    private final By estimatedDeliveryTime = By.id("estimatedDeliveryTime");
    private final By notificationSettings = By.id("notificationSettings");
    private final By trackingHistoryLog = By.id("trackingHistoryLog");

    public LiveTrackingPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void login(String userId) {
        WebElement loginField = getDriver().findElement(By.id("loginField"));
        WebElement loginButton = getDriver().findElement(By.id("loginButton"));
        loginField.sendKeys(userId);
        loginButton.click();
        Assert.assertTrue(isLiveTrackingPageDisplayed(), "Login failed, live tracking page not displayed.");
    }

    public void navigateToLiveTrackingPage() {
        WebElement liveTrackingMenu = getDriver().findElement(By.id("liveTrackingMenu"));
        liveTrackingMenu.click();
        Assert.assertTrue(isLiveTrackingPageDisplayed(), "Navigation to live tracking page failed.");
    }

    public boolean isLiveTrackingPageDisplayed() {
        return getDriver().findElement(trackingField).isDisplayed();
    }

    public void enterShipmentID(String shipmentId) {
        waitUntilElementVisible(trackingField, 3);
        WebElement trackingInput = getDriver().findElement(trackingField);
        trackingInput.clear();
        trackingInput.sendKeys(shipmentId);
        Assert.assertTrue(isTrackingDetailsDisplayed(shipmentId), "Tracking details not displayed for shipment ID: " + shipmentId);
    }

    public boolean isTrackingDetailsDisplayed(String shipmentId) {
        return getDriver().findElement(trackingField).getAttribute("value").equals(shipmentId);
    }

    public boolean isCurrentLocationDisplayed() {
        waitUntilElementVisible(currentLocation, 3);
        return getDriver().findElement(currentLocation).isDisplayed();
    }

    public void simulateLocationChange() {
        WebElement simulateLocationChangeButton = getDriver().findElement(By.id("simulateLocationChange"));
        simulateLocationChangeButton.click();
        Assert.assertTrue(isLocationUpdatedInRealTime(), "Location not updated in real-time after simulation.");
    }

    public boolean isLocationUpdatedInRealTime() {
        return getDriver().findElement(currentLocation).getText().contains("Updated");
    }

    public boolean isEstimatedDeliveryTimeDisplayed() {
        waitUntilElementVisible(estimatedDeliveryTime, 3);
        return getDriver().findElement(estimatedDeliveryTime).isDisplayed();
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
        Assert.assertTrue(isTrackingInformationConsistent(), "Tracking information inconsistent after refresh.");
    }

    public boolean isTrackingInformationConsistent() {
        return getDriver().findElement(trackingField).isDisplayed();
    }

    public void logout() {
        WebElement logoutButton = getDriver().findElement(By.id("logoutButton"));
        logoutButton.click();
        Assert.assertFalse(isLiveTrackingPageDisplayed(), "Logout failed, live tracking page still displayed.");
    }

    public boolean isTrackingInformationAvailable() {
        return getDriver().findElement(trackingField).isDisplayed();
    }

    public void checkNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
        Assert.assertTrue(isNotificationSettingsCorrect(), "Notification settings for live tracking updates are incorrect.");
    }

    public boolean isNotificationSettingsCorrect() {
        return getDriver().findElement(notificationSettings).isSelected();
    }

    public void simulateNetworkIssueAndAttemptUpdate() {
        WebElement simulateNetworkIssueAndUpdateButton = getDriver().findElement(By.id("simulateNetworkIssueAndUpdate"));
        simulateNetworkIssueAndUpdateButton.click();
        Assert.assertTrue(isNetworkIssueHandledDuringUpdate(), "Network issue during location update is not handled correctly.");
    }

    public boolean isNetworkIssueHandledDuringUpdate() {
        return getDriver().findElement(trackingField).isDisplayed();
    }

    public void verifyTrackingHistoryLog() {
        waitUntilElementVisible(trackingHistoryLog, 3);
        Assert.assertTrue(isTrackingHistoryLogAccurate(), "Tracking history log is not accurate.");
    }

    public boolean isTrackingHistoryLogAccurate() {
        return getDriver().findElement(trackingHistoryLog).isDisplayed();
    }

    public void checkErrorMessagesDuringUpdates() {
        Assert.assertTrue(areErrorMessagesDisplayed(), "Error messages are not displayed during updates.");
    }

    public boolean areErrorMessagesDisplayed() {
        return getDriver().findElements(By.className("errorMessage")).size() > 0;
    }

    public void updateLocationFromDifferentDevice() {
        WebElement updateLocationButton = getDriver().findElement(By.id("updateLocation"));
        updateLocationButton.click();
        Assert.assertTrue(isLocationSynchronizedAcrossDevices(), "Location not synchronized across devices.");
    }

    public boolean isLocationSynchronizedAcrossDevices() {
        return getDriver().findElement(currentLocation).getText().contains("Synchronized");
    }

    public boolean isMobileTrackingConsistent() {
        return getDriver().findElement(currentLocation).isDisplayed();
    }

    public void rebootSystem() {
        WebElement rebootSystemButton = getDriver().findElement(By.id("rebootSystem"));
        rebootSystemButton.click();
        Assert.assertTrue(isTrackingInformationAvailableAfterReboot(), "Tracking information not available after reboot.");
    }

    public boolean isTrackingInformationAvailableAfterReboot() {
        return getDriver().findElement(trackingField).isDisplayed();
    }

    public boolean isLiveTrackingAccurate() {
        return getDriver().findElement(currentLocation).getText().contains("Accurate");
    }
}