Feature: Validate system behavior with special characters in Attribute2

  @TC-155
  Scenario Outline: Validate Sales Order creation with special characters in Attribute2
    Given the user logs into the SAP S/4HANA Cloud system using valid credentials
    And the user navigates to the Sales Order creation screen
    When the user creates a Sales Order of type ZOR with Attribute1 as "<Attribute1>" and Attribute2 as "<Attribute2>"
    Then the Sales Order is created successfully
    And the Sales Order is saved successfully with a unique Order ID

    Examples:
      | Attribute1    | Attribute2                       |
      | ValidValue    | !@#$%^&*()_+-=[]{}|;:,.<>?       |

  @TC-155
  Scenario: Navigate to the billing due program screen
    Given the user has created and saved a Sales Order with special characters in Attribute2
    When the user navigates to the billing due program screen
    Then the billing due program screen is displayed

  @TC-155
  Scenario: Trigger the billing due program
    Given the user is on the billing due program screen
    When the user triggers the billing due program for the created Sales Order
    Then the billing due program starts execution
    And the billing due program completes successfully without errors

  @TC-155
  Scenario: Verify the billing document creation
    Given the billing due program has completed successfully
    When the user verifies the billing document created for the Sales Order
    Then the billing document is created successfully for the Sales Order

  @TC-155
  Scenario: Navigate to the billing document display screen
    Given a billing document is created for the Sales Order
    When the user navigates to the billing document display screen
    Then the billing document display screen is displayed

  @TC-155
  Scenario: Verify Attribute2 value in the billing document
    Given the user is on the billing document display screen
    When the user verifies the Attribute2 value in the billing document
    Then the Attribute2 value in the billing document matches the special characters provided during Sales Order creation

  @TC-155
  Scenario: Capture billing document details for audit purposes
    Given the billing document is displayed
    When the user captures the details of the billing document
    Then the billing document details are captured successfully

  @TC-155
  Scenario: Verify linkage between Sales Order and billing document
    Given the billing document is created for the Sales Order
    When the user verifies the linkage between the Sales Order and the billing document
    Then the linkage between the Sales Order and the billing document is verified successfully