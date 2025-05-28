package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class QASymphonyPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = //a[contains(text(), 'Agile Testing')])
    private WebElement agileTestingSubMenu;

    @FindBy(xpath = //a[contains(text(), 'Get Free Trial')])
    private WebElement getFreeTrialButton;

    @FindBy(xpath = //section[@id='scale-agile']//a[contains(text(), 'Learn More')])
    private WebElement scaleAgileLearnMoreButton;

    @FindBy(xpath = //section[@id='explorer-testing']//a[contains(text(), 'Learn More')])
    private WebElement explorerTestingLearnMoreButton;

    @FindBy(xpath = //section[@id='distributed-team']//a[contains(text(), 'Learn More')])
    private WebElement distributedTeamLearnMoreButton;

    @FindBy(xpath = //section[@id='integration-apis']//a[contains(text(), 'Learn More')])
    private WebElement integrationApisLearnMoreButton;

    public QASymphonyPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openPage(final String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, Failed to open the specified URL.);
    }

    public void clickAgileTestingSubMenu() {
        waitUntilVisible(agileTestingSubMenu);
        agileTestingSubMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(agile-testing), Failed to navigate to Agile Testing page.);
    }

    public void callGetFreeTrial() {
        waitUntilVisible(getFreeTrialButton);
        getFreeTrialButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(free-trial), Failed to navigate to Free Trial page.);
    }

    public void clickScaleAgileLearnMore() {
        waitUntilVisible(scaleAgileLearnMoreButton);
        scaleAgileLearnMoreButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(scale-agile), Failed to navigate to Scale Agile page.);
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilVisible(explorerTestingLearnMoreButton);
        explorerTestingLearnMoreButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(explorer-testing), Failed to navigate to Explorer Testing page.);
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilVisible(distributedTeamLearnMoreButton);
        distributedTeamLearnMoreButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(distributed-team), Failed to navigate to Distributed Team page.);
    }

    public void clickIntegrationApisLearnMore() {
        waitUntilVisible(integrationApisLearnMoreButton);
        integrationApisLearnMoreButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(integration-apis), Failed to navigate to Integration APIs page.);
    }

    private void waitUntilVisible(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}