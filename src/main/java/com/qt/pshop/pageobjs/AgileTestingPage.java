package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private final By agileTestingSubMenu = By.id("agileTestingSubMenu");
    private final By getFreeTrialButton = By.id("getFreeTrial");
    private final By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    private final By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    private final By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    private final By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the Agile Testing page.
     */
    public void navigateToAgileTestingPage() {
        launchUrl("http://www.qasymphony.com/platform.html");
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, "http://www.qasymphony.com/platform.html", "Failed to navigate to Agile Testing page.");
    }

    /**
     * Clicks on the Agile Testing submenu.
     */
    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 5);
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Agile Testing submenu is not visible after clicking.");
    }

    /**
     * Initiates the free trial process.
     */
    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 5);
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Get Free Trial button is not visible after clicking.");
    }

    /**
     * Clicks on the 'Scale Agile' learn more link.
     */
    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 5);
        WebElement element = driver.findElement(scaleAgileLearnMore);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Scale Agile Learn More link is not visible after clicking.");
    }

    /**
     * Clicks on the 'Explorer Testing' learn more link.
     */
    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 5);
        WebElement element = driver.findElement(explorerTestingLearnMore);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Explorer Testing Learn More link is not visible after clicking.");
    }

    /**
     * Clicks on the 'Distributed Team' learn more link.
     */
    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 5);
        WebElement element = driver.findElement(distributedTeamLearnMore);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Distributed Team Learn More link is not visible after clicking.");
    }

    /**
     * Clicks on the 'Integration APIs' learn more link.
     */
    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore, 5);
        WebElement element = driver.findElement(integrationAPIsLearnMore);
        element.click();
        Assert.assertTrue(element.isDisplayed(), "Integration APIs Learn More link is not visible after clicking.");
    }
}