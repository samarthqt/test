package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductDetailsPage;

public class ProductDetailsSteps extends ProductDetailsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the product page is loaded")
    public void theProductPageIsLoaded() {
        String productPageURL = testHarness.getData("ProductData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("the product details are fetched from the database")
    public void theProductDetailsAreFetchedFromTheDatabase() {
        fetchProductDetails();
    }

    @Then("the product name, description, price, image, stock availability, and category should be visible")
    public void theProductDetailsShouldBeVisible() {
        verifyProductDetailsVisibility();
    }

    @Then("all fields should be correctly populated and updated in real-time")
    public void allFieldsShouldBeCorrectlyPopulatedAndUpdatedInRealTime() {
        verifyRealTimeUpdates();
    }

    @When("the user clicks on the product image")
    public void theUserClicksOnTheProductImage() {
        clickProductImage();
    }

    @Then("the product image should be displayed in high resolution")
    public void theProductImageShouldBeDisplayedInHighResolution() {
        verifyHighResolutionImage();
    }

    @When("there is an error in loading product details")
    public void thereIsAnErrorInLoadingProductDetails() {
        simulateErrorInLoadingDetails();
    }

    @Then("the system should display an error message gracefully")
    public void theSystemShouldDisplayAnErrorMessageGracefully() {
        verifyErrorMessageDisplay();
    }

    @When("the user views the product details")
    public void theUserViewsTheProductDetails() {
        viewProductDetails();
    }

    @Then("security measures should ensure product details are not tampered with")
    public void securityMeasuresShouldEnsureProductDetailsAreNotTamperedWith() {
        verifySecurityMeasures();
    }

    @When("the user accesses the product details")
    public void theUserAccessesTheProductDetails() {
        accessProductDetails();
    }

    @Then("accessibility standards must be met for all product details")
    public void accessibilityStandardsMustBeMetForAllProductDetails() {
        verifyAccessibilityStandards();
    }

    @Given("the product page is loaded on a device")
    public void theProductPageIsLoadedOnADevice() {
        String deviceType = testHarness.getData("DeviceData", "DeviceType");
        loadProductPageOnDevice(deviceType);
    }

    @When("the user views the product details")
    public void theUserViewsTheProductDetailsOnDevice() {
        viewProductDetailsOnDevice();
    }

    @Then("product details must be available on both desktop and mobile platforms")
    public void productDetailsMustBeAvailableOnBothPlatforms() {
        verifyPlatformAvailability();
    }

    @When("an issue is encountered during the display of product details")
    public void anIssueIsEncounteredDuringDisplay() {
        simulateDisplayIssue();
    }

    @Then("the system should log the issue")
    public void theSystemShouldLogTheIssue() {
        logDisplayIssue();
    }

    @When("the product details are updated in the database")
    public void theProductDetailsAreUpdatedInTheDatabase() {
        updateProductDetailsInDatabase();
    }

    @Then("the product page should reflect accurate and timely updates")
    public void theProductPageShouldReflectUpdates() {
        verifyTimelyUpdates();
    }

    @When("the product is out of stock")
    public void theProductIsOutOfStock() {
        simulateOutOfStock();
    }

    @Then("the system should notify users that the product is out of stock")
    public void theSystemShouldNotifyUsersOutOfStock() {
        verifyOutOfStockNotification();
    }
}