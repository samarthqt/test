package com.qt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qt.pshop.pageobjs.AgileTestingPage;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingTest extends WebReusableComponents {

    private AgileTestingPage agileTestingPage;

    @BeforeMethod
    public void setUp() {
        launchBrowser();
        agileTestingPage = new AgileTestingPage();
    }

    @Test
    public void testAgileTestingPage() {
        agileTestingPage.navigateToAgileTestingPage();
        agileTestingPage.clickAgileTestingSubMenu();
        agileTestingPage.callGetFreeTrial();
        agileTestingPage.clickScaleAgileLearnMore();
        agileTestingPage.clickExplorerTestingLearnMore();
        agileTestingPage.clickDistributedTeamLearnMore();
        agileTestingPage.clickIntegrationAPIsLearnMore();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}