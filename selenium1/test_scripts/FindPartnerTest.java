package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.PartnerPage;
import java.util.*;

public class FindPartnerTest {
    PartnerPage partnerPage;

    @BeforeMethod
    public void setUp() {
        partnerPage = new PartnerPage();
        partnerPage.navigateToPartnerPage();
    }

    @Test
    public void testFindPartner() {
        partnerPage.clickFindPartnerButton();
        partnerPage.verifyPartnerPageOpened();
    }

    @AfterMethod
    public void tearDown() {
        partnerPage.closeBrowser();
    }
}