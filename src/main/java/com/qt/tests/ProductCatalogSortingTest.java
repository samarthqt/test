package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pshop.pageobjs.ProductCatalogPage;
import static org.testng.Assert.assertTrue;

public class ProductCatalogSortingTest {

    private ProductCatalogPage productCatalogPage;

    @BeforeMethod
    public void setUp() {
        productCatalogPage = new ProductCatalogPage();
        productCatalogPage.navigateToMainMenu();
    }

    @Test
    public void testProductSortingByPrice() {
        productCatalogPage.selectProductCatalog();
        assertTrue(productCatalogPage.isSortingOptionsVisible(), "Sorting options are not visible.");

        productCatalogPage.sortByPriceAscending();
        assertTrue(productCatalogPage.verifyPricesAscending(), "Prices are not sorted in ascending order.");

        productCatalogPage.sortByPriceDescending();
        assertTrue(productCatalogPage.verifyPricesDescending(), "Prices are not sorted in descending order.");

        assertTrue(productCatalogPage.isSortingResponsive(), "Sorting is not responsive.");
        assertTrue(productCatalogPage.isPerformanceOptimal(), "Performance issues detected during sorting.");

        productCatalogPage.navigateAwayAndBack();
        assertTrue(productCatalogPage.isSortingOptionPersisted(), "Sorting option did not persist.");

        assertTrue(productCatalogPage.isNoSortingErrors(), "Sorting errors detected.");
        assertTrue(productCatalogPage.isSortingAvailableOnAllDevices(), "Sorting options are not accessible on all devices.");

        productCatalogPage.testSortingWithLargeDataset();
        assertTrue(productCatalogPage.isSortingEfficientWithLargeDataset(), "Sorting is not efficient with large datasets.");

        assertTrue(productCatalogPage.isUIFeedbackCorrect(), "UI feedback is incorrect when sorting is applied.");

        productCatalogPage.testSortingWithDifferentFilters();
        assertTrue(productCatalogPage.isSortingConsistentAcrossFilters(), "Sorting is not consistent across different filters.");
    }

    @AfterMethod
    public void tearDown() {
        productCatalogPage.closeBrowser();
    }
}