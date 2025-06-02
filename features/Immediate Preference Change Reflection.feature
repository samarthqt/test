Feature: Immediate Preference Change Reflection
@TC-35
Scenario: Verify changes to preferences are saved and reflected immediately
Given the user is logged into the application
When the user navigates to the user settings page
Then the user settings page is displayed
And the user has existing preferences
When the user clicks on 'Notification Settings'
Then notification settings options are displayed
When the user selects 'Email' preference
Then the email preference is selected
When the user enters the email address 'user@example.com'
Then the email address is entered without errors
When the user selects 'SMS' preference
Then the SMS preference is selected
When the user enters the SMS number '+1234567890'
Then the SMS number is entered without errors
When the user chooses notification frequency as 'Weekly'
Then the notification frequency is set to weekly
When the user clicks 'Save Changes'
Then changes are saved successfully
And a confirmation message 'Settings updated successfully' is displayed
When the user immediately checks the notification settings page
Then the updated preferences are reflected immediately
When the user logs out and logs back in
Then the user is logged back into the application
When the user navigates back to 'Notification Settings'
Then the notification settings reflect the updated preferences
When the user checks the email inbox for notification test email
Then the test email is received in the inbox
When the user checks the SMS inbox for notification test SMS
Then the test SMS is received on the phone
And ensure immediate reflection of changes across all user devices
Then changes are synchronized across all devices