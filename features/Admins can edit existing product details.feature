Feature: Admins can edit existing product details
@TC-91
Scenario: Verify admins can edit existing product details
Given Admin access to the product management system
When Admin logs in as an admin
Then Admin successfully logs into the system
And Existing products are available in the system
When Admin navigates to the product management section
Then Product management section is displayed
When Admin selects an existing product to edit
Then Existing product details are displayed
When Admin edits the product name
Then Product name is updated successfully
When Admin edits the product description
Then Product description is updated successfully
When Admin edits the product price
Then Product price is updated successfully
When Admin edits the product category
Then Product category is updated successfully
When Admin uploads a new product image
Then Product image is updated successfully
When Admin submits the updated product details
Then Product details are updated successfully
Then Verify the updated product appears in the product listing
And Updated product details are visible in the product listing
Then Check for any error messages during product editing
And No error messages are displayed during product editing
Then Verify updated product details are saved correctly
And Updated product details are saved accurately
Then Test product editing with different categories
And Product details can be edited under different categories
Then Check system logs for product editing events
And Logs contain entries for successful product editing
Then Verify product editing handling on mobile devices
And Product editing behaves consistently on mobile devices