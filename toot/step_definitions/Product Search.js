import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("I am on the product search page", () => {
 ProductSearchPage.visit();
});

When("I enter {string} in the search bar", (productName) => {
 ProductSearchPage.enterProductName(productName);
});

When("I select {string} from the category dropdown", (category) => {
 ProductSearchPage.selectCategory(category);
});

When("I leave the search bar empty", () => {
 ProductSearchPage.clearSearchBar();
});

When("I click on the search button", () => {
 ProductSearchPage.clickSearchButton();
});

Then("I should see a list of products with names containing {string}", (productName) => {
 ProductSearchPage.verifyProductListContains(productName);
});

Then("I should see a list of products under the {string} category", (category) => {
 ProductSearchPage.verifyProductListUnderCategory(category);
});

Then("I should see a message {string}", (message) => {
 ProductSearchPage.verifyNoProductsFoundMessage(message);
});

Then("I should see a validation message {string}", (validationMessage) => {
 ProductSearchPage.verifyValidationMessage(validationMessage);
});