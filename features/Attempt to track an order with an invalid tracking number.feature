Feature: Attempt to track an order with an invalid tracking number
@TC-307
Scenario: Log in to the e-commerce website using valid credentials
Given a valid user account with User ID "U54321" and password "********"
When the user logs in to the e-commerce website
Then the user should be successfully logged in and redirected to the homepage
@TC-307
Scenario: Navigate to the 'My Orders' section
Given the user is logged in
When the user navigates to the 'My Orders' section
Then 'My Orders' page should display a list of past and current orders
@TC-307
Scenario: Select the order with the invalid tracking number
Given the user is on 'My Orders' page
When the user selects the order with Order ID "O654321"
Then the order details page should be displayed with tracking options
@TC-307
Scenario: Attempt to track the order with an invalid tracking number
Given the user is on the order details page
When the user clicks on the 'Track Order' button with invalid tracking number "T000000"
Then the system should attempt to retrieve tracking information
And an error message should be displayed indicating the tracking number is invalid
@TC-307
Scenario: Check for suggestions or help options provided to the user
Given an error message is displayed for an invalid tracking number
When the user views the error message
Then the system should offer suggestions or links to customer support for assistance
@TC-307
Scenario: Ensure error handling is consistent across different browsers
Given an error message is displayed for an invalid tracking number
When the user views the error message on different browsers
Then the error message should be consistent and clear on all supported browsers
@TC-307
Scenario: Log out from the website
Given the user is logged in
When the user logs out from the website
Then the user should be logged out successfully
@TC-307
Scenario: Log back in and attempt to track the order again
Given the user is logged out
When the user logs back in and attempts to track the order with invalid tracking number "T000000"
Then the system should consistently display the error message for the invalid tracking number
@TC-307
Scenario: Try tracking with a different invalid number
Given the user is logged in
When the user attempts to track the order with a different invalid tracking number
Then an error message should be displayed for any invalid tracking number
@TC-307
Scenario: Check if the system logs the error for auditing purposes
Given an error message is displayed for an invalid tracking number
When the system logs the error event
Then the error should be logged for further analysis
@TC-307
Scenario: Verify the security of the tracking feature
Given the user attempts to track an order
When the system processes the tracking request
Then the system should ensure tracking details are secure and inaccessible to unauthorized users
@TC-307
Scenario: Test the website's responsiveness on mobile devices
Given the user attempts to track an order on a mobile device
When the system handles the tracking request
Then error handling should be consistent and efficient on mobile platforms
@TC-307
Scenario: Attempt to track an order with a valid tracking number
Given the user is logged in
When the user attempts to track an order with a valid tracking number
Then the system should display correct tracking information for valid numbers
@TC-307
Scenario: Verify email notifications for tracking errors
Given an error message is displayed for an invalid tracking number
When the system sends notifications
Then the user should receive email notifications if tracking fails due to invalid numbers