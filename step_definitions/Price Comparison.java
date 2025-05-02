package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceComparisonSteps extends ComparisonPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am on the product listing page")
    public void iAmOnTheProductListingPage() {
        navigateToProductListingPage();
    }

    @When("I select two similar products for comparison")
    public void iSelectTwoSimilarProductsForComparison() {
        selectProductsForComparison(2);
    }

    @Then("I should see a comparison chart with product details including price, features, and specifications")
    public void iShouldSeeAComparisonChartWithProductDetails() {
        verifyComparisonChartDetails();
    }

    @When("I select more than two similar products for comparison")
    public void iSelectMoreThanTwoSimilarProductsForComparison() {
        selectProductsForComparison(3);
    }

    @Then("I should see a comparison chart with all selected product details including price, features, and specifications")
    public void iShouldSeeAComparisonChartWithAllSelectedProductDetails() {
        verifyComparisonChartDetails();
    }

    @When("I select products from different categories for comparison")
    public void iSelectProductsFromDifferentCategoriesForComparison() {
        selectDifferentCategoryProductsForComparison();
    }

    @Then("I should see a message indicating that only similar products can be compared")
    public void iShouldSeeAMessageIndicatingOnlySimilarProductsCanBeCompared() {
        verifyComparisonRestrictionMessage();
    }

    @Given("I have a comparison chart with multiple products")
    public void iHaveAComparisonChartWithMultipleProducts() {
        ensureComparisonChartHasMultipleProducts();
    }

    @When("I remove a product from the comparison")
    public void iRemoveAProductFromTheComparison() {
        removeProductFromComparison();
    }

    @Then("the comparison chart should update to reflect the remaining products")
    public void theComparisonChartShouldUpdateToReflectRemainingProducts() {
        verifyUpdatedComparisonChart();
    }

    @Given("I have a comparison chart with some products")
    public void iHaveAComparisonChartWithSomeProducts() {
        ensureComparisonChartHasSomeProducts();
    }

    @When("I add another similar product to the comparison")
    public void iAddAnotherSimilarProductToTheComparison() {
        addProductToComparison();
    }

    @Then("the comparison chart should update to include the new product with all its details")
    public void theComparisonChartShouldUpdateToIncludeNewProductDetails() {
        verifyUpdatedComparisonChartWithNewProduct();
    }

    @When("I select a specific feature for detailed comparison")
    public void iSelectASpecificFeatureForDetailedComparison() {
        selectFeatureForDetailedComparison();
    }

    @Then("I should see a detailed view highlighting the differences of the selected feature across the products")
    public void iShouldSeeADetailedViewHighlightingFeatureDifferences() {
        verifyDetailedFeatureComparisonView();
    }

    @Given("I am on a specific product page")
    public void iAmOnASpecificProductPage() {
        navigateToSpecificProductPage();
    }

    @When("I choose to compare the product with similar ones")
    public void iChooseToCompareProductWithSimilarOnes() {
        chooseProductComparison();
    }

    @Then("I should be redirected to a comparison page with the selected product and similar options")
    public void iShouldBeRedirectedToComparisonPage() {
        verifyRedirectionToComparisonPage();
    }

    @Given("I have a comparison chart with selected products")
    public void iHaveAComparisonChartWithSelectedProducts() {
        ensureComparisonChartHasSelectedProducts();
    }

    @When("I choose to save the comparison")
    public void iChooseToSaveTheComparison() {
        saveComparison();
    }

    @Then("the comparison should be saved under my account for future reference")
    public void theComparisonShouldBeSavedForFutureReference() {
        verifyComparisonSaved();
    }

    @When("I choose to share the comparison")
    public void iChooseToShareTheComparison() {
        shareComparison();
    }

    @Then("I should be able to share the comparison via email or social media platforms")
    public void iShouldBeAbleToShareComparison() {
        verifyComparisonSharingOptions();
    }
}