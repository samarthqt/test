Feature: Access Tracking Link for Shipped Order

  @TC-22
  Scenario: User accesses tracking link for a shipped order
    Given the user is logged in
    When the user navigates to the account dashboard
    Then the account dashboard is displayed with order history
    When the user locates Order ID 66666 in the order history
    Then Order ID 66666 is listed with status 'Shipped'
    When the user selects Order ID 66666 to view details
    Then order details are displayed, including status and tracking link
    When the user selects the tracking link
    Then the tracking page is opened, displaying real-time shipment status