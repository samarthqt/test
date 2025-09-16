package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QASymphonyPage {

    private WebDriver driver;

    public QASymphonyPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void enterUrl(String url) {
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
}

package com.cucumber.steps;

import com.pageobjects.QASymphonyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class QASymphonySteps {

    private QASymphonyPage qaSymphonyPage = new QASymphonyPage();

    @Given("Opening new browser window")
    public void openingNewBrowserWindow() {
        qaSymphonyPage.openBrowser();
    }

    @When("Enter {string} URL")
    public void enterUrl(String url) {
        qaSymphonyPage.enterUrl(url);
    }

    @When("Click on the {string} sub-menu")
    public void clickOnSubMenu(String subMenu) {
        if (subMenu.equals("Agile Testing")) {
            qaSymphonyPage.clickAgileTestingSubMenu();
        }
    }

    @When("Call Get Free Trial")
    public void callGetFreeTrial() {
        qaSymphonyPage.callGetFreeTrial();
    }

    @When("Click on the content or Learn More button of Scale Agile section")
    public void clickLearnMoreScaleAgile() {
        qaSymphonyPage.clickLearnMoreScaleAgile();
    }

    @When("Click on the content or Learn More button of eXplorer Testing section")
    public void clickLearnMoreExplorerTesting() {
        qaSymphonyPage.clickLearnMoreExplorerTesting();
    }

    @When("Click on the content or Learn More button of Distributed Team section")
    public void clickLearnMoreDistributedTeam() {
        qaSymphonyPage.clickLearnMoreDistributedTeam();
    }

    @When("Click on the content or Learn More button of Integration & APIs section")
    public void clickLearnMoreIntegrationAPIs() {
        qaSymphonyPage.clickLearnMoreIntegrationAPIs();
    }
}