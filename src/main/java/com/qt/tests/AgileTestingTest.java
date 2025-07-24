package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pshop.pageobjs.AgileTestingPage;
import com.framework.reusable.WebReusableComponents;

public class AgileTestingTest {

    private AgileTestingPage agileTestingPage;

    @BeforeMethod
    public void setUp() {
        agileTestingPage = new AgileTestingPage();
        agileTestingPage.launchUrl("http://www.qasymphony.com/platform.html");
    }

    @Test
    public void testAgileTestingPage() {
        agileTestingPage.clickAgileTestingSubMenu();
        agileTestingPage.callGetFreeTrial();
        agileTestingPage.clickScaleAgileLearnMore();
        agileTestingPage.clickExplorerTestingLearnMore();
        agileTestingPage.clickDistributedTeamLearnMore();
        agileTestingPage.clickIntegrationAPIsLearnMore();
    }

    @AfterMethod
    public void tearDown() {
        WebReusableComponents.quitDriver();
    }
}