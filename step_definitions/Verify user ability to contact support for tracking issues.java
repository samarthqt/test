package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ContactSupportPage;

public class ContactSupportSteps extends ContactSupportPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the 'Order History' section is displayed with a list of past orders")
    public void theOrderHistorySectionIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the user has an order with tracking information")
    public void theUserHasAnOrderWithTrackingInformation() {
        verifyOrderWithTrackingInfo();
    }

    @When("the user selects an order with tracking information available")
    public void theUserSelectsAnOrderWithTrackingInformationAvailable() {
        selectOrderWithTrackingInfo();
    }

    @Then("the order details page is displayed with tracking information visible")
    public void theOrderDetailsPageIsDisplayedWithTrackingInformationVisible() {
        verifyTrackingInfoVisible();
    }

    @Given("the user is on the order details page")
    public void theUserIsOnTheOrderDetailsPage() {
        navigateToOrderDetailsPage();
    }

    @When("the user identifies an issue with the tracking information, such as incorrect updates")
    public void theUserIdentifiesAnIssueWithTheTrackingInformation() {
        identifyTrackingIssue();
    }

    @Then("the issue with tracking information is identified")
    public void theIssueWithTrackingInformationIsIdentified() {
        verifyTrackingIssueIdentified();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        navigateToDashboard();
    }

    @When("the user navigates to the 'Help & Support' section")
    public void theUserNavigatesToTheHelpSupportSection() {
        navigateToHelpSupport();
    }

    @Then("the 'Help & Support' section is displayed with contact options")
    public void theHelpSupportSectionIsDisplayedWithContactOptions() {
        verifyHelpSupportDisplayed();
    }

    @Given("the user is in the 'Help & Support' section")
    public void theUserIsInTheHelpSupportSection() {
        verifyInHelpSupportSection();
    }

    @When("the user selects 'Live Chat' as the contact method")
    public void theUserSelectsLiveChatAsTheContactMethod() {
        selectLiveChat();
    }

    @Then("the Live Chat interface is displayed for user interaction")
    public void theLiveChatInterfaceIsDisplayedForUserInteraction() {
        verifyLiveChatInterfaceDisplayed();
    }

    @Given("the Live Chat interface is displayed")
    public void theLiveChatInterfaceIsDisplayed() {
        verifyLiveChatInterfaceDisplayed();
    }

    @When("the user initiates a chat session and describes the tracking issue to support")
    public void theUserInitiatesAChatSessionAndDescribesTheTrackingIssueToSupport() {
        initiateChatSession();
    }

    @Then("the chat session is initiated and the issue is communicated to support")
    public void theChatSessionIsInitiatedAndTheIssueIsCommunicatedToSupport() {
        verifyChatSessionInitiated();
    }

    @Given("the user has communicated the issue to support")
    public void theUserHasCommunicatedTheIssueToSupport() {
        verifyIssueCommunicated();
    }

    @When("support acknowledges the issue")
    public void supportAcknowledgesTheIssue() {
        verifySupportAcknowledgement();
    }

    @Then("support provides solutions or next steps")
    public void supportProvidesSolutionsOrNextSteps() {
        verifySolutionsProvided();
    }

    @Given("the user has identified a tracking issue")
    public void theUserHasIdentifiedATrackingIssue() {
        verifyTrackingIssueIdentified();
    }

    @When("the user tests alternative contact methods like email or phone")
    public void theUserTestsAlternativeContactMethodsLikeEmailOrPhone() {
        testAlternativeContactMethods();
    }

    @Then("the user is able to contact support via alternative methods successfully")
    public void theUserIsAbleToContactSupportViaAlternativeMethodsSuccessfully() {
        verifyAlternativeContactSuccessful();
    }

    @Given("the user has contacted support")
    public void theUserHasContactedSupport() {
        verifySupportContacted();
    }

    @When("checking the response time and effectiveness of support")
    public void checkingTheResponseTimeAndEffectivenessOfSupport() {
        checkSupportResponseTime();
    }

    @Then("support responds within acceptable time limits and resolves the issue effectively")
    public void supportRespondsWithinAcceptableTimeLimitsAndResolvesTheIssueEffectively() {
        verifySupportResponseEffective();
    }

    @Given("the tracking issue has been resolved")
    public void theTrackingIssueHasBeenResolved() {
        verifyIssueResolved();
    }

    @When("support communicates the resolution back to the user")
    public void supportCommunicatesTheResolutionBackToTheUser() {
        verifyResolutionCommunicated();
    }

    @Then("the resolution of the tracking issue is communicated back to the user")
    public void theResolutionOfTheTrackingIssueIsCommunicatedBackToTheUser() {
        verifyResolutionCommunicated();
    }

    @Given("the user is accessing the support interface")
    public void theUserIsAccessingTheSupportInterface() {
        accessSupportInterface();
    }

    @When("testing the usability of the support interface")
    public void testingTheUsabilityOfTheSupportInterface() {
        testSupportInterfaceUsability();
    }

    @Then("the support interface is user-friendly and easy to navigate for reporting issues")
    public void theSupportInterfaceIsUserFriendlyAndEasyToNavigateForReportingIssues() {
        verifySupportInterfaceUsability();
    }

    @Given("the user is on the application")
    public void theUserIsOnTheApplication() {
        verifyUserOnApplication();
    }

    @When("accessing support contact options")
    public void accessingSupportContactOptions() {
        accessSupportContactOptions();
    }

    @Then("support contact options are accessible and functional on both platforms")
    public void supportContactOptionsAreAccessibleAndFunctionalOnBothPlatforms() {
        verifySupportOptionsAccessible();
    }

    @Given("the user is attempting to contact support")
    public void theUserIsAttemptingToContactSupport() {
        attemptToContactSupport();
    }

    @When("verifying user authentication")
    public void verifyingUserAuthentication() {
        verifyUserAuthentication();
    }

    @Then("user authentication is required and verified before contacting support")
    public void userAuthenticationIsRequiredAndVerifiedBeforeContactingSupport() {
        verifyAuthenticationRequired();
    }

    @Given("the user is interacting with support")
    public void theUserIsInteractingWithSupport() {
        interactWithSupport();
    }

    @When("checking the security of user information")
    public void checkingTheSecurityOfUserInformation() {
        checkUserInformationSecurity();
    }

    @Then("user information is securely handled during support interaction")
    public void userInformationIsSecurelyHandledDuringSupportInteraction() {
        verifyInformationSecurity();
    }

    @Given("the user needs support for tracking issues")
    public void theUserNeedsSupportForTrackingIssues() {
        verifySupportNeeded();
    }

    @When("checking support availability")
    public void checkingSupportAvailability() {
        checkSupportAvailability();
    }

    @Then("support is available during specified hours and ready to assist with tracking issues")
    public void supportIsAvailableDuringSpecifiedHoursAndReadyToAssistWithTrackingIssues() {
        verifySupportAvailability();
    }
}