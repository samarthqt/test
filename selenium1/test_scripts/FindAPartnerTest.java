package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.FindAPartnerPage;
import java.util.*;

public class FindAPartnerTest {

    private FindAPartnerPage findAPartnerPage;

    @BeforeMethod
    public void setUp() {
        findAPartnerPage = new FindAPartnerPage();
        findAPartnerPage.openBrowser();
    }

    @Test
    public void testFindAPartnerPage() {
        findAPartnerPage.enterUrl("http://www.qasymphony.com/partners.html");
        findAPartnerPage.clickFindPartnerButton();
    }

    @AfterMethod
    public void tearDown() {
        findAPartnerPage.closeBrowser();
    }
}