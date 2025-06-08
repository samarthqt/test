package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By getFreeTrialButton = By.id("getFreeTrial");
    protected By scaleAgileSection = By.id("scaleAgileSection");
    protected By explorerTestingSection = By.id("explorerTestingSection");
    protected By distributedTeamSection = By.id("distributedTeamSection");
    protected By integrationApisSection = By.id("integrationApisSection");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void verifyAgileTestingPageDisplayed() {
        Assert.assertTrue(driver.getTitle().contains("Agile Testing"), "Agile Testing page is not displayed.");
    }

    public void clickAgileTestingSubMenu(String subMenu) {
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
    }

    public void verifyAgileTestingSubMenuDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(agileTestingSubMenu));
        Assert.assertTrue(driver.findElement(agileTestingSubMenu).isDisplayed(), "Agile Testing sub-menu is not displayed.");
    }

    public void initiateGetFreeTrial() {
        WebElement element = driver.findElement(getFreeTrialButton);
        element.click();
    }

    public void verifyGetFreeTrialInitiated() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFreeTrialButton));
        Assert.assertTrue(driver.findElement(getFreeTrialButton).isDisplayed(), "Get Free Trial process is not initiated.");
    }

    public void clickSectionContentOrLearnMore(String section) {
        By sectionLocator = getSectionLocator(section);
        WebElement element = driver.findElement(sectionLocator);
        element.click();
    }

    public void verifySectionDetailsDisplayed(String section) {
        By sectionLocator = getSectionLocator(section);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionLocator));
        Assert.assertTrue(driver.findElement(sectionLocator).isDisplayed(), section + " section details are not displayed.");
    }

    private By getSectionLocator(String section) {
        switch (section) {
            case "Scale Agile":
                return scaleAgileSection;
            case "eXplorer Testing":
                return explorerTestingSection;
            case "Distributed Team":
                return distributedTeamSection;
            case "Integration & APIs":
                return integrationApisSection;
            default:
                throw new IllegalArgumentException("Unknown section: " + section);
        }
    }
}