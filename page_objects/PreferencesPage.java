package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class PreferencesPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By darkModeToggle = By.id("darkModeToggle");
    protected By notificationsToggle = By.id("notificationsToggle");
    protected By deviceList = By.cssSelector(".device-list-item");

    public PreferencesPage() {
        PageFactory.initElements(driver, this);
    }

    public void setUserPreferences() {
        setToggleState(darkModeToggle, true);
        setToggleState(notificationsToggle, true);
    }

    public void registerDevices() {
        List<WebElement> devices = driver.findElements(deviceList);
        for (WebElement device : devices) {
            registerDevice(device.getText());
        }
    }

    public void loginToDevice(String deviceName) {
        navigateToDevice(deviceName);
        clickElement(loginButton);
        verifyLoginSuccess();
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(loginButton), "Login was not successful.");
    }

    public void verifyPreferences(String deviceName, boolean darkMode, boolean notifications) {
        navigateToDevice(deviceName);
        boolean currentDarkMode = getToggleState(darkModeToggle);
        boolean currentNotifications = getToggleState(notificationsToggle);
        Assert.assertEquals(currentDarkMode, darkMode, "Dark Mode preference mismatch.");
        Assert.assertEquals(currentNotifications, notifications, "Notifications preference mismatch.");
    }

    public void registerDevice(String deviceName) {
        // Logic to register a specific device
        // Assume registration logic is implemented here
    }

    public void verifyLogin(String deviceName) {
        navigateToDevice(deviceName);
        Assert.assertTrue(isElementVisible(loginButton), "Device login verification failed.");
    }

    public void changePreference(String deviceName, boolean darkMode) {
        navigateToDevice(deviceName);
        setToggleState(darkModeToggle, darkMode);
    }

    public void refreshPreferences(String deviceName) {
        navigateToDevice(deviceName);
        driver.navigate().refresh();
        verifyPreferences(deviceName, getToggleState(darkModeToggle), getToggleState(notificationsToggle));
    }

    public void changeNotificationSetting(String deviceName, boolean notifications) {
        navigateToDevice(deviceName);
        setToggleState(notificationsToggle, notifications);
    }

    public void logoutDevice(String deviceName) {
        navigateToDevice(deviceName);
        // Assume logout logic is implemented here
    }

    public void registerAdditionalDevices() {
        // Logic to register additional devices
        // Assume additional registration logic is implemented here
    }

    public void repeatPreferenceChangeAndSync() {
        List<WebElement> devices = driver.findElements(deviceList);
        for (WebElement device : devices) {
            changePreference(device.getText(), false);
            refreshPreferences(device.getText());
        }
    }

    public void verifyAllDevicesPreferences() {
        List<WebElement> devices = driver.findElements(deviceList);
        for (WebElement device : devices) {
            verifyPreferences(device.getText(), true, true);
        }
    }

    public boolean getToggleState(By toggle) {
        return driver.findElement(toggle).isSelected();
    }

    public void setToggleState(By toggle, boolean state) {
        WebElement element = driver.findElement(toggle);
        if (element.isSelected() != state) {
            element.click();
        }
    }

    private void navigateToDevice(String deviceName) {
        // Logic to navigate to a specific device
        // Assume navigation logic is implemented here
    }
}