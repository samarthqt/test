package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FindPartnerPage {

    private WebDriver driver;
    private final By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        if (driver == null) {
            driver = new ChromeDriver();
            PageFactory.initElements(driver, this);
        }
    }

    public void enterUrl(final String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not load correctly");
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), "Find Partner button was not clicked successfully");
    }

    public void verifyPageLoaded() {
        final String expectedTitle = "Partners - QASymphony";
        final String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}