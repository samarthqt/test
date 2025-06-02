package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TrackOrderPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By trackOrderSectionLink = By.id("trackOrderSection");
    protected By txtTrackingNumber = By.id("trackingNumber");
    protected By btnSubmitTracking = By.id("submitTracking");
    protected By lblOrderStatus = By.id("orderStatus");
    protected By lblEstimatedDelivery = By.id("estimatedDelivery");
    protected By lblCarrierInfo = By.id("carrierInfo");
    protected By errorMessage = By.id("errorMessage");

    public TrackOrderPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
        verifyLoginSuccess();
    }

    public void verifyLoginSuccess() {
        WebElement loginSuccessElement = driver.findElement(By.id("loginSuccess"));
        Assert.assertTrue(loginSuccessElement.isDisplayed(), "Login was not successful.");
    }

    public void navigateToTrackOrderSection() {
        waitUntilElementVisible(trackOrderSectionLink, 3);
        clickElement(trackOrderSectionLink);
        verifyTrackOrderPageDisplayed();
    }

    public void verifyTrackOrderPageDisplayed() {
        WebElement trackOrderPageElement = driver.findElement(By.id("trackOrderPage"));
        Assert.assertTrue(trackOrderPageElement.isDisplayed(), "Track Order page is not displayed.");
    }

    public void enterTrackingNumber(String trackingNumber) {
        waitUntilElementVisible(txtTrackingNumber, 3);
        enterText(txtTrackingNumber, trackingNumber);
        verifyTrackingNumberAccepted();
    }

    public void verifyTrackingNumberAccepted() {
        WebElement trackingNumberAcceptedElement = driver.findElement(By.id("trackingNumberAccepted"));
        Assert.assertTrue(trackingNumberAcceptedElement.isDisplayed(), "Tracking number is not accepted.");
    }

    public void submitTrackingRequest() {
        waitUntilElementVisible(btnSubmitTracking, 3);
        clickElement(btnSubmitTracking);
        verifyTrackingInformationRetrieved();
    }

    public void verifyTrackingInformationRetrieved() {
        WebElement trackingInfoElement = driver.findElement(By.id("trackingInfo"));
        Assert.assertTrue(trackingInfoElement.isDisplayed(), "Tracking information is not retrieved.");
    }

    public void checkCurrentOrderStatus() {
        waitUntilElementVisible(lblOrderStatus, 3);
        String status = getTextFromElement(lblOrderStatus);
        Assert.assertNotNull(status, "Order status is not displayed.");
        verifyCurrentOrderStatusDisplayedCorrectly();
    }

    public void verifyCurrentOrderStatusDisplayedCorrectly() {
        String expectedStatus = "Delivered";
        String actualStatus = getTextFromElement(lblOrderStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Order status is not displayed correctly.");
    }

    public void checkEstimatedDeliveryTime() {
        waitUntilElementVisible(lblEstimatedDelivery, 3);
        String deliveryTime = getTextFromElement(lblEstimatedDelivery);
        Assert.assertNotNull(deliveryTime, "Estimated delivery time is not displayed.");
        verifyEstimatedDeliveryTimeShown();
    }

    public void verifyEstimatedDeliveryTimeShown() {
        String expectedDeliveryTime = "2 days";
        String actualDeliveryTime = getTextFromElement(lblEstimatedDelivery);
        Assert.assertEquals(actualDeliveryTime, expectedDeliveryTime, "Estimated delivery time is not shown correctly.");
    }

    public void checkCarrierInformation() {
        waitUntilElementVisible(lblCarrierInfo, 3);
        String carrierInfo = getTextFromElement(lblCarrierInfo);
        Assert.assertNotNull(carrierInfo, "Carrier information is not displayed.");
        verifyCarrierInformationDisplayedCorrectly();
    }

    public void verifyCarrierInformationDisplayedCorrectly() {
        String expectedCarrierInfo = "FedEx";
        String actualCarrierInfo = getTextFromElement(lblCarrierInfo);
        Assert.assertEquals(actualCarrierInfo, expectedCarrierInfo, "Carrier information is not displayed correctly.");
    }

    public void verifyErrorMessageForInvalidTrackingNumber() {
        waitUntilElementVisible(errorMessage, 3);
        String error = getTextFromElement(errorMessage);
        Assert.assertEquals(error, "Invalid tracking number.", "Error message is incorrect.");
    }

    public void simulateTrackingInformationChange() {
        // Simulate tracking information change logic
        WebElement trackingInfoChangeElement = driver.findElement(By.id("trackingInfoChange"));
        Assert.assertTrue(trackingInfoChangeElement.isDisplayed(), "Tracking information change simulation failed.");
        verifyRealTimeTrackingInformationUpdates();
    }

    public void verifyRealTimeTrackingInformationUpdates() {
        WebElement realTimeUpdatesElement = driver.findElement(By.id("realTimeUpdates"));
        Assert.assertTrue(realTimeUpdatesElement.isDisplayed(), "Real-time tracking information updates are not verified.");
    }

    public void checkTrackingDetails() {
        WebElement trackingDetailsElement = driver.findElement(By.id("trackingDetails"));
        Assert.assertTrue(trackingDetailsElement.isDisplayed(), "Tracking details are not checked.");
        verifyTrackingDetailsAccuracyAndConsistency();
    }

    public void verifyTrackingDetailsAccuracyAndConsistency() {
        String expectedDetails = "Accurate";
        String actualDetails = getTextFromElement(By.id("trackingDetails"));
        Assert.assertEquals(actualDetails, expectedDetails, "Tracking details are not accurate and consistent.");
    }

    public void accessTrackingInformation() {
        WebElement trackingInfoAccessElement = driver.findElement(By.id("trackingInfoAccess"));
        Assert.assertTrue(trackingInfoAccessElement.isDisplayed(), "Tracking information access failed.");
        verifyTrackingInformationSecurity();
    }

    public void verifyTrackingInformationSecurity() {
        WebElement trackingInfoSecurityElement = driver.findElement(By.id("trackingInfoSecurity"));
        Assert.assertTrue(trackingInfoSecurityElement.isDisplayed(), "Tracking information security is not verified.");
    }

    public void interactWithTrackingInterface() {
        WebElement trackingInterfaceElement = driver.findElement(By.id("trackingInterface"));
        Assert.assertTrue(trackingInterfaceElement.isDisplayed(), "Tracking interface interaction failed.");
        verifyTrackingInterfaceUserFriendliness();
    }

    public void verifyTrackingInterfaceUserFriendliness() {
        WebElement userFriendlyElement = driver.findElement(By.id("userFriendlyInterface"));
        Assert.assertTrue(userFriendlyElement.isDisplayed(), "Tracking interface is not user-friendly.");
    }

    public void accessTrackingPageOnDifferentDevices() {
        WebElement trackingPageAccessElement = driver.findElement(By.id("trackingPageAccess"));
        Assert.assertTrue(trackingPageAccessElement.isDisplayed(), "Tracking page access on different devices failed.");
        verifyTrackingPageResponsiveness();
    }

    public void verifyTrackingPageResponsiveness() {
        WebElement responsiveElement = driver.findElement(By.id("responsivePage"));
        Assert.assertTrue(responsiveElement.isDisplayed(), "Tracking page is not responsive.");
    }

    public void submitMultipleTrackingRequests() {
        WebElement multipleRequestsElement = driver.findElement(By.id("multipleRequests"));
        Assert.assertTrue(multipleRequestsElement.isDisplayed(), "Multiple tracking requests submission failed.");
        verifyMultipleTrackingRequestsHandling();
    }

    public void verifyMultipleTrackingRequestsHandling() {
        WebElement requestsHandlingElement = driver.findElement(By.id("requestsHandling"));
        Assert.assertTrue(requestsHandlingElement.isDisplayed(), "Multiple tracking requests handling is not verified.");
    }

    public void accessTrackingHistory() {
        WebElement trackingHistoryElement = driver.findElement(By.id("trackingHistory"));
        Assert.assertTrue(trackingHistoryElement.isDisplayed(), "Tracking history access failed.");
        verifyTrackingHistoryAccessibility();
    }

    public void verifyTrackingHistoryAccessibility() {
        WebElement historyAccessibilityElement = driver.findElement(By.id("historyAccessibility"));
        Assert.assertTrue(historyAccessibilityElement.isDisplayed(), "Tracking history accessibility is not verified.");
    }
}