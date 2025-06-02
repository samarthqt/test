package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PlatformPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMore");
    protected By integrationApisLearnMoreButton = By.id("integrationApisLearnMore");

    public PlatformPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), "New browser window was not opened successfully.");
    }

    public void enterPlatformUrl() {
        navigateToUrl("http://www.qasymphony.com/platform.html");
        Assert.assertEquals(getCurrentURL(), "http://www.qasymphony.com/platform.html", "URL navigation failed.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu was not clicked successfully.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementVisible(getFreeTrialButton), "Get Free Trial button was not clicked successfully.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMoreButton, 3);
        clickElement(scaleAgileLearnMoreButton);
        Assert.assertTrue(isElementVisible(scaleAgileLearnMoreButton), "Scale Agile Learn More button was not clicked successfully.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMoreButton, 3);
        clickElement(explorerTestingLearnMoreButton);
        Assert.assertTrue(isElementVisible(explorerTestingLearnMoreButton), "Explorer Testing Learn More button was not clicked successfully.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMoreButton, 3);
        clickElement(distributedTeamLearnMoreButton);
        Assert.assertTrue(isElementVisible(distributedTeamLearnMoreButton), "Distributed Team Learn More button was not clicked successfully.");
    }

    public void clickIntegrationApisLearnMore() {
        waitUntilElementVisible(integrationApisLearnMoreButton, 3);
        clickElement(integrationApisLearnMoreButton);
        Assert.assertTrue(isElementVisible(integrationApisLearnMoreButton), "Integration APIs Learn More button was not clicked successfully.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    private boolean isNewWindowOpened() {
        return driver.getWindowHandles().size() > 1;
    }
}