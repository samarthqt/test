Feature: Profile Options Labels Verification
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed on Admin profile
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then I should see the "Release" label displayed with an appropriate value
And I should see the "Last Deployed Date" label displayed with an appropriate value
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed on User profile
Given I am logged into COCO as a User
When I navigate to the user profile
Then I should see the "Release" label displayed with an appropriate value
And I should see the "Last Deployed Date" label displayed with an appropriate value