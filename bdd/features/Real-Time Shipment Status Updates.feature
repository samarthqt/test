Feature: Real-Time Shipment Status Updates
@TC-1
Scenario: Verify real-time updates on shipment status
Given the user is logged into the system
When the user navigates to the "My Shipments" section from the dashboard
Then the "My Shipments" section is displayed
@TC-1
Scenario: Select an active shipment and observe the real-time shipment timeline
Given the user is in the "My Shipments" section
When the user selects an active shipment from the shipment list
Then the real-time shipment timeline is displayed on the screen
@TC-1
Scenario: Enable push notifications for shipment status updates
Given the user has selected an active shipment
When the user enables push notifications for shipment status updates
Then push notifications are enabled successfully
@TC-1
Scenario: Simulate a backend status update to "In Transit" and verify UI update
Given the user has enabled push notifications
When a backend status update is simulated to "In Transit"
Then the status update reflects instantly on the UI
And a push notification is triggered for the update
@TC-1
Scenario: View shipment map and confirm location corresponds to new status
Given the status update is reflected on the UI
When the user views the shipment map
Then the location on the map corresponds to the new status
@TC-1
Scenario: Simulate a status update delay and confirm message display
Given the user is viewing the shipment status
When a status update delay is simulated (e.g., server lag or throttling)
Then a message like “Awaiting latest update…” is displayed
@TC-1
Scenario: Enable email notifications for shipment status updates
Given the user is viewing the shipment status
When the user enables email notifications for shipment status updates
Then email notifications are enabled successfully
@TC-1
Scenario: Simulate a delay in delivery and verify updated estimated delivery time
Given the user has enabled email notifications
When a delay in delivery is simulated
Then the updated estimated delivery time is displayed
@TC-1
Scenario: Download shipment status report as a PDF and verify contents
Given the user is viewing the shipment status
When the user downloads the shipment status report as a PDF
Then the PDF contains the correct shipment status information