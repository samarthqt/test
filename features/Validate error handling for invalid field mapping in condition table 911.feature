Feature: Validate error handling for invalid field mapping in condition table 911

  @TC-294
  Scenario: User navigates to the access sequence maintenance screen
    Given the user navigates to transaction "V/07" for maintaining access sequences
    Then the access sequence maintenance screen is displayed

  @TC-294
  Scenario: User searches for and selects access sequence Z002
    Given the user searches for access sequence "Z002"
    When the user selects the access sequence "Z002"
    Then the access sequence "Z002" is displayed for editing

  @TC-294
  Scenario: User adds condition table 911 to the access sequence
    Given the user has access sequence "Z002" open for editing
    When the user adds condition table "911" to the access sequence
    Then condition table "911" is added to the access sequence

  @TC-294
  Scenario Outline: Validate error handling for invalid field mapping in condition table 911
    Given the user has added condition table "<ConditionTableID>" to the access sequence
    When the user defines an invalid field mapping with "<InvalidFieldMapping>"
    Then the system displays an error message "<ErrorMessage>" for invalid field mapping
    When the user attempts to save the changes to access sequence "<AccessSequenceID>"
    Then the system prevents saving of the access sequence due to invalid field mapping

    Examples:
      | ConditionTableID | InvalidFieldMapping           | ErrorMessage                       | AccessSequenceID |
      | 911              | Sales Org, Billing Type, XYZ  | Invalid field mapping detected     | Z002             |
      | 911              | Invalid Field, Billing Type   | Invalid field mapping detected     | Z002             |

  @TC-294
  Scenario: User corrects the field mapping and saves the changes
    Given the user has defined invalid field mappings for condition table "911"
    When the user corrects the field mapping
    And the user saves the changes
    Then the changes are saved successfully

  @TC-294
  Scenario: User documents the error message and validation behavior
    Given the user has encountered an error message for invalid field mapping
    When the user documents the error message and validation behavior
    Then the error message and validation behavior are documented