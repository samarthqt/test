package com.qt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qt.pshop.pageobjs.FindPartnerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertTrue;

public class FindPartnerTest {

    private WebDriver driver;
    private FindPartnerPage findPartnerPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        findPartnerPage = new FindPartnerPage(driver);
    }

    @Test
    public void testFindPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        findPartnerPage.clickFindPartnerButton();
        assertTrue(findPartnerPage.isPartnerPageDisplayed(), "Partner page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}