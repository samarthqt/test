Feature: Verify black badge color for Control Group on Brand Three PLP
Scenario: Ensure that the badge color is correctly displayed as black for the Control Group on the Brand Three Product Listing Page (PLP)
Given access to Brand Three PLP
When I navigate to the Brand Three Product Listing Page
Then the Brand Three PLP is displayed
Scenario: Identify Control Group product and verify badge color
Given Control Group data is available
When I identify a product belonging to the Control Group
Then the product is identified as part of the Control Group
And the badge color is displayed as black
Scenario: Verify badge color consistency across multiple Control Group products
When I inspect multiple Control Group products
Then all Control Group products display a black badge
Scenario: Check badge color in different browsers
Given I use different browsers like Chrome, Firefox, Safari
When I check the badge color
Then the badge color remains black across different browsers
Scenario: Test badge color on different devices
Given I use different devices like desktop, mobile, tablet
When I test the badge color
Then the badge color remains black across different devices
Scenario: Verify badge color after refreshing the page
When I refresh the page
Then the badge color remains black after refreshing the page
Scenario: Verify badge color after clearing browser cache and cookies
When I clear the browser cache and cookies and reload the page
Then the badge color remains black after clearing cache and cookies
Scenario: Check badge color with different screen resolutions
Given I use different screen resolutions
When I check the badge color
Then the badge color remains black across different screen resolutions
Scenario: Inspect badge color with different network speeds
Given I use different network speeds like 3G, 4G, Wi-Fi
When I inspect the badge color
Then the badge color remains black regardless of network speed
Scenario: Verify badge color in incognito or private browsing mode
When I verify the badge color in incognito or private browsing mode
Then the badge color remains black in incognito or private browsing mode
Scenario: Check badge color with browser extensions enabled and disabled
Given I have browser extensions enabled and disabled
When I check the badge color
Then the badge color remains black regardless of browser extensions
Scenario: Test badge color with different operating systems
Given I use different operating systems like Windows, macOS, Linux
When I test the badge color
Then the badge color remains black across different operating systems
Scenario: Inspect badge color with various browser zoom levels
Given I use various browser zoom levels like 100%, 125%, 150%
When I inspect the badge color
Then the badge color remains black across various zoom levels
Scenario: Verify badge color with different user roles or permissions
Given I have different user roles or permissions
When I verify the badge color
Then the badge color remains black regardless of user roles or permissions