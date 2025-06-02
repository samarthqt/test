import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";
import CartPage from "../pages/cartPage";

Given("the user is logged into the system with username {string} and password {string}", (username, password) => {
 cy.login(username, password);
});

When("the user navigates to the product page for {string} with Product ID {string}", (productName, productId) => {
 ProductPage.visit(productId);
});

Then("the product page is displayed with product details", () => {
 ProductPage.verifyProductDetails();
});

Given("the product page for {string} is accessible", (productName) => {
 ProductPage.verifyPageAccessible(productName);
});

When("the user selects the quantity of the product to add to the cart", () => {
 ProductPage.selectQuantity();
});

Then("the quantity selection is available and can be adjusted", () => {
 ProductPage.verifyQuantitySelection();
});

Given("the user has selected the quantity for {string}", (productName) => {
 ProductPage.verifyQuantitySelected(productName);
});

When("the user clicks on the {string} button", (buttonName) => {
 ProductPage.clickButton(buttonName);
});

Then("the product is added to the shopping cart", () => {
 CartPage.verifyProductAdded();
});

Given("the product is added to the shopping cart", () => {
 CartPage.verifyProductInCart();
});

When("the user views the cart icon", () => {
 CartPage.viewCartIcon();
});

Then("the cart icon reflects the updated quantity of products", () => {
 CartPage.verifyCartIconQuantity();
});

When("the user navigates to the shopping cart page", () => {
 CartPage.visit();
});

Then("the shopping cart page displays the added product with details", () => {
 CartPage.verifyProductDetailsInCart();
});

When("the user checks the subtotal and total amounts in the cart", () => {
 CartPage.checkAmounts();
});

Then("the amounts are calculated correctly based on product price and quantity", () => {
 CartPage.verifyAmounts();
});

When("the user removes the product from the cart", () => {
 CartPage.removeProduct();
});

Then("the product is removed and the cart updates accordingly", () => {
 CartPage.verifyProductRemoved();
});

Given("the product was removed from the shopping cart", () => {
 CartPage.verifyProductNotInCart();
});

When("the user adds the product to the cart again", () => {
 ProductPage.addProductAgain();
});

Then("the product is successfully added back to the cart", () => {
 CartPage.verifyProductAddedAgain();
});

When("the user proceeds to checkout", () => {
 CartPage.proceedToCheckout();
});

Then("the user is redirected to the checkout page with cart details", () => {
 CartPage.verifyCheckoutPage();
});

Given("the user is on the checkout page", () => {
 CartPage.verifyOnCheckoutPage();
});

When("the user logs out from the account", () => {
 cy.logout();
});

Then("the user is logged out and redirected to the login page", () => {
 cy.verifyLoggedOut();
});

Given("the user is logged out", () => {
 cy.verifyUserLoggedOut();
});

When("the user logs back into the account", () => {
 cy.loginAgain();
});

Then("the cart retains the previously added product", () => {
 CartPage.verifyCartRetention();
});

When("the user attempts to add a product with zero quantity", () => {
 ProductPage.addZeroQuantity();
});

Then("the system displays an error message indicating invalid quantity", () => {
 ProductPage.verifyInvalidQuantityError();
});

When("the user adds the product with maximum available quantity", () => {
 ProductPage.addMaxQuantity();
});

Then("the product is added successfully up to the maximum quantity limit", () => {
 ProductPage.verifyMaxQuantityAdded();
});

Given("multiple products are added to the cart", () => {
 CartPage.verifyMultipleProductsInCart();
});

When("the cart is under high load", () => {
 CartPage.simulateHighLoad();
});

Then("the cart functions correctly and maintains performance", () => {
 CartPage.verifyPerformanceUnderLoad();
});

When("the user views the product details in the cart", () => {
 CartPage.viewProductDetails();
});

Then("the product name, price, and quantity match the selected product", () => {
 CartPage.verifyProductDetailsMatch();
});