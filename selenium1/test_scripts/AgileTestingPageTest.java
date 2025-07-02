package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.AgileTestingPage;
import static org.testng.Assert.assertTrue;

public class AgileTestingPageTest {

    private AgileTestingPage agileTestingPage;

    @BeforeMethod
    public void setUp() {
        agileTestingPage = new AgileTestingPage();
        agileTestingPage.openBrowser();
    }

    @Test
    public void testAgileTestingPage() {
        agileTestingPage.enterUrl("http://www.qasymphony.com/platform.html");
        agileTestingPage.clickAgileTestingSubMenu();
        agileTestingPage.callGetFreeTrial();
        assertTrue(agileTestingPage.clickScaleAgileLearnMore(), "Scale Agile Learn More not clickable");
        assertTrue(agileTestingPage.clickExplorerTestingLearnMore(), "Explorer Testing Learn More not clickable");
        assertTrue(agileTestingPage.clickDistributedTeamLearnMore(), "Distributed Team Learn More not clickable");
        assertTrue(agileTestingPage.clickIntegrationApisLearnMore(), "Integration & APIs Learn More not clickable");
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}