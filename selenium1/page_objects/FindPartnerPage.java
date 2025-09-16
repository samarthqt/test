package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By findPartnerButton = By.id("findPartnerButton");

    public FindPartnerPage() {
        this.driver = WebReusableComponents.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Maximizes the browser window.
     */
    public void openBrowser() {
        driver.manage().window().maximize();
    }

    /**
     * Navigates to the partner page and waits for the find partner button to be visible.
     */
    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        waitUntilElementVisible(findPartnerButton);
    }

    /**
     * Clicks the find partner button.
     */
    public void clickFindPartnerButton() {
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }

    /**
     * Verifies that the partner page has loaded correctly by checking the URL.
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
        driver.quit();
    }

    /**
     * Waits until the specified element is visible.
     *
     * @param locator The locator of the element to wait for.
     */
    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}