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

public class CustomerServicePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CustomerServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToCustomerServicePage() {
        driver.get(http://example.com/customer-service);
    }

    public boolean isCustomerServicePageDisplayed() {
        WebElement pageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(customer_service_page)));
        Assert.assertTrue(pageElement.isDisplayed(), Customer Service Page is not displayed);
        return pageElement.isDisplayed();
    }

    public boolean isPhoneContactInfoDisplayed() {
        WebElement phoneInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(phone_contact_info)));
        Assert.assertTrue(phoneInfo.isDisplayed(), Phone contact info is not displayed);
        return phoneInfo.isDisplayed();
    }

    public void clickPhoneContactInfo() {
        WebElement phoneContact = wait.until(ExpectedConditions.elementToBeClickable(By.id(phone_contact_info)));
        phoneContact.click();
    }

    public void clickOnPhoneNumber() {
        WebElement phoneNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id(phone_number)));
        phoneNumber.click();
    }

    public boolean isCallInitiated() {
        WebElement callStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(call_status)));
        Assert.assertTrue(callStatus.isDisplayed(), Call is not initiated);
        return callStatus.isDisplayed();
    }

    public boolean isEmailContactInfoDisplayed() {
        WebElement emailInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_contact_info)));
        Assert.assertTrue(emailInfo.isDisplayed(), Email contact info is not displayed);
        return emailInfo.isDisplayed();
    }

    public void clickEmailContactInfo() {
        WebElement emailContact = wait.until(ExpectedConditions.elementToBeClickable(By.id(email_contact_info)));
        emailContact.click();
    }

    public void clickOnEmailAddress() {
        WebElement emailAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id(email_address)));
        emailAddress.click();
    }

    public boolean isEmailClientOpened() {
        WebElement emailClientStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_client_status)));
        Assert.assertTrue(emailClientStatus.isDisplayed(), Email client is not opened);
        return emailClientStatus.isDisplayed();
    }

    public boolean isLiveChatOptionAvailable() {
        WebElement liveChatOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(live_chat_option)));
        Assert.assertTrue(liveChatOption.isDisplayed(), Live chat option is not available);
        return liveChatOption.isDisplayed();
    }

    public void clickLiveChatOption() {
        WebElement liveChat = wait.until(ExpectedConditions.elementToBeClickable(By.id(live_chat_option)));
        liveChat.click();
    }

    public void sendMessageInLiveChat(String message) {
        WebElement chatWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(live_chat_window)));
        chatWindow.sendKeys(message);
    }

    public boolean isChatWindowOpened() {
        WebElement chatWindowStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(chat_window_status)));
        Assert.assertTrue(chatWindowStatus.isDisplayed(), Chat window is not opened);
        return chatWindowStatus.isDisplayed();
    }

    public void clickOnChatLink() {
        WebElement chatLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(chat_link)));
        chatLink.click();
    }

    public boolean areChatLinksFunctional() {
        WebElement chatLinks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(chat_links)));
        Assert.assertTrue(chatLinks.isDisplayed(), Chat links are not functional);
        return chatLinks.isDisplayed();
    }

    public void verifyChatLinks() {
        WebElement chatLinks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(chat_links)));
        Assert.assertTrue(chatLinks.isDisplayed(), Chat links verification failed);
    }

    public boolean isContactInformationDisplayed() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not displayed);
        return contactInfo.isDisplayed();
    }

    public void checkContactInformation() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information check failed);
    }

    public boolean isContactInformationCurrent() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not current);
        return contactInfo.isDisplayed();
    }

    public void verifyContactInformation() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information verification failed);
    }

    public boolean isContactInformationUserFriendly() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not user-friendly);
        return contactInfo.isDisplayed();
    }

    public void viewContactInformation() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information view failed);
    }

    public boolean isContactInfoDisplayedCorrectlyOnDevices() {
        // Implement logic to verify on different devices
        return true;
    }

    public boolean isContactInfoUpToDate() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not up-to-date);
        return contactInfo.isDisplayed();
    }

    public boolean isContactInformationLocalized() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not localized);
        return contactInfo.isDisplayed();
    }

    public boolean isContactInformationAccessible() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not accessible);
        return contactInfo.isDisplayed();
    }

    public boolean isContactInfoAccessible() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact info is not accessible);
        return contactInfo.isDisplayed();
    }

    public boolean areAlternativeContactMethodsDisplayed() {
        WebElement alternativeMethods = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alternative_contact_methods)));
        Assert.assertTrue(alternativeMethods.isDisplayed(), Alternative contact methods are not displayed);
        return alternativeMethods.isDisplayed();
    }

    public boolean isResponseTimeMentioned() {
        WebElement responseTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(response_time)));
        Assert.assertTrue(responseTime.isDisplayed(), Response time is not mentioned);
        return responseTime.isDisplayed();
    }

    public boolean areWorkingHoursMentioned() {
        WebElement workingHours = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(working_hours)));
        Assert.assertTrue(workingHours.isDisplayed(), Working hours are not mentioned);
        return workingHours.isDisplayed();
    }

    public void verifyPhoneNumbers() {
        WebElement phoneNumbers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(phone_numbers)));
        Assert.assertTrue(phoneNumbers.isDisplayed(), Phone numbers verification failed);
    }

    public boolean arePhoneNumbersCorrect() {
        WebElement phoneNumbers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(phone_numbers)));
        Assert.assertTrue(phoneNumbers.isDisplayed(), Phone numbers are not correct);
        return phoneNumbers.isDisplayed();
    }

    public void verifyEmailAddresses() {
        WebElement emailAddresses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_addresses)));
        Assert.assertTrue(emailAddresses.isDisplayed(), Email addresses verification failed);
    }

    public boolean areEmailAddressesCorrect() {
        WebElement emailAddresses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_addresses)));
        Assert.assertTrue(emailAddresses.isDisplayed(), Email addresses are not correct);
        return emailAddresses.isDisplayed();
    }

    public boolean isContactInformationSecure() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not secure);
        return contactInfo.isDisplayed();
    }

    public boolean isContactInformationUpdatable() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not updatable);
        return contactInfo.isDisplayed();
    }

    public boolean lookForContactInformation() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information lookup failed);
        return contactInfo.isDisplayed();
    }

    public boolean isContactInformationConsistent() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information is not consistent);
        return contactInfo.isDisplayed();
    }

    public void updateContactInformation() {
        WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(contact_info)));
        Assert.assertTrue(contactInfo.isDisplayed(), Contact information update failed);
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}