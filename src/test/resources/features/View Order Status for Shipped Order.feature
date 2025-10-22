Feature: View Order Status for Shipped Order

  @TC-16 @TC-15 @TC-18 @TC-13
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

  @TC-16 @TC-15 @TC-13
  Scenario: Receive Shipping Update SMS
    Given the user has placed an order
    And the user has opted in for SMS notifications
    When the order status is updated to 'Shipped'
    Then an SMS notification for shipping update is received on the user's phone

  @TC-16 @TC-15
  Scenario: Receive SMS for Account Changes
    Given the user has opted in for SMS notifications
    When the user changes account details such as password or email
    Then account details are successfully changed
    And an SMS notification for account changes is received on the user's phone

  @TC-16
  Scenario: Receive SMS for Password Recovery
    Given the user has opted in for SMS notifications
    When the user initiates a password recovery process
    Then the password recovery process is initiated
    And an SMS notification for password recovery is received on the user's phone