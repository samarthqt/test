import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminPage from "../pages/adminPage";

Given("an admin account with product management privileges", () => {
  AdminPage.ensureAdminPrivileges();
});

When("the admin logs in with product management privileges", () => {
  AdminPage.loginAsAdmin();
});

Then("the admin is successfully logged in and redirected to the admin dashboard", () => {
  AdminPage.verifyAdminDashboard();
});

When("the admin navigates to the product management section", () => {
  AdminPage.navigateToProductManagement();
});

Then("the product management interface is displayed", () => {
  AdminPage.verifyProductManagementInterface();
});

When("the admin clicks on 'Add New Product' button", () => {
  AdminPage.clickAddNewProduct();
});

Then("the product addition form is displayed", () => {
  AdminPage.verifyProductAdditionForm();
});

When("the admin enters product name {string}", (productName) => {
  AdminPage.enterProductName(productName);
});

When("the admin selects product category {string} from the dropdown", (category) => {
  AdminPage.selectProductCategory(category);
});

When("the admin enters product price {string}", (price) => {
  AdminPage.enterProductPrice(price);
});

When("the admin enters stock quantity {string}", (quantity) => {
  AdminPage.enterStockQuantity(quantity);
});

When("the admin enters product description {string}", (description) => {
  AdminPage.enterProductDescription(description);
});

When("the admin enters SKU {string}", (sku) => {
  AdminPage.enterSKU(sku);
});

When("the admin uploads product image", () => {
  AdminPage.uploadProductImage();
});

When("the admin reviews all entered details for accuracy", () => {
  AdminPage.reviewProductDetails();
});

When("the admin clicks on 'Save' or 'Add Product' button", () => {
  AdminPage.saveProduct();
});

Then("the product is successfully added to the inventory", () => {
  AdminPage.verifyProductAdded();
});

When("the admin verifies the newly added product in the product list", () => {
  AdminPage.verifyProductInList();
});

When("the admin logs out from the admin account", () => {
  AdminPage.logout();
});

Then("the admin is logged out and redirected to the login page", () => {
  AdminPage.verifyLogout();
});

When("the admin verifies product visibility on the customer-facing site", () => {
  AdminPage.verifyProductVisibility();
});

Then("the new product is visible to customers with accurate details", () => {
  AdminPage.verifyProductDetailsOnCustomerSite();
});