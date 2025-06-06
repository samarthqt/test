package com.pageobjects;

import com.framework.components.ApplitoolsOperations;
import com.framework.components.ScriptHelper;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;


public class KSM_NewBirth extends WebReusableComponents {
    public KSM_NewBirth(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }

    protected By link_Search = By.xpath("//p[@class='chakra-text css-c8ybkp']");
    protected By checkbox_Search = By.xpath("(//span[contains(@class,'chakra-checkbox__control css-etm9zf')])[1]");
    protected By btn_Smart = By.xpath("(//button[normalize-space()='Smart Search'])[1]");
    protected By dropDownBtn_Container = By.xpath("(//div[contains(@class,'css-1wy0on6')])[2]");
    protected By dropDownBtn_LocalBodyType = By.xpath("//div[@id='react-select-37-option-0']");
    protected By dropDownBtn_SearchBy = By.xpath("(//*[name()='svg'][@class='css-8mmkcg'])[4]");
    protected By btn_Search = By.xpath("(//button[contains(@type,'submit')][normalize-space()='Search'])[1]");

    protected ApplitoolsOperations appliTools = new ApplitoolsOperations();

    public void launchApp(String url) {
        launchUrl(url);
        appliTools.captureContent("");
    }

    public void clickSearchLink() {
        waitUntilElementVisible(link_Search,30);
        clickElement(link_Search);
    }

    public void clickSearchCheckBox() {
        clickElement(checkbox_Search);
    }

    public void clickSmartBtn() {
        clickElement(btn_Smart);
    }
    public void clickContainerDropDownBtn() {
        clickElement(dropDownBtn_Container);
    }

    public void clickLocalBodyTypeDropDownBtn() {
        waitUntilElementVisible(dropDownBtn_LocalBodyType,30);
//        selectByValue(dropDownBtn_LocalBodyType,value);
        clickElement(dropDownBtn_LocalBodyType);
    }

    public void clickSearchByDropDownBtn(String value) {
        waitUntilElementVisible(dropDownBtn_SearchBy,30);
        selectByValue(dropDownBtn_SearchBy,value);
    }


    public void clickSearchBtn() {
        clickElement(btn_Search);
    }





}
