package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    protected By btnFindPartner = By.id("findPartnerButton");
    private static final String PARTNER_PAGE_URL = "http://www.qasymphony.com/partners.html";
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPartnerPage() {
        driver.get(PARTNER_PAGE_URL);
        Assert.assertTrue(isPartnerPageDisplayed(), "Partner page is not displayed.");
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = waitUntilElementVisible(btnFindPartner);
        findPartnerButton.click();
    }

    public boolean isPartnerPageDisplayed() {
        return driver.getCurrentUrl().contains("partners.html");
    }

    public void closeBrowser() {
        driver.quit();
    }

    private WebElement waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}