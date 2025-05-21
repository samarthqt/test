Feature: Real-Time Shipment Status Updates
@TC-1
Scenario: Verify real-time updates on shipment status
Given the user is logged into the system
When the user navigates to the shipment tracking page
Then the shipment tracking page is displayed
And shipment data is available in the system
@TC-1
Scenario: Enter Shipment ID and display details
Given the user is on the shipment tracking page
When the user enters the Shipment ID "12345" in the tracking field
Then shipment details for ID "12345" are displayed
@TC-1
Scenario: Check current status of the shipment
Given shipment details for ID "12345" are displayed
When the user checks the current status of the shipment
Then the current status is displayed as "In Transit"
@TC-1
Scenario: Simulate status update to 'Out for Delivery'
Given the current status is "In Transit"
When the status is updated to "Out for Delivery"
Then the status updates to "Out for Delivery" in real-time
@TC-1
Scenario: Simulate status update to 'Delivered'
Given the status is "Out for Delivery"
When the status is updated to "Delivered"
Then the status updates to "Delivered" in real-time
@TC-1
Scenario: Verify timestamp of the latest status update
Given the status is "Delivered"
When the user verifies the timestamp of the latest status update
Then the timestamp matches the current time
@TC-1
Scenario: Refresh the page and verify status
Given the status is "Delivered"
When the user refreshes the page
Then the status remains "Delivered" with the same timestamp
@TC-1
Scenario: Log out and log back in to verify status
Given the status is "Delivered"
When the user logs out and logs back in
Then the shipment status remains "Delivered"
@TC-1
Scenario: Check notification settings for shipment updates
Given the user is logged into the system
When the user checks the notification settings for shipment updates
Then notifications are enabled for real-time updates
@TC-1
Scenario: Simulate network issue and attempt to update status
Given there is a network issue
When the user attempts to update the status
Then the system handles the issue gracefully and retries the update
@TC-1
Scenario: Verify shipment history log
Given the status has been updated multiple times
When the user verifies the shipment history log
Then the log contains all status updates with timestamps
@TC-1
Scenario: Check for error messages during status updates
Given the status has been updated
When the user checks for error messages
Then no error messages are displayed
@TC-1
Scenario: Attempt to update status from a different device
Given the status is "Delivered"
When the user attempts to update the status from a different device
Then the status updates are synchronized across devices
@TC-1
Scenario: Verify shipment status on a mobile device
Given the user is on a mobile device
When the user verifies the shipment status
Then the status is consistent with the desktop view
@TC-1
Scenario: Check shipment status after a system reboot
Given the system has been rebooted
When the user checks the shipment status
Then the status remains "Delivered"