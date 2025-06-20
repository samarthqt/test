package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    protected By btnFindPartner = By.id("findPartnerButton");
    private WebDriver driver;
    private WebDriverWait wait;

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver = new WebDriver(); // Replace with actual WebDriver initialization
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        verifyPartnerPageLoaded();
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnFindPartner));
        findPartnerButton.click();
    }

    public void verifyPartnerPageLoaded() {
        String expectedUrl = "http://www.qasymphony.com/partners.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Partner page did not load correctly.");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}