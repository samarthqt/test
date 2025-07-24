package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pshop.pageobjs.FindPartnerPage;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerTest {

    private WebReusableComponents webComponents;
    private FindPartnerPage findPartnerPage;

    @BeforeMethod
    public void setUp() {
        webComponents = new WebReusableComponents();
        findPartnerPage = new FindPartnerPage();
        webComponents.launchUrl("http://www.qasymphony.com/partners.html");
    }

    @Test
    public void testFindPartnerPage() {
        findPartnerPage.clickFindPartnerButton();
        findPartnerPage.verifyPartnerPageLoaded();
    }

    @AfterMethod
    public void tearDown() {
        webComponents.quitDriver();
    }
}