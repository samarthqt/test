Feature: Navigation to Menu Screen After Location Selection
Scenario: Verify navigation to Menu screen after location selection
Given the user is logged into the application with username "username@example.com" and password "password123"
And location services are enabled on the device
When the user launches the application on a supported device
Then the application opens successfully and displays the home screen
Scenario: Log in and navigate to location selection
Given the user is on the home screen
When the user logs in using valid credentials
Then the user is successfully logged in and the main dashboard is displayed
Scenario: Enable location services
Given the user is on the main dashboard
When the user ensures location services are enabled on the device
Then location services are confirmed as enabled
Scenario: Navigate to and select a location
Given the user is on the main dashboard
When the user navigates to the location selection screen
Then the location selection screen is displayed with available locations
When the user selects 'Downtown Cafe' from the list of locations
Then the location is selected, and a confirmation prompt appears
When the user confirms the location selection
Then the system processes the selection and navigates to the Menu screen
Scenario: Verify Menu screen display and content
Given the user is on the Menu screen
Then the Menu screen is displayed with options specific to 'Downtown Cafe'
And no error messages or alerts are displayed
And the header shows 'Downtown Cafe'
And menu items are relevant to 'Downtown Cafe'
And navigation bar options are functional and contextually relevant
Scenario: Navigation from and return to Menu screen
Given the user is on the Menu screen
When the user attempts to navigate to another screen
Then navigation to another screen is successful without errors
When the user returns to the Menu screen
Then the Menu screen still displays options for 'Downtown Cafe'
Scenario: Log out and re-login to check location persistence
Given the user is on the Menu screen
When the user logs out and logs back in
Then upon re-login, 'Downtown Cafe' is still the selected location
Scenario: Consistency check with a different location
Given the user is on the location selection screen
When the user repeats the test with a different location
Then the system consistently navigates to the Menu screen for different locations