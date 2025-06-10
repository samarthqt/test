package com.pageobjects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;

public class WebDisney extends WebReusableComponents {

    protected By virtualAssistant = By.xpath("//img[@alt='virtual-assistant-launcher']");
    protected By menuClothing = By.xpath("//span[normalize-space()='Clothing']");
    protected By cardService = By.xpath("//div[@class='float-left']//li[2]//div[1]");
    protected By btnStoreLocator = By.xpath("//span[normalize-space()='Store Locator']");
    protected By switchToIframe1 = By.xpath("//iframe[@class='align-center']");
    protected By searchLocator = By.xpath("//input[@placeholder='Enter city, state or postal code']");
    protected By btnDisneyCheckbox = By.xpath("//span[text()='Disney Outlet']");
    protected By btnSearch = By.xpath("//button[@class='button-search']");
    protected By switchToIframe = By.xpath("//iframe[@id='insync-iframe']");
    protected By orderStatus = By.xpath("//button[contains(@class,'insyncBtn')]");
    protected By clickYes = By.xpath("(//div[@class='insyncBubbles'])[1]/child::div[1]");
    protected By clickNo = By.xpath("(//div[@class='insyncBubbles'])[3]/child::div[2]");
    protected By querySearch = By.xpath("//input[@placeholder='Type your question here']");
    protected By searchSubmit = By.xpath("//input[@name='commit']");
    protected By yesFeedback = By.xpath("//button[normalize-space()='Yes']");

    public WebDisney() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String url) {
        driver.get(url);
        Assert.assertTrue(driver.getTitle().contains("Disney"), "Failed to launch Disney app.");
    }

    public void refresh() {
        driver.navigate().refresh();
        Assert.assertTrue(driver.getTitle().contains("Disney"), "Failed to refresh Disney app.");
    }

    public void searchQuery() {
        waitUntilElementVisible(querySearch, 20);
        clickElement(querySearch);
    }

    public void enterQuery(String query) {
        enterText(querySearch, query);
    }

    public void searchSubmit() {
        clickElement(searchSubmit);
    }

    public void verifyResult() {
        String expectedTitle = "What currency is accepted?";
        By elementLocator = By.xpath("//h3[normalize-space()='What currency is accepted?']");
        waitUntilElementVisible(elementLocator, 60);
        String actualTitle = getTextFromElement(elementLocator);
        Assert.assertEquals(actualTitle, expectedTitle, "Verification failed for query result.");
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
        waitUntilElementVisible(virtualAssistant, 100);
        clickElement(virtualAssistant);
    }

    public void clickOrderStatus() {
        waitUntilElementVisible(orderStatus, 20);
        clickElement(orderStatus);
    }

    public void clickYes() {
        waitUntilElementVisible(clickYes, 20);
        clickElement(clickYes);
    }

    public void clickNo() {
        waitUntilElementVisible(clickNo, 20);
        clickElement(clickNo);
    }

    public void clickClothing() {
        waitUntilElementVisible(menuClothing, 20);
        clickElement(menuClothing);
    }
}