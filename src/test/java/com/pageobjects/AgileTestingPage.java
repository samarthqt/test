package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By scaleAgileLearnMore = By.id("scaleAgileLearnMore");
    protected By explorerTestingLearnMore = By.id("explorerTestingLearnMore");
    protected By distributedTeamLearnMore = By.id("distributedTeamLearnMore");
    protected By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");
    protected By getFreeTrialButton = By.id("getFreeTrialButton");
    protected By scaleAgileDetails = By.id("scaleAgileDetails");
    protected By explorerTestingDetails = By.id("explorerTestingDetails");
    protected By distributedTeamDetails = By.id("distributedTeamDetails");
    protected By integrationAPIsDetails = By.id("integrationAPIsDetails");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver = initializeDriver();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void verifySubMenuVisible(String subMenu) {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        Assert.assertTrue(driver.findElement(agileTestingSubMenu).isDisplayed(), subMenu + " sub-menu is not visible.");
    }

    public void clickSubMenu(String subMenu) {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
    }

    public void verifyGetFreeTrialAvailable() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        Assert.assertTrue(driver.findElement(getFreeTrialButton).isDisplayed(), "Get Free Trial button is not available.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 3);
        clickElement(scaleAgileLearnMore);
    }

    public void verifyScaleAgileDetailsVisible() {
        waitUntilElementVisible(scaleAgileDetails, 3);
        Assert.assertTrue(driver.findElement(scaleAgileDetails).isDisplayed(), "Scale Agile details are not visible.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 3);
        clickElement(explorerTestingLearnMore);
    }

    public void verifyExplorerTestingDetailsVisible() {
        waitUntilElementVisible(explorerTestingDetails, 3);
        Assert.assertTrue(driver.findElement(explorerTestingDetails).isDisplayed(), "eXplorer Testing details are not visible.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 3);
        clickElement(distributedTeamLearnMore);
    }

    public void verifyDistributedTeamDetailsVisible() {
        waitUntilElementVisible(distributedTeamDetails, 3);
        Assert.assertTrue(driver.findElement(distributedTeamDetails).isDisplayed(), "Distributed Team details are not visible.");
    }

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore, 3);
        clickElement(integrationAPIsLearnMore);
    }

    public void verifyIntegrationAPIsDetailsVisible() {
        waitUntilElementVisible(integrationAPIsDetails, 3);
        Assert.assertTrue(driver.findElement(integrationAPIsDetails).isDisplayed(), "Integration & APIs details are not visible.");
    }
}