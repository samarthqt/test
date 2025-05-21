package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class EmailPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailSubjectLocator = By.id(email_subject);
    private final By emailBodyLocator = By.id(email_body);
    private final By statusDropdownLocator = By.id(status_dropdown);
    private final By updateButtonLocator = By.id(update_button);
    private final By emailSentMessageLocator = By.id(email_sent_message);
    private final By errorLogLocator = By.id(error_log);
    private final By failureNotificationLocator = By.id(failure_notification);

    public EmailPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getEmailSubject() {
        WebElement emailSubject = wait.until(ExpectedConditions.visibilityOfElementLocated(emailSubjectLocator));
        String subjectText = emailSubject.getText();
        Assert.assertNotNull(subjectText, Email subject is null);
        return subjectText;
    }

    public String getEmailBody() {
        WebElement emailBody = wait.until(ExpectedConditions.visibilityOfElementLocated(emailBodyLocator));
        String bodyText = emailBody.getText();
        Assert.assertNotNull(bodyText, Email body is null);
        return bodyText;
    }

    public void updateOrderStatus(final String status) {
        WebElement statusDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(statusDropdownLocator));
        statusDropdown.sendKeys(status);
        WebElement updateButton = driver.findElement(updateButtonLocator);
        updateButton.click();
        Assert.assertTrue(isEmailSent(), Email was not sent after updating order status);
    }

    public boolean isEmailSent() {
        WebElement emailSentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(emailSentMessageLocator));
        boolean isDisplayed = emailSentMessage.isDisplayed();
        Assert.assertTrue(isDisplayed, Email sent message is not displayed);
        return isDisplayed;
    }

    public boolean isErrorLogged() {
        WebElement errorLog = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLogLocator));
        boolean isDisplayed = errorLog.isDisplayed();
        Assert.assertTrue(isDisplayed, Error log is not displayed);
        return isDisplayed;
    }

    public boolean isFailureNotificationDisplayed() {
        WebElement failureNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(failureNotificationLocator));
        boolean isDisplayed = failureNotification.isDisplayed();
        Assert.assertTrue(isDisplayed, Failure notification is not displayed);
        return isDisplayed;
    }
}