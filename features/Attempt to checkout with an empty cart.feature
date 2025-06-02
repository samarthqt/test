Feature: Attempt to checkout with an empty cart
As a user logged into the shopping platform,
I want to verify the system response when attempting to checkout with an empty cart,
So that I can ensure the system handles this scenario correctly.
@TC-304
Scenario: Navigate to the cart page
Given the user is logged into the shopping platform
When the user navigates to the cart page
Then the cart page is displayed showing no items
And the cart must be empty
@TC-304
Scenario: Attempt to checkout with an empty cart
Given the cart is empty
When the user clicks on the 'Proceed to Checkout' button
Then the system does not allow proceeding to checkout
And an error message is displayed
@TC-304
Scenario: Verify the error message content and clarity
Given an error message is displayed due to an empty cart
When the user reads the error message
Then the error message clearly states that the cart is empty and checkout cannot proceed
@TC-304
Scenario: Add a product to the cart and proceed to checkout
Given the user is on the cart page
When the user adds a product to the cart
And the user proceeds to checkout
Then the product is added successfully
And checkout can proceed with a non-empty cart
@TC-304
Scenario: Remove all items and retry checkout
Given the user has added items to the cart
When the user removes all items from the cart
And attempts to checkout
Then the same error message is displayed indicating the cart is empty
@TC-304
Scenario: Check system logs or alerts for empty cart checkout attempt
Given the user attempts to checkout with an empty cart
When system logs or alerts are checked
Then they indicate a checkout attempt with an empty cart
@TC-304
Scenario: Ensure system stability during empty cart checkout attempt
Given the user attempts to checkout with an empty cart
When the checkout attempt is made
Then the system remains stable and responsive
@TC-304
Scenario: Review user interface for error message layout
Given an error message is displayed due to an empty cart
When the user interface is reviewed
Then the error message is displayed correctly without any layout issues
@TC-304
Scenario: Log out and log back in to ensure system state consistency
Given the user is logged into the shopping platform
When the user logs out and logs back in
Then the cart remains empty
And no checkout is possible
@TC-304
Scenario: Verify no order is recorded in the order history
Given the user attempts to checkout with an empty cart
When the order history is checked
Then no order is found due to the empty cart
@TC-304
Scenario: Attempt to navigate away from the cart page without adding items
Given the user is on the cart page with an empty cart
When the user attempts to navigate away from the cart page
Then a warning message is displayed asking to confirm navigation without proceeding to checkout
@TC-304
Scenario: Ensure system provides guidance on adding items to the cart
Given the user is on the cart page with an empty cart
When the user reviews the system guidance
Then the system suggests adding items to the cart before proceeding to checkout
@TC-304
Scenario: Attempt to access the checkout page directly via URL manipulation
Given the user attempts to access the checkout page directly via URL manipulation
When the URL is manipulated
Then access is denied
And the user is redirected back to the cart page
@TC-304
Scenario: Verify user-friendly experience despite the error
Given an error message is displayed due to an empty cart
When the user interacts with the system
Then the system maintains a user-friendly experience with clear guidance and error messages
@TC-304
Scenario: Add items from the product details page and proceed to checkout
Given the user is on the product details page
When the user adds items from the product details page
And proceeds to checkout
Then items are added successfully
And checkout proceeds smoothly