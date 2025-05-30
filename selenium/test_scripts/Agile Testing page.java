package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QASymphonyAutomation {

    private WebDriver driver;

    public QASymphonyAutomation() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void openBrowserWindow() {
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

    public void clickLearnMoreScaleAgile() {
        WebElement learnMoreScaleAgile = driver.findElement(By.linkText("Learn More"));
        learnMoreScaleAgile.click();
    }

    public void clickLearnMoreExplorerTesting() {
        WebElement learnMoreExplorerTesting = driver.findElement(By.linkText("Learn More"));
        learnMoreExplorerTesting.click();
    }

    public void clickLearnMoreDistributedTeam() {
        WebElement learnMoreDistributedTeam = driver.findElement(By.linkText("Learn More"));
        learnMoreDistributedTeam.click();
    }

    public void clickLearnMoreIntegrationAPIs() {
        WebElement learnMoreIntegrationAPIs = driver.findElement(By.linkText("Learn More"));
        learnMoreIntegrationAPIs.click();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        QASymphonyAutomation automation = new QASymphonyAutomation();
        automation.openBrowserWindow();
        automation.enterURL("http://www.qasymphony.com/platform.html");
        automation.clickAgileTestingSubMenu();
        automation.callGetFreeTrial();
        automation.clickLearnMoreScaleAgile();
        automation.clickLearnMoreExplorerTesting();
        automation.clickLearnMoreDistributedTeam();
        automation.clickLearnMoreIntegrationAPIs();
        automation.closeBrowser();
    }
}