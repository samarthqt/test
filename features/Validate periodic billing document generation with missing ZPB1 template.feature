Feature: Validate periodic billing document generation with missing ZPB1 template  
  Ensure the system logs appropriate error messages and halts the billing process when the ZPB1 template is missing or misconfigured.

  @TC-127
  Scenario: User logs into the SAP system with valid credentials
    Given the user has valid credentials
    When the user logs into the SAP system
    Then the user is successfully logged in and redirected to the main dashboard

  @TC-127
  Scenario: User navigates to the periodic billing document creation module
    Given the user is logged into the SAP system
    When the user navigates to the periodic billing document creation module
    Then the periodic billing document creation module is displayed

  @TC-127
  Scenario: User selects document type ZPB for creation
    Given the user is in the periodic billing document creation module
    When the user selects document type "ZPB" for creation
    Then the document type "ZPB" is selected without errors

  @TC-127
  Scenario Outline: System response to missing or incomplete ZPB1 form template
    Given the user has selected document type "ZPB"
    When the user attempts to generate the periodic billing document
    Then the system displays an error message indicating "<error_message>"
    And the system logs the error "<log_details>" in the system logs
    And the fallback mechanism is "<fallback_status>"
    And no incomplete billing document is saved in the system

    Examples:
      | error_message                          | log_details                           | fallback_status  |
      | Missing ZPB1 template                  | Missing template logged successfully  | triggered         |
      | Incomplete ZPB1 template configuration | Incomplete template logged successfully | triggered         |

  @TC-127
  Scenario: Reviewing the error message for clarity and actionable details
    Given the error message is displayed to the user
    When the user reviews the error message
    Then the error message provides clear and actionable details for resolution

  @TC-127
  Scenario: Reprocessing the billing document after correcting the template
    Given the user has corrected the ZPB1 form template
    When the user attempts to reprocess the billing document
    Then the system successfully processes the billing document
    And the corrected ZPB1 form template is used without issues

  @TC-127
  Scenario: Validating system compliance with periodic billing standards
    Given the system has processed the billing document
    When the user validates the periodic billing process
    Then the system complies with periodic billing standards, ensuring no disruptions