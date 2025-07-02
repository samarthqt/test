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

    private final By findPartnerButton = By.id("findPartnerButton");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PartnerPage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void enterURL(String url) {
        driver.get(url);
        Assert.assertTrue(driver.getCurrentUrl().contains(url), "URL did not load correctly.");
    }

    public void clickFindPartnerButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(findPartnerButton));
        button.click();
        Assert.assertTrue(isPartnerPageDisplayed(), "Partner page is not displayed after clicking the button.");
    }

    public boolean isPartnerPageDisplayed() {
        return driver.getCurrentUrl().contains("partners");
    }

    public void closeBrowser() {
        driver.quit();
    }
}