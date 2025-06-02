package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.page_objects.FilterPage;

public class FilterSteps extends FilterPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I open the application in a desktop browser")
    public void iOpenTheApplicationInADesktopBrowser() {
        launchApplicationOnDesktop();
    }

    @Then("the application should load successfully")
    public void theApplicationShouldLoadSuccessfully() {
        verifyApplicationLoad();
    }

    @Given("I navigate to the product listing page on a desktop browser")
    public void iNavigateToTheProductListingPageOnADesktopBrowser() {
        navigateToProductListingPageOnDesktop();
    }

    @Then("the product listing page should display correctly")
    public void theProductListingPageShouldDisplayCorrectly() {
        verifyProductListingPageDisplay();
    }

    @Given("I locate the filter section on the desktop interface")
    public void iLocateTheFilterSectionOnTheDesktopInterface() {
        locateFilterSectionOnDesktop();
    }

    @Then("filters should be visible and clearly labeled")
    public void filtersShouldBeVisibleAndClearlyLabeled() {
        verifyFiltersVisibilityAndLabeling();
    }

    @Given("I access the application on a mobile browser")
    public void iAccessTheApplicationOnAMobileBrowser() {
        launchApplicationOnMobile();
    }

    @Then("the application should load successfully on mobile")
    public void theApplicationShouldLoadSuccessfullyOnMobile() {
        verifyApplicationLoadOnMobile();
    }

    @Given("I navigate to the product listing page on mobile")
    public void iNavigateToTheProductListingPageOnMobile() {
        navigateToProductListingPageOnMobile();
    }

    @Then("the product listing page should display correctly on mobile")
    public void theProductListingPageShouldDisplayCorrectlyOnMobile() {
        verifyProductListingPageDisplayOnMobile();
    }

    @Given("I locate the filter section on the mobile interface")
    public void iLocateTheFilterSectionOnTheMobileInterface() {
        locateFilterSectionOnMobile();
    }

    @Then("filters should be visible and clearly labeled on mobile")
    public void filtersShouldBeVisibleAndClearlyLabeledOnMobile() {
        verifyFiltersVisibilityAndLabelingOnMobile();
    }

    @Given("I access the filter section")
    public void iAccessTheFilterSection() {
        accessFilterSection();
    }

    @Then("filters should be accessible with one click or tap")
    public void filtersShouldBeAccessibleWithOneClickOrTap() {
        verifyFiltersAccessibility();
    }

    @Given("I resize the browser window on desktop")
    public void iResizeTheBrowserWindowOnDesktop() {
        resizeBrowserWindowOnDesktop();
    }

    @Then("filter labels should adjust correctly to different screen sizes")
    public void filterLabelsShouldAdjustCorrectlyToDifferentScreenSizes() {
        verifyFilterLabelsResponsivenessOnDesktop();
    }

    @Given("I view the filter labels on different mobile screen sizes")
    public void iViewTheFilterLabelsOnDifferentMobileScreenSizes() {
        viewFilterLabelsOnDifferentMobileScreenSizes();
    }

    @Then("filter labels should adjust correctly on different mobile screen sizes")
    public void filterLabelsShouldAdjustCorrectlyOnDifferentMobileScreenSizes() {
        verifyFilterLabelsResponsivenessOnMobile();
    }

    @Given("I use keyboard shortcuts to access filters on desktop")
    public void iUseKeyboardShortcutsToAccessFiltersOnDesktop() {
        useKeyboardShortcutsForFiltersOnDesktop();
    }

    @Then("filters should be accessible using keyboard shortcuts")
    public void filtersShouldBeAccessibleUsingKeyboardShortcuts() {
        verifyFiltersAccessibilityWithKeyboard();
    }

    @Given("I use voice commands to access filters on mobile")
    public void iUseVoiceCommandsToAccessFiltersOnMobile() {
        useVoiceCommandsForFiltersOnMobile();
    }

    @Then("filters should be accessible using voice commands")
    public void filtersShouldBeAccessibleUsingVoiceCommands() {
        verifyFiltersAccessibilityWithVoiceCommands();
    }

    @Given("I view the filter labels")
    public void iViewTheFilterLabels() {
        viewFilterLabels();
    }

    @Then("filter labels should not overlap with other UI elements")
    public void filterLabelsShouldNotOverlapWithOtherUIElements() {
        verifyFilterLabelsNoOverlap();
    }

    @Given("I check the filter labels in different lighting conditions on mobile")
    public void iCheckTheFilterLabelsInDifferentLightingConditionsOnMobile() {
        checkFilterLabelsInDifferentLightingConditionsOnMobile();
    }

    @Then("filter labels should be readable in different lighting conditions")
    public void filterLabelsShouldBeReadableInDifferentLightingConditions() {
        verifyFilterLabelsReadabilityInLightingConditions();
    }

    @Given("I apply filters on both platforms")
    public void iApplyFiltersOnBothPlatforms() {
        applyFiltersOnBothPlatforms();
    }

    @Then("filters should be applied correctly on both desktop and mobile")
    public void filtersShouldBeAppliedCorrectlyOnBothDesktopAndMobile() {
        verifyFiltersAppliedCorrectly();
    }

    @Given("I reset the filters after application")
    public void iResetTheFiltersAfterApplication() {
        resetFiltersAfterApplication();
    }

    @Then("filters should reset correctly after application")
    public void filtersShouldResetCorrectlyAfterApplication() {
        verifyFiltersResetCorrectly();
    }
}