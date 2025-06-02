Feature: Test handling of invalid addresses during shipping quote retrieval
@TC-323
Scenario: Verify system handling of edge cases like invalid addresses during shipping quote retrieval
Given a user account exists
When the user logs into the application using valid credentials
Then the user is successfully logged in and navigated to the homepage
@TC-323
Scenario: Navigate to the shopping cart
Given the user has added products to the cart
When the user navigates to the shopping cart
Then all items added to the cart are displayed with their respective details
@TC-323
Scenario: Proceed to checkout with an invalid address
Given the user is on the shopping cart page
When the user proceeds to checkout
Then the checkout page is displayed with options to enter shipping information
@TC-323
Scenario: Enter invalid shipping address details
Given the user is on the checkout page
When the user enters invalid shipping address details
Then the system detects the invalid address and displays an error message
@TC-323
Scenario: Verify error message guidance
Given an error message is displayed for the invalid address
Then the error message provides guidance on correcting the address
@TC-323
Scenario: Attempt to retrieve shipping quotes with invalid address
Given the user has entered an invalid shipping address
When the user attempts to retrieve shipping quotes
Then the system prevents retrieval of shipping quotes due to invalid address
@TC-323
Scenario: Correct the shipping address and retrieve quotes
Given the user has corrected the shipping address
When the user attempts retrieval again
Then the system accepts the corrected address and successfully retrieves shipping quotes
@TC-323
Scenario: Review and select preferred shipping provider
Given shipping quotes are retrieved successfully
When the user reviews the shipping quotes
Then the user selects a preferred provider and confirms for checkout
@TC-323
Scenario: Verify logging of invalid address attempt
Given an invalid address attempt was made
Then the invalid address attempt is logged for auditing purposes
@TC-323
Scenario: Check email notification for invalid address entry
Given an invalid address entry was made
When the user checks their email
Then an email notification is sent with details about the invalid address entry
@TC-323
Scenario: Log out of the application
Given the user is logged into the application
When the user logs out
Then the user is successfully logged out
@TC-323
Scenario: Re-log into the application and navigate to order history
Given the user has logged out of the application
When the user re-logs into the application
Then the user navigates to order history
@TC-323
Scenario: View detailed shipping information
Given the user is on the order history page
When the user selects the order to view
Then detailed shipping information including provider and tracking number is displayed
@TC-323
Scenario: Track the order using the tracking number
Given the user has detailed shipping information
When the user tracks the order using the provided tracking number
Then tracking information is accessible and updates are displayed in real-time
@TC-323
Scenario: Verify estimated delivery date
Given shipping quotes were provided during checkout
When the user reviews the estimated delivery date
Then the estimated delivery date matches the shipping provider's quote