Feature: Real-Time Shipment Status Updates
@TC-1
Scenario: Verify real-time updates on shipment status
Given the user is logged into the system
When the user navigates to the shipment tracking page
Then the shipment tracking page is displayed
@TC-1
Scenario: Enter shipment ID and check status
Given shipment data is available in the system
When the user enters Shipment ID "12345" in the tracking field
Then shipment details for ID "12345" are displayed
@TC-1
Scenario: Select the location and confirm
Given shipment details for ID "12345" are displayed
When the user selects the location in the location field
And clicks on the OK button
Then the location is confirmed
@TC-1
Scenario: Check current shipment status
Given the user has entered the Shipment ID "12345"
When the user checks the current status of the shipment
Then the current status is displayed as 'In Transit'
@TC-1
Scenario: Simulate status update to 'Out for Delivery'
Given the current status is 'In Transit'
When a status update is simulated to 'Out for Delivery'
Then the status updates to 'Out for Delivery' in real-time
@TC-1
Scenario: Simulate status update to 'Delivered'
Given the current status is 'Out for Delivery'
When a status update is simulated to 'Delivered'
Then the status updates to 'Delivered' in real-time
@TC-1
Scenario: Verify timestamp of latest status update
Given the status is 'Delivered'
When the user verifies the timestamp of the latest status update
Then the timestamp matches the current time
@TC-1
Scenario: Refresh the page and verify status
Given the status is 'Delivered'
When the user refreshes the page
Then the status remains 'Delivered' with the same timestamp
@TC-1
Scenario: Log out and log back in to verify status
Given the user is logged out
When the user logs back in
Then the shipment status remains 'Delivered'
@TC-1
Scenario: Check notification settings for shipment updates
Given the user is logged in
When the user checks the notification settings for shipment updates
Then notifications are enabled for real-time updates
@TC-1
Scenario: Simulate network issue during status update
Given the user is attempting to update status
When a network issue is simulated
Then the system handles the issue gracefully and retries the update
@TC-1
Scenario: Verify shipment history log
Given the status updates have been made
When the user verifies the shipment history log
Then the log contains all status updates with timestamps
@TC-1
Scenario: Check for error messages during status updates
Given the status updates have been made
When the user checks for any error messages
Then no error messages are displayed