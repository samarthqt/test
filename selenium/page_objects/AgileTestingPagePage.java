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
    private WebElement getFreeTrialButton;

    @FindBy(xpath = "//section[contains(@class, 'scale-agile')]//a[contains(text(), 'Learn More')]")
    private WebElement scaleAgileLearnMore;

    @FindBy(xpath = "//section[contains(@class, 'explorer-testing')]//a[contains(text(), 'Learn More')]")
    private WebElement explorerTestingLearnMore;

    @FindBy(xpath = "//section[contains(@class, 'distributed-team')]//a[contains(text(), 'Learn More')]")
    private WebElement distributedTeamLearnMore;

    public PlatformPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAgileTestingSubMenu() {
        agileTestingSubMenu.click();
    }

    public void clickGetFreeTrial() {
        getFreeTrialButton.click();
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
}