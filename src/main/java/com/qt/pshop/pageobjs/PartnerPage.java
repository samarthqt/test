package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By findPartnerButton = By.id("findPartnerButton");

    public PartnerPage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void enterUrl(String url) {
        driver.get(url);
    }

    public void clickFindPartnerButton() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(findPartnerButton));
        button.click();
    }

    public boolean isPartnerPageDisplayed() {
        String currentUrl = driver.getCurrentUrl();
        boolean isDisplayed = currentUrl.contains("partners.html");
        Assert.assertTrue(isDisplayed, "Partner page is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }
}