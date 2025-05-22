Feature: Return Flow for Eligible Achieve Access Code
@TC-9
Scenario: Verify customer can initiate a return for an Achieve access code within the eligible period
Given the customer has purchased an Achieve access code
And the purchase was made within the last 14 days
When the customer logs in to the BFW store with their account
Then the customer's account dashboard is displayed
@TC-9
Scenario: Navigate to the Order Details section
Given the customer is logged in
When the customer navigates to the 'Order Details' section
Then order details are displayed with a list of recent purchases
@TC-9
Scenario: Select the order with ID 98765
Given the customer is on the 'Order Details' section
When the customer selects the order with ID 98765
Then order details for order ID 98765 are displayed
@TC-9
Scenario: Initiate return for Achieve access code
Given the customer is viewing order details for order ID 98765
When the customer clicks on the 'Initiate Return' button for the Achieve access code
Then the 'Initiate Return' form is displayed
@TC-9
Scenario: Complete and submit the return form
Given the 'Initiate Return' form is displayed
When the customer completes the return form with required details and submits
Then the return request is submitted successfully
@TC-9
Scenario: Verify refund is processed by Braintree
Given the return request is submitted
When the refund is processed by Braintree
Then the refund is processed immediately
@TC-9
Scenario: Check customer's email for confirmation
Given the refund is processed
When the customer checks their email
Then the customer receives a confirmation email from Braintree
@TC-9
Scenario: Verify order details in daily return request email to CX
Given the return request is submitted
When the daily return request email is sent to CX
Then order details are present in the daily return request email to CX
@TC-9
Scenario: Check CX system for the return request
Given the daily return request email is sent to CX
When the CX system is checked for the return request
Then CX receives the return request and takes appropriate action
@TC-9
Scenario: Verify access to Achieve course is revoked if access code was redeemed
Given the return request is processed
When the access code was redeemed
Then access to the Achieve course is revoked
@TC-9
Scenario: Verify access code is zeroed out if not redeemed
Given the return request is processed
When the access code was not redeemed
Then the access code is zeroed out and can no longer be used
@TC-9
Scenario: Ensure access code cannot be used post-refund
Given the return request is processed
When the refund is completed
Then the access code is invalid for accessing the Achieve course