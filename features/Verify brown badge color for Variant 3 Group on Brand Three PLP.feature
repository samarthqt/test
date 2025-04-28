Feature: Verify brown badge color for Variant 3 Group on Brand Three PLP
Scenario: Check brown badge color for Variant 3 Group on Brand Three PLP
Given I have access to the Brand Three Product Listing Page (PLP)
When I navigate to the Brand Three PLP
Then the Brand Three PLP is displayed
Scenario: Identify product belonging to Variant 3 Group
Given Variant 3 Group data is available
When I identify a product belonging to the Variant 3 Group
Then the product is identified as part of the Variant 3 Group
Scenario: Inspect badge color on the product
When I inspect the badge color displayed on the product
Then the badge color is displayed as brown
Scenario: Verify badge color consistency across multiple products
When I verify the badge color consistency across multiple Variant 3 Group products
Then all Variant 3 Group products display a brown badge
Scenario: Check badge color across different browsers
When I check the badge color in different browsers (e.g., Chrome, Firefox, Safari)
Then the badge color remains brown across different browsers
Scenario: Test badge color on different devices
When I test the badge color on different devices (e.g., desktop, mobile, tablet)
Then the badge color remains brown across different devices
Scenario: Refresh page and verify badge color
When I refresh the page and verify the badge color again
Then the badge color remains brown after refreshing the page
Scenario: Clear cache and cookies, then reload page
When I clear the browser cache and cookies, then reload the page
Then the badge color remains brown after clearing cache and cookies
Scenario: Check badge color with different screen resolutions
When I check the badge color with different screen resolutions
Then the badge color remains brown across different screen resolutions
Scenario: Inspect badge color with different network speeds
When I inspect the badge color with different network speeds (e.g., 3G, 4G, Wi-Fi)
Then the badge color remains brown regardless of network speed
Scenario: Verify badge color in incognito or private browsing mode
When I verify the badge color in incognito or private browsing mode
Then the badge color remains brown in incognito or private browsing mode
Scenario: Check badge color with browser extensions enabled and disabled
When I check the badge color with browser extensions enabled and disabled
Then the badge color remains brown regardless of browser extensions
Scenario: Test badge color with different operating systems
When I test the badge color with different operating systems (e.g., Windows, macOS, Linux)
Then the badge color remains brown across different operating systems
Scenario: Inspect badge color with various browser zoom levels
When I inspect the badge color with various browser zoom levels (e.g., 100%, 125%, 150%)
Then the badge color remains brown across various zoom levels
Scenario: Verify badge color with different user roles or permissions
When I verify the badge color with different user roles or permissions
Then the badge color remains brown regardless of user roles or permissions