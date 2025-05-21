import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class ViewCartSteps {
    WebDriver driver;
    WebDriverWait wait;
    ShoppingCartPage shoppingCartPage;

    public ViewCartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.shoppingCartPage = new ShoppingCartPage(driver);
    }

    public void userNavigatesToShoppingCartPage() {
        shoppingCartPage.navigateToCart();
    }

    public void userShouldSeeAllProductsInCart() {
        Assert.assertTrue("Products not displayed in cart", shoppingCartPage.areProductsDisplayed());
    }

    public void eachProductShouldDisplayDetails() {
        Assert.assertTrue("Product details not displayed correctly", shoppingCartPage.areProductDetailsCorrect());
    }

    public void userShouldSeeEmptyCartMessage() {
        Assert.assertTrue("Empty cart message not displayed", shoppingCartPage.isEmptyCartMessageDisplayed());
    }

    public void userUpdatesProductQuantity() {
        shoppingCartPage.updateProductQuantity("ProductName", 2);
    }

    public void cartShouldReflectUpdatedQuantity() {
        Assert.assertTrue("Quantity not updated", shoppingCartPage.isQuantityUpdated("ProductName", 2));
    }

    public void totalPriceShouldBeRecalculated() {
        Assert.assertTrue("Total price not recalculated", shoppingCartPage.isTotalPriceCorrect());
    }

    public void userRemovesProductFromCart() {
        shoppingCartPage.removeProduct("ProductName");
    }

    public void productShouldNoLongerAppearInCart() {
        Assert.assertFalse("Product still appears in cart", shoppingCartPage.isProductInCart("ProductName"));
    }

    public void totalPriceShouldBeUpdated() {
        Assert.assertTrue("Total price not updated", shoppingCartPage.isTotalPriceCorrect());
    }

    public void userProceedsToCheckout() {
        shoppingCartPage.proceedToCheckout();
    }

    public void userShouldBeDirectedToCheckoutProcess() {
        Assert.assertTrue("Not directed to checkout", shoppingCartPage.isCheckoutPageDisplayed());
    }
}