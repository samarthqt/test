import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("the user is logged into the admin panel", () => {
 cy.login();
});

When("the user navigates to the product addition page", () => {
 ProductPage.visit();
});

Then("the product addition page is displayed successfully", () => {
 ProductPage.verifyPageDisplayed();
});

And("the product addition interface must be accessible", () => {
 ProductPage.verifyInterfaceAccessible();
});

Given("the 'Product Name' field is empty", () => {
 ProductPage.clearProductName();
});

When("the user enters '100' in the 'Product Price' field", () => {
 ProductPage.enterProductPrice('100');
});

Then("the 'Product Price' field is populated with '100'", () => {
 ProductPage.verifyProductPrice('100');
});

When("the user enters 'Sample Description' in the 'Product Description' field", () => {
 ProductPage.enterProductDescription('Sample Description');
});

Then("the 'Product Description' field is populated with 'Sample Description'", () => {
 ProductPage.verifyProductDescription('Sample Description');
});

When("the user selects 'Electronics' from the 'Product Category' dropdown", () => {
 ProductPage.selectProductCategory('Electronics');
});

Then("the 'Product Category' field is set to 'Electronics'", () => {
 ProductPage.verifyProductCategory('Electronics');
});

When("the user clicks on the 'Save' button to attempt to add the product", () => {
 ProductPage.clickSaveButton();
});

Then("an error message is displayed indicating that the 'Product Name' field cannot be empty", () => {
 ProductPage.verifyErrorMessageForEmptyProductName();
});

And("the product does not appear in the product list", () => {
 ProductPage.verifyProductNotInList();
});

And("system logs or alerts indicate a validation error due to the missing product name", () => {
 ProductPage.verifySystemLogsForValidationError();
});

When("the user refreshes the page and re-enters the same data", () => {
 ProductPage.refreshAndReEnterData();
});

Then("the same validation error is displayed indicating the 'Product Name' field is required", () => {
 ProductPage.verifyErrorMessageForEmptyProductName();
});

When("the user attempts to navigate away from the page without saving", () => {
 ProductPage.attemptToNavigateAway();
});

Then("a warning message is displayed asking to confirm navigation without saving", () => {
 ProductPage.verifyNavigationWarningMessage();
});

Given("the user enters a valid name in the 'Product Name' field", () => {
 ProductPage.enterProductName('Valid Product Name');
});

When("the user saves the product", () => {
 ProductPage.clickSaveButton();
});

Then("the product is successfully added to the product list with a valid name", () => {
 ProductPage.verifyProductInList('Valid Product Name');
});

Given("the product was attempted to be added without a name", () => {
 ProductPage.attemptToAddProductWithoutName();
});

Then("no entry is found in the database for the product without a name", () => {
 ProductPage.verifyNoDatabaseEntryForProductWithoutName();
});

Given("the user encounters a validation error", () => {
 ProductPage.simulateValidationError();
});

Then("the system remains stable and responsive after the validation error", () => {
 ProductPage.verifySystemStability();
});

Given("an error message is displayed", () => {
 ProductPage.simulateErrorMessageDisplay();
});

Then("the user interface displays the error message correctly without any layout issues", () => {
 ProductPage.verifyErrorMessageLayout();
});

Given("the user logs out and logs back in", () => {
 cy.logout();
 cy.login();
});

Then("the system state is consistent and no product without a name is added", () => {
 ProductPage.verifySystemStateConsistency();
});