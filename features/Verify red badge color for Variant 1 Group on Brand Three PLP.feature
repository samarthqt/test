Feature: Verify red badge color for Variant 1 Group on Brand Three PLP
Scenario: Ensure badge color is correctly displayed as red for Variant 1 Group on Brand Three PLP
Given I have access to the Brand Three Product Listing Page
When I navigate to the Brand Three Product Listing Page
Then the Brand Three PLP should be displayed
Scenario: Identify and verify badge color for Variant 1 Group products
Given Variant 1 Group data is available
When I identify a product belonging to the Variant 1 Group
Then the product should be identified as part of the Variant 1 Group
Scenario: Inspect and verify badge color consistency
When I inspect the badge color displayed on the product
Then the badge color should be displayed as red
Scenario: Verify badge color consistency across multiple products
When I verify the badge color consistency across multiple Variant 1 Group products
Then all Variant 1 Group products should display a red badge
Scenario: Check badge color in different browsers
When I check the badge color in different browsers like Chrome, Firefox, and Safari
Then the badge color should remain red across different browsers
Scenario: Test badge color on different devices
When I test the badge color on different devices like desktop, mobile, and tablet
Then the badge color should remain red across different devices
Scenario: Verify badge color after page refresh
When I refresh the page
Then the badge color should remain red after refreshing the page
Scenario: Verify badge color after clearing cache and cookies
When I clear the browser cache and cookies and reload the page
Then the badge color should remain red after clearing cache and cookies
Scenario: Check badge color with different screen resolutions
When I check the badge color with different screen resolutions
Then the badge color should remain red across different screen resolutions
Scenario: Inspect badge color with different network speeds
When I inspect the badge color with different network speeds like 3G, 4G, and Wi-Fi
Then the badge color should remain red regardless of network speed
Scenario: Verify badge color in incognito or private browsing mode
When I verify the badge color in incognito or private browsing mode
Then the badge color should remain red in incognito or private browsing mode
Scenario: Check badge color with browser extensions enabled and disabled
When I check the badge color with browser extensions enabled and disabled
Then the badge color should remain red regardless of browser extensions
Scenario: Test badge color with different operating systems
When I test the badge color with different operating systems like Windows, macOS, and Linux
Then the badge color should remain red across different operating systems
Scenario: Inspect badge color with various browser zoom levels
When I inspect the badge color with various browser zoom levels like 100%, 125%, and 150%
Then the badge color should remain red across various zoom levels
Scenario: Verify badge color with different user roles or permissions
When I verify the badge color with different user roles or permissions
Then the badge color should remain red regardless of user roles or permissions