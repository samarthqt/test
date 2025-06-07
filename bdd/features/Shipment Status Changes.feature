Feature: Shipment Status Changes
@TC-1
Scenario: Verify real-time updates on shipment status
Given the user is logged into the system
When the user navigates to the "My Shipments" section from the dashboard
And selects an active shipment from the shipment list
Then the real-time shipment timeline is displayed on the screen
@TC-1
Scenario: Enable push notifications for shipment status updates
Given the user is in the "My Shipments" section
When the user enables push notifications for shipment status updates
Then push notifications should be enabled
@TC-1
Scenario: Simulate and verify backend status update to "In Transit"
Given the user is viewing an active shipment
When a backend status update is simulated to "In Transit"
Then the status update should reflect instantly on the UI
And a push notification should be triggered for the update
@TC-1
Scenario: View shipment map and confirm location
Given the status update to "In Transit" is reflected on the UI
When the user views the shipment map
Then the location should correspond to the new status
@TC-1
Scenario: Simulate status update delay and confirm message
Given the user is viewing the shipment status
When a status update delay is simulated (e.g., server lag or throttling)
Then a message like “Awaiting latest update…” should be displayed