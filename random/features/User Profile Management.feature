Feature: User Profile Management
Scenario: Update personal information
Given the user is logged into their account
When the user navigates to the profile management section
Then the user should be able to update their name
And the user should be able to update their email
And the user should be able to update their shipping address
And the user should be able to update their billing address
And the user should be able to update their phone number
And the changes should be saved immediately
And the changes should reflect in the user profile
And a notification should confirm successful updates
Scenario: Change password securely
Given the user is logged into their account
When the user navigates to the password change section
Then the user should be able to change their password securely
And the changes should be saved immediately
And a notification should confirm successful password change
Scenario: Input validation for personal information
Given the user is on the profile management section
When the user enters incorrect data format in any field
Then an error message should be displayed for invalid inputs
Scenario: Secure storage of user data
Given the user has updated their personal information
Then the user data should be encrypted and stored securely
Scenario: Logging of profile changes
Given the user has made changes to their profile
Then the changes should be tracked in the logs