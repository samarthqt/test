package com.pageobjects;
import com.framework.components.ApplitoolsOperations;
import com.framework.components.ScriptHelper;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;


public class KSM_LoginPage extends WebReusableComponents {
    public KSM_LoginPage(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }

    protected By btn_Citizen = By.xpath("(//button[normalize-space()='Citizen'])[1]");
    protected By txt_PhoneNumber = By.xpath("(//input[@id='phoneNumber'])[1]");
    protected By btn_SendOTP = By.xpath("(//button[@type='submit'][normalize-space()='Send OTP'])[1]");
    protected By link_CreateAccount = By.xpath("//button[contains(text(),'Create Account')]");
    protected By btn_Organization = By.xpath("(//button[normalize-space()='Organization'])[1]");
    protected By txt_PhoneNumber1 = By.xpath("//div[@class='relative']//input[@id='phoneNumber']");
    protected By txt_OrganizationName = By.xpath("//input[@id='organizationName']");
    protected By btn_SendOTP1 = By.xpath("(//input[@id='phoneNumber'])[2]");
    protected By link_CreateAccount1 = By.xpath("//button[contains(text(),'Create Account')]");

    protected ApplitoolsOperations appliTools = new ApplitoolsOperations();

    public void launchApp(String url) {
        launchUrl(url);
        appliTools.captureContent("");
    }

    public void clickCitizenBtn() {
        clickElement(btn_Citizen);
    }

    public void enterPhoneNumberTxt(String phoneNumber) {
        enterText(txt_PhoneNumber, phoneNumber);
    }

    public void clickSendOTPBtn() {
        clickElement(btn_SendOTP);
    }

    public void clickCreateAccountLink() {
        clickElement(link_CreateAccount);
    }

    public void clickOrganizationBtn() {
        clickElement(btn_Organization);
    }

    public void enterPhoneNumberTxt1(String phoneNumber1) {
        waitUntilElementVisible(txt_PhoneNumber1,120);
        enterText(txt_PhoneNumber1, phoneNumber1);
    }

    public void enterOrganizationNameTxt(String phoneNumber) {
        enterText(txt_OrganizationName, phoneNumber);
    }

    public void clickSendOTPBtn1() {
        clickElement(btn_SendOTP1);
    }

    public void clickCreateAccountLink1() {
        clickElement(link_CreateAccount1);
    }

}