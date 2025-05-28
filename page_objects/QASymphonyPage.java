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

    @FindBy(linkText = Agile Testing)
    private WebElement agileTestingSubMenu;

    @FindBy(linkText = Get Free Trial)
    private WebElement getFreeTrialButton;

    @FindBy(xpath = //section[@id='scale-agile']//a[contains(text(),'Learn More')])
    private WebElement scaleAgileLearnMoreButton;

    @FindBy(xpath = //section[@id='explorer-testing']//a[contains(text(),'Learn More')])
    private WebElement explorerTestingLearnMoreButton;

    @FindBy(xpath = //section[@id='distributed-team']//a[contains(text(),'Learn More')])
    private WebElement distributedTeamLearnMoreButton;

    public QASymphonyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openAgileTestingSubMenu() {
        waitUntilVisible(agileTestingSubMenu);
        agileTestingSubMenu.click();
        Assert.assertTrue(isElementVisible(agileTestingSubMenu), Agile Testing submenu is not visible after clicking.);
    }

    public void clickGetFreeTrial() {
        waitUntilVisible(getFreeTrialButton);
        getFreeTrialButton.click();
        Assert.assertTrue(isElementVisible(getFreeTrialButton), Get Free Trial button is not visible after clicking.);
    }

    public void clickScaleAgileLearnMore() {
        waitUntilVisible(scaleAgileLearnMoreButton);
        scaleAgileLearnMoreButton.click();
        Assert.assertTrue(isElementVisible(scaleAgileLearnMoreButton), Scale Agile Learn More button is not visible after clicking.);
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilVisible(explorerTestingLearnMoreButton);
        explorerTestingLearnMoreButton.click();
        Assert.assertTrue(isElementVisible(explorerTestingLearnMoreButton), Explorer Testing Learn More button is not visible after clicking.);
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilVisible(distributedTeamLearnMoreButton);
        distributedTeamLearnMoreButton.click();
        Assert.assertTrue(isElementVisible(distributedTeamLearnMoreButton), Distributed Team Learn More button is not visible after clicking.);
    }

    private void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}