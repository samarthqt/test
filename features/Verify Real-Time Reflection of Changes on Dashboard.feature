Feature: Verify Real-Time Reflection of Changes on Dashboard
@TC-96
Scenario: Log in and access the dashboard
Given the user is on the login page
When the user logs in with valid credentials
Then the user is successfully logged in and directed to the dashboard
@TC-96
Scenario: Navigate to the dashboard section
Given the user is logged in
When the user navigates to the dashboard section
Then the dashboard is displayed with all components visible
@TC-96
Scenario: Edit a component on the dashboard
Given the user is on the dashboard
When the user selects a component to edit
Then the component is selected and options to edit are displayed
@TC-96
Scenario: Make changes to the selected component
Given the user has selected a component to edit
When the user makes changes to the component (e.g., update data, add widget)
Then the changes are made successfully with no errors
@TC-96
Scenario: Save changes to the component
Given changes have been made to a dashboard component
When the user saves the changes
Then the changes are saved successfully without any errors
@TC-96
Scenario: Observe real-time updates on the dashboard
Given changes have been saved to a dashboard component
When the user observes the dashboard
Then the dashboard updates in real-time to reflect the changes made
@TC-96
Scenario: Refresh the dashboard page
Given changes have been made to the dashboard
When the user refreshes the dashboard page
Then the dashboard retains the changes after refresh
@TC-96
Scenario: Log out and log back into the application
Given changes have been made to the dashboard
When the user logs out and logs back into the application
Then the dashboard still reflects the changes after re-login
@TC-96
Scenario: Check the dashboard on a different device/browser
Given changes have been made to the dashboard
When the user checks the dashboard on a different device/browser
Then the changes are visible across different devices/browsers in real-time
@TC-96
Scenario: Make simultaneous changes on two different devices
Given the user is logged in on two different devices
When the user makes simultaneous changes on both devices
Then real-time sync is maintained and changes are reflected accurately
@TC-96
Scenario: Check for error messages or logs
Given changes are being made to the dashboard
When the user checks for error messages or logs
Then no error messages or logs indicate issues with real-time updates
@TC-96
Scenario: Verify dashboard performance with multiple real-time updates
Given the dashboard is receiving multiple real-time updates
When the user observes the dashboard performance
Then the dashboard performance remains optimal
@TC-96
Scenario: Test real-time updates with different types of changes
Given the user wants to test different types of changes
When the user makes various changes (e.g., data update, visual change)
Then all types of changes are reflected in real-time without issues
@TC-96
Scenario: Check real-time reflection with a slow internet connection
Given the user has a slow internet connection
When the user makes changes to the dashboard
Then real-time updates are consistent even with a slow internet connection
@TC-96
Scenario: Revert changes and observe real-time reflection
Given changes have been made to the dashboard
When the user reverts the changes
Then reverted changes are reflected in real-time accurately