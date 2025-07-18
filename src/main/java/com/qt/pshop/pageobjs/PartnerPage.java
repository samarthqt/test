package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerPage extends WebReusableComponents {

    private final By btnFindPartner = By.id("findPartnerButton");
    private final By partnerPageContent = By.id("partnerPageContent");

    public PartnerPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the 'Find Partner' button and waits for the partner page content to be visible.
     */
    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 5);
        clickElement(btnFindPartner);
        waitUntilElementVisible(partnerPageContent, 5);
    }

    /**
     * Checks if the partner page is displayed by verifying the visibility of the partner page content.
     * 
     * @return true if the partner page content is displayed, false otherwise.
     */
    public boolean isPartnerPageDisplayed() {
        waitUntilElementVisible(partnerPageContent, 5);
        boolean isDisplayed = isElementDisplayed(partnerPageContent);
        Assert.assertTrue(isDisplayed, "Partner page content is not displayed.");
        return isDisplayed;
    }

    /**
     * Waits until the specified element is visible within the given timeout.
     * 
     * @param by the locator of the element to wait for.
     * @param timeOutInSeconds the timeout in seconds.
     */
    public void waitUntilElementVisible(By by, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Clicks on the specified element.
     * 
     * @param by the locator of the element to click.
     */
    public void clickElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    /**
     * Checks if the specified element is displayed.
     * 
     * @param by the locator of the element to check.
     * @return true if the element is displayed, false otherwise.
     */
    public boolean isElementDisplayed(By by) {
        WebElement element = driver.findElement(by);
        return element.isDisplayed();
    }
}