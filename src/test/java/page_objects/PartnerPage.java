
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

    protected By btnFindPartner = By.id("findPartnerButton");

    public PartnerPage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), "New browser window was not opened successfully.");
    }

    public void enterPartnerPageUrl() {
        String url = "http://www.qasymphony.com/partners.html";
        driver.navigate().to(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "Failed to navigate to the Partner Page URL.");
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnFindPartner));
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), "Find Partner button was not clicked successfully.");
    }
}
