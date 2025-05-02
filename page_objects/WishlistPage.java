package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class WishlistPage extends WebReusableComponents {

    protected By addToWishlistButton = By.id("addToWishlist");
    protected By wishlistLink = By.id("wishlistLink");
    protected By wishlistItems = By.cssSelector(".wishlist-item");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By loginPrompt = By.id("loginPrompt");

    protected By removeWishlistItem(String productName) {
        return By.xpath("//div[@class='wishlist-item' and contains(text(), '" + productName + "')]/following-sibling::button[@class='remove']");
    }

    public void addProductToWishlist() {
        waitUntilElementVisible(addToWishlistButton, 3);
        clickElement(addToWishlistButton);
    }

    public void navigateToWishlist() {
        waitUntilElementVisible(wishlistLink, 3);
        clickElement(wishlistLink);
    }

    public boolean isWishlistNotEmpty() {
        waitUntilElementVisible(wishlistItems, 3);
        List<WebElement> items = getWebElementList(wishlistItems);
        return !items.isEmpty();
    }

    public void verifyWishlistContainsItems() {
        Assert.assertTrue(isWishlistNotEmpty(), "Wishlist is empty.");
    }

    public void removeProductFromWishlist(String productName) {
        By removeButton = removeWishlistItem(productName);
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyProductRemoved(String productName) {
        By productLocator = removeWishlistItem(productName);
        boolean isProductPresent = elementVisible(productLocator);
        Assert.assertFalse(isProductPresent, "Product was not removed from the wishlist.");
    }

    public void verifyConfirmationMessageDisplayed() {
        waitUntilElementVisible(confirmationMessage, 3);
        Assert.assertTrue(elementVisible(confirmationMessage), "Confirmation message not displayed.");
    }

    public void addProductFromWishlistToCart() {
        // Implement logic to add product from wishlist to cart
    }

    public void verifyProductInCart() {
        // Implement logic to verify product is in cart
    }

    public void clearWishlist() {
        // Implement logic to clear wishlist
    }

    public void verifyWishlistIsEmpty() {
        // Implement logic to verify wishlist is empty
    }

    public void verifyLoginPromptDisplayed() {
        waitUntilElementVisible(loginPrompt, 3);
        Assert.assertTrue(elementVisible(loginPrompt), "Login prompt not displayed.");
    }

    public void performLogin() {
        // Implement login logic
    }

    public void navigateToHomePage() {
        // Implement navigation to home page
    }
}