Feature: Validate system behavior for unauthorized user attempting Credit Memo Request creation

  @TC-475
  Scenario Outline: Validate access and actions for Credit Memo Request creation based on user authorization
    Given the user logs in to SAP Fiori with "<user_type>" credentials
    When the user navigates to the Credit Memo Request creation application
    Then the system "<access_result>" and "<action_result>"
    And the system "<additional_verification>"

    Examples:
      | user_type       | access_result                       | action_result                                         | additional_verification                              |
      | unauthorized    | denies access                      | displays an error message indicating insufficient authorization | records the unauthorized access attempt in the audit log |
      | authorized      | grants access                      | allows the user to create a Credit Memo Request      | triggers the workflow for the submitted request     |

  @TC-475
  Scenario Outline: Verify system behavior for submitted Credit Memo Request
    Given the user logs in to SAP Fiori with "<user_type>" credentials
    When the user "<action>" the submitted Credit Memo Request
    Then the system "<result>"

    Examples:
      | user_type       | action              | result                                          |
      | approver        | reviews            | displays the submitted request for review      |
      | approver        | approves           | updates the request status to approved         |
      | unauthorized    | attempts to view   | denies access to the approved request          |
      | unauthorized    | attempts to edit   | denies access to the approved request          |

  @TC-475
  Scenario Outline: Verify system workflow and notifications for Credit Memo Request
    Given the user submits a Credit Memo Request as "<user_type>"
    When the system processes the request
    Then the request "<workflow_stage>"
    And the system "<notification_result>"

    Examples:
      | user_type       | workflow_stage                      | notification_result                                    |
      | authorized      | proceeds to the next stage          | notifies the administrator about unauthorized access attempts |
      | unauthorized    | does not proceed                   | maintains system integrity and detects no unauthorized changes |