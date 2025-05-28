import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("the user is on the product search page", () => {
 ProductSearchPage.visit();
});

When("the user enters a product name in the search bar", () => {
 ProductSearchPage.enterProductName('Sample Product');
});

When("the user selects a category from the category dropdown", () => {
 ProductSearchPage.selectCategory('Electronics');
});

When("the user enters a non-existent product name in the search bar", () => {
 ProductSearchPage.enterProductName('NonExistentProduct');
});

When("the user enters special characters in the search bar", () => {
 ProductSearchPage.enterProductName('!@#$%^&*');
});

When("the user leaves the search bar empty", () => {
 ProductSearchPage.enterProductName('');
});

When("the user enters a partial product name in the search bar", () => {
 ProductSearchPage.enterProductName('PartName');
});

When("the user enters a product name in the search bar with different case", () => {
 ProductSearchPage.enterProductName('sample product');
});

When("clicks the search button", () => {
 ProductSearchPage.clickSearchButton();
});

Then("the system should display a list of products that match the entered name", () => {
 ProductSearchPage.verifyProductList('Sample Product');
});

Then("the system should display a list of products that belong to the selected category", () => {
 ProductSearchPage.verifyCategoryProductList('Electronics');
});

Then("the system should display a message indicating no products were found", () => {
 ProductSearchPage.verifyNoProductsFoundMessage();
});

Then("the system should handle the input gracefully and display a message if no products are found", () => {
 ProductSearchPage.verifyNoProductsFoundMessage();
});

Then("the system should prompt the user to enter a search term", () => {
 ProductSearchPage.verifyEnterSearchTermPrompt();
});

Then("the system should display a list of products that match the partial name", () => {
 ProductSearchPage.verifyPartialNameProductList('PartName');
});

Then("the system should display a list of products that match the entered name regardless of case", () => {
 ProductSearchPage.verifyProductList('Sample Product');
});