package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        Assert.assertTrue(isPartnerPageDisplayed(), "Failed to navigate to Partner Page.");
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = wait.until(ExpectedConditions.elementToBeClickable(btnFindPartner));
        findPartnerButton.click();
        Assert.assertTrue(isPartnerPageDisplayed(), "Partner page is not displayed after clicking Find Partner button.");
    }

    public boolean isPartnerPageDisplayed() {
        return driver.getCurrentUrl().contains("partners.html");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}