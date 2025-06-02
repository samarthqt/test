Feature: Change Notification Settings
@TC-32
Scenario: Verify users can change notification settings including email and SMS preferences
Given the user is logged into the application
And the user has existing notification settings
When the user navigates to the user settings page
Then the user settings page is displayed
@TC-32
Scenario: Accessing Notification Settings
When the user clicks on 'Notification Settings'
Then notification settings options are displayed
@TC-32
Scenario: Selecting Email Preference
When the user selects 'Email' preference
Then the email preference is selected
@TC-32
Scenario: Entering Email Address
When the user enters the email address 'user@example.com'
Then the email address is entered without errors
@TC-32
Scenario: Selecting SMS Preference
When the user selects 'SMS' preference
Then the SMS preference is selected
@TC-32
Scenario: Entering SMS Number
When the user enters the SMS number '+1234567890'
Then the SMS number is entered without errors
@TC-32
Scenario: Setting Notification Frequency
When the user chooses notification frequency as 'Weekly'
Then the notification frequency is set to weekly
@TC-32
Scenario: Saving Changes
When the user clicks 'Save Changes'
Then the changes are saved successfully
@TC-32
Scenario: Verification of Confirmation Message
Then the confirmation message 'Settings updated successfully' is displayed
@TC-32
Scenario: Logging out and back in
When the user logs out and logs back in
Then the user is logged back into the application
@TC-32
Scenario: Verifying Updated Notification Settings
When the user navigates back to 'Notification Settings'
Then the notification settings reflect the updated preferences
@TC-32
Scenario: Checking Email Inbox for Test Email
When the user checks email inbox for notification test email
Then the test email is received in the inbox
@TC-32
Scenario: Checking SMS Inbox for Test SMS
When the user checks SMS inbox for notification test SMS
Then the test SMS is received on the phone
@TC-32
Scenario: Attempting to Change Preferences Without Saving
When the user attempts to change preferences again without saving
Then no changes occur without saving
@TC-32
Scenario: Ensuring Notification Settings are Not Editable by Unauthorized Users
Then unauthorized users cannot edit notification settings