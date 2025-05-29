package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By btnFindPartner = By.id("findPartnerButton");

    public PartnerPage() {
        this.driver = WebDriverInstance.getDriver(); // Assuming WebDriverInstance is a utility class to get the driver
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens a new browser window.
     */
    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
        Assert.assertTrue(driver.getWindowHandles().size() > 1, "New browser window was not opened.");
    }

    /**
     * Navigates to the Partner Page URL.
     */
    public void enterPartnerPageUrl() {
        driver.navigate().to("http://www.qasymphony.com/partners.html");
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.qasymphony.com/partners.html", "Failed to navigate to Partner Page URL.");
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), "Find Partner button was not clicked successfully.");
    }

    /**
     * Waits until the specified element is visible.
     * 
     * @param by Locator of the element
     * @param timeOutInSeconds Timeout in seconds
     */
    public void waitUntilElementVisible(By by, long timeOutInSeconds) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}