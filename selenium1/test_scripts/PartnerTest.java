package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.PartnerPage;
import static org.testng.Assert.assertTrue;

public class PartnerTest {

    private PartnerPage partnerPage;

    @BeforeMethod
    public void setUp() {
        partnerPage = new PartnerPage();
        partnerPage.openBrowser();
    }

    @Test
    public void testFindPartner() {
        partnerPage.navigateToPartnerPage();
        partnerPage.clickFindPartnerButton();
        assertTrue(partnerPage.isPartnerPageDisplayed(), "Partner page is not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        partnerPage.closeBrowser();
    }
}