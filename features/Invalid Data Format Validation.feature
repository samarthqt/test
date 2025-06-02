Feature: Invalid Data Format Validation
@TC-34
Scenario: Attempt to update preferences with invalid email format
Given the user is logged into the application
And the user navigates to the user settings page
And the user has existing preferences
When the user clicks on 'Notification Settings'
And the user enters invalid email format 'invalid-email'
Then the system displays an error message for invalid email format
@TC-34
Scenario: Attempt to update preferences with invalid SMS number
Given the user is on the notification settings page
When the user enters invalid SMS number '12345'
Then the system displays an error message for invalid SMS number
@TC-34
Scenario: Set notification frequency to 'Daily'
Given the user is on the notification settings page
When the user sets notification frequency to 'Daily'
Then the notification frequency is set to daily
@TC-34
Scenario: Attempt to save changes with invalid data formats
Given the user has entered invalid email and SMS number
When the user clicks 'Save Changes'
Then the system prevents saving due to invalid data formats
And error messages are displayed for invalid email and SMS number
@TC-34
Scenario: Attempt to save changes again with invalid data formats
Given the user has entered invalid email and SMS number
When the user attempts to save changes again
Then the system continues to prevent saving due to invalid data formats
@TC-34
Scenario: Save changes with valid data
Given the user enters valid email and SMS data
When the user clicks 'Save Changes' with valid data
Then changes are saved successfully
And a confirmation message 'Settings updated successfully' is displayed
@TC-34
Scenario: Test system behavior with unsupported notification frequency
Given the user is on the notification settings page
When the user tests system behavior with unsupported notification frequency
Then the system displays an error message for unsupported frequency
@TC-34
Scenario: Attempt to enter non-numeric SMS number
Given the user is on the notification settings page
When the user attempts to enter non-numeric SMS number
Then the system displays an error message for non-numeric SMS number
@TC-34
Scenario: Check system logs for failed update attempts
Given the user has attempted to save changes with invalid data formats
When the user checks system logs for failed update attempts
Then logs reflect failed attempts accurately
@TC-34
Scenario: Ensure error messages are user-friendly and clear
Given the user encounters error messages for invalid inputs
Then the error messages provide clear guidance on corrections