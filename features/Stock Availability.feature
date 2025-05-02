Feature: Stock Availability
Scenario: Display real-time stock availability on product page
Given a user navigates to a product page
When the product page loads
Then the user should see the real-time stock availability information for the item
Scenario: Update stock availability when quantity changes
Given a user is on a product page
When the stock quantity changes due to a purchase or restock
Then the stock availability information should update in real-time
Scenario: Notify user when item is out of stock
Given a user is on a product page
When the item becomes out of stock
Then the user should be notified that the item is out of stock
Scenario: Display stock availability for multiple product variations
Given a user is on a product page with multiple variations (e.g., color, size)
When the user selects a different product variation
Then the stock availability information should update to reflect the selected variation
Scenario: Ensure stock availability information is accurate
Given a user is on a product page
When the user views the stock availability information
Then the information should accurately reflect the current stock status of the item