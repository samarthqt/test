Feature: Alert System Under High Load
To verify the alert system's performance under high load conditions.
@TC-8
Scenario: Verify alert system performance under high load
Given multiple shipment orders exist in the system
When I log in to the Dynamics 365 system with valid credentials
Then the user is logged in and the dashboard is displayed
When I navigate to the 'Orders' module
Then the Orders module is displayed with a list of orders
When I select orders with IDs ranging from 10001 to 10050
Then order details for each selected order are displayed
When I update the shipment status of all selected orders to 'Dispatched'
Then shipment status for all selected orders is updated to 'Dispatched'
When I monitor the alert system for outgoing alerts
Then alerts are sent to customer@example.com for all orders without delay
When I verify the system's performance metrics
Then the system maintains optimal performance under high load conditions