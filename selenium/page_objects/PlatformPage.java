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
    protected By scaleAgileLearnMore = By.id(scaleAgileLearnMore);
    protected By explorerTestingLearnMore = By.id(explorerTestingLearnMore);
    protected By distributedTeamLearnMore = By.id(distributedTeamLearnMore);
    protected By integrationApisLearnMore = By.id(integrationApisLearnMore);

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), New browser window was not opened successfully.);
    }

    public void enterPlatformUrl(String url) {
        navigateToUrl(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, Failed to navigate to the specified URL.);
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(isElementClicked(element), Agile Testing SubMenu was not clicked successfully.);
    }

    public void callGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), Get Free Trial button was not clicked successfully.);
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMore));
        element.click();
        Assert.assertTrue(isElementClicked(element), Scale Agile Learn More link was not clicked successfully.);
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMore));
        element.click();
        Assert.assertTrue(isElementClicked(element), Explorer Testing Learn More link was not clicked successfully.);
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMore));
        element.click();
        Assert.assertTrue(isElementClicked(element), Distributed Team Learn More link was not clicked successfully.);
    }

    public void clickIntegrationApisLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationApisLearnMore));
        element.click();
        Assert.assertTrue(isElementClicked(element), Integration APIs Learn More link was not clicked successfully.);
    }

    private boolean isElementClicked(WebElement element) {
        return element != null && element.isDisplayed();
    }

    private boolean isNewWindowOpened() {
        return driver.getWindowHandles().size() > 1;
    }
}