package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.AgileTestingPage;
import static org.testng.Assert.assertTrue;

public class AgileTestingTest {

    private AgileTestingPage agileTestingPage;

    @BeforeMethod
    public void setUp() {
        agileTestingPage = new AgileTestingPage();
        agileTestingPage.openBrowser();
    }

    @Test
    public void testAgileTestingPage() {
        agileTestingPage.enterURL("http://www.qasymphony.com/platform.html");
        agileTestingPage.clickAgileTestingSubMenu();
        assertTrue(agileTestingPage.isAgileTestingPageDisplayed(), "Agile Testing page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}