package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SMSNotificationPage extends WebReusableComponents {

    protected By phoneNumberField = By.id("phoneNumber");
    protected By supportRequestButton = By.id("submitSupportRequest");
    protected By ticketIDField = By.id("ticketID");
    protected By smsNotificationToggle = By.id("smsNotificationToggle");
    protected By smsContentField = By.id("smsContent");
    protected By smsSenderField = By.id("smsSender");
    protected By smsFormatField = By.id("smsFormat");
    protected By smsDeliveryTimeField = By.id("smsDeliveryTime");
    protected By smsLinkField = By.id("smsLink");
    protected By smsNetworkField = By.id("smsNetwork");
    protected By smsInfoField = By.id("smsInfo");
    protected By smsChargesField = By.id("smsCharges");
    protected By smsReplyField = By.id("smsReply");
    protected By smsSpamField = By.id("smsSpam");

    public SMSNotificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyRegisteredPhoneNumber(String phoneNumber) {
        waitUntilElementVisible(phoneNumberField, 3);
        String actualPhoneNumber = getTextFromElement(phoneNumberField);
        Assert.assertEquals(actualPhoneNumber, phoneNumber, "Phone number does not match.");
    }

    public void submitSupportRequest() {
        waitUntilElementVisible(supportRequestButton, 3);
        clickElement(supportRequestButton);
    }

    public void verifyTicketIDGenerated() {
        waitUntilElementVisible(ticketIDField, 3);
        String ticketID = getTextFromElement(ticketIDField);
        Assert.assertNotNull(ticketID, "Ticket ID was not generated.");
    }

    public void verifySMSNotificationsEnabled() {
        waitUntilElementVisible(smsNotificationToggle, 3);
        boolean isEnabled = isElementSelected(smsNotificationToggle);
        Assert.assertTrue(isEnabled, "SMS notifications are not enabled.");
    }

    public void verifySupportTicketID(String ticketID) {
        waitUntilElementVisible(ticketIDField, 3);
        String actualTicketID = getTextFromElement(ticketIDField);
        Assert.assertEquals(actualTicketID, ticketID, "Support ticket ID does not match.");
    }

    public void sendSupportResponse() {
        // Logic to send support response
        // Assuming sending response involves interacting with some elements
        WebElement responseField = driver.findElement(By.id("responseField"));
        enterText(responseField, "Support response");
        WebElement sendButton = driver.findElement(By.id("sendButton"));
        clickElement(sendButton);
    }

    public void verifySMSNotificationReceived() {
        waitUntilElementVisible(smsContentField, 3);
        String smsContent = getTextFromElement(smsContentField);
        Assert.assertNotNull(smsContent, "SMS notification was not received.");
    }

    public void verifySMSContentDetails() {
        waitUntilElementVisible(smsContentField, 3);
        String smsContent = getTextFromElement(smsContentField);
        Assert.assertTrue(smsContent.contains("support response"), "SMS content details are incorrect.");
    }

    public void verifySMSSenderNumber() {
        waitUntilElementVisible(smsSenderField, 3);
        String smsSender = getTextFromElement(smsSenderField);
        Assert.assertEquals(smsSender, "DesignatedSupportNumber", "SMS sender number is incorrect.");
    }

    public void verifySMSFormatting() {
        waitUntilElementVisible(smsFormatField, 3);
        String smsFormat = getTextFromElement(smsFormatField);
        Assert.assertTrue(smsFormat.matches(".*readable.*"), "SMS is not well-formatted.");
    }

    public void verifySMSDeliveryTime() {
        waitUntilElementVisible(smsDeliveryTimeField, 3);
        String deliveryTime = getTextFromElement(smsDeliveryTimeField);
        Assert.assertTrue(Integer.parseInt(deliveryTime) <= 5, "SMS was not received within 5 minutes.");
    }

    public void verifyNoDuplicateSMS() {
        // Logic to verify no duplicate SMS
        // Assuming checking for duplicates involves some list or database query
        String smsContent = getTextFromElement(smsContentField);
        boolean isDuplicate = checkForDuplicateSMS(smsContent);
        Assert.assertFalse(isDuplicate, "Duplicate SMS found.");
    }

    public void verifySMSLinkToSupportRequest() {
        waitUntilElementVisible(smsLinkField, 3);
        String smsLink = getTextFromElement(smsLinkField);
        Assert.assertTrue(smsLink.contains("support request"), "SMS link to support request is missing.");
    }

    public void verifySMSOnDifferentNetworks() {
        waitUntilElementVisible(smsNetworkField, 3);
        String smsNetwork = getTextFromElement(smsNetworkField);
        Assert.assertTrue(smsNetwork.contains("accessible"), "SMS is not accessible on different networks.");
    }

    public void verifySMSContainsNecessaryInfo() {
        waitUntilElementVisible(smsInfoField, 3);
        String smsInfo = getTextFromElement(smsInfoField);
        Assert.assertTrue(smsInfo.contains("necessary information"), "SMS contains unnecessary information.");
    }

    public void verifyNoChargesForSMS() {
        waitUntilElementVisible(smsChargesField, 3);
        String smsCharges = getTextFromElement(smsChargesField);
        Assert.assertEquals(smsCharges, "0", "User is charged for receiving SMS.");
    }

    public void replyToSMS() {
        waitUntilElementVisible(smsReplyField, 3);
        enterText(smsReplyField, "Reply to support");
        WebElement replyButton = driver.findElement(By.id("replyButton"));
        clickElement(replyButton);
    }

    public void verifyReplyDirectedToSupportTeam() {
        // Logic to verify reply is directed to support team
        // Assuming checking involves some confirmation message or status
        WebElement replyStatus = driver.findElement(By.id("replyStatus"));
        String status = getTextFromElement(replyStatus);
        Assert.assertTrue(status.contains("directed to support"), "Reply was not directed to support team.");
    }

    public void verifySMSNotMarkedAsSpam() {
        waitUntilElementVisible(smsSpamField, 3);
        boolean isSpam = isElementSelected(smsSpamField);
        Assert.assertFalse(isSpam, "SMS is marked as spam.");
    }

    private boolean checkForDuplicateSMS(String smsContent) {
        // Placeholder logic for checking duplicate SMS
        // This should be replaced with actual logic to check for duplicates
        return false;
    }
}