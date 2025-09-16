package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FindPartnerPage {

    private WebDriver driver;
    private By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        verifyPartnerPageLoaded();
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
    }

    public void verifyPartnerPageLoaded() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("partners.html"), "Partner page not loaded correctly");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}