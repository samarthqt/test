package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ProductDetailPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class HighResolutionImageSteps extends ProductDetailPage {

    @Given("the user navigates to the 'Camera B' product detail page")
    public void theUserNavigatesToTheCameraBProductDetailPage() {
        navigateToProductDetailPage("Camera B");
    }

    @Then("the product detail page is displayed")
    public void theProductDetailPageIsDisplayed() {
        verifyProductDetailPageDisplayed();
    }

    @When("the user selects the product image to view in high resolution")
    public void theUserSelectsTheProductImageToViewInHighResolution() {
        selectProductImageForHighResolution();
    }

    @Then("the high-resolution image is displayed and can be zoomed in")
    public void theHighResolutionImageIsDisplayedAndCanBeZoomedIn() {
        verifyHighResolutionImageDisplayed();
        verifyImageCanBeZoomedIn();
    }
}