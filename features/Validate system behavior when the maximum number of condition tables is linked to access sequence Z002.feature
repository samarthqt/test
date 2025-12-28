Feature: Validate system behavior when the maximum number of condition tables is linked to access sequence Z002

  @TC-300
  Scenario Outline: User validates the system behavior for linking maximum condition tables to access sequence Z002
    Given user logs into the SAP system using "<credentials>"
    And user navigates to transaction V/07 for maintaining access sequences
    When user selects access sequence Z002 for editing
    And user adds "<number_of_condition_tables>" condition tables to the access sequence
    And user defines the sequence order and field mappings for all tables
    And user saves and activates the updated access sequence Z002
    Then the access sequence should be activated "<activation_status>"
    And user creates a test billing document that will utilize access sequence Z002
    When user triggers output determination for the test billing document
    Then the output determination process should be executed "<output_status>"
    And the correct condition table should be referenced based on the defined sequence "<reference_status>"
    And system performance during the determination process should remain "<performance_status>"
    And no functionality issues should be observed during the process "<functionality_status>"
    And the system should handle the maximum configuration "<handling_status>"

    Examples:
      | credentials    | number_of_condition_tables | activation_status         | output_status         | reference_status         | performance_status         | functionality_status         | handling_status         |
      | valid          | maximum                    | activated successfully    | executed successfully | referenced correctly     | stable and acceptable      | no issues observed           | successfully handled    |
      | invalid        | maximum                    | activation failed         | execution failed       | not referenced correctly | degraded performance       | issues observed              | failed to handle        |
      | blank          | maximum                    | activation failed         | execution failed       | not referenced correctly | degraded performance       | issues observed              | failed to handle        |
      | valid          | exceeding maximum          | activation failed         | execution failed       | not referenced correctly | degraded performance       | issues observed              | failed to handle        |
      | valid          | less than maximum          | activated successfully    | executed successfully | referenced correctly     | stable and acceptable      | no issues observed           | successfully handled    |