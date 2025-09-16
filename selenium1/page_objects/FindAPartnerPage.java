package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindAPartnerPage {

    protected By btnFindPartner = By.id("findPartnerButton");
    private static final int TIMEOUT = 10;

    public FindAPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser and maximizes the window.
     */
    public void openBrowser() {
        driver.manage().window().maximize();
    }

    /**
     * Navigates to the specified URL.
     * @param url The URL to navigate to.
     */
    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not match after navigation.");
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = waitUntilElementVisible(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), "Find Partner button is not displayed after click.");
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
     * @return The visible WebElement.
     */
    public WebElement waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}