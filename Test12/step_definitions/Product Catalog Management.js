import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductCatalogPage from "../pages/productCatalogPage";

Given("the admin has access to the product catalog management interface", () => {
 ProductCatalogPage.visit();
});

When("the admin adds a new product with name, description, price, image, stock, and category", () => {
 ProductCatalogPage.addProduct({name: 'Product1', description: 'Description1', price: 100, image: 'image.png', stock: 10, category: 'Category1'});
});

Then("the product is saved with complete details", () => {
 ProductCatalogPage.verifyProductDetails({name: 'Product1', description: 'Description1', price: 100, image: 'image.png', stock: 10, category: 'Category1'});
});

Given("there is an existing product in the catalog", () => {
 ProductCatalogPage.verifyProductExists('Product1');
});

When("the admin edits the product details such as name, description, price, image, stock, or category", () => {
 ProductCatalogPage.editProduct('Product1', {name: 'UpdatedProduct', description: 'UpdatedDescription', price: 150, image: 'updatedImage.png', stock: 20, category: 'UpdatedCategory'});
});

Then("the product details are updated successfully", () => {
 ProductCatalogPage.verifyProductDetails({name: 'UpdatedProduct', description: 'UpdatedDescription', price: 150, image: 'updatedImage.png', stock: 20, category: 'UpdatedCategory'});
});

When("the admin deletes the product", () => {
 ProductCatalogPage.deleteProduct('Product1');
});

Then("the product is removed from the catalog", () => {
 ProductCatalogPage.verifyProductNotExists('Product1');
});

Given("the admin is adding or editing a product", () => {
 ProductCatalogPage.startProductModification();
});

When("the admin attempts to save the product details", () => {
 ProductCatalogPage.saveProductDetails();
});

Then("the application validates the details for correctness and completeness", () => {
 ProductCatalogPage.verifyValidation();
});

Given("the admin uploads a product image", () => {
 ProductCatalogPage.uploadProductImage('secureImage.png');
});

When("the image is saved in the system", () => {
 ProductCatalogPage.saveImage();
});

Then("the system ensures the image is stored securely", () => {
 ProductCatalogPage.verifyImageSecurity();
});

Given("the admin updates the stock information for a product", () => {
 ProductCatalogPage.updateStock('Product1', 30);
});

When("the update is saved", () => {
 ProductCatalogPage.saveStockUpdate();
});

Then("the application reflects the updated stock information in real-time", () => {
 ProductCatalogPage.verifyRealTimeStockUpdate('Product1', 30);
});

When("the admin assigns a category to the product", () => {
 ProductCatalogPage.assignCategory('Product1', 'NewCategory');
});

Then("the product is categorized accurately", () => {
 ProductCatalogPage.verifyProductCategory('Product1', 'NewCategory');
});

Given("the admin makes changes to product details", () => {
 ProductCatalogPage.modifyProductDetails('Product1', {name: 'FinalProduct'});
});

When("the changes are saved", () => {
 ProductCatalogPage.saveChanges();
});

Then("the system logs all changes made", () => {
 ProductCatalogPage.verifyChangeLog('Product1');
});

Given("the admin accesses the product catalog management interface", () => {
 ProductCatalogPage.visit();
});

Then("the interface is user-friendly and easy to navigate", () => {
 ProductCatalogPage.verifyUserFriendlyInterface();
});

Given("the admin adds, edits, or deletes product details", () => {
 ProductCatalogPage.modifyProductDetails('Product1', {name: 'ConsistentProduct'});
});

Then("the system ensures data consistency across all product details", () => {
 ProductCatalogPage.verifyDataConsistency('Product1');
});