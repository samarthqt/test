Feature: Verify Order Tracking Using Tracking Number
@TC-197
Scenario: Ensure users can track orders using a valid tracking number provided post-purchase
Given a user account with a recent purchase
When the user logs in using valid credentials
Then the user is successfully logged in
@TC-197
Scenario: Navigate to the 'Track Order' section
Given the user is logged in
When the user navigates to the 'Track Order' section
Then the Track Order page is displayed
@TC-197
Scenario: Enter a valid tracking number in the tracking field
Given the Track Order page is displayed
When the user enters the tracking number "TRK123456789" in the tracking field
Then the tracking number is accepted
@TC-197
Scenario: Submit the tracking request
Given the tracking number is accepted
When the user submits the tracking request
Then the tracking information is retrieved
@TC-197
Scenario: Verify the current status of the order
Given the tracking information is retrieved
When the user checks the current status of the order
Then the current order status is displayed correctly
@TC-197
Scenario: Check the estimated delivery time provided
Given the tracking information is retrieved
When the user checks the estimated delivery time
Then the estimated delivery time is shown
@TC-197
Scenario: Verify the carrier information associated with the order
Given the tracking information is retrieved
When the user checks the carrier information
Then the carrier information is displayed correctly
@TC-197
Scenario: Attempt to track an order using an incorrect tracking number
Given the user is on the Track Order page
When the user enters an incorrect tracking number
Then the system displays an error message for invalid tracking number
@TC-197
Scenario: Ensure the tracking information is updated in real-time
Given the tracking information is retrieved
When there are changes in the tracking information
Then the tracking information updates reflect real-time changes
@TC-197
Scenario: Check for any discrepancies in the tracking details provided
Given the tracking information is retrieved
When the user checks the tracking details
Then the tracking details are accurate and consistent
@TC-197
Scenario: Validate the security of tracking information access
Given the tracking information is retrieved
When the user accesses the tracking information
Then the tracking information is secure and requires authentication
@TC-197
Scenario: Ensure the tracking interface is user-friendly and intuitive
Given the user is on the Track Order page
When the user interacts with the tracking interface
Then the tracking interface is easy to navigate and understand
@TC-197
Scenario: Verify the responsiveness of the tracking page across devices
Given the user is on the Track Order page
When the user accesses the tracking page on different devices
Then the tracking page is responsive and loads efficiently on all devices
@TC-197
Scenario: Attempt to track multiple orders simultaneously
Given the user is on the Track Order page
When the user submits multiple tracking requests simultaneously
Then the system handles multiple tracking requests without errors
@TC-197
Scenario: Check if tracking history is available for previous orders
Given the user is logged in
When the user accesses the tracking history
Then the tracking history is accessible and displays past tracking information