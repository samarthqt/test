Feature: Sign up using Facebook account
@TC-53
Scenario: Verify user can sign up using Facebook account
Given the user navigates to the application URL
When the application homepage is displayed
And the user clicks on the 'Sign Up' button
Then sign-up options are displayed
When the user selects 'Sign up with Facebook'
Then the Facebook login page is displayed
When the user enters Facebook account email "example@facebook.com" and password "examplePassword"
Then credentials are accepted
When the user clicks on 'Login' to proceed
Then the Facebook account permissions page is displayed
When the user grants necessary permissions to the application
Then permissions are granted
When the user confirms the sign-up process
Then a sign-up confirmation message is displayed
When the user is redirected to the application dashboard
Then the user dashboard is displayed
When the user verifies profile information retrieved from Facebook
Then profile information matches Facebook account details
When the user logs out from the application
Then the user is logged out successfully
When the user attempts to log in again using the same Facebook account
Then the user is logged in successfully using Facebook
When the user checks for any error messages or alerts during the sign-up process
Then no errors or alerts are displayed
When the user verifies email confirmation received from the application
Then email confirmation is received
When the user confirms that the sign-up process adheres to privacy policies
Then privacy policies are adhered to
When the user ensures that application terms and conditions are accepted during sign-up
Then terms and conditions are accepted