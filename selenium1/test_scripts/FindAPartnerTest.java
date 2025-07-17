package selenium1.test_scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import selenium1.page_objects.FindAPartnerPage;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class FindAPartnerTest {

    private WebDriver driver;
    private FindAPartnerPage findAPartnerPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        findAPartnerPage = new FindAPartnerPage();
    }

    @Test
    public void testFindAPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        findAPartnerPage.clickFindPartnerButton();
        assertTrue(findAPartnerPage.isPartnerPageDisplayed(), "Partner page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}