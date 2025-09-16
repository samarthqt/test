package selenium1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class CartPage extends WebReusableComponents {

    private final By btnAddToCart = By.id("addToCart");
    private final By cartIcon = By.id("cartIcon");
    private final By cartItems = By.cssSelector(".cart-item");
    private final By productQuantity = By.cssSelector(".cart-item-quantity");
    private final By btnRemoveItem = By.cssSelector(".remove-item");
    private final By cartEmptyMessage = By.id("cartEmptyMessage");

    public CartPage() {
        PageFactory.initElements(driver, this);
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
        List<WebElement> items = getWebElementList(cartItems);
        boolean productFound = items.stream().anyMatch(item -> item.getText().contains(expectedProductName));
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
}