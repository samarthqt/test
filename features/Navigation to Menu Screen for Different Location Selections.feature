Feature: Navigation to Menu Screen for Different Location Selections
Scenario: Verify navigation to Menu screen for different location selections
Given the user is logged into the application
And location services are enabled
When the user navigates to the location selection screen
Then the location selection screen is displayed
Scenario Outline: Select location and verify navigation to Menu screen
When the user selects <Location> from the list
Then the Menu screen is displayed for <Location>
Examples:
| Location   |
| Location A |
| Location B |
| Location C |
Scenario: Disable location services and attempt to select a location
Given the user changes the application settings to disable location services
When the user attempts to select a location from the list
Then the system prompts the user to enable location services
Scenario: Enable location services and select a location
Given location services are disabled
When the user enables location services and selects a location again
Then the Menu screen is displayed for the selected location
Scenario: Verify Menu screen displays correct options based on selected location
Given the user is on the Menu screen
When a location is selected
Then the Menu options are tailored to the selected location
Scenario: Check responsiveness of the Menu screen when switching locations
Given the user is switching locations
Then the Menu screen loads quickly and correctly for each location
Scenario: Verify navigation back to the location selection screen from the Menu screen
Given the user is on the Menu screen
When the user navigates back to the location selection screen
Then the user can navigate back to the location selection screen
Scenario: Log out from the application
Given the user is logged into the application
When the user logs out from the application
Then the user is logged out successfully
Scenario: Repeat the test with a different user account
Given a different user account is used
When the test is repeated
Then the system behaves consistently across different user accounts
Scenario: Check for any error messages or logs generated during location selection
When the user selects a location
Then no error messages or unusual logs are generated