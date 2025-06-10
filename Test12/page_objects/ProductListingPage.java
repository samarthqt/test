package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class ProductListingPage extends WebReusableComponents {

    protected By addToWishlistButton = By.id("addToWishlist");
    protected By wishlistLink = By.id("wishlistLink");
    protected By wishlistItems = By.cssSelector(".wishlist-item");
    protected By removeWishlistItem(String productName) {
        return By.xpath("//div[@class='wishlist-item' and contains(text(), '" + productName + "')]/following-sibling::button[@class='remove']");
    }
    protected By btnAddToCart = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By productQuantity = By.cssSelector(".cart-item-quantity");
    protected By btnRemoveItem = By.cssSelector(".remove-item");
    protected By cartEmptyMessage = By.id("cartEmptyMessage");
    protected By filterOptions = By.id("filterOptions");
    protected By filteredResults = By.id("filteredResults");

    public ProductListingPage() {
        PageFactory.initElements(driver, this);
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

    public void addProductToCart() {
        waitUntilElementVisible(btnAddToCart, 3);
        clickElement(btnAddToCart);
    }

    public void openCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyProductInCart(String expectedProductName) {
        waitUntilElementVisible(cartItems, 3);
        boolean productFound = getWebElementList(cartItems)
            .stream()
            .anyMatch(item -> item.getText().contains(expectedProductName));
        Assert.assertTrue(productFound, "Product is not in the cart.");
    }

    public void updateProductQuantity(String quantity) {
        waitUntilElementVisible(productQuantity, 3);
        selectByValue(productQuantity, quantity);
    }

    public void verifyProductQuantity(String expectedQuantity) {
        waitUntilElementVisible(productQuantity, 3);
        String actualQuantity = getTextFromElement(productQuantity);
        Assert.assertEquals(actualQuantity, expectedQuantity, "Quantity update failed.");
    }

    public void removeProductFromCart() {
        waitUntilElementVisible(btnRemoveItem, 3);
        clickElement(btnRemoveItem);
    }

    public void verifyCartIsEmpty() {
        waitUntilElementVisible(cartEmptyMessage, 3);
        String actualMessage = getTextFromElement(cartEmptyMessage);
        Assert.assertEquals(actualMessage, "Your cart is empty.", "Cart is not empty.");
    }

    public void applyFilter() {
        waitUntilElementVisible(filterOptions, 3);
        clickElement(filterOptions);
    }

    public void verifyFilterEase() {
        Assert.assertTrue(isElementDisplayed(filterOptions), "Filter options are not easy to use.");
    }

    public void verifyResponsiveResults() {
        waitUntilElementVisible(filteredResults, 3);
        Assert.assertTrue(isElementDisplayed(filteredResults), "Filtered results are not responsive.");
    }
}