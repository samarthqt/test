Feature: View Order Status for Shipped Order

  @TC-18
  Scenario: User views the status of a shipped order and accesses tracking links
    Given the user is logged in
    When the user navigates to the account dashboard
    Then the account dashboard is displayed with order history

    When the user locates Order ID 22222 in the order history
    Then Order ID 22222 is listed with status 'Shipped'

    When the user selects Order ID 22222 to view details
    Then order details are displayed, including status and tracking link

    When the user selects the tracking link
    Then the tracking page is opened, displaying real-time shipment status