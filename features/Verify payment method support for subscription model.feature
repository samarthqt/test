Feature: Verify payment method support for subscription model
@TC-366
Scenario: Navigate to the payment method update page
Given the user has a registered account
And the user is logged in
When the user navigates to the payment method update page
Then the user is directed to the payment method update page displaying current payment options
@TC-366
Scenario: Select a payment method to update
Given the user is on the payment method update page
When the user selects a payment method to update
Then current payment details are displayed for editing
@TC-366
Scenario: Enter new payment information
Given the user has selected a payment method to update
When the user enters new payment information
Then new payment information is verified and accepted
@TC-366
Scenario: Confirm the payment method update
Given the user has entered new payment information
When the user confirms the payment method update
Then a confirmation message is displayed indicating successful update
@TC-366
Scenario: Check email for payment method update confirmation
Given the payment method update is successful
When the user checks their email
Then an email is received confirming payment method update
@TC-366
Scenario: Verify updated payment method in user account
Given the payment method update is confirmed
When the user checks their account
Then the updated payment method is correctly listed under user account
@TC-366
Scenario: Attempt to use the updated payment method for subscription
Given the payment method is updated
When the user attempts to use the updated payment method for subscription
Then subscription payment is processed successfully using the updated method
@TC-366
Scenario: Attempt to revert payment method update
Given the payment method is updated
When the user attempts to revert the payment method update
Then the user is able to revert payment method successfully
@TC-366
Scenario: Verify refund process if payment method update is reverted
Given the payment method update is reverted within the allowed period
When the refund process is initiated
Then refund is processed as per policy
@TC-366
Scenario: Check for any subscription payment conflicts
Given the payment method is updated
When the user checks for subscription payment conflicts
Then no conflicts are found; payment schedule is clear
@TC-366
Scenario: Verify notification settings for payment updates
Given the user wants to manage notifications for payment updates
When the user enables or disables notifications
Then user can enable/disable notifications successfully
@TC-366
Scenario: Attempt payment update with invalid payment method
Given the user attempts to update payment method
When the user enters invalid payment method information
Then an error message is displayed indicating payment method issue
@TC-366
Scenario: Check system response to payment method change
Given the user updates the payment method
When the system processes the payment method change
Then system updates payment method without errors
@TC-366
Scenario: Verify payment renewal process with updated method
Given the payment method is updated
When the payment renewal process occurs
Then payment renews automatically as per schedule using updated method
@TC-366
Scenario: Attempt to update payment method during subscription renewal
Given the subscription renewal is due
When the user updates the payment method during subscription renewal
Then payment method update is processed without affecting renewal