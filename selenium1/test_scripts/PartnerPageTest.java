package selenium1.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium1.page_objects.PartnerPage;
import static org.testng.Assert.assertTrue;

public class PartnerPageTest {

    private WebDriver driver;
    private PartnerPage partnerPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        partnerPage = new PartnerPage(driver);
    }

    @Test
    public void testFindPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        partnerPage.clickFindPartnerButton();
        assertTrue(partnerPage.isPartnerPageDisplayed(), "Partner page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}