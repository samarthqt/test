package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AccountDashboardPage;

public class OrderTrackingSteps extends AccountDashboardPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid login credentials")
    public void theUserHasValidLoginCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(username);
        enterPassword(password);
    }

    @When("the user logs into the application")
    public void theUserLogsIntoTheApplication() {
        clickLoginButton();
    }

    @Then("the user is successfully logged into the application")
    public void theUserIsSuccessfullyLoggedIntoTheApplication() {
        verifyHomePageRedirection(testHarness.getData("LoginData", "ExpectedHomePageURL"));
    }

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        theUserHasValidLoginCredentials();
        theUserLogsIntoTheApplication();
    }

    @When("the user navigates to the account dashboard")
    public void theUserNavigatesToTheAccountDashboard() {
        navigateToAccountDashboard();
    }

    @Then("the account dashboard is displayed with user information")
    public void theAccountDashboardIsDisplayedWithUserInformation() {
        verifyAccountDashboardDisplayed();
    }

    @Given("the user is on the account dashboard")
    public void theUserIsOnTheAccountDashboard() {
        theUserIsLoggedIntoTheApplication();
        theUserNavigatesToTheAccountDashboard();
    }

    @When("the user locates the 'Order Tracking' feature on the dashboard")
    public void theUserLocatesTheOrderTrackingFeatureOnTheDashboard() {
        locateOrderTrackingFeature();
    }

    @Then("'Order Tracking' feature is visible on the dashboard")
    public void orderTrackingFeatureIsVisibleOnTheDashboard() {
        verifyOrderTrackingFeatureVisible();
    }

    @Given("the 'Order Tracking' feature is visible on the dashboard")
    public void theOrderTrackingFeatureIsVisibleOnTheDashboard() {
        theUserIsOnTheAccountDashboard();
        theUserLocatesTheOrderTrackingFeatureOnTheDashboard();
    }

    @When("the user clicks on the 'Order Tracking' feature")
    public void theUserClicksOnTheOrderTrackingFeature() {
        clickOrderTrackingFeature();
    }

    @Then("the user is directed to the tracking information page")
    public void theUserIsDirectedToTheTrackingInformationPage() {
        verifyTrackingInformationPage();
    }

    @Given("the user is on the tracking information page")
    public void theUserIsOnTheTrackingInformationPage() {
        theOrderTrackingFeatureIsVisibleOnTheDashboard();
        theUserClicksOnTheOrderTrackingFeature();
    }

    @When("the user views the tracking information")
    public void theUserViewsTheTrackingInformation() {
        viewTrackingInformation();
    }

    @Then("tracking information is displayed accurately from the dashboard")
    public void trackingInformationIsDisplayedAccuratelyFromTheDashboard() {
        verifyTrackingInformationAccuracy();
    }

    @When("the user accesses the 'Order Tracking' feature from different sections")
    public void theUserAccessesTheOrderTrackingFeatureFromDifferentSections() {
        accessOrderTrackingFromDifferentSections();
    }

    @Then("'Order Tracking' feature is accessible from various sections of the dashboard")
    public void orderTrackingFeatureIsAccessibleFromVariousSectionsOfTheDashboard() {
        verifyOrderTrackingAccessibility();
    }

    @Given("the user accesses the 'Order Tracking' feature")
    public void theUserAccessesTheOrderTrackingFeature() {
        theOrderTrackingFeatureIsVisibleOnTheDashboard();
        theUserClicksOnTheOrderTrackingFeature();
    }

    @When("the feature is loading")
    public void theFeatureIsLoading() {
        waitForFeatureToLoad();
    }

    @Then("'Order Tracking' feature is responsive and loads within acceptable time limits")
    public void orderTrackingFeatureIsResponsiveAndLoadsWithinAcceptableTimeLimits() {
        verifyFeatureResponsiveness();
    }

    @Given("there are updates to the tracking information")
    public void thereAreUpdatesToTheTrackingInformation() {
        updateTrackingInformation();
    }

    @When("the user views the tracking information on the dashboard")
    public void theUserViewsTheTrackingInformationOnTheDashboard() {
        viewUpdatedTrackingInformation();
    }

    @Then("tracking information updates are visible on the dashboard")
    public void trackingInformationUpdatesAreVisibleOnTheDashboard() {
        verifyTrackingInformationUpdates();
    }

    @When("the user accesses tracking information")
    public void theUserAccessesTrackingInformation() {
        accessTrackingInformation();
    }

    @Then("the dashboard interface is intuitive and easy to use for accessing tracking information")
    public void theDashboardInterfaceIsIntuitiveAndEasyToUseForAccessingTrackingInformation() {
        verifyDashboardInterface();
    }

    @Given("the user accesses tracking information from the dashboard")
    public void theUserAccessesTrackingInformationFromTheDashboard() {
        theUserIsOnTheAccountDashboard();
        theUserAccessesTrackingInformation();
    }

    @When("checking security measures")
    public void checkingSecurityMeasures() {
        checkSecurityMeasures();
    }

    @Then("security measures are verified for safe access to tracking information from the dashboard")
    public void securityMeasuresAreVerifiedForSafeAccessToTrackingInformationFromTheDashboard() {
        verifySecurityMeasures();
    }

    @Given("there is an unauthorized attempt to access tracking information")
    public void thereIsAnUnauthorizedAttemptToAccessTrackingInformation() {
        simulateUnauthorizedAccessAttempt();
    }

    @When("the system detects the unauthorized attempt")
    public void theSystemDetectsTheUnauthorizedAttempt() {
        detectUnauthorizedAttempt();
    }

    @Then("the system blocks unauthorized attempts to access tracking information from the dashboard")
    public void theSystemBlocksUnauthorizedAttemptsToAccessTrackingInformationFromTheDashboard() {
        blockUnauthorizedAccess();
    }

    @Given("the user attempts to access tracking information")
    public void theUserAttemptsToAccessTrackingInformation() {
        attemptToAccessTrackingInformation();
    }

    @When("the user is authenticated")
    public void theUserIsAuthenticated() {
        authenticateUser();
    }

    @Then("tracking information is accessible only to authenticated users")
    public void trackingInformationIsAccessibleOnlyToAuthenticatedUsers() {
        verifyAccessForAuthenticatedUsers();
    }

    @Given("the user accesses the dashboard")
    public void theUserAccessesTheDashboard() {
        theUserIsOnTheAccountDashboard();
    }

    @When("the user uses either desktop or mobile device")
    public void theUserUsesEitherDesktopOrMobileDevice() {
        accessDashboardOnDifferentDevices();
    }

    @Then("tracking information is accessible on both desktop and mobile dashboards")
    public void trackingInformationIsAccessibleOnBothDesktopAndMobileDashboards() {
        verifyAccessibilityOnAllDevices();
    }

    @When("verifying compliance with data protection regulations")
    public void verifyingComplianceWithDataProtectionRegulations() {
        verifyDataProtectionCompliance();
    }

    @Then("tracking information access complies with relevant data protection regulations")
    public void trackingInformationAccessCompliesWithRelevantDataProtectionRegulations() {
        verifyComplianceWithRegulations();
    }

    @When("collecting user feedback")
    public void collectingUserFeedback() {
        collectUserFeedback();
    }

    @Then("user feedback indicates satisfaction with tracking information access from the dashboard")
    public void userFeedbackIndicatesSatisfactionWithTrackingInformationAccessFromTheDashboard() {
        verifyUserFeedback();
    }
}