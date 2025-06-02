Feature: Return Flow for Expired Return Period
@TC-10
Scenario: Verify that a customer cannot initiate a return for an Achieve access code after the eligible period
Given the customer has purchased an Achieve access code
And the purchase was made more than 14 days ago
And the customer is logged in to the BFW store with their account
When the customer navigates to the 'Order Details' section
And selects the order with ID 87654
Then the order details for order ID 87654 are displayed
And the access code is ACH54321
When the customer attempts to click on the 'Initiate Return' button for the Achieve access code
Then the 'Initiate Return' button is disabled or not present
And the customer is notified that the return period has expired