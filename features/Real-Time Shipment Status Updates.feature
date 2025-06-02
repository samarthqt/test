Feature: Real-Time Shipment Status Updates
@TC-1
Scenario: Verify real-time updates on shipment status
Given User is logged into the system
When User navigates to the shipment tracking page
Then Shipment tracking page is displayed
And Shipment data is available in the system
@TC-1
Scenario: Enter shipment ID and display details
Given Shipment ID is "12345"
When User enters the Shipment ID "12345" in the tracking field
Then Shipment details for ID "12345" are displayed
@TC-1
Scenario: Check current status of the shipment
Given User ID is "67890"
When User checks the current status of the shipment
Then Current status is displayed as "In Transit"
@TC-1
Scenario: Simulate status update to 'Out for Delivery'
When User simulates a status update to "Out for Delivery"
Then Status updates to "Out for Delivery" in real-time
@TC-1
Scenario: Simulate status update to 'Delivered'
When User simulates a status update to "Delivered"
Then Status updates to "Delivered" in real-time
@TC-1
Scenario: Verify timestamp of latest status update
When User verifies the timestamp of the latest status update
Then Timestamp matches the current time
@TC-1
Scenario: Refresh the page
When User refreshes the page
Then Status remains "Delivered" with the same timestamp
@TC-1
Scenario: Log out and log back in
When User logs out and logs back in
Then Shipment status remains "Delivered"
@TC-1
Scenario: Check notification settings for shipment updates
When User checks the notification settings for shipment updates
Then Notifications are enabled for real-time updates
@TC-1
Scenario: Simulate network issue and attempt to update status
When User simulates a network issue and attempts to update status
Then System handles the issue gracefully and retries the update
@TC-1
Scenario: Verify shipment history log
When User verifies the shipment history log
Then Log contains all status updates with timestamps
@TC-1
Scenario: Check for error messages during status updates
When User checks for any error messages during status updates
Then No error messages are displayed
@TC-1
Scenario: Attempt to update status from a different device
When User attempts to update status from a different device
Then Status updates are synchronized across devices
@TC-1
Scenario: Verify shipment status on a mobile device
When User verifies the shipment status on a mobile device
Then Status is consistent with the desktop view
@TC-1
Scenario: Check shipment status after a system reboot
When User checks the shipment status after a system reboot
Then Status remains "Delivered"