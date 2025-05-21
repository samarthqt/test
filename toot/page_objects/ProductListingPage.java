
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.List;
import .util.stream.Collectors;

public class ProductListingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productListing = By.id(product-listing);
    private final By sortDropdown = By.id(sort-options);
    private final By orderDropdown = By.id(order-options);
    private final By productItems = By.cssSelector(.product-item);

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productListing));
        return element.isDisplayed();
    }

    public void selectSortOption(String option) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
        dropdown.click();
        WebElement sortOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//option[text()=' + option + '])));
        sortOption.click();
    }

    public void selectOrder(String order) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(orderDropdown));
        dropdown.click();
        WebElement orderOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//option[text()=' + order + '])));
        orderOption.click();
    }

    public boolean isSortedBy(String criteria, String order) {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productItems));
        List<String> productNames = products.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedProductNames = productNames.stream().sorted().collect(Collectors.toList());
        if (descending.equalsIgnoreCase(order)) {
            sortedProductNames.sort((a, b) -> b.compareTo(a));
        }
        return productNames.equals(sortedProductNames);
    }
}
