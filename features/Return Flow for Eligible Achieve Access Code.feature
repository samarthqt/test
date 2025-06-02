Feature: Return Flow for Eligible Achieve Access Code
To verify that a customer can initiate a return for an Achieve access code within the eligible period.
@TC-9
Scenario: Customer initiates a return for an Achieve access code
Given the customer has purchased an Achieve access code
And the order ID is 98765
And the purchase was made within the last 14 days
When the customer logs in to the BFW store with their account
Then the customer's account dashboard is displayed
@TC-9
Scenario: Navigate to Order Details
Given the customer is logged in
When the customer navigates to the 'Order Details' section
Then the order details are displayed with a list of recent purchases
@TC-9
Scenario: Select Order for Return
Given the order details are displayed
When the customer selects the order with ID 98765
Then the order details for order ID 98765 are displayed
@TC-9
Scenario: Initiate Return for Achieve Access Code
Given the order details for order ID 98765 are displayed
When the customer clicks on the 'Initiate Return' button for the Achieve access code
Then the 'Initiate Return' form is displayed
@TC-9
Scenario: Submit Return Form
Given the 'Initiate Return' form is displayed
When the customer completes the return form with required details and submits it
Then the return request is submitted successfully
@TC-9
Scenario: Refund Process Verification
Given the return request is submitted
When the refund is processed by Braintree
Then the refund is processed immediately by Braintree
@TC-9
Scenario: Email Confirmation
Given the refund is processed
When the customer checks their email for confirmation
Then the customer receives a confirmation email from Braintree
@TC-9
Scenario: Order Details in Daily Return Request Email
Given the refund is processed
When the order details are verified in the daily return request email to CX
Then the order details are present in the daily return request email to CX
@TC-9
Scenario: CX System Return Request Verification
Given the refund is processed
When the CX system is checked for the return request
Then CX receives the return request and takes appropriate action
@TC-9
Scenario: Revoke Access to Achieve Course
Given the Achieve access code was redeemed
When the refund is processed
Then access to the Achieve course is revoked
@TC-9
Scenario: Zero Out Access Code if Not Redeemed
Given the Achieve access code was not redeemed
When the refund is processed
Then the access code is zeroed out and can no longer be used
@TC-9
Scenario: Access Code Invalid Post-Refund
Given the refund is processed
When the customer attempts to use the access code
Then the access code is invalid for accessing the Achieve course