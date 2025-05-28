package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = //a[text()='Find a Partner'])
    private WebElement findPartnerButton;

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(http://www.qasymphony.com/partners.html);
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, http://www.qasymphony.com/partners.html, Failed to open Partner page.);
    }

    public void clickFindPartnerButton() {
        waitUntilElementClickable(findPartnerButton, 10);
        findPartnerButton.click();
        Assert.assertTrue(objectExists(By.xpath(//div[@id='partnerList'])), Partner list is not displayed after clicking Find Partner button.);
    }

    private void waitUntilElementClickable(WebElement element, long timeOutInSeconds) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private Boolean objectExists(By by) {
        return !driver.findElements(by).isEmpty();
    }
}