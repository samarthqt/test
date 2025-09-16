package selenium.page_objects;

import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By findPartnerButton = By.id("findPartnerButton");

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.switchTo().newWindow(WebDriver.WindowType.WINDOW);
        Assert.assertNotNull(driver.getWindowHandle(), "Failed to open a new browser window.");
    }

    public void enterPartnerPageUrl() {
        driver.navigate().to("http://www.qasymphony.com/partners.html");
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.qasymphony.com/partners.html", "URL does not match the expected Partner Page URL.");
    }

    public void clickFindPartnerButton() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(findPartnerButton));
        button.click();
        Assert.assertTrue(button.isDisplayed(), "Find Partner button is not visible after clicking.");
    }
}