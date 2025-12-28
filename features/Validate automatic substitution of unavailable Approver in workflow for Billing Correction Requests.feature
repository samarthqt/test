Feature: Validate automatic substitution of unavailable Approver in workflow for Billing Correction Requests

  @TC-245
  Scenario: User logs in as an administrator with required permissions
    Given the user has administrator credentials with necessary permissions
    When the user logs in to the SAP system
    Then the user successfully logs in with required permissions

  @TC-245
  Scenario Outline: User marks a designated Approver as unavailable for a specific period
    Given the user navigates to the user management section
    When the user marks the designated Approver as unavailable for a specific period
    Then the Approver is successfully marked as unavailable in the system

    Examples:
      | Approver Status      |
      | Unavailable          |

  @TC-245
  Scenario Outline: User creates a Billing Correction Request with a designated Approver assigned
    Given the system has Billing Correction Request data "<RequestType>"
    When the user creates a Billing Correction Request with the designated Approver assigned
    Then the Billing Correction Request is successfully created and routed for workflow

    Examples:
      | RequestType |
      | ZRK         |

  @TC-245
  Scenario Outline: User submits the Billing Correction Request for workflow routing
    Given the Billing Correction Request "<RequestType>" is created
    When the user submits the Billing Correction Request for workflow routing
    Then the request is successfully submitted for workflow routing

    Examples:
      | RequestType |
      | ZRK         |

  @TC-245
  Scenario: System automatically assigns a substitute for the unavailable Approver
    Given the designated Approver is marked as unavailable
    When the user submits a Billing Correction Request for workflow routing
    Then the system identifies the unavailability of the Approver and assigns a substitute automatically

  @TC-245
  Scenario: User verifies the substitution process in the workflow log
    Given the system has routed the Billing Correction Request
    When the user checks the workflow log
    Then the workflow log reflects the substitution of the unavailable Approver with the assigned substitute

  @TC-245
  Scenario: Workflow progresses without interruption
    Given the system has assigned a substitute Approver
    When the user checks the workflow progression
    Then the workflow progresses seamlessly without any deadlocks or delays

  @TC-245
  Scenario: Approval sequence and levels are preserved in the workflow
    Given the system has substituted the unavailable Approver
    When the user verifies the approval sequence and levels
    Then the approval sequence and required levels are maintained as per the configuration

  @TC-245
  Scenario: Substitute Approver receives the workflow notification
    Given the system has assigned a substitute Approver
    When the user verifies the workflow notification
    Then the substitute Approver receives the notification for the assigned task

  @TC-245
  Scenario: Substitute Approver approves the request
    Given the substitute Approver has received the workflow notification
    When the user logs in as the substitute Approver and approves the request
    Then the substitute Approver successfully approves the request

  @TC-245
  Scenario: Workflow progresses to the next stage after approval
    Given the request has been approved by the substitute Approver
    When the user verifies the workflow progression
    Then the workflow progresses to the next stage as per the defined process

  @TC-245
  Scenario: System logs do not contain errors or warnings during substitution process
    Given the substitution process has been completed
    When the user checks the system logs
    Then no errors or warnings are logged during the substitution process