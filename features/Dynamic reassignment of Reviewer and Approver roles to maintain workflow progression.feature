Feature: Dynamic reassignment of Reviewer and Approver roles to maintain workflow progression

  @TC-249
  Scenario: User logs in to the SAP system as an administrator
    Given the user has administrative access credentials
    When the user logs into the SAP system
    Then the user successfully accesses the system

  @TC-249
  Scenario: User navigates to the workflow management module
    Given the user is logged into the SAP system
    When the user navigates to the workflow management module
    Then the workflow management module is displayed with active workflows

  @TC-249
  Scenario: User searches for Billing Correction Request ID
    Given the user is in the workflow management module
    When the user searches for Billing Correction Request ID "BCR003"
    Then the Billing Correction Request details are displayed

  @TC-249
  Scenario Outline: System dynamically reassigns substitute Reviewer and Approver roles
    Given the Billing Correction Request ID "<RequestID>" with substitute Reviewer "<Reviewer>" and substitute Approver "<Approver>" is displayed
    When the user marks the substitute Reviewer "<Reviewer>" as unavailable
    Then the system updates the status of "<Reviewer>" to unavailable
    And the system automatically assigns a new substitute Reviewer
    And the updated workflow is displayed
    When the user marks the substitute Approver "<Approver>" as unavailable
    Then the system updates the status of "<Approver>" to unavailable
    And the system automatically assigns a new substitute Approver
    And the updated workflow is displayed

    Examples:
      | RequestID | Reviewer | Approver |
      | BCR003    | UserC    | UserD    |

  @TC-249
  Scenario: User checks the workflow logs for errors or reassignment details
    Given the user has marked the substitute Reviewer and Approver as unavailable
    When the user checks the workflow logs
    Then the workflow logs show successful reassignment without errors

  @TC-249
  Scenario: User confirms that the workflow progresses without interruption
    Given the user has verified the workflow logs
    When the user checks the workflow progression
    Then the workflow continues to the next step without delays

  @TC-249
  Scenario: User validates that the approval sequence remains intact
    Given the user is viewing the updated workflow
    When the user validates the approval sequence
    Then the approval sequence is preserved as per the workflow configuration

  @TC-249
  Scenario: User checks if the Billing Correction Request status updates correctly
    Given the user is viewing the workflow progression
    When the user checks the Billing Correction Request status
    Then the Billing Correction Request status reflects the current workflow stage

  @TC-249
  Scenario: User ensures that the system generates an audit log for the reassignments
    Given the user has verified the reassignment of Reviewer and Approver roles
    When the user checks the audit logs
    Then the system generates an audit log with details of both reassignments