Feature: Verify Black Badge Color for Control Group on Brand Two PLP
Scenario: Verify that the badge color is black for the Control Group on the Brand Two Product Listing Page (PLP)
Given the user has access to Brand Two PLP
And the Control Group badge color settings are configured to black
When the user navigates to the Brand Two PLP
Then the Brand Two PLP is displayed
Scenario: Identify a product listed under the Control Group
Given the user is on the Brand Two PLP
When the user identifies a product listed under the Control Group
Then a product from the Control Group is identified
Scenario: Check the badge color of the identified Control Group product
Given a product from the Control Group is identified
When the user checks the badge color
Then the badge color is black
Scenario: Verify the badge color remains black when scrolling through the PLP
Given a product from the Control Group is identified
When the user scrolls through the PLP
Then the badge color remains black
Scenario: Refresh the Brand Two PLP
Given a product from the Control Group is identified
When the user refreshes the Brand Two PLP
Then the badge color remains black after refresh
Scenario: Switch categories and return to Control Group
Given a product from the Control Group is identified
When the user switches to a different category and switches back to the Control Group category
Then the badge color is black when returning to the Control Group
Scenario: Check the badge color on different screen resolutions
Given a product from the Control Group is identified
When the user checks the badge color on different screen resolutions
Then the badge color remains black across different resolutions
Scenario: Inspect the badge color using browser developer tools
Given a product from the Control Group is identified
When the user inspects the badge color using browser developer tools
Then the badge color CSS property is set to black
Scenario: Verify the badge color with different browser zoom levels
Given a product from the Control Group is identified
When the user verifies the badge color with different browser zoom levels
Then the badge color remains black at different zoom levels
Scenario: Perform a search for a Control Group product and verify the badge color
Given the user is on the Brand Two PLP
When the user performs a search for a Control Group product
Then the badge color is black for search results
Scenario: Check the badge color on a mobile device
Given a product from the Control Group is identified
When the user checks the badge color on a mobile device
Then the badge color is black on mobile devices
Scenario: Clear browser cache and cookies, then reload the PLP
Given a product from the Control Group is identified
When the user clears browser cache and cookies, then reloads the PLP
Then the badge color remains black after clearing cache
Scenario: Verify the badge color when using a different browser
Given a product from the Control Group is identified
When the user verifies the badge color using a different browser
Then the badge color is black across different browsers
Scenario: Check the badge color with different user roles
Given a product from the Control Group is identified
When the user checks the badge color with different user roles
Then the badge color is black for all user roles
Scenario: Log out and log back in, then verify the badge color
Given a product from the Control Group is identified
When the user logs out and logs back in
Then the badge color remains black after re-login