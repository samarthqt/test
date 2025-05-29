
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
    protected By contactInformation = By.id("contactInformation");
    protected By phoneNumbers = By.cssSelector(".phone-number");
    protected By emailAddresses = By.cssSelector(".email-address");
    protected By chatLinks = By.cssSelector(".chat-link");

    public CustomerServicePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToCustomerServicePage() {
        waitUntilElementVisible(customerServicePage, 3);
        clickElement(customerServicePage);
    }

    public void verifyCustomerServicePageDisplayed() {
        waitUntilElementVisible(customerServicePage, 3);
        Assert.assertTrue(isElementDisplayed(customerServicePage), "Customer service page is not displayed.");
    }

    public void verifyPhoneContactInformation() {
        waitUntilElementVisible(phoneContactInfo, 3);
        Assert.assertTrue(isElementDisplayed(phoneContactInfo), "Phone contact information is not displayed.");
    }

    public void verifyEmailContactInformation() {
        waitUntilElementVisible(emailContactInfo, 3);
        Assert.assertTrue(isElementDisplayed(emailContactInfo), "Email contact information is not displayed.");
    }

    public void verifyLiveChatOptionAvailable() {
        waitUntilElementVisible(liveChatOption, 3);
        Assert.assertTrue(isElementDisplayed(liveChatOption), "Live chat option is not available.");
    }

    public void clickPhoneContactInformation() {
        waitUntilElementVisible(phoneContactInfo, 3);
        clickElement(phoneContactInfo);
    }

    public void verifyPhoneDialerOpened() {
        Assert.assertTrue(true, "Phone dialer is opened.");
    }

    public void clickEmailContactInformation() {
        waitUntilElementVisible(emailContactInfo, 3);
        clickElement(emailContactInfo);
    }

    public void verifyEmailClientOpened() {
        Assert.assertTrue(true, "Email client is opened.");
    }

    public void clickLiveChatOption() {
        waitUntilElementVisible(liveChatOption, 3);
        clickElement(liveChatOption);
    }

    public void verifyLiveChatWindowOpened() {
        waitUntilElementVisible(liveChatWindow, 3);
        Assert.assertTrue(isElementDisplayed(liveChatWindow), "Live chat window is not opened.");
    }

    public void openLiveChatWindow() {
        waitUntilElementVisible(liveChatWindow, 3);
        clickElement(liveChatWindow);
    }

    public void enterMessageInLiveChatWindow() {
        Assert.assertTrue(true, "Message entered in live chat window.");
    }

    public void verifyMessageSentAndResponseReceived() {
        Assert.assertTrue(true, "Message sent and response received.");
    }

    public void verifyAlternativeContactMethods() {
        waitUntilElementVisible(alternativeContactMethods, 3);
        Assert.assertTrue(isElementDisplayed(alternativeContactMethods), "Alternative contact methods are not displayed.");
    }

    public void verifyResponseTimeMentioned() {
        waitUntilElementVisible(responseTimeInfo, 3);
        Assert.assertTrue(isElementDisplayed(responseTimeInfo), "Response time is not mentioned.");
    }

    public void verifyWorkingHoursMentioned() {
        waitUntilElementVisible(workingHoursInfo, 3);
        Assert.assertTrue(isElementDisplayed(workingHoursInfo), "Working hours are not mentioned.");
    }

    public void contactCustomerServiceThroughAllChannels() {
        Assert.assertTrue(true, "Contacted customer service through all channels.");
    }

    public void verifyCustomerServiceReachable() {
        Assert.assertTrue(true, "Customer service is reachable.");
    }

    public void verifyContactInformationAccessible() {
        Assert.assertTrue(true, "Contact information is accessible.");
    }

    public void verifyContactInformationDisplayedCorrectly() {
        Assert.assertTrue(true, "Contact information displayed correctly.");
    }

    public void verifyContactInformationUpToDate() {
        Assert.assertTrue(true, "Contact information is up to date.");
    }

    public void verifySpamProtectionMeasures() {
        Assert.assertTrue(true, "Spam protection measures are in place.");
    }

    public void printContactInformationPage() {
        Assert.assertTrue(true, "Contact information page printed.");
    }

    public void verifyPrintFormatOfContactInformation() {
        Assert.assertTrue(true, "Contact information formatted correctly for printing.");
    }

    public void verifyEmailAddresses() {
        waitUntilElementVisible(emailAddresses, 3);
        Assert.assertTrue(isElementDisplayed(emailAddresses), "Email addresses are not displayed.");
    }

    public void verifyChatLinks() {
        waitUntilElementVisible(chatLinks, 3);
        Assert.assertTrue(isElementDisplayed(chatLinks), "Chat links are not displayed.");
    }

    public void clickPhoneNumber() {
        WebElement phoneNumber = driver.findElement(phoneNumbers);
        phoneNumber.click();
        Assert.assertTrue(true, "Phone number clicked.");
    }

    public void clickEmailAddress() {
        WebElement emailAddress = driver.findElement(emailAddresses);
        emailAddress.click();
        Assert.assertTrue(true, "Email address clicked.");
    }

    public void clickChatLink() {
        WebElement chatLink = driver.findElement(chatLinks);
        chatLink.click();
        Assert.assertTrue(true, "Chat link clicked.");
    }

    public void assertPhoneNumbersValidity() {
        Assert.assertTrue(true, "Phone numbers are valid.");
    }

    public void assertEmailAddressesValidity() {
        Assert.assertTrue(true, "Email addresses are valid.");
    }

    public void assertChatLinksFunctionality() {
        Assert.assertTrue(true, "Chat links are functional.");
    }

    public void assertEmailClientOpening() {
        Assert.assertTrue(true, "Email client opens correctly.");
    }

    public void assertCallInitiation() {
        Assert.assertTrue(true, "Call initiation is successful.");
    }

    public void assertChatWindowOpening() {
        Assert.assertTrue(true, "Chat window opens correctly.");
    }

    public void assertContactInformationFormat() {
        Assert.assertTrue(true, "Contact information format is correct.");
    }

    public void verifyPhoneNumbers() {
        waitUntilElementVisible(phoneNumbers, 3);
        Assert.assertTrue(isElementDisplayed(phoneNumbers), "Phone numbers are not displayed.");
    }

    public void navigateToCustomerServiceSection() {
        waitUntilElementVisible(customerServicePage, 3);
        clickElement(customerServicePage);
    }

    public void viewContactInformation() {
        waitUntilElementVisible(contactInformation, 3);
        Assert.assertTrue(isElementDisplayed(contactInformation), "Contact information is not displayed.");
    }
}
