Feature: Verify admins can add new products with complete details
@TC-90
Scenario: Admins add new products with all required details
Given admin access to the product management system
When the admin logs in
Then the admin successfully logs into the system
When the admin navigates to the product management section
Then the product management section is displayed
When the admin selects the option to add a new product
Then the add new product form is displayed
When the admin enters a valid product name
Then the product name is entered successfully
When the admin enters a valid product description
Then the product description is entered successfully
When the admin enters a valid product price
Then the product price is entered successfully
When the admin selects a valid product category
Then the product category is selected successfully
When the admin uploads a valid product image
Then the product image is uploaded successfully
When the admin submits the new product form
Then the new product is added successfully
Then the new product appears in the product listing
And no error messages are displayed during product addition
And product details are saved accurately
@TC-90
Scenario Outline: Test product addition with different categories
Given admin access to the product management system
When the admin logs in
Then the admin successfully logs into the system
When the admin navigates to the product management section
Then the product management section is displayed
When the admin selects the option to add a new product
Then the add new product form is displayed
When the admin enters a valid product name
Then the product name is entered successfully
When the admin enters a valid product description
Then the product description is entered successfully
When the admin enters a valid product price
Then the product price is entered successfully
When the admin selects a valid product category "<category>"
Then the product category is selected successfully
When the admin uploads a valid product image
Then the product image is uploaded successfully
When the admin submits the new product form
Then the new product is added successfully
Then the new product appears in the product listing
And no error messages are displayed during product addition
And product details are saved accurately
Examples:
| category       |
| Electronics    |
| Clothing       |
| Home & Garden  |
@TC-90
Scenario: Verify system logs for product addition events
Given admin access to the product management system
When the admin logs in
Then the admin successfully logs into the system
When the admin navigates to the product management section
Then the product management section is displayed
When the admin selects the option to add a new product
Then the add new product form is displayed
When the admin enters a valid product name
Then the product name is entered successfully
When the admin enters a valid product description
Then the product description is entered successfully
When the admin enters a valid product price
Then the product price is entered successfully
When the admin selects a valid product category
Then the product category is selected successfully
When the admin uploads a valid product image
Then the product image is uploaded successfully
When the admin submits the new product form
Then the new product is added successfully
Then the system logs contain entries for successful product addition
@TC-90
Scenario: Verify product addition handling on mobile devices
Given admin access to the product management system
When the admin logs in
Then the admin successfully logs into the system
When the admin navigates to the product management section
Then the product management section is displayed
When the admin selects the option to add a new product
Then the add new product form is displayed
When the admin enters a valid product name
Then the product name is entered successfully
When the admin enters a valid product description
Then the product description is entered successfully
When the admin enters a valid product price
Then the product price is entered successfully
When the admin selects a valid product category
Then the product category is selected successfully
When the admin uploads a valid product image
Then the product image is uploaded successfully
When the admin submits the new product form
Then the new product is added successfully
Then product addition behaves consistently on mobile devices