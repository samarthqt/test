package bdd3.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerPage extends WebReusableComponents {

    private final By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        driver.manage().window().maximize();
        Assert.assertTrue(driver.manage().window().getSize().getWidth() > 0, "Browser window did not maximize successfully.");
    }

    public void enterURL(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL did not load correctly.");
    }

    public void clickFindPartnerButton() {
        waitUntilElementVisible(btnFindPartner, 3);
        clickElement(btnFindPartner);
        Assert.assertTrue(isElementPresent(btnFindPartner), "Find Partner button was not clicked successfully.");
    }

    private void waitUntilElementVisible(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}