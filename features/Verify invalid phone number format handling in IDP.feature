Feature: Verify invalid phone number format handling in IDP
Scenario: Verify system response to invalid phone number formats
Given the user has access to IDP
And the user is logged into the system
When the user navigates to the IDP login page
Then the IDP login page is displayed
Scenario Outline: Enter invalid phone number formats and verify system response
Given the user is on the IDP login page
When the user enters a valid email address in the email field
Then the email address is accepted
When the user enters "<invalid_phone_number>" in the phone number field
Then the system displays an error message indicating invalid phone number format
When the user attempts to submit the form with the invalid phone number
Then the form submission is blocked, and an error message is displayed
When the user corrects the phone number format to a valid one
Then the system accepts the corrected phone number format
When the user submits the form with the corrected phone number
Then the form is successfully submitted
Examples:
| invalid_phone_number |
| 123-abc-4567         |
| (123) 456-7890x123   |
| 123456               |
| abcdefg              |
| +12345               |
Scenario: Verify system logs and OTP behavior for invalid phone numbers
Given the user is on the IDP login page
When the user enters invalid phone number formats from test data
Then the system consistently displays error messages for invalid formats
And the system logs contain entries for each invalid phone number attempt
And the system does not send OTP for invalid phone number formats
Scenario: Verify account recovery process with invalid phone numbers
Given the user is on the IDP login page
When the user attempts to use an invalid phone number for account recovery
Then the account recovery process fails due to invalid phone number format
Scenario: Verify system response time and user guidance for error messages
Given the user is on the IDP login page
When the user enters an invalid phone number format
Then the system displays error messages promptly after invalid input
And the error messages provide clear guidance on valid phone number formats
Scenario: Test international invalid phone number formats
Given the user is on the IDP login page
When the user enters international invalid phone number formats
Then the system behaves consistently with international invalid formats
Scenario: Ensure system security and validation bypass attempts
Given the user is on the IDP login page
When the user attempts to bypass validation using special characters
Then the system detects and blocks attempts to bypass validation
And the system maintains security, with no exposure of phone number details