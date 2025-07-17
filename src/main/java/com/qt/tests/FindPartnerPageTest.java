package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pshop.pageobjs.PartnerPage;
import static org.testng.Assert.assertTrue;
import java.util.*;

public class FindPartnerPageTest {

    private PartnerPage partnerPage;

    @BeforeMethod
    public void setUp() {
        partnerPage = new PartnerPage();
        partnerPage.openBrowser();
    }

    @Test
    public void testFindPartnerPage() {
        partnerPage.enterUrl("http://www.qasymphony.com/partners.html");
        partnerPage.clickFindPartnerButton();
        assertTrue(partnerPage.isPartnerPageDisplayed(), "Partner page is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        partnerPage.closeBrowser();
    }
}