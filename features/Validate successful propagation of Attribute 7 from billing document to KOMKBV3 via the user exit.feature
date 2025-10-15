Feature: Validate successful propagation of Attribute 7 from billing document to KOMKBV3 via the user exit

  @TC-494
  Scenario: User logs into the SAP S/4HANA system
    Given the user has valid credentials
    When the user logs into the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-494
  Scenario: User navigates to the billing document creation module
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the billing document creation module
    Then the billing document creation module is displayed

  @TC-494
  Scenario Outline: User creates and saves a billing document with Attribute 7
    Given the user is in the billing document creation module
    When the user creates a new billing document and populates Attribute 7 with the value "<attribute_value>"
    And the user saves the billing document
    Then the billing document is saved successfully

    Examples:
      | attribute_value |
      | ABC123          |

  @TC-494
  Scenario: User triggers the user exit during output determination
    Given the billing document with Attribute 7 is saved
    When the user triggers the user exit RVCOMFZZ:USEREXIT_KOMKBV3_FILL during the output determination process
    Then the user exit is triggered successfully during the output determination process

  @TC-494
  Scenario: User accesses the KOMKBV3 structure
    Given the user exit has been triggered
    When the user accesses the KOMKBV3 structure via debugging or relevant transaction
    Then the KOMKBV3 structure is accessible

  @TC-494
  Scenario Outline: Verify Attribute 7 in KOMKBV3 matches the billing document value
    Given the KOMKBV3 structure is accessible
    When the user verifies that Attribute 7 in KOMKBV3 matches the value "<attribute_value>" from the billing document
    Then Attribute 7 in KOMKBV3 matches the value "<attribute_value>"

    Examples:
      | attribute_value |
      | ABC123          |

  @TC-494
  Scenario: Validate no other attributes in KOMKBV3 are unintentionally modified
    Given the KOMKBV3 structure is accessible
    When the user validates that no other attributes in KOMKBV3 are unintentionally modified
    Then all other attributes remain unchanged

  @TC-494
  Scenario: Check system logs for errors or warnings
    Given the output determination process is completed
    When the user checks the system logs for any errors or warnings during the process
    Then no errors or warnings are logged

  @TC-494
  Scenario: Perform test output determination process to ensure Attribute 7 availability
    Given the billing document is processed
    When the user performs a test output determination process
    Then the output determination process completes successfully with Attribute 7 available

  @TC-494
  Scenario: Generate report to confirm Attribute 7 in output determination logs
    Given the output determination process is completed
    When the user generates a report to confirm the presence of Attribute 7 in the output determination logs
    Then the report confirms the presence of Attribute 7 in the logs

  @TC-494
  Scenario: Document results and close the test case
    Given the test case execution is complete
    When the user documents the results
    Then the test case is successfully closed