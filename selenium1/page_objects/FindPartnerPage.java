package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerPage extends WebReusableComponents {

    private By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver = new ChromeDriver();
        Assert.assertNotNull(driver, "Driver initialization failed.");
    }

    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        Assert.assertTrue(driver.getCurrentUrl().contains("partners.html"), "Navigation to partner page failed.");
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), "Find Partner button is not displayed.");
    }

    public void verifyPartnerPageLoaded() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("partners.html"), "Partner page not loaded correctly.");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            Assert.assertNull(driver, "Browser did not close properly.");
        }
    }
}