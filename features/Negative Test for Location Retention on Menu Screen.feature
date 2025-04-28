Feature: Negative Test for Location Retention on Menu Screen
Scenario: Verify system behavior when the selected location is not retained on the Menu screen
Given the user is logged into the application with username "username@example.com" and password "password123"
And location services are enabled on the device
When the user launches the application on a supported device
Then the application should open successfully and display the home screen
When the user logs in using valid user credentials
Then the user should be successfully logged in and the main dashboard should be displayed
When the user ensures location services are enabled on the device
Then location services should be confirmed as enabled
When the user navigates to the location selection screen
Then the location selection screen should be displayed with available locations
When the user selects "Downtown Cafe" from the list of locations
Then the location should be selected and a confirmation prompt should appear
When the user confirms the location selection
Then the system should process the selection and navigate to the Menu screen
When the user verifies the Menu screen is displayed with the selected location retained
Then the Menu screen should display options specific to "Downtown Cafe"
When the user navigates away from the Menu screen and selects a different location
Then the system should process the new location selection
When the user returns to the Menu screen and checks if the selected location is retained
Then the Menu screen should incorrectly display options for the previous location
When the user checks for any error messages or alerts regarding location retention
Then no error messages or alerts should be displayed, indicating a failure in retention
When the user logs out and logs back in to check if the location selection persists incorrectly
Then upon re-login, the incorrect location should still be displayed
When the user tests the scenario with multiple location changes to ensure consistent failure
Then the system should consistently fail to retain the correct location after changes
When the user verifies the system logs the incorrect location retention for audit purposes
Then incorrect location retention should be logged in the system for auditing
When the user checks the UI/UX response to incorrect location retention
Then UI/UX should not indicate the incorrect retention, leading to user confusion
When the user attempts to manually reset the location and verifies the system's response
Then manual reset should allow the correct location to be selected and retained