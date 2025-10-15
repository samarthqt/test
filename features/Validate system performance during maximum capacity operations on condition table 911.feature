Feature: Validate system performance during maximum capacity operations on condition table 911

  @TC-559
  Scenario: User logs into the SAP system and navigates to condition table maintenance
    Given the user has appropriate credentials
    When the user logs into the SAP system
    Then the user is successfully logged into the SAP system
    And the condition table is populated with the maximum allowed entries
    And the user navigates to the condition table maintenance transaction
    Then the condition table maintenance screen is displayed

  @TC-559
  Scenario Outline: User selects condition table 911 and performs operations
    Given the user has navigated to the condition table maintenance screen
    When the user selects condition table <Table ID> from the list
    Then the condition table is displayed for maintenance
    When the user performs a <Operation> operation on the condition table
    Then the <Operation> operation is performed successfully without errors
    And the system response time remains within acceptable thresholds

    Examples:
      | Table ID | Operation        |
      | 911      | data retrieval   |
      | 911      | update           |

  @TC-559
  Scenario: User generates a report to validate entries in the condition table
    Given the user has performed a data retrieval operation on the condition table
    When the user generates a report to validate the number of entries in the condition table
    Then the report accurately reflects the number of entries in the condition table

  @TC-559
  Scenario: User validates system performance metrics during data retrieval process
    Given the user has performed a data retrieval operation on the condition table
    When the user monitors the system's performance metrics during the data retrieval process
    Then the system performance metrics remain within acceptable thresholds

  @TC-559
  Scenario: User verifies that an updated entry is saved and accessible
    Given the user has performed an update operation on a specific entry in the condition table
    When the user verifies the updated entry
    Then the updated entry is saved and accessible without errors

  @TC-559
  Scenario: User validates system performance during concurrent operations
    Given the user performs concurrent operations on the condition table
    When the user monitors the system's performance
    Then the system performance remains stable during concurrent operations

  @TC-559
  Scenario: User documents results and confirms compliance with performance requirements
    Given the user has completed operations on the condition table
    When the user documents the results
    Then the results are documented
    And the system meets performance requirements