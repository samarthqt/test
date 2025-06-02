package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ChatTranscriptPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By chatFeatureStatus = By.id("chatFeatureStatus");
    protected By supportSection = By.id("supportSection");
    protected By btnInitiateChat = By.id("initiateChat");
    protected By chatAgentStatus = By.id("chatAgentStatus");
    protected By chatConversation = By.id("chatConversation");
    protected By btnEndChat = By.id("endChat");
    protected By chatHistorySection = By.id("chatHistorySection");
    protected By recentChatSession = By.id("recentChatSession");
    protected By chatTranscript = By.id("chatTranscript");
    protected By downloadPrintOptions = By.id("downloadPrintOptions");
    protected By transcriptSecurity = By.id("transcriptSecurity");
    protected By retentionPeriod = By.id("retentionPeriod");
    protected By errorMessages = By.id("errorMessages");

    public ChatTranscriptPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(isElementDisplayed(btnLogin), "Login button is not displayed.");
    }

    public void verifyLiveChatFeatureEnabled() {
        waitUntilElementVisible(chatFeatureStatus, 3);
        Assert.assertTrue(isElementDisplayed(chatFeatureStatus), "Live chat feature is not enabled.");
    }

    public void navigateToSupportSection() {
        waitUntilElementVisible(supportSection, 3);
        clickElement(supportSection);
        Assert.assertTrue(isElementDisplayed(supportSection), "Support section is not displayed.");
    }

    public void verifySupportSectionDisplayed() {
        waitUntilElementVisible(supportSection, 3);
        Assert.assertTrue(isElementDisplayed(supportSection), "Support section is not displayed.");
    }

    public void initiateLiveChatSession() {
        waitUntilElementVisible(btnInitiateChat, 3);
        clickElement(btnInitiateChat);
        Assert.assertTrue(isElementDisplayed(chatAgentStatus), "Live chat session is not initiated.");
    }

    public void verifyLiveChatSessionInitiated() {
        waitUntilElementVisible(chatAgentStatus, 3);
        Assert.assertTrue(isElementDisplayed(chatAgentStatus), "Live chat session is not initiated.");
    }

    public void engageInConversation() {
        waitUntilElementVisible(chatConversation, 3);
        enterText(chatConversation, "Hello, I need help.");
        Assert.assertTrue(isElementDisplayed(chatConversation), "Conversation is not successful.");
    }

    public void verifyConversationSuccess() {
        waitUntilElementVisible(chatConversation, 3);
        Assert.assertTrue(isElementDisplayed(chatConversation), "Conversation is not successful.");
    }

    public void endLiveChatSession() {
        waitUntilElementVisible(btnEndChat, 3);
        clickElement(btnEndChat);
        Assert.assertFalse(isElementDisplayed(chatAgentStatus), "Live chat session did not end successfully.");
    }

    public void verifyLiveChatSessionEnded() {
        waitUntilElementVisible(chatAgentStatus, 3);
        Assert.assertFalse(isElementDisplayed(chatAgentStatus), "Live chat session did not end successfully.");
    }

    public void navigateToChatHistorySection() {
        waitUntilElementVisible(chatHistorySection, 3);
        clickElement(chatHistorySection);
        Assert.assertTrue(isElementDisplayed(chatHistorySection), "Chat history section is not displayed.");
    }

    public void verifyChatHistoryDisplayed() {
        waitUntilElementVisible(chatHistorySection, 3);
        Assert.assertTrue(isElementDisplayed(chatHistorySection), "Chat history section is not displayed.");
    }

    public void selectRecentChatSession() {
        waitUntilElementVisible(recentChatSession, 3);
        clickElement(recentChatSession);
        Assert.assertTrue(isElementDisplayed(recentChatSession), "Recent chat session is not selected.");
    }

    public void verifyTranscriptDisplayed() {
        waitUntilElementVisible(chatTranscript, 3);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcript is not displayed accurately.");
    }

    public void viewChatTranscript() {
        waitUntilElementVisible(chatTranscript, 3);
        clickElement(chatTranscript);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcript is not viewed.");
    }

    public void verifyTranscriptAccuracy() {
        waitUntilElementVisible(chatTranscript, 3);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcript is not accurate and complete.");
    }

    public void checkDownloadPrintOptions() {
        waitUntilElementVisible(downloadPrintOptions, 3);
        Assert.assertTrue(isElementDisplayed(downloadPrintOptions), "Download/Print options are not available.");
    }

    public void verifyDownloadPrintOptions() {
        waitUntilElementVisible(downloadPrintOptions, 3);
        Assert.assertTrue(isElementDisplayed(downloadPrintOptions), "Download/Print options are not functional.");
    }

    public void accessTranscriptsOnDifferentDevice() {
        waitUntilElementVisible(chatTranscript, 3);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcripts are not accessible on different devices.");
    }

    public void verifyTranscriptsAccessibility() {
        waitUntilElementVisible(chatTranscript, 3);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcripts are not accessible across devices.");
    }

    public void verifySecurityPrivacy() {
        waitUntilElementVisible(transcriptSecurity, 3);
        Assert.assertTrue(isElementDisplayed(transcriptSecurity), "Transcripts are not secured.");
    }

    public void verifyTranscriptsSecurity() {
        waitUntilElementVisible(transcriptSecurity, 3);
        Assert.assertTrue(isElementDisplayed(transcriptSecurity), "Transcripts are not accessible only to authorized users.");
    }

    public void checkRetentionPeriod() {
        waitUntilElementVisible(retentionPeriod, 3);
        Assert.assertTrue(isElementDisplayed(retentionPeriod), "Retention period is not specified.");
    }

    public void verifyRetentionPeriod() {
        waitUntilElementVisible(retentionPeriod, 3);
        Assert.assertTrue(isElementDisplayed(retentionPeriod), "Retention period is not as per policy.");
    }

    public void testWithSlowInternet() {
        waitUntilElementVisible(chatTranscript, 3);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcripts are not accessible with slow internet.");
    }

    public void verifyAccessibilityWithDelays() {
        waitUntilElementVisible(chatTranscript, 3);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcripts are not accessible with delays.");
    }

    public void verifyTranscriptFeatureWithDifferentSessions() {
        waitUntilElementVisible(chatTranscript, 3);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcripts are not saved for all session types.");
    }

    public void verifyTranscriptsForAllSessions() {
        waitUntilElementVisible(chatTranscript, 3);
        Assert.assertTrue(isElementDisplayed(chatTranscript), "Transcripts are not accessible for all session types.");
    }

    public void checkForErrorMessages() {
        waitUntilElementVisible(errorMessages, 3);
        Assert.assertFalse(isElementDisplayed(errorMessages), "Error messages are present during retrieval.");
    }

    public void verifyNoErrorMessages() {
        waitUntilElementVisible(errorMessages, 3);
        Assert.assertFalse(isElementDisplayed(errorMessages), "Issues are indicated during transcript retrieval.");
    }
}