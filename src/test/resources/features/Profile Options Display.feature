Feature: Profile Options Display
@TC-4
Scenario: Verify 'Release' and 'Last Deployed Date' labels are displayed for Admin profile
Given the admin user is logged in successfully
When the admin user navigates to the profile section
Then the profile section is displayed
And the 'Release' label is displayed with appropriate value
And the 'Last Deployed Date' label is displayed with appropriate value
When the admin user logs out
Then the admin user is logged out
@TC-4
Scenario: Verify 'Release' and 'Last Deployed Date' labels are displayed for User profile
Given the user logs in successfully
When the user navigates to the profile section
Then the profile section is displayed
And the 'Release' label is displayed with appropriate value
And the 'Last Deployed Date' label is displayed with appropriate value