import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductListingPage from "../pages/productListingPage";

Given("I am on the product listing page", () => {
 ProductListingPage.visit();
});

When("I select {string} from the sort options", (option) => {
 ProductListingPage.selectSortOption(option);
});

And("I choose {string} order", (order) => {
 ProductListingPage.chooseOrder(order);
});

Then("the products should be displayed sorted by {string} in {string} order", (criteria, order) => {
 ProductListingPage.verifySorting(criteria, order);
});