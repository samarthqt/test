package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingPage extends WebReusableComponents {

    private By agileTestingSubMenu = By.id("agileTestingSubMenu");

    public AgileTestingPage() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Opens the browser and maximizes the window.
     */
    public void openBrowser() {
        getDriver().manage().window().maximize();
    }

    /**
     * Navigates to the specified URL.
     * 
     * @param url The URL to navigate to.
     */
    public void enterUrl(String url) {
        getDriver().get(url);
    }

    /**
     * Clicks on the Agile Testing submenu.
     */
    public void clickAgileTestingSubMenu() {
        WebElement subMenu = getDriver().findElement(agileTestingSubMenu);
        subMenu.click();
    }

    /**
     * Verifies that the Agile Testing page is loaded by checking the page title.
     */
    public void verifyAgileTestingPageLoaded() {
        String expectedTitle = "Agile Testing - QA Symphony";
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
    }

    /**
     * Closes the browser.
     */
    public void closeBrowser() {
        getDriver().quit();
    }
}