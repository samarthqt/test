import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SupportPage from "../pages/supportPage";

Given("the user is logged into their account", () => {
 SupportPage.login();
});

When("the user navigates to the 'Order History' section", () => {
 SupportPage.goToOrderHistory();
});

Then("the 'Order History' section is displayed with a list of past orders", () => {
 SupportPage.verifyOrderHistoryDisplayed();
});

Given("the user has an order with tracking information", () => {
 SupportPage.selectOrderWithTracking();
});

When("the user selects an order with tracking information available", () => {
 SupportPage.selectOrderWithTracking();
});

Then("the order details page is displayed with tracking information visible", () => {
 SupportPage.verifyTrackingInfoVisible();
});

Given("the user is on the order details page", () => {
 SupportPage.onOrderDetailsPage();
});

When("the user identifies an issue with the tracking information, such as incorrect updates", () => {
 SupportPage.identifyTrackingIssue();
});

Then("the issue with tracking information is identified", () => {
 SupportPage.verifyTrackingIssueIdentified();
});

Given("the user is on the dashboard", () => {
 SupportPage.onDashboard();
});

When("the user navigates to the 'Help & Support' section", () => {
 SupportPage.goToHelpAndSupport();
});

Then("the 'Help & Support' section is displayed with contact options", () => {
 SupportPage.verifyHelpAndSupportDisplayed();
});

Given("the user is in the 'Help & Support' section", () => {
 SupportPage.inHelpAndSupport();
});

When("the user selects 'Live Chat' as the contact method", () => {
 SupportPage.selectLiveChat();
});

Then("the Live Chat interface is displayed for user interaction", () => {
 SupportPage.verifyLiveChatDisplayed();
});

Given("the Live Chat interface is displayed", () => {
 SupportPage.liveChatDisplayed();
});

When("the user initiates a chat session and describes the tracking issue to support", () => {
 SupportPage.initiateChatSession();
});

Then("the chat session is initiated and the issue is communicated to support", () => {
 SupportPage.verifyChatInitiated();
});

Given("the user has communicated the issue to support", () => {
 SupportPage.issueCommunicated();
});

When("support acknowledges the issue", () => {
 SupportPage.supportAcknowledgesIssue();
});

Then("support provides solutions or next steps", () => {
 SupportPage.verifySolutionsProvided();
});

Given("the user has identified a tracking issue", () => {
 SupportPage.trackingIssueIdentified();
});

When("the user tests alternative contact methods like email or phone", () => {
 SupportPage.testAlternativeContactMethods();
});

Then("the user is able to contact support via alternative methods successfully", () => {
 SupportPage.verifyAlternativeContactSuccess();
});

Given("the user has contacted support", () => {
 SupportPage.contactSupport();
});

When("checking the response time and effectiveness of support", () => {
 SupportPage.checkResponseTime();
});

Then("support responds within acceptable time limits and resolves the issue effectively", () => {
 SupportPage.verifyEffectiveSupport();
});

Given("the tracking issue has been resolved", () => {
 SupportPage.issueResolved();
});

When("support communicates the resolution back to the user", () => {
 SupportPage.supportCommunicatesResolution();
});

Then("the resolution of the tracking issue is communicated back to the user", () => {
 SupportPage.verifyResolutionCommunicated();
});

Given("the user is accessing the support interface", () => {
 SupportPage.accessingSupportInterface();
});

When("testing the usability of the support interface", () => {
 SupportPage.testSupportUsability();
});

Then("the support interface is user-friendly and easy to navigate for reporting issues", () => {
 SupportPage.verifyUsability();
});

Given("the user is on the application", () => {
 SupportPage.onApplication();
});

When("accessing support contact options", () => {
 SupportPage.accessSupportOptions();
});

Then("support contact options are accessible and functional on both platforms", () => {
 SupportPage.verifyContactOptionsAccessible();
});

Given("the user is attempting to contact support", () => {
 SupportPage.attemptingContactSupport();
});

When("verifying user authentication", () => {
 SupportPage.verifyUserAuthentication();
});

Then("user authentication is required and verified before contacting support", () => {
 SupportPage.verifyAuthenticationRequired();
});

Given("the user is interacting with support", () => {
 SupportPage.interactingWithSupport();
});

When("checking the security of user information", () => {
 SupportPage.checkUserInfoSecurity();
});

Then("user information is securely handled during support interaction", () => {
 SupportPage.verifyInfoSecurity();
});

Given("the user needs support for tracking issues", () => {
 SupportPage.needsSupportForTracking();
});

When("checking support availability", () => {
 SupportPage.checkSupportAvailability();
});

Then("support is available during specified hours and ready to assist with tracking issues", () => {
 SupportPage.verifySupportAvailability();
});