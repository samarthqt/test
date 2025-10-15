Feature: Validate system behavior when ZPB1 output determination fails during ZFR processing

  @TC-122
  Scenario Outline: Verify system behavior during ZPB1 output determination failure in ZFR processing
    Given the user is logged into the SAP S/4HANA system with authorized credentials
    And the user navigates to the periodic billing document processing transaction (VF31)
    When the user enters the ZFR document number "<ZFR Document Number>" in the appropriate field
    And the user selects the ZFR document for processing
    And the user triggers the output processing for the ZFR document
    Then the system displays an error message indicating that ZPB1 output determination has failed
    And the error logs provide detailed information about the cause of the ZPB1 output determination failure
    And the ZFR document status indicates that it is unprocessed for output
    And the system generates error codes corresponding to the misconfiguration or disabled ZPB1 output determination settings
    When the user documents the error message and logs for further analysis
    Then the user logs out of the SAP S/4HANA system
    And the user communicates the issue to the configuration team for resolution

    Examples:
      | ZFR Document Number |
      | ZFR12345            |