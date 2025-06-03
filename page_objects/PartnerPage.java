package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.switchTo().newWindow(WebDriver.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), "New browser window did not open successfully.");
    }

    /**
     * Navigates to the specified URL.
     * @param url The URL to navigate to.
     */
    public void enterURL(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "Failed to navigate to the specified URL.");
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(btnFindPartner));
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), "Find Partner button was not clicked successfully.");
    }
}