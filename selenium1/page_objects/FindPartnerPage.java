package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    /**
     * Opens the browser and maximizes the window.
     */
    public void openBrowser() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Navigates to the partner page.
     */
    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnFindPartner));
        findPartnerButton.click();
    }

    /**
     * Verifies that the partner page has loaded correctly.
     */
    public void verifyPartnerPageLoaded() {
        String expectedUrl = "http://www.qasymphony.com/partners.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Partner page did not load correctly.");
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}