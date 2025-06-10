package com.pageobjects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.*;

public class KSM_LoginPage extends WebReusableComponents {

    protected By btn_Citizen = By.xpath("(//button[normalize-space()='Citizen'])[1]");
    protected By txt_PhoneNumber = By.xpath("(//input[@id='phoneNumber'])[1]");
    protected By btn_SendOTP = By.xpath("(//button[@type='submit'][normalize-space()='Send OTP'])[1]");
    protected By link_CreateAccount = By.xpath("//button[contains(text(),'Create Account')]");
    protected By btn_Organization = By.xpath("(//button[normalize-space()='Organization'])[1]");
    protected By txt_PhoneNumber1 = By.xpath("//div[@class='relative']//input[@id='phoneNumber']");
    protected By txt_OrganizationName = By.xpath("//input[@id='organizationName']");
    protected By btn_SendOTP1 = By.xpath("(//input[@id='phoneNumber'])[2]");
    protected By link_CreateAccount1 = By.xpath("//button[contains(text(),'Create Account')]");

    public KSM_LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String url) {
        launchUrl(url);
        String currentUrl = getCurrentURL();
        Assert.assertEquals(currentUrl, url, "Failed to launch the application.");
    }

    public void clickCitizenBtn() {
        waitUntilElementVisible(btn_Citizen, 3);
        clickElement(btn_Citizen);
        Assert.assertTrue(isElementVisible(btn_Citizen), "Citizen button is not visible after clicking.");
    }

    public void enterPhoneNumberTxt(String phoneNumber) {
        waitUntilElementVisible(txt_PhoneNumber, 3);
        enterText(txt_PhoneNumber, phoneNumber);
        String enteredText = getTextFromElement(txt_PhoneNumber);
        Assert.assertEquals(enteredText, phoneNumber, "Phone number text does not match.");
    }

    public void clickSendOTPBtn() {
        waitUntilElementVisible(btn_SendOTP, 3);
        clickElement(btn_SendOTP);
        Assert.assertTrue(isElementVisible(btn_SendOTP), "Send OTP button is not visible after clicking.");
    }

    public void clickCreateAccountLink() {
        waitUntilElementVisible(link_CreateAccount, 3);
        clickElement(link_CreateAccount);
        Assert.assertTrue(isElementVisible(link_CreateAccount), "Create Account link is not visible after clicking.");
    }

    public void clickOrganizationBtn() {
        waitUntilElementVisible(btn_Organization, 3);
        clickElement(btn_Organization);
        Assert.assertTrue(isElementVisible(btn_Organization), "Organization button is not visible after clicking.");
    }

    public void enterPhoneNumberTxt1(String phoneNumber1) {
        waitUntilElementVisible(txt_PhoneNumber1, 3);
        enterText(txt_PhoneNumber1, phoneNumber1);
        String enteredText = getTextFromElement(txt_PhoneNumber1);
        Assert.assertEquals(enteredText, phoneNumber1, "Phone number text does not match.");
    }

    public void enterOrganizationNameTxt(String organizationName) {
        waitUntilElementVisible(txt_OrganizationName, 3);
        enterText(txt_OrganizationName, organizationName);
        String enteredText = getTextFromElement(txt_OrganizationName);
        Assert.assertEquals(enteredText, organizationName, "Organization name text does not match.");
    }

    public void clickSendOTPBtn1() {
        waitUntilElementVisible(btn_SendOTP1, 3);
        clickElement(btn_SendOTP1);
        Assert.assertTrue(isElementVisible(btn_SendOTP1), "Send OTP button is not visible after clicking.");
    }

    public void clickCreateAccountLink1() {
        waitUntilElementVisible(link_CreateAccount1, 3);
        clickElement(link_CreateAccount1);
        Assert.assertTrue(isElementVisible(link_CreateAccount1), "Create Account link is not visible after clicking.");
    }
}