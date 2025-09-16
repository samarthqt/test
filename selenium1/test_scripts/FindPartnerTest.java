package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.FindPartnerPage;
import java.util.*;

public class FindPartnerTest {

    private FindPartnerPage findPartnerPage;

    @BeforeMethod
    public void setUp() {
        findPartnerPage = new FindPartnerPage();
        findPartnerPage.openBrowser();
    }

    @Test
    public void testFindPartner() {
        findPartnerPage.navigateToPartnerPage();
        findPartnerPage.clickFindPartnerButton();
    }

    @AfterMethod
    public void tearDown() {
        findPartnerPage.closeBrowser();
    }
}