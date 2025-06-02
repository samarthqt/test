Feature: Verify Users Can Select from Multiple Payment Options at Checkout
@TC-113
Scenario: Verify navigation to the shopping cart
Given the user is logged into the application
When the user navigates to the shopping cart
Then the shopping cart is displayed with all added items
@TC-113
Scenario: Proceed to the checkout page
Given the user has items in the shopping cart
When the user proceeds to the checkout page
Then the checkout page is displayed with the order summary
@TC-113
Scenario: Verify the list of available payment options
Given the user is on the checkout page
When the user views the list of available payment options
Then the list includes Credit Card, PayPal, and Gift Card
@TC-113
Scenario: Select Credit Card as the payment option
Given the user is on the checkout page
When the user selects 'Credit Card' as the payment option and enters valid card details
Then the system accepts the card details and proceeds to the next step
@TC-113
Scenario: Select PayPal as the payment option
Given the user is on the checkout page
When the user goes back to the payment options and selects 'PayPal'
Then the system redirects to the PayPal login page
@TC-113
Scenario: Confirm payment with PayPal
Given the user is on the PayPal login page
When the user logs in to PayPal and confirms the payment
Then the payment is confirmed and the order is processed
@TC-113
Scenario: Select Gift Card as the payment option
Given the user is on the checkout page
When the user returns to the payment options and selects 'Gift Card'
Then the system prompts for the gift card code
@TC-113
Scenario: Enter and apply valid gift card code
Given the user is prompted for the gift card code
When the user enters a valid gift card code and applies it
Then the gift card code is accepted and the order total is updated
@TC-113
Scenario: Place the order with the selected payment option
Given the user has selected a payment option
When the user attempts to place the order
Then the order is successfully placed with the selected payment option
@TC-113
Scenario: Verify order confirmation page displays selected payment option
Given the order is successfully placed
When the user views the order confirmation page
Then the page displays the correct payment option used
@TC-113
Scenario: Check email confirmation includes payment details
Given the order is successfully placed
When the user checks the email confirmation for the order
Then the email confirmation includes accurate payment details
@TC-113
Scenario: Handle invalid payment option selection
Given the user is on the checkout page
When the user selects an invalid payment option
Then the system displays an appropriate error message
@TC-113
Scenario: Test responsiveness of payment options section on different devices
Given the user is on the checkout page
When the user tests the responsiveness of the payment options section on different devices
Then the payment options section is responsive and user-friendly on all devices
@TC-113
Scenario: Verify security of payment information
Given the user is on the checkout page
When the user enters payment information during checkout
Then the payment information is securely transmitted and stored
@TC-113
Scenario: Check performance of checkout process with multiple payment options
Given the user is on the checkout page
When the user proceeds through the checkout process with multiple payment options
Then the checkout process is smooth and efficient