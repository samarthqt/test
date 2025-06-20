package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.AgileTestingPage;
import static org.testng.Assert.assertTrue;
import java.util.*;

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
        agileTestingPage.callGetFreeTrial();
        assertTrue(agileTestingPage.clickScaleAgileLearnMore(), "Scale Agile Learn More button not clickable");
        assertTrue(agileTestingPage.clickExplorerTestingLearnMore(), "eXplorer Testing Learn More button not clickable");
        assertTrue(agileTestingPage.clickDistributedTeamLearnMore(), "Distributed Team Learn More button not clickable");
        assertTrue(agileTestingPage.clickIntegrationAPIsLearnMore(), "Integration & APIs Learn More button not clickable");
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}