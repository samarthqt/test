package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By findPartnerButton = By.id("findPartnerButton");

    public FindPartnerPage() {
        this.driver = WebDriverInstance.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void enterUrl(final String url) {
        driver.get(url);
    }

    public void clickFindPartnerButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(findPartnerButton));
        button.click();
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

class WebDriverInstance {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize the WebDriver instance here, e.g., new ChromeDriver();
            driver = new ChromeDriver();
        }
        return driver;
    }
}