package com.cucumber.test_scripts;

import com.page_objects.CartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ModifyProductQuantityTest {

    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        cartPage = new CartPage();
        cartPage.openCart();
    }

    @Test
    public void testModifyProductQuantity() {
        cartPage.locateProductInCart("101");
        cartPage.modifyProductQuantity("101", "5");
        assertEquals(cartPage.getProductQuantity("101"), "5", "Product quantity not updated correctly.");
        assertTrue(cartPage.verifySubtotalCalculation("101", 5), "Subtotal calculation is incorrect.");
        assertTrue(cartPage.verifyQuantityModificationNotification(), "No notification for quantity modification.");
        assertTrue(cartPage.verifyInventoryIntegration("101", 5), "Inventory not updated correctly.");
        assertTrue(cartPage.verifyLoggingOfAction("101", 5), "Action not logged correctly.");
        assertTrue(cartPage.verifyMobileInterface(), "Mobile interface is not responsive.");
        assertTrue(cartPage.verifySecurityMeasures(), "Security measures are not adequate.");
        cartPage.logOutAndLogIn();
        assertEquals(cartPage.getProductQuantity("101"), "5", "Quantity not persistent after re-login.");
        assertTrue(cartPage.attemptSetQuantityBeyondStock("101"), "No error for insufficient stock.");
        assertTrue(cartPage.attemptSetQuantityToZero("101"), "No prompt to remove product when quantity set to zero.");
    }

    @AfterMethod
    public void tearDown() {
        cartPage = null;
    }
}