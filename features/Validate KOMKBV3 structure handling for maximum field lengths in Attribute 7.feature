Feature: Validate KOMKBV3 structure handling for maximum field lengths in Attribute 7

  Ensure the system correctly propagates Attribute 7 to KOMKBV3 when the field is populated with maximum allowable characters. User exit RVCOMFZZ:USEREXIT_KOMKBV3_FILL is implemented and activated.

  @TC-496
  Scenario Outline: Validate Attribute 7 handling in KOMKBV3 structure for maximum field length
    Given the user logs into the SAP S/4HANA system with appropriate credentials
    And billing documents with Attribute 7 values at maximum allowable length exist in the system
    When the user navigates to the billing document creation module
    And the user creates a new billing document and populates Attribute 7 with "<attribute_7_value>"
    And the user saves the billing document
    And the user triggers the user exit RVCOMFZZ:USEREXIT_KOMKBV3_FILL during the output determination process
    And the user accesses the KOMKBV3 structure via debugging or relevant transaction
    Then Attribute 7 in KOMKBV3 matches "<attribute_7_value>"
    And the system logs contain no errors or warnings during the process
    And the output determination process completes successfully with Attribute 7 available
    And the generated report confirms the presence and correctness of Attribute 7 in the output determination logs

    Examples:
      | attribute_7_value                          |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ABCDEFGHIJ |

  @TC-496
  Scenario: Document and share test results
    Given the user has completed Attribute 7 validation in KOMKBV3
    When the user documents the results
    Then the test case is closed
    And the user shares the test results with the development and quality assurance teams