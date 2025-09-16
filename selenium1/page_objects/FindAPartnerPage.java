package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import .util.concurrent.TimeUnit;

public class FindAPartnerPage {

    private WebDriver driver;
    private By findAPartnerButton = By.id("findPartnerButton");

    public FindAPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void navigateToURL(String url) {
        driver.get(url);
        Assert.assertTrue(driver.getCurrentUrl().equals(url), "Navigation to URL failed.");
    }

    public void clickFindAPartnerButton() {
        WebElement button = driver.findElement(findAPartnerButton);
        button.click();
        Assert.assertTrue(isFindAPartnerPageDisplayed(), "Find A Partner page is not displayed after clicking the button.");
    }

    public boolean isFindAPartnerPageDisplayed() {
        boolean isDisplayed = driver.getCurrentUrl().contains("partners");
        Assert.assertTrue(isDisplayed, "Find A Partner page is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}