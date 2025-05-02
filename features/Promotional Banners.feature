Feature: Promotional Banners
Scenario: Display promotional banners for current sales
Given the user is on the homepage
When the promotional banners are loaded
Then the banners should display current sales information
Scenario: Display promotional banners for current discounts
Given the user is on the homepage
When the promotional banners are loaded
Then the banners should display current discount information
Scenario: Ensure promotional banners are visible
Given the user is on the homepage
When the promotional banners are loaded
Then the banners should be visible to the user
Scenario: Ensure promotional banners attract user interest
Given the user is on the homepage
When the promotional banners are loaded
Then the banners should be designed to attract user interest
Scenario: Verify promotional banners update with new promotions
Given the user is on the homepage
When a new promotion is active
Then the promotional banners should update to reflect the new promotion
Scenario: Check promotional banners link to relevant sales pages
Given the user is on the homepage
When the user clicks on a promotional banner
Then the user should be directed to the relevant sales page
Scenario: Ensure promotional banners load without errors
Given the user is on the homepage
When the promotional banners are loaded
Then there should be no loading errors
Scenario: Verify promotional banners are responsive
Given the user is on the homepage
When the promotional banners are viewed on different devices
Then the banners should display correctly on all devices