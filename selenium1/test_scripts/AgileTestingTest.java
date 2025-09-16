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
        agileTestingPage.navigateToPlatformPage();
        agileTestingPage.clickAgileTestingSubMenu();
        agileTestingPage.clickGetFreeTrial();
        assertTrue(agileTestingPage.isScaleAgileSectionVisible());
        agileTestingPage.clickScaleAgileLearnMore();
        assertTrue(agileTestingPage.isExplorerTestingSectionVisible());
        agileTestingPage.clickExplorerTestingLearnMore();
        assertTrue(agileTestingPage.isDistributedTeamSectionVisible());
        agileTestingPage.clickDistributedTeamLearnMore();
        assertTrue(agileTestingPage.isIntegrationAPIsSectionVisible());
        agileTestingPage.clickIntegrationAPIsLearnMore();
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}