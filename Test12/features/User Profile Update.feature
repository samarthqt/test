Feature: User Profile Update
@24
Scenario: Access user profile via account dashboard
Given the user is logged into their account
When the user navigates to the account dashboard
Then the user should be able to access their profile
@24
Scenario: Update personal information
Given the user is on their profile page
When the user updates their name, email, shipping/billing addresses, and phone number
And the user saves the changes
Then the changes should be saved promptly
@24
Scenario: Validate email and phone number format
Given the user is updating their email and phone number
When the user enters an invalid email or phone number format
Then an error message should be displayed
@24
Scenario: Receive notification for successful updates
Given the user has successfully updated their personal information
Then the user should receive a notification confirming the successful update
@24
Scenario: Log changes for auditing purposes
Given the user has made changes to their personal information
Then all changes should be logged for auditing purposes
@24
Scenario: Ensure data encryption for sensitive information
Given the user is updating sensitive personal information
Then the system must ensure data encryption for this information
@24
Scenario: Revert changes within a specified time frame
Given the user has updated their personal information
When the user decides to revert the changes within the specified time frame
Then the changes should be reverted successfully