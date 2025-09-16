package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FindPartnerPage {

    private WebDriver driver;
    private By btnFindPartner = By.id("findPartnerButton");

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
     * Navigates to the Find Partner page.
     */
    public void navigateToFindPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        Assert.assertTrue(isPartnerPageDisplayed(), "Failed to navigate to the Find Partner page.");
    }

    /**
     * Clicks the Find Partner button.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(isPartnerPageDisplayed(), "Find Partner button click did not lead to the expected page.");
    }

    /**
     * Checks if the Partner page is displayed.
     * @return true if the current URL contains "partners.html", false otherwise.
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