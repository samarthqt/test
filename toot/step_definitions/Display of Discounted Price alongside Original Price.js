import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPricingPage from "../pages/productPricingPage";

Given("I am on the product pricing page", () => {
 ProductPricingPage.visit();
});

Given("a product has an original price of {string}", (originalPrice) => {
 ProductPricingPage.setOriginalPrice(originalPrice);
});

Given("the product has a discount of {string}", (discount) => {
 ProductPricingPage.setDiscount(discount);
});

Given("the product has no discount", () => {
 ProductPricingPage.setDiscount("0%");
});

Given("the following products exist:", (dataTable) => {
 dataTable.hashes().forEach((product) => {
 ProductPricingPage.addProduct(product);
 });
});

Given("a product has an invalid discount of {string}", (invalidDiscount) => {
 ProductPricingPage.setInvalidDiscount(invalidDiscount);
});

When("I view the product pricing details", () => {
 ProductPricingPage.viewPricingDetails();
});

When("I calculate the discounted price", () => {
 ProductPricingPage.calculateDiscountedPrice();
});

Then("I should see the original price displayed as {string}", (expectedPrice) => {
 cy.get(ProductPricingPage.originalPriceSelector()).should("have.text", expectedPrice);
});

Then("I should see the discounted price displayed as {string}", (expectedDiscountedPrice) => {
 cy.get(ProductPricingPage.discountedPriceSelector()).should("have.text", expectedDiscountedPrice);
});

Then("I should not see any discounted price displayed", () => {
 cy.get(ProductPricingPage.discountedPriceSelector()).should("not.exist");
});

Then("I should see the original price for {string} displayed as {string}", (productName, expectedPrice) => {
 cy.get(ProductPricingPage.originalPriceByProductSelector(productName)).should("have.text", expectedPrice);
});

Then("I should see the discounted price for {string} displayed as {string}", (productName, expectedDiscountedPrice) => {
 cy.get(ProductPricingPage.discountedPriceByProductSelector(productName)).should("have.text", expectedDiscountedPrice);
});

Then("the discounted price should be calculated as {string}", (expectedCalculatedPrice) => {
 cy.get(ProductPricingPage.calculatedDiscountedPriceSelector()).should("have.text", expectedCalculatedPrice);
});

Then("I should see a message indicating {string}", (expectedMessage) => {
 cy.get(ProductPricingPage.invalidDiscountMessageSelector()).should("have.text", expectedMessage);
});