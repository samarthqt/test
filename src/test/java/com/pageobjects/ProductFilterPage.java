package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;

public class ProductFilterPage extends WebReusableComponents {

    protected By categoryFilterDropdown = By.id("categoryFilter");
    protected By productItems = By.cssSelector(".product-item");

    public ProductFilterPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToProductSearchPage() {
        driver.get("http://example.com/product-search");
    }

    public void selectCategoryFilter(String category) {
        waitUntilElementVisible(categoryFilterDropdown, 3);
        selectByVisibleText(categoryFilterDropdown, category);
    }

    public void verifyProductsDisplayedByCategory(String category) {
        waitUntilElementVisible(productItems, 3);
        List<WebElement> products = getWebElementList(productItems);
        boolean allProductsMatchCategory = products.stream()
            .allMatch(product -> product.getText().contains(category));
        Assert.assertTrue(allProductsMatchCategory, "Not all products are from the " + category + " category.");
    }
}