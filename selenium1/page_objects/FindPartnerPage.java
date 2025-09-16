package selenium1.page_objects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FindPartnerPage extends WebReusableComponents {

    private WebDriver driver;
    private final By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser and initializes the WebDriver.
     */
    public void openBrowser() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
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
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
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
     * Closes the browser and quits the WebDriver.
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}