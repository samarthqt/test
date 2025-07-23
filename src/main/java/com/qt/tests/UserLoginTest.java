package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pshop.pageobjs.LoginPage;
import com.framework.reusable.WebReusableComponents;

public class UserLoginTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebReusableComponents.launchUrl("https://example.com");
        loginPage = new LoginPage();
    }

    @Test
    public void testUserLoginWithValidUsername() {
        loginPage.clickLoginOption();
        loginPage.enterUserName("validUser123");
        loginPage.enterPassword("ValidPass123");
        loginPage.clickLoginButton();
        loginPage.verifyDashboardRedirection();
        loginPage.verifySessionActive();
        loginPage.verifyRememberMeFunctionality();
        loginPage.verifySecureProtocol();
        loginPage.verifyLoginAttemptLogs();
        loginPage.verifySuccessfulLoginFeedback();
        loginPage.logout();
        loginPage.verifyDashboardAccessDenied();
        loginPage.verifyAccountLockout();
        loginPage.verifyNoSecurityAlerts();
        loginPage.verifySessionTimeout();
    }

    @AfterMethod
    public void tearDown() {
        WebReusableComponents.closeBrowser();
    }
}