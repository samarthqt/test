package com.cucumber.steps;

import com.page_objects.OrderHistoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderHistorySteps extends OrderHistoryPage {

    @Given("a user account exists with User ID {int} and no past orders")
    public void aUserAccountExistsWithUserIDAndNoPastOrders(int userId) {
        verifyUserAccountExists(userId);
    }

    @When("the user logs in using valid credentials")
    public void theUserLogsInUsingValidCredentials() {
        loginWithValidCredentials();
    }

    @Then("the user successfully logs into the account")
    public void theUserSuccessfullyLogsIntoTheAccount() {
        verifySuccessfulLogin();
    }

    @Then("the account status is active")
    public void theAccountStatusIsActive() {
        verifyAccountStatusActive();
    }

    @When("the user navigates to the 'Order History' section in the user dashboard")
    public void theUserNavigatesToTheOrderHistorySectionInTheUserDashboard() {
        navigateToOrderHistorySection();
    }

    @Then("the user is directed to the 'Order History' page")
    public void theUserIsDirectedToTheOrderHistoryPage() {
        verifyOrderHistoryPageNavigation();
    }

    @Then("no orders are listed")
    public void noOrdersAreListed() {
        verifyNoOrdersListed();
    }

    @Then("a message indicating no past orders is displayed")
    public void aMessageIndicatingNoPastOrdersIsDisplayed() {
        verifyNoPastOrdersMessageDisplayed();
    }

    @Then("the presence of filters or search options is verified")
    public void thePresenceOfFiltersOrSearchOptionsIsVerified() {
        verifyFiltersOrSearchOptionsPresence();
    }

    @Then("the filters or search options are present but disabled or non-functional due to no data")
    public void theFiltersOrSearchOptionsArePresentButDisabledOrNonFunctionalDueToNoData() {
        verifyFiltersOrSearchOptionsDisabled();
    }

    @Then("any links or buttons suggesting placing a new order are checked")
    public void anyLinksOrButtonsSuggestingPlacingANewOrderAreChecked() {
        verifyNewOrderLinkOrButton();
    }

    @Then("a link or button is available to guide the user to place a new order")
    public void aLinkOrButtonIsAvailableToGuideTheUserToPlaceANewOrder() {
        verifyNewOrderGuidanceLinkOrButton();
    }

    @When("the user attempts to refresh the page")
    public void theUserAttemptsToRefreshThePage() {
        refreshOrderHistoryPage();
    }

    @Then("the page refreshes with the same message indicating no past orders")
    public void thePageRefreshesWithTheSameMessageIndicatingNoPastOrders() {
        verifyPageRefreshNoPastOrdersMessage();
    }

    @Then("the page is inspected for any error messages or system notifications")
    public void thePageIsInspectedForAnyErrorMessagesOrSystemNotifications() {
        verifyNoErrorMessagesOrNotifications();
    }

    @Then("no error messages or system notifications are present")
    public void noErrorMessagesOrSystemNotificationsArePresent() {
        verifyNoErrorMessagesOrNotifications();
    }

    @Then("the page layout and design are checked for consistency and clarity")
    public void thePageLayoutAndDesignAreCheckedForConsistencyAndClarity() {
        verifyPageLayoutAndDesignConsistency();
    }

    @Then("the page layout is consistent and design is clear with appropriate spacing and alignment")
    public void thePageLayoutIsConsistentAndDesignIsClearWithAppropriateSpacingAndAlignment() {
        verifyPageLayoutAndDesignConsistency();
    }

    @When("the user attempts to navigate back to the main dashboard from the 'Order History' page")
    public void theUserAttemptsToNavigateBackToTheMainDashboardFromTheOrderHistoryPage() {
        navigateBackToMainDashboard();
    }

    @Then("the user can easily navigate back to the main dashboard")
    public void theUserCanEasilyNavigateBackToTheMainDashboard() {
        verifyNavigationBackToMainDashboard();
    }

    @When("the user attempts to access the 'Order History' page directly via URL manipulation")
    public void theUserAttemptsToAccessTheOrderHistoryPageDirectlyViaURLManipulation() {
        accessOrderHistoryPageViaURLManipulation();
    }

    @Then("the user is redirected to the login page or main dashboard if not authenticated")
    public void theUserIsRedirectedToTheLoginPageOrMainDashboardIfNotAuthenticated() {
        verifyRedirectionToLoginOrDashboard();
    }

    @Then("the availability of help or support links on the 'Order History' page is checked")
    public void theAvailabilityOfHelpOrSupportLinksOnTheOrderHistoryPageIsChecked() {
        verifyHelpOrSupportLinksAvailability();
    }

    @Then("help or support links are present and functional")
    public void helpOrSupportLinksArePresentAndFunctional() {
        verifyHelpOrSupportLinksFunctionality();
    }

    @Then("the page is reviewed for any promotional content or offers")
    public void thePageIsReviewedForAnyPromotionalContentOrOffers() {
        verifyPromotionalContentOrOffers();
    }

    @Then("relevant promotional content or offers are displayed if applicable")
    public void relevantPromotionalContentOrOffersAreDisplayedIfApplicable() {
        verifyPromotionalContentOrOffers();
    }

    @Then("the responsiveness of the 'Order History' page on different devices is verified")
    public void theResponsivenessOfTheOrderHistoryPageOnDifferentDevicesIsVerified() {
        verifyPageResponsivenessOnDevices();
    }

    @Then("the page is responsive and displays correctly on various devices")
    public void thePageIsResponsiveAndDisplaysCorrectlyOnVariousDevices() {
        verifyPageResponsivenessOnDevices();
    }

    @Then("the browser compatibility of the 'Order History' page is checked")
    public void theBrowserCompatibilityOfTheOrderHistoryPageIsChecked() {
        verifyBrowserCompatibility();
    }

    @Then("the page functions correctly on all supported browsers")
    public void thePageFunctionsCorrectlyOnAllSupportedBrowsers() {
        verifyBrowserCompatibility();
    }

    @When("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        logout();
    }

    @Then("the user is successfully logged out and redirected to the login page")
    public void theUserIsSuccessfullyLoggedOutAndRedirectedToTheLoginPage() {
        verifySuccessfulLogout();
    }
}