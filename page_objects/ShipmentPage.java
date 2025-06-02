package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By trackShipmentSection = By.id("trackShipmentSection");
    protected By shipmentIdInput = By.id("shipmentIdInput");
    protected By currentLocation = By.id("currentLocation");
    protected By estimatedDeliveryTime = By.id("estimatedDeliveryTime");
    protected By logoutButton = By.id("logoutButton");

    public ShipmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCustomerAccount(final String customerId) {
        WebElement customerElement = driver.findElement(By.id("customerId"));
        Assert.assertEquals(customerElement.getText(), customerId, "Customer ID does not match.");
    }

    public void verifyShipmentInTransit(final String shipmentId) {
        enterShipmentId(shipmentId);
        WebElement statusElement = driver.findElement(By.id("shipmentStatus"));
        Assert.assertEquals(statusElement.getText(), "In Transit", "Shipment is not in transit.");
    }

    public void login(final String username, final String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        clickElement(loginButton);
    }

    public void verifyLoginSuccess() {
        WebElement dashboardElement = driver.findElement(By.id("dashboard"));
        Assert.assertTrue(dashboardElement.isDisplayed(), "Login was not successful.");
    }

    public void navigateToTrackShipment() {
        waitUntilElementVisible(trackShipmentSection, 3);
        clickElement(trackShipmentSection);
    }

    public void verifyTrackShipmentSectionDisplayed() {
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), "Track Shipment section is not displayed.");
    }

    public void enterShipmentId(final String shipmentId) {
        waitUntilElementVisible(shipmentIdInput, 3);
        enterText(shipmentIdInput, shipmentId);
    }

    public void verifyShipmentDetailsDisplayed(final String shipmentId) {
        WebElement shipmentDetailsElement = driver.findElement(By.id("shipmentDetails"));
        Assert.assertTrue(shipmentDetailsElement.isDisplayed(), "Shipment details are not displayed.");
    }

    public void verifyCurrentLocation(final String expectedLocation) {
        waitUntilElementVisible(currentLocation, 3);
        String actualLocation = getTextFromElement(currentLocation);
        Assert.assertEquals(actualLocation, expectedLocation, "Current location does not match.");
    }

    public void verifyEstimatedDeliveryTime(final String expectedTime) {
        waitUntilElementVisible(estimatedDeliveryTime, 3);
        String actualTime = getTextFromElement(estimatedDeliveryTime);
        Assert.assertEquals(actualTime, expectedTime, "Estimated delivery time does not match.");
    }

    public void waitForMinutes(final int minutes) {
        try {
            Thread.sleep(minutes * 60 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void verifyRealTimeUpdates() {
        WebElement updatesElement = driver.findElement(By.id("realTimeUpdates"));
        Assert.assertTrue(updatesElement.isDisplayed(), "Real-time updates are not visible.");
    }

    public void logout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        WebElement loginPageElement = driver.findElement(By.id("loginPage"));
        Assert.assertTrue(loginPageElement.isDisplayed(), "Logout was not successful.");
    }
}