package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TrackingPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By trackOrderSection = By.id("trackOrderSection");
    protected By txtTrackingNumber = By.id("trackingNumber");
    protected By btnSubmitTracking = By.id("submitTracking");
    protected By orderStatus = By.id("orderStatus");
    protected By estimatedDeliveryTime = By.id("estimatedDeliveryTime");
    protected By carrierInformation = By.id("carrierInformation");
    protected By trackingUpdates = By.id("trackingUpdates");
    protected By trackingDetails = By.id("trackingDetails");
    protected By trackingSecurity = By.id("trackingSecurity");
    protected By userFriendlyInterface = By.id("userFriendlyInterface");
    protected By pageResponsiveness = By.id("pageResponsiveness");
    protected By multipleOrderTracking = By.id("multipleOrderTracking");
    protected By trackingHistory = By.id("trackingHistory");

    public TrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void login() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(trackOrderSection), "Login failed.");
    }

    public void navigateToTrackOrderSection() {
        waitUntilElementVisible(trackOrderSection, 3);
        clickElement(trackOrderSection);
    }

    public void verifyTrackOrderPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtTrackingNumber), "Track Order page not displayed.");
    }

    public void setTrackingNumber(String trackingNumber) {
        waitUntilElementVisible(txtTrackingNumber, 3);
        enterText(txtTrackingNumber, trackingNumber);
    }

    public void enterTrackingNumber() {
        clickElement(txtTrackingNumber);
    }

    public void verifyTrackingNumberAccepted() {
        Assert.assertTrue(isElementVisible(btnSubmitTracking), "Tracking number not accepted.");
    }

    public void submitTrackingRequest() {
        waitUntilElementVisible(btnSubmitTracking, 3);
        clickElement(btnSubmitTracking);
    }

    public void verifyTrackingInformationRetrieved() {
        Assert.assertTrue(isElementVisible(orderStatus), "Tracking information not retrieved.");
    }

    public void checkOrderStatus() {
        waitUntilElementVisible(orderStatus, 3);
        String status = getTextFromElement(orderStatus);
        Assert.assertNotNull(status, "Order status not displayed.");
    }

    public void verifyOrderStatusDisplayedCorrectly() {
        Assert.assertTrue(isElementVisible(orderStatus), "Order status not displayed correctly.");
    }

    public void checkEstimatedDeliveryTime() {
        waitUntilElementVisible(estimatedDeliveryTime, 3);
        String deliveryTime = getTextFromElement(estimatedDeliveryTime);
        Assert.assertNotNull(deliveryTime, "Estimated delivery time not shown.");
    }

    public void verifyEstimatedDeliveryTimeShown() {
        Assert.assertTrue(isElementVisible(estimatedDeliveryTime), "Estimated delivery time not shown.");
    }

    public void verifyCarrierInformation() {
        waitUntilElementVisible(carrierInformation, 3);
        String carrierInfo = getTextFromElement(carrierInformation);
        Assert.assertNotNull(carrierInfo, "Carrier information not displayed correctly.");
    }

    public void verifyCarrierInformationDisplayedCorrectly() {
        Assert.assertTrue(isElementVisible(carrierInformation), "Carrier information not displayed correctly.");
    }

    public void ensureRealTimeTrackingUpdates() {
        waitUntilElementVisible(trackingUpdates, 3);
        String updates = getTextFromElement(trackingUpdates);
        Assert.assertNotNull(updates, "Real-time tracking updates not reflected.");
    }

    public void verifyRealTimeTrackingUpdates() {
        Assert.assertTrue(isElementVisible(trackingUpdates), "Real-time tracking updates not reflected.");
    }

    public void checkTrackingDetailsDiscrepancies() {
        waitUntilElementVisible(trackingDetails, 3);
        String details = getTextFromElement(trackingDetails);
        Assert.assertNotNull(details, "Tracking details discrepancies found.");
    }

    public void verifyTrackingDetailsAccuracy() {
        Assert.assertTrue(isElementVisible(trackingDetails), "Tracking details are not accurate.");
    }

    public void validateTrackingDetailsAccuracy() {
        waitUntilElementVisible(trackingDetails, 3);
        String details = getTextFromElement(trackingDetails);
        Assert.assertNotNull(details, "Tracking details are not accurate.");
    }

    public void verifyTrackingInformationSecurity() {
        waitUntilElementVisible(trackingSecurity, 3);
        String securityInfo = getTextFromElement(trackingSecurity);
        Assert.assertNotNull(securityInfo, "Tracking information is not secure.");
    }

    public void ensureUserFriendlyInterface() {
        waitUntilElementVisible(userFriendlyInterface, 3);
        String interfaceInfo = getTextFromElement(userFriendlyInterface);
        Assert.assertNotNull(interfaceInfo, "Tracking interface is not user-friendly.");
    }

    public void verifyUserFriendlyInterface() {
        Assert.assertTrue(isElementVisible(userFriendlyInterface), "Tracking interface is not user-friendly.");
    }

    public void verifyPageResponsiveness() {
        waitUntilElementVisible(pageResponsiveness, 3);
        String responsivenessInfo = getTextFromElement(pageResponsiveness);
        Assert.assertNotNull(responsivenessInfo, "Tracking page is not responsive.");
    }

    public void attemptMultipleOrderTracking() {
        waitUntilElementVisible(multipleOrderTracking, 3);
        String multipleTrackingInfo = getTextFromElement(multipleOrderTracking);
        Assert.assertNotNull(multipleTrackingInfo, "Multiple order tracking failed.");
    }

    public void verifyMultipleOrderTrackingHandling() {
        Assert.assertTrue(isElementVisible(multipleOrderTracking), "Multiple order tracking failed.");
    }

    public void checkTrackingHistoryAvailability() {
        waitUntilElementVisible(trackingHistory, 3);
        String historyInfo = getTextFromElement(trackingHistory);
        Assert.assertNotNull(historyInfo, "Tracking history is not accessible.");
    }

    public void verifyTrackingHistoryAccessibility() {
        Assert.assertTrue(isElementVisible(trackingHistory), "Tracking history is not accessible.");
    }
}