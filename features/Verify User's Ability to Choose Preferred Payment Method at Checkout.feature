Feature: Verify User's Ability to Choose Preferred Payment Method at Checkout
@TC-14
Scenario: User can select Credit Card as the payment method
Given user is logged in and on the checkout page
When user selects Credit Card as the payment method
And user enters valid Credit Card details
Then Credit Card details are accepted and validated
And transaction is processed successfully with confirmation message
@TC-14
Scenario: User can select PayPal as the payment method
Given user is logged in and on the checkout page
When user selects PayPal as the payment method
And user enters valid PayPal account details
Then PayPal account details are accepted and validated
And transaction is processed successfully with confirmation message
@TC-14
Scenario: User can change payment method before finalizing transaction
Given user is logged in and on the checkout page
When user selects a payment method
And user decides to change payment method
Then user can change payment method before completing transaction
@TC-14
Scenario: Payment method selection on mobile device
Given user is logged in and on the checkout page on a mobile device
When user selects a payment method
Then payment method selection is accessible and functional on mobile
@TC-14
Scenario: Attempt transaction with unsupported payment method
Given user is logged in and on the checkout page
When user attempts to select an unsupported payment method
Then unsupported payment method is not selectable
And error message is displayed
@TC-14
Scenario: Verify payment method selection in different browsers
Given user is logged in and on the checkout page in a browser
When user selects a payment method
Then payment method selection is consistent across browsers
@TC-14
Scenario: Simulate slow internet connection during payment method selection
Given user is logged in and on the checkout page with a slow internet connection
When user selects a payment method
Then payment method selection remains functional under slow connection
@TC-14
Scenario: Check UI responsiveness during payment method selection
Given user is logged in and on the checkout page
When user selects a payment method
Then UI remains responsive during payment method selection
@TC-14
Scenario: Verify payment method selection with multiple items in cart
Given user is logged in and on the checkout page with multiple items in the cart
When user selects a payment method
Then payment method selection is functional with multiple items
@TC-14
Scenario: Test payment method selection with maximum transaction amount
Given user is logged in and on the checkout page
When user selects a payment method
And user enters maximum transaction amount
Then payment method selection accommodates maximum transaction amount
@TC-14
Scenario: Verify transaction confirmation with selected payment method
Given user is logged in and on the checkout page
When user completes a transaction with a selected payment method
Then transaction confirmation reflects selected payment method
@TC-14
Scenario: Check error handling for declined payment method
Given user is logged in and on the checkout page
When user selects a payment method and attempts a transaction
And the payment method is declined
Then error message is displayed for declined payment method