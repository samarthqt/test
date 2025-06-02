import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("the system is under peak traffic load", () => {
 cy.intercept("GET", "/api/traffic", { fixture: "peakTraffic" });
});

When("I navigate to the homepage of the retail application", () => {
 ProductPage.visitHomepage();
});

Then("the homepage is displayed with navigation options", () => {
 ProductPage.verifyHomepage();
});

Given("the homepage is displayed", () => {
 ProductPage.verifyHomepage();
});

When("I click on the 'Categories' dropdown menu", () => {
 ProductPage.clickCategoriesDropdown();
});

Then("the dropdown menu expands showing available product categories", () => {
 ProductPage.verifyCategoriesDropdown();
});

When("I select the 'Fashion' category from the dropdown", () => {
 ProductPage.selectCategory("Fashion");
});

Then("the product listing page displays products under the 'Fashion' category", () => {
 ProductPage.verifyProductListing("Fashion");
});

Given("the product listing page is displayed", () => {
 ProductPage.verifyProductListingPage();
});

When("I enter {string} in the search bar and press enter", (keyword) => {
 ProductPage.searchProduct(keyword);
});

Then("search results display products related to {string}", (keyword) => {
 ProductPage.verifySearchResults(keyword);
});

Given("the search results are displayed", () => {
 ProductPage.verifySearchResultsPage();
});

Then("product details such as name, price, and rating are correctly displayed for each item", () => {
 ProductPage.verifyProductDetails();
});

When("I click on a product", () => {
 ProductPage.clickOnProduct();
});

Then("I am redirected to the product detail page promptly", () => {
 ProductPage.verifyProductDetailPage();
});

Given("the search results page is displayed", () => {
 ProductPage.verifySearchResultsPage();
});

When("I choose to return to the homepage", () => {
 ProductPage.navigateBackToHomepage();
});

Then("I can navigate back to the homepage promptly", () => {
 ProductPage.verifyHomepage();
});