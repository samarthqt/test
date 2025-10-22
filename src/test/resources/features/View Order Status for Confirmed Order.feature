Feature: View Order Status for Confirmed Order

  @TC-17
  Scenario: User views the status of a confirmed order in their account dashboard
    Given the user is logged in
    When the user navigates to the account dashboard
    Then the account dashboard is displayed with order history
    And the user locates Order ID 11111 in the order history
    Then Order ID 11111 is listed with status 'Confirmed'
    When the user selects Order ID 11111 to view details
    Then the order details are displayed, including status and other relevant information