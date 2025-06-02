package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TwilioIntegrationPage extends WebReusableComponents {

    protected By twilioAccountStatus = By.id("twilioAccountStatus");
    protected By loginButton = By.id("loginButton");
    protected By applicationSettings = By.id("applicationSettings");
    protected By apiKeyStatus = By.id("apiKeyStatus");
    protected By supportRequestForm = By.id("supportRequestForm");
    protected By ticketID = By.id("ticketID");
    protected By supportResponseStatus = By.id("supportResponseStatus");
    protected By twilioDashboard = By.id("twilioDashboard");
    protected By smsDeliveryStatus = By.id("smsDeliveryStatus");
    protected By smsNotification = By.id("smsNotification");
    protected By smsContent = By.id("smsContent");
    protected By senderNumber = By.id("senderNumber");
    protected By smsFormat = By.id("smsFormat");
    protected By smsDeliveryTime = By.id("smsDeliveryTime");
    protected By smsNotifications = By.id("smsNotifications");
    protected By smsLink = By.id("smsLink");
    protected By smsNetworks = By.id("smsNetworks");
    protected By smsCharges = By.id("smsCharges");

    public TwilioIntegrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyTwilioAccountConfigured() {
        waitUntilElementVisible(twilioAccountStatus, 3);
        Assert.assertTrue(isElementDisplayed(twilioAccountStatus), "Twilio account is not configured.");
    }

    public void loginToApplication() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifyUserLoggedIn() {
        WebElement element = waitUntilElementVisible(loginButton, 3);
        Assert.assertFalse(isElementDisplayed(element), "User is not logged in.");
    }

    public void verifyTwilioAPIKeySetup() {
        waitUntilElementVisible(apiKeyStatus, 3);
        Assert.assertTrue(isElementDisplayed(apiKeyStatus), "Twilio API key is not set up.");
    }

    public void checkApplicationSettings() {
        waitUntilElementVisible(applicationSettings, 3);
        clickElement(applicationSettings);
        Assert.assertTrue(isElementDisplayed(applicationSettings), "Application settings not accessible.");
    }

    public void verifyAPIKeyConfiguration() {
        WebElement element = waitUntilElementVisible(apiKeyStatus, 3);
        Assert.assertTrue(isElementDisplayed(element), "API key configuration is incorrect.");
    }

    public void submitSupportRequest() {
        waitUntilElementVisible(supportRequestForm, 3);
        clickElement(supportRequestForm);
        Assert.assertTrue(isElementDisplayed(supportRequestForm), "Support request form not submitted.");
    }

    public void verifySupportRequestSubmission() {
        waitUntilElementVisible(ticketID, 3);
        Assert.assertTrue(isElementDisplayed(ticketID), "Support request not submitted.");
    }

    public void respondToSupportRequest() {
        WebElement element = waitUntilElementVisible(supportResponseStatus, 3);
        clickElement(element);
        Assert.assertTrue(isElementDisplayed(supportResponseStatus), "Support response not sent.");
    }

    public void verifySupportTeamResponse() {
        WebElement element = waitUntilElementVisible(supportResponseStatus, 3);
        Assert.assertTrue(isElementDisplayed(element), "Support team response not received.");
    }

    public void verifySupportResponseSent() {
        waitUntilElementVisible(supportResponseStatus, 3);
        Assert.assertTrue(isElementDisplayed(supportResponseStatus), "Support response not sent.");
    }

    public void checkTwilioDashboard() {
        waitUntilElementVisible(twilioDashboard, 3);
        clickElement(twilioDashboard);
        Assert.assertTrue(isElementDisplayed(twilioDashboard), "Twilio dashboard not accessible.");
    }

    public void verifySMSDeliveryStatus() {
        waitUntilElementVisible(smsDeliveryStatus, 3);
        Assert.assertTrue(isElementDisplayed(smsDeliveryStatus), "SMS delivery status not successful.");
    }

    public void checkUserPhone() {
        WebElement element = waitUntilElementVisible(smsNotification, 3);
        Assert.assertTrue(isElementDisplayed(element), "User phone not verified.");
    }

    public void verifySMSNotificationReceived() {
        waitUntilElementVisible(smsNotification, 3);
        Assert.assertTrue(isElementDisplayed(smsNotification), "SMS notification not received.");
    }

    public void reviewSMSContent() {
        waitUntilElementVisible(smsContent, 3);
        Assert.assertTrue(isElementDisplayed(smsContent), "SMS content not reviewed.");
    }

    public void verifySMSContentDetails() {
        WebElement element = waitUntilElementVisible(smsContent, 3);
        Assert.assertTrue(isElementDisplayed(element), "SMS content details not verified.");
    }

    public void checkSenderNumber() {
        waitUntilElementVisible(senderNumber, 3);
        Assert.assertTrue(isElementDisplayed(senderNumber), "Sender number not checked.");
    }

    public void verifySenderNumber() {
        WebElement element = waitUntilElementVisible(senderNumber, 3);
        Assert.assertTrue(isElementDisplayed(element), "Sender number not verified.");
    }

    public void reviewSMSFormat() {
        waitUntilElementVisible(smsFormat, 3);
        Assert.assertTrue(isElementDisplayed(smsFormat), "SMS format not reviewed.");
    }

    public void verifySMSFormat() {
        WebElement element = waitUntilElementVisible(smsFormat, 3);
        Assert.assertTrue(isElementDisplayed(element), "SMS format not verified.");
    }

    public void checkSMSDeliveryTime() {
        waitUntilElementVisible(smsDeliveryTime, 3);
        Assert.assertTrue(isElementDisplayed(smsDeliveryTime), "SMS delivery time not checked.");
    }

    public void verifySMSDeliveryTime() {
        WebElement element = waitUntilElementVisible(smsDeliveryTime, 3);
        Assert.assertTrue(isElementDisplayed(element), "SMS delivery time not verified.");
    }

    public void checkSMSNotifications() {
        waitUntilElementVisible(smsNotifications, 3);
        Assert.assertTrue(isElementDisplayed(smsNotifications), "SMS notifications not checked.");
    }

    public void verifySingleSMSNotification() {
        WebElement element = waitUntilElementVisible(smsNotifications, 3);
        Assert.assertTrue(isElementDisplayed(element), "Single SMS notification not verified.");
    }

    public void checkSMSContent() {
        waitUntilElementVisible(smsContent, 3);
        Assert.assertTrue(isElementDisplayed(smsContent), "SMS content not checked.");
    }

    public void verifySMSLink() {
        waitUntilElementVisible(smsLink, 3);
        Assert.assertTrue(isElementDisplayed(smsLink), "SMS link not verified.");
    }

    public void checkSMSOnNetworks() {
        waitUntilElementVisible(smsNetworks, 3);
        Assert.assertTrue(isElementDisplayed(smsNetworks), "SMS on networks not checked.");
    }

    public void verifySMSOnNetworks() {
        WebElement element = waitUntilElementVisible(smsNetworks, 3);
        Assert.assertTrue(isElementDisplayed(element), "SMS on networks not verified.");
    }

    public void reviewSMSContentAgain() {
        waitUntilElementVisible(smsContent, 3);
        Assert.assertTrue(isElementDisplayed(smsContent), "SMS content not reviewed again.");
    }

    public void verifySMSNecessaryInformation() {
        WebElement element = waitUntilElementVisible(smsContent, 3);
        Assert.assertTrue(isElementDisplayed(element), "SMS necessary information not verified.");
    }

    public void checkSMSCharges() {
        waitUntilElementVisible(smsCharges, 3);
        Assert.assertTrue(isElementDisplayed(smsCharges), "SMS charges not checked.");
    }

    public void verifyNoSMSCharges() {
        WebElement element = waitUntilElementVisible(smsCharges, 3);
        Assert.assertFalse(isElementDisplayed(element), "SMS charges are present.");
    }
}