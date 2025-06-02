package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.switchTo().newWindow(WebDriver.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), "Failed to open a new browser window.");
    }

    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not match the expected value.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementDisplayed(agileTestingSubMenu), "Agile Testing Sub Menu was not clicked successfully.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementDisplayed(getFreeTrialButton), "Get Free Trial button was not clicked successfully.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMoreButton, 3);
        clickElement(scaleAgileLearnMoreButton);
        Assert.assertTrue(isElementDisplayed(scaleAgileLearnMoreButton), "Scale Agile Learn More button was not clicked successfully.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMoreButton, 3);
        clickElement(explorerTestingLearnMoreButton);
        Assert.assertTrue(isElementDisplayed(explorerTestingLearnMoreButton), "Explorer Testing Learn More button was not clicked successfully.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMoreButton, 3);
        clickElement(distributedTeamLearnMoreButton);
        Assert.assertTrue(isElementDisplayed(distributedTeamLearnMoreButton), "Distributed Team Learn More button was not clicked successfully.");
    }

    public void clickIntegrationApisLearnMore() {
        waitUntilElementVisible(integrationApisLearnMoreButton, 3);
        clickElement(integrationApisLearnMoreButton);
        Assert.assertTrue(isElementDisplayed(integrationApisLearnMoreButton), "Integration APIs Learn More button was not clicked successfully.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}