Feature: Alert System Performance Under High Load
@TC-8
Scenario: Verify alert system's performance under high load conditions
Given I am logged into the Dynamics 365 system with valid credentials
And the dashboard is displayed
And multiple shipment orders exist with IDs ranging from 10001 to 10050
And customers have subscribed to shipment alerts
When I navigate to the 'Orders' module
Then the Orders module is displayed with a list of orders
And the customer email is customer@example.com
When I select orders with IDs ranging from 10001 to 10050
Then order details for each selected order are displayed
And the shipment status is 'Dispatched'
When I update the shipment status of all selected orders to 'Dispatched'
Then the shipment status for all selected orders is updated to 'Dispatched'
When I monitor the alert system for outgoing alerts
Then alerts are sent to customer@example.com for all orders without delay
And the system maintains optimal performance under high load conditions