Feature: Unauthorized Access Attempt with Email/Password
Scenario: Verify system response to unauthorized access using email/password
Given the user has access to the sign-in page
When the user navigates to the sign-in page
Then the sign-in page is displayed
Scenario: Unauthorized access attempt
Given the user is on the sign-in page
When the user enters "unauthorized@example.com" in the email field
And the user enters "UnauthorizedPass123" in the password field
And the user clicks on the "Sign In" button
Then the system processes the request
And an error message indicating unauthorized access is displayed
And the error message is clear, concise, and meets security standards
Scenario: Account lock after multiple failed attempts
Given the user has made multiple failed attempts
When the user tries to sign in again
Then the account is temporarily locked
Scenario: Disabled sign-in button after error message
Given an error message is displayed
When the user tries to click the sign-in button
Then the sign-in button is disabled
Scenario: Error message logging
Given an error message is displayed
Then the error message is logged in the system for auditing
Scenario: Password reset attempt for unauthorized account
When the user attempts to reset the password for the unauthorized account
Then the system prompts for security verification before allowing password reset
Scenario: Error message disappears after account unlock
Given the account is unlocked
When the user returns to the sign-in page
Then the error message disappears
Scenario: Email field retains entered email after error
Given an error message is displayed
When the user returns to the sign-in page
Then the email field retains the entered email
Scenario: Similar error message for different unauthorized email
When the user enters another unauthorized email
Then a similar error message is displayed
Scenario: System behavior when switching pages
Given an error message is displayed
When the user switches to another page and returns to the sign-in page
Then the error message remains consistent
Scenario: System provides guidance for authorized access
When the user encounters an error message
Then the system provides guidance for authorized access