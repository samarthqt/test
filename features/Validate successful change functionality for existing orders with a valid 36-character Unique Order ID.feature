Feature: Validate successful change functionality for existing orders with a valid 36-character Unique Order ID

  @TC-340
  Scenario: User logs into the SAP S/4HANA system successfully
    Given the user has valid SAP S/4HANA credentials
    When the user logs into the system
    Then the user is successfully logged into the SAP S/4HANA system

  @TC-340
  Scenario: User navigates to the Sales Order processing screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Sales Order processing screen
    Then the Sales Order processing screen is displayed

  @TC-340
  Scenario Outline: User searches for an order using a 36-character Unique Order ID
    Given the user is on the Sales Order processing screen
    When the user searches for an order using the Unique Order ID "<UniqueOrderID>"
    Then the order details corresponding to the Unique Order ID are displayed

    Examples:
      | UniqueOrderID                               |
      | 123456789012345678901234567890123456        |

  @TC-340
  Scenario Outline: User modifies the order details
    Given the user has accessed the order details using a valid Unique Order ID
    When the user updates the order details with quantity "<Quantity>" and delivery date "<DeliveryDate>"
    Then the updated order details are entered successfully

    Examples:
      | Quantity | DeliveryDate  |
      | 10       | 2023-11-01    |
      | 20       | 2023-12-15    |

  @TC-340
  Scenario: User saves the changes made to the order
    Given the user has modified the order details
    When the user saves the changes
    Then the changes are saved successfully
    And a confirmation message is displayed

  @TC-340
  Scenario: User verifies the changes in the order details screen
    Given the user has saved the changes to the order
    When the user views the order details screen
    Then the updated details are displayed correctly

  @TC-340
  Scenario: User checks the order history to confirm the changes
    Given the user has saved the changes to the order
    When the user checks the order history
    Then the order history shows the modification details with a timestamp

  @TC-340
  Scenario: User verifies the updated order details in the database
    Given the user has saved the changes to the order
    When the user checks the database
    Then the database reflects the updated order details

  @TC-340
  Scenario: User generates an order confirmation document
    Given the user has saved the changes to the order
    When the user generates an order confirmation document
    Then the order confirmation document reflects the updated details

  @TC-340
  Scenario: User validates system logs for errors or warnings during the update process
    Given the user has saved the changes to the order
    When the user validates system logs
    Then no errors or warnings are logged

  @TC-340
  Scenario: User performs a system-wide search for the updated order
    Given the user has saved the changes to the order
    When the user performs a system-wide search for the updated order
    Then the updated order details are displayed in the search results

  @TC-340
  Scenario: User logs out of the system
    Given the user has completed all tasks
    When the user logs out of the system
    Then the user is logged out successfully