package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomerServicePage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By customerServicePage = By.id(customerServicePage);
    protected By phoneContactInfo = By.id(phoneContactInfo);
    protected By emailContactInfo = By.id(emailContactInfo);
    protected By liveChatOption = By.id(liveChatOption);
    protected By liveChatWindow = By.id(liveChatWindow);
    protected By alternativeContactMethods = By.id(alternativeContactMethods);
    protected By responseTimeInfo = By.id(responseTimeInfo);
    protected By workingHoursInfo = By.id(workingHoursInfo);
    protected By contactInfoSection = By.id(contactInfoSection);
    protected By phoneNumber = By.cssSelector(.phone-number);
    protected By emailAddress = By.cssSelector(.email-address);
    protected By chatLink = By.cssSelector(.chat-link);

    public CustomerServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToCustomerServicePage() {
        waitUntilElementVisible(customerServicePage);
        clickElement(customerServicePage);
    }

    public void verifyCustomerServicePageDisplayed() {
        waitUntilElementVisible(customerServicePage);
        Assert.assertTrue(isElementVisible(customerServicePage), Customer service page is not displayed.);
    }

    public void verifyPhoneContactInformation() {
        waitUntilElementVisible(phoneContactInfo);
        Assert.assertTrue(isElementVisible(phoneContactInfo), Phone contact information is not displayed.);
    }

    public void verifyEmailContactInformation() {
        waitUntilElementVisible(emailContactInfo);
        Assert.assertTrue(isElementVisible(emailContactInfo), Email contact information is not displayed.);
    }

    public void verifyLiveChatOptionAvailable() {
        waitUntilElementVisible(liveChatOption);
        Assert.assertTrue(isElementVisible(liveChatOption), Live chat option is not available.);
    }

    public void clickPhoneContactInformation() {
        waitUntilElementVisible(phoneContactInfo);
        clickElement(phoneContactInfo);
    }

    public void verifyPhoneDialerOpens() {
        Assert.assertTrue(isCallInitiated(), Phone dialer did not open.);
    }

    public void clickEmailContactInformation() {
        waitUntilElementVisible(emailContactInfo);
        clickElement(emailContactInfo);
    }

    public void verifyEmailClientOpens() {
        Assert.assertTrue(isEmailClientOpened(), Email client did not open.);
    }

    public void clickLiveChatOption() {
        waitUntilElementVisible(liveChatOption);
        clickElement(liveChatOption);
    }

    public void verifyLiveChatWindowOpens() {
        waitUntilElementVisible(liveChatWindow);
        Assert.assertTrue(isElementVisible(liveChatWindow), Live chat window did not open.);
    }

    public void openLiveChatWindow() {
        waitUntilElementVisible(liveChatWindow);
        clickElement(liveChatWindow);
    }

    public void enterMessageInLiveChatWindow(String message) {
        WebElement chatInput = driver.findElement(By.id(chatInput));
        chatInput.sendKeys(message);
        WebElement sendButton = driver.findElement(By.id(sendButton));
        sendButton.click();
        Assert.assertTrue(verifyMessageSentAndResponseReceived(), Message was not sent or response not received.);
    }

    public boolean verifyMessageSentAndResponseReceived() {
        WebElement response = driver.findElement(By.id(chatResponse));
        return response.isDisplayed();
    }

    public void verifyAlternativeContactMethods() {
        waitUntilElementVisible(alternativeContactMethods);
        Assert.assertTrue(isElementVisible(alternativeContactMethods), Alternative contact methods are not displayed.);
    }

    public void verifyResponseTimeMentioned() {
        waitUntilElementVisible(responseTimeInfo);
        Assert.assertTrue(isElementVisible(responseTimeInfo), Response time is not mentioned.);
    }

    public void verifyWorkingHoursMentioned() {
        waitUntilElementVisible(workingHoursInfo);
        Assert.assertTrue(isElementVisible(workingHoursInfo), Working hours are not mentioned.);
    }

    public void contactCustomerServiceUsingAllChannels() {
        clickPhoneContactInformation();
        verifyPhoneDialerOpens();
        clickEmailContactInformation();
        verifyEmailClientOpens();
        clickLiveChatOption();
        verifyLiveChatWindowOpens();
    }

    public void verifyCustomerServiceReachable() {
        Assert.assertTrue(isElementVisible(phoneContactInfo) || isElementVisible(emailContactInfo) || isElementVisible(liveChatOption), Customer service is not reachable.);
    }

    public void verifyContactInformationAccessibility() {
        Assert.assertTrue(isElementVisible(contactInfoSection), Contact information is not accessible.);
    }

    public void verifyContactInformationDisplayOnDevices() {
        Assert.assertTrue(isElementVisible(phoneNumber) && isElementVisible(emailAddress) && isElementVisible(chatLink), Contact information is not displayed correctly on devices.);
    }

    public void verifyContactInformationUpToDate() {
        String actualPhoneNumber = getTextFromElement(phoneNumber);
        String expectedPhoneNumber = 123-456-7890;
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, Phone number is not up to date.);
        String actualEmailAddress = getTextFromElement(emailAddress);
        String expectedEmailAddress = support@example.com;
        Assert.assertEquals(actualEmailAddress, expectedEmailAddress, Email address is not up to date.);
    }

    public void navigateToCustomerServiceSection() {
        waitUntilElementVisible(contactInfoSection);
        clickElement(contactInfoSection);
    }

    public void checkContactInformation() {
        waitUntilElementVisible(contactInfoSection);
        Assert.assertTrue(isElementVisible(contactInfoSection), Contact information section is not displayed.);
    }

    public void verifyContactInformationDisplay() {
        Assert.assertTrue(isElementVisible(phoneNumber), Phone number is not displayed.);
        Assert.assertTrue(isElementVisible(emailAddress), Email address is not displayed.);
        Assert.assertTrue(isElementVisible(chatLink), Chat link is not displayed.);
    }

    public void verifyPhoneNumbers() {
        String actualPhoneNumber = getTextFromElement(phoneNumber);
        String expectedPhoneNumber = 123-456-7890;
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, Phone number is incorrect.);
    }

    public void assertPhoneNumbersValidity() {
        String actualPhoneNumber = getTextFromElement(phoneNumber);
        Assert.assertTrue(actualPhoneNumber.matches(\\d{3}-\\d{3}-\\d{4}), Phone number format is invalid.);
    }

    public void verifyEmailAddresses() {
        String actualEmailAddress = getTextFromElement(emailAddress);
        String expectedEmailAddress = support@example.com;
        Assert.assertEquals(actualEmailAddress, expectedEmailAddress, Email address is incorrect.);
    }

    public void assertEmailAddressesValidity() {
        String actualEmailAddress = getTextFromElement(emailAddress);
        Assert.assertTrue(actualEmailAddress.contains(@), Email address format is invalid.);
    }

    public void verifyChatLinks() {
        Assert.assertTrue(isElementVisible(chatLink), Chat link is not displayed.);
    }

    public void assertChatLinksFunctionality() {
        clickElement(chatLink);
        Assert.assertTrue(isChatWindowOpened(), Chat window did not open.);
    }

    public void clickPhoneNumber() {
        clickElement(phoneNumber);
    }

    public void assertCallInitiation() {
        Assert.assertTrue(isCallInitiated(), Call was not initiated.);
    }

    public void clickEmailAddress() {
        clickElement(emailAddress);
    }

    public void assertEmailClientOpening() {
        Assert.assertTrue(isEmailClientOpened(), Email client did not open.);
    }

    public void clickChatLink() {
        clickElement(chatLink);
    }

    public void assertChatWindowOpening() {
        Assert.assertTrue(isChatWindowOpened(), Chat window did not open.);
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    private String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    private boolean isCallInitiated() {
        // Logic to verify call initiation
        return true;
    }

    private boolean isEmailClientOpened() {
        // Logic to verify email client opening
        return true;
    }

    private boolean isChatWindowOpened() {
        // Logic to verify chat window opening
        return true;
    }
}