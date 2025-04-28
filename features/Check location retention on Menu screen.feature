Feature: Check location retention on Menu screen
Scenario: Ensure the selected location is retained when navigating to the Menu screen
Given the user is logged into the application with username "username@example.com" and password "password123"
And location services are enabled on the device
When the user launches the application on a supported device
Then the application opens successfully and displays the home screen
Scenario: Log in and select a location
Given location services are enabled on the device
When the user logs in using valid user credentials
Then the user is successfully logged in and the main dashboard is displayed
Scenario: Select and confirm location
Given the user navigates to the location selection screen
When the user selects "Downtown Cafe" from the list of locations
Then a confirmation prompt appears
When the user confirms the location selection
Then the system processes the selection and navigates to the Menu screen
Scenario: Verify location retention on Menu screen
Given the Menu screen is displayed
Then the Menu screen displays options specific to "Downtown Cafe"
And no error messages or alerts are displayed
And the header shows "Downtown Cafe"
And menu items are relevant to "Downtown Cafe"
Scenario: Check location retention after navigation
When the user navigates away from the Menu screen and returns
Then the Menu screen still displays options for "Downtown Cafe"
Scenario: Verify location retention after logout
When the user logs out and logs back in
Then "Downtown Cafe" is still the selected location
Scenario: Test location retention consistency
When the user tests the scenario with a different location
Then the system consistently retains the selected location for different locations
Scenario: Verify system logging for audit purposes
Then the selected location is logged in the system for auditing
Scenario: Check UI/UX consistency
Then UI/UX is consistent and adheres to design standards