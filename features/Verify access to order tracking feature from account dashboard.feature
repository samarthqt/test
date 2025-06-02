Feature: Verify access to order tracking feature from account dashboard
Ensure that users can access the order tracking feature from their account dashboard. User must have a valid account and order with tracking information.
@TC-207
Scenario: User can log into the application using valid credentials
Given the user has valid login credentials
When the user logs into the application
Then the user is successfully logged into the application
@TC-207
Scenario: User can navigate to the account dashboard
Given the user is logged into the application
When the user navigates to the account dashboard
Then the account dashboard is displayed with user information
@TC-207
Scenario: Locate the 'Order Tracking' feature on the dashboard
Given the user is on the account dashboard
When the user locates the 'Order Tracking' feature on the dashboard
Then 'Order Tracking' feature is visible on the dashboard
@TC-207
Scenario: Access tracking information by clicking 'Order Tracking' feature
Given the 'Order Tracking' feature is visible on the dashboard
When the user clicks on the 'Order Tracking' feature
Then the user is directed to the tracking information page
@TC-207
Scenario: Verify tracking information is displayed correctly from the dashboard
Given the user is on the tracking information page
When the user views the tracking information
Then tracking information is displayed accurately from the dashboard
@TC-207
Scenario: Test accessibility of 'Order Tracking' feature from different sections
Given the user is on the account dashboard
When the user accesses the 'Order Tracking' feature from different sections
Then 'Order Tracking' feature is accessible from various sections of the dashboard
@TC-207
Scenario: Ensure 'Order Tracking' feature is responsive and loads quickly
Given the user accesses the 'Order Tracking' feature
When the feature is loading
Then 'Order Tracking' feature is responsive and loads within acceptable time limits
@TC-207
Scenario: Check tracking information updates are reflected on the dashboard
Given there are updates to the tracking information
When the user views the tracking information on the dashboard
Then tracking information updates are visible on the dashboard
@TC-207
Scenario: Verify dashboard interface is user-friendly for accessing tracking information
Given the user is on the account dashboard
When the user accesses tracking information
Then the dashboard interface is intuitive and easy to use for accessing tracking information
@TC-207
Scenario: Ensure security measures for accessing tracking information from the dashboard
Given the user accesses tracking information from the dashboard
When checking security measures
Then security measures are verified for safe access to tracking information from the dashboard
@TC-207
Scenario: Test system's response to unauthorized attempts to access tracking information
Given there is an unauthorized attempt to access tracking information
When the system detects the unauthorized attempt
Then the system blocks unauthorized attempts to access tracking information from the dashboard
@TC-207
Scenario: Verify tracking information is only accessible to users with valid authentication
Given the user attempts to access tracking information
When the user is authenticated
Then tracking information is accessible only to authenticated users
@TC-207
Scenario: Check tracking information can be accessed on both desktop and mobile dashboards
Given the user accesses the dashboard
When the user uses either desktop or mobile device
Then tracking information is accessible on both desktop and mobile dashboards
@TC-207
Scenario: Confirm tracking information access complies with data protection regulations
Given the user accesses tracking information
When verifying compliance with data protection regulations
Then tracking information access complies with relevant data protection regulations
@TC-207
Scenario: Ensure user feedback on tracking information access is positive
Given the user accesses tracking information from the dashboard
When collecting user feedback
Then user feedback indicates satisfaction with tracking information access from the dashboard