package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PlatformPage;

public class AgileTestingTest {
    private WebDriver driver;
    private PlatformPage platformPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        platformPage = new PlatformPage(driver);
    }

    @Test
    public void testAgileTestingPage() {
        driver.get("http://www.qasymphony.com/platform.html");
        platformPage.clickAgileTestingSubMenu();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}