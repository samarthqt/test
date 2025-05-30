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

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By findPartnerButton = By.id("findPartner");

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens a new browser window.
     */
    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WebDriver.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), "New browser window was not opened.");
    }

    /**
     * Navigates to the partner page URL.
     */
    public void enterPartnerPageURL() {
        driver.navigate().to("http://www.qasymphony.com/partners.html");
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.qasymphony.com/partners.html", "Failed to navigate to the partner page URL.");
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(findPartnerButton));
        button.click();
        Assert.assertTrue(button.isDisplayed(), "Find Partner button was not clicked successfully.");
    }
}