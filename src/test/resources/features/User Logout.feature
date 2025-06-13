Feature: User Logout
In order to ensure that users can securely end their sessions
As a user
I want to be able to log out and be redirected to the login page
@WD-REQ-06
Scenario: User logs out successfully
Given the user is logged into the application
When the user clicks on "LogOut" in the top menu
Then the user should be redirected to the login page
And the user session should be terminated
@WD-REQ-06
Scenario: User attempts to access a secured page after logging out
Given the user is logged into the application
And the user clicks on "LogOut" in the top menu
When the user tries to access a secured page
Then the user should be redirected to the login page
@WD-REQ-06
Scenario: User session is terminated after logout
Given the user is logged into the application
When the user clicks on "LogOut" in the top menu
Then the user session should be terminated
And any further requests should not be authenticated