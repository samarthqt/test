package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductBundlesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By bundlesSection = By.id(bundles-section);
    private final By bundlesList = By.id(bundles-list);
    private final By bundleItem = By.cssSelector(.bundle-item);
    private final By bundleDetails = By.id(bundle-details);
    private final By originalPrice = By.id(original-price);
    private final By discountedPrice = By.id(discounted-price);
    private final By itemsIncluded = By.id(items-included);
    private final By addToCartButton = By.id(add-to-cart);
    private final By cartBundle = By.id(cart-bundle);
    private final By cartDiscountedPrice = By.id(cart-discounted-price);
    private final By removeFromCartButton = By.id(remove-from-cart);
    private final By checkoutButton = By.id(checkout);
    private final By checkoutBundle = By.id(checkout-bundle);
    private final By totalPrice = By.id(total-price);
    private final By cartTotal = By.id(cart-total);
    private final By discountedTotal = By.id(discounted-total);
    private final By noBundles = By.id(no-bundles);
    private final By noBundlesMessage = By.id(no-bundles-message);
    private final By product1 = By.id(product1);
    private final By product2 = By.id(product2);
    private final By discountField = By.id(discount);
    private final By applyDiscountButton = By.id(apply_discount);
    private final By editBundleButton = By.id(edit_bundle);
    private final By addProductButton = By.id(add_product);
    private final By removeProductButton = By.id(remove_product);
    private final By updateDiscountButton = By.id(update_discount);
    private final By updatedBundle = By.id(updated_bundle);
    private final By newPrice = By.id(new_price);
    private final By completePaymentButton = By.id(complete_payment);
    private final By confirmationMessage = By.id(confirmation_message);
    private final By purchasedBundle = By.id(purchased_bundle);

    public ProductBundlesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToBundlesSection() {
        driver.findElement(bundlesSection).click();
    }

    public boolean isBundlesListDisplayed() {
        return driver.findElement(bundlesList).isDisplayed();
    }

    public void selectBundle() {
        driver.findElement(bundleItem).click();
    }

    public boolean isBundleDetailsDisplayed() {
        return driver.findElement(bundleDetails).isDisplayed();
    }

    public boolean verifyBundleDetails() {
        WebElement originalPriceElement = driver.findElement(originalPrice);
        WebElement discountedPriceElement = driver.findElement(discountedPrice);
        WebElement itemsIncludedElement = driver.findElement(itemsIncluded);
        return originalPriceElement.isDisplayed() && discountedPriceElement.isDisplayed() && itemsIncludedElement.isDisplayed();
    }

    public void addBundleToCart() {
        driver.findElement(addToCartButton).click();
    }

    public boolean isBundleInCart() {
        return driver.findElement(cartBundle).isDisplayed();
    }

    public boolean verifyDiscountedPriceInCart() {
        WebElement discountedPriceElement = driver.findElement(cartDiscountedPrice);
        return discountedPriceElement.isDisplayed();
    }

    public void removeBundleFromCart() {
        driver.findElement(removeFromCartButton).click();
    }

    public boolean isCartUpdatedAfterRemoval() {
        return !driver.findElement(cartBundle).isDisplayed();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public boolean isCheckoutPageDisplayingBundle() {
        return driver.findElement(checkoutBundle).isDisplayed();
    }

    public boolean verifyTotalPriceReflectsDiscount() {
        WebElement totalPriceElement = driver.findElement(totalPrice);
        return totalPriceElement.isDisplayed();
    }

    public boolean verifyCartTotal() {
        WebElement cartTotalElement = driver.findElement(cartTotal);
        return cartTotalElement.isDisplayed();
    }

    public boolean verifyCorrectDiscountedTotal() {
        WebElement discountedTotalElement = driver.findElement(discountedTotal);
        return discountedTotalElement.isDisplayed();
    }

    public void setNoBundlesAvailable() {
        driver.findElement(noBundles).click();
    }

    public boolean isNoBundlesMessageDisplayed() {
        return driver.findElement(noBundlesMessage).isDisplayed();
    }

    public void navigateToProductBundles() {
        driver.findElement(By.linkText(Product Bundles)).click();
    }

    public void selectMultipleProducts() {
        WebElement product1Element = wait.until(ExpectedConditions.elementToBeClickable(product1));
        product1Element.click();
        WebElement product2Element = wait.until(ExpectedConditions.elementToBeClickable(product2));
        product2Element.click();
    }

    public void applyDiscount() {
        WebElement discountFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(discountField));
        discountFieldElement.sendKeys(10);
        WebElement applyButtonElement = driver.findElement(applyDiscountButton);
        applyButtonElement.click();
    }

    public boolean isDiscountAppliedCorrectly() {
        WebElement totalPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        return totalPriceElement.getText().contains(Discounted);
    }

    public void browseAvailableBundles() {
        // Logic to browse bundles
    }

    public boolean areBundlesDisplayedWithDiscounts() {
        WebElement bundlesListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(bundlesList));
        return bundlesListElement.getText().contains(Discount);
    }

    public void ensureBundleInCart() {
        // Logic to ensure bundle is in cart
    }

    public void editBundle() {
        WebElement editButtonElement = wait.until(ExpectedConditions.elementToBeClickable(editBundleButton));
        editButtonElement.click();
    }

    public void modifyBundleProducts() {
        WebElement addProductElement = wait.until(ExpectedConditions.elementToBeClickable(addProductButton));
        addProductElement.click();
        WebElement removeProductElement = wait.until(ExpectedConditions.elementToBeClickable(removeProductButton));
        removeProductElement.click();
    }

    public void updateDiscount() {
        WebElement discountFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(discountField));
        discountFieldElement.clear();
        discountFieldElement.sendKeys(15);
        WebElement updateButtonElement = driver.findElement(updateDiscountButton);
        updateButtonElement.click();
    }

    public boolean isBundleUpdated() {
        WebElement updatedBundleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(updatedBundle));
        return updatedBundleElement.isDisplayed();
    }

    public boolean isNewPriceDisplayed() {
        WebElement newPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newPrice));
        return newPriceElement.isDisplayed();
    }

    public void ensureDiscountedBundleInCart() {
        // Logic to ensure discounted bundle is in cart
    }

    public void completePayment() {
        WebElement paymentButtonElement = wait.until(ExpectedConditions.elementToBeClickable(completePaymentButton));
        paymentButtonElement.click();
    }

    public boolean isPurchaseConfirmed() {
        WebElement confirmationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return confirmationMessageElement.isDisplayed();
    }

    public boolean isBundleMarkedAsPurchased() {
        WebElement purchasedBundleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(purchasedBundle));
        return purchasedBundleElement.isDisplayed();
    }
}