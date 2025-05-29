package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class QASymphonyPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMoreButton = By.id("integrationAPIsLearnMore");

    public QASymphonyPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), "New browser window was not opened.");
    }

    public void enterPlatformUrl() {
        navigateToUrl("http://www.qasymphony.com/platform.html");
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.qasymphony.com/platform.html", "URL navigation failed.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing SubMenu was not clicked.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button was not clicked.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMoreButton, 3);
        WebElement element = driver.findElement(scaleAgileLearnMoreButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Scale Agile Learn More button was not clicked.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMoreButton, 3);
        WebElement element = driver.findElement(explorerTestingLearnMoreButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Explorer Testing Learn More button was not clicked.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMoreButton, 3);
        WebElement element = driver.findElement(distributedTeamLearnMoreButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Distributed Team Learn More button was not clicked.");
    }

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMoreButton, 3);
        WebElement element = driver.findElement(integrationAPIsLearnMoreButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Integration APIs Learn More button was not clicked.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private boolean isNewWindowOpened() {
        return driver.getWindowHandles().size() > 1;
    }
}