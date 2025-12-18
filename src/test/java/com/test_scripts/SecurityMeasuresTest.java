package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.SecurityPage;
import com.framework.reusable.WebReusableComponents;
import org.testng.Assert;

public class SecurityMeasuresTest extends WebReusableComponents {

    private SecurityPage securityPage;

    @BeforeMethod
    public void setUp() {
        launchUrl(getAppUrl());
        maximizeWindow();
        securityPage = new SecurityPage();
    }

    @Test
    public void testAccessDeniedForCreditCardDetails() {
        boolean accessDenied = securityPage.isAccessDeniedForCreditCardDetails();
        Assert.assertTrue(accessDenied, "Access to credit card details should be denied.");
    }

    @Test
    public void testNoSensitiveInfoInNetworkLogs() {
        boolean noSensitiveInfo = securityPage.checkNetworkLogsForSensitiveInfo();
        Assert.assertTrue(noSensitiveInfo, "No sensitive information should be exposed in network logs.");
    }

    @Test
    public void testExportUserInfoBlocked() {
        boolean exportBlocked = securityPage.isExportBlocked();
        Assert.assertTrue(exportBlocked, "Export action should be blocked with an error message.");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}