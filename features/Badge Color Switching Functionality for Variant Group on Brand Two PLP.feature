Feature: Badge Color Switching Functionality for Variant Group on Brand Two PLP
Scenario: Verify badge color switching functionality for Variant Group
Given the user has access to Brand Two PLP
And the Variant Group badge color settings are configured
When the user navigates to the Brand Two PLP
Then the Brand Two PLP is displayed
Scenario: Identify a product listed under the Variant Group
Given the user is on Brand Two PLP
When the user identifies a product listed under the Variant Group
Then a product from the Variant Group is identified
Scenario: Check initial badge color of the identified Variant Group product
Given a product from the Variant Group is identified
When the user checks the initial badge color of the identified product
Then the initial badge color is displayed correctly
Scenario: Switch the badge color setting for the Variant Group
Given a product from the Variant Group is identified
When the user switches the badge color setting for the Variant Group
Then the badge color setting is switched successfully
Scenario: Verify badge color changes on the PLP
Given the badge color setting is switched
When the user verifies the badge color changes on the PLP
Then the badge color changes to the new setting
Scenario: Refresh the Brand Two PLP
Given the badge color changes to the new setting
When the user refreshes the Brand Two PLP
Then the badge color remains as the new setting after refresh
Scenario: Switch back to the original badge color setting
Given the badge color remains as the new setting
When the user switches back to the original badge color setting
Then the badge color reverts to the original setting
Scenario: Verify badge color consistency during page navigation
Given the badge color reverts to the original setting
When the user navigates through different pages
Then the badge color remains consistent during navigation
Scenario: Check badge color consistency across different devices
Given the badge color remains consistent during navigation
When the user checks badge color consistency across different devices
Then the badge color remains consistent across devices
Scenario: Verify badge color consistency across different browsers
Given the badge color remains consistent across devices
When the user verifies badge color consistency across different browsers
Then the badge color remains consistent across browsers
Scenario: Perform a search for a Variant Group product and verify badge color
Given the badge color remains consistent across browsers
When the user performs a search for a Variant Group product
Then the badge color is correct for search results
Scenario: Check badge color consistency with different browser zoom levels
Given the badge color is correct for search results
When the user checks badge color consistency with different browser zoom levels
Then the badge color remains consistent at different zoom levels
Scenario: Inspect the badge color using browser developer tools
Given the badge color remains consistent at different zoom levels
When the user inspects the badge color using browser developer tools
Then the badge color CSS property reflects the current setting
Scenario: Clear browser cache and cookies, then reload the PLP
Given the badge color CSS property reflects the current setting
When the user clears browser cache and cookies, then reloads the PLP
Then the badge color remains consistent after clearing cache
Scenario: Log out and log back in, then verify badge color
Given the badge color remains consistent after clearing cache
When the user logs out and logs back in
Then the badge color remains consistent after re-login