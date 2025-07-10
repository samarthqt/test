package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindPartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By findPartnerButton = By.id("findPartnerButton");

    public FindPartnerPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
        Assert.assertTrue(driver.manage().window().getSize().getWidth() > 0, "Browser did not open correctly.");
    }

    public void enterUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not load correctly.");
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(findPartnerButton);
        WebElement button = driver.findElement(findPartnerButton);
        button.click();
        Assert.assertTrue(button.isDisplayed(), "Find Partner button was not clicked successfully.");
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close correctly.");
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}