Feature: Validate system behavior with maximum field lengths for KATR1 and KATR2

  @TC-456
  Scenario Outline: Validate maximum field lengths for KATR1 and KATR2 during the Sales Order to Billing Document copy process
    Given the user is logged into the SAP S/4HANA Cloud system
    And the user navigates to the Sales Order to Billing Document copy process screen
    When the user selects Sales Order with KATR1 "<KATR1_Value>" and KATR2 "<KATR2_Value>"
    And the user initiates the copy process to generate a billing document
    Then the system should process the maximum field lengths without errors or warnings
    And the user documents the results for review
    And the user logs out of the SAP S/4HANA Cloud system

    Examples:
      | KATR1_Value        | KATR2_Value        |
      | MaxLengthValue1    | MaxLengthValue2    |