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
        assertTrue(agileTestingPage.isScaleAgileSectionVisible(), "Scale Agile section is not visible");
        agileTestingPage.clickLearnMoreScaleAgile();
        assertTrue(agileTestingPage.isExplorerTestingSectionVisible(), "eXplorer Testing section is not visible");
        agileTestingPage.clickLearnMoreExplorerTesting();
        assertTrue(agileTestingPage.isDistributedTeamSectionVisible(), "Distributed Team section is not visible");
        agileTestingPage.clickLearnMoreDistributedTeam();
        assertTrue(agileTestingPage.isIntegrationAPIsSectionVisible(), "Integration & APIs section is not visible");
        agileTestingPage.clickLearnMoreIntegrationAPIs();
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}