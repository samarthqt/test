import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrangeHRMPage from "../pages/orangeHRMPage";

Given("the user navigates to {string}", (url) => {
 OrangeHRMPage.visit(url);
});

Given("the user logs in with username {string} and password {string}", (username, password) => {
 OrangeHRMPage.login(username, password);
});

When("the user navigates to the {string} module", (module) => {
 OrangeHRMPage.navigateToModule(module);
});

When("clicks on the {string} button", (button) => {
 OrangeHRMPage.clickButton(button);
});

When("the user enters the first name as {string}, middle name as {string}, and last name as {string}", (firstName, middleName, lastName) => {
 OrangeHRMPage.enterEmployeeDetails(firstName, middleName, lastName);
});

When("saves the new employee details", () => {
 OrangeHRMPage.saveEmployeeDetails();
});

Then("a success message {string} is displayed", (message) => {
 OrangeHRMPage.verifySuccessMessage(message);
});

Then("the new employee is visible in the {string}", (list) => {
 OrangeHRMPage.verifyEmployeeInList(list);
});