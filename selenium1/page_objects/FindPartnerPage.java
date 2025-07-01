package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FindPartnerPage {

    private By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        PageFactory.initElements(new ChromeDriver(), this);
    }

    /**
     * Opens the browser using ChromeDriver.
     */
    public void openBrowser() {
        WebDriver driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the partner page.
     */
    public void navigateToPartnerPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qasymphony.com/partners.html");
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebDriver driver = new ChromeDriver();
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
    }

    /**
     * Verifies that the partner page is loaded correctly.
     */
    public void verifyPartnerPageLoaded() {
        WebDriver driver = new ChromeDriver();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("partners.html"), "Partner page not loaded correctly.");
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}