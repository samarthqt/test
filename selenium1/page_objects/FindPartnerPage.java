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
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Opens the browser and initializes the WebDriver.
     */
    public void openBrowser() {
        // Logic to initialize WebDriver and open browser
        // Example: driver = new ChromeDriver();
    }

    /**
     * Navigates to the partner page.
     */
    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        verifyPartnerPageLoaded();
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = waitUntilElementVisible(btnFindPartner);
        findPartnerButton.click();
    }

    /**
     * Verifies that the partner page has loaded correctly.
     */
    public void verifyPartnerPageLoaded() {
        String expectedURL = "http://www.qasymphony.com/partners.html";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, "Partner page did not load correctly.");
    }

    /**
     * Closes the browser and quits the WebDriver.
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Waits until the specified element is visible.
     *
     * @param locator The locator of the element to wait for.
     * @return The visible WebElement.
     */
    public WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}