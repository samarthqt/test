package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlatformPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By agileTestingSubMenu = By.linkText(Agile Testing);
    private final By getFreeTrialButton = By.linkText(Get Free Trial);
    private final By scaleAgileLearnMoreButton = By.xpath(//section[@id='scale-agile']//a[contains(text(), 'Learn More')]);
    private final By explorerTestingLearnMoreButton = By.xpath(//section[@id='explorer-testing']//a[contains(text(), 'Learn More')]);
    private final By distributedTeamLearnMoreButton = By.xpath(//section[@id='distributed-team']//a[contains(text(), 'Learn More')]);

    // Constructor
    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the specified URL in the browser.
     * @param url The URL to open.
     */
    public void openPage(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, Failed to open the specified URL.);
    }

    /**
     * Clicks on the Agile Testing submenu.
     */
    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(driver.findElement(agileTestingSubMenu).isDisplayed(), Agile Testing submenu is not displayed.);
    }

    /**
     * Clicks on the Get Free Trial button.
     */
    public void clickGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getFreeTrialButton));
        element.click();
        Assert.assertTrue(driver.findElement(getFreeTrialButton).isDisplayed(), Get Free Trial button is not displayed.);
    }

    /**
     * Clicks on the Scale Agile Learn More button.
     */
    public void clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(scaleAgileLearnMoreButton));
        element.click();
        Assert.assertTrue(driver.findElement(scaleAgileLearnMoreButton).isDisplayed(), Scale Agile Learn More button is not displayed.);
    }

    /**
     * Clicks on the Explorer Testing Learn More button.
     */
    public void clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(explorerTestingLearnMoreButton));
        element.click();
        Assert.assertTrue(driver.findElement(explorerTestingLearnMoreButton).isDisplayed(), Explorer Testing Learn More button is not displayed.);
    }

    /**
     * Clicks on the Distributed Team Learn More button.
     */
    public void clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(distributedTeamLearnMoreButton));
        element.click();
        Assert.assertTrue(driver.findElement(distributedTeamLearnMoreButton).isDisplayed(), Distributed Team Learn More button is not displayed.);
    }
}