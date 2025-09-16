package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerPage extends WebReusableComponents {

    private WebDriver driver;
    private final By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser using ChromeDriver.
     */
    public void openBrowser() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the specified URL.
     * @param url The URL to navigate to.
     */
    public void enterUrl(String url) {
        driver.get(url);
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
    }

    /**
     * Verifies that the page has loaded by checking the title.
     */
    public void verifyPageLoaded() {
        String expectedTitle = "Partners - QA Symphony";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
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