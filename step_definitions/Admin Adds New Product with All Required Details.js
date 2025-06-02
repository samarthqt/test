import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminPage from "../pages/adminPage";

Given("an admin account exists", () => {
 // Assume admin account setup is done outside of this test
});

And("admin has necessary permissions to add products", () => {
 // Assume permissions are set correctly
});

When("admin logs in using valid credentials", () => {
 AdminPage.login();
});

Then("admin successfully logs into the account", () => {
 cy.url().should("include", "/dashboard");
});

When("admin navigates to the 'Product Management' section in the admin dashboard", () => {
 AdminPage.navigateToProductManagement();
});

Then("admin is directed to the 'Product Management' page", () => {
 cy.url().should("include", "/product-management");
});

When("admin clicks on the 'Add New Product' button", () => {
 AdminPage.clickAddNewProduct();
});

Then("admin is redirected to the 'Add New Product' form", () => {
 cy.url().should("include", "/add-product");
});

When("admin enters the product name {string} in the 'Product Name' field", (productName) => {
 AdminPage.enterProductName(productName);
});

Then("product name is entered successfully", () => {
 AdminPage.verifyProductName();
});

When("admin selects the category {string} from the 'Category' dropdown", (category) => {
 AdminPage.selectCategory(category);
});

Then("category is selected successfully", () => {
 AdminPage.verifyCategorySelection();
});

When("admin enters the price {string} in the 'Price' field", (price) => {
 AdminPage.enterPrice(price);
});

Then("price is entered successfully", () => {
 AdminPage.verifyPrice();
});

When("admin enters the stock quantity {string} in the 'Stock Quantity' field", (quantity) => {
 AdminPage.enterStockQuantity(quantity);
});

Then("stock quantity is entered successfully", () => {
 AdminPage.verifyStockQuantity();
});

When("admin enters the description {string} in the 'Description' field", (description) => {
 AdminPage.enterDescription(description);
});

Then("description is entered successfully", () => {
 AdminPage.verifyDescription();
});

When("admin uploads an image {string} for the product using the 'Upload Image' button", (imageName) => {
 AdminPage.uploadImage(imageName);
});

Then("image is uploaded successfully", () => {
 AdminPage.verifyImageUpload();
});

When("admin reviews all entered details for accuracy", () => {
 AdminPage.reviewDetails();
});

Then("all details are accurate and complete", () => {
 AdminPage.verifyDetailsAccuracy();
});

When("admin clicks on the 'Save' or 'Submit' button to add the product", () => {
 AdminPage.submitProduct();
});

Then("product is added successfully and a confirmation message is displayed", () => {
 AdminPage.verifyProductAdded();
});

When("admin verifies the new product appears in the product list", () => {
 AdminPage.verifyProductInList();
});

Then("new product is listed in the product management section", () => {
 AdminPage.verifyProductListed();
});

When("admin checks the product details to ensure they match the entered data", () => {
 AdminPage.checkProductDetails();
});

Then("product details are correct and match the entered data", () => {
 AdminPage.verifyProductDetailsMatch();
});

When("admin logs out of the admin account", () => {
 AdminPage.logout();
});

Then("admin is successfully logged out and redirected to the login page", () => {
 cy.url().should("include", "/login");
});

When("admin logs in again", () => {
 AdminPage.login();
});

Then("newly added product persists and is visible after re-login", () => {
 AdminPage.verifyProductPersists();
});