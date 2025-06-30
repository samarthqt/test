package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        agileTestingPage.enterUrl("http://www.qasymphony.com/platform.html");
        agileTestingPage.clickAgileTestingSubMenu();
        agileTestingPage.clickGetFreeTrial();
        assertTrue(agileTestingPage.clickScaleAgileLearnMore(), "Scale Agile Learn More button not working");
        assertTrue(agileTestingPage.clickExplorerTestingLearnMore(), "eXplorer Testing Learn More button not working");
        assertTrue(agileTestingPage.clickDistributedTeamLearnMore(), "Distributed Team Learn More button not working");
        assertTrue(agileTestingPage.clickIntegrationApisLearnMore(), "Integration & APIs Learn More button not working");
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}