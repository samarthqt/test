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

    public void userIsOnProductListingPage() {
        driver.get("http://example.com/products");
    }

    public void userSelectsAProduct() {
        productPage.selectProduct();
    }

    public void userClicksAddToCartButton() {
        productPage.clickAddToCart();
    }

    public void productShouldBeAddedToShoppingCart() {
        Assert.assertTrue("Product not added to cart", cartPage.isProductInCart());
    }

    public void cartShouldDisplayAddedProduct() {
        Assert.assertTrue("Cart does not display added product", cartPage.isProductDisplayed());
    }

    public void userSelectsMultipleProducts() {
        productPage.selectMultipleProducts();
    }

    public void userClicksAddToCartButtonForEachProduct() {
        productPage.clickAddToCartForEachProduct();
    }

    public void allSelectedProductsShouldBeAddedToShoppingCart() {
        Assert.assertTrue("Not all products added to cart", cartPage.areAllProductsInCart());
    }

    public void cartShouldDisplayAllAddedProducts() {
        Assert.assertTrue("Cart does not display all added products", cartPage.areAllProductsDisplayed());
    }

    public void userClicksAddToCartButtonMultipleTimes() {
        productPage.clickAddToCartMultipleTimes();
    }

    public void cartShouldReflectCorrectQuantity() {
        Assert.assertTrue("Cart quantity incorrect", cartPage.isQuantityCorrect());
    }

    public void userAddsProductToCart() {
        productPage.selectProduct();
        productPage.clickAddToCart();
    }

    public void userNavigatesToShoppingCartPage() {
        cartPage.navigateToCart();
    }

    public void cartShouldListAllProductsAdded() {
        Assert.assertTrue("Cart does not list all products", cartPage.areAllProductsListed());
    }

    public void totalCostShouldBeCorrectlyCalculated() {
        Assert.assertTrue("Total cost incorrect", cartPage.isTotalCostCorrect());
    }

    public void userIsNotLoggedIn() {
        // Assume user is not logged in
    }

    public void userShouldBePromptedToLogInOrRegister() {
        Assert.assertTrue("User not prompted to log in", cartPage.isLoginPromptDisplayed());
    }

    public void productIsOutOfStock() {
        productPage.selectOutOfStockProduct();
    }

    public void userSelectsOutOfStockProduct() {
        productPage.selectOutOfStockProduct();
    }

    public void userShouldBeNotifiedProductOutOfStock() {
        Assert.assertTrue("User not notified of out of stock", productPage.isOutOfStockNotificationDisplayed());
    }

    public void productShouldNotBeAddedToCart() {
        Assert.assertFalse("Out of stock product added to cart", cartPage.isOutOfStockProductInCart());
    }
}