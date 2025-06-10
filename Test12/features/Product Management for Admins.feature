Feature: Product Management for Admins
@27
Scenario: Admin adds a new product with complete details
Given I am logged in as an admin
When I add a new product with name "Product A", description "Description A", price "100", image "imageA.jpg", stock "50", and category "Category A"
Then the product should be successfully added to the product catalog
And I should receive a notification for the successful update
And the change should be logged for auditing purposes
@27
Scenario: Admin edits an existing product
Given I am logged in as an admin
And a product with name "Product A" exists in the product catalog
When I edit the product's details to name "Product A1", description "Description A1", price "150", image "imageA1.jpg", stock "60", and category "Category A1"
Then the product details should be successfully updated
And I should receive a notification for the successful update
And the change should be logged for auditing purposes
@27
Scenario: Admin deletes a product with confirmation
Given I am logged in as an admin
And a product with name "Product A" exists in the product catalog
When I attempt to delete the product
Then I should see a confirmation prompt
When I confirm the deletion
Then the product should be successfully deleted from the product catalog
And the change should be logged for auditing purposes
@27
Scenario: Admin enters invalid data while adding a product
Given I am logged in as an admin
When I add a new product with name "", description "", price "-100", image "imageA.jpg", stock "-10", and category ""
Then I should see error messages for the invalid data inputs
@27
Scenario: Admin enters invalid data while editing a product
Given I am logged in as an admin
And a product with name "Product A" exists in the product catalog
When I edit the product's details to name "", description "", price "-150", image "imageA1.jpg", stock "-60", and category ""
Then I should see error messages for the invalid data inputs
@27
Scenario: Ensure data integrity and prevent unauthorized access
Given I am not logged in as an admin
When I attempt to add, edit, or delete a product
Then I should not be able to perform these actions
And I should see an error message indicating unauthorized access