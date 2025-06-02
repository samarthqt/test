Feature: Admin Product Addition with Required Details
Admins can successfully add a product with all required details.
@TC-300
Scenario: Admin adds a new product with all required details
Given an admin account with product management privileges
When the admin logs in with product management privileges
Then the admin is successfully logged in and redirected to the admin dashboard
And the admin navigates to the product management section
Then the product management interface is displayed
When the admin clicks on 'Add New Product' button
Then the product addition form is displayed
When the admin enters product name "New Product High 61"
Then the product name is entered without error
When the admin selects product category "Electronics" from the dropdown
Then the product category is selected
When the admin enters product price "$299.99"
Then the product price is entered without error
When the admin enters stock quantity "100"
Then the stock quantity is entered without error
When the admin enters product description "Latest model with advanced features"
Then the product description is entered without error
When the admin enters SKU "ELEC12345"
Then the SKU is entered without error
When the admin uploads product image
Then the product image is uploaded successfully
When the admin reviews all entered details for accuracy
Then all details are accurate and complete
When the admin clicks on 'Save' or 'Add Product' button
Then the product is successfully added to the inventory
When the admin verifies the newly added product in the product list
Then the new product is listed with correct details
When the admin logs out from the admin account
Then the admin is logged out and redirected to the login page
When the admin verifies product visibility on the customer-facing site
Then the new product is visible to customers with accurate details