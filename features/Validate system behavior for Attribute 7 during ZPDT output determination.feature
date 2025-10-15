Feature: Validate system behavior for Attribute 7 during ZPDT output determination

  @TC-311
  Scenario Outline: Validate Attribute 7 input values during ZPDT output determination
    Given the user is logged into the SAP system with necessary authorizations
    When the user navigates to the transaction code for creating billing documents
    And the user creates a billing document and populates Attribute 7 with "<attribute_7_value>"
    And the user saves the billing document and triggers the output determination process
    Then the system logs "<error_message>" for Attribute 7
    And the system "<output_status>" the ZPDT output determination process
    And the user validates the error message displayed
    And the user checks the logs for additional warnings or errors

    Examples:
      | attribute_7_value | error_message                          | output_status          |
      | -1                | Attribute 7 has an invalid value       | halts the process      |
      | blank             | Attribute 7 cannot be blank            | halts the process      |
      | 999999999         | Attribute 7 exceeds maximum length     | halts the process      |
      | special_characters| Attribute 7 contains invalid characters| halts the process      |
      | valid_value       | No error                               | completes successfully |

  @TC-311
  Scenario: Prevent saving billing document with invalid Attribute 7
    Given the user is logged into the SAP system with necessary authorizations
    When the user navigates to the transaction code for creating billing documents
    And the user creates a billing document and populates Attribute 7 with an invalid value
    And the user attempts to resave the billing document without correcting Attribute 7
    Then the system prevents saving the document without a valid Attribute 7 value

  @TC-311
  Scenario: Update Attribute 7 and retry ZPDT output determination
    Given the user is logged into the SAP system with necessary authorizations
    When the user navigates to the transaction code for creating billing documents
    And the user creates a billing document and populates Attribute 7 with an invalid value
    And the user updates Attribute 7 in the billing document with a valid value
    And the user retries the output determination process
    Then the output determination process completes successfully

  @TC-311
  Scenario: Validate system enforces Attribute 7 validation during ZPDT output determination
    Given the user is logged into the SAP system with necessary authorizations
    When the user navigates to the transaction code for creating billing documents
    And the user creates a billing document with Attribute 7
    Then the system enforces validation for Attribute 7 during output determination

  @TC-311
  Scenario: Document test results and observations
    Given the user has completed the validation of Attribute 7 during ZPDT output determination
    When the user documents the test results and observations
    Then the test results should include all error handling behaviors