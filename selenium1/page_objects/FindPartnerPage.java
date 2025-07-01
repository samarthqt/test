package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage extends WebReusableComponents {

    private final By btnFindPartner = By.id("findPartnerButton");
    private final By partnerList = By.id("partnerList");

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
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement button = waitUntilElementVisible(btnFindPartner, 5);
        button.click();
    }

    /**
     * Checks if the partner list is displayed.
     * 
     * @return true if the partner list is displayed, false otherwise.
     */
    public boolean isPartnerListDisplayed() {
        WebElement list = waitUntilElementVisible(partnerList, 5);
        boolean isDisplayed = list.isDisplayed();
        Assert.assertTrue(isDisplayed, "Partner list is not displayed.");
        return isDisplayed;
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * Waits until the specified element is visible.
     * 
     * @param locator the locator of the element to wait for.
     * @param timeout the timeout in seconds.
     * @return the visible WebElement.
     */
    public WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}