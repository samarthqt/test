package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerPage extends WebReusableComponents {

    private WebDriver driver;
    private final By findPartnerButton = By.id("findPartnerButton");

    public FindPartnerPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the browser and initializes the WebDriver.
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
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
    }

    /**
     * Checks if the partner page is displayed.
     * 
     * @return true if the partner page URL is correct, false otherwise.
     */
    public boolean isPartnerPageDisplayed() {
        return driver.getCurrentUrl().contains("partners.html");
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