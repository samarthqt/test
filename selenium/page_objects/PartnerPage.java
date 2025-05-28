package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = Find a Partner)
    private WebElement findPartnerButton;

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the Partner page.
     */
    public void openPage() {
        driver.get(http://www.qasymphony.com/partners.html);
        Assert.assertTrue(driver.getTitle().contains(Partners), Page title does not contain 'Partners');
    }

    /**
     * Clicks the 'Find a Partner' button.
     */
    public void clickFindPartner() {
        waitUntilElementClickable(findPartnerButton);
        findPartnerButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(find-a-partner), URL does not contain 'find-a-partner');
    }

    /**
     * Waits until the specified element is clickable.
     * 
     * @param element The WebElement to wait for.
     */
    private void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}