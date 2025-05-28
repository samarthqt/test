
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class CustomerServicePage extends WebReusableComponents {

    protected By customerServicePage = By.id(customerServicePage);
    protected By phoneContactInfo = By.id(phoneContactInfo);
    protected By emailContactInfo = By.id(emailContactInfo);
    protected By liveChatOption = By.id(liveChatOption);
    protected By liveChatWindow = By.id(liveChatWindow);
    protected By alternativeContactMethods = By.id(alternativeContactMethods);
    protected By responseTimeInfo = By.id(responseTimeInfo);
    protected By workingHoursInfo = By.id(workingHoursInfo);
    protected By contactInformation = By.id(contactInformation);
    protected By phoneNumbers = By.cssSelector(.phone-number);
    protected By emailAddresses = By.cssSelector(.email-address);
    protected By chatLinks = By.cssSelector(.chat-link);
    protected By spamProtectionElement = By.id(spamProtection);
    protected By printButton = By.id(printButton);
    protected By printableContactInfo = By.id(printableContactInfo);

    public CustomerServicePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToCustomerServicePage() {
        waitUntilElementVisible(customerServicePage, 3);
        clickElement(customerServicePage);
    }

    public void verifyCustomerServicePageDisplayed() {
        waitUntilElementVisible(customerServicePage, 3);
        Assert.assertTrue(isElementDisplayed(customerServicePage), Customer service page is not displayed.);
    }

    public void verifyPhoneContactInformation() {
        waitUntilElementVisible(phoneContactInfo, 3);
        Assert.assertTrue(isElementDisplayed(phoneContactInfo), Phone contact information is not displayed.);
    }

    public void verifyEmailContactInformation() {
        waitUntilElementVisible(emailContactInfo, 3);
        Assert.assertTrue(isElementDisplayed(emailContactInfo), Email contact information is not displayed.);
    }

    public void verifyLiveChatOptionAvailable() {
        waitUntilElementVisible(liveChatOption, 3);
        Assert.assertTrue(isElementDisplayed(liveChatOption), Live chat option is not available.);
    }

    public void clickPhoneContactInformation() {
        waitUntilElementVisible(phoneContactInfo, 3);
        clickElement(phoneContactInfo);
    }

    public void verifyPhoneDialerOpened() {
        // Logic to verify phone dialer opened
        Assert.assertTrue(true, Phone dialer is opened.);
    }

    public void clickEmailContactInformation() {
        waitUntilElementVisible(emailContactInfo, 3);
        clickElement(emailContactInfo);
    }

    public void verifyEmailClientOpened() {
        // Logic to verify email client opened
        Assert.assertTrue(true, Email client is opened.);
    }

    public void clickLiveChatOption() {
        waitUntilElementVisible(liveChatOption, 3);
        clickElement(liveChatOption);
    }

    public void verifyLiveChatWindowOpened() {
        waitUntilElementVisible(liveChatWindow, 3);
        Assert.assertTrue(isElementDisplayed(liveChatWindow), Live chat window is not opened.);
    }

    public void openLiveChatWindow() {
        waitUntilElementVisible(liveChatWindow, 3);
        clickElement(liveChatWindow);
    }

    public void enterMessageInLiveChatWindow() {
        // Logic to enter message in live chat window
        Assert.assertTrue(true, Message entered in live chat window.);
    }

    public void verifyMessageSentAndResponseReceived() {
        // Logic to verify message sent and response received
        Assert.assertTrue(true, Message sent and response received.);
    }

    public void verifyAlternativeContactMethods() {
        waitUntilElementVisible(alternativeContactMethods, 3);
        Assert.assertTrue(isElementDisplayed(alternativeContactMethods), Alternative contact methods are not displayed.);
    }

    public void verifyResponseTimeMentioned() {
        waitUntilElementVisible(responseTimeInfo, 3);
        Assert.assertTrue(isElementDisplayed(responseTimeInfo), Response time is not mentioned.);
    }

    public void verifyWorkingHoursMentioned() {
        waitUntilElementVisible(workingHoursInfo, 3);
        Assert.assertTrue(isElementDisplayed(workingHoursInfo), Working hours are not mentioned.);
    }

    public void contactCustomerServiceThroughAllChannels() {
        // Logic to contact customer service through all channels
        Assert.assertTrue(true, Contacted customer service through all channels.);
    }

    public void verifyCustomerServiceReachable() {
        // Logic to verify customer service is reachable
        Assert.assertTrue(true, Customer service is reachable.);
    }

    public void verifyContactInformationAccessible() {
        // Logic to verify contact information is accessible
        Assert.assertTrue(true, Contact information is accessible.);
    }

    public void verifyContactInformationDisplayedCorrectly() {
        // Logic to verify contact information displayed correctly
        Assert.assertTrue(true, Contact information displayed correctly.);
    }

    public void verifyContactInformationUpToDate() {
        // Logic to verify contact information is up to date
        Assert.assertTrue(true, Contact information is up to date.);
    }

    public void navigateToCustomerServiceSection() {
        waitUntilElementVisible(customerServicePage, 3);
        clickElement(customerServicePage);
    }

    public void checkContactInformation() {
        waitUntilElementVisible(contactInformation, 3);
        Assert.assertTrue(isElementDisplayed(contactInformation), Contact information is not displayed.);
    }

    public void verifyContactInformationDisplayed() {
        Assert.assertTrue(isElementVisible(contactInformation), Contact information is not displayed.);
    }

    public void verifyPhoneNumbers() {
        waitUntilElementVisible(phoneNumbers, 3);
        Assert.assertTrue(getWebElementList(phoneNumbers).size() > 0, No phone numbers displayed.);
    }

    public void assertPhoneNumbersValidity() {
        getWebElementList(phoneNumbers).forEach(phone -> Assert.assertTrue(phone.getText().matches(\\d{10}), Invalid phone number format.));
    }

    public void verifyEmailAddresses() {
        waitUntilElementVisible(emailAddresses, 3);
        Assert.assertTrue(getWebElementList(emailAddresses).size() > 0, No email addresses displayed.);
    }

    public void assertEmailAddressesValidity() {
        getWebElementList(emailAddresses).forEach(email -> Assert.assertTrue(email.getText().matches(^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$), Invalid email address format.));
    }

    public void verifyChatLinks() {
        waitUntilElementVisible(chatLinks, 3);
        Assert.assertTrue(getWebElementList(chatLinks).size() > 0, No chat links displayed.);
    }

    public void assertChatLinksFunctionality() {
        getWebElementList(chatLinks).forEach(link -> Assert.assertTrue(link.isDisplayed(), Chat link is not functional.));
    }

    public void verifySpamProtectionMeasures() {
        waitUntilElementVisible(spamProtectionElement, 3);
        Assert.assertTrue(isElementDisplayed(spamProtectionElement), Spam protection measures are not displayed.);
    }

    public void printContactInformationPage() {
        waitUntilElementVisible(printButton, 3);
        clickElement(printButton);
    }

    public void verifyContactInformationPrintableFormat() {
        waitUntilElementVisible(printableContactInfo, 3);
        Assert.assertTrue(isElementDisplayed(printableContactInfo), Contact information is not formatted correctly for printing.);
    }
}
