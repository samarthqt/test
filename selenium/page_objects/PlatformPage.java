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

    protected By agileTestingSubMenu = By.id(agileTestingSubMenu);
    protected By getFreeTrialButton = By.id(getFreeTrial);
    protected By scaleAgileLearnMoreButton = By.id(scaleAgileLearnMore);
    protected By explorerTestingLearnMoreButton = By.id(explorerTestingLearnMore);
    protected By distributedTeamLearnMoreButton = By.id(distributedTeamLearnMore);
    protected By integrationApisLearnMoreButton = By.id(integrationApisLearnMore);

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        switchToLastestWindow();
        Assert.assertTrue(driver.getWindowHandles().size() > 1, New browser window did not open.);
    }

    public void enterPlatformUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, URL did not match the expected platform URL.);
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(elementVisible(agileTestingSubMenu), Agile Testing SubMenu is not visible after click.);
    }

    public void callGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        element.click();
        Assert.assertTrue(elementVisible(getFreeTrialButton), Get Free Trial button is not visible after click.);
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMoreButton));
        element.click();
        Assert.assertTrue(elementVisible(scaleAgileLearnMoreButton), Scale Agile Learn More button is not visible after click.);
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMoreButton));
        element.click();
        Assert.assertTrue(elementVisible(explorerTestingLearnMoreButton), Explorer Testing Learn More button is not visible after click.);
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMoreButton));
        element.click();
        Assert.assertTrue(elementVisible(distributedTeamLearnMoreButton), Distributed Team Learn More button is not visible after click.);
    }

    public void clickIntegrationApisLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationApisLearnMoreButton));
        element.click();
        Assert.assertTrue(elementVisible(integrationApisLearnMoreButton), Integration APIs Learn More button is not visible after click.);
    }
}