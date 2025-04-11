Feature: Product Catalog Management
Scenario: Admin adds a new product with complete details
Given the admin is logged into the product catalog management system
When the admin navigates to the "Add Product" page
And the admin enters the product name, description, price, uploads an image, sets stock availability, and selects a category
And the admin submits the product details
Then the new product is added to the catalog
And a notification confirms the successful addition of the product
And the changes are saved immediately and reflect in the catalog
Scenario: Admin edits existing product details
Given the admin is logged into the product catalog management system
And there is an existing product in the catalog
When the admin navigates to the "Edit Product" page for that product
And the admin updates the product name, description, price, image, stock availability, or category
And the admin submits the updated product details
Then the product details are updated in the catalog
And a notification confirms the successful update of the product
And the changes are saved immediately and reflect in the catalog
Scenario: Admin deletes a product from the catalog
Given the admin is logged into the product catalog management system
And there is an existing product in the catalog
When the admin navigates to the "Delete Product" option for that product
And the admin confirms the deletion
Then the product is removed from the catalog
And a notification confirms the successful deletion of the product
And the changes are saved immediately and reflect in the catalog
Scenario: Input validation for adding a new product
Given the admin is on the "Add Product" page
When the admin enters invalid data in any of the fields such as name, description, price, image, stock availability, or category
And the admin attempts to submit the product details
Then an error message is displayed indicating the invalid input
And the product is not added to the catalog
Scenario: Logging tracks changes to the product catalog
Given the admin performs an operation such as adding, editing, or deleting a product
When the operation is completed successfully
Then the system logs the details of the operation including the type of change and product details