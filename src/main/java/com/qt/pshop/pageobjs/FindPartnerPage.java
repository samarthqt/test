package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    @FindBy(id = "findPartnerButton")
    private WebElement findPartnerButton;

    @FindBy(id = "partnerPage")
    private WebElement partnerPage;

    private final WebDriverWait wait;

    public FindPartnerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        waitUntilElementVisible(findPartnerButton);
        findPartnerButton.click();
    }

    /**
     * Verifies if the partner page is displayed.
     * 
     * @return true if the partner page is displayed, false otherwise.
     */
    public boolean isPartnerPageDisplayed() {
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(partnerPage)).isDisplayed();
        Assert.assertTrue(isDisplayed, "Partner page is not displayed.");
        return isDisplayed;
    }

    /**
     * Waits until the specified element is visible.
     * 
     * @param element the WebElement to wait for.
     */
    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}