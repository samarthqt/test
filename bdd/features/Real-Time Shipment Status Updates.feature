Feature: Real-Time Shipment Status Updates
@TC-1
Scenario: User logs in and navigates to My Shipments section
Given the user is logged into the system
When the user navigates to the “My Shipments” section from the dashboard
Then the My Shipments section is displayed
@TC-1
Scenario: Select an active shipment and observe real-time shipment timeline
Given the user is in the My Shipments section
When the user selects an active shipment from the shipment list
Then the real-time shipment timeline is displayed on the screen
@TC-1
Scenario: Enable push notifications for shipment status updates
Given the real-time shipment timeline is displayed
When the user enables push notifications for shipment status updates
Then push notifications are enabled for shipment status updates
@TC-1
Scenario: Simulate backend status update to "In Transit"
Given push notifications are enabled for shipment status updates
When a backend status update is simulated to "In Transit"
Then the status update reflects instantly on the UI
And a push notification is triggered for the update
@TC-1
Scenario: View shipment map and confirm location corresponds to status
Given the status update is "In Transit"
When the user views the shipment map
Then the location corresponds to the new status
@TC-1
Scenario: Simulate a status update delay and display awaiting message
Given the user is viewing the shipment map
When a status update delay is simulated (e.g., server lag or throttling)
Then a message like “Awaiting latest update…” is displayed
@TC-1
Scenario: Enable email notifications for shipment status updates
Given the user is viewing the shipment map
When the user enables email notifications for shipment status updates
Then email notifications are enabled for shipment status updates
@TC-1
Scenario: Simulate delay in delivery and verify updated estimated delivery time
Given email notifications are enabled for shipment status updates
When a delay in delivery is simulated
Then the updated estimated delivery time is displayed
@TC-1
Scenario: Download shipment status report as PDF and verify contents
Given the updated estimated delivery time is displayed
When the user downloads the shipment status report as a PDF
Then the PDF contents are verified