Feature: View Order Status for Delivered Order

  @TC-19
  Scenario: User views the status of a delivered order
    Given the user is logged in
    When the user navigates to the account dashboard
    Then the account dashboard is displayed with order history
    When the user locates Order ID 33333 in the order history
    Then Order ID 33333 is listed with status 'Delivered'
    When the user selects Order ID 33333 to view details
    Then order details are displayed, including status and delivery confirmation