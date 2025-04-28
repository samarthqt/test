Feature: Verify error message consistency across different devices
Scenario: Error message consistency across mobile, tablet, and desktop
Given the system is configured to display error messages
When the user navigates to the sign-in page using a mobile device
Then the sign-in page is displayed on the mobile device
When the user enters an invalid email and password
Then the fields accept input
When the user clicks 'Sign In' and observes the error message
Then the error message is displayed
When the user repeats steps 1-3 using a tablet
Then the error message is consistent with the mobile device
When the user repeats steps 1-3 using a desktop
Then the error message is consistent with the mobile device
And the email used is invalid@example.com
And the password used is incorrectPassword
Scenario: Verify error message content and format
When the user verifies the error message content and format
Then the content and format are consistent across devices
Scenario: Check for device-specific error message issues
When the user checks for any device-specific error message issues
Then no device-specific issues are found
Scenario: Verify system logs for error messages
When the user verifies system logs for error messages across devices
Then logs accurately reflect error messages
Scenario: Error message consistency during high traffic conditions
When the user checks error message consistency during high traffic conditions
Then error messages remain consistent
Scenario: Error message consistency with different screen resolutions
When the user tests error message consistency with different screen resolutions
Then error messages are consistent across resolutions
Scenario: Error message consistency under high latency conditions
When the user verifies error messages under high latency conditions
Then error messages remain consistent
Scenario: Discrepancies in error message language
When the user checks for any discrepancies in error message language
Then language is consistent across devices
Scenario: Error message consistency during server downtime
When the user verifies error message consistency during server downtime
Then error messages remain consistent
Scenario: Error message consistency with different network speeds
When the user tests error message consistency with different network speeds
Then error messages are consistent across speeds
Scenario: Error message consistency with different device orientations
When the user verifies error message consistency with different device orientations
Then error messages are consistent across orientations