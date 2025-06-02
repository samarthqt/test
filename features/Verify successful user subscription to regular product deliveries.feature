Feature: Verify successful user subscription to regular product deliveries
@TC-364
Scenario: User navigates to the product subscription page
Given the user is logged in with User ID "12345"
When the user navigates to the product subscription page
Then the user is directed to the subscription page displaying available products
@TC-364
Scenario: User selects a product for subscription
Given the user is on the subscription page
When the user selects a product with Product ID "67890"
Then product details are displayed including subscription options
@TC-364
Scenario: User chooses the subscription frequency
Given the user has selected a product for subscription
When the user chooses the subscription frequency "Weekly"
Then the selected frequency is highlighted and ready for confirmation
@TC-364
Scenario: User enters payment information
Given the user has chosen the subscription frequency
When the user enters payment information using Credit Card
Then the payment information is verified and accepted
@TC-364
Scenario: User confirms the subscription setup
Given the payment information is accepted
When the user confirms the subscription setup
Then a confirmation message is displayed indicating successful subscription
@TC-364
Scenario: User checks email for subscription confirmation
Given the subscription setup is confirmed
When the user checks their email
Then an email is received confirming subscription details
@TC-364
Scenario: User verifies subscription details in their account
Given the user has received email confirmation
When the user checks their account
Then subscription details are correctly listed under the user account
@TC-364
Scenario: User attempts to modify subscription frequency
Given the user has an active subscription
When the user attempts to change the subscription frequency
Then the user is able to change subscription frequency successfully
@TC-364
Scenario: User attempts to cancel the subscription
Given the user has an active subscription
When the user attempts to cancel the subscription
Then the subscription is canceled and a confirmation message is displayed
@TC-364
Scenario: Verify refund process for subscription cancellation
Given the subscription is canceled within the allowed period
When the user requests a refund
Then the refund is processed as per policy
@TC-364
Scenario: Check for delivery schedule conflicts
Given the user has an active subscription
When the system checks the delivery schedule
Then no conflicts are found; schedule is clear
@TC-364
Scenario: Verify notification settings for subscription updates
Given the user has an active subscription
When the user attempts to enable/disable notifications
Then the user can enable/disable notifications successfully
@TC-364
Scenario: Attempt subscription with invalid payment method
Given the user is on the subscription payment page
When the user enters an invalid payment method
Then an error message is displayed indicating payment method issue
@TC-364
Scenario: Check system response to subscription frequency change
Given the user has changed the subscription frequency
When the system updates the frequency
Then the system updates frequency without errors
@TC-364
Scenario: Verify subscription renewal process
Given the user has an active subscription
When the subscription renewal period arrives
Then the subscription renews automatically as per schedule