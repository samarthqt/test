Feature: Validate error handling for unsupported frequency values in Attribute 3

  @TC-171
  Scenario Outline: Validate system behavior for different frequency values in Attribute 3
    Given the user logs in to the SAP S/4HANA Cloud system with valid credentials
    And the user navigates to the billing due program using transaction code "<Transaction Code>"
    And the user locates the configuration section for Attribute 3
    When the user sets Attribute 3 to "<Frequency Value>"
    Then the system "<System Behavior>"
    And the user attempts to save the configuration changes
    Then the system "<Save Behavior>"
    And no billing documents are generated if the frequency value is invalid
    And the error logs "<Error Log Behavior>"
    And the system "<Error Handling Behavior>"
    And the system complies with business rules regarding frequency validation

    Examples:
      | Transaction Code | Frequency Value | System Behavior                                  | Save Behavior                               | Error Log Behavior                          | Error Handling Behavior                   |
      | BDP001           | INVALID_FREQ    | rejects the invalid frequency value             | prevents saving changes and displays error | accurately captures the invalid frequency  | handles errors gracefully and maintains data integrity |
      | BDP001           | VALID_FREQ      | accepts the valid frequency value               | allows saving changes                      | does not log any errors                    | maintains data integrity                  |

  @TC-171
  Scenario: Validate reconfiguration with a valid frequency value
    Given the user logs in to the SAP S/4HANA Cloud system with valid credentials
    And the user navigates to the billing due program using transaction code "BDP001"
    And the user locates the configuration section for Attribute 3
    When the user sets Attribute 3 to a valid frequency value
    Then the system accepts the valid frequency value
    And the user saves the configuration changes successfully
    And the system allows the generation of billing documents