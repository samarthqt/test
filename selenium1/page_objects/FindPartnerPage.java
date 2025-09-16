package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerPage extends WebReusableComponents {

    protected By btnFindPartner = By.id("findPartnerButton");
    protected By partnerPageHeader = By.tagName("h1");

    public FindPartnerPage() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Opens the browser and initializes the WebDriver.
     */
    public void openBrowser() {
        initializeDriver();
        maximizeWindow();
    }

    /**
     * Navigates to the partner page and waits for the Find Partner button to be visible.
     */
    public void navigateToPartnerPage() {
        getDriver().get("http://www.qasymphony.com/partners.html");
        waitUntilElementVisible(btnFindPartner, 10);
    }

    /**
     * Clicks the Find Partner button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = getDriver().findElement(btnFindPartner);
        findPartnerButton.click();
    }

    /**
     * Verifies that the partner page is loaded by checking the presence of the page header.
     */
    public void verifyPartnerPageLoaded() {
        WebElement header = getDriver().findElement(partnerPageHeader);
        Assert.assertTrue(header.isDisplayed(), "Partner page header is not displayed.");
    }

    /**
     * Closes the browser and quits the WebDriver.
     */
    public void closeBrowser() {
        getDriver().quit();
    }

    /**
     * Waits until the specified element is visible.
     *
     * @param locator The locator of the element to wait for.
     * @param timeout The timeout in seconds.
     */
    public void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Initializes the WebDriver.
     */
    public void initializeDriver() {
        // Logic to initialize WebDriver
    }

    /**
     * Maximizes the browser window.
     */
    public void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    /**
     * Retrieves the current WebDriver instance.
     *
     * @return The WebDriver instance.
     */
    public WebDriver getDriver() {
        // Logic to retrieve WebDriver instance
        return driver;
    }
}