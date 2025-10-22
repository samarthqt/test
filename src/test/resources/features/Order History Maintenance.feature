Feature: Order History Maintenance

  @TC-23
  Scenario: User navigates to the account dashboard to view order history
    Given the user is logged in
    When the user navigates to the account dashboard
    Then the account dashboard is displayed with order history

  @TC-23
  Scenario: User verifies all past orders are listed in the order history
    Given the user is on the account dashboard with past orders
    When the user reviews the order history
    Then all past orders are displayed with their respective statuses

  @TC-23
  Scenario: User selects a past order to view details
    Given the user is on the order history page
    When the user selects a past order
    Then the order details are displayed, including status and other relevant information