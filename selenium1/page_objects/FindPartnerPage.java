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
    protected WebDriver driver;
    protected WebDriverWait wait;

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser and maximizes the window.
     */
    public void openBrowser() {
        driver.manage().window().maximize();
    }

    /**
     * Navigates to the partner page.
     */
    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        Assert.assertTrue(isPartnerPageDisplayed(), "Failed to navigate to the partner page.");
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = waitUntilElementVisible(btnFindPartner, 3);
        findPartnerButton.click();
    }

    /**
     * Checks if the partner page is displayed.
     * @return true if the partner page URL is correct, false otherwise.
     */
    public boolean isPartnerPageDisplayed() {
        return driver.getCurrentUrl().contains("partners.html");
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * Waits until the specified element is visible.
     * @param locator The locator of the element to wait for.
     * @param timeout The timeout in seconds.
     * @return The visible WebElement.
     */
    public WebElement waitUntilElementVisible(By locator, int timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}