Feature: Admin Adds New Product with All Required Details
@TC-134
Scenario: Verify admin can successfully add a new product with all required details
Given an admin account exists
And admin has necessary permissions to add products
When admin logs in using valid credentials
Then admin successfully logs into the account
When admin navigates to the 'Product Management' section in the admin dashboard
Then admin is directed to the 'Product Management' page
When admin clicks on the 'Add New Product' button
Then admin is redirected to the 'Add New Product' form
When admin enters the product name "Example Product" in the 'Product Name' field
Then product name is entered successfully
When admin selects the category "Electronics" from the 'Category' dropdown
Then category is selected successfully
When admin enters the price "$100" in the 'Price' field
Then price is entered successfully
When admin enters the stock quantity "50" in the 'Stock Quantity' field
Then stock quantity is entered successfully
When admin enters the description "High-quality electronic product" in the 'Description' field
Then description is entered successfully
When admin uploads an image "example_product.jpg" for the product using the 'Upload Image' button
Then image is uploaded successfully
When admin reviews all entered details for accuracy
Then all details are accurate and complete
When admin clicks on the 'Save' or 'Submit' button to add the product
Then product is added successfully and a confirmation message is displayed
When admin verifies the new product appears in the product list
Then new product is listed in the product management section
When admin checks the product details to ensure they match the entered data
Then product details are correct and match the entered data
When admin logs out of the admin account
Then admin is successfully logged out and redirected to the login page
When admin logs in again
Then newly added product persists and is visible after re-login