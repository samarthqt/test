package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.CartPage;
import com.framework.reusable.WebReusableComponents;
import org.testng.Assert;

public class RemoveProductFromCartTest extends WebReusableComponents {

    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        cartPage = new CartPage();
        navigateToPage("/cart");
    }

    @Test
    public void testRemoveProductFromCart() {
        cartPage.selectProductById("101");
        cartPage.removeProductFromCart();
        Assert.assertFalse(cartPage.isProductInCart("101"), "Product is still in the cart.");
        Assert.assertTrue(cartPage.isSubtotalUpdated(), "Subtotal is not updated correctly.");
        Assert.assertTrue(cartPage.isRemovalNotificationDisplayed(), "Removal notification not displayed.");
        Assert.assertTrue(cartPage.isActionLogged(), "Action not logged.");
        Assert.assertTrue(cartPage.isCartResponsiveOnMobile(), "Cart is not responsive on mobile.");
        Assert.assertTrue(cartPage.isCartAccessSecure(), "Cart access is not secure.");
        logOut();
        logIn();
        Assert.assertFalse(cartPage.isProductInCart("101"), "Product reappeared in the cart after re-login.");
        Assert.assertTrue(cartPage.isInventoryUpdated("101"), "Inventory not updated correctly.");
        Assert.assertTrue(cartPage.attemptToRemoveNonExistentProduct(), "No error message for non-existent product.");
    }

    @AfterMethod
    public void tearDown() {
        // Clean up actions if necessary
    }
}