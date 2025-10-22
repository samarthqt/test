Feature: View Order Status for Cancelled Order

  @TC-20
  Scenario: User views the status of a cancelled order in their account dashboard
    Given the user is logged in
    When the user navigates to the account dashboard
    Then the account dashboard is displayed with order history
    And the user locates Order ID 44444 in the order history
    Then Order ID 44444 is listed with status 'Cancelled'
    When the user selects Order ID 44444 to view details
    Then the order details are displayed, including status and cancellation reason