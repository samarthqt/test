package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TrackingPage extends WebReusableComponents {

    protected By customerIdField = By.id("customerId");
    protected By loginButton = By.id("loginButton");
    protected By trackShipmentSection = By.id("trackShipmentSection");
    protected By searchBar = By.id("searchBar");
    protected By shipmentDetails = By.id("shipmentDetails");
    protected By shipmentStatus = By.id("shipmentStatus");
    protected By feedbackMessage = By.id("feedbackMessage");
    protected By refreshButton = By.id("refreshButton");
    protected By logoutButton = By.id("logoutButton");

    public TrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCustomerAccount(String customerId) {
        waitUntilElementVisible(customerIdField, 3);
        enterText(customerIdField, customerId);
        Assert.assertTrue(isElementVisible(customerIdField), "Customer ID field is not visible.");
    }

    public void loginToAccount(String username, String password) {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(loginButton);
        Assert.assertTrue(isElementVisible(By.id("accountDashboard")), "Login was not successful.");
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(By.id("accountDashboard")), "Login was not successful.");
    }

    public void navigateToTrackShipmentSection() {
        waitUntilElementVisible(trackShipmentSection, 3);
        clickElement(trackShipmentSection);
        Assert.assertTrue(isElementVisible(trackShipmentSection), "Track Shipment section is not displayed.");
    }

    public void verifyTrackShipmentSectionDisplayed() {
        Assert.assertTrue(isElementVisible(trackShipmentSection), "Track Shipment section is not displayed.");
    }

    public void enterShipmentIDInSearchBar(String shipmentId) {
        waitUntilElementVisible(searchBar, 3);
        enterText(searchBar, shipmentId);
        Assert.assertTrue(getTextFromElement(searchBar).contains(shipmentId), "Shipment ID is not entered correctly.");
    }

    public void verifyShipmentDetailsDisplayed(String shipmentId) {
        waitUntilElementVisible(shipmentDetails, 3);
        Assert.assertTrue(getTextFromElement(shipmentDetails).contains(shipmentId), "Shipment details are not displayed.");
    }

    public void verifyShipmentStatus(String expectedStatus) {
        waitUntilElementVisible(shipmentStatus, 3);
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Shipment status does not match.");
    }

    public void verifyCurrentStatus(String expectedStatus) {
        Assert.assertEquals(getTextFromElement(shipmentStatus), expectedStatus, "Current status is not displayed correctly.");
    }

    public void verifyAccurateStatus(String expectedStatus) {
        Assert.assertEquals(getTextFromElement(shipmentStatus), expectedStatus, "Current status is not accurate.");
    }

    public void refreshTrackingInformation() {
        clickElement(refreshButton);
        Assert.assertTrue(isElementVisible(refreshButton), "Refresh button is not visible.");
    }

    public void verifyRealTimeUpdates() {
        // Logic to verify real-time updates
        Assert.assertTrue(isElementVisible(By.id("realTimeUpdates")), "Real-time updates are not visible.");
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(isElementVisible(By.id("pageRefreshed")), "Page did not refresh successfully.");
    }

    public void verifyTrackingInformationUpdates() {
        // Logic to verify tracking information updates
        Assert.assertTrue(isElementVisible(By.id("trackingUpdates")), "Tracking information updates are not visible.");
    }

    public void verifyShipmentInTransit(String shipmentId) {
        // Logic to verify shipment in transit
        Assert.assertTrue(getTextFromElement(shipmentStatus).contains("In Transit"), "Shipment is not in transit.");
    }

    public void verifyFeedbackForLongID() {
        String feedback = getTextFromElement(feedbackMessage);
        Assert.assertTrue(feedback.contains("error") || feedback.contains("processed"), "Feedback for long ID is not provided.");
    }

    public void verifyErrorMessageOrGracefulHandling() {
        String feedback = getTextFromElement(feedbackMessage);
        Assert.assertTrue(feedback.contains("error") || feedback.contains("handled"), "System did not handle input gracefully.");
    }

    public void verifyInputProcessing() {
        Assert.assertFalse(isElementVisible(By.id("error")), "System crashed or displayed errors.");
    }

    public void logoutFromAccount() {
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(By.id("loginPage")), "Logout was not successful.");
    }

    public void logout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(By.id("loginPage")), "Logout was not successful.");
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementVisible(By.id("loginPage")), "Logout was not successful.");
    }
}