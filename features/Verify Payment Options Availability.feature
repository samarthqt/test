Feature: Verify Payment Options Availability
@TC-318
Scenario: Verify Stripe and PayPal are available as payment options during checkout
Given the user logs into the system with valid credentials
Then the user is successfully logged in
And Stripe and PayPal accounts are set up for testing
@TC-318
Scenario: Navigate to the checkout page
Given the user navigates to the checkout page
Then the checkout page is displayed with payment options
@TC-318
Scenario: Select Stripe as the payment method
Given the user selects Stripe as the payment method
Then Stripe payment option is selected successfully
@TC-318
Scenario: Enter payment details for Stripe
Given the user enters payment details for Stripe
Then payment details are entered correctly
@TC-318
Scenario: Confirm the payment using Stripe
Given the user confirms the payment using Stripe
Then payment is processed successfully using Stripe
@TC-318
Scenario: Verify transaction confirmation for Stripe
Given the transaction confirmation for Stripe is verified
Then transaction confirmation is received for Stripe
@TC-318
Scenario Outline: Repeat payment process for PayPal
Given the user selects PayPal as the payment method
Then PayPal payment option is selected successfully
When the user enters payment details for PayPal
Then payment details are entered correctly
And the user confirms the payment using PayPal
Then payment is processed successfully using PayPal
And transaction confirmation for PayPal is verified
Then transaction confirmation is received for PayPal
@TC-318
Scenario: Check for alternative payment methods availability
Given the user checks for alternative payment methods availability
Then alternative payment methods are available and selectable
@TC-318
Scenario: Ensure security measures are in place for payment processing
Given security measures are ensured during payment processing
Then security measures like encryption are verified during payment
@TC-318
Scenario: Monitor system logs for payment-related errors
Given system logs are monitored for payment-related errors
Then no critical errors are logged during payment processing
@TC-318
Scenario: Verify user notifications for successful payment
Given user notifications for successful payment are verified
Then user is notified accurately upon successful payment
@TC-318
Scenario: Assess impact of payment failures on user experience
Given the impact of payment failures on user experience is assessed
Then the system handles payment failures gracefully with user notifications
@TC-318
Scenario: Test system recovery from payment interruptions
Given system recovery from payment interruptions is tested
Then the system recovers and resumes payment processing without data loss
@TC-318
Scenario: Evaluate system performance during peak payment times
Given system performance during peak payment times is evaluated
Then the system performs efficiently during peak payment times