package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.FindPartnerPage;
import com.framework.reusable.WebReusableComponents;

public class FindPartnerTest extends WebReusableComponents {

    private FindPartnerPage findPartnerPage;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        findPartnerPage = new FindPartnerPage();
    }

    @Test
    public void testFindPartnerPage() {
        findPartnerPage.navigateToFindPartnerPage();
        findPartnerPage.clickFindPartnerButton();
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}