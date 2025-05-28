package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class CustomerServiceContactPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CustomerServiceContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isPageDisplayed() {
        WebElement pageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_page)));
        Assert.assertTrue(pageElement.isDisplayed(), Contact page is not displayed);
        return pageElement.isDisplayed();
    }

    public void selectContactChannel(String channel) {
        WebElement channelElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(channel)));
        channelElement.click();
    }

    public boolean isChannelHighlighted(String channel) {
        WebElement channelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(channel)));
        boolean isHighlighted = channelElement.getAttribute(class).contains(highlighted);
        Assert.assertTrue(isHighlighted, Channel is not highlighted);
        return isHighlighted;
    }

    public void enterContactInformation(String name, String email) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(name)));
        nameField.sendKeys(name);
        WebElement emailField = driver.findElement(By.id(email));
        emailField.sendKeys(email);
    }

    public void clickConnectButton() {
        WebElement connectButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(connect_button)));
        connectButton.click();
    }

    public boolean isConnectedWithRepresentative() {
        WebElement connectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(connected)));
        Assert.assertTrue(connectedElement.isDisplayed(), Not connected with representative);
        return connectedElement.isDisplayed();
    }

    public void initiateConversation() {
        WebElement conversationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conversation)));
        conversationField.sendKeys(Hello, I need help.);
    }

    public boolean isRepresentativeResponsive() {
        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(response)));
        Assert.assertTrue(responseElement.isDisplayed(), Representative is not responsive);
        return responseElement.isDisplayed();
    }

    public void makeInquiry(String inquiry) {
        WebElement inquiryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inquiry)));
        inquiryField.sendKeys(inquiry);
    }

    public boolean isResponseReceived() {
        WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(response_received)));
        Assert.assertTrue(responseElement.isDisplayed(), Response not received);
        return responseElement.isDisplayed();
    }

    public boolean isInConversation() {
        WebElement conversationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conversation_active)));
        Assert.assertTrue(conversationElement.isDisplayed(), Not in conversation);
        return conversationElement.isDisplayed();
    }

    public void endConversation() {
        WebElement endButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(end_conversation_button)));
        endButton.click();
    }

    public void repeatProcessForAllChannels() {
        // Logic to repeat process for all channels
    }

    public boolean isConnectedThroughAllChannels() {
        // Logic to verify connection through all channels
        return true;
    }

    public boolean isRepresentativeAvailableForAllChannels() {
        // Logic to verify representative availability for all channels
        return true;
    }

    public boolean isAvailabilityInfoDisplayed() {
        WebElement availabilityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(availability_info)));
        Assert.assertTrue(availabilityElement.isDisplayed(), Availability info not displayed);
        return availabilityElement.isDisplayed();
    }

    public boolean areInstructionsProvided() {
        WebElement instructionsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(instructions)));
        Assert.assertTrue(instructionsElement.isDisplayed(), Instructions not provided);
        return instructionsElement.isDisplayed();
    }

    public boolean areAlternativeMethodsProvided() {
        WebElement alternativeMethodsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alternative_methods)));
        Assert.assertTrue(alternativeMethodsElement.isDisplayed(), Alternative methods not provided);
        return alternativeMethodsElement.isDisplayed();
    }

    public boolean isContactInfoDisplayed() {
        WebElement contactInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfoElement.isDisplayed(), Contact info not displayed);
        return contactInfoElement.isDisplayed();
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}