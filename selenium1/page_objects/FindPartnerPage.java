package selenium1.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerPage extends WebReusableComponents {

    private WebDriver driver;
    private final By btnFindPartner = By.id("findPartnerButton");

    public FindPartnerPage() {
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void openBrowser() {
        driver.manage().window().maximize();
    }

    public void navigateToPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        Assert.assertTrue(driver.getCurrentUrl().contains("partners.html"), "Failed to navigate to Partner page.");
    }

    public void clickFindPartnerButton() {
        WebElement findPartnerButton = driver.findElement(btnFindPartner);
        findPartnerButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("find-partner"), "Find Partner button did not redirect correctly.");
    }

    public void verifyPartnerPageLoaded() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("partners.html"), "Partner page not loaded correctly.");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}