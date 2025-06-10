Feature: Profile Options
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed on Admin profile
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then I should see the "Release" and "Last Deployed Date" labels displayed with appropriate values
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed on User profile
Given I am logged into COCO as a User
When I navigate to the user profile
Then I should see the "Release" and "Last Deployed Date" labels displayed with appropriate values