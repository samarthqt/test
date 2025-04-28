package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BadgeColorSteps extends BrandTwoPLPPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has access to Brand Two PLP")
    public void theUserHasAccessToBrandTwoPLP() {
        navigateToBrandTwoPLP();
    }

    @Given("the Control Group badge color settings are configured to black")
    public void theControlGroupBadgeColorSettingsAreConfiguredToBlack() {
        configureBadgeColorToBlack();
    }

    @When("the user navigates to the Brand Two PLP")
    public void theUserNavigatesToTheBrandTwoPLP() {
        navigateToBrandTwoPLP();
    }

    @Then("the Brand Two PLP is displayed")
    public void theBrandTwoPLPIsDisplayed() {
        verifyPLPDisplayed();
    }

    @Given("the user is on the Brand Two PLP")
    public void theUserIsOnTheBrandTwoPLP() {
        navigateToBrandTwoPLP();
    }

    @When("the user identifies a product listed under the Control Group")
    public void theUserIdentifiesAProductListedUnderTheControlGroup() {
        identifyControlGroupProduct();
    }

    @Then("a product from the Control Group is identified")
    public void aProductFromTheControlGroupIsIdentified() {
        verifyControlGroupProductIdentified();
    }

    @When("the user checks the badge color")
    public void theUserChecksTheBadgeColor() {
        checkBadgeColor();
    }

    @Then("the badge color is black")
    public void theBadgeColorIsBlack() {
        verifyBadgeColorIsBlack();
    }

    @When("the user scrolls through the PLP")
    public void theUserScrollsThroughThePLP() {
        scrollThroughPLP();
    }

    @Then("the badge color remains black")
    public void theBadgeColorRemainsBlack() {
        verifyBadgeColorRemainsBlack();
    }

    @When("the user refreshes the Brand Two PLP")
    public void theUserRefreshesTheBrandTwoPLP() {
        refreshPLP();
    }

    @When("the user switches to a different category and switches back to the Control Group category")
    public void theUserSwitchesToADifferentCategoryAndSwitchesBackToTheControlGroupCategory() {
        switchCategoriesAndReturn();
    }

    @When("the user checks the badge color on different screen resolutions")
    public void theUserChecksTheBadgeColorOnDifferentScreenResolutions() {
        checkBadgeColorOnDifferentResolutions();
    }

    @When("the user inspects the badge color using browser developer tools")
    public void theUserInspectsTheBadgeColorUsingBrowserDeveloperTools() {
        inspectBadgeColorWithDevTools();
    }

    @Then("the badge color CSS property is set to black")
    public void theBadgeColorCSSPropertyIsSetToBlack() {
        verifyBadgeColorCSSProperty();
    }

    @When("the user verifies the badge color with different browser zoom levels")
    public void theUserVerifiesTheBadgeColorWithDifferentBrowserZoomLevels() {
        verifyBadgeColorWithZoomLevels();
    }

    @When("the user performs a search for a Control Group product")
    public void theUserPerformsASearchForAControlGroupProduct() {
        searchForControlGroupProduct();
    }

    @Then("the badge color is black for search results")
    public void theBadgeColorIsBlackForSearchResults() {
        verifyBadgeColorForSearchResults();
    }

    @When("the user checks the badge color on a mobile device")
    public void theUserChecksTheBadgeColorOnAMobileDevice() {
        checkBadgeColorOnMobile();
    }

    @Then("the badge color is black on mobile devices")
    public void theBadgeColorIsBlackOnMobileDevices() {
        verifyBadgeColorOnMobile();
    }

    @When("the user clears browser cache and cookies, then reloads the PLP")
    public void theUserClearsBrowserCacheAndCookiesThenReloadsThePLP() {
        clearCacheAndReloadPLP();
    }

    @When("the user verifies the badge color using a different browser")
    public void theUserVerifiesTheBadgeColorUsingADifferentBrowser() {
        verifyBadgeColorOnDifferentBrowser();
    }

    @When("the user checks the badge color with different user roles")
    public void theUserChecksTheBadgeColorWithDifferentUserRoles() {
        checkBadgeColorWithUserRoles();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }
}