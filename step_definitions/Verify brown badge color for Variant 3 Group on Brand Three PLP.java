package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BadgeColorSteps extends BrandThreePLPPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have access to the Brand Three Product Listing Page (PLP)")
    public void iHaveAccessToTheBrandThreePLP() {
        String brandThreePLPURL = testHarness.getData("PLPData", "BrandThreePLPURL");
        navigateToPage(brandThreePLPURL);
    }

    @When("I navigate to the Brand Three PLP")
    public void iNavigateToTheBrandThreePLP() {
        verifyPLPDisplayed();
    }

    @Then("the Brand Three PLP is displayed")
    public void theBrandThreePLPIsDisplayed() {
        verifyPLPDisplayed();
    }

    @Given("Variant 3 Group data is available")
    public void variant3GroupDataIsAvailable() {
        loadVariant3GroupData();
    }

    @When("I identify a product belonging to the Variant 3 Group")
    public void iIdentifyAProductBelongingToVariant3Group() {
        identifyVariant3GroupProduct();
    }

    @Then("the product is identified as part of the Variant 3 Group")
    public void theProductIsIdentifiedAsPartOfVariant3Group() {
        verifyProductIsVariant3Group();
    }

    @When("I inspect the badge color displayed on the product")
    public void iInspectTheBadgeColorDisplayedOnTheProduct() {
        inspectBadgeColor();
    }

    @Then("the badge color is displayed as brown")
    public void theBadgeColorIsDisplayedAsBrown() {
        verifyBadgeColorIsBrown();
    }

    @When("I verify the badge color consistency across multiple Variant 3 Group products")
    public void iVerifyBadgeColorConsistencyAcrossMultipleProducts() {
        verifyBadgeColorConsistency();
    }

    @Then("all Variant 3 Group products display a brown badge")
    public void allVariant3GroupProductsDisplayABrownBadge() {
        verifyAllProductsHaveBrownBadge();
    }

    @When("I check the badge color in different browsers \(e.g., Chrome, Firefox, Safari\)")
    public void iCheckBadgeColorInDifferentBrowsers() {
        checkBadgeColorInDifferentBrowsers();
    }

    @Then("the badge color remains brown across different browsers")
    public void theBadgeColorRemainsBrownAcrossDifferentBrowsers() {
        verifyBadgeColorAcrossBrowsers();
    }

    @When("I test the badge color on different devices \(e.g., desktop, mobile, tablet\)")
    public void iTestBadgeColorOnDifferentDevices() {
        testBadgeColorOnDifferentDevices();
    }

    @Then("the badge color remains brown across different devices")
    public void theBadgeColorRemainsBrownAcrossDifferentDevices() {
        verifyBadgeColorAcrossDevices();
    }

    @When("I refresh the page and verify the badge color again")
    public void iRefreshThePageAndVerifyBadgeColorAgain() {
        refreshPageAndVerifyBadgeColor();
    }

    @Then("the badge color remains brown after refreshing the page")
    public void theBadgeColorRemainsBrownAfterRefreshingThePage() {
        verifyBadgeColorAfterRefresh();
    }

    @When("I clear the browser cache and cookies, then reload the page")
    public void iClearCacheAndCookiesThenReloadPage() {
        clearCacheAndCookies();
        reloadPage();
    }

    @Then("the badge color remains brown after clearing cache and cookies")
    public void theBadgeColorRemainsBrownAfterClearingCacheAndCookies() {
        verifyBadgeColorAfterClearingCache();
    }

    @When("I check the badge color with different screen resolutions")
    public void iCheckBadgeColorWithDifferentScreenResolutions() {
        checkBadgeColorWithDifferentResolutions();
    }

    @Then("the badge color remains brown across different screen resolutions")
    public void theBadgeColorRemainsBrownAcrossDifferentScreenResolutions() {
        verifyBadgeColorAcrossResolutions();
    }

    @When("I inspect the badge color with different network speeds \(e.g., 3G, 4G, Wi-Fi\)")
    public void iInspectBadgeColorWithDifferentNetworkSpeeds() {
        inspectBadgeColorWithDifferentNetworkSpeeds();
    }

    @Then("the badge color remains brown regardless of network speed")
    public void theBadgeColorRemainsBrownRegardlessOfNetworkSpeed() {
        verifyBadgeColorAcrossNetworkSpeeds();
    }

    @When("I verify the badge color in incognito or private browsing mode")
    public void iVerifyBadgeColorInIncognitoMode() {
        verifyBadgeColorInIncognitoMode();
    }

    @Then("the badge color remains brown in incognito or private browsing mode")
    public void theBadgeColorRemainsBrownInIncognitoMode() {
        verifyBadgeColorInIncognitoMode();
    }

    @When("I check the badge color with browser extensions enabled and disabled")
    public void iCheckBadgeColorWithExtensions() {
        checkBadgeColorWithExtensions();
    }

    @Then("the badge color remains brown regardless of browser extensions")
    public void theBadgeColorRemainsBrownRegardlessOfExtensions() {
        verifyBadgeColorWithExtensions();
    }

    @When("I test the badge color with different operating systems \(e.g., Windows, macOS, Linux\)")
    public void iTestBadgeColorWithDifferentOS() {
        testBadgeColorWithDifferentOS();
    }

    @Then("the badge color remains brown across different operating systems")
    public void theBadgeColorRemainsBrownAcrossDifferentOS() {
        verifyBadgeColorAcrossOS();
    }

    @When("I inspect the badge color with various browser zoom levels \(e.g., 100%, 125%, 150%\)")
    public void iInspectBadgeColorWithZoomLevels() {
        inspectBadgeColorWithZoomLevels();
    }

    @Then("the badge color remains brown across various zoom levels")
    public void theBadgeColorRemainsBrownAcrossZoomLevels() {
        verifyBadgeColorAcrossZoomLevels();
    }

    @When("I verify the badge color with different user roles or permissions")
    public void iVerifyBadgeColorWithUserRoles() {
        verifyBadgeColorWithUserRoles();
    }

    @Then("the badge color remains brown regardless of user roles or permissions")
    public void theBadgeColorRemainsBrownRegardlessOfUserRoles() {
        verifyBadgeColorWithUserRoles();
    }
}