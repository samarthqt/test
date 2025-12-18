package com.page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;

public class ProductListingPage extends WebReusableComponents {

    protected By productById(String productId) {
        return By.cssSelector(".product[data-id='" + productId + "']");
    }

    protected By btnAddToCart = By.id("addToCart");

    public ProductListingPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectProductById(String productId) {
        WebElement product = findElement(productById(productId));
        product.click();
    }

    public void addToCart() {
        waitUntilElementVisible(btnAddToCart, 3);
        clickElement(btnAddToCart);
    }
}