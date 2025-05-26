package com.qasymphony.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlatformPage {

    WebDriver driver;

    @FindBy(linkText = "Agile Testing")
    private WebElement agileTestingSubMenu;

    @FindBy(linkText = "Get Free Trial")
    private WebElement getFreeTrialLink;

    @FindBy(xpath = "//section[@id='scale-agile']//a[contains(text(), 'Learn More')]")
    private WebElement scaleAgileLearnMore;

    @FindBy(xpath = "//section[@id='explorer-testing']//a[contains(text(), 'Learn More')]")
    private WebElement explorerTestingLearnMore;

    @FindBy(xpath = "//section[@id='distributed-team']//a[contains(text(), 'Learn More')]")
    private WebElement distributedTeamLearnMore;

    @FindBy(xpath = "//section[@id='integration-apis']//a[contains(text(), 'Learn More')]")
    private WebElement integrationApisLearnMore;

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAgileTestingSubMenu() {
        agileTestingSubMenu.click();
    }

    public void clickGetFreeTrial() {
        getFreeTrialLink.click();
    }

    public void clickScaleAgileLearnMore() {
        scaleAgileLearnMore.click();
    }

    public void clickExplorerTestingLearnMore() {
        explorerTestingLearnMore.click();
    }

    public void clickDistributedTeamLearnMore() {
        distributedTeamLearnMore.click();
    }

    public void clickIntegrationApisLearnMore() {
        integrationApisLearnMore.click();
    }
}