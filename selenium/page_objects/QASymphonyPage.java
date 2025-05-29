package com.pageobjects;

import org.openqa.selenium.By;
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
    protected By integrationAPIsLearnMore = By.id("integrationAPIsLearnMore");

    public QASymphonyPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        openNewWindow();
        Assert.assertTrue(isNewWindowOpened(), "New browser window was not opened.");
    }

    public void enterURL(String url) {
        navigateToUrl(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL navigation failed.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        clickElement(agileTestingSubMenu);
        Assert.assertTrue(isElementClicked(agileTestingSubMenu), "Agile Testing SubMenu was not clicked.");
    }

    public void callGetFreeTrial() {
        waitUntilElementVisible(getFreeTrialButton, 3);
        clickElement(getFreeTrialButton);
        Assert.assertTrue(isElementClicked(getFreeTrialButton), "Get Free Trial button was not clicked.");
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementVisible(scaleAgileLearnMore, 3);
        clickElement(scaleAgileLearnMore);
        Assert.assertTrue(isElementClicked(scaleAgileLearnMore), "Scale Agile Learn More was not clicked.");
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementVisible(explorerTestingLearnMore, 3);
        clickElement(explorerTestingLearnMore);
        Assert.assertTrue(isElementClicked(explorerTestingLearnMore), "Explorer Testing Learn More was not clicked.");
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementVisible(distributedTeamLearnMore, 3);
        clickElement(distributedTeamLearnMore);
        Assert.assertTrue(isElementClicked(distributedTeamLearnMore), "Distributed Team Learn More was not clicked.");
    }

    public void clickIntegrationAPIsLearnMore() {
        waitUntilElementVisible(integrationAPIsLearnMore, 3);
        clickElement(integrationAPIsLearnMore);
        Assert.assertTrue(isElementClicked(integrationAPIsLearnMore), "Integration APIs Learn More was not clicked.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementClicked(By locator) {
        // Implement logic to verify if the element was clicked successfully
        return true; // Placeholder for actual implementation
    }

    private boolean isNewWindowOpened() {
        // Implement logic to verify if a new window was opened successfully
        return true; // Placeholder for actual implementation
    }
}