package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = wait.until(ExpectedConditions.elementToBeClickable(btnFindPartner));
        findPartnerButton.click();
    }

    public boolean isPartnerPageDisplayed() {
        String currentUrl = driver.getCurrentUrl();
        boolean isDisplayed = currentUrl.contains("partners.html");
        Assert.assertTrue(isDisplayed, "Partner page is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }
}