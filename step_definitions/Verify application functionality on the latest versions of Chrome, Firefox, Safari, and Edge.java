package com.cucumber.steps;

import com.page_objects.BrowserTestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrowserTestSteps extends BrowserTestPage {

    @Given("the latest version of Chrome 90 is installed")
    public void theLatestVersionOfChrome90IsInstalled() {
        verifyChromeInstallation();
    }

    @When("the user opens the web platform on Chrome 90")
    public void theUserOpensTheWebPlatformOnChrome90() {
        openWebPlatformOnChrome();
    }

    @Then("the web platform loads correctly without any display issues")
    public void theWebPlatformLoadsCorrectlyWithoutAnyDisplayIssues() {
        verifyPlatformLoad();
    }

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        verifyUserCredentials();
    }

    @When("the user logs in on Chrome 90")
    public void theUserLogsInOnChrome90() {
        loginUserOnChrome();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifySuccessfulLogin();
    }

    @Then("the Order ID is ORD54321")
    public void theOrderIDIsORD54321() {
        verifyOrderID("ORD54321");
    }

    @Given("the user is logged in on Chrome 90")
    public void theUserIsLoggedInOnChrome90() {
        verifyUserLoggedInOnChrome();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history page is displayed correctly")
    public void theOrderHistoryPageIsDisplayedCorrectly() {
        verifyOrderHistoryPage();
    }

    @Then("the User Account is user_browser@example.com")
    public void theUserAccountIsUserBrowserExampleCom() {
        verifyUserAccount("user_browser@example.com");
    }

    @Given("the latest version of {string} is installed")
    public void theLatestVersionOfBrowserIsInstalled(String browser) {
        verifyBrowserInstallation(browser);
    }

    @When("the user repeats steps 1-3 on {string}")
    public void theUserRepeatsStepsOnBrowser(String browser) {
        repeatStepsOnBrowser(browser);
    }

    @Then("the web platform functions correctly on {string}")
    public void theWebPlatformFunctionsCorrectlyOnBrowser(String browser) {
        verifyPlatformFunctionality(browser);
    }

    @Given("the user is logged in on any browser")
    public void theUserIsLoggedInOnAnyBrowser() {
        verifyUserLoggedInOnAnyBrowser();
    }

    @When("the user checks for order status updates")
    public void theUserChecksForOrderStatusUpdates() {
        checkOrderStatusUpdates();
    }

    @Then("the order status updates are consistent across all browsers")
    public void theOrderStatusUpdatesAreConsistentAcrossAllBrowsers() {
        verifyOrderStatusConsistency();
    }

    @When("the user checks for display issues or errors")
    public void theUserChecksForDisplayIssuesOrErrors() {
        checkDisplayIssuesOrErrors();
    }

    @Then("no display issues or errors are encountered on any browser")
    public void noDisplayIssuesOrErrorsAreEncounteredOnAnyBrowser() {
        verifyNoDisplayIssuesOrErrors();
    }

    @When("the user tests responsiveness and performance")
    public void theUserTestsResponsivenessAndPerformance() {
        testResponsivenessAndPerformance();
    }

    @Then("the web platform is responsive and performs well on each browser")
    public void theWebPlatformIsResponsiveAndPerformsWellOnEachBrowser() {
        verifyResponsivenessAndPerformance();
    }

    @When("the user checks for notifications of order status updates")
    public void theUserChecksForNotificationsOfOrderStatusUpdates() {
        checkOrderStatusNotifications();
    }

    @Then("users receive notifications for order status updates on each browser")
    public void usersReceiveNotificationsForOrderStatusUpdatesOnEachBrowser() {
        verifyOrderStatusNotifications();
    }

    @When("the user checks system logs for errors")
    public void theUserChecksSystemLogsForErrors() {
        checkSystemLogsForErrors();
    }

    @Then("no browser-specific errors are logged in the system")
    public void noBrowserSpecificErrorsAreLoggedInTheSystem() {
        verifyNoBrowserSpecificErrors();
    }

    @When("the user assesses the user experience")
    public void theUserAssessesTheUserExperience() {
        assessUserExperience();
    }

    @Then("user experience is consistent and satisfactory on each browser")
    public void userExperienceIsConsistentAndSatisfactoryOnEachBrowser() {
        verifyUserExperienceConsistency();
    }

    @When("the user checks compatibility with browser extensions")
    public void theUserChecksCompatibilityWithBrowserExtensions() {
        checkBrowserExtensionsCompatibility();
    }

    @Then("the web platform remains compatible with common browser extensions")
    public void theWebPlatformRemainsCompatibleWithCommonBrowserExtensions() {
        verifyBrowserExtensionsCompatibility();
    }

    @When("the user tests accessibility features")
    public void theUserTestsAccessibilityFeatures() {
        testAccessibilityFeatures();
    }

    @Then("accessibility features function correctly on each browser")
    public void accessibilityFeaturesFunctionCorrectlyOnEachBrowser() {
        verifyAccessibilityFeaturesFunctionality();
    }

    @When("the user logs out from the web platform")
    public void theUserLogsOutFromTheWebPlatform() {
        logoutFromWebPlatform();
    }

    @Then("the user is successfully logged out from the web platform on each browser")
    public void theUserIsSuccessfullyLoggedOutFromTheWebPlatformOnEachBrowser() {
        verifySuccessfulLogout();
    }
}