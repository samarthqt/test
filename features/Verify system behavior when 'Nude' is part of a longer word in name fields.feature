Feature: Verify system behavior when 'Nude' is part of a longer word in name fields
Scenario: Check system behavior with 'Nude' in longer words during sign-up
Given I have access to the sign-up page
When I navigate to the sign-up page
Then the sign-up page is displayed
When I enter "Anudeep" in the First Name field
Then the First Name field accepts input without errors
When I enter "Smith" in the Last Name field
Then the Last Name field accepts input without errors
When I enter "anudeep.smith@example.com" in the Email field
Then the Email field accepts input without errors
When I enter "SecurePass123!" in the Password field
Then the Password field accepts input without errors
When I click on the 'Sign Up' button
Then the system processes the sign-up request
And I check for any error messages related to the name field containing 'Nude'
Then no error messages are displayed for 'Anudeep'
When I verify account creation confirmation
Then account creation is confirmed, and the user is redirected to the welcome page
When I log out of the account
Then the user is logged out successfully
When I attempt to log in with the newly created account
Then the user is able to log in successfully
When I check the user profile for correct name display
Then 'Anudeep Smith' is displayed correctly in the user profile
When I inspect network logs for any sign-up errors
Then no errors related to the name field are logged
When I verify that the name 'Anudeep' is stored correctly in the database
Then the name is stored as 'Anudeep' in the database
When I ensure that the name 'Anudeep' does not trigger any backend validation errors
Then no backend validation errors are triggered
When I confirm that the user receives a welcome email
Then the welcome email is received with the correct name