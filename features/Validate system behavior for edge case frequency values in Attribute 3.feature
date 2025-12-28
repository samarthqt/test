Feature: Validate system behavior for edge case frequency values in Attribute 3

  @TC-172
  Scenario: User logs into the SAP S/4HANA Cloud system and accesses the billing module
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user gains access to the billing module

  @TC-172
  Scenario: User navigates to the billing due program interface
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the billing due program using transaction code "BDP001"
    Then the billing due program interface is displayed

  @TC-172
  Scenario: User locates the configuration section for Attribute 3
    Given the user is on the billing due program interface
    When the user locates the configuration section for Attribute 3
    Then the configuration section for Attribute 3 is accessible

  @TC-172
  Scenario Outline: User sets Attribute 3 to an edge-case frequency value
    Given the user is in the configuration section for Attribute 3
    When the user sets Attribute 3 to "<frequency_value>"
    Then Attribute 3 is updated successfully with the edge-case frequency value

    Examples:
      | frequency_value       |
      | EDGE_CASE_FREQ_1      |
      | EDGE_CASE_FREQ_2      |

  @TC-172
  Scenario: User saves configuration changes
    Given the user has updated Attribute 3 with an edge-case frequency value
    When the user saves the configuration changes
    Then the changes are saved, and the system accepts the edge-case frequency value for testing purposes

  @TC-172
  Scenario: User executes the billing due program
    Given the user has set and saved Attribute 3 with an edge-case frequency value
    When the user executes the billing due program
    Then the billing due program starts execution

  @TC-172
  Scenario: User monitors program execution logs for error messages
    Given the billing due program is executing
    When the user monitors the program execution logs
    Then error messages are logged indicating edge-case frequency values

  @TC-172
  Scenario: User verifies no billing documents are generated
    Given the billing due program execution logs indicate error messages
    When the user verifies the outcome of the billing due program execution
    Then no billing documents are created due to the edge-case frequency value

  @TC-172
  Scenario: User checks the error message displayed
    Given the billing due program execution logs indicate error messages
    When the user checks the error message displayed
    Then the error message clearly states that the frequency value is unsupported

  @TC-172
  Scenario: User validates system maintains data integrity
    Given the system has rejected the edge-case frequency value
    When the user verifies data integrity
    Then the system rejects edge-case values without affecting other configurations or data

  @TC-172
  Scenario: User verifies compliance with business rules
    Given the system has rejected the edge-case frequency value
    When the user verifies compliance with business rules
    Then the system complies with business rules and prevents incorrect billing document generation

  @TC-172
  Scenario: User logs out of the SAP S/4HANA Cloud system
    Given the user has completed the validation of edge-case frequency values
    When the user logs out of the SAP S/4HANA Cloud system
    Then the user successfully logs out