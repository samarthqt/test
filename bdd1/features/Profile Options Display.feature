Feature: Profile Options Display
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed for Admin profile
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then the following labels should be displayed with appropriate values:
| Label              |
| Release            |
| Last Deployed Date |
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed for User profile
Given the user is logged into COCO
When the user navigates to the user profile
Then the following labels should be displayed with appropriate values:
| Label              |
| Release            |
| Last Deployed Date |
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed on the home page for Admin profile
Given I am logged into COCO as an Admin
When I navigate to the home page
Then the following labels should be displayed with appropriate values:
| Label              |
| Release            |
| Last Deployed Date |
@4
Scenario: Verify "Release" and "Last Deployed Date" labels are displayed on the home page for User profile
Given the user is logged into COCO
When the user navigates to the home page
Then the following labels should be displayed with appropriate values:
| Label              |
| Release            |
| Last Deployed Date |