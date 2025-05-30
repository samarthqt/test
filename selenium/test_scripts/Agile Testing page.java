package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrowserAutomation {

    private WebDriver driver;

    public BrowserAutomation() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void openNewBrowserWindow() {
        driver.manage().window().maximize();
    }

    public void enterURL(String url) {
        driver.get(url);
    }

    public void clickAgileTestingSubMenu() {
        WebElement agileTestingSubMenu = driver.findElement(By.linkText("Agile Testing"));
        agileTestingSubMenu.click();
    }

    public void callGetFreeTrial() {
        WebElement getFreeTrialButton = driver.findElement(By.linkText("Get Free Trial"));
        getFreeTrialButton.click();
    }

    public void clickLearnMoreButton(String sectionName) {
        WebElement learnMoreButton = driver.findElement(By.xpath("//section[contains(text(), '" + sectionName + "')]/following-sibling::a[contains(text(), 'Learn More')]"));
        learnMoreButton.click();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        BrowserAutomation automation = new BrowserAutomation();
        automation.openNewBrowserWindow();
        automation.enterURL("http://www.qasymphony.com/platform.html");
        automation.clickAgileTestingSubMenu();
        automation.callGetFreeTrial();
        automation.clickLearnMoreButton("Scale Agile");
        automation.clickLearnMoreButton("eXplorer Testing");
        automation.clickLearnMoreButton("Distributed Team");
        automation.clickLearnMoreButton("Integration & APIs");
        automation.closeBrowser();
    }
}