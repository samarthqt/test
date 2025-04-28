Feature: Error Message Verification for Email/Password Sign-In After Apple Sign-Up
Scenario: Ensure an error message is displayed when a user tries to sign in with email/password after signing up with Apple
Given a user account created using Apple sign-up
And access to the sign-in page
When the user navigates to the sign-in page
Then the sign-in page is displayed
When the user enters the email associated with the Apple account
And the user enters an incorrect password
And clicks on the 'Sign In' button
Then an error message is displayed indicating the sign-in method is incorrect
And the error message matches the design specifications
And additional guidance is provided for signing in with Apple
When the user attempts to reset the password using the 'Forgot Password' link
Then the password reset process is initiated
When verifying if the system allows password reset for Apple sign-up accounts
Then the system does not allow password reset for Apple sign-up accounts
When checking server logs for any errors during the sign-in attempt
Then no critical errors are logged in the server during sign-in attempt
When ensuring the account is not locked after multiple failed attempts
Then the account remains accessible after failed attempts
When reviewing the user interface for any inconsistencies during the error display
Then the user interface remains consistent and the error is displayed clearly
When testing the sign-in process with a correct Apple login
Then the user is successfully signed in using Apple
When evaluating the user experience during the sign-in attempt
Then the user experience is intuitive and error handling is clear
When documenting findings and suggesting improvements if needed
Then findings are documented and any improvements are noted