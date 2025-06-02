Feature: Verify Order Tracking Details Display
@TC-198
Scenario: Ensure order tracking displays current status, estimated delivery time, and carrier information
Given a user account with a recent purchase
And the user is logged in using valid credentials
When the user navigates to the 'Track Order' section
And enters the tracking number "TRK987654321" in the tracking field
And submits the tracking request
Then the current status of the order is displayed correctly
And the estimated delivery time is shown
And the carrier information is displayed correctly
And the tracking details are accurate and consistent
And the tracking information updates reflect real-time changes
And tracking information is secure and requires authentication
And the tracking interface is easy to navigate and understand
And the tracking page is responsive and loads efficiently on all devices
And the system handles multiple tracking requests without errors
And tracking history is accessible and displays past tracking information
@TC-198
Scenario: Check for any discrepancies in the tracking details provided
Given a valid tracking number is provided post-purchase
When the tracking request is submitted
Then tracking details are accurate and consistent
@TC-198
Scenario: Verify the security of tracking information access
Given a user is logged in using valid credentials
When the user accesses tracking information
Then tracking information is secure and requires authentication
@TC-198
Scenario: Ensure the tracking interface is user-friendly and intuitive
Given a user is on the 'Track Order' page
When the user interacts with the tracking interface
Then the interface is easy to navigate and understand
@TC-198
Scenario: Verify the responsiveness of the tracking page across devices
Given a user accesses the tracking page on different devices
When the page loads
Then the tracking page is responsive and loads efficiently on all devices
@TC-198
Scenario: Attempt to track multiple orders simultaneously
Given a user has multiple orders to track
When the user submits multiple tracking requests
Then the system handles multiple tracking requests without errors
@TC-198
Scenario: Check if tracking history is available for previous orders
Given a user has previous orders
When the user accesses tracking history
Then tracking history is accessible and displays past tracking information