Feature: Profile Options Display
Scenario: Admin profile displays "Release" and "Last Deployed Date" labels
@4
Given I am logged in as an Admin
When I navigate to the profile page
Then I should see the "Release" label displayed
And I should see the "Last Deployed Date" label displayed
And the "Release" label should have an appropriate value
And the "Last Deployed Date" label should have an appropriate value
Scenario: User profile displays "Release" and "Last Deployed Date" labels
@4
Given I am logged in as a User
When I navigate to the profile page
Then I should see the "Release" label displayed
And I should see the "Last Deployed Date" label displayed
And the "Release" label should have an appropriate value
And the "Last Deployed Date" label should have an appropriate value