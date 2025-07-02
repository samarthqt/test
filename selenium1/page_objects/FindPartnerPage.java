package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage extends WebReusableComponents {

    private final By btnFindPartner = By.id("findPartnerButton");
    private final String partnerPageUrl = "http://www.qasymphony.com/partners.html";

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPartnerPage() {
        driver.get(partnerPageUrl);
        Assert.assertTrue(isPartnerPageDisplayed(), "Failed to navigate to Partner Page.");
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = waitUntilElementVisible(btnFindPartner, 3);
        findPartnerButton.click();
    }

    public boolean isPartnerPageDisplayed() {
        return driver.getCurrentUrl().contains("partners.html");
    }

    public void closeBrowser() {
        driver.quit();
    }

    public WebElement waitUntilElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}