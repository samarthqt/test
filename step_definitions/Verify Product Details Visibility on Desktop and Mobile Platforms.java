package com.cucumber.steps;

import com.page_objects.ProductDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsSteps extends ProductDetailsPage {

    @Given("the retail application is open on a desktop browser")
    public void openRetailApplicationOnDesktop() {
        openApplication("desktop");
    }

    @Given("the retail application is open on a mobile browser")
    public void openRetailApplicationOnMobile() {
        openApplication("mobile");
    }

    @When("I navigate to the product catalog section")
    public void navigateToProductCatalogDesktop() {
        navigateToCatalog("desktop");
    }

    @When("I navigate to the product catalog section on mobile")
    public void navigateToProductCatalogMobile() {
        navigateToCatalog("mobile");
    }

    @Then("the product catalog is displayed on the desktop screen")
    public void verifyCatalogDisplayedDesktop() {
        verifyCatalogDisplayed("desktop");
    }

    @Then("the product catalog is displayed on the mobile screen")
    public void verifyCatalogDisplayedMobile() {
        verifyCatalogDisplayed("mobile");
    }

    @When("I select a product from the catalog")
    public void selectProductFromCatalogDesktop() {
        selectProduct("desktop");
    }

    @When("I select the same product from the catalog on mobile")
    public void selectProductFromCatalogMobile() {
        selectProduct("mobile");
    }

    @Then("the product details page is displayed with product information")
    public void verifyProductDetailsPageDesktop() {
        verifyProductDetailsPage("desktop");
    }

    @Then("the product details page is displayed with product information on mobile")
    public void verifyProductDetailsPageMobile() {
        verifyProductDetailsPage("mobile");
    }

    @Then("product name, description, price, and image are visible and correctly displayed on the desktop")
    public void verifyProductDetailsDesktop() {
        verifyProductDetails("desktop");
    }

    @Then("product name, description, price, and image are visible and correctly displayed on the mobile")
    public void verifyProductDetailsMobile() {
        verifyProductDetails("mobile");
    }

    @Given("the product details are visible on both desktop and mobile platforms")
    public void verifyProductDetailsVisibleBothPlatforms() {
        verifyProductDetailsVisibleBothPlatforms();
    }

    @Then("there are no discrepancies; product details are consistent across platforms")
    public void verifyNoDiscrepanciesAcrossPlatforms() {
        verifyConsistencyAcrossPlatforms();
    }

    @Given("the product details page is displayed on mobile")
    public void verifyProductDetailsPageDisplayedMobile() {
        verifyProductDetailsPage("mobile");
    }

    @When("I rotate the mobile device")
    public void rotateMobileDevice() {
        rotateDevice();
    }

    @Then("the product details page adjusts correctly to landscape and portrait orientations")
    public void verifyPageAdjustsToOrientation() {
        verifyPageAdjustsToOrientation();
    }

    @Given("the product details page is displayed on both desktop and mobile")
    public void verifyProductDetailsPageDisplayedBothPlatforms() {
        verifyProductDetailsPageBothPlatforms();
    }

    @Then("the product details page loads within acceptable time limits on both platforms")
    public void verifyPageLoadTimeBothPlatforms() {
        verifyPageLoadTimeBothPlatforms();
    }

    @When("I click on the 'Add to Cart' button")
    public void clickAddToCartButton() {
        clickAddToCart();
    }

    @Then("the 'Add to Cart' button functions correctly on both platforms")
    public void verifyAddToCartFunctionalityBothPlatforms() {
        verifyAddToCartFunctionalityBothPlatforms();
    }

    @Then("the product image displays correctly without distortion on both desktop and mobile")
    public void verifyProductImageDisplaysCorrectlyBothPlatforms() {
        verifyProductImageDisplaysCorrectlyBothPlatforms();
    }

    @Then("no error messages or broken links are present on the product details page")
    public void verifyNoErrorsOrBrokenLinks() {
        verifyNoErrorsOrBrokenLinks();
    }

    @When("I share product details via social media links")
    public void shareProductDetailsViaSocialMedia() {
        shareViaSocialMedia();
    }

    @Then("product details can be shared successfully via social media links on both desktop and mobile")
    public void verifySocialMediaSharingBothPlatforms() {
        verifySocialMediaSharingBothPlatforms();
    }
}