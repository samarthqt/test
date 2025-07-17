package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pshop.pageobjs.PartnerPage;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartnerPageTest {

    private WebDriver driver;
    private PartnerPage partnerPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        partnerPage = new PartnerPage();
    }

    @Test
    public void testFindPartnerPage() {
        driver.get("http://www.qasymphony.com/partners.html");
        partnerPage.clickFindPartnerButton();
        assertTrue(partnerPage.isPartnerPageDisplayed(), "Partner page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}