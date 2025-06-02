Feature: Alert System Performance Under High Load
@TC-8
Scenario: Verify the alert system's performance under high load conditions
Given the user logs in to the Dynamics 365 system with valid credentials
Then the user is logged in and the dashboard is displayed
And multiple shipment orders exist in the system with Order IDs ranging from 10001 to 10050
And customers have subscribed to shipment alerts
When the user navigates to the 'Orders' module
Then the Orders module is displayed with a list of orders
When the user selects orders with IDs ranging from 10001 to 10050
Then order details for each selected order are displayed with Shipment Status as 'Dispatched'
When the user updates the shipment status of all selected orders to 'Dispatched'
Then shipment status for all selected orders is updated to 'Dispatched'
When the user monitors the alert system for outgoing alerts
Then alerts are sent to customer@example.com for all orders without delay
When the user verifies the system's performance metrics
Then the system maintains optimal performance under high load conditions