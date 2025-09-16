package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgileTestingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By agileTestingSubMenu = By.linkText("Agile Testing");

    public AgileTestingPage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void enterURL(final String url) {
        driver.get(url);
        Assert.assertTrue(driver.getCurrentUrl().equals(url), "URL did not load correctly.");
    }

    public void clickAgileTestingSubMenu() {
        waitUntilElementVisible(agileTestingSubMenu);
        WebElement subMenu = driver.findElement(agileTestingSubMenu);
        subMenu.click();
    }

    public boolean isAgileTestingPageDisplayed() {
        String title = driver.getTitle();
        boolean isDisplayed = title.contains("Agile Testing");
        Assert.assertTrue(isDisplayed, "Agile Testing page is not displayed.");
        return isDisplayed;
    }

    public void closeBrowser() {
        driver.quit();
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}