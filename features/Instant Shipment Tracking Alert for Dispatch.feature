Feature: Instant Shipment Tracking Alert for Dispatch

  @TC-3
  Scenario: Verify that customers receive an instant alert when their shipment is dispatched
    Given a shipment order exists in the system
    And the customer has subscribed to shipment alerts
    When the user logs in to the Dynamics 365 system with valid credentials
    Then the user is logged in and the dashboard is displayed
    And the order ID is 12345
    When the user navigates to the 'Orders' module
    Then the orders module is displayed with a list of orders
    And the customer email is customer@example.com
    When the user selects the order with ID 12345
    Then the order details for order ID 12345 are displayed
    And the shipment status is 'Dispatched'
    When the user updates the shipment status to 'Dispatched'
    Then the shipment status is updated to 'Dispatched'
    And an alert is sent to customer@example.com notifying them of the dispatch status
    Then the customer receives an alert with the message: 'Your shipment has been dispatched.'