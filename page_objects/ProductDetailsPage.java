package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ProductDetailsPage extends WebReusableComponents {

    protected By catalogSectionDesktop = By.id("catalogDesktop");
    protected By catalogSectionMobile = By.id("catalogMobile");
    protected By productDetailsDesktop = By.id("productDetailsDesktop");
    protected By productDetailsMobile = By.id("productDetailsMobile");
    protected By addToCartButton = By.id("addToCart");
    protected By productImageDesktop = By.id("productImageDesktop");
    protected By productImageMobile = By.id("productImageMobile");
    protected By socialMediaLinks = By.cssSelector(".social-media-links");

    public ProductDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void openApplication(String platform) {
        if (platform.equals("desktop")) {
            driver.get("http://retailapp.com/desktop");
        } else {
            driver.get("http://retailapp.com/mobile");
        }
    }

    public void navigateToCatalog(String platform) {
        if (platform.equals("desktop")) {
            waitUntilElementVisible(catalogSectionDesktop, 3);
            clickElement(catalogSectionDesktop);
        } else {
            waitUntilElementVisible(catalogSectionMobile, 3);
            clickElement(catalogSectionMobile);
        }
    }

    public void verifyCatalogDisplayed(String platform) {
        if (platform.equals("desktop")) {
            Assert.assertTrue(elementVisible(catalogSectionDesktop), "Catalog not displayed on desktop.");
        } else {
            Assert.assertTrue(elementVisible(catalogSectionMobile), "Catalog not displayed on mobile.");
        }
    }

    public void selectProduct(String platform) {
        WebElement product;
        if (platform.equals("desktop")) {
            product = driver.findElement(By.cssSelector(".product-desktop"));
        } else {
            product = driver.findElement(By.cssSelector(".product-mobile"));
        }
        product.click();
    }

    public void verifyProductDetailsPage(String platform) {
        if (platform.equals("desktop")) {
            Assert.assertTrue(elementVisible(productDetailsDesktop), "Product details page not displayed on desktop.");
        } else {
            Assert.assertTrue(elementVisible(productDetailsMobile), "Product details page not displayed on mobile.");
        }
    }

    public void verifyProductDetails(String platform) {
        WebElement productDetails;
        if (platform.equals("desktop")) {
            productDetails = driver.findElement(productDetailsDesktop);
        } else {
            productDetails = driver.findElement(productDetailsMobile);
        }
        Assert.assertTrue(productDetails.getText().contains("Product Name"), "Product name not visible.");
        Assert.assertTrue(productDetails.getText().contains("Description"), "Product description not visible.");
        Assert.assertTrue(productDetails.getText().contains("Price"), "Product price not visible.");
        Assert.assertTrue(elementVisible(platform.equals("desktop") ? productImageDesktop : productImageMobile), "Product image not visible.");
    }

    public void verifyProductDetailsVisibleBothPlatforms() {
        verifyProductDetailsPage("desktop");
        verifyProductDetailsPage("mobile");
    }

    public void verifyConsistencyAcrossPlatforms() {
        String desktopDetails = driver.findElement(productDetailsDesktop).getText();
        String mobileDetails = driver.findElement(productDetailsMobile).getText();
        Assert.assertEquals(desktopDetails, mobileDetails, "Product details are inconsistent across platforms.");
    }

    public void rotateDevice() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void verifyPageAdjustsToOrientation() {
        Assert.assertTrue(elementVisible(productDetailsMobile), "Page did not adjust correctly to orientation.");
    }

    public void verifyProductDetailsPageBothPlatforms() {
        verifyProductDetailsPage("desktop");
        verifyProductDetailsPage("mobile");
    }

    public void verifyPageLoadTimeBothPlatforms() {
        long startTime = System.currentTimeMillis();
        driver.navigate().refresh();
        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) < 5000, "Page load time exceeded acceptable limits.");
    }

    public void clickAddToCart() {
        waitUntilElementVisible(addToCartButton, 3);
        clickElement(addToCartButton);
    }

    public void verifyAddToCartFunctionalityBothPlatforms() {
        Assert.assertTrue(elementVisible(By.id("cartConfirmation")), "Add to Cart functionality failed.");
    }

    public void verifyProductImageDisplaysCorrectlyBothPlatforms() {
        Assert.assertTrue(elementVisible(productImageDesktop), "Product image distorted on desktop.");
        Assert.assertTrue(elementVisible(productImageMobile), "Product image distorted on mobile.");
    }

    public void verifyNoErrorsOrBrokenLinks() {
        Assert.assertFalse(driver.getPageSource().contains("404"), "Broken links found on product details page.");
        Assert.assertFalse(driver.getPageSource().contains("Error"), "Error messages found on product details page.");
    }

    public void shareViaSocialMedia() {
        waitUntilElementVisible(socialMediaLinks, 3);
        clickElement(socialMediaLinks);
    }

    public void verifySocialMediaSharingBothPlatforms() {
        Assert.assertTrue(driver.getCurrentUrl().contains("shared"), "Social media sharing failed.");
    }
}