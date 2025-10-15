Feature: Verify system behavior when no substitute Approver is configured

  @TC-251
  Scenario Outline: Validate system response when no substitute Approver is configured
    Given the user logs in to the SAP system with administrative credentials
    And the user navigates to the workflow management module
    And the user searches for Billing Correction Request ID "<RequestID>"
    When the user marks the currently assigned Approver as unavailable
    Then the system updates the status of the Approver to unavailable
    And the system flags an error indicating "<ErrorMessage>"
    And the workflow halts and does not progress further
    And the administrator receives a notification about "<NotificationMessage>"
    And the workflow logs contain detailed information about "<LogDetails>"
    When the user attempts to manually assign a substitute Approver
    Then the system allows manual assignment of a substitute Approver
    And the workflow progresses to the next stage after manual assignment
    And an audit log is created with details of the manual assignment
    And the user logs out of the system

    Examples:
      | RequestID | ErrorMessage                          | NotificationMessage                 | LogDetails                               |
      | BCR005    | No substitute Approver is configured | Missing substitute Approver alert  | Missing substitute Approver information |

  @TC-251
  Scenario: Verify successful login and logout by the administrator
    Given the user logs in to the SAP system with administrative credentials
    Then the administrator successfully accesses the system
    When the user logs out of the system
    Then the administrator successfully logs out

  @TC-251
  Scenario: Verify workflow progression and audit log creation after manual assignment
    Given the user attempts to manually assign a substitute Approver
    Then the system allows manual assignment of a substitute Approver
    And the workflow progresses to the next stage after manual assignment
    And an audit log is created with details of the manual assignment