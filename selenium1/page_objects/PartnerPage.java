package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PartnerPage extends WebReusableComponents {

    private By findPartnerButton = By.id("findPartnerButton");

    public PartnerPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void openBrowser() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public void navigateToPartnerPage() {
        getDriver().get("http://www.qasymphony.com/partners.html");
    }

    public void clickFindPartnerButton() {
        WebElement button = waitUntilElementVisible(findPartnerButton, 10);
        button.click();
    }

    public boolean isPartnerPageDisplayed() {
        String currentUrl = getDriver().getCurrentUrl();
        boolean isDisplayed = currentUrl.contains("partners");
        Assert.assertTrue(isDisplayed, "Partner page is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        getDriver().quit();
    }

    private WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebDriver getDriver() {
        return WebReusableComponents.getDriver();
    }
}