package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ProductDetailPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class OutOfStockSteps extends ProductDetailPage {

    @Given("the user navigates to the {string} product detail page")
    public void theUserNavigatesToTheProductDetailPage(String productName) {
        navigateToProductDetailPage(productName);
    }

    @Then("the product detail page is displayed")
    public void theProductDetailPageIsDisplayed() {
        verifyProductDetailPageDisplayed();
    }

    @Then("the user checks for the out-of-stock label")
    public void theUserChecksForTheOutOfStockLabel() {
        checkOutOfStockLabel();
    }

    @Then("the out-of-stock label is displayed prominently")
    public void theOutOfStockLabelIsDisplayedProminently() {
        verifyOutOfStockLabelDisplayed();
    }
}