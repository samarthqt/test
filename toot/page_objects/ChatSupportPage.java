package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class ChatSupportPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By startChatButtonLocator = By.id(start_chat_button);
    private final By chatSessionLocator = By.id(chat_session);
    private final By welcomeMessageLocator = By.id(welcome_message);
    private final By sendRequestButtonLocator = By.id(send_request_button);
    private final By notificationLocator = By.id(notification);
    private final By chatInterfaceLocator = By.id(chat_interface);
    private final By messageFieldLocator = By.id(message_field);
    private final By sendButtonLocator = By.id(send_button);
    private final By chatWindowLocator = By.id(chat_window);
    private final By endChatButtonLocator = By.id(end_chat_button);
    private final By feedbackFormLocator = By.id(feedback_form);
    private final By chatSummaryLocator = By.id(chat_summary);
    private final By timeoutNotificationLocator = By.id(timeout_notification);

    public ChatSupportPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToChatSupportPage() {
        driver.get(http://example.com/chat-support);
        Assert.assertTrue(driver.getCurrentUrl().contains(chat-support), Navigation to Chat Support Page failed.);
    }

    public void clickStartChatButton() {
        WebElement startChatButton = wait.until(ExpectedConditions.visibilityOfElementLocated(startChatButtonLocator));
        startChatButton.click();
        Assert.assertTrue(isChatSessionInitiated(), Chat session initiation failed.);
    }

    public boolean isChatSessionInitiated() {
        WebElement chatSession = wait.until(ExpectedConditions.visibilityOfElementLocated(chatSessionLocator));
        return chatSession.isDisplayed();
    }

    public boolean isWelcomeMessageDisplayed() {
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageLocator));
        return welcomeMessage.isDisplayed();
    }

    public void sendChatRequestToRepresentative() {
        WebElement sendRequestButton = wait.until(ExpectedConditions.visibilityOfElementLocated(sendRequestButtonLocator));
        sendRequestButton.click();
        Assert.assertTrue(isNotificationReceived(), Notification not received after sending chat request.);
    }

    public boolean isNotificationReceived() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationLocator));
        return notification.isDisplayed();
    }

    public boolean isChatInterfaceDisplayed() {
        WebElement chatInterface = wait.until(ExpectedConditions.visibilityOfElementLocated(chatInterfaceLocator));
        return chatInterface.isDisplayed();
    }

    public void typeMessage(String message) {
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(messageFieldLocator));
        messageField.sendKeys(message);
        Assert.assertTrue(messageField.getAttribute(value).equals(message), Message typing failed.);
    }

    public void clickSendButton() {
        WebElement sendButton = driver.findElement(sendButtonLocator);
        sendButton.click();
        Assert.assertTrue(isMessageDisplayed(Your message), Message sending failed.);
    }

    public boolean isMessageDisplayed(String message) {
        WebElement chatWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(chatWindowLocator));
        return chatWindow.getText().contains(message);
    }

    public void clickEndChatButton() {
        WebElement endChatButton = wait.until(ExpectedConditions.visibilityOfElementLocated(endChatButtonLocator));
        endChatButton.click();
        Assert.assertTrue(isFeedbackFormDisplayed(), Feedback form not displayed after ending chat.);
    }

    public boolean isFeedbackFormDisplayed() {
        WebElement feedbackForm = wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackFormLocator));
        return feedbackForm.isDisplayed();
    }

    public boolean isChatSummaryDisplayed() {
        WebElement chatSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(chatSummaryLocator));
        return chatSummary.isDisplayed();
    }

    public boolean isTimeoutNotificationDisplayed() {
        WebElement timeoutNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(timeoutNotificationLocator));
        return timeoutNotification.isDisplayed();
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}