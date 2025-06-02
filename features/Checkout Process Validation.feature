Feature: Checkout Process Validation
@TC-5
Scenario: Verify checkout fails without shipping and billing information
Given the user has items with IDs 101, 102, and 103 in the cart
When the user navigates to the cart page
Then the cart page is displayed with items 101, 102, and 103 listed
And the user clicks on the 'Proceed to Checkout' button
Then the user is redirected to the checkout page
And the user account is logged in
When the user attempts to complete the checkout without entering any shipping or billing information
Then an error message is displayed indicating that shipping and billing information is required
And the error message reads: 'Shipping and billing information is required to proceed.'
And the checkout button remains disabled
@TC-5
Scenario: Verify error message persists with partial shipping information
Given the user is on the checkout page
When the user enters partial shipping information only
Then the error message persists
And checkout cannot proceed
@TC-5
Scenario: Verify error message persists with partial billing information
Given the user is on the checkout page
When the user enters partial billing information only
Then the error message persists
And checkout cannot proceed
@TC-5
Scenario: Verify error message with invalid shipping and billing information
Given the user is on the checkout page
When the user enters invalid shipping and billing information
Then the error message indicates invalid information
@TC-5
Scenario: Verify alternative user assistance options are available
Given the user is on the checkout page
Then assistance options such as help links or FAQs are available
@TC-5
Scenario: Verify page refresh does not bypass requirement
Given the user is on the checkout page
When the user refreshes the page and retries checkout
Then page refresh does not bypass the requirement for shipping and billing information
@TC-5
Scenario: Verify no unexpected errors in browser console
Given the user is on the checkout page
When the user checks the browser console for any error logs
Then no unexpected errors are logged in the console
@TC-5
Scenario: Verify cart contents remain unchanged
Given the user is on the checkout page
When the user checks the cart contents
Then the cart still contains items 101, 102, and 103
@TC-5
Scenario: Verify checkout page requirement after navigation
Given the user is on the checkout page
When the user navigates away and returns to the checkout page
Then the checkout page still requires shipping and billing information
@TC-5
Scenario: Verify checkout requirement after logging out and back in
Given the user is on the checkout page
When the user logs out and logs back in, then attempts checkout again
Then checkout requirement for shipping and billing information remains
@TC-5
Scenario: Verify checkout requirement across different browsers
Given the user is on the checkout page
When the user attempts checkout using a different browser
Then shipping and billing information is required across all browsers