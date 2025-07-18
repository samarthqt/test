package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By btnFindPartner = By.id("findPartnerButton");
    private final By partnerPageContent = By.id("partnerPageContent");

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the 'Find Partner' button and verifies the action.
     */
    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 5);
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(isPartnerPageDisplayed(), "Partner page is not displayed after clicking 'Find Partner' button.");
    }

    /**
     * Checks if the partner page content is displayed.
     * 
     * @return true if the partner page content is visible, false otherwise.
     */
    public boolean isPartnerPageDisplayed() {
        waitUntilElementVisible(partnerPageContent, 5);
        WebElement content = driver.findElement(partnerPageContent);
        boolean isDisplayed = content.isDisplayed();
        Assert.assertTrue(isDisplayed, "Partner page content is not displayed.");
        return isDisplayed;
    }

    /**
     * Waits until the specified element is visible on the page.
     * 
     * @param by the locator of the element to wait for
     * @param timeOutInSeconds the timeout in seconds
     */
    public void waitUntilElementVisible(By by, long timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}