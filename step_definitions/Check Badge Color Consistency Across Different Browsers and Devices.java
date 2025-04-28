package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BadgeColorConsistencySteps extends BrandTwoPLPPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have access to Brand Two PLP")
    public void iHaveAccessToBrandTwoPLP() {
        String brandTwoPLPURL = testHarness.getData("PLPData", "BrandTwoPLPURL");
        navigateToPage(brandTwoPLPURL);
    }

    @Given("different browsers and devices are available for testing")
    public void differentBrowsersAndDevicesAreAvailableForTesting() {
        // Setup for different browsers and devices
    }

    @When("I navigate to the Brand Two PLP using {string}")
    public void iNavigateToTheBrandTwoPLPUsing(String browserOrDevice) {
        navigateToPLPUsing(browserOrDevice);
    }

    @Then("the Brand Two PLP is displayed on {string}")
    public void theBrandTwoPLPIsDisplayedOn(String browserOrDevice) {
        verifyPLPDisplayed(browserOrDevice);
    }

    @When("I identify a product with a badge on {string}")
    public void iIdentifyAProductWithABadgeOn(String browserOrDevice) {
        identifyProductWithBadge(browserOrDevice);
    }

    @Then("a product with a badge is identified on {string}")
    public void aProductWithABadgeIsIdentifiedOn(String browserOrDevice) {
        verifyProductWithBadgeIdentified(browserOrDevice);
    }

    @When("I verify the badge color on {string}")
    public void iVerifyTheBadgeColorOn(String browserOrDevice) {
        verifyBadgeColor(browserOrDevice);
    }

    @Then("the badge color is correct on {string}")
    public void theBadgeColorIsCorrectOn(String browserOrDevice) {
        verifyCorrectBadgeColor(browserOrDevice);
    }

    @When("I compare badge color consistency between {string} and {string}")
    public void iCompareBadgeColorConsistencyBetween(String firstBrowserOrDevice, String secondBrowserOrDevice) {
        compareBadgeColorConsistency(firstBrowserOrDevice, secondBrowserOrDevice);
    }

    @Then("the badge color remains consistent between {string}")
    public void theBadgeColorRemainsConsistentBetween(String browsersOrDevices) {
        verifyBadgeColorConsistency(browsersOrDevices);
    }

    @When("I inspect the badge color using browser developer tools on each browser")
    public void iInspectTheBadgeColorUsingBrowserDeveloperToolsOnEachBrowser() {
        inspectBadgeColorUsingDevTools();
    }

    @Then("the badge color CSS property is consistent across browsers")
    public void theBadgeColorCSSPropertyIsConsistentAcrossBrowsers() {
        verifyBadgeColorCSSConsistency();
    }
}