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

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = Agile Testing)
    private WebElement agileTestingSubMenu;

    @FindBy(linkText = Get Free Trial)
    private WebElement getFreeTrialButton;

    @FindBy(xpath = //section[contains(@class, 'scale-agile')]//a[text()='Learn More'])
    private WebElement scaleAgileLearnMoreButton;

    @FindBy(xpath = //section[contains(@class, 'explorer-testing')]//a[text()='Learn More'])
    private WebElement explorerTestingLearnMoreButton;

    @FindBy(xpath = //section[contains(@class, 'distributed-team')]//a[text()='Learn More'])
    private WebElement distributedTeamLearnMoreButton;

    public QASymphonyPlatformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementClickable(agileTestingSubMenu);
        agileTestingSubMenu.click();
        Assert.assertTrue(isElementVisible(By.linkText(Agile Testing)), Agile Testing submenu is not visible after click.);
    }

    public void clickGetFreeTrial() {
        waitUntilElementClickable(getFreeTrialButton);
        getFreeTrialButton.click();
        Assert.assertTrue(isElementVisible(By.linkText(Get Free Trial)), Get Free Trial button is not visible after click.);
    }

    public void clickScaleAgileLearnMore() {
        waitUntilElementClickable(scaleAgileLearnMoreButton);
        scaleAgileLearnMoreButton.click();
        Assert.assertTrue(isElementVisible(By.xpath(//section[contains(@class, 'scale-agile')]//a[text()='Learn More'])), Scale Agile Learn More button is not visible after click.);
    }

    public void clickExplorerTestingLearnMore() {
        waitUntilElementClickable(explorerTestingLearnMoreButton);
        explorerTestingLearnMoreButton.click();
        Assert.assertTrue(isElementVisible(By.xpath(//section[contains(@class, 'explorer-testing')]//a[text()='Learn More'])), Explorer Testing Learn More button is not visible after click.);
    }

    public void clickDistributedTeamLearnMore() {
        waitUntilElementClickable(distributedTeamLearnMoreButton);
        distributedTeamLearnMoreButton.click();
        Assert.assertTrue(isElementVisible(By.xpath(//section[contains(@class, 'distributed-team')]//a[text()='Learn More'])), Distributed Team Learn More button is not visible after click.);
    }

    private void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}