Feature: Verify system behavior when ZPB1 output type is missing during periodic billing workflow

  @TC-143
  Scenario Outline: Validate system behavior with missing or incorrect ZPB1 output type configuration
    Given user logs into the SAP S/4HANA Cloud system using "<user_id>" and "<password>"
    And user navigates to the periodic billing section
    When user creates a billing document of type "<billing_document_type>"
    And user triggers the periodic billing workflow for the created document with output type configuration "<output_type_configuration>"
    And user attempts to generate ZPB1 output for the billing document
    Then system displays "<error_message>"
    And periodic billing workflow "<workflow_status>"
    And system logs contain "<log_details>"
    And no ZPB1 output is generated for the billing document

    Examples:
      | user_id     | password   | billing_document_type | output_type_configuration | error_message                                       | workflow_status     | log_details                                   |
      | test_user   | ********   | ZFR                   | Missing                   | Error indicating absence of ZPB1 output type       | halts at generation | Detailed error about missing output type      |
      | test_user   | ********   | ZFR                   | Incorrectly Configured    | Error indicating misconfiguration of ZPB1 output  | halts at generation | Detailed error about incorrect configuration  |

  @TC-143
  Scenario: Capture screenshots of system error messages for documentation
    Given user has triggered the periodic billing workflow with missing ZPB1 output type
    When user observes the displayed error messages
    Then user captures screenshots of the error messages successfully

  @TC-143
  Scenario: Attempt to manually configure ZPB1 output type and re-trigger workflow
    Given user manually configures the ZPB1 output type correctly
    When user re-triggers the periodic billing workflow
    Then system allows re-triggering of the workflow
    And workflow completes successfully with ZPB1 output generation