Feature: Validate system behavior when CMO_ID or Site_ID is missing in the inbound file

  @TC-327
  Scenario Outline: Validate system behavior for missing mandatory fields in the inbound file
    Given the user uploads an inbound file with <MissingField> values into the SAP system
    When the user triggers the inbound interface processing manually
    Then the system logs errors specifying the missing <MissingField>
    And no sales orders are created due to the missing data
    And the user receives a notification for corrective action
    And the error messages are clear and actionable

    Examples:
      | MissingField |
      | CMO_ID       |
      | Site_ID      |

  @TC-327
  Scenario: Verify the system prevents processing of incomplete data
    Given the user uploads an inbound file with missing mandatory fields into the SAP system
    When the user triggers the inbound interface processing manually
    Then the system blocks incomplete data from being processed

  @TC-327
  Scenario: Validate reprocessing after correcting missing fields
    Given the user manually corrects the missing fields in the inbound file
    When the user reprocesses the corrected file
    Then the file is reprocessed successfully
    And sales orders are created successfully

  @TC-327
  Scenario: Verify compliance with data validation rules
    Given the user uploads an inbound file into the SAP system
    When the system validates the file
    Then the system adheres to the defined data validation rules

  @TC-327
  Scenario: Test system performance with multiple errors in a single file
    Given the user uploads an inbound file containing multiple errors into the SAP system
    When the user triggers the inbound interface processing manually
    Then the system handles multiple errors gracefully without crashing

  @TC-327
  Scenario: Validate audit trail for failed processing attempts
    Given the user uploads an inbound file with missing mandatory fields into the SAP system
    When the user triggers the inbound interface processing manually
    Then the audit trail captures all details of the failed attempt

  @TC-327
  Scenario: Validate system recovery from errors and processing corrected data
    Given the user manually corrects the errors in the inbound file
    When the user reprocesses the corrected file
    Then the system successfully recovers and processes the corrected data