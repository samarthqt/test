Feature: Return Flow for Expired Return Period
@TC-10
Scenario: Verify that a customer cannot initiate a return for an Achieve access code after the eligible period
Given a customer has purchased an Achieve access code
And the purchase was made more than 14 days ago
When the customer logs in to the BFW store with their account
Then the customer's account dashboard is displayed
And the Order ID is 87654
When the customer navigates to the 'Order Details' section
Then order details are displayed with a list of recent purchases
And the Customer Email is customer@example.com
When the customer selects the order with ID 87654
Then order details for order ID 87654 are displayed
And the Access Code is ACH54321
When the customer attempts to click on the 'Initiate Return' button for the Achieve access code
Then the 'Initiate Return' button is disabled or not present
And the Purchase Date is 20 days ago
Then the system does not allow return initiation
And the customer is notified that the return period has expired