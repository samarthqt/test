Feature: Verify Accessibility and Labeling of Filters on Desktop and Mobile
@TC-148
Scenario: Verify application loads successfully on desktop browsers
Given I open the application in a desktop browser
Then the application should load successfully
@TC-148
Scenario: Verify product listing page displays correctly on desktop
Given I navigate to the product listing page on a desktop browser
Then the product listing page should display correctly
@TC-148
Scenario: Verify filters are visible and labeled on desktop
Given I locate the filter section on the desktop interface
Then filters should be visible and clearly labeled
@TC-148
Scenario: Verify application loads successfully on mobile browsers
Given I access the application on a mobile browser
Then the application should load successfully on mobile
@TC-148
Scenario: Verify product listing page displays correctly on mobile
Given I navigate to the product listing page on mobile
Then the product listing page should display correctly on mobile
@TC-148
Scenario: Verify filters are visible and labeled on mobile
Given I locate the filter section on the mobile interface
Then filters should be visible and clearly labeled on mobile
@TC-148
Scenario: Verify filters are accessible with one click or tap
Given I access the filter section
Then filters should be accessible with one click or tap
@TC-148
Scenario: Verify responsiveness of filter labels on desktop
Given I resize the browser window on desktop
Then filter labels should adjust correctly to different screen sizes
@TC-148
Scenario: Verify responsiveness of filter labels on mobile
Given I view the filter labels on different mobile screen sizes
Then filter labels should adjust correctly on different mobile screen sizes
@TC-148
Scenario: Verify accessibility of filters using keyboard shortcuts on desktop
Given I use keyboard shortcuts to access filters on desktop
Then filters should be accessible using keyboard shortcuts
@TC-148
Scenario: Verify accessibility of filters with voice commands on mobile
Given I use voice commands to access filters on mobile
Then filters should be accessible using voice commands
@TC-148
Scenario: Check for overlap of filter labels with other UI elements
Given I view the filter labels
Then filter labels should not overlap with other UI elements
@TC-148
Scenario: Verify readability of filter labels in different lighting conditions on mobile
Given I check the filter labels in different lighting conditions on mobile
Then filter labels should be readable in different lighting conditions
@TC-148
Scenario: Ensure filters are functional and can be applied correctly
Given I apply filters on both platforms
Then filters should be applied correctly on both desktop and mobile
@TC-148
Scenario: Verify filters reset correctly after application
Given I reset the filters after application
Then filters should reset correctly after application