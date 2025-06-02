Feature: Simulate Payment Failures
@TC-319
Scenario: Verify system handles payment failures with invalid credit card
Given User is logged into the system with valid credentials
When User navigates to the checkout page
And User selects a payment method and enters invalid credit card details
Then Payment fails due to invalid credit card details
And User receives notification about payment failure
And Payment failure errors are logged correctly
@TC-319
Scenario: Verify system handles payment failures with network issues
Given User is logged into the system with valid credentials
When User navigates to the checkout page
And User selects a payment method and enters valid payment details
And Network failure occurs during payment processing
Then Payment fails due to network issues
And User receives notification about network-related payment failure
And Payment failure errors are logged correctly
@TC-319
Scenario Outline: Verify system handles payment failures with expired PayPal account
Given User is logged into the system with valid credentials
When User navigates to the checkout page
And User selects a payment method and enters expired PayPal account details
Then Payment fails due to expired PayPal account
And User receives notification about expired account failure
And Payment failure errors are logged correctly
@TC-319
Scenario: Test system recovery from payment failures
Given User is logged into the system with valid credentials
When Payment fails due to any reason
Then System recovers and allows retry of payment without data loss
And User is able to update payment details and retry payment
@TC-319
Scenario: Monitor system performance during payment failure handling
Given User is logged into the system with valid credentials
When Payment failure occurs
Then System performs efficiently during payment failure handling
@TC-319
Scenario: Assess the impact of payment failures on user experience
Given User is logged into the system with valid credentials
When Payment failure occurs
Then System handles payment failures gracefully with user notifications
@TC-319
Scenario: Evaluate system logs for any critical errors during payment failures
Given User is logged into the system with valid credentials
When Payment failure occurs
Then No critical errors are logged during payment failure handling