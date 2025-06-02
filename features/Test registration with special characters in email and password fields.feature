Feature: Test registration with special characters in email and password fields
Verify the system behavior when special characters are used in email and password fields during registration.
@TC-331
Scenario: Register with special characters in email and password fields
Given the user registration page is accessible
When I navigate to the registration page of the application
Then the registration page is displayed
When I enter "user+special@example.com" in the email field
Then the email with special characters is entered successfully
When I enter "P@ssw0rd!@#$%^&*()" in the password field
Then the password with special characters is entered successfully
When I fill in other required registration fields with valid data
Then all fields are populated correctly
When I click on the 'Register' button
Then the registration process is initiated
When I check if the registration confirmation message is displayed
Then the registration confirmation message is displayed
When I verify the email received for registration confirmation
Then email confirmation is received successfully
When I attempt to log in using the registered email and password
Then the user is able to log in successfully
When I check the user profile for registration details
Then the user profile displays correct registration details
When I verify that the system does not truncate special characters in email or password
Then email and password are stored completely with special characters
When I log out from the application
Then the user is logged out successfully
When I attempt to reset the password using the registered email
Then the password reset link is sent to the email
When I verify the password reset functionality with special characters
Then password reset is successful using special characters
When I check the system logs for any errors during registration
Then no errors are logged in the system
When I ensure the registration data is encrypted in the database
Then registration data is encrypted