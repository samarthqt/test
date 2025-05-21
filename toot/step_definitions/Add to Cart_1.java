import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class AddToCartSteps {
    WebDriver driver;
    WebDriverWait wait;
    ProductPage productPage;
    CartPage cartPage;

    public AddToCartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
    }

    public void givenIAmViewingAProductOnTheProductDetailsPage() {
        productPage.navigateToProductDetails();
    }

    public void whenIClickOnTheAddToCartButton() {
        productPage.clickAddToCart();
    }

    public void thenTheProductShouldBeAddedToTheShoppingCart() {
        Assert.assertTrue("Product not added to cart", cartPage.isProductInCart());
    }

    public void andTheCartIconShouldDisplayTheCorrectNumberOfItems(int expectedCount) {
        Assert.assertEquals("Incorrect number of items in cart", expectedCount, cartPage.getCartItemCount());
    }

    public void whenISelectAQuantityOf(int quantity) {
        productPage.selectQuantity(quantity);
    }

    public void andINavigateToAnotherProductDetailsPage() {
        productPage.navigateToAnotherProductDetails();
    }

    public void givenIHaveAddedProductsToMyShoppingCart() {
        cartPage.addProductsToCart();
    }

    public void whenIClickOnTheCartIcon() {
        cartPage.clickCartIcon();
    }

    public void thenIShouldBeTakenToTheCartPage() {
        Assert.assertTrue("Not on cart page", cartPage.isOnCartPage());
    }

    public void andIShouldSeeAllTheProductsIHaveAdded() {
        Assert.assertTrue("Products not visible in cart", cartPage.areAllProductsVisible());
    }

    public void andTheTotalPriceShouldBeCorrectlyCalculated() {
        Assert.assertTrue("Incorrect total price", cartPage.isTotalPriceCorrect());
    }

    public void givenIAmNotLoggedIntoTheECommercePlatform() {
        productPage.ensureNotLoggedIn();
    }

    public void whenITryToAddAProductToTheCart() {
        productPage.tryAddToCart();
    }

    public void thenIShouldBePromptedToLogInOrRegister() {
        Assert.assertTrue("Not prompted to log in", productPage.isLoginPromptVisible());
    }

    public void givenIHaveAddedAProductToMyShoppingCart() {
        cartPage.addSingleProductToCart();
    }

    public void whenIViewMyCart() {
        cartPage.viewCart();
    }

    public void thenIShouldSeeTheCorrectProductNamePriceAndQuantity() {
        Assert.assertTrue("Incorrect product details", cartPage.areProductDetailsCorrect());
    }

    public void whenIChooseToRemoveAProduct() {
        cartPage.removeProduct();
    }

    public void thenTheProductShouldNoLongerAppearInMyCart() {
        Assert.assertFalse("Product still in cart", cartPage.isProductInCart());
    }
}