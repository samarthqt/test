package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PlatformPage extends WebReusableComponents {

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");
    private final By freeTrialButton = By.id("freeTrialButton");

    public PlatformPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), "New browser window was not opened.");
    }

    public void enterPlatformURL() {
        navigateToUrl("http://www.qasymphony.com/platform.html");
        Assert.assertEquals(getCurrentURL(), "http://www.qasymphony.com/platform.html", "URL did not match.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing SubMenu was not clicked.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(freeTrialButton, 3);
        clickElement(freeTrialButton);
        Assert.assertTrue(isElementVisible(freeTrialButton), "Get Free Trial button was not clicked.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 3);
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(isElementVisible(scaleAgileLearnMore), "Scale Agile Learn More was not clicked.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 3);
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(isElementVisible(explorerTestingLearnMore), "Explorer Testing Learn More was not clicked.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 3);
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(isElementVisible(distributedTeamLearnMore), "Distributed Team Learn More was not clicked.");
    }

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore, 3);
        clickElement(integrationAPIsLearnMore);
        Assert.assertTrue(isElementVisible(integrationAPIsLearnMore), "Integration APIs Learn More was not clicked.");
    }

    private boolean isNewWindowOpened() {
        // Implement logic to verify if a new window is opened
        return true;
    }

    private boolean isElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}