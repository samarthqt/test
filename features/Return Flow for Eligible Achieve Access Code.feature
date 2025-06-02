Feature: Return Flow for Eligible Achieve Access Code
To verify that a customer can initiate a return for an Achieve access code within the eligible period.
@TC-9
Scenario: Customer initiates return for Achieve access code
Given the customer has purchased an Achieve access code
And the purchase was made within the last 14 days
When the customer logs in to the BFW store with their account
Then the customer's account dashboard is displayed
And the order details are displayed with a list of recent purchases
@TC-9
Scenario: Access order details for return initiation
Given the customer is on the account dashboard
When the customer navigates to the 'Order Details' section
Then the order details for order ID 98765 are displayed
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
Scenario: Verify refund processing
Given the return request is submitted successfully
When the refund is processed by Braintree
Then the refund is processed immediately by Braintree
@TC-9
Scenario: Email confirmation for return
Given the refund is processed by Braintree
When the customer checks their email
Then the customer receives a confirmation email from Braintree
@TC-9
Scenario: Verify order details in daily return request email
Given the return request is submitted successfully
When the daily return request email to CX is sent
Then the order details are included in the daily return request email to CX
@TC-9
Scenario: Verify return request in CX system
Given the return request is submitted successfully
When the CX system is checked for the return request
Then CX receives the return request and takes appropriate action
@TC-9
Scenario: Revoke access to Achieve course if access code redeemed
Given the access code was redeemed
When the refund is processed
Then access to the Achieve course is revoked
@TC-9
Scenario: Zero out access code if not redeemed
Given the access code was not redeemed
When the refund is processed
Then the access code is zeroed out and can no longer be used
@TC-9
Scenario: Ensure access code cannot be used post-refund
Given the refund is processed
When the customer attempts to use the access code
Then the access code is invalid for accessing the Achieve course