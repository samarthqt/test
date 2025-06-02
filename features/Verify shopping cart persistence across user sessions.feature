Feature: Verify shopping cart persistence across user sessions
@TC-69
Scenario: Add products to the shopping cart and verify persistence
Given the user is logged in
When the user adds products to the shopping cart
Then the products are successfully added to the cart
@TC-69
Scenario: Log out and verify cart persistence after logging back in
Given the user is logged out successfully
When the user logs back into the session
Then the shopping cart displays previously added products
@TC-69
Scenario: Verify product details and quantities in the cart
Given the user navigates to the shopping cart
Then the product details and quantities match the previous session
@TC-69
Scenario: Verify cart persistence across different devices
Given the user is logged out
When the user logs in from a different device
Then the cart contents remain consistent across devices
@TC-69
Scenario: Add more products and verify cart persistence
Given the user adds more products to the cart
When the user logs out
Then the new products are added successfully
@TC-69
Scenario: Verify cart after logging back in
Given the user logs back in
Then the cart should reflect new additions accurately
@TC-69
Scenario: Verify cart persistence after clearing browser cache
Given the user clears browser cache
When the user logs in again
Then the cart contents should remain intact despite cache clearing
@TC-69
Scenario: Verify cart persistence after switching network
Given the user switches network
When the user logs in
Then the cart persistence should be unaffected by network changes
@TC-69
Scenario: Verify cart persistence on mobile browser
Given the user repeats the test on a mobile browser
Then the cart contents should persist on mobile browsers too
@TC-69
Scenario: Check for discrepancies in cart total
Given the user navigates to the shopping cart
Then the cart total should be accurate and consistent
@TC-69
Scenario: Remove a product and verify persistence
Given the user attempts to remove a product
When the user logs out
Then the product removal should be successful and reflect in the next session
@TC-69
Scenario: Verify cart behavior using a guest account
Given the user logs in using a guest account
Then the guest cart should not persist across sessions
@TC-69
Scenario: Ensure no console errors during session transitions
Given the user performs session transitions
Then no console errors should appear during the test execution