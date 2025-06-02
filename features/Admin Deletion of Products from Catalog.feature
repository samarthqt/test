Feature: Admin Deletion of Products from Catalog
@TC-92
Scenario: Verify that admins can delete products from the catalog successfully
Given the admin is logged in with valid credentials "admin@example.com" and "password123"
And the product with ID "12345" exists in the catalog
When the admin navigates to the catalog management section at "/admin/catalog"
And the admin searches for the product using the product ID "12345"
Then the product details are displayed correctly
When the admin selects the product to be deleted
Then the delete option is visible
When the admin clicks on the delete button
Then a confirmation dialog appears asking for confirmation to delete the product
When the admin confirms the deletion in the dialog
Then the product is successfully deleted from the catalog
And the product is no longer listed in the catalog
And no error messages or alerts are displayed
When the admin logs out from the admin account
Then the admin is successfully logged out
When the admin attempts to access the deleted product via direct URL
Then an error message indicating the product does not exist is displayed
When the admin checks the database for the product entry
Then the product entry is removed from the database
When the admin verifies audit logs for the deletion action
Then audit logs show the product deletion action with admin details
When the admin checks for any automatic notifications sent regarding the deletion
Then notifications are sent to relevant stakeholders if applicable
When the admin reviews system performance post-deletion
Then system performance remains stable and unaffected
And no dependent products or categories are affected by the deletion