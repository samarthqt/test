package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReturnPolicyPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By policyDetailsLocator = By.id(policy-details);
    private final By languageSelectorLocator = By.id(language-selector);
    private final By spanishOptionLocator = By.xpath(//option[@value='es']);

    public ReturnPolicyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public boolean isOnReturnPolicyPage() {
        boolean isOnPage = driver.getCurrentUrl().contains(return-policy);
        Assert.assertTrue(isOnPage, Not on Return Policy Page);
        return isOnPage;
    }

    public WebElement getPolicyDetails() {
        WebElement policyDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(policyDetailsLocator));
        Assert.assertNotNull(policyDetails, Policy details not found);
        return policyDetails;
    }

    public boolean isPolicyDetailsDisplayed() {
        boolean isDisplayed = getPolicyDetails().isDisplayed();
        Assert.assertTrue(isDisplayed, Policy details are not displayed);
        return isDisplayed;
    }

    public WebElement getLanguageSelector() {
        WebElement languageSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(languageSelectorLocator));
        Assert.assertNotNull(languageSelector, Language selector not found);
        return languageSelector;
    }

    public void changeLanguageToSpanish() {
        getLanguageSelector().click();
        WebElement spanishOption = wait.until(ExpectedConditions.elementToBeClickable(spanishOptionLocator));
        spanishOption.click();
        Assert.assertTrue(isPolicyDetailsInSpanish(), Policy details are not in Spanish);
    }

    public boolean isPolicyDetailsInSpanish() {
        boolean isInSpanish = getPolicyDetails().getText().contains(Devoluciones);
        Assert.assertTrue(isInSpanish, Policy details are not in Spanish);
        return isInSpanish;
    }
}