package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuScreenSteps extends MenuPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @Given("multiple locations are configured in the system")
    public void multipleLocationsAreConfiguredInTheSystem() {
        verifyMultipleLocationsConfigured();
    }

    @When("the user navigates to the location selection screen")
    public void theUserNavigatesToTheLocationSelectionScreen() {
        navigateToLocationSelectionScreen();
    }

    @Then("the location selection screen is displayed")
    public void theLocationSelectionScreenIsDisplayed() {
        verifyLocationSelectionScreenDisplayed();
    }

    @When("the user selects {string} from the list")
    public void theUserSelectsLocationFromTheList(String location) {
        selectLocationFromList(location);
    }

    @When("confirms the selection")
    public void confirmsTheSelection() {
        confirmLocationSelection();
    }

    @Then("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @Then("the Menu screen for {string} is displayed")
    public void theMenuScreenForLocationIsDisplayed(String location) {
        verifyMenuScreenForLocation(location);
    }

    @Then("the menu items correspond to the selected location")
    public void theMenuItemsCorrespondToTheSelectedLocation() {
        verifyMenuItemsCorrespondToLocation();
    }

    @Then("the layout and design are consistent with the selected location")
    public void theLayoutAndDesignAreConsistentWithTheSelectedLocation() {
        verifyLayoutAndDesignConsistency();
    }

    @Then("all buttons and links work as expected")
    public void allButtonsAndLinksWorkAsExpected() {
        verifyButtonsAndLinksFunctionality();
    }

    @Then("the selected location name is displayed on the screen")
    public void theSelectedLocationNameIsDisplayedOnTheScreen() {
        verifySelectedLocationNameDisplayed();
    }

    @Then("no error messages or alerts are shown")
    public void noErrorMessagesOrAlertsAreShown() {
        verifyNoErrorMessagesOrAlerts();
    }

    @Given("the user has selected a location")
    public void theUserHasSelectedALocation() {
        verifyLocationSelected();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLoginAgain();
    }

    @Then("the selected location is persistent after re-login")
    public void theSelectedLocationIsPersistentAfterReLogin() {
        verifyLocationPersistenceAfterReLogin();
    }

    @When("the user changes the location")
    public void theUserChangesTheLocation() {
        changeLocation();
    }

    @Then("the Menu screen updates according to the new location")
    public void theMenuScreenUpdatesAccordingToTheNewLocation() {
        verifyMenuScreenUpdatesForNewLocation();
    }

    @Given("the user selects a location with no specific menu")
    public void theUserSelectsALocationWithNoSpecificMenu() {
        selectLocationWithNoSpecificMenu();
    }

    @Then("a default menu or appropriate message is displayed")
    public void aDefaultMenuOrAppropriateMessageIsDisplayed() {
        verifyDefaultMenuOrMessageDisplayed();
    }

    @Given("the user is on the Menu screen")
    public void theUserIsOnTheMenuScreen() {
        navigateToMenuScreen();
    }

    @Then("accessibility features are present and functional")
    public void accessibilityFeaturesArePresentAndFunctional() {
        verifyAccessibilityFeatures();
    }
}