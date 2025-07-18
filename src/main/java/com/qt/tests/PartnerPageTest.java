package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pshop.pageobjs.PartnerPage;
import com.framework.reusable.WebReusableComponents;
import static org.testng.Assert.assertTrue;

public class PartnerPageTest extends WebReusableComponents {

    private PartnerPage partnerPage;

    @BeforeMethod
    public void setUp() {
        partnerPage = new PartnerPage();
        launchUrl("http://www.qasymphony.com/partners.html");
    }

    @Test
    public void testFindPartnerButton() {
        partnerPage.clickFindPartnerButton();
        assertTrue(partnerPage.isPartnerPageDisplayed(), "Partner page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}