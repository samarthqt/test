Feature: Order Tracking with Real-Time Updates

  @TC-21
  Scenario Outline: Verify that order status updates in real-time in the user's account dashboard
    Given the user is logged into their account
    When the user navigates to the account dashboard
    Then the account dashboard should display with order history for User ID "<UserID>"
    When the user locates Order ID "<OrderID>" in the order history
    Then Order ID "<OrderID>" should be listed with current status "<CurrentStatus>"
    When a status change is simulated in the backend system
    Then the order status should update in real-time on the account dashboard
    And the user should receive a notification about the status change

    Examples:
      | UserID | OrderID | CurrentStatus     |
      | 12345  | 55555   | Order is in transit |