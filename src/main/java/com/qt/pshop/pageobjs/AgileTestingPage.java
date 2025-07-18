package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrialButton");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(element);
        Assert.assertTrue(element.isDisplayed(), "Agile Testing Sub Menu is not displayed");
    }

    public void callGetFreeTrial() {
        WebElement element = waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(element);
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial Button is not displayed");
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = waitUntilElementVisible(scaleAgileLearnMore, 3);
        clickElement(element);
        Assert.assertTrue(element.isDisplayed(), "Scale Agile Learn More is not displayed");
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = waitUntilElementVisible(explorerTestingLearnMore, 3);
        clickElement(element);
        Assert.assertTrue(element.isDisplayed(), "Explorer Testing Learn More is not displayed");
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = waitUntilElementVisible(distributedTeamLearnMore, 3);
        clickElement(element);
        Assert.assertTrue(element.isDisplayed(), "Distributed Team Learn More is not displayed");
    }

    public void clickIntegrationAPIsLearnMore() {
        WebElement element = waitUntilElementVisible(integrationAPIsLearnMore, 3);
        clickElement(element);
        Assert.assertTrue(element.isDisplayed(), "Integration APIs Learn More is not displayed");
    }

    private WebElement waitUntilElementVisible(By locator, int timeout) {
        return waitUntilElementVisible(locator, timeout);
    }

    private void clickElement(WebElement element) {
        element.click();
    }
}