Feature: Test System Response to Invalid Recovery Link Attempts
@TC-119
Scenario: Ensure the system responds appropriately to invalid password recovery link attempts
Given an invalid recovery link "http://example.com/recover?token=invalid" is available
When I attempt to access the password reset page using the invalid link
Then the system denies access to the password reset page
And an error message is displayed indicating the link is invalid
And the invalid link attempt is logged in the system
And the user is redirected to the login page or given an option to request a new link
And the user is logged out successfully