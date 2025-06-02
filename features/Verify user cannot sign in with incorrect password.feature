Feature: Verify user cannot sign in with incorrect password
@TC-55
Scenario: User attempts to sign in with incorrect password
Given the user navigates to the application URL "https://example.com"
And the application homepage is displayed
When the user clicks on the 'Sign In' button
Then the sign-in page is displayed
And the user enters registered email "user@example.com" in the email field
And the user enters incorrect password "wrongPassword" in the password field
When the user clicks on 'Sign In' to proceed
Then the system processes the sign-in request
And the system checks password validity
And an error message indicating incorrect password is displayed
And the error message includes guidance for password recovery or contacting support
And the system logs the incorrect sign-in attempt
And no alerts or notifications are displayed
And privacy policies are adhered to
And terms and conditions are displayed
And support contact information is available
@TC-55
Scenario: User signs in successfully with correct password
Given the user navigates to the application URL "https://example.com"
And the application homepage is displayed
When the user clicks on the 'Sign In' button
Then the sign-in page is displayed
And the user enters registered email "user@example.com" in the email field
And the user enters correct password "correctPassword" in the password field
When the user clicks on 'Sign In' to proceed
Then the system processes the sign-in request
And sign-in is successful with the correct password
And user dashboard is accessible