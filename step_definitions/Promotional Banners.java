package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PromotionalBannersSteps extends PromotionalBannersPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the promotional banners are loaded")
    public void thePromotionalBannersAreLoaded() {
        waitForBannersToLoad();
    }

    @Then("the banners should display current sales information")
    public void theBannersShouldDisplayCurrentSalesInformation() {
        verifySalesInformationDisplayed();
    }

    @Then("the banners should display current discount information")
    public void theBannersShouldDisplayCurrentDiscountInformation() {
        verifyDiscountInformationDisplayed();
    }

    @Then("the banners should be visible to the user")
    public void theBannersShouldBeVisibleToTheUser() {
        verifyBannersVisibility();
    }

    @Then("the banners should be designed to attract user interest")
    public void theBannersShouldBeDesignedToAttractUserInterest() {
        verifyBannersDesign();
    }

    @When("a new promotion is active")
    public void aNewPromotionIsActive() {
        activateNewPromotion();
    }

    @Then("the promotional banners should update to reflect the new promotion")
    public void thePromotionalBannersShouldUpdateToReflectTheNewPromotion() {
        verifyBannersUpdate();
    }

    @When("the user clicks on a promotional banner")
    public void theUserClicksOnAPromotionalBanner() {
        clickPromotionalBanner();
    }

    @Then("the user should be directed to the relevant sales page")
    public void theUserShouldBeDirectedToTheRelevantSalesPage() {
        verifyRedirectionToSalesPage();
    }

    @Then("there should be no loading errors")
    public void thereShouldBeNoLoadingErrors() {
        verifyNoLoadingErrors();
    }

    @When("the promotional banners are viewed on different devices")
    public void thePromotionalBannersAreViewedOnDifferentDevices() {
        viewBannersOnDifferentDevices();
    }

    @Then("the banners should display correctly on all devices")
    public void theBannersShouldDisplayCorrectlyOnAllDevices() {
        verifyResponsiveDesign();
    }
}