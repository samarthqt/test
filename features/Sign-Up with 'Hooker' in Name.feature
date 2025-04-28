Feature: Sign-Up with 'Hooker' in Name
Scenario: Ensure users can sign-up with 'Hooker' in their name without triggering any errors
Given the user has access to the sign-up page
When the user navigates to the sign-up page
Then the sign-up page is displayed
When the user enters 'John Hooker' in the First Name field
Then the First Name field accepts input without errors
When the user enters 'Doe' in the Last Name field
Then the Last Name field accepts input without errors
When the user enters 'johndoe@example.com' in the Email field
Then the Email field accepts input without errors
When the user enters 'SecurePass123!' in the Password field
Then the Password field accepts input without errors
When the user clicks on the 'Sign Up' button
Then the system processes the sign-up request
And no error messages are displayed related to the name field
When the user verifies account creation confirmation
Then account creation is confirmed
And the user is redirected to the welcome page
When the user logs out of the account
Then the user is logged out successfully
When the user attempts to log in with the newly created account
Then the user is able to log in successfully
When the user checks the user profile for correct name display
Then 'John Hooker' is displayed correctly in the user profile
When the user inspects network logs for any sign-up errors
Then no errors related to the name field are logged
When the user verifies that the name 'Hooker' is stored correctly in the database
Then the name is stored as 'John Hooker' in the database
When the user ensures that the name 'Hooker' does not trigger any backend validation errors
Then no backend validation errors are triggered
When the user confirms that they receive a welcome email
Then the welcome email is received with the correct name