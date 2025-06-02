Feature: Password Recovery Initiation via 'Forgot Password' Link
@TC-117
Scenario: Verify users can initiate password recovery using the 'Forgot Password' link
Given the user is on the login page
When the user clicks on the 'Forgot Password' link
Then the 'Forgot Password' page is displayed
@TC-117
Scenario: Enter registered email address for password recovery
Given the user is on the 'Forgot Password' page
When the user enters the registered email address "user@example.com"
Then the email address is accepted
@TC-117
Scenario: Submit password recovery request
Given the user has entered a registered email address
When the user submits the password recovery request
Then a confirmation message for password recovery is displayed
@TC-117
Scenario: Check for password recovery email
Given the user has submitted a password recovery request
When the user checks the registered email inbox
Then the password recovery email is received
@TC-117
Scenario: Verify content of the password recovery email
Given the password recovery email is received
When the user opens the email
Then the email contains a secure recovery link
@TC-117
Scenario: Use the recovery link
Given the user has a secure recovery link from the email
When the user attempts to use the recovery link
Then the recovery link leads to the password reset page
@TC-117
Scenario: Log out of any active sessions
Given the user is logged in
When the user logs out of any active sessions
Then the user is logged out successfully