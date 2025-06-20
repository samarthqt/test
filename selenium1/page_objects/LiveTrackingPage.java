package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LiveTrackingPage extends WebReusableComponents {

    private final By trackingField = By.id("trackingField");
    private final By currentLocation = By.id("currentLocation");
    private final By estimatedDeliveryTime = By.id("estimatedDeliveryTime");
    private final By notificationSettings = By.id("notificationSettings");
    private final By trackingHistoryLog = By.id("trackingHistoryLog");
    private final By errorMessage = By.className("errorMessage");

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
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(trackingField));
        WebElement trackingInput = getDriver().findElement(trackingField);
        trackingInput.clear();
        trackingInput.sendKeys(shipmentId);
        Assert.assertTrue(isTrackingDetailsDisplayed(shipmentId), "Tracking details not displayed for shipment ID: " + shipmentId);
    }

    public boolean isTrackingDetailsDisplayed(String shipmentId) {
        return getDriver().findElement(trackingField).getAttribute("value").equals(shipmentId);
    }

    public boolean isCurrentLocationDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentLocation));
        return getDriver().findElement(currentLocation).isDisplayed();
    }

    public void simulateLocationChange() {
        WebElement simulateLocationChange = getDriver().findElement(By.id("simulateLocationChange"));
        simulateLocationChange.click();
        Assert.assertTrue(isLocationUpdatedInRealTime(), "Location not updated in real-time after simulation.");
    }

    public boolean isLocationUpdatedInRealTime() {
        return getDriver().findElement(currentLocation).getText().contains("Updated");
    }

    public boolean isEstimatedDeliveryTimeDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(estimatedDeliveryTime));
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

    public boolean areNotificationsEnabled() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationSettings));
        return getDriver().findElement(notificationSettings).isSelected();
    }

    public void simulateNetworkIssue() {
        WebElement simulateNetworkIssue = getDriver().findElement(By.id("simulateNetworkIssue"));
        simulateNetworkIssue.click();
        Assert.assertTrue(isNetworkIssueHandledGracefully(), "Network issue not handled gracefully.");
    }

    public boolean isNetworkIssueHandledGracefully() {
        return getDriver().findElement(trackingField).isDisplayed();
    }

    public boolean isTrackingHistoryLogCorrect() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(trackingHistoryLog));
        return getDriver().findElement(trackingHistoryLog).isDisplayed();
    }

    public boolean areErrorMessagesDisplayed() {
        return getDriver().findElements(errorMessage).size() > 0;
    }

    public void updateLocationFromDifferentDevice() {
        WebElement updateLocation = getDriver().findElement(By.id("updateLocation"));
        updateLocation.click();
        Assert.assertTrue(isLocationSynchronizedAcrossDevices(), "Location not synchronized across devices.");
    }

    public boolean isLocationSynchronizedAcrossDevices() {
        return getDriver().findElement(currentLocation).getText().contains("Synchronized");
    }

    public boolean isMobileTrackingConsistent() {
        return getDriver().findElement(currentLocation).isDisplayed();
    }

    public void rebootSystem() {
        WebElement rebootSystem = getDriver().findElement(By.id("rebootSystem"));
        rebootSystem.click();
        Assert.assertTrue(isTrackingInformationAvailableAfterReboot(), "Tracking information not available after reboot.");
    }

    public boolean isTrackingInformationAvailableAfterReboot() {
        return getDriver().findElement(trackingField).isDisplayed();
    }

    public boolean isLiveTrackingAccurate() {
        return getDriver().findElement(currentLocation).getText().contains("Accurate");
    }
}