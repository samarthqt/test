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
        agileTestingPage.clickLearnMoreScaleAgile();
        agileTestingPage.clickLearnMoreExplorerTesting();
        agileTestingPage.clickLearnMoreDistributedTeam();
        agileTestingPage.clickLearnMoreIntegrationAPIs();
        assertTrue(agileTestingPage.isAgileTestingPageLoaded(), "Agile Testing page did not load correctly.");
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}