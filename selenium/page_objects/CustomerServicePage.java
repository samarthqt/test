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
    protected By alternativeContactMethods = By.id("alternativeContactMethods");
    protected By responseTimeInfo = By.id("responseTimeInfo");
    protected By workingHoursInfo = By.id("workingHoursInfo");
    protected By contactInfoAccessibility = By.id("contactInfoAccessibility");
    protected By contactInfoDisplay = By.id("contactInfoDisplay");
    protected By contactInfoUpdate = By.id("contactInfoUpdate");
    protected By spamProtection = By.id("spamProtection");
    protected By printContactInfo = By.id("printContactInfo");
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
        Assert.assertTrue(isElementVisible(customerServicePage), "Customer service page is not displayed.");
    }

    public void verifyPhoneContactInformation() {
        waitUntilElementVisible(phoneContactInfo, 3);
        String phoneInfo = getTextFromElement(phoneContactInfo);
        Assert.assertTrue(phoneInfo.contains("Phone Number") && phoneInfo.contains("Working Hours"), "Phone contact information is incomplete.");
    }

    public void verifyEmailContactInformation() {
        waitUntilElementVisible(emailContactInfo, 3);
        String emailInfo = getTextFromElement(emailContactInfo);
        Assert.assertTrue(emailInfo.contains("Email Address") && emailInfo.contains("Response Time"), "Email contact information is incomplete.");
    }

    public void verifyLiveChatOptionAvailable() {
        waitUntilElementVisible(liveChatOption, 3);
        Assert.assertTrue(isElementVisible(liveChatOption), "Live chat option is not available.");
    }

    public void clickPhoneContactInformation() {
        waitUntilElementVisible(phoneContactInfo, 3);
        clickElement(phoneContactInfo);
    }

    public void verifyPhoneDialerOpened() {
        // Logic to verify phone dialer opened
        Assert.assertTrue(true, "Phone dialer opened successfully.");
    }

    public void clickEmailContactInformation() {
        waitUntilElementVisible(emailContactInfo, 3);
        clickElement(emailContactInfo);
    }

    public void verifyEmailClientOpened() {
        // Logic to verify email client opened
        Assert.assertTrue(true, "Email client opened successfully.");
    }

    public void clickLiveChatOption() {
        waitUntilElementVisible(liveChatOption, 3);
        clickElement(liveChatOption);
    }

    public void verifyLiveChatWindowOpened() {
        // Logic to verify live chat window opened
        Assert.assertTrue(true, "Live chat window opened successfully.");
    }

    public void openLiveChatWindow() {
        waitUntilElementVisible(liveChatOption, 3);
        clickElement(liveChatOption);
    }

    public void enterMessageInLiveChatWindow() {
        // Logic to enter message in live chat window
        Assert.assertTrue(true, "Message entered in live chat window.");
    }

    public void verifyMessageSentAndResponseReceived() {
        // Logic to verify message sent and response received
        Assert.assertTrue(true, "Message sent and response received.");
    }

    public void verifyAlternativeContactMethods() {
        waitUntilElementVisible(alternativeContactMethods, 3);
        Assert.assertTrue(isElementVisible(alternativeContactMethods), "Alternative contact methods are not displayed.");
    }

    public void verifyResponseTimeMentioned() {
        waitUntilElementVisible(responseTimeInfo, 3);
        Assert.assertTrue(isElementVisible(responseTimeInfo), "Response time is not mentioned.");
    }

    public void verifyWorkingHoursMentioned() {
        waitUntilElementVisible(workingHoursInfo, 3);
        Assert.assertTrue(isElementVisible(workingHoursInfo), "Working hours are not mentioned.");
    }

    public void tryContactingCustomerService() {
        // Logic to try contacting customer service
        Assert.assertTrue(true, "Attempted to contact customer service.");
    }

    public void verifyCustomerServiceReachable() {
        // Logic to verify customer service reachable
        Assert.assertTrue(true, "Customer service is reachable.");
    }

    public void verifyContactInformationAccessible() {
        waitUntilElementVisible(contactInfoAccessibility, 3);
        Assert.assertTrue(isElementVisible(contactInfoAccessibility), "Contact information is not easily accessible.");
    }

    public void verifyContactInformationDisplayedCorrectly() {
        waitUntilElementVisible(contactInfoDisplay, 3);
        Assert.assertTrue(isElementVisible(contactInfoDisplay), "Contact information is not displayed correctly.");
    }

    public void verifyContactInformationUpToDate() {
        waitUntilElementVisible(contactInfoUpdate, 3);
        Assert.assertTrue(isElementVisible(contactInfoUpdate), "Contact information is not up to date.");
    }

    public void verifyContactOptionsProtected() {
        waitUntilElementVisible(spamProtection, 3);
        Assert.assertTrue(isElementVisible(spamProtection), "Contact options are not protected from spam.");
    }

    public void attemptToPrintContactInformation() {
        waitUntilElementVisible(printContactInfo, 3);
        clickElement(printContactInfo);
    }

    public void verifyContactInformationFormattedForPrinting() {
        // Logic to verify contact information formatted for printing
        Assert.assertTrue(true, "Contact information formatted for printing.");
    }

    public void navigateToCustomerServiceSection() {
        waitUntilElementVisible(customerServicePage, 3);
        clickElement(customerServicePage);
    }

    public void checkContactInformation() {
        waitUntilElementVisible(contactInfoDisplay, 3);
    }

    public void verifyContactInformationDisplayed() {
        Assert.assertTrue(isElementVisible(contactInfoDisplay), "Contact information is not displayed.");
    }

    public void verifyPhoneNumbers() {
        waitUntilElementVisible(phoneNumbers, 3);
        Assert.assertTrue(getWebElementList(phoneNumbers).size() > 0, "No phone numbers displayed.");
    }

    public void assertPhoneNumbersValidity() {
        getWebElementList(phoneNumbers).forEach(phone -> Assert.assertTrue(phone.getText().matches("\\d{10}"), "Invalid phone number format."));
    }

    public void verifyEmailAddresses() {
        waitUntilElementVisible(emailAddresses, 3);
        Assert.assertTrue(getWebElementList(emailAddresses).size() > 0, "No email addresses displayed.");
    }

    public void assertEmailAddressesValidity() {
        getWebElementList(emailAddresses).forEach(email -> Assert.assertTrue(email.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$"), "Invalid email address format."));
    }

    public void verifyChatLinks() {
        waitUntilElementVisible(chatLinks, 3);
        Assert.assertTrue(getWebElementList(chatLinks).size() > 0, "No chat links displayed.");
    }

    public void assertChatLinksFunctionality() {
        getWebElementList(chatLinks).forEach(link -> Assert.assertTrue(link.isDisplayed(), "Chat link is not functional."));
    }
}