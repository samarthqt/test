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
    protected By integrationAPIsLearnMoreButton = By.id(integrationAPIsLearnMore);

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
        Assert.assertTrue(isElementClicked(element), Failed to click on Agile Testing Sub Menu.);
    }

    public void callGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), Failed to click on Get Free Trial button.);
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scaleAgileLearnMoreButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), Failed to click on Scale Agile Learn More button.);
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(explorerTestingLearnMoreButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), Failed to click on Explorer Testing Learn More button.);
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(distributedTeamLearnMoreButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), Failed to click on Distributed Team Learn More button.);
    }

    public void clickIntegrationAPIsLearnMore() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(integrationAPIsLearnMoreButton));
        element.click();
        Assert.assertTrue(isElementClicked(element), Failed to click on Integration APIs Learn More button.);
    }

    private boolean isElementClicked(WebElement element) {
        return element != null && element.isDisplayed();
    }

    private boolean isNewWindowOpened() {
        return driver.getWindowHandles().size() > 1;
    }
}