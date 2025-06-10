package com.pageobjects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.*;

public class KSM_NewBirth extends WebReusableComponents {

    protected By link_Search = By.xpath("//p[@class='chakra-text css-c8ybkp']");
    protected By checkbox_Search = By.xpath("(//span[contains(@class,'chakra-checkbox__control css-etm9zf')])[1]");
    protected By btn_Smart = By.xpath("(//button[normalize-space()='Smart Search'])[1]");
    protected By dropDownBtn_Container = By.xpath("(//div[contains(@class,'css-1wy0on6')])[2]");
    protected By dropDownBtn_LocalBodyType = By.xpath("//div[@id='react-select-37-option-0']");
    protected By dropDownBtn_SearchBy = By.xpath("(//*[name()='svg'][@class='css-8mmkcg'])[4]");
    protected By btn_Search = By.xpath("(//button[contains(@type,'submit')][normalize-space()='Search'])[1]");

    public KSM_NewBirth() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String url) {
        launchUrl(url);
        String currentUrl = getCurrentURL();
        Assert.assertEquals(currentUrl, url, "Failed to launch the application.");
    }

    public void clickSearchLink() {
        waitUntilElementVisible(link_Search, 30);
        clickElement(link_Search);
        Assert.assertTrue(isElementVisible(link_Search), "Search link is not visible after clicking.");
    }

    public void clickSearchCheckBox() {
        waitUntilElementVisible(checkbox_Search, 30);
        clickElement(checkbox_Search);
        Assert.assertTrue(isElementSelected(checkbox_Search), "Search checkbox is not selected after clicking.");
    }

    public void clickSmartBtn() {
        waitUntilElementVisible(btn_Smart, 30);
        clickElement(btn_Smart);
        Assert.assertTrue(isElementVisible(btn_Smart), "Smart button is not visible after clicking.");
    }

    public void clickContainerDropDownBtn() {
        waitUntilElementVisible(dropDownBtn_Container, 30);
        clickElement(dropDownBtn_Container);
        Assert.assertTrue(isElementVisible(dropDownBtn_Container), "Container dropdown button is not visible after clicking.");
    }

    public void clickLocalBodyTypeDropDownBtn() {
        waitUntilElementVisible(dropDownBtn_LocalBodyType, 30);
        clickElement(dropDownBtn_LocalBodyType);
        Assert.assertTrue(isElementVisible(dropDownBtn_LocalBodyType), "Local body type dropdown button is not visible after clicking.");
    }

    public void clickSearchByDropDownBtn(String value) {
        waitUntilElementVisible(dropDownBtn_SearchBy, 30);
        selectByValue(dropDownBtn_SearchBy, value);
        Assert.assertTrue(isElementVisible(dropDownBtn_SearchBy), "Search by dropdown button is not visible after selecting value.");
    }

    public void clickSearchBtn() {
        waitUntilElementVisible(btn_Search, 30);
        clickElement(btn_Search);
        Assert.assertTrue(isElementVisible(btn_Search), "Search button is not visible after clicking.");
    }
}