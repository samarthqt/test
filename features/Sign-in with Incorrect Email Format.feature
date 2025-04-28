Feature: Sign-in with Incorrect Email Format
Scenario: Verify error handling when signing in with an incorrect email format
Given the user has access to the sign-in page
When the user navigates to the sign-in page
Then the sign-in page is displayed
Scenario: Enter incorrect email format
Given the user is on the sign-in page
When the user enters "userexample.com" in the email field
And the user enters "ValidPassword123" in the password field
And the user clicks on the "Sign In" button
Then an error message indicating invalid email format is displayed
Scenario: Verify error message alignment with UI/UX standards
Given an error message is displayed for incorrect email format
Then the error message is clear, concise, and meets design standards
Scenario: Visual cues for email field error
Given an error message is displayed for incorrect email format
Then the email field is highlighted with a red border
Scenario: Sign-in button disabled after error message
Given an error message is displayed for incorrect email format
Then the sign-in button is disabled
Scenario: Error message logging
Given an error message is displayed for incorrect email format
Then the error message is logged in the system for auditing
Scenario: Correct email format and sign in
Given an error message is displayed for incorrect email format
When the user corrects the email format and clicks "Sign In" again
Then the system accepts the correct email format and processes sign-in
And the error message disappears
Scenario: Email field retains correct format after correction
Given the user has corrected the email format
Then the email field retains the correct format
Scenario: Enter another incorrect email format
Given the user is on the sign-in page
When the user enters another incorrect email format
Then a similar error message is displayed for different incorrect format
Scenario: Error message consistency after page switch
Given an error message is displayed for incorrect email format
When the user switches to another page and returns to sign-in
Then the error message remains consistent upon returning
Scenario: System suggestions for correcting email format
Given an error message is displayed for incorrect email format
Then the system provides suggestions for correcting the email format