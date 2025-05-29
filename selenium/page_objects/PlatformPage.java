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

    private WebDriver driver;
    private WebDriverWait wait;

    protected final By agileTestingSubMenu = By.id(agileTestingSubMenu);
    protected final By getFreeTrialButton = By.id(getFreeTrial);
    protected final By scaleAgileLearnMoreButton = By.id(scaleAgileLearnMore);
    protected final By explorerTestingLearnMoreButton = By.id(explorerTestingLearnMore);
    protected final By distributedTeamLearnMoreButton = By.id(distributedTeamLearnMore);
    protected final By integrationAPIsLearnMoreButton = By.id(integrationAPIsLearnMore);

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WebDriver.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), Failed to open new browser window.);
    }

    public void enterPlatformUrl() {
        driver.navigate().to(http://www.qasymphony.com/platform.html);
        Assert.assertEquals(driver.getCurrentUrl(), http://www.qasymphony.com/platform.html, URL navigation failed.);
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(element.isDisplayed(), Agile Testing SubMenu is not visible after click.);
    }

    public void callGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        element.click();
        Assert.assertTrue(element.isDisplayed(), Get Free Trial button is not visible after click.);
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMoreButton));
        element.click();
        Assert.assertTrue(element.isDisplayed(), Scale Agile Learn More button is not visible after click.);
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMoreButton));
        element.click();
        Assert.assertTrue(element.isDisplayed(), Explorer Testing Learn More button is not visible after click.);
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMoreButton));
        element.click();
        Assert.assertTrue(element.isDisplayed(), Distributed Team Learn More button is not visible after click.);
    }

    public void clickIntegrationAPIsLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationAPIsLearnMoreButton));
        element.click();
        Assert.assertTrue(element.isDisplayed(), Integration APIs Learn More button is not visible after click.);
    }
}