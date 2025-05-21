import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class AddToCartSteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductPage productPage;
    CartPage cartPage;

    public AddToCartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
    }

    public void userIsOnProductPage() {
        driver.get("http://example.com/products");
    }

    public void userSelectsAProduct() {
        productPage.selectProduct();
    }

    public void userClicksAddToCartButton() {
        productPage.clickAddToCart();
    }

    public void productShouldBeAddedToCart() {
        Assert.assertTrue("Product not added to cart", cartPage.isProductInCart());
    }

    public void cartIconShouldDisplayCorrectNumberOfItems(int expectedCount) {
        Assert.assertEquals("Incorrect number of items in cart", expectedCount, cartPage.getCartItemCount());
    }

    public void userSelectsMultipleProducts() {
        productPage.selectMultipleProducts();
    }

    public void userClicksAddToCartButtonForEachProduct() {
        productPage.clickAddToCartForEachProduct();
    }

    public void allSelectedProductsShouldBeAddedToCart() {
        Assert.assertTrue("Not all products added to cart", cartPage.areAllProductsInCart());
    }

    public void productHasMultipleOptions() {
        Assert.assertTrue("Product does not have multiple options", productPage.hasMultipleOptions());
    }

    public void userTriesToAddProductWithoutSelectingOptions() {
        productPage.tryAddToCartWithoutOptions();
    }

    public void userShouldBePromptedToSelectOptions() {
        Assert.assertTrue("User not prompted to select options", productPage.isPromptedToSelectOptions());
    }

    public void userAddsProductToCart() {
        productPage.addProductToCart();
    }

    public void userClicksViewCartButton() {
        productPage.clickViewCart();
    }

    public void userShouldBeNavigatedToCartPage() {
        Assert.assertTrue("User not navigated to cart page", cartPage.isOnCartPage());
    }

    public void addedProductShouldBeDisplayedInCart() {
        Assert.assertTrue("Added product not displayed in cart", cartPage.isProductDisplayedInCart());
    }

    public void productIsOutOfStock() {
        Assert.assertTrue("Product is not out of stock", productPage.isOutOfStock());
    }

    public void userTriesToAddOutOfStockProduct() {
        productPage.tryAddOutOfStockProduct();
    }

    public void userShouldReceiveOutOfStockNotification() {
        Assert.assertTrue("No out of stock notification", productPage.isOutOfStockNotificationDisplayed());
    }

    public void productShouldNotBeAddedToCart() {
        Assert.assertFalse("Out of stock product added to cart", cartPage.isOutOfStockProductInCart());
    }

    public void userHasProductsInCart() {
        Assert.assertTrue("No products in cart", cartPage.hasProductsInCart());
    }

    public void userDecidesToRemoveProduct() {
        cartPage.selectProductToRemove();
    }

    public void userClicksRemoveButton() {
        cartPage.clickRemoveButton();
    }

    public void productShouldBeRemovedFromCart() {
        Assert.assertFalse("Product not removed from cart", cartPage.isProductInCart());
    }

    public void userUpdatesProductQuantity() {
        cartPage.updateProductQuantity();
    }

    public void cartShouldReflectUpdatedQuantity() {
        Assert.assertTrue("Cart does not reflect updated quantity", cartPage.isQuantityUpdated());
    }

    public void totalPriceShouldBeRecalculated() {
        Assert.assertTrue("Total price not recalculated", cartPage.isTotalPriceRecalculated());
    }
}