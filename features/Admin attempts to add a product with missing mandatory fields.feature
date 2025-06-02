Feature: Admin attempts to add a product with missing mandatory fields
@TC-135
Scenario: Verify system validation for missing mandatory fields when adding a product
Given an admin account exists
And the admin has necessary permissions to add products
When the admin logs in using valid credentials
Then the admin successfully logs into the account
When the admin navigates to the 'Product Management' section in the admin dashboard
Then the admin is directed to the 'Product Management' page
When the admin clicks on the 'Add New Product' button
Then the admin is redirected to the 'Add New Product' form
When the admin leaves the 'Product Name' field empty
And selects the appropriate category "Electronics" from the 'Category' dropdown
And leaves the 'Price' field empty
And enters the stock quantity "50" in the 'Stock Quantity' field
And leaves the 'Description' field empty
And leaves the image field empty
And attempts to save the product with missing mandatory fields
Then the system displays validation errors for missing mandatory fields
When the admin checks for specific error messages for each missing field
Then specific error messages are displayed for each missing field
When the admin attempts to navigate away from the form without saving
Then the system prompts to confirm navigation, warning about unsaved changes
When the admin fills in all mandatory fields and saves the product
Then the product is saved successfully once all mandatory fields are filled
When the admin verifies that the product does not appear in the product list when mandatory fields are missing
Then the product is not listed when mandatory fields are missing
When the admin logs out of the admin account
Then the admin is successfully logged out and redirected to the login page