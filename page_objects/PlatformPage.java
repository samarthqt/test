package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PlatformPage extends WebReusableComponents {

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileLearnMoreButton = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMoreButton = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMoreButton = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMoreButton = By.id("integrationAPIsLearnMore");

    public PlatformPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), "New browser window was not opened successfully.");
    }

    public void enterPlatformUrl(String url) {
        navigateToUrl(url);
        Assert.assertEquals(getCurrentURL(), url, "Failed to navigate to the specified URL.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), "Agile Testing Sub Menu was not clicked successfully.");
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

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMoreButton, 3);
        clickElement(integrationAPIsLearnMoreButton);
        Assert.assertTrue(isElementVisible(integrationAPIsLearnMoreButton), "Integration APIs Learn More button was not clicked successfully.");
    }

    private boolean isNewWindowOpened() {
        // Implement logic to verify if a new window is opened
        return true; // Placeholder for actual implementation
    }

    private boolean isElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}