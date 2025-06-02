Feature: Verify Real-Time Update of Tracking Information
@TC-199
Scenario: Ensure tracking information is updated in real-time
Given a user account with recent purchase
And valid credentials
When the user logs in to the account
Then the user is successfully logged in
@TC-199
Scenario: Navigate to the 'Track Order' section
Given User ID: 67890
When the user navigates to the 'Track Order' section
Then the Track Order page is displayed
@TC-199
Scenario: Enter tracking number in the tracking field
Given Tracking Number: TRK123456789
And Order Date: 29th May 2023
When the user enters the tracking number in the tracking field
Then the tracking number is accepted
@TC-199
Scenario: Submit the tracking request
When the user submits the tracking request
Then tracking information is retrieved
@TC-199
Scenario: Verify the current status of the order
When the user checks the current status of the order
Then the current order status is displayed correctly
@TC-199
Scenario: Check the estimated delivery time
When the user checks the estimated delivery time provided
Then the estimated delivery time is shown
@TC-199
Scenario: Verify the carrier information
When the user verifies the carrier information associated with the order
Then the carrier information is displayed correctly
@TC-199
Scenario: Ensure tracking information is updated in real-time
When the user ensures the tracking information is updated in real-time
Then tracking information updates reflect real-time changes
@TC-199
Scenario: Check for discrepancies in tracking details
When the user checks for any discrepancies in the tracking details provided
Then tracking details are accurate and consistent
@TC-199
Scenario: Validate the accuracy of tracking details
When the user validates the accuracy of the tracking details displayed
Then tracking details are accurate and consistent
@TC-199
Scenario: Verify the security of tracking information access
When the user verifies the security of tracking information access
Then tracking information is secure and requires authentication
@TC-199
Scenario: Ensure tracking interface is user-friendly
When the user ensures the tracking interface is user-friendly and intuitive
Then the tracking interface is easy to navigate and understand
@TC-199
Scenario: Verify responsiveness of tracking page across devices
When the user verifies the responsiveness of the tracking page across devices
Then the tracking page is responsive and loads efficiently on all devices
@TC-199
Scenario: Attempt to track multiple orders simultaneously
When the user attempts to track multiple orders simultaneously
Then the system handles multiple tracking requests without errors
@TC-199
Scenario: Check tracking history availability for previous orders
When the user checks if tracking history is available for previous orders
Then tracking history is accessible and displays past tracking information