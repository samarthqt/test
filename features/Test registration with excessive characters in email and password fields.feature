Feature: Test registration with excessive characters in email and password fields
Verify that the system rejects registration with characters exceeding the maximum allowable limit in email and password fields.
@TC-330
Scenario: Navigate to the registration page
Given the user registration page is accessible
When I navigate to the registration page of the application
Then the registration page is displayed
@TC-330
Scenario: Enter excessive characters in the email field
Given I understand maximum character limits for email and password fields
When I enter excessive characters in the email field
Then the system displays an error message for exceeding character limit
@TC-330
Scenario: Enter excessive characters in the password field
Given I understand maximum character limits for email and password fields
When I enter excessive characters in the password field
Then the system displays an error message for exceeding character limit
@TC-330
Scenario: Fill in other required registration fields with valid data
Given I have entered excessive characters in the email and password fields
When I fill in other required registration fields with valid data
Then all fields are populated correctly
@TC-330
Scenario: Click on the 'Register' button
Given I have entered excessive characters in the email and password fields
When I click on the 'Register' button
Then the registration process is not initiated due to errors
@TC-330
Scenario: Check if the registration error message is displayed
Given I have attempted to register with excessive characters
When I check if the registration error message is displayed
Then the registration error message is displayed for email and password
@TC-330
Scenario: Attempt to log in using the email and password with excessive characters
Given I have attempted registration with excessive characters
When I attempt to log in using the email and password with excessive characters
Then the user is unable to log in due to invalid credentials
@TC-330
Scenario: Verify that no registration email is received
Given I have attempted registration with excessive characters
When I verify that no registration email is received
Then no registration confirmation email is received
@TC-330
Scenario: Check the user profile for any registration details
Given I have attempted registration with excessive characters
When I check the user profile for any registration details
Then the user profile is not created
@TC-330
Scenario: Verify that the system does not store excessive characters in email or password
Given I have attempted registration with excessive characters
When I verify that the system does not store excessive characters in email or password
Then the system does not store excessive characters
@TC-330
Scenario: Log out from the application if logged in
Given I am logged in
When I log out from the application
Then the user is logged out successfully
@TC-330
Scenario: Attempt to reset the password using the email with excessive characters
Given I have entered excessive characters in the email field
When I attempt to reset the password using the email with excessive characters
Then the system displays an error message for invalid email
@TC-330
Scenario: Verify the password reset functionality with excessive characters
Given I have entered excessive characters in the email field
When I verify the password reset functionality with excessive characters
Then the password reset is unsuccessful due to invalid email
@TC-330
Scenario: Check the system logs for errors during registration attempts
Given I have attempted registration with excessive characters
When I check the system logs for errors during registration attempts
Then errors are logged for exceeding character limits
@TC-330
Scenario: Ensure the system does not store invalid registration data
Given I have attempted registration with excessive characters
When I ensure the system does not store invalid registration data
Then invalid registration data is not stored