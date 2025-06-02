Feature: Attempt account creation with an already registered email and verify system response
@TC-87
Scenario: Attempt account creation with an already registered email
Given I am on the account creation page
When I enter the email "registereduser@example.com" and password "NewPass123"
And I click on the "Create Account" button
Then I should see an error message indicating the email is already registered
And the error message should clearly state the reason for account creation failure
@TC-87
Scenario: Attempt account creation with a different email
Given I am on the account creation page
When I enter a non-registered email and a password
And I click on the "Create Account" button
Then the account should be created successfully
@TC-87
Scenario: Check system behavior after multiple attempts with registered email
Given I am on the account creation page
When I repeatedly attempt to create an account with the email "registereduser@example.com"
Then the system should consistently display an error message for each attempt
@TC-87
Scenario: Verify error message accessibility
Given I have attempted account creation with an already registered email
Then the error message should be accessible and clearly visible
@TC-87
Scenario: Check error message on mobile devices
Given I have attempted account creation with an already registered email on a mobile device
Then the error message should be displayed correctly on mobile devices
@TC-87
Scenario: Attempt account creation with registered email and invalid password format
Given I am on the account creation page
When I enter the email "registereduser@example.com" and an invalid password format
And I click on the "Create Account" button
Then I should see an error message for both registered email and invalid password
@TC-87
Scenario: Verify system logs for account creation attempts
Given I have attempted account creation with an already registered email
Then the system logs should contain records of failed account creation attempts
@TC-87
Scenario: Attempt account creation with registered email during high traffic
Given the system is experiencing high traffic
When I attempt to create an account with the email "registereduser@example.com"
Then the system should handle high traffic efficiently and display an error message
@TC-87
Scenario: Check system response to account creation with registered email and weak password
Given I am on the account creation page
When I enter the email "registereduser@example.com" and a weak password
And I click on the "Create Account" button
Then the system should prompt for a stronger password and display an email registration error
@TC-87
Scenario: Verify system response when attempting account creation without internet connection
Given I am offline
When I attempt to create an account with the email "registereduser@example.com"
Then the system should display an error message indicating a network issue
@TC-87
Scenario: Attempt account creation using social media account linked to registered email
Given I have a social media account linked to the email "registereduser@example.com"
When I attempt to create an account using that social media account
Then the system should allow account creation via social media despite the registered email
@TC-87
Scenario: Verify system behavior with expired session during account creation
Given my session has expired
When I attempt to create an account with the email "registereduser@example.com"
Then the system should prompt me to re-login and display an error message for the registered email