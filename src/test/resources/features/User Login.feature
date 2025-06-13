Feature: User Login
@WD-REQ-01
Scenario: Successful login with valid credentials
Given the login page is displayed on app launch
When the user enters valid credentials
Then the login succeeds
And the home page is displayed
@WD-REQ-01
Scenario: Login with invalid credentials
Given the login page is displayed on app launch
When the user enters invalid credentials
Then the login fails
And an error message is displayed
@WD-REQ-01
Scenario: Login with empty credentials
Given the login page is displayed on app launch
When the user enters empty credentials
Then the login fails
And an error message is displayed indicating missing credentials
@WD-REQ-01
Scenario: Login page accessibility
Given the app is launched
Then the login page is displayed
And the login form is accessible
@WD-REQ-01
Scenario: Logout from the application
Given the user is logged in
When the user chooses to log out
Then the user is logged out successfully
And the login page is displayed