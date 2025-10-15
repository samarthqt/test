Feature: Output determination with invalid Attribute 7 values in payer master data

  @TC-284
  Scenario Outline: Validate the system behavior for invalid Attribute 7 values during billing output determination
    Given the user logs into the SAP system with valid credentials
    When the user navigates to the transaction for maintaining payer master data
    And the user populates Attribute 7 in the payer master data with "<attribute_7_value>"
    And the user saves the changes to the payer master data
    And the user navigates to the field catalog configuration screen (ZPDT)
    Then Attribute 7 should be present in the field catalog
    When the user creates a new billing document with standard data
    And the user triggers the output determination process for the billing document
    Then the system logs should indicate "<log_message>"
    And no output should be generated due to invalid Attribute 7 values
    And the logs should contain "<error_message>"
    When the user documents the test results and closes the session
    Then the session should be closed successfully

    Examples:
      | attribute_7_value | log_message                                     | error_message                                |
      | INVALID_VALUE     | Attribute 7 contains invalid values, process aborted | Error: Invalid Attribute 7 value detected   |
      | UNSUPPORTED_CHAR  | Attribute 7 contains unsupported characters, process aborted | Error: Unsupported characters in Attribute 7 |
      | EMPTY             | Attribute 7 is blank, process aborted          | Error: Attribute 7 cannot be blank          |
      | TOO_LONG_VALUE    | Attribute 7 exceeds allowed length, process aborted | Error: Attribute 7 exceeds length limit     |