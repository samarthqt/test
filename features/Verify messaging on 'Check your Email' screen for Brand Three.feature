Feature: Verify messaging on 'Check your Email' screen for Brand Three
Scenario: Ensure correct messaging is displayed on the 'Check your Email' screen for Brand Three users
Given a user is registered with Brand Three
And the user has initiated an email verification process
When the user is directed to the 'Check your Email' screen
Then the message "Please check your email for the verification link." should be displayed
And no additional instructions or links should be present
And the branding and design elements should conform to Brand Three's guidelines
And the message should be grammatically correct and clear