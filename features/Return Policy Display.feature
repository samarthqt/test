Feature: Return Policy Display
Scenario: Verify return policy details are displayed clearly on the site
Given I am a user on the retail website
When I navigate to the return policy page
Then I should see the return policy details clearly displayed
Scenario: Ensure users are aware of return procedures
Given I am a user on the retail website
When I view the return policy page
Then I should see clear instructions on how to initiate a return
Scenario: Verify visibility of return policy link in the footer
Given I am a user on the retail website
When I scroll to the footer of the page
Then I should see a visible link to the return policy
Scenario: Check accessibility of return policy from product pages
Given I am viewing a product page on the retail website
When I look for return policy information
Then I should find a link or reference to the return policy
Scenario: Validate return policy information is up-to-date
Given I am a user on the retail website
When I check the return policy page
Then the information should be current and reflect any recent changes