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

    private WebDriver driver;
    private WebDriverWait wait;

    protected By btnFindPartner = By.id(findPartnerButton);

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WebDriver.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), Failed to open a new browser window.);
    }

    public void enterPartnerPageUrl() {
        driver.navigate().to(http://www.qasymphony.com/partners.html);
        Assert.assertEquals(driver.getCurrentUrl(), http://www.qasymphony.com/partners.html, URL navigation failed.);
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnFindPartner));
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), Find Partner button is not visible after click.);
    }
}