import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("I am logged in as an admin", () => {
 // Code to log in as an admin
});

Given("a product with name {string} exists in the product catalog", (productName) => {
 ProductPage.verifyProductExists(productName);
});

Given("I am not logged in as an admin", () => {
 // Code to ensure the user is not logged in as an admin
});

When("I add a new product with name {string}, description {string}, price {string}, image {string}, stock {string}, and category {string}", (name, description, price, image, stock, category) => {
 ProductPage.addProduct(name, description, price, image, stock, category);
});

When("I edit the product's details to name {string}, description {string}, price {string}, image {string}, stock {string}, and category {string}", (name, description, price, image, stock, category) => {
 ProductPage.editProduct(name, description, price, image, stock, category);
});

When("I attempt to delete the product", () => {
 ProductPage.attemptToDeleteProduct();
});

When("I confirm the deletion", () => {
 ProductPage.confirmDeletion();
});

When("I attempt to add, edit, or delete a product", () => {
 ProductPage.attemptUnauthorizedActions();
});

Then("the product should be successfully added to the product catalog", () => {
 ProductPage.verifyProductAdded();
});

Then("the product details should be successfully updated", () => {
 ProductPage.verifyProductUpdated();
});

Then("I should receive a notification for the successful update", () => {
 ProductPage.verifyUpdateNotification();
});

Then("the change should be logged for auditing purposes", () => {
 ProductPage.verifyChangeLogged();
});

Then("I should see a confirmation prompt", () => {
 ProductPage.verifyConfirmationPrompt();
});

Then("the product should be successfully deleted from the product catalog", () => {
 ProductPage.verifyProductDeleted();
});

Then("I should see error messages for the invalid data inputs", () => {
 ProductPage.verifyErrorMessages();
});

Then("I should not be able to perform these actions", () => {
 ProductPage.verifyUnauthorizedAccess();
});

Then("I should see an error message indicating unauthorized access", () => {
 ProductPage.verifyUnauthorizedErrorMessage();
});