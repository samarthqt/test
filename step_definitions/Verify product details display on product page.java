package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import com.page_objects.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsSteps extends ProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have access to the product page")
    public void iHaveAccessToTheProductPage() {
        String productPageURL = testHarness.getData("ProductData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("I navigate to the product page with ID {int}")
    public void iNavigateToTheProductPageWithID(int productId) {
        navigateToProductPage(productId);
    }

    @Then("the product page loads successfully")
    public void theProductPageLoadsSuccessfully() {
        verifyPageLoaded();
    }

    @Given("I am on the product page with ID {int}")
    public void iAmOnTheProductPageWithID(int productId) {
        navigateToProductPage(productId);
    }

    @When("I check the product name")
    public void iCheckTheProductName() {
        verifyProductName();
    }

    @Then("the product name '{string}' is displayed correctly")
    public void theProductNameIsDisplayedCorrectly(String expectedName) {
        verifyProductName(expectedName);
    }

    @When("I check the product description")
    public void iCheckTheProductDescription() {
        verifyProductDescription();
    }

    @Then("the description '{string}' is displayed correctly")
    public void theDescriptionIsDisplayedCorrectly(String expectedDescription) {
        verifyProductDescription(expectedDescription);
    }

    @When("I check the product price")
    public void iCheckTheProductPrice() {
        verifyProductPrice();
    }

    @Then("the price '{string}' is displayed correctly")
    public void thePriceIsDisplayedCorrectly(String expectedPrice) {
        verifyProductPrice(expectedPrice);
    }

    @When("I check the product image")
    public void iCheckTheProductImage() {
        verifyProductImage();
    }

    @Then("the image is displayed without distortion")
    public void theImageIsDisplayedWithoutDistortion() {
        verifyImageDisplay();
    }

    @When("I check the stock availability")
    public void iCheckTheStockAvailability() {
        verifyStockAvailability();
    }

    @Then("the stock status '{string}' is displayed correctly")
    public void theStockStatusIsDisplayedCorrectly(String expectedStatus) {
        verifyStockStatus(expectedStatus);
    }

    @When("I check the product category")
    public void iCheckTheProductCategory() {
        verifyProductCategory();
    }

    @Then("the category '{string}' is displayed correctly")
    public void theCategoryIsDisplayedCorrectly(String expectedCategory) {
        verifyProductCategory(expectedCategory);
    }

    @When("I refresh the product page")
    public void iRefreshTheProductPage() {
        refreshPage();
    }

    @Then("the product details remain unchanged")
    public void theProductDetailsRemainUnchanged() {
        verifyDetailsPersistence();
    }

    @Given("I have access to the backend database")
    public void iHaveAccessToTheBackendDatabase() {
        connectToDatabase();
    }

    @When("I check the product details for ID {int}")
    public void iCheckTheProductDetailsForID(int productId) {
        verifyDatabaseEntries(productId);
    }

    @Then("the database entries match the displayed data")
    public void theDatabaseEntriesMatchTheDisplayedData() {
        verifyDatabaseConsistency();
    }

    @When("I view the product page on different browsers")
    public void iViewTheProductPageOnDifferentBrowsers() {
        verifyCrossBrowserCompatibility();
    }

    @Then("the product details display consistently across all browsers")
    public void theProductDetailsDisplayConsistentlyAcrossAllBrowsers() {
        verifyCrossBrowserConsistency();
    }

    @When("I view the product page on mobile devices")
    public void iViewTheProductPageOnMobileDevices() {
        verifyMobileCompatibility();
    }

    @Then("the product details are displayed correctly on mobile")
    public void theProductDetailsAreDisplayedCorrectlyOnMobile() {
        verifyMobileDisplay();
    }

    @When("I edit the product details")
    public void iEditTheProductDetails() {
        editProductDetails();
    }

    @Then("updates reflect immediately on the product page")
    public void updatesReflectImmediatelyOnTheProductPage() {
        verifyImmediateUpdates();
    }

    @When("I check the accessibility features")
    public void iCheckTheAccessibilityFeatures() {
        verifyAccessibilityFeatures();
    }

    @Then("the product details are accessible to screen readers")
    public void theProductDetailsAreAccessibleToScreenReaders() {
        verifyScreenReaderAccessibility();
    }

    @When("I check for notifications triggered by product details")
    public void iCheckForNotificationsTriggeredByProductDetails() {
        verifyNotificationTriggers();
    }

    @Then("no unexpected notifications are triggered")
    public void noUnexpectedNotificationsAreTriggered() {
        verifyNoUnexpectedNotifications();
    }

    @Given("I have access to the search functionality")
    public void iHaveAccessToTheSearchFunctionality() {
        accessSearchFunctionality();
    }

    @When("I search for the product with ID {int}")
    public void iSearchForTheProductWithID(int productId) {
        searchProductById(productId);
    }

    @Then("the search results display correct product details")
    public void theSearchResultsDisplayCorrectProductDetails() {
        verifySearchResults();
    }
}