import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PeakSeasonPage from "../pages/peakSeasonPage";

Given("peak shopping season data is available", () => {
 PeakSeasonPage.loadPeakData();
});

Given("user account {string}", (account) => {
 PeakSeasonPage.setUserAccount(account);
});

Given("web platform URL {string}", (url) => {
 PeakSeasonPage.setPlatformUrl(url);
});

Given("mobile app version {string}", (version) => {
 PeakSeasonPage.setAppVersion(version);
});

When("I simulate peak shopping season traffic on the web platform", () => {
 PeakSeasonPage.simulateWebTraffic();
});

When("I simulate peak shopping season traffic on the mobile app", () => {
 PeakSeasonPage.simulateMobileTraffic();
});

When("I place multiple orders simultaneously during peak season", () => {
 PeakSeasonPage.placeMultipleOrders();
});

When("I verify real-time order status updates during peak season", () => {
 PeakSeasonPage.verifyRealTimeOrderStatus();
});

When("I check system response time for order placement during peak season", () => {
 PeakSeasonPage.checkResponseTime();
});

When("I monitor system logs for errors or delays during peak season", () => {
 PeakSeasonPage.monitorSystemLogs();
});

When("I verify data accuracy for orders placed during peak season", () => {
 PeakSeasonPage.verifyDataAccuracy();
});

When("I test system scalability during peak season traffic", () => {
 PeakSeasonPage.testScalability();
});

When("I check for any system crashes or downtime during peak season", () => {
 PeakSeasonPage.checkForCrashes();
});

When("I verify user notifications for order status updates during peak season", () => {
 PeakSeasonPage.verifyUserNotifications();
});

When("I assess system performance under high load conditions", () => {
 PeakSeasonPage.assessPerformance();
});

When("I evaluate user experience on both web and mobile platforms during peak season", () => {
 PeakSeasonPage.evaluateUserExperience();
});

When("I check for any discrepancies in order data between web and mobile platforms", () => {
 PeakSeasonPage.checkDataDiscrepancies();
});

When("I verify the system's ability to recover from errors during peak season", () => {
 PeakSeasonPage.verifyRecoveryAbility();
});

When("I log out from both web and mobile platforms", () => {
 PeakSeasonPage.logoutBothPlatforms();
});

Then("the web platform handles increased traffic without degradation in performance", () => {
 PeakSeasonPage.checkWebPerformance();
});

Then("the mobile app handles increased traffic without degradation in performance", () => {
 PeakSeasonPage.checkMobilePerformance();
});

Then("orders are processed accurately and efficiently", () => {
 PeakSeasonPage.checkOrderProcessing();
});

Then("order status updates are reflected in real-time on both platforms", () => {
 PeakSeasonPage.checkOrderStatusUpdates();
});

Then("system response time remains within acceptable limits", () => {
 PeakSeasonPage.checkResponseLimits();
});

Then("system logs show no significant errors or delays", () => {
 PeakSeasonPage.checkSystemLogs();
});

Then("order data is accurate and consistent across platforms", () => {
 PeakSeasonPage.checkOrderDataConsistency();
});

Then("system scales effectively to accommodate peak season traffic", () => {
 PeakSeasonPage.checkScalability();
});

Then("system remains stable with no crashes or downtime", () => {
 PeakSeasonPage.checkSystemStability();
});

Then("users receive timely notifications for order status updates", () => {
 PeakSeasonPage.checkUserNotifications();
});

Then("system performs optimally under high load conditions", () => {
 PeakSeasonPage.checkPerformanceUnderLoad();
});

Then("user experience remains smooth and responsive on both platforms", () => {
 PeakSeasonPage.checkUserExperience();
});

Then("order data is consistent and free of discrepancies across platforms", () => {
 PeakSeasonPage.checkDataConsistency();
});

Then("system recovers gracefully from any errors encountered", () => {
 PeakSeasonPage.checkErrorRecovery();
});

Then("user is successfully logged out from both platforms", () => {
 PeakSeasonPage.checkLogoutSuccess();
});