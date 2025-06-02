package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TrackingPage extends WebReusableComponents {

    protected By customerIDField = By.id("customerID");
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By trackShipmentSection = By.id("trackShipmentSection");
    protected By shipmentIDField = By.id("shipmentID");
    protected By shipmentDetails = By.id("shipmentDetails");
    protected By shipmentStatus = By.id("shipmentStatus");
    protected By refreshButton = By.id("refreshButton");
    protected By errorMessage = By.id("errorMessage");
    protected By logoutButton = By.id("logoutButton");

    public TrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCustomerAccount(String customerID) {
        waitUntilElementVisible(customerIDField, 3);
        enterText(customerIDField, customerID);
        Assert.assertTrue(isElementDisplayed(customerIDField), "Customer ID field is not displayed.");
    }

    public void loginToAccount(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), "Login failed.");
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), "Login failed.");
    }

    public void navigateToTrackShipmentSection() {
        waitUntilElementVisible(trackShipmentSection, 3);
        clickElement(trackShipmentSection);
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), "Track Shipment section is not displayed.");
    }

    public void verifyTrackShipmentSectionDisplayed() {
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), "Track Shipment section is not displayed.");
    }

    public void enterShipmentIdInSearchBar(String shipmentId) {
        waitUntilElementVisible(shipmentIDField, 3);
        enterText(shipmentIDField, shipmentId);
        Assert.assertTrue(getTextFromElement(shipmentIDField).contains(shipmentId), "Shipment ID not entered correctly.");
    }

    public void verifyShipmentDetailsDisplayed(String shipmentId) {
        waitUntilElementVisible(shipmentDetails, 3);
        Assert.assertTrue(getTextFromElement(shipmentDetails).contains(shipmentId), "Shipment details not displayed.");
    }

    public void verifyShipmentStatusInTransit() {
        waitUntilElementVisible(shipmentStatus, 3);
        Assert.assertEquals(getTextFromElement(shipmentStatus), "In Transit", "Shipment status is not 'In Transit'.");
    }

    public void verifyShipmentStatus(String expectedStatus) {
        waitUntilElementVisible(shipmentStatus, 3);
        Assert.assertEquals(getTextFromElement(shipmentStatus), expectedStatus, "Shipment status incorrect.");
    }

    public void verifyAccurateShipmentStatus(String expectedStatus) {
        waitUntilElementVisible(shipmentStatus, 3);
        Assert.assertEquals(getTextFromElement(shipmentStatus), expectedStatus, "Shipment status not accurate.");
    }

    public void refreshTrackingInformation() {
        waitUntilElementVisible(refreshButton, 3);
        clickElement(refreshButton);
        Assert.assertTrue(isElementDisplayed(refreshButton), "Refresh button is not displayed.");
    }

    public void refreshPageForUpdates() {
        driver.navigate().refresh();
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), "Page refresh failed.");
    }

    public void verifyRealTimeTrackingUpdates() {
        // Logic to verify real-time tracking updates
        Assert.assertTrue(isElementDisplayed(shipmentStatus), "Real-time tracking updates failed.");
    }

    public void verifyImmediateTrackingUpdates() {
        // Logic to verify immediate tracking updates
        Assert.assertTrue(isElementDisplayed(shipmentStatus), "Immediate tracking updates failed.");
    }

    public void verifyInvalidShipmentIDErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid shipment ID.", "Error message not displayed correctly.");
    }

    public void verifyErrorMessagePersists() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid shipment ID.", "Error message not persistent.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertFalse(isElementDisplayed(trackShipmentSection), "Logout failed.");
    }

    public void logoutOfAccount() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertFalse(isElementDisplayed(trackShipmentSection), "Logout failed.");
    }

    public void verifyLogoutSuccess() {
        Assert.assertFalse(isElementDisplayed(trackShipmentSection), "Logout failed.");
    }
}