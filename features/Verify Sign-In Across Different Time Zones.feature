Feature: Verify Sign-In Across Different Time Zones
Scenario: Check system behavior when sign-in attempt is made across different time zones
Given the user account is active
And the user has valid credentials with email "user@example.com" and password "SecurePass123"
When the user opens the application login page
Then the login page is displayed
When the user enters the valid email "user@example.com"
Then the email is entered in the email field
When the user enters the valid password "SecurePass123"
Then the password is entered in the password field
When the user attempts sign-in from UTC time zone
Then the user is successfully signed in
When the user signs out from the application
Then the user is successfully signed out
When the system time is changed to PST time zone
Then the system time is updated to PST
When the user repeats the sign-in process with updated time zone
Then the user is successfully signed in
When the user signs out from the application
Then the user is successfully signed out
When the system time is changed to EST time zone
Then the system time is updated to EST
When the user repeats the sign-in process with updated time zone
Then the user is successfully signed in
When the user signs out from the application
Then the user is successfully signed out
When the system time is changed to IST time zone
Then the system time is updated to IST
When the user repeats the sign-in process with updated time zone
Then the user is successfully signed in
When the user signs out from the application
Then the user is successfully signed out
When the system time is changed to JST time zone
Then the system time is updated to JST
When the user repeats the sign-in process with updated time zone
Then the user is successfully signed in