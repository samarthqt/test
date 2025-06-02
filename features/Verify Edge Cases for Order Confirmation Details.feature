Feature: Verify Edge Cases for Order Confirmation Details
@TC-174
Scenario: Navigate to the order confirmation page after completing the purchase
Given the user has completed a purchase transaction with edge case data
When the user navigates to the order confirmation page
Then the order confirmation page is displayed
@TC-174
Scenario: Check if the order number with maximum digits is displayed correctly
Given the order ID is '99999999999999999999'
Then the order number '99999999999999999999' is displayed without truncation
@TC-174
Scenario: Verify that the extremely long shipping address is displayed correctly
Given the shipping address exceeds normal limits
Then the shipping address is displayed without truncation or errors
@TC-174
Scenario: Ensure that the absence of purchased items is handled gracefully
Given no items were purchased
Then the system indicates no items were purchased with a user-friendly message
@TC-174
Scenario: Check for any UI issues caused by the long address
Given the shipping address exceeds normal limits
Then the UI remains intact and user-friendly despite the long address
@TC-174
Scenario: Verify that the total amount is displayed as zero due to no items purchased
Given no items were purchased
Then the total amount is displayed as zero with a message explaining the reason
@TC-174
Scenario: Confirm the estimated delivery date is not applicable due to no items
Given no items were purchased
Then the message indicates no delivery date due to no items purchased
@TC-174
Scenario: Check if the payment method used is listed as N/A
Given no items were purchased
Then the payment method is displayed as N/A with a message explaining the reason
@TC-174
Scenario: Ensure that customer support contact information is still available
Then customer support contact information is displayed
@TC-174
Scenario: Check if a link to track the order is unavailable due to no items
Given no items were purchased
Then the system provides a message indicating the absence of tracking information
@TC-174
Scenario: Verify that the print option is disabled or provides a message about no items
Given no items were purchased
Then the print option is disabled or provides a message about no items
@TC-174
Scenario: Ensure the email option is disabled or provides a message about no items
Given no items were purchased
Then the email option is disabled or provides a message about no items
@TC-174
Scenario: Check if any promotional offers or discounts are displayed despite no items
Given no items were purchased
Then promotional offers or discounts are displayed if applicable, with a message about no items
@TC-174
Scenario: Verify that the system logs an error for handling edge case order confirmation details
Then the system logs an error for handling edge case order confirmation details for auditing purposes
@TC-174
Scenario: Check if the system can handle simultaneous edge case orders without crashing
Given multiple edge case orders are placed simultaneously
Then the system handles multiple edge case orders without crashing or performance issues