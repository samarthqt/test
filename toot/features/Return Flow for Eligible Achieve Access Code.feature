Feature: Return Flow for Eligible Achieve Access Code
To verify that a customer can initiate a return for an Achieve access code within the eligible period.
@TC-9
Scenario: Customer initiates return for Achieve access code
Given a customer has purchased an Achieve access code
And the purchase was made within the last 14 days
When the customer logs in to the BFW store with their account
Then the customer's account dashboard is displayed
@TC-9
Scenario: Navigate to Order Details section
Given the customer is logged in
When the customer navigates to the 'Order Details' section
Then order details are displayed with a list of recent purchases
@TC-9
Scenario: Select order with ID 98765
Given the order details are displayed
When the customer selects the order with ID 98765
Then order details for order ID 98765 are displayed
@TC-9
Scenario: Initiate return for Achieve access code
Given the order details for order ID 98765 are displayed
When the customer clicks on the 'Initiate Return' button for the Achieve access code
Then the 'Initiate Return' form is displayed
@TC-9
Scenario: Submit return form
Given the 'Initiate Return' form is displayed
When the customer completes the return form with required details and submits
Then the return request is submitted successfully
@TC-9
Scenario: Verify refund processing by Braintree
Given the return request is submitted
When the refund is processed by Braintree
Then the refund is processed immediately by Braintree
@TC-9
Scenario: Check email confirmation
Given the refund is processed
When the customer checks their email for confirmation
Then the customer receives a confirmation email from Braintree
@TC-9
Scenario: Verify order details in daily return request email to CX
Given the return request is submitted
When verifying the order details in the daily return request email to CX
Then order details are present in the daily return request email to CX
@TC-9
Scenario: Check CX system for return request
Given the return request is submitted
When checking the CX system for the return request
Then CX receives the return request and takes appropriate action
@TC-9
Scenario Outline: Verify Achieve course access
Given the return request is processed
When verifying access to the Achieve course
Then access to the Achieve course is revoked if the access code was redeemed
And access code is zeroed out if not redeemed
And access code cannot be used post-refund
Examples:
| Access Code Status |
| Redeemed           |
| Not Redeemed       |