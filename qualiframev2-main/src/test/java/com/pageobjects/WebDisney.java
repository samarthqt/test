package com.pageobjects;

import com.framework.components.ApplitoolsOperations;
import com.framework.components.ScriptHelper;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class WebDisney extends WebReusableComponents {


    public WebDisney(ScriptHelper scriptHelper) {
        super(scriptHelper);
    }

    protected By virtualassistant = By.xpath("//img[@alt='virtual-assistant-launcher']");
    protected By menu_clothing = By.xpath("//span[normalize-space()='Clothing']");

    protected By cardService = By.xpath("//div[@class='float-left']//li[2]//div[1]");

    protected By btn_StoreLocater = By.xpath("//span[normalize-space()='Store Locator']");

    protected By switchToIframe1 = By.xpath("//iframe[@class='align-center']");

    protected By searchLocater = By.xpath("//input[@placeholder='Enter city, state or postal code']");
    protected By btn_disney_Checkbox = By.xpath("//span[text()='Disney Outlet']");

    protected By btn_search = By.xpath("//button[@class='button-search']");

    protected By switchToIframe = By.xpath("//iframe[@id='insync-iframe']");

    protected By orderstatus = By.xpath("//button[contains(@class,'insyncBtn')]");

    protected By clickyes = By.xpath("(//div[@class='insyncBubbles'])[1]/child::div[1]");


    protected By clickNo = By.xpath("(//div[@class='insyncBubbles'])[3]/child::div[2]");


    protected By querySearch = By.xpath("//input[@placeholder='Type your question here']");

    protected By SerachSubmit = By.xpath("//input[@name='commit']");

    protected By yesfeedback =By.xpath("//button[normalize-space()='Yes']");




    protected ApplitoolsOperations appliTools = new ApplitoolsOperations();

    public void launchApp(String url) {
        launchUrl(url);
//		maximizeWindow();
        appliTools.captureContent("");
    }

    public void refresh()
    {
     driver.navigate().refresh();
    }

    public void searchQuery()
    {
        waitUntilElementLocated(querySearch,20);
        clickElement(querySearch);
    }

    public void enterQuery(String p)
    {
        enterText(querySearch,p);
    }

    public void SearchSubmit()
    {
        clickElement(SerachSubmit);
    }

    public void verifyResult()
    {
        String expectedTitle = "What currency is accepted?";
        By elementLocator = By.xpath("//h3[normalize-space()='What currency is accepted?']");
        waitUntilElementVisible(elementLocator, 60);
        String actualTitle = getTextFromElement(elementLocator);
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);

    }
    public void scroll() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,300)");
    }
    public void switchToIframeContainer() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(switchToIframe));

        WebElement iframeElement = driver.findElement(switchToIframe);
        driver.switchTo().frame(iframeElement);
    }
    public void clickVirtualAssistant() {
        waitUntilElementVisible(virtualassistant, 100);
        clickElement(virtualassistant);

    }
    public void clickOrderStatus() {
        waitUntilElementVisible(orderstatus, 20);
        clickElement(orderstatus);
    }

    public void ClickYes() {
        waitUntilElementLocated(clickyes, 20);
        clickElement(clickyes);

    }

    public void ClickNo() {
        waitUntilElementLocated(clickNo, 20);
        clickElement(clickNo);

    }
    public void cliclkClothig() {
//        driver.navigate().refresh();
        waitUntilElementLocated(menu_clothing, 20);
        clickElement(menu_clothing);
    }

}
