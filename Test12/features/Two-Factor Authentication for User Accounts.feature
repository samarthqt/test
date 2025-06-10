Feature: Two-Factor Authentication for User Accounts
Users should have the option to enable two-factor authentication (2FA) for added security, providing an additional layer of security beyond passwords. The application should support multiple 2FA methods, and users should receive notifications for 2FA-related activities. Security checks should ensure 2FA is functioning correctly.
@54
Scenario: User enables two-factor authentication
Given the user is logged into their account
When the user navigates to the security settings
And the user selects the option to enable two-factor authentication
Then the user should be presented with multiple 2FA methods
And the user should be able to choose a preferred 2FA method
@54
Scenario: User receives notification for 2FA-related activity
Given the user has enabled two-factor authentication
When a 2FA-related activity occurs
Then the user should receive a notification about the activity
@54
Scenario: Security checks for 2FA functionality
Given the user has enabled two-factor authentication
When the user attempts to log in
Then the application should prompt for the 2FA method
And the application should verify the 2FA method is functioning correctly
@54
Scenario Outline: User selects preferred 2FA method
Given the user is on the two-factor authentication setup page
When the user selects "<2FA method>"
Then the user should be able to configure "<2FA method>" successfully
Examples:
| 2FA method  |
| SMS         |
| app-based   |