Feature: Verify error message when signing in with email/password after Facebook sign-up
Scenario: Display error message for email/password sign-in after Facebook sign-up
Given the user has an account created using Facebook sign-up
And the user navigates to the sign-in page
When the user enters the email associated with the Facebook account
And the user enters an incorrect password
And the user clicks on the 'Sign In' button
Then an error message is displayed indicating the sign-in method is incorrect
And the error message matches the design specifications
And guidance is provided for signing in with Facebook
Scenario: Attempt to reset password for Facebook sign-up account
Given the user has an account created using Facebook sign-up
And the user navigates to the sign-in page
When the user attempts to reset the password using the 'Forgot Password' link
Then the system does not allow password reset for Facebook sign-up accounts
Scenario: Check server logs during sign-in attempt
Given the user has an account created using Facebook sign-up
And the user navigates to the sign-in page
When the user enters the email associated with the Facebook account
And the user enters an incorrect password
And the user clicks on the 'Sign In' button
Then no critical errors are logged in the server during the sign-in attempt
Scenario: Ensure account accessibility after multiple failed attempts
Given the user has an account created using Facebook sign-up
And the user navigates to the sign-in page
When the user enters the email associated with the Facebook account
And the user enters an incorrect password multiple times
Then the account remains accessible after failed attempts
Scenario: Review user interface during error display
Given the user has an account created using Facebook sign-up
And the user navigates to the sign-in page
When the user enters the email associated with the Facebook account
And the user enters an incorrect password
And the user clicks on the 'Sign In' button
Then the user interface remains consistent and the error is displayed clearly
Scenario: Successful sign-in with correct Facebook login
Given the user has an account created using Facebook sign-up
And the user navigates to the sign-in page
When the user signs in using the correct Facebook login
Then the user is successfully signed in using Facebook
Scenario: Evaluate user experience during sign-in attempt
Given the user has an account created using Facebook sign-up
And the user navigates to the sign-in page
When the user enters the email associated with the Facebook account
And the user enters an incorrect password
And the user clicks on the 'Sign In' button
Then the user experience is intuitive and error handling is clear
Scenario: Document findings and suggest improvements
Given the user has an account created using Facebook sign-up
And the user navigates to the sign-in page
When the user attempts to sign in with email/password
Then findings are documented and any improvements are noted