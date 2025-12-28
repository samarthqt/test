Feature: Validate system behavior with maximum field lengths in ZPB1 template  
  Ensure the system handles maximum field lengths in the ZPB1 template without truncation or errors during periodic billing.

  @TC-132
  Scenario: User logs into the SAP system
    Given the user has appropriate credentials
    When the user logs into the SAP system
    Then the user is successfully logged in and redirected to the main dashboard

  @TC-132
  Scenario: Validate billing document type configuration
    Given the billing document type "ZPB" is configured in the system
    Then the billing document type "ZPB" is available for selection

  @TC-132
  Scenario: Navigate to periodic billing document creation module
    When the user navigates to the periodic billing document creation module
    Then the periodic billing document creation module is displayed

  @TC-132
  Scenario: Validate form template configuration
    Given the form template "ZPB1" is configured with maximum field lengths
    Then the form template "ZPB1" is available for use

  @TC-132
  Scenario: Select document type ZPB for creation
    When the user selects the document type "ZPB" for creation
    Then the document type "ZPB" is selected without errors

  @TC-132
  Scenario: Generate periodic billing document using ZPB1 template
    When the user attempts to generate the periodic billing document using the "ZPB1" template
    Then the system generates the billing document using the "ZPB1" template without errors

  @TC-132
  Scenario: Validate system response to maximum field lengths
    Given the ZPB1 template contains maximum field lengths
    When the system processes the ZPB1 template
    Then the system handles the maximum field lengths without truncation or errors

  @TC-132
  Scenario: Verify data accuracy in the generated billing document
    When the user checks the generated billing document
    Then the generated billing document contains accurate data without truncation

  @TC-132
  Scenario: Validate formatting of the ZPB1 template in the generated document
    When the user observes the formatting of the ZPB1 template in the generated billing document
    Then the ZPB1 template is formatted correctly without misalignment

  @TC-132
  Scenario: Verify system logs for warnings or errors
    When the user reviews the system logs
    Then the system logs do not contain warnings or errors related to field lengths

  @TC-132
  Scenario: Print the generated billing document
    When the user attempts to print the generated billing document
    Then the billing document is printed successfully without formatting issues

  @TC-132
  Scenario: Validate system compliance with periodic billing standards
    When the user validates the system's compliance with periodic billing standards
    Then the system complies with periodic billing standards, ensuring no disruptions

  @TC-132
  Scenario: Verify correct usage of the ZPB1 template in the billing document
    When the user verifies the usage of the ZPB1 template in the billing document
    Then the ZPB1 template is used correctly without issues

  @TC-132
  Scenario: Ensure system handles edge cases for field lengths
    Given the ZPB1 template includes edge cases for field lengths
    When the system processes the ZPB1 template
    Then the system handles edge cases for field lengths without errors