Feature: Verify No Error for Whitelisted Words in Name Fields
Scenario: Ensure no error message is displayed for whitelisted words in name fields
Given I have access to the sign-up page
When I navigate to the sign-up page
Then the sign-up page is displayed
When I enter "Angel" in the First Name field
Then the First Name field accepts input without errors
When I enter "Whitelist" in the Last Name field
Then the Last Name field accepts input without errors
When I enter "angelwhitelist@example.com" in the Email field
Then the Email field accepts input without errors
When I enter "SecurePass123!" in the Password field
Then the Password field accepts input without errors
When I click on the "Sign Up" button
Then the system processes the sign-up request
When I check for any error messages related to the name field
Then no error messages are displayed for whitelisted words
When I verify account creation confirmation
Then account creation is confirmed, and user is redirected to the welcome page
When I log out of the account
Then the user is logged out successfully
When I attempt to log in with the newly created account
Then the user is able to log in successfully
When I check the user profile for correct name display
Then "Angel Whitelist" is displayed correctly in the user profile
When I inspect network logs for any sign-up errors
Then no errors related to the name field are logged
When I verify that the name "Angel Whitelist" is stored correctly in the database
Then the name is stored as "Angel Whitelist" in the database
When I ensure that the whitelisted words do not trigger any backend validation errors
Then no backend validation errors are triggered
When I confirm that the user receives a welcome email
Then the welcome email is received with the correct name