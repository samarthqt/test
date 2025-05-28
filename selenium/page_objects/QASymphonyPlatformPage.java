package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class QASymphonyPlatformPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(linkText = Agile Testing)
    private WebElement agileTestingSubMenu;

    @FindBy(linkText = Get Free Trial)
    private WebElement getFreeTrialButton;

    @FindBy(xpath = //section[contains(@class, 'scale-agile')]//a[contains(text(), 'Learn More')])
    private WebElement scaleAgileLearnMore;

    @FindBy(xpath = //section[contains(@class, 'explorer-testing')]//a[contains(text(), 'Learn More')])
    private WebElement explorerTestingLearnMore;

    @FindBy(xpath = //section[contains(@class, 'distributed-team')]//a[contains(text(), 'Learn More')])
    private WebElement distributedTeamLearnMore;

    @FindBy(xpath = //section[contains(@class, 'integration-apis')]//a[contains(text(), 'Learn More')])
    private WebElement integrationApisLearnMore;

    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, Failed to open the specified URL.);
    }

    public void clickAgileTestingSubMenu() {
        waitUntilVisible(agileTestingSubMenu);
        agileTestingSubMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(agile-testing), Agile Testing submenu click failed.);
    }

    public void clickGetFreeTrial() {
        waitUntilVisible(getFreeTrialButton);
        getFreeTrialButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(free-trial), Get Free Trial button click failed.);
    }

    public void clickScaleAgileLearnMore() {
        waitUntilVisible(scaleAgileLearnMore);
        scaleAgileLearnMore.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(scale-agile), Scale Agile Learn More click failed.);
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilVisible(explorerTestingLearnMore);
        explorerTestingLearnMore.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(explorer-testing), Explorer Testing Learn More click failed.);
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilVisible(distributedTeamLearnMore);
        distributedTeamLearnMore.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(distributed-team), Distributed Team Learn More click failed.);
    }

    public void clickIntegrationApisLearnMore() {
        waitUntilVisible(integrationApisLearnMore);
        integrationApisLearnMore.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(integration-apis), Integration APIs Learn More click failed.);
    }

    private void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}