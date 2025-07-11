package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.PartnerPage;
import static org.testng.Assert.assertTrue;
import java.util.*;

public class PartnerTest {

    private PartnerPage partnerPage;

    @BeforeMethod
    public void setUp() {
        partnerPage = new PartnerPage();
        partnerPage.launchBrowser();
    }

    @Test
    public void testFindPartnerPage() {
        partnerPage.navigateToUrl("http://www.qasymphony.com/partners.html");
        partnerPage.clickFindPartnerButton();
        assertTrue(partnerPage.isFindPartnerPageDisplayed(), "Find Partner page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        partnerPage.closeBrowser();
    }
}