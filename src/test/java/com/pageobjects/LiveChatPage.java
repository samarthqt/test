package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LiveChatPage extends WebReusableComponents {

    protected By btnInitiateChat = By.id("initiateChat");
    protected By chatAcknowledgement = By.id("chatAcknowledgement");
    protected By automatedMessage = By.id("automatedMessage");
    protected By messageOptions = By.id("messageOptions");

    public LiveChatPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String page) {
        // Dummy implementation for navigation
        driver.get("http://example.com/" + page);
    }

    public void initiateLiveChat() {
        waitUntilElementVisible(btnInitiateChat, 3);
        clickElement(btnInitiateChat);
    }

    public void verifyChatAcknowledgement(String responseTime) {
        waitUntilElementVisible(chatAcknowledgement, 3);
        String acknowledgementText = getTextFromElement(chatAcknowledgement);
        Assert.assertTrue(acknowledgementText.contains(responseTime), "Chat was not acknowledged in time.");
    }

    public void simulateAgentsUnavailable() {
        // Simulate agents being unavailable
    }

    public void verifyAutomatedMessageReceived() {
        waitUntilElementVisible(automatedMessage, 3);
        String messageText = getTextFromElement(automatedMessage);
        Assert.assertTrue(messageText.contains("automated"), "Automated message not received.");
    }

    public void verifyMessageOptions() {
        waitUntilElementVisible(messageOptions, 3);
        String optionsText = getTextFromElement(messageOptions);
        Assert.assertTrue(optionsText.contains("leave a message") || optionsText.contains("estimated wait times"), "Message options not available.");
    }
}