Feature: Profile Options Display
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed for Admin profile
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then the "Release" label should be displayed with an appropriate value
And the "Last Deployed Date" label should be displayed with an appropriate value
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed for User profile
Given the user is logged into COCO
When the user navigates to the user profile
Then the "Release" label should be displayed with an appropriate value
And the "Last Deployed Date" label should be displayed with an appropriate value