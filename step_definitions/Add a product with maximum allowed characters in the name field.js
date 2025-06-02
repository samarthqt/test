import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("User is logged into the admin panel", () => {
 cy.login();
});

When("User navigates to the product addition page", () => {
 ProductPage.visit();
});

Then("Product addition page is displayed successfully", () => {
 ProductPage.verifyPageDisplayed();
});

Then("Product addition interface must be accessible", () => {
 ProductPage.verifyInterfaceAccessible();
});

When("User enters 255 'A' characters in the 'Product Name' field", () => {
 ProductPage.enterProductName('A'.repeat(255));
});

Then("The 'Product Name' field is populated with 255 'A' characters", () => {
 ProductPage.verifyProductName('A'.repeat(255));
});

When("User enters '200' in the 'Product Price' field", () => {
 ProductPage.enterProductPrice('200');
});

Then("The 'Product Price' field is populated with '200'", () => {
 ProductPage.verifyProductPrice('200');
});

When("User enters 'Sample Description' in the 'Product Description' field", () => {
 ProductPage.enterProductDescription('Sample Description');
});

Then("The 'Product Description' field is populated with 'Sample Description'", () => {
 ProductPage.verifyProductDescription('Sample Description');
});

When("User selects 'Home Appliances' from the 'Product Category' dropdown", () => {
 ProductPage.selectProductCategory('Home Appliances');
});

Then("The 'Product Category' field is set to 'Home Appliances'", () => {
 ProductPage.verifyProductCategory('Home Appliances');
});

When("User clicks on the 'Save' button to add the product", () => {
 ProductPage.saveProduct();
});

Then("The product is successfully added to the product list with the name containing 255 'A' characters", () => {
 ProductPage.verifyProductInList('A'.repeat(255));
});

Then("The product appears in the product list with the correct name", () => {
 ProductPage.verifyProductInList('A'.repeat(255));
});

Then("The product name is stored correctly in the database with 255 'A' characters", () => {
 cy.verifyProductNameInDatabase('A'.repeat(255));
});

When("User attempts to edit the product name to exceed the maximum allowed characters", () => {
 ProductPage.attemptEditProductName('A'.repeat(256));
});

Then("An error message is displayed indicating the maximum character limit is exceeded", () => {
 ProductPage.verifyErrorMessage();
});

Then("The user interface displays the full product name without truncation", () => {
 ProductPage.verifyProductNameDisplay();
});

When("User logs out and logs back in", () => {
 cy.logout();
 cy.login();
});

Then("The product name remains intact with 255 'A' characters", () => {
 ProductPage.verifyProductName('A'.repeat(255));
});

When("User attempts to search for the product using the full name", () => {
 ProductPage.searchProduct('A'.repeat(255));
});

Then("The product is successfully found using the full name in search", () => {
 ProductPage.verifySearchResult('A'.repeat(255));
});

Then("The product details page displays the full product name correctly", () => {
 ProductPage.verifyProductDetails('A'.repeat(255));
});

Then("The system remains stable and responsive with the maximum character name", () => {
 ProductPage.verifySystemStability();
});

Then("The layout and design display the long name without any issues", () => {
 ProductPage.verifyLayoutDesign();
});