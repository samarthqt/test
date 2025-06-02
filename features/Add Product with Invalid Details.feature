Feature: Add Product with Invalid Details
@TC-93
Scenario: Attempt to add a product with invalid details and verify error handling
Given the admin is logged in using valid credentials "admin@example.com" and "password123"
When the admin navigates to the catalog management section
And the admin clicks on the 'Add Product' button
Then the admin is directed to the product addition form at "/admin/catalog"
When the admin enters invalid product details: Name: '', Price: 'abc', SKU: '12345'
And the admin attempts to submit the form
Then error messages are displayed for invalid inputs
And detailed error messages are shown for empty name, non-numeric price, etc.
When the admin attempts to correct one field at a time and resubmits
Then error messages update to reflect remaining invalid fields
And no product is added to the catalog
And the database contains no new entries
And audit logs reflect failed attempts with error details
When the admin attempts to add a product with valid details
Then the product is successfully added without errors
And the admin logs out from the admin account
Then the admin is successfully logged out
And system performance remains stable and unaffected during invalid submissions
And error messages provide clear guidance for correction
And no notifications are sent for invalid submissions