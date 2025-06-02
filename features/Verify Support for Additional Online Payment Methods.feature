Feature: Verify Support for Additional Online Payment Methods
@TC-170
Scenario: Verify the presence of additional payment methods
Given the user is logged into the application
And the user has items in the shopping cart
When the user navigates to the shopping cart page
Then the shopping cart page is displayed with items listed
When the user clicks on the 'Proceed to Checkout' button
Then the checkout page is displayed with payment options
And additional payment methods (Apple Pay, Google Pay) are displayed as options
@TC-170
Scenario: Complete payment using Apple Pay
Given the user is on the checkout page with payment options
When the user selects 'Apple Pay' as the payment method
Then 'Apple Pay' option is selected
When the user completes the payment using Apple Pay
Then the payment is processed successfully using Apple Pay
And a confirmation message is displayed
@TC-170
Scenario: Complete payment using Google Pay
Given the user is on the checkout page with payment options
When the user selects 'Google Pay' as the payment method
Then 'Google Pay' option is selected
When the user completes the payment using Google Pay
Then the payment is processed successfully using Google Pay
And a confirmation message is displayed
@TC-170
Scenario: Verify order summary and payment details
Given the user has completed a payment
When the user verifies the order summary and payment details
Then the order summary and payment details are accurate and correspond to the selected payment method
@TC-170
Scenario: Log out from the user account
Given the user has completed their activities
When the user logs out from the user account
Then the user is logged out successfully