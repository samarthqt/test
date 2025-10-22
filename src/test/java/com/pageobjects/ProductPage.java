package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ProductPage extends WebReusableComponents {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    private By reviewsSection = By.id("reviewsSection");
    private By productTitle = By.cssSelector(".product-title");

    public void navigateToProductDetailPage(String productName) {
        driver.get("http://example.com/product/" + productName);
        waitUntilElementVisible(productTitle, 5);
    }

    public void scrollToReviewsSection() {
        WebElement reviewsElement = driver.findElement(reviewsSection);
        scrollToElement(reviewsElement);
    }

    public void verifyReviewsAndRatingsDisplayed() {
        waitUntilElementVisible(reviewsSection, 5);
        boolean isDisplayed = driver.findElement(reviewsSection).isDisplayed();
        Assert.assertTrue(isDisplayed, "Reviews and ratings are not displayed correctly.");
    }
}