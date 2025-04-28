Feature: Verify dark-grey badge color for Variant 2 Group on Brand Three PLP
Scenario: Ensure the badge color is displayed as dark-grey for the Variant 2 Group on the Brand Three Product Listing Page (PLP)
Given I have access to the Brand Three PLP
When I navigate to the Brand Three Product Listing Page
Then the Brand Three PLP is displayed
Scenario: Identify a product belonging to the Variant 2 Group
Given Variant 2 Group data is available
When I identify a product belonging to the Variant 2 Group
Then the product is identified as part of the Variant 2 Group
Scenario: Inspect the badge color displayed on the product
When I inspect the badge color displayed on the product
Then the badge color is displayed as dark-grey
Scenario: Verify badge color consistency across multiple Variant 2 Group products
When I verify the badge color consistency across multiple Variant 2 Group products
Then all Variant 2 Group products display a dark-grey badge
Scenario: Check the badge color in different browsers
When I check the badge color in different browsers such as Chrome, Firefox, and Safari
Then the badge color remains dark-grey across different browsers
Scenario: Test the badge color on different devices
When I test the badge color on different devices like desktop, mobile, and tablet
Then the badge color remains dark-grey across different devices
Scenario: Refresh the page and verify the badge color
When I refresh the page
Then the badge color remains dark-grey after refreshing the page
Scenario: Clear the browser cache and cookies, then reload the page
When I clear the browser cache and cookies and reload the page
Then the badge color remains dark-grey after clearing cache and cookies
Scenario: Check the badge color with different screen resolutions
When I check the badge color with different screen resolutions
Then the badge color remains dark-grey across different screen resolutions
Scenario: Inspect the badge color with different network speeds
When I inspect the badge color with different network speeds such as 3G, 4G, and Wi-Fi
Then the badge color remains dark-grey regardless of network speed
Scenario: Verify the badge color in incognito or private browsing mode
When I verify the badge color in incognito or private browsing mode
Then the badge color remains dark-grey in incognito or private browsing mode
Scenario: Check the badge color with browser extensions enabled and disabled
When I check the badge color with browser extensions enabled and disabled
Then the badge color remains dark-grey regardless of browser extensions
Scenario: Test the badge color with different operating systems
When I test the badge color with different operating systems like Windows, macOS, and Linux
Then the badge color remains dark-grey across different operating systems
Scenario: Inspect the badge color with various browser zoom levels
When I inspect the badge color with various browser zoom levels such as 100%, 125%, and 150%
Then the badge color remains dark-grey across various zoom levels
Scenario: Verify the badge color with different user roles or permissions
When I verify the badge color with different user roles or permissions
Then the badge color remains dark-grey regardless of user roles or permissions