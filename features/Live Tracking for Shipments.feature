Feature: Live Tracking for Shipments
@TC-2
Scenario: View live tracking information with real-time updates
Given User is logged into the system
When User navigates to the live tracking page
Then Live tracking page is displayed
@TC-2
Scenario: Enter shipment ID for tracking
Given Shipment data is available in the system
When User enters the Shipment ID 54321 in the tracking field
Then Live tracking details for ID 54321 are displayed
@TC-2
Scenario: Check current location of the shipment
Given User ID is 09876
When User checks the current location of the shipment
Then Current location is displayed on the map
@TC-2
Scenario: Simulate change in shipment location
When User simulates a change in shipment location
Then Location updates in real-time on the map
@TC-2
Scenario: Verify estimated delivery time
When User verifies the estimated delivery time
Then Estimated delivery time is displayed accurately
@TC-2
Scenario: Refresh the live tracking page
When User refreshes the page
Then Live tracking information remains consistent
@TC-2
Scenario: Log out and log back in
When User logs out and logs back in
Then Live tracking information remains available
@TC-2
Scenario: Check notification settings for live tracking updates
When User checks the notification settings for live tracking updates
Then Notifications are enabled for live tracking updates
@TC-2
Scenario: Simulate network issue during location update
When User simulates a network issue and attempts to update location
Then System handles the issue gracefully and retries the update
@TC-2
Scenario: Verify tracking history log
When User verifies the tracking history log
Then Log contains all location updates with timestamps
@TC-2
Scenario: Check for error messages during location updates
When User checks for any error messages during location updates
Then No error messages are displayed
@TC-2
Scenario: Update location from a different device
When User attempts to update location from a different device
Then Location updates are synchronized across devices
@TC-2
Scenario: Verify live tracking on a mobile device
When User verifies the live tracking on a mobile device
Then Tracking is consistent with the desktop view
@TC-2
Scenario: Check live tracking after system reboot
When User checks the live tracking after a system reboot
Then Tracking information remains available
@TC-2
Scenario: Verify accuracy of live tracking system
When User verifies the accuracy of the live tracking system
Then Live tracking information is accurate and reliable