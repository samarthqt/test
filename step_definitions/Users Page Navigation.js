import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import UsersPage from "../pages/usersPage";

Given("the Admin user logs in to the COCO application", () => {
 LoginPage.visit();
});

When("the Admin user enters username {string} and password {string}", (username, password) => {
 LoginPage.enterUsername(username);
 LoginPage.enterPassword(password);
});

Then("the Admin user is logged in successfully", () => {
 LoginPage.verifySuccessfulLogin();
});

Then("the Admin profile menu options are visible", () => {
 LoginPage.verifyProfileMenuOptions();
});

When("the Admin user clicks on the 'Users' menu option", () => {
 LoginPage.clickUsersMenuOption();
});

Then("the user is redirected to the Users page", () => {
 UsersPage.verifyRedirectionToUsersPage();
});

Then("the 'Create New User' option is displayed on the Users page", () => {
 UsersPage.verifyCreateNewUserOption();
});