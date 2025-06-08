Feature: Real-Time Shipment Status Changes
@TC-1
Scenario: Verify real-time updates on shipment status
Given the user is logged into the system
When the user navigates to the "My Shipments" section from the dashboard
Then the "My Shipments" section is displayed with a list of active shipments
When the user selects an active shipment from the shipment list
Then the real-time shipment timeline is displayed on the screen
When the user enables push notifications for shipment status updates
Then push notifications for shipment status updates are enabled
When a backend status update is simulated to "In Transit"
Then the status update reflects instantly on the UI
And a push notification is triggered for the update
When the user views the shipment map
Then the location corresponds to the new status "In Transit"
When a status update delay is simulated (e.g., server lag or throttling)
Then a message like "Awaiting latest update..." is displayed