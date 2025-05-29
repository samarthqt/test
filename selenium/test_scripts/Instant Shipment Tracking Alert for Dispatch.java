package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.AgileTestingPage;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingTest extends WebReusableComponents {
    private AgileTestingPage agileTestingPage;

    @BeforeMethod
    public void setUp() {
        agileTestingPage = new AgileTestingPage();
        agileTestingPage.navigateToAgileTestingPage();
    }

    @Test
    public void testAgileTestingPage() {
        agileTestingPage.verifyAgileTestingPageLoaded();
        agileTestingPage.clickAgileTestingSubMenu();
        String currentUrl = getCurrentURL();
        Assert.assertEquals(currentUrl, "http://www.qasymphony.com/platform.html", "URL does not match");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}