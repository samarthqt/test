
package page_objects;

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

    private final By btnFindPartner = By.id("findPartnerButton");

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens a new browser window and verifies the action.
     */
    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.WINDOW);
        Assert.assertTrue(driver.getWindowHandles().size() > 1, "New browser window did not open.");
    }

    /**
     * Navigates to the Partner Page URL and verifies the navigation.
     */
    public void enterPartnerPageUrl() {
        String url = "http://www.qasymphony.com/partners.html";
        driver.navigate().to(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "Failed to navigate to the Partner Page URL.");
    }

    /**
     * Clicks the 'Find Partner' button and verifies the button is clicked.
     */
    public void clickFindPartnerButton() {
        WebElement findPartnerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnFindPartner));
        findPartnerButton.click();
        Assert.assertTrue(ExpectedConditions.stalenessOf(findPartnerButton).apply(driver), "Find Partner button was not clicked.");
    }
}
