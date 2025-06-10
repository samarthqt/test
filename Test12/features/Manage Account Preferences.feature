Feature: Manage Account Preferences
Users should be able to manage their account preferences, including notifications, privacy settings, and personal information updates.
@8
Scenario: Update notification settings successfully
Given the user is on the account preferences page
When the user updates the notification settings
Then the system provides a confirmation message for successful update
And the changes are stored and reflected immediately in the user profile
@8
Scenario: Change privacy settings without errors
Given the user is on the account preferences page
When the user changes the privacy settings
Then the system provides a confirmation message for successful update
And the changes are stored and reflected immediately in the user profile
@8
Scenario: Update personal information successfully
Given the user is on the account preferences page
When the user updates personal information such as name, email, and phone number
Then the system provides a confirmation message for successful update
And the changes are stored and reflected immediately in the user profile
@8
Scenario: Display error messages for invalid inputs
Given the user is on the account preferences page
When the user enters invalid inputs
Then error messages are displayed
@8
Scenario: Save user preferences securely
Given the user has updated account preferences
When the changes are saved
Then user preferences are saved securely and comply with privacy regulations
@8
Scenario: Reset preferences to default settings
Given the user is on the account preferences page
When the user resets preferences to default settings
Then the system provides a confirmation message for successful reset
And the changes are stored and reflected immediately in the user profile
@8
Scenario: Interface is intuitive and user-friendly
Given the user is on the account preferences page
When the user interacts with the interface
Then the interface is intuitive and user-friendly
@8
Scenario: Generate logs for changes made to account preferences
Given the user has made changes to account preferences
When the changes are saved
Then logs are generated for changes made to account preferences