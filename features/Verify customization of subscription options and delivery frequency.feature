Feature: Verify customization of subscription options and delivery frequency
@TC-365
Scenario: Navigate to the subscription customization page
Given the user is logged in with User ID: 54321
When the user navigates to the subscription customization page
Then the user should be directed to the customization page displaying available options
@TC-365
Scenario: Select a product for customization
Given the user is on the subscription customization page
When the user selects a product with Product ID: 09876 for customization
Then the product details should be displayed including customization options
@TC-365
Scenario: Choose a delivery frequency
Given the user is customizing a product
When the user chooses a delivery frequency of "Monthly"
Then the selected frequency should be highlighted and ready for confirmation
@TC-365
Scenario: Enter payment information
Given the user has chosen a delivery frequency
When the user enters payment information using PayPal
Then the payment information should be verified and accepted
@TC-365
Scenario: Confirm the customization setup
Given the payment information is accepted
When the user confirms the customization setup
Then a confirmation message should be displayed indicating successful customization
@TC-365
Scenario: Check email for customization confirmation
Given the customization setup is confirmed
When the user checks their email
Then an email confirming customization details should be received
@TC-365
Scenario: Verify customization details in user account
Given the user has received email confirmation
When the user checks their account
Then customization details should be correctly listed under the user account
@TC-365
Scenario: Modify delivery frequency
Given the user has an active customization
When the user attempts to modify the delivery frequency
Then the user should be able to change delivery frequency successfully
@TC-365
Scenario: Cancel the customization
Given the user has an active customization
When the user attempts to cancel the customization
Then the customization should be canceled and a confirmation message displayed
@TC-365
Scenario: Verify refund process for canceled customization
Given the customization is canceled within the allowed period
When the user checks the refund process
Then the refund should be processed as per policy
@TC-365
Scenario: Check for delivery schedule conflicts
Given the user has an active customization
When the user checks the delivery schedule
Then no conflicts should be found; schedule is clear
@TC-365
Scenario: Verify notification settings for customization updates
Given the user has an active customization
When the user attempts to enable/disable notifications
Then the user should be able to successfully change notification settings
@TC-365
Scenario: Attempt customization with invalid payment method
Given the user is customizing a product
When the user enters invalid payment information
Then an error message should be displayed indicating payment method issue
@TC-365
Scenario: Check system response to customization frequency change
Given the user has an active customization
When the user changes the customization frequency
Then the system should update frequency without errors
@TC-365
Scenario: Verify customization renewal process
Given the user has an active customization
When the renewal period is reached
Then the customization should renew automatically as per schedule