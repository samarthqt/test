Feature: Error handling when adding more products to the cart than available in stock
@TC-156
Scenario: Verify error handling when adding more products to the cart than available in stock
Given the user is logged into the application
When the user navigates to the product page for Product ID 12345
Then the product page displays correctly with stock information
And the product stock information is accurately updated in the system
@TC-156
Scenario: Attempt to add more products than available in stock
Given the available stock for Product ID 12345 is 10
When the user enters a quantity of 15 into the quantity field
And clicks the 'Add to Cart' button
Then the system displays an error message indicating insufficient stock
And the cart does not contain the requested quantity
@TC-156
Scenario: Verify error message clarity and accuracy
Given the user attempted to add more products than available in stock
Then the error message clearly states the issue and available stock
@TC-156
Scenario: Successfully add products within available stock limit
Given the user adjusts the quantity to the available stock limit
When the user adds the product to the cart
Then the system successfully adds the product to the cart
And the cart displays the correct quantity reflecting available stock
@TC-156
Scenario: Test edge case with quantity of 0
When the user enters a quantity of 0 into the quantity field
And clicks the 'Add to Cart' button
Then the system should not add the product and may display a relevant message
@TC-156
Scenario: Attempt to add a negative quantity to the cart
When the user enters a negative quantity into the quantity field
And clicks the 'Add to Cart' button
Then the system should reject the input and display an error message
@TC-156
Scenario: Attempt to add a non-numeric quantity to the cart
When the user enters a non-numeric quantity into the quantity field
And clicks the 'Add to Cart' button
Then the system should reject the input and display an error message
@TC-156
Scenario: Check system logs for error handling entries
When the user attempts actions that breach stock limits
Then the system logs should reflect the error handling process
@TC-156
Scenario: Verify system performance under repeated attempts to breach stock limits
When the user repeatedly attempts to add more products than available in stock
Then the system remains responsive and handles errors gracefully
@TC-156
Scenario: Assess user experience and satisfaction with error handling
Given the user encounters error messages due to stock limit breaches
Then users should understand the error message and how to resolve the issue
@TC-156
Scenario: Ensure system maintains accurate stock levels after error handling
Given the user attempts various actions related to stock limits
Then stock levels remain consistent and accurately reflect available inventory