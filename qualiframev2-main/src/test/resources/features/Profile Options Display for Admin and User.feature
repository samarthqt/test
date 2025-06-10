Feature: Profile Options Display for Admin and User
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed for Admin profile
Given the admin user is logged in successfully
When the user navigates to the user profile section
Then the user profile section is displayed
And 'Release' label is displayed with an appropriate value
And 'Last Deployed Date' label is displayed with an appropriate value
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed for User profile
Given the user is logged in successfully
When the user navigates to the user profile section
Then the user profile section is displayed
And 'Release' label is displayed with an appropriate value
And 'Last Deployed Date' label is displayed with an appropriate value