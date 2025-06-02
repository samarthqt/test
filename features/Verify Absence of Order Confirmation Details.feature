Feature: Verify Absence of Order Confirmation Details
@TC-173
Scenario: Navigate to the order confirmation page after completing the purchase
Given the user has completed a purchase transaction
When the user navigates to the order confirmation page
Then the order confirmation page is displayed
And the order ID is not present
@TC-173
Scenario: Check absence of order number on the confirmation page
Given the user is on the order confirmation page
When the system checks for the order number
Then the system provides a message indicating the absence of order number
@TC-173
Scenario: Verify absence of shipping address
Given the user is on the order confirmation page
When the system checks for the shipping address
Then the system provides a message indicating the absence of shipping address
@TC-173
Scenario: Ensure absence of items purchased
Given the user is on the order confirmation page
When the system checks for items purchased
Then the system provides a message indicating the absence of items purchased
@TC-173
Scenario: Check for error messages regarding missing information
Given the user is on the order confirmation page
When the system checks for missing information
Then error messages or alerts are displayed for missing information
@TC-173
Scenario: Verify page layout remains intact despite missing data
Given the user is on the order confirmation page
When the system checks the page layout
Then the page layout is clear and information is easily readable despite missing data
@TC-173
Scenario: Confirm absence of total amount due to missing order details
Given the user is on the order confirmation page
When the system checks for the total amount
Then the total amount is not displayed
And a message explains the reason
@TC-173
Scenario: Check absence of estimated delivery date
Given the user is on the order confirmation page
When the system checks for the estimated delivery date
Then the system provides a message indicating the absence of an estimated delivery date
@TC-173
Scenario: Verify absence of payment method details
Given the user is on the order confirmation page
When the system checks for payment method details
Then the system provides a message indicating the absence of payment method details
@TC-173
Scenario: Ensure customer support contact information is available
Given the user is on the order confirmation page
When the system checks for customer support contact information
Then customer support contact information is displayed
@TC-173
Scenario: Check absence of order tracking link
Given the user is on the order confirmation page
When the system checks for a link to track the order
Then the system provides a message indicating the absence of tracking information
@TC-173
Scenario: Verify print option is disabled or provides a message about missing data
Given the user is on the order confirmation page
When the system checks the print option
Then the print option is disabled or provides a message about missing data
@TC-173
Scenario: Ensure email option is disabled or provides a message about missing data
Given the user is on the order confirmation page
When the system checks the email option
Then the email option is disabled or provides a message about missing data
@TC-173
Scenario: Check for promotional offers or discounts despite missing order details
Given the user is on the order confirmation page
When the system checks for promotional offers or discounts
Then promotional offers or discounts are displayed if applicable
And a message explains the missing order details
@TC-173
Scenario: Verify system logs an error for missing order confirmation details
Given the user is on the order confirmation page
When the system checks for missing order confirmation details
Then the system logs an error for auditing purposes