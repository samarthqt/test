Feature: Verify support for multiple currencies
@TC-28
Scenario: User logs in and accesses currency settings
Given the user is on the login page
When the user logs in to the application
Then the user is successfully logged in
And the user has access to currency settings
@TC-28
Scenario: Navigate to currency settings page
Given the user is logged in
When the user navigates to the currency settings page
Then the currency settings page is displayed
@TC-28
Scenario: Select a different currency from the default
Given the user is on the currency settings page
When the user selects a different currency from the default
Then the currency selection is updated
@TC-28
Scenario: Verify application updates prices to the selected currency
Given the user has selected a different currency
When the application updates prices
Then prices are displayed in the selected currency
@TC-28
Scenario: Check that all product prices are converted correctly
Given the user has selected a different currency
When the application displays product prices
Then all product prices are correctly converted
@TC-28
Scenario: Verify currency symbols are displayed correctly
Given the user has selected a different currency
When the application displays currency symbols
Then currency symbols are displayed correctly
@TC-28
Scenario: Check transaction amounts are in the selected currency
Given the user has selected a different currency
When the user views transaction amounts
Then transaction amounts are in the selected currency
@TC-28
Scenario: Ensure currency selection persists after re-login
Given the user has selected a different currency
When the user logs out and logs back in
Then the selected currency persists after re-login
@TC-28
Scenario: Verify currency selection on different devices
Given the user has selected a different currency
When the user accesses the application on different devices
Then currency settings are consistent across different devices
@TC-28
Scenario: Verify currency selection on different browsers
Given the user has selected a different currency
When the user accesses the application on different browsers
Then currency settings are consistent across different browsers
@TC-28
Scenario: Ensure currency selection is available on the mobile app
Given the user has selected a different currency
When the user accesses the mobile app
Then currency settings are accessible on the mobile app
@TC-28
Scenario: Check for discrepancies in currency conversion rates
Given the user has selected a different currency
When the application performs currency conversion
Then no discrepancies in currency conversion rates are found
@TC-28
Scenario: Verify currency selection does not affect application performance
Given the user has selected a different currency
When the user interacts with the application
Then application performance remains unaffected by currency selection
@TC-28
Scenario: Ensure currency can be switched back to the default
Given the user has selected a different currency
When the user switches back to the default currency
Then currency can be switched back to the default successfully
@TC-28
Scenario: Verify handling of unsupported currencies
Given the user selects an unsupported currency
When the application processes the currency selection
Then the system provides a fallback or notification for unsupported currencies