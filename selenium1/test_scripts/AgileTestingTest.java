package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.AgileTestingPage;
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
        agileTestingPage.clickScaleAgileLearnMore();
        agileTestingPage.clickExplorerTestingLearnMore();
        agileTestingPage.clickDistributedTeamLearnMore();
        agileTestingPage.clickIntegrationAPIsLearnMore();
    }

    @AfterMethod
    public void tearDown() {
        agileTestingPage.closeBrowser();
    }
}