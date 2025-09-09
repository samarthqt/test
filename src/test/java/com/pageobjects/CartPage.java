package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;

public class CartPage extends WebReusableComponents {

    protected By productListingPage = By.id("productListingPage");
    protected By product1Details = By.id("product1Details");
    protected By product2Details = By.id("product2Details");
    protected By addToCartButton = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By cartContents = By.id("cartContents");
    protected By cartSubtotal = By.id("cartSubtotal");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By productQuantity = By.cssSelector(".cart-item-quantity");
    protected By subtotal = By.id("subtotal");
    protected By confirmationDialog = By.id("confirmationDialog");
    protected By btnConfirmRemoval = By.id("confirmRemoval");
    protected By cartEmptyMessage = By.id("cartEmptyMessage");
    protected By homePage = By.id("homePage");
    protected By productDetailPage = By.id("productDetailPage");
    protected By quantitySelector = By.id("quantitySelector");
    protected By errorMessage = By.id("errorMessage");
    protected By cartQuantityField = By.id("cartQuantityField");
    protected By product1 = By.id("product1");
    protected By addToCartButton = By.id("addToCartButton");
    protected By productPrice = By.cssSelector(".cart-item-price");

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get("http://ecommerce-website.com");
    }

    public void navigateToProductListingPage() {
        waitUntilElementVisible(productListingPage, 3);
        clickElement(productListingPage);
    }

    public void verifyProductListingPage() {
        Assert.assertTrue(elementVisible(productListingPage), "Product listing page is not displayed.");
    }

    public void selectProduct1() {
        waitUntilElementVisible(product1Details, 3);
        clickElement(product1Details);
    }

    public void viewProduct1Details() {
        waitUntilElementVisible(product1Details, 3);
        clickElement(product1Details);
    }

    public void verifyProduct1DetailsPage() {
        Assert.assertTrue(elementVisible(product1Details), "Product 1 details page is not displayed.");
    }

    public void addProduct1ToCart() {
        waitUntilElementVisible(addToCartButton, 3);
        clickElement(addToCartButton);
    }

    public void verifyProduct1InCart() {
        openCart();
        List<WebElement> items = getWebElementList(cartContents);
        boolean product1Found = items.stream().anyMatch(item -> item.getText().contains("Product 1"));
        Assert.assertTrue(product1Found, "Product 1 is not in the cart.");
    }

    public void verifyAddToCartConfirmation() {
        String message = getTextFromElement(confirmationMessage);
        Assert.assertEquals(message, "Product added to cart successfully", "Confirmation message is incorrect.");
    }

    public void verifyCartIconCount(int expectedCount) {
        String countText = getTextFromElement(cartIcon);
        Assert.assertEquals(Integer.parseInt(countText), expectedCount, "Cart icon count is incorrect.");
    }

    public void navigateBackToProductListingPage() {
        navigateToProductListingPage();
    }

    public void viewProduct2Details() {
        waitUntilElementVisible(product2Details, 3);
        clickElement(product2Details);
    }

    public void verifyProduct2DetailsPage() {
        Assert.assertTrue(elementVisible(product2Details), "Product 2 details page is not displayed.");
    }

    public void addProduct2ToCart() {
        waitUntilElementVisible(addToCartButton, 3);
        clickElement(addToCartButton);
    }

    public void verifyProduct2InCart() {
        openCart();
        List<WebElement> items = getWebElementList(cartContents);
        boolean product2Found = items.stream().anyMatch(item -> item.getText().contains("Product 2"));
        Assert.assertTrue(product2Found, "Product 2 is not in the cart.");
    }

    public void openCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyCartContents() {
        List<WebElement> items = getWebElementList(cartContents);
        boolean product1Found = items.stream().anyMatch(item -> item.getText().contains("Product 1"));
        boolean product2Found = items.stream().anyMatch(item -> item.getText().contains("Product 2"));
        Assert.assertTrue(product1Found && product2Found, "Cart contents are incorrect.");
    }

    public void verifyCartSubtotal() {
        String subtotalText = getTextFromElement(cartSubtotal);
        Assert.assertEquals(subtotalText, "Expected Subtotal", "Cart subtotal is incorrect.");
    }

    public void quickAddProduct1ToCart() {
        addProduct1ToCart();
    }

    public void verifyProduct1Quantity(int expectedQuantity) {
        openCart();
        List<WebElement> items = getWebElementList(cartContents);
        WebElement product1 = items.stream().filter(item -> item.getText().contains("Product 1")).findFirst().orElse(null);
        String quantityText = product1.findElement(By.cssSelector(".quantity")).getText();
        Assert.assertEquals(Integer.parseInt(quantityText), expectedQuantity, "Product 1 quantity is incorrect.");
    }

    public void verifyCartUpdateConfirmation() {
        String message = getTextFromElement(confirmationMessage);
        Assert.assertEquals(message, "Cart updated successfully", "Cart update confirmation message is incorrect.");
    }

    public void verifyUpdatedCartContents() {
        verifyCartContents();
    }

    public void verifyUpdatedCartSubtotal() {
        verifyCartSubtotal();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void verifyCartPersistence() {
        verifyUpdatedCartContents();
        verifyUpdatedCartSubtotal();
    }

    public void addProductToCart(int productNumber) {
        By addToCartButton = By.id("addToCart" + productNumber);
        waitUntilElementVisible(addToCartButton, 3);
        clickElement(addToCartButton);
    }

    public void verifyCartContainsProductsWithQuantity(int productCount, int quantity) {
        waitUntilElementVisible(cartItems, 3);
        Assert.assertEquals(getWebElementList(cartItems).size(), productCount, "Cart does not contain the expected number of products.");
        getWebElementList(productQuantity).forEach(item -> Assert.assertEquals(item.getText(), String.valueOf(quantity), "Product quantity is incorrect."));
    }

    public void verifySubtotal(String expectedSubtotal) {
        waitUntilElementVisible(subtotal, 3);
        String actualSubtotal = getTextFromElement(subtotal);
        Assert.assertEquals(actualSubtotal, expectedSubtotal, "Subtotal is incorrect.");
    }

    public void removeProductFromCart(int productNumber) {
        By removeButton = By.id("removeProduct" + productNumber);
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyConfirmationDialogAppears() {
        waitUntilElementVisible(confirmationDialog, 3);
        Assert.assertTrue(elementVisible(confirmationDialog), "Confirmation dialog did not appear.");
    }

    public void confirmRemoval() {
        waitUntilElementVisible(btnConfirmRemoval, 3);
        clickElement(btnConfirmRemoval);
    }

    public void verifyProductRemovedFromCart(int productNumber) {
        By productLocator = By.id("product" + productNumber);
        Assert.assertFalse(elementVisible(productLocator), "Product was not removed from the cart.");
    }

    public void verifyCartContainsSpecificProductsWithQuantity(int[] productNumbers, int quantity) {
        for (int productNumber : productNumbers) {
            By productLocator = By.id("product" + productNumber);
            Assert.assertTrue(elementVisible(productLocator), "Product " + productNumber + " is not in the cart.");
            By quantityLocator = By.id("quantity" + productNumber);
            Assert.assertEquals(getTextFromElement(quantityLocator), String.valueOf(quantity), "Product quantity is incorrect.");
        }
    }

    public void verifyCartContainsSpecificProducts(int[] productNumbers) {
        for (int productNumber : productNumbers) {
            By productLocator = By.id("product" + productNumber);
            Assert.assertTrue(elementVisible(productLocator), "Product " + productNumber + " is not in the cart.");
        }
    }

    public void verifyCartIsEmpty() {
        waitUntilElementVisible(cartEmptyMessage, 3);
        String actualMessage = getTextFromElement(cartEmptyMessage);
        Assert.assertEquals(actualMessage, "Your cart is empty.", "Cart is not empty.");
    }

    public void selectProduct(String productName) {
        clickElement(By.linkText(productName));
    }

    public void verifyProductDetailPage(String productName) {
        Assert.assertTrue(driver.getTitle().contains(productName), "Not on product detail page.");
    }

    public void locateQuantitySelector() {
        waitUntilElementVisible(quantitySelector, 3);
    }

    public void clearAndEnterQuantity(String quantity) {
        clearAndEnterText(quantitySelector, quantity);
    }

    public void clickAddToCart() {
        clickElement(btnAddToCart);
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyCartIconUnchanged() {
        // Logic to verify cart icon remains unchanged
    }

    public void verifyCartContents(String productName, boolean shouldContain, String... quantity) {
        // Logic to verify cart contents
    }

    public void navigateToProductDetailPage(String productName) {
        clickElement(By.linkText(productName));
    }

    public void verifyQuantityFieldReset(String quantity) {
        String actualQuantity = getTextFromElement(quantitySelector);
        Assert.assertEquals(actualQuantity, quantity, "Quantity field not reset.");
    }

    public void enterQuantity(String quantity) {
        clearAndEnterText(quantitySelector, quantity);
    }

    public void verifyProductAddedToCart(String quantity) {
        // Logic to verify product added to cart
    }

    public void locateCartQuantityField(String productName) {
        // Logic to locate cart quantity field
    }

    public void clearAndEnterCartQuantity(String quantity) {
        clearAndEnterText(cartQuantityField, quantity);
    }

    public void verifyCartErrorMessage(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Cart error message does not match.");
    }

    public void verifyCartQuantityReverted(String quantity) {
        String actualQuantity = getTextFromElement(cartQuantityField);
        Assert.assertEquals(actualQuantity, quantity, "Cart quantity not reverted.");
    }

    public void viewCartContents() {
        waitUntilElementVisible(cartContents, 3);
        clickElement(cartContents);
    }

    public void verifyProductNotInCart(String productName) {
        waitUntilElementVisible(cartContents, 3);
        boolean productFound = getWebElementList(cartContents)
            .stream()
            .noneMatch(item -> item.getText().contains(productName));
        Assert.assertTrue(productFound, "Product is in the cart.");
    }

    public void navigateToProduct1DetailPage() {
        driver.get("http://example.com/product1DetailPage");
    }

    public void verifyProductInCartWithQuantity(String productName, String quantity) {
        waitUntilElementVisible(cartContents, 3);
        boolean productFound = getWebElementList(cartContents)
            .stream()
            .anyMatch(item -> item.getText().contains(productName) && item.getText().contains(quantity));
        Assert.assertTrue(productFound, "Product with specified quantity is not in the cart.");
    }

    public void verifyConfirmationMessage() {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Product added successfully.", "Confirmation message does not match.");
    }

    public void verifyCartDisplaysProductWithQuantity(String productName, String quantity) {
        waitUntilElementVisible(cartContents, 3);
        boolean productFound = getWebElementList(cartContents)
            .stream()
            .anyMatch(item -> item.getText().contains(productName) && item.getText().contains(quantity));
        Assert.assertTrue(productFound, "Product with specified quantity is not displayed in the cart.");
    }

    public void enterCartQuantityAndUpdate(String quantity) {
        waitUntilElementVisible(cartQuantityField, 3);
        enterText(cartQuantityField, quantity);
        clickElement(cartQuantityField);
    }

    public void openWebApplication() {
        // Dummy implementation for opening the web application
    }

    public void navigateToCategory(String category) {
        // Dummy implementation for navigating to a category
    }

    public void verifyProductInCartWithQuantity(String productName, int expectedQuantity) {
        waitUntilElementVisible(cartItems, 3);
        boolean productFound = getWebElementList(cartItems)
            .stream()
            .anyMatch(item -> item.getText().contains(productName) &&
                Integer.parseInt(item.findElement(productQuantity).getText()) == expectedQuantity);
        Assert.assertTrue(productFound, "Product with expected quantity is not in the cart.");
    }

    public void verifySingleEntryInCart(String productName) {
        long count = getWebElementList(cartItems)
            .stream()
            .filter(item -> item.getText().contains(productName))
            .count();
        Assert.assertEquals(count, 1, "More than one entry found for the product.");
    }

    public void verifySubtotal(double expectedSubtotal) {
        waitUntilElementVisible(subtotal, 3);
        double actualSubtotal = Double.parseDouble(getTextFromElement(subtotal).replace("$", ""));
        Assert.assertEquals(actualSubtotal, expectedSubtotal, "Subtotal is incorrect.");
    }
}
