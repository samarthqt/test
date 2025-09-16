package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    /**
     * Opens the browser and initializes the WebDriver.
     */
    public void openBrowser() {
        // Logic to initialize WebDriver and open browser
        // Example: driver = new ChromeDriver();
        // driver.manage().window().maximize();
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
        WebElement findPartnerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnFindPartner));
        findPartnerButton.click();
    }

    /**
     * Verifies that the partner page is loaded correctly.
     */
    public void verifyPartnerPageLoaded() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "http://www.qasymphony.com/partners.html", "Partner page did not load correctly.");
    }

    /**
     * Closes the browser and quits the WebDriver.
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}