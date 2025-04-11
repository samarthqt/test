import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductCatalogPage from '../pageObjects/ProductCatalogPage';

const productCatalogPage = new ProductCatalogPage();

Given('the admin is logged into the product catalog management system', () => {
  cy.loginAsAdmin();
});

When('the admin navigates to the {string} page', (pageName) => {
  productCatalogPage.navigateToPage(pageName);
});

When('the admin enters the product name, description, price, uploads an image, sets stock availability, and selects a category', () => {
  productCatalogPage.enterProductDetails({
    name: 'New Product',
    description: 'Product Description',
    price: '100',
    image: 'path/to/image.jpg',
    stock: 'In Stock',
    category: 'Electronics'
  });
});

When('the admin submits the product details', () => {
  productCatalogPage.submitProductDetails();
});

Then('the new product is added to the catalog', () => {
  productCatalogPage.verifyProductAdded('New Product');
});

Then('a notification confirms the successful addition of the product', () => {
  productCatalogPage.verifyNotification('Product added successfully');
});

Then('the changes are saved immediately and reflect in the catalog', () => {
  productCatalogPage.verifyChangesSaved();
});

When('the admin updates the product name, description, price, image, stock availability, or category', () => {
  productCatalogPage.updateProductDetails({
    name: 'Updated Product',
    description: 'Updated Description',
    price: '150',
    image: 'path/to/updated_image.jpg',
    stock: 'Out of Stock',
    category: 'Home Appliances'
  });
});

Then('the product details are updated in the catalog', () => {
  productCatalogPage.verifyProductUpdated('Updated Product');
});

Then('a notification confirms the successful update of the product', () => {
  productCatalogPage.verifyNotification('Product updated successfully');
});

When('the admin confirms the deletion', () => {
  productCatalogPage.confirmDeletion();
});

Then('the product is removed from the catalog', () => {
  productCatalogPage.verifyProductRemoved('Deleted Product');
});

Then('a notification confirms the successful deletion of the product', () => {
  productCatalogPage.verifyNotification('Product deleted successfully');
});

Given('the admin is on the {string} page', (pageName) => {
  productCatalogPage.navigateToPage(pageName);
});

When('the admin enters invalid data in any of the fields', () => {
  productCatalogPage.enterInvalidProductDetails();
});

When('the admin attempts to submit the product details', () => {
  productCatalogPage.submitProductDetails();
});

Then('an error message is displayed indicating the invalid input', () => {
  productCatalogPage.verifyErrorMessage('Invalid input');
});

Then('the product is not added to the catalog', () => {
  productCatalogPage.verifyProductNotAdded();
});

Given('the admin performs an operation such as adding, editing, or deleting a product', () => {
  cy.performProductOperation();
});

When('the operation is completed successfully', () => {
  cy.verifyOperationSuccess();
});

Then('the system logs the details of the operation', () => {
  cy.verifyOperationLogged();
});