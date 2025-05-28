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
    public PlatformPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void openPage(final String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, Failed to open the specified URL.);
    }

    public void clickAgileTestingSubMenu() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(agileTestingSubMenu));
        element.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(agile-testing), Agile Testing submenu was not clicked successfully.);
    }

    public void clickGetFreeTrial() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getFreeTrialButton));
        element.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(free-trial), Get Free Trial button was not clicked successfully.);
    }

    public void clickScaleAgileLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(scaleAgileLearnMoreButton));
        element.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(scale-agile), Scale Agile Learn More button was not clicked successfully.);
    }

    public void clickExplorerTestingLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(explorerTestingLearnMoreButton));
        element.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(explorer-testing), Explorer Testing Learn More button was not clicked successfully.);
    }

    public void clickDistributedTeamLearnMore() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(distributedTeamLearnMoreButton));
        element.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(distributed-team), Distributed Team Learn More button was not clicked successfully.);
    }
}