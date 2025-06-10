Feature: Product Catalog Management
@2
Scenario: Admin adds a product with complete details
Given the admin has access to the product catalog management interface
When the admin adds a new product with name, description, price, image, stock, and category
Then the product is saved with complete details
@2
Scenario: Admin edits existing product details
Given the admin has access to the product catalog management interface
And there is an existing product in the catalog
When the admin edits the product details such as name, description, price, image, stock, or category
Then the product details are updated successfully
@2
Scenario: Admin deletes a product
Given the admin has access to the product catalog management interface
And there is an existing product in the catalog
When the admin deletes the product
Then the product is removed from the catalog
@2
Scenario: Application validates product details before saving
Given the admin is adding or editing a product
When the admin attempts to save the product details
Then the application validates the details for correctness and completeness
@2
Scenario: System ensures product images are stored securely
Given the admin uploads a product image
When the image is saved in the system
Then the system ensures the image is stored securely
@2
Scenario: Application updates stock information in real-time
Given the admin updates the stock information for a product
When the update is saved
Then the application reflects the updated stock information in real-time
@2
Scenario: Admin categorizes products accurately
Given the admin is adding or editing a product
When the admin assigns a category to the product
Then the product is categorized accurately
@2
Scenario: System logs all changes made to product details
Given the admin makes changes to product details
When the changes are saved
Then the system logs all changes made
@2
Scenario: Application offers a user-friendly interface for catalog management
Given the admin accesses the product catalog management interface
Then the interface is user-friendly and easy to navigate
@2
Scenario: System ensures data consistency across all product details
Given the admin adds, edits, or deletes product details
When the changes are saved
Then the system ensures data consistency across all product details