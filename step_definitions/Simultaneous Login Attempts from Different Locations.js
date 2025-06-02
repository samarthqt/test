import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("a user account exists with username {string} and password {string}", (username, password) => {
 LoginPage.createAccount(username, password);
});

When("the user attempts to login from Location 1 (New York, USA) with valid credentials", () => {
 LoginPage.login("user@example.com", "ValidPassword123", "New York");
});

Then("the user is successfully logged in from Location 1", () => {
 LoginPage.verifyLogin("New York");
});

Given("the user is logged in from Location 1", () => {
 LoginPage.verifyLogin("New York");
});

When("the user attempts to login from Location 2 (London, UK) with the same credentials", () => {
 LoginPage.login("user@example.com", "ValidPassword123", "London");
});

Then("the system detects a simultaneous login attempt and prompts for verification", () => {
 LoginPage.verifySimultaneousLogin();
});

When("the user completes the verification process for Location 2", () => {
 LoginPage.completeVerification("London");
});

Then("the user is successfully logged in from Location 2", () => {
 LoginPage.verifyLogin("London");
});

And("the session from Location 1 remains active", () => {
 LoginPage.verifySessionActive("New York");
});

Given("the user is logged in from Location 1 and Location 2", () => {
 LoginPage.verifyLogin("New York");
 LoginPage.verifyLogin("London");
});

When("the user attempts to login from Location 3 with the same credentials", () => {
 LoginPage.login("user@example.com", "ValidPassword123", "Location 3");
});

Then("the system prompts for verification due to multiple active sessions", () => {
 LoginPage.promptVerification();
});

When("the user fails the verification process for Location 3", () => {
 LoginPage.failVerification("Location 3");
});

Then("the user is not logged in from Location 3", () => {
 LoginPage.verifyNotLoggedIn("Location 3");
});

When("the user logs out from Location 1", () => {
 LoginPage.logout("New York");
});

Then("the user is logged out from Location 1", () => {
 LoginPage.verifyLoggedOut("New York");
});

And("the session from Location 2 remains active", () => {
 LoginPage.verifySessionActive("London");
});

Given("the user is logged in from Location 2", () => {
 LoginPage.verifyLogin("London");
});

When("the user attempts to login from a different device at Location 2", () => {
 LoginPage.loginFromDifferentDevice("London");
});

Then("the system prompts for verification due to device change", () => {
 LoginPage.promptVerification();
});

When("the user completes the verification process for the new device", () => {
 LoginPage.completeVerification("new device");
});

Then("the user is successfully logged in from the new device at Location 2", () => {
 LoginPage.verifyLogin("London", "new device");
});

When("the user attempts to login from Location 4 with incorrect credentials", () => {
 LoginPage.login("user@example.com", "WrongPassword", "Location 4");
});

Then("the system displays an error message indicating incorrect credentials", () => {
 LoginPage.verifyErrorMessage("incorrect credentials");
});

Given("multiple failed login attempts from Location 4", () => {
 LoginPage.simulateFailedAttempts("Location 4");
});

When("the user attempts to login from Location 4 with correct credentials", () => {
 LoginPage.login("user@example.com", "ValidPassword123", "Location 4");
});

Then("the system prompts for additional verification due to previous failed attempts", () => {
 LoginPage.promptAdditionalVerification();
});

When("monitoring system logs for login attempts", () => {
 LoginPage.monitorLogs();
});

Then("the system logs capture all login attempts with timestamps and locations", () => {
 LoginPage.verifyLogs();
});

When("checking for security alerts generated due to simultaneous login attempts", () => {
 LoginPage.checkSecurityAlerts();
});

Then("security alerts are generated and sent to the user's registered email or phone", () => {
 LoginPage.verifySecurityAlerts();
});

Given("multiple active sessions", () => {
 LoginPage.verifyMultipleSessions();
});

When("verifying session timeout behavior", () => {
 LoginPage.verifySessionTimeout();
});

Then("sessions time out independently based on inactivity", () => {
 LoginPage.verifyIndependentTimeout();
});