package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By findPartnerButton = By.id("findPartnerButton");
    private final By partnerList = By.id("partnerList");

    public PartnerPage() {
        this.driver = WebDriverInstance.getDriver(); // Assume WebDriverInstance is a utility class providing WebDriver instance
        this.wait = new WebDriverWait(driver, 10);
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
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.qasymphony.com/partners.html", "Navigation to partner page failed.");
    }

    /**
     * Clicks the 'Find Partner' button.
     */
    public void clickFindPartnerButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(findPartnerButton));
        button.click();
    }

    /**
     * Checks if the partner list is displayed.
     * @return true if the partner list is displayed, false otherwise.
     */
    public boolean isPartnerListDisplayed() {
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(partnerList));
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
}