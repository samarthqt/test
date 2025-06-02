package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentPage extends WebReusableComponents {

    protected By customerIdField = By.id("customerId");
    protected By shipmentIdField = By.id("shipmentId");
    protected By loginButton = By.id("loginButton");
    protected By trackShipmentSection = By.id("trackShipmentSection");
    protected By currentLocationField = By.id("currentLocation");
    protected By estimatedDeliveryTimeField = By.id("estimatedDeliveryTime");
    protected By logoutButton = By.id("logoutButton");

    public ShipmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCustomerAccount(String customerId) {
        waitUntilElementVisible(customerIdField, 3);
        enterText(customerIdField, customerId);
        Assert.assertTrue(isElementDisplayed(customerIdField), "Customer ID field is not displayed.");
    }

    public void verifyShipmentInTransit(String shipmentId) {
        waitUntilElementVisible(shipmentIdField, 3);
        enterText(shipmentIdField, shipmentId);
        Assert.assertTrue(isElementDisplayed(shipmentIdField), "Shipment ID field is not displayed.");
    }

    public void loginToAccount(String username, String password) {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(loginButton);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementDisplayed(By.id("accountDashboard")), "Login was not successful.");
    }

    public void navigateToTrackShipmentSection() {
        clickElement(trackShipmentSection);
    }

    public void verifyTrackShipmentSectionDisplayed() {
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), "Track Shipment section is not displayed.");
    }

    public void enterShipmentID(String shipmentId) {
        enterText(shipmentIdField, shipmentId);
    }

    public void verifyShipmentDetailsDisplayed() {
        Assert.assertTrue(isElementDisplayed(By.id("shipmentDetails")), "Shipment details are not displayed.");
    }

    public void verifyCurrentLocation(String expectedLocation) {
        String actualLocation = getTextFromElement(currentLocationField);
        Assert.assertEquals(actualLocation, expectedLocation, "Current location does not match.");
    }

    public void verifyEstimatedDeliveryTime(String expectedDeliveryTime) {
        String actualDeliveryTime = getTextFromElement(estimatedDeliveryTimeField);
        Assert.assertEquals(actualDeliveryTime, expectedDeliveryTime, "Estimated delivery time does not match.");
    }

    public void waitForMinutesAndRefreshPage(int minutes) {
        waitForMinutes(minutes);
        refreshPage();
    }

    public void verifyRealTimeUpdates() {
        Assert.assertTrue(isElementDisplayed(By.id("realTimeUpdates")), "Real-time updates are not displayed.");
    }

    public void logoutOfAccount() {
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementDisplayed(By.id("loginPage")), "Logout was not successful.");
    }
}