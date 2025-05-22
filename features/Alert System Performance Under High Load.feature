Feature: Alert System Performance Under High Load
@TC-8
Scenario: Verify alert system's performance under high load conditions
Given the user is logged into the Dynamics 365 system with valid credentials
And the dashboard is displayed
And multiple shipment orders exist with Order IDs ranging from 10001 to 10050
And customers have subscribed to shipment alerts
When the user navigates to the 'Orders' module
Then the orders module is displayed with a list of orders
And the user selects orders with IDs ranging from 10001 to 10050
Then order details for each selected order are displayed
And the shipment status is 'Dispatched'
When the user updates the shipment status of all selected orders to 'Dispatched'
Then the shipment status for all selected orders is updated to 'Dispatched'
And the alert system is monitored for outgoing alerts
Then alerts are sent to customer@example.com for all orders without delay
When the system's performance metrics are verified
Then the system maintains optimal performance under high load conditions