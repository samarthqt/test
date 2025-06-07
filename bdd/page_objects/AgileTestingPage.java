package bdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AgileTestingPage extends WebReusableComponents {

    protected By agileTestingSubMenu = By.id("agileTestingSubMenu");
    protected By platformPageIdentifier = By.id("platformPageIdentifier");
    protected By agileTestingPageIdentifier = By.id("agileTestingPageIdentifier");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Maximizes the browser window.
     */
    public void openNewBrowserWindow() {
        driver.manage().window().maximize();
    }

    /**
     * Navigates to the specified URL.
     * @param url The URL to navigate to.
     */
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    /**
     * Verifies that the platform page is displayed.
     */
    public void verifyPlatformPageDisplayed() {
        waitUntilElementVisible(platformPageIdentifier, 3);
        WebElement element = driver.findElement(platformPageIdentifier);
        Assert.assertTrue(element.isDisplayed(), "Platform page is not displayed.");
    }

    /**
     * Clicks on the specified submenu.
     * @param subMenu The submenu to click.
     */
    public void clickSubMenu(String subMenu) {
        waitUntilElementVisible(agileTestingSubMenu, 3);
        WebElement element = driver.findElement(agileTestingSubMenu);
        element.click();
    }

    /**
     * Verifies that the Agile Testing page is displayed.
     */
    public void verifyAgileTestingPageDisplayed() {
        waitUntilElementVisible(agileTestingPageIdentifier, 3);
        WebElement element = driver.findElement(agileTestingPageIdentifier);
        Assert.assertTrue(element.isDisplayed(), "Agile Testing page is not displayed.");
    }
}