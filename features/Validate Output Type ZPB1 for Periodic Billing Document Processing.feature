Feature: Validate Output Type ZPB1 for Periodic Billing Document Processing

  @TC-414
  Scenario: User logs into the SAP S/4HANA Cloud system with valid credentials
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-414
  Scenario: User navigates to the periodic billing document processing transaction
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the periodic billing document processing transaction
    Then the periodic billing document processing screen is displayed

  @TC-414
  Scenario Outline: User searches for a ZFR document ID
    Given the user is on the periodic billing document processing screen
    When the user searches for the ZFR document ID "<document_id>"
    Then the ZFR document is displayed in the search results

    Examples:
      | document_id  |
      | ZFR12345     |

  @TC-414
  Scenario: User selects the ZFR document for processing
    Given the ZFR document is displayed in the search results
    When the user selects the ZFR document for processing
    Then the ZFR document is selected successfully

  @TC-414
  Scenario: User triggers the output processing for the ZFR document
    Given the ZFR document is selected for processing
    When the user triggers the output processing for the ZFR document
    Then the system begins processing the output for the ZFR document

  @TC-414
  Scenario: System determines ZPB1 as the output type during processing
    Given the system is processing the output for the ZFR document
    When the system determines the output type
    Then the output type ZPB1 is determined successfully

  @TC-414
  Scenario: User checks the generated output for formatting and dispatch details
    Given the output type ZPB1 is determined successfully
    When the user checks the generated output
    Then the output is formatted correctly and includes all dispatch details

  @TC-414
  Scenario: Validate that the output is stored in the processing logs
    Given the output is generated successfully
    When the user validates the processing logs
    Then the output is available in the processing logs

  @TC-414
  Scenario: Verify that the output is associated with the correct periodic billing form template
    Given the output is generated successfully
    When the user verifies the form template associated with the output
    Then the output is based on the correct periodic billing form template

  @TC-414
  Scenario: Check the system logs for errors or warnings during output processing
    Given the output processing is completed
    When the user checks the system logs
    Then no errors or warnings are logged

  @TC-414
  Scenario: Validate that the output is ready for dispatch to the customer
    Given the output is generated successfully
    When the user validates the readiness of the output
    Then the output is ready and available for dispatch

  @TC-414
  Scenario: Confirm that the ZPB1 output enhances periodic billing communication
    Given the output is ready for dispatch
    When the user evaluates the ZPB1 output
    Then the ZPB1 output ensures accurate and timely communication with the customer