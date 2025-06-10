import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import ProjectsPage from "../pages/projectsPage";

Given("the Admin user logs into the COCO application with username {string} and password {string}", (username, password) => {
 LoginPage.visit();
 LoginPage.enterUsername(username);
 LoginPage.enterPassword(password);
 LoginPage.submit();
});

Then("the Admin user is logged in successfully", () => {
 cy.url().should("include", "/dashboard");
});

Then("the Admin profile menu options are visible", () => {
 cy.get("#adminMenu").should("be.visible");
});

When("the Admin user clicks on the 'Projects' menu option", () => {
 ProjectsPage.clickProjectsMenu();
});

Then("the user is redirected to the Projects page", () => {
 cy.url().should("include", "/projects");
});

Then("the 'Create New Project' option is displayed on the Projects page", () => {
 ProjectsPage.verifyCreateNewProjectOption();
});