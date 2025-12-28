Feature: Validate system behavior with maximum length Attribute1 in SAP S/4HANA Cloud

  @TC-154
  Scenario Outline: Validate the creation of a Sales Order with maximum allowable length for Attribute1 and its subsequent processing
    Given the user logs into the SAP S/4HANA Cloud system using valid credentials
    And the user navigates to the Sales Order creation screen
    When the user creates a Sales Order of type ZOR with Attribute1 set to "<Attribute1>" and Attribute2 set to "<Attribute2>"
    Then the Sales Order is created successfully with a unique Order ID
    And the user navigates to the billing due program screen
    When the user triggers the billing due program for the created Sales Order
    Then the billing due program completes successfully without errors
    And a billing document is created successfully for the Sales Order
    And the user navigates to the billing document display screen
    Then the Attribute1 value in the billing document matches "<Attribute1>"
    And the user captures the details of the billing document for audit purposes
    And the linkage between the Sales Order and the billing document is verified successfully

    Examples:
      | Attribute1                          | Attribute2  |
      | A repeated to maximum allowable length | ValidValue |