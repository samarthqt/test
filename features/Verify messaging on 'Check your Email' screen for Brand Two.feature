Feature: Verify messaging on 'Check your Email' screen for Brand Two
Scenario: Ensure correct messaging is displayed on the 'Check your Email' screen for Brand Two users
Given a user is registered with Brand Two and has initiated an email verification process
When the user initiates the email verification process for a Brand Two user
Then the user is directed to the 'Check your Email' screen
Scenario: Verify the messaging displayed on the 'Check your Email' screen
When the user views the 'Check your Email' screen
Then the message "Please check your email for the verification link." is displayed
Scenario: Check for additional instructions or links on the 'Check your Email' screen
When the user views the 'Check your Email' screen
Then no additional instructions or links are present
Scenario: Confirm branding and design elements match Brand Two's guidelines
When the user views the 'Check your Email' screen
Then the branding and design elements conform to Brand Two's guidelines
Scenario: Ensure the message is clear and free of grammatical errors
When the user views the 'Check your Email' screen
Then the message is grammatically correct and clear