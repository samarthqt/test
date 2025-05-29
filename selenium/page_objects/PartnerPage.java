package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerPage extends WebReusableComponents {

    protected By btnFindPartner = By.id("findPartnerButton");

    public PartnerPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens a new browser window.
     */
    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.WINDOW);
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
        WebElement findPartnerButton = waitUntilElementVisible(btnFindPartner, 3);
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), "Find Partner button was not clicked successfully.");
    }

    /**
     * Waits until the specified element is visible.
     * 
     * @param locator The locator of the element to wait for.
     * @param timeout The timeout in seconds.
     * @return The visible WebElement.
     */
    public WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}