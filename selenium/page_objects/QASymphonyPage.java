package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class QASymphonyPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationApisLearnMore = By.id("integrationApisLearnMore");

    public QASymphonyPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow(String url) {
        openNewWindow();
        navigateToUrl(url);
        Assert.assertTrue(driver.getCurrentUrl().contains(url), "Failed to open new browser window with URL: " + url);
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementDisplayed(agileTestingSubMenu), "Agile Testing SubMenu was not clicked successfully.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementDisplayed(getFreeTrialButton), "Get Free Trial button was not clicked successfully.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 3);
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(isElementDisplayed(scaleAgileLearnMore), "Scale Agile Learn More was not clicked successfully.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 3);
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(isElementDisplayed(explorerTestingLearnMore), "Explorer Testing Learn More was not clicked successfully.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 3);
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(isElementDisplayed(distributedTeamLearnMore), "Distributed Team Learn More was not clicked successfully.");
    }

    public void clickIntegrationApisLearnMore() {
        waitUntilElementVisible(integrationApisLearnMore, 3);
        clickElement(integrationApisLearnMore);
        Assert.assertTrue(isElementDisplayed(integrationApisLearnMore), "Integration APIs Learn More was not clicked successfully.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}