Feature: Analytics Dashboard for Admin
""
Background:
Given the admin is logged into the system
""
Scenario: Accessing the Analytics Dashboard
When the admin navigates to the Analytics Dashboard
Then the admin should see the sales data displayed
And the admin should see the performance metrics displayed
""
Scenario: Viewing Sales Data
Given the admin is on the Analytics Dashboard
When the admin selects the sales data tab
Then the admin should see a graphical representation of sales data
And the admin should see sales data filtered by time period
""
Scenario: Viewing Performance Metrics
Given the admin is on the Analytics Dashboard
When the admin selects the performance metrics tab
Then the admin should see a graphical representation of performance metrics
And the admin should see performance metrics filtered by time period
""
Scenario: Filtering Data by Time Period
Given the admin is on the Analytics Dashboard
When the admin applies a time period filter
Then the sales data should be updated to reflect the selected time period
And the performance metrics should be updated to reflect the selected time period
""
Scenario: Exporting Data
Given the admin is on the Analytics Dashboard
When the admin selects the option to export data
Then the admin should be able to download the sales data in a CSV format
And the admin should be able to download the performance metrics in a CSV format
""
Scenario: Handling No Data Available
Given the admin is on the Analytics Dashboard
And there is no sales data available for the selected time period
When the admin views the sales data
Then the admin should see a message indicating no data is available
""
Scenario: Handling No Performance Metrics Available
Given the admin is on the Analytics Dashboard
And there are no performance metrics available for the selected time period
When the admin views the performance metrics
Then the admin should see a message indicating no data is available
```