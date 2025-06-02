Feature: Verify user can sign up using Google account
@TC-52
Scenario: User successfully signs up using a Google account
Given the user has access to the internet
And the application URL "https://example.com" is accessible
And Google sign-up integration is enabled
When the user navigates to the application URL
Then the application homepage is displayed
When the user clicks on the 'Sign Up' button
Then sign-up options are displayed
When the user selects 'Sign up with Google'
Then the Google login page is displayed
When the user enters Google account email "example@gmail.com" and password "examplePassword"
Then the credentials are accepted
When the user clicks on 'Next' to proceed
Then the Google account permissions page is displayed
When the user grants necessary permissions to the application
Then permissions are granted
When the user confirms the sign-up process
Then a sign-up confirmation message is displayed
When the user is redirected to the application dashboard
Then the user dashboard is displayed
When the user verifies their profile information
Then the profile information matches Google account details
When the user logs out from the application
Then the user is logged out successfully
When the user attempts to log in again using the same Google account
Then the user is logged in successfully using Google
When the user checks for any error messages or alerts during the sign-up process
Then no errors or alerts are displayed
When the user verifies email confirmation received from the application
Then email confirmation is received
When the user confirms that the sign-up process adheres to privacy policies
Then privacy policies are adhered to
When the user ensures that application terms and conditions are accepted during sign-up
Then terms and conditions are accepted