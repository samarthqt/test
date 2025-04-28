Feature: Verify Clock Skew Handling During Sign-In
Scenario: Handling clock skew during sign-in attempts
Given the user account is active
And the user has valid credentials
When the user opens the application login page
Then the login page should be displayed
When the user enters valid email "user@example.com"
Then the email should be entered in the email field
When the user enters valid password "SecurePass123"
Then the password should be entered in the password field
When the system clock is set 5 minutes ahead
Then the system clock should be set 5 minutes ahead
When the user attempts to sign-in with adjusted clock
Then the user should be successfully signed in
When the user signs out from the application
Then the user should be successfully signed out
When the system clock is set 5 minutes behind
Then the system clock should be set 5 minutes behind
When the user repeats sign-in process with adjusted clock
Then the user should be successfully signed in
When the user signs out from the application
Then the user should be successfully signed out
When the system clock is reset to current time
Then the system clock should be reset to current time
When the user attempts to sign-in with correct system time
Then the user should be successfully signed in
When the user signs out from the application
Then the user should be successfully signed out
When the system logs are verified for any clock skew warnings
Then no clock skew warnings should be logged
When the system is checked for any error messages related to clock skew
Then no error messages related to clock skew should be displayed
When the user repeats sign-in process with normal clock settings
Then the user should be successfully signed in