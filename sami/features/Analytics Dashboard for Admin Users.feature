Feature: Analytics Dashboard for Admin Users
""
Background:
Given an admin user is logged into the system
""
Scenario: Accessing the Analytics Dashboard
When the admin user navigates to the analytics dashboard
Then the analytics dashboard should be displayed
""
Scenario: Viewing Sales Data on the Analytics Dashboard
Given the admin user is on the analytics dashboard
When the admin user views the sales data
Then the sales data should be presented in a clear and understandable format
And the sales data should be up-to-date
""
Scenario: Filtering Sales Data by Date Range
Given the admin user is on the analytics dashboard
When the admin user filters the sales data by a specific date range
Then the sales data should be updated to reflect the selected date range
""
Scenario: Exporting Sales Data
Given the admin user is on the analytics dashboard
When the admin user chooses to export the sales data
Then the sales data should be exported in the selected format (e.g., CSV, Excel)
And a confirmation message should be displayed to the user
""
Scenario: Customizing Dashboard Widgets
Given the admin user is on the analytics dashboard
When the admin user customizes the dashboard widgets
Then the changes should be saved
And the dashboard should reflect the customizations made by the admin user
""
Scenario: Access Denied for Non-Admin Users
Given a non-admin user is logged into the system
When the non-admin user attempts to access the analytics dashboard
Then access should be denied
And an appropriate error message should be displayed
```
```gherkin
TCID:54