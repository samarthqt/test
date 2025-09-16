package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
        driver.get("http://www.qasymphony.com");
        Assert.assertTrue(driver.getTitle().contains("QA Symphony"), "Browser did not open correctly.");
    }

    public void navigateToPartnerPage() {
        driver.navigate().to("http://www.qasymphony.com/partners.html");
        waitUntilElementVisible(btnFindPartner, 5);
        Assert.assertTrue(driver.getCurrentUrl().contains("partners"), "Navigation to partner page failed.");
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(findPartnerButton.isDisplayed(), "Find Partner button was not clicked successfully.");
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close correctly.");
    }

    private void waitUntilElementVisible(By by, long timeOutInSeconds) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}