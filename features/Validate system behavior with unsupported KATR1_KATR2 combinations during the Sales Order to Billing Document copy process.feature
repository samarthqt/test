Feature: Validate system behavior with unsupported KATR1/KATR2 combinations during the Sales Order to Billing Document copy process

  @TC-454
  Scenario Outline: Ensure the system generates errors for unsupported KATR1/KATR2 combinations
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials
    And the user navigates to the Sales Order to Billing Document copy process screen
    When the user selects a Sales Order with KATR1 value "<KATR1>" and KATR2 value "<KATR2>"
    And the user initiates the copy process to generate a billing document
    Then the system displays an error message "<ErrorMessage>" indicating unsupported KATR1/KATR2 combination
    And the user documents the error message details for review
    And the user logs out of the SAP S/4HANA Cloud system successfully

    Examples:
      | KATR1          | KATR2          | ErrorMessage                                      |
      | Unsupported1   | Unsupported2   | Unsupported KATR1/KATR2 combination detected     |
      | UnsupportedA   | UnsupportedB   | Unsupported KATR1/KATR2 combination detected     |
      | InvalidValue1  | InvalidValue2  | Unsupported KATR1/KATR2 combination detected     |
      | TestValue1     | TestValue2     | Unsupported KATR1/KATR2 combination detected     |