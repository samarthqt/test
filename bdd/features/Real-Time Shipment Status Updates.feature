Feature: Real-Time Shipment Status Updates
@TC-1
Scenario: Verify real-time updates on shipment status
Given the user is logged into the system
When the user logs in as a standard user with a valid account
Then the dashboard should be displayed
When the user navigates to the "My Shipments" section from the dashboard
Then the "My Shipments" section is displayed
When the user selects an active shipment from the shipment list
Then the shipment details are displayed
And the real-time shipment timeline is visible on the screen
When the user enables push notifications for shipment status updates
Then push notifications should be enabled
When a backend status update is simulated to "In Transit"
Then the status update should reflect instantly on the UI
And a push notification should be triggered for the update
When the user views the shipment map
Then the location should correspond to the new status
When a status update delay is simulated (e.g., server lag or throttling)
Then a message like “Awaiting latest update…” should be displayed