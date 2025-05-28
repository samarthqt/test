package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CustomerServicePage extends WebReusableComponents {

    protected By customerServicePage = By.id("customerServicePage");
    protected By phoneContactInfo = By.id("phoneContactInfo");
    protected By emailContactInfo = By.id("emailContactInfo");
    protected By liveChatOption = By.id("liveChatOption");
    protected By liveChatWindow = By.id("liveChatWindow");
    protected By alternativeContactMethods = By.id("alternativeContactMethods");
    protected By responseTimeInfo = By.id("responseTimeInfo");
    protected By workingHoursInfo = By.id("workingHoursInfo");
    protected By printButton = By.id("printButton");
    protected By contactInfoSection = By.id("contactInfoSection");
    protected By phoneNumbers = By.cssSelector(".phone-number");
    protected By emailAddresses = By.cssSelector(".email-address");
    protected By chatLinks = By.cssSelector(".chat-link");

    public CustomerServicePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToCustomerServicePage() {
        navigateToUrl("/customer-service");
        waitUntilElementVisible(customerServicePage, 3);
    }

    public void verifyCustomerServicePageDisplayed() {
        Assert.assertTrue(isElementDisplayed(customerServicePage), "Customer service page is not displayed.");
    }

    public void verifyPhoneContactInformation() {
        Assert.assertTrue(isElementDisplayed(phoneContactInfo), "Phone contact information is not displayed.");
    }

    public void verifyEmailContactInformation() {
        Assert.assertTrue(isElementDisplayed(emailContactInfo), "Email contact information is not displayed.");
    }

    public void verifyLiveChatOptionAvailable() {
        Assert.assertTrue(isElementDisplayed(liveChatOption), "Live chat option is not available.");
    }

    public void clickPhoneContactInformation() {
        clickElement(phoneContactInfo);
    }

    public void verifyPhoneDialerOpened() {
        Assert.assertTrue(isElementDisplayed(By.id("phoneDialer")), "Phone dialer is not opened.");
    }

    public void clickEmailContactInformation() {
        clickElement(emailContactInfo);
    }

    public void verifyEmailClientOpened() {
        Assert.assertTrue(isElementDisplayed(By.id("emailClient")), "Email client is not opened.");
    }

    public void clickLiveChatOption() {
        clickElement(liveChatOption);
    }

    public void verifyLiveChatWindowOpened() {
        Assert.assertTrue(isElementDisplayed(liveChatWindow), "Live chat window is not opened.");
    }

    public void openLiveChatWindow() {
        clickElement(liveChatOption);
        waitUntilElementVisible(liveChatWindow, 3);
    }

    public void enterMessageInLiveChat(String message) {
        WebElement chatInput = driver.findElement(By.id("chatInput"));
        chatInput.sendKeys(message);
        WebElement sendButton = driver.findElement(By.id("sendButton"));
        sendButton.click();
    }

    public void verifyMessageSentAndResponseReceived() {
        WebElement response = driver.findElement(By.id("chatResponse"));
        Assert.assertTrue(response.isDisplayed(), "Response not received.");
    }

    public void verifyAlternativeContactMethods() {
        Assert.assertTrue(isElementDisplayed(alternativeContactMethods), "Alternative contact methods are not displayed.");
    }

    public void verifyResponseTimeMentioned() {
        Assert.assertTrue(isElementDisplayed(responseTimeInfo), "Response time is not mentioned.");
    }

    public void verifyWorkingHoursMentioned() {
        Assert.assertTrue(isElementDisplayed(workingHoursInfo), "Working hours are not mentioned.");
    }

    public void printContactInformationPage() {
        clickElement(printButton);
    }

    public void verifyContactInformationFormattedForPrinting() {
        WebElement printPreview = driver.findElement(By.id("printPreview"));
        Assert.assertTrue(printPreview.isDisplayed(), "Contact information is not formatted for printing.");
    }

    public void navigateToCustomerServiceSection() {
        waitUntilElementVisible(contactInfoSection, 3);
        clickElement(contactInfoSection);
    }

    public void checkContactInformation() {
        waitUntilElementVisible(phoneNumbers, 3);
        waitUntilElementVisible(emailAddresses, 3);
        waitUntilElementVisible(chatLinks, 3);
    }

    public void verifyContactInformationDisplayed() {
        Assert.assertTrue(isElementDisplayed(phoneNumbers), "Phone numbers are not displayed.");
        Assert.assertTrue(isElementDisplayed(emailAddresses), "Email addresses are not displayed.");
        Assert.assertTrue(isElementDisplayed(chatLinks), "Chat links are not displayed.");
    }

    public void verifyPhoneNumbers() {
        WebElement phoneNumber = driver.findElement(phoneNumbers);
        Assert.assertTrue(phoneNumber.isDisplayed(), "Phone number is not displayed.");
    }

    public void assertPhoneNumbersValid() {
        WebElement phoneNumber = driver.findElement(phoneNumbers);
        Assert.assertTrue(phoneNumber.getText().matches("\\d{10}"), "Phone number is not valid.");
    }

    public void verifyEmailAddresses() {
        WebElement emailAddress = driver.findElement(emailAddresses);
        Assert.assertTrue(emailAddress.isDisplayed(), "Email address is not displayed.");
    }

    public void assertEmailAddressesValid() {
        WebElement emailAddress = driver.findElement(emailAddresses);
        Assert.assertTrue(emailAddress.getText().contains("@"), "Email address is not valid.");
    }

    public void verifyChatLinks() {
        WebElement chatLink = driver.findElement(chatLinks);
        Assert.assertTrue(chatLink.isDisplayed(), "Chat link is not displayed.");
    }

    public void assertChatLinksFunctional() {
        WebElement chatLink = driver.findElement(chatLinks);
        chatLink.click();
        Assert.assertTrue(isElementDisplayed(liveChatWindow), "Chat link is not functional.");
    }

    public void clickPhoneNumber() {
        WebElement phoneNumber = driver.findElement(phoneNumbers);
        phoneNumber.click();
    }

    public void assertCallInitiated() {
        WebElement callStatus = driver.findElement(By.id("callStatus"));
        Assert.assertTrue(callStatus.isDisplayed(), "Call is not initiated.");
    }

    public void clickEmailAddress() {
        WebElement emailAddress = driver.findElement(emailAddresses);
        emailAddress.click();
    }

    public void assertEmailClientOpened() {
        WebElement emailClient = driver.findElement(By.id("emailClient"));
        Assert.assertTrue(emailClient.isDisplayed(), "Email client is not opened.");
    }

    public void clickChatLink() {
        WebElement chatLink = driver.findElement(chatLinks);
        chatLink.click();
    }

    public void assertChatWindowOpened() {
        Assert.assertTrue(isElementDisplayed(liveChatWindow), "Chat window is not opened.");
    }

    public void viewContactInformation() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.isDisplayed(), "Contact information is not viewable.");
    }

    public void assertContactInformationUserFriendly() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.getText().contains("Contact Us"), "Contact information is not user-friendly.");
    }

    public void verifyContactInformation() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.isDisplayed(), "Contact information is not verified.");
    }

    public void assertContactInformationCurrent() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.getText().contains("2023"), "Contact information is not current.");
    }

    public void navigateToAnyPage(String url) {
        navigateToUrl(url);
        Assert.assertTrue(driver.getCurrentUrl().contains(url), "Navigation to page failed.");
    }

    public void lookForContactInformation() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.isDisplayed(), "Contact information not found.");
    }

    public void assertContactInformationAccessible() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.isDisplayed(), "Contact information is not accessible.");
    }

    public void accessFromDifferentPlatforms() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.isDisplayed(), "Contact information is not accessible from different platforms.");
    }

    public void viewContactInformationOnDifferentPlatforms() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.isDisplayed(), "Contact information is not viewable on different platforms.");
    }

    public void assertContactInformationConsistent() {
        WebElement contactInfo = driver.findElement(contactInfoSection);
        Assert.assertTrue(contactInfo.getText().contains("Contact Us"), "Contact information is not consistent.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    private void navigateToUrl(String url) {
        driver.get(url);
    }
}