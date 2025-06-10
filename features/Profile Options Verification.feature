Feature: Profile Options Verification
@TC-5
Scenario: Verify 'Release' and 'Last Deployed Date' labels are displayed on the profile page for Admin profile
Given I am logged into the COCO application as an Admin with username "profileUser" and password "profilePassword"
When I navigate to the profile page
Then I should see the 'Release' label with the appropriate value
And I should see the 'Last Deployed Date' label with the appropriate value
@TC-5
Scenario: Verify 'Release' and 'Last Deployed Date' labels are displayed on the profile page for User profile
Given I am logged into the COCO application as a User with username "profileUser" and password "profilePassword"
When I navigate to the profile page
Then I should see the 'Release' label with the appropriate value
And I should see the 'Last Deployed Date' label with the appropriate value