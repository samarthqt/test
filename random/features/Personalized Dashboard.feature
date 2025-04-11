Feature: Personalized Dashboard
Scenario: Add a widget to the dashboard
Given the user is on the dashboard page
When the user selects a widget to add
Then the widget should be added to the dashboard
Scenario: Remove a widget from the dashboard
Given the user has a widget on the dashboard
When the user chooses to remove the widget
Then the widget should be removed from the dashboard
Scenario: Rearrange widgets on the dashboard
Given the user has multiple widgets on the dashboard
When the user drags a widget to a new position
Then the widget should be rearranged to the new position
Scenario: Dashboard suggests layout changes based on user behavior
Given the user frequently uses certain widgets
When the user accesses the dashboard
Then the dashboard should suggest layout changes to optimize user experience
Scenario: Save changes to the dashboard
Given the user has made changes to the dashboard layout
When the user logs out and logs back in
Then the changes should persist across sessions
Scenario: Include quick transfers and recent transactions widgets
Given the user is customizing the dashboard
When the user selects widgets to add
Then the dashboard must include quick transfers and recent transactions widgets
Scenario: Real-time update of dashboard with latest account information
Given the user is viewing the dashboard
When there are updates to the account information
Then the dashboard should update in real-time with the latest account information