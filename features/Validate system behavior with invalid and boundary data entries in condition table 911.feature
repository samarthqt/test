Feature: Validate system behavior with invalid and boundary data entries in condition table 911

  @TC-290
  Scenario: User logs into the SAP system successfully
    Given the SAP system is configured and accessible
    When the user logs into the SAP system with valid credentials
    Then the user is successfully logged into the SAP system

  @TC-290
  Scenario Outline: Validate data entry in condition table 911
    Given the condition table 911 is created and activated
    When the user navigates to transaction VK11 to populate the condition table
    And the user enters "<Sales Org>", "<Billing Type>", and "<Attribute 7>" into the condition table
    Then the system displays "<Error Message>"
    And the system prevents saving the invalid data

    Examples:
      | Sales Org | Billing Type | Attribute 7 | Error Message                          |
      | ABCD      | XYZ          | -1          | Invalid data entries detected          |
      |           |              |             | Fields cannot be blank                 |
      | ABCD12345 | XYZ12345     | 9999999999  | Data exceeds the acceptable range      |

  @TC-290
  Scenario: User corrects invalid entries in the condition table
    Given the user navigates to transaction VK11 to populate the condition table
    When the user corrects the invalid entries with valid data
    Then the system accepts the corrected data entries
    And the user saves the corrected entries successfully

  @TC-290
  Scenario: Verify saved data using transaction SE16
    Given the user has saved corrected entries in the condition table
    When the user verifies the saved data using transaction SE16
    Then the saved data displays correctly in the query results

  @TC-290
  Scenario: Test output determination process with corrected table
    Given the user has saved corrected entries in the condition table
    When the user tests the output determination process using the corrected table
    Then the output determination works correctly using the condition table

  @TC-290
  Scenario: Verify logs for errors or warnings
    Given the user has completed the output determination process
    When the user verifies the logs for any errors or warnings during the process
    Then no errors or warnings are found in the logs

  @TC-290
  Scenario Outline: Validate boundary values in condition table 911
    Given the condition table 911 is created and activated
    When the user navigates to transaction VK11 to populate the condition table
    And the user enters boundary values "<Boundary Sales Org>", "<Boundary Billing Type>", and "<Boundary Attribute 7>" into the condition table
    Then the system accepts the boundary values without errors
    And the user saves the boundary values successfully

    Examples:
      | Boundary Sales Org | Boundary Billing Type | Boundary Attribute 7 |
      | A                  | B                    | 0                    |
      | Z                  | Y                    | 999999999            |
      | ABCD               | XYZ                  | 123456789            |

  @TC-290
  Scenario: Verify saved boundary values using transaction SE16
    Given the user has saved boundary values in the condition table
    When the user verifies the saved boundary values using transaction SE16
    Then the boundary values are saved and displayed correctly in the query results

  @TC-290
  Scenario: Test output determination process with boundary values
    Given the user has saved boundary values in the condition table
    When the user tests the output determination process using the table with boundary values
    Then the output determination works correctly using the table with boundary values